package dao;

import java.util.List;
import model.Cliente;
import model.Fornecedor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class FornecedorDao {

    private Session session;
    private Transaction transaction;

    public String salvar(Fornecedor fornecedor) {
        String retorno = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(fornecedor);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }
    
     public List<Fornecedor> listar(String nome) {

        String hql = "from Fornecedor f where f.nome like :nome and f.excluido = 0";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("nome", "%" + nome + "%")
                .list();
        transaction.commit();
        return lista;
    }    
    
    public String atualizar(Fornecedor fornecedor) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(fornecedor);
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
    
     public String remover(Fornecedor fornecedor) {
        String retorno;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(fornecedor);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            retorno = "FALHA";
        }
        return retorno;
    }
     
      public Fornecedor localizar(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Fornecedor.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setMaxResults(1);
        Fornecedor fornecedor = (Fornecedor) criteria.uniqueResult();
        session.close();
        return fornecedor;
    }

}
