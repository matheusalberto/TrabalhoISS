package dao;

import java.util.List;
import org.hibernate.Session;
import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ProdutoDao {

    private Session session;
    private Transaction transaction;

    public String salvar(Produto produto) {
        String retorno = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(produto);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }

    public List<Produto> listar(String descricao) {

        String hql = "from Produto p where p.descricao like :descricao";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("descricao", "%" + descricao + "%")
                .list();
        transaction.commit();
        return lista;
    }

    public List<Produto> listarParaPedido(String descricao) {
        String hql = "from Produto p where p.descricao like :descricao and p.quantidadeEstoque > 0";
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("descricao", "%" + descricao + "%")
                .list();
        transaction.commit();
        return lista;
    }

    public List<Produto> listarParaManipulacao(String descricao) {
        String hql = "from Produto p where p.descricao like :descricao and p.quantidadeEstoque > 0 and p.unidade <> 'un'";
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("descricao", "%" + descricao + "%")
                .list();
        transaction.commit();
        return lista;
    }

    public String atualizar(Produto produto) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(produto);
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

    public String atualizarQuantidadeEstoque(int id) {
        String retorno = null;
        Produto produto = localizar(id);
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1);
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(produto);
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

    public String remover(Produto produto) {
        String retorno;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(produto);
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

    public Produto localizar(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Produto.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setMaxResults(1);
        Produto produto = (Produto) criteria.uniqueResult();
        session.close();
        return produto;
    }
}
