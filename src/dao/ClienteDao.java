package dao;

import model.Cliente;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ClienteDao {

    private Session session;
    private Transaction transaction;

    public String salvar(Cliente cliente) {
        String retorno = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(cliente);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }
}
