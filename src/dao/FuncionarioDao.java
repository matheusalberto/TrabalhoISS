package dao;

import java.util.List;
import model.Funcionario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
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

            //Funcionario f = new Funcionario();
            //f.setLogin(funcionario.getLogin());
            //f.setSenha(senha);
            //f.setNome(senha);
            session.save(funcionario);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (ConstraintViolationException e) {
            retorno = "FALHA";
            throw new RuntimeException("Usuário já cadastrado, tente com outro!");
        } catch (Exception e) {
            e.printStackTrace();
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }
    
}
