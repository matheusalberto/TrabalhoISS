/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import model.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Bia
 */
public class RelatorioController {
    
    private Session session;
    private Transaction transaction;
    
    public void geraRelatorio(Date dataIni, Date dataFim) {

      
        String hql = "from Produto p where p.dataCompra >= :dataIni and p.dataCompra <= :dataFim";

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        List<Produto> lista = session.createQuery(hql)
                .setParameter("dataIni", dataIni)
                .setParameter("dataFim", dataFim )
                .list();
        transaction.commit();
        
        Document document = new Document();
        try{
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\teste.pdf"));
            document.open();
           
            for(Produto prod : lista){
                System.out.println(prod.getDescricao());
                document.add(new Paragraph(prod.getDescricao()));
                
                
            }
        }
        catch(DocumentException de){
            System.err.println(de.getMessage());
            
        }
        
        catch(IOException ioe){
            System.err.println(ioe.getMessage());
            
        }
        document.close();
    }
    
}
