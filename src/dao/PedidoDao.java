package dao;

import java.util.Date;
import java.util.List;
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
    
    public List<Pedido> listarRelatorioPedido(Date dataIni, Date dataFim) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String hql = "from Pedido p where p.dataPedido >= :dataIni and p.dataPedido <= :dataFim";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List<Pedido> lista = session.createQuery(hql)
                .setParameter("dataIni", dataIni)
                .setParameter("dataFim", dataFim )
                .list();
        transaction.commit();
        return lista;
    }

}
