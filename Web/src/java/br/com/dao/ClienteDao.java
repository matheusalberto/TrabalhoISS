package br.com.dao;

import br.com.model.Cliente;
import br.com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

public class ClienteDao {

    private Session session;
    private Transaction transaction;
    
    public List<String> listar() {

        String hql = "select c.email from Cliente c where c.excluido = 0";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List lista = session.createQuery(hql)                
                .list();
        transaction.commit();
        return lista;
    }
    
    public String salvar(Cliente cliente) {
        String retorno = null;
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
            
            Cliente c = new Cliente();
            c.setNome(cliente.getNome());
            c.setCpf(cliente.getCpf());
            c.setEndereco(cliente.getEndereco());
            c.setEmail(cliente.getEmail());
            c.setTelefone(cliente.getTelefone());
            c.setSexo(cliente.getSexo());
            c.setExcluido(0);
            
            session.save(c);
            transaction.commit();
            retorno = "SUCESSO";
        } catch (ConstraintViolationException e) {
            retorno = "FALHA_CPF";
        } catch (Exception e) {
            retorno = "FALHA";
        } finally {
            session.close();
            return retorno;
        }
    }

}
