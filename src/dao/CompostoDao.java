package dao;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Composto;
import org.hibernate.Session;
import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class CompostoDao {

    private Session session;
    private Transaction transaction;

    public String salvar(Composto composto) {
        String retorno = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(composto);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }

    public List<Composto> listarParaManipulacao(String descricao) {
        String hql = "from Composto c where c.descricao like :descricao and c.quantidadeEstoque > 0 and c.excluido = 0";
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("descricao", "%" + descricao + "%")
                .list();
        transaction.commit();
        return lista;
    }

    public String atualizar(Composto composto) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(composto);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            e.printStackTrace();
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }
    
    public String atualizarQuantidadeEstoqueManip(int id, double quantidade) {
        
        String retorno = null;
        Composto composto = localizar(id);
        composto.setQuantidadeEstoque(quantidade);
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(composto);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            e.printStackTrace();
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }

    public String remover(Composto composto,JFrame tela) {
        
        String retorno;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(composto);
            transaction.commit();
            retorno = "SUCESSO";
            JOptionPane.showMessageDialog(tela, ("DELETEI" + retorno), "AQUI", JOptionPane.DEFAULT_OPTION);
           
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            retorno = "FALHA";
        }
        return retorno;
    }

    public Composto localizar(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Composto.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setMaxResults(1);
        Composto composto = (Composto) criteria.uniqueResult();
        session.close();
        return composto;
    }
    
    
}
