package dao;

import java.util.List;
import model.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GerarCriptografiaSenha;
import util.HibernateUtil;

public class FuncionarioDao {

    private Session session;
    private Transaction transaction;

    public boolean consultar(Funcionario funcionario) {
        String hql = "from Funcionario u where u.login like :login"
                + " and u.senha like :senha";
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("login", funcionario.getLogin())
                .setParameter("senha", GerarCriptografiaSenha.criptografaSenha(funcionario.getSenha()))
                .list();
        transaction.commit();
        return !(lista.isEmpty());
    }

    public String salvar(Funcionario funcionario) {
        String retorno = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String senha = GerarCriptografiaSenha.criptografaSenha(funcionario.getSenha());

            funcionario.setSenha(senha);

            session.save(funcionario);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            retorno = "FALHA";
            throw new RuntimeException("Funcionário já cadastrado, tente com outro!");
        } finally {
            session.close();
            return retorno;
        }
    }

    public List<Funcionario> listar(String nome) {

        String hql = "from Funcionario p where p.nome like :nome";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)
                .setParameter("nome", "%" + nome + "%")
                .list();
        transaction.commit();
        return lista;
    }

    public String atualizar(Funcionario funcionario) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(funcionario);
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

    public String remover(Funcionario funcionario) {
        String retorno;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(funcionario);
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

    public Funcionario localizar(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Funcionario.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setMaxResults(1);
        Funcionario funcionario = (Funcionario) criteria.uniqueResult();
        session.close();
        return funcionario;
    }

    public Funcionario localizar(String login) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Funcionario.class);
        criteria.add(Restrictions.eq("login", login));
        criteria.setMaxResults(1);
        Funcionario funcionario = (Funcionario) criteria.uniqueResult();
        session.close();
        return funcionario;
    }

}
