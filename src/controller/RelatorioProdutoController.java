/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ProdutoDao;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DataSistema;
import util.HibernateUtil;


public class RelatorioProdutoController {
    

    
    public void geraRelatorioCompra(JFrame tela, Date dataIni, Date dataFim) {

      List<Produto> lista = new ProdutoDao().listarRelatorioCompra(dataIni, dataFim);
        
        
        Document document = new Document();
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(tela, "Nao existe entrada de produtos nessa data", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
        else{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\relatorioProdutoCompra.pdf"));
                document.open();

                com.itextpdf.text.Font fonteNegrito1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,Font.BOLD,BaseColor.BLACK);

                Paragraph preface = new Paragraph("Relatorio de Cadastro de Produtos",fonteNegrito1);
                preface.setAlignment(Element.ALIGN_CENTER);// centraliza texto
                document.add(preface);
                
               
                DataSistema dataAgora =  new DataSistema();
                document.add(new Paragraph("\nData e hora de criação de documento: "+dataAgora.getDateTime()));
                Locale brasil = new Locale("pt","BR");
                Format f1 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
                document.add(new Paragraph("Busca realizada de "+f1.format(dataIni)+" ate "+f1.format(dataFim)));
                
                
                com.itextpdf.text.Font fonteNegrito2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14,Font.BOLD,BaseColor.BLACK);
                Paragraph subtit = new Paragraph("\nResultados Encontrados",fonteNegrito2);
                subtit.setAlignment(Element.ALIGN_CENTER);// centraliza texto
                document.add(subtit);
                
                double total = 0;
                double aux = 0;
                    
                for(Produto prod : lista){
                    
                    Paragraph id = new Paragraph("\nProduto: "+prod.getId(),fonteNegrito2);
                    id.setAlignment(Element.ALIGN_LEFT);// centraliza texto
                    document.add(id);
                    document.add(new Paragraph("Descricao: "+prod.getDescricao()));
                    document.add(new Paragraph("Fornecedor: "+prod.getFornecedor()));
                    document.add(new Paragraph("Quantidade em estoque: "+prod.getQuantidadeEstoque()));
                    document.add(new Paragraph("Data de Compra: "+prod.getDataCompra().toString()));
                    document.add(new Paragraph("Data de Validade: "+prod.getDataValidade().toString()));
                    document.add(new Paragraph("Preco de Compra: "+prod.getPrecoCompra()+" reais"));
                    document.add(new Paragraph("Preco de Venda: "+prod.getPrecoVenda()+" reais"));
                    
                    aux = prod.getPrecoCompra()*prod.getQuantidadeEstoque();
                    total+=aux;
                   
                }
                
                Paragraph tot = new Paragraph("\nValor total da compra: "+total+" reais",fonteNegrito2);
                tot.setAlignment(Element.ALIGN_RIGHT);// centraliza texto
                document.add(tot);
            }
            catch(DocumentException de){
                System.err.println(de.getMessage());

            }

            catch(IOException ioe){
                System.err.println(ioe.getMessage());

            }
            document.close();
            
            JOptionPane.showMessageDialog(tela, "Documento gerado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
            tela.dispose();
        }
    }
    
    public void geraRelatorioVencimento(JFrame tela, Date dataIni, Date dataFim) {

       List<Produto> lista = new ProdutoDao().listarRelatorioVencimento(dataIni, dataFim);
        
        
        Document document = new Document();
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(tela, "Nao existem Produtos que vencem nessa data", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
        else{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\relatorioProdutoValidade.pdf"));
                document.open();

                com.itextpdf.text.Font fonteNegrito1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,Font.BOLD,BaseColor.BLACK);

                Paragraph preface = new Paragraph("Relatorio de Vencimento de Produtos",fonteNegrito1);
                preface.setAlignment(Element.ALIGN_CENTER);// centraliza texto
                document.add(preface);
                
               
                DataSistema dataAgora =  new DataSistema();
                document.add(new Paragraph("\nData e hora de criação de documento: "+dataAgora.getDateTime()));
                Locale brasil = new Locale("pt","BR");
                Format f1 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
                document.add(new Paragraph("Busca realizada de "+f1.format(dataIni)+" ate "+f1.format(dataFim)));
                
                
                com.itextpdf.text.Font fonteNegrito2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14,Font.BOLD,BaseColor.BLACK);
                Paragraph subtit = new Paragraph("\nResultados Encontrados",fonteNegrito2);
                subtit.setAlignment(Element.ALIGN_CENTER);// centraliza texto
                document.add(subtit);
                
                double total = 0;
                double aux = 0;
                    
                for(Produto prod : lista){
                    
                    Paragraph id = new Paragraph("\nProduto: "+prod.getId(),fonteNegrito2);
                    id.setAlignment(Element.ALIGN_LEFT);// centraliza texto
                    document.add(id);
                    document.add(new Paragraph("Descricao: "+prod.getDescricao()));
                    document.add(new Paragraph("Fornecedor: "+prod.getFornecedor()));
                    document.add(new Paragraph("Quantidade em estoque: "+prod.getQuantidadeEstoque()));
                    document.add(new Paragraph("Data de Compra: "+prod.getDataCompra().toString()));
                    document.add(new Paragraph("Data de Validade: "+prod.getDataValidade().toString()));
                    document.add(new Paragraph("Preco de Compra: "+prod.getPrecoCompra()+" reais"));
                    document.add(new Paragraph("Preco de Venda: "+prod.getPrecoVenda()+" reais"));
                    
                    aux = prod.getPrecoCompra()*prod.getQuantidadeEstoque();
                    total+=aux;
                   
                }
                
                Paragraph tot = new Paragraph("\nValor total de mercadorias que serao perdidas: "+total+" reais",fonteNegrito2);
                tot.setAlignment(Element.ALIGN_RIGHT);// centraliza texto
                document.add(tot);
            }
            catch(DocumentException de){
                System.err.println(de.getMessage());

            }

            catch(IOException ioe){
                System.err.println(ioe.getMessage());

            }
            document.close();
            JOptionPane.showMessageDialog(tela, "Documento gerado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
            tela.dispose();
        }
    }    

    
}
