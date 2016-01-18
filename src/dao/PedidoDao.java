package dao;

import model.Pedido;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PedidoDao {

    private Session session;
    private Transaction transaction;
    
    public String salvar(Pedido pedido) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(pedido);
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
