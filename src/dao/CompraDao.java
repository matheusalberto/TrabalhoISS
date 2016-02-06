
package dao;

import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Compra;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;


public class CompraDao {
    
    private Session session;
    private Transaction transaction;

    public String salvar(Compra compra) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.save(compra);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (Exception e) {
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    
    }

    public Object atualizar(Compra compra) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.update(compra);
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
    
     public List<Compra> listar(Date data) {

      
        String hql = "from Compra p where p.dataCompra <= :data";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List<Compra> lista = session.createQuery(hql)
                .setParameter("data", data)
                .list();
        transaction.commit();
        
        return lista;  
     }
     
     public List<Compra> listarRelatorioCompra(Date dataIni, Date dataFim) {

        String hql = "from Compra p where p.dataCompra >= :dataIni and p.dataCompra <= :dataFim";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List<Compra> lista = session.createQuery(hql)
                .setParameter("dataIni", dataIni)
                .setParameter("dataFim", dataFim )
                .list();
        transaction.commit();
        return lista;
     }
     
     public List<Compra> listarRelatorioNaoPagto(Date dataIni, Date dataFim) {

        String hql = "from Compra c where c.dataCompra >= :dataIni and c.dataCompra <= :dataFim  and c.pagto like 'N'";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List<Compra> lista = session.createQuery(hql)
                .setParameter("dataIni", dataIni)
                .setParameter("dataFim", dataFim )
                .list();
        transaction.commit();
        return lista;
    }
     
     public List<Compra> listarRelatorioNaoEntregue(Date dataIni, Date dataFim) {

        String hql = "from Compra c where c.dataEntrega >= :dataIni and c.dataEntrega <= :dataFim";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List<Compra> lista = session.createQuery(hql)
                .setParameter("dataIni", dataIni)
                .setParameter("dataFim", dataFim )
                .list();
        transaction.commit();
        return lista;
    }
    
     

    public Compra localizar(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compra.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.setMaxResults(1);
        Compra compra = (Compra) criteria.uniqueResult();
        session.close();
        return compra;
    }

    public Object remover(Compra compra) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String retorno;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(compra);
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
    
}    
