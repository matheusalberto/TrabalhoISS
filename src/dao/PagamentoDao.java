/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Pagamento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Thiago
 */
public class PagamentoDao {
    
    private Session session;
    private Transaction transaction;
    
    public String salvar(Pagamento pagamento){
        
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        try{
            session.save(pagamento);
            transaction.commit();
            retorno =  "SUCESSO";
        } catch (Exception e){
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }
    
}
