package dao;

import java.util.List;
import model.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;

public class ClienteDao {

    private Session session;
    private Transaction transaction;

    public String salvar(Cliente cliente) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(cliente);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (ConstraintViolationException e) {
            retorno = "FALHA_CPF";
        } catch(Exception e){
            retorno = "FALHA";
        }finally {
            session.close();
            return retorno;
        }
    }

    public List<Cliente> listar(String nome) {

        String hql = "from Cliente p where p.nome like :nome";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("nome", "%" + nome + "%")
                .list();
        transaction.commit();
        return lista;
    }

    public String atualizar(Cliente cliente) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(cliente);
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

    public String remover(Cliente cliente) {
        String retorno;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(cliente);
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

    public Cliente localizar(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setMaxResults(1);
        Cliente cliente = (Cliente) criteria.uniqueResult();
        session.close();
        return cliente;
    }

    public String localizarCPF(String cpf) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("cpf", cpf));
        criteria.setMaxResults(1);
        Cliente cliente = (Cliente) criteria.uniqueResult();
        session.close();
        return cliente.getCpf();
    }

}
