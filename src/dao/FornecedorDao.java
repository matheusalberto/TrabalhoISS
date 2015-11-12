package dao;

import model.Cliente;
import model.Fornecedor;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

}
