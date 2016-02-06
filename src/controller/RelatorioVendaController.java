
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.PedidoDao;
import dao.ProdutoDao;
import java.awt.Font;
import java.awt.Frame;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Funcionario;
import model.Pedido;
import model.Produto;
import util.DataSistema;
import view.RelatorioVenda;


public class RelatorioVendaController {

    public void geraRelatorioVenda(Frame tela, Date dataIni, Date dataFim) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Pedido> lista = new PedidoDao().listarRelatorioPedido(dataIni, dataFim);
        
        
        Document document = new Document();
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(tela, "Nao existe vendas nessa data", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
        else{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\relatorioVenda.pdf"));
                document.open();

                com.itextpdf.text.Font fonteNegrito1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,Font.BOLD,BaseColor.BLACK);

                Paragraph preface = new Paragraph("Relatorio de Venda de Produtos",fonteNegrito1);
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
                    
                for(Pedido prod : lista){
                    
                    
                    Paragraph id = new Paragraph("\nPedido: "+prod.getId(),fonteNegrito2);
                    id.setAlignment(Element.ALIGN_LEFT);// centraliza texto
                    document.add(id);
                    document.add(new Paragraph("Data do Pedido: "+prod.getDataPedido().toString()));
                    document.add(new Paragraph("Funcionario responsavel por venda: "+prod.getFuncionario().getNome()));
                    document.add(new Paragraph("Cliente: "+prod.getCliente().getNome()));   
                    document.add(new Paragraph("Valor da Venda: "+prod.getValorCompra()+" reais"));
                    
                    total+=prod.getValorCompra();
                   
                }
                
                Paragraph tot = new Paragraph("\nValor total das vendas: "+total+" reais",fonteNegrito2);
                tot.setAlignment(Element.ALIGN_RIGHT);// centraliza texto
                document.add(tot);
            
                document.close();
            
                JOptionPane.showMessageDialog(tela, "Documento gerado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
            }
            catch(DocumentException de){
                System.err.println(de.getMessage());

            }

            catch(IOException ioe){
                System.err.println(ioe.getMessage());

            }
            
        }
        
    }

    public void geraRelatorioVendaC(JFrame tela, int cli, Date dataIni, Date dataFim) {
    
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Pedido> lista = new PedidoDao().listarRelatorioPedido(dataIni, dataFim);
        
        
        Document document = new Document();
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(tela, "Nao existe vendas nessa data", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
        else{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\relatorioVendaCliente.pdf"));
                document.open();

                com.itextpdf.text.Font fonteNegrito1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,Font.BOLD,BaseColor.BLACK);

                Paragraph preface = new Paragraph("Relatorio de Venda de Produtos",fonteNegrito1);
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
                    
                for(Pedido prod : lista){
                    
                    if(prod.getCliente().getId() == cli){
                        Paragraph id = new Paragraph("\nPedido: "+prod.getId(),fonteNegrito2);
                        id.setAlignment(Element.ALIGN_LEFT);// centraliza texto
                        document.add(id);
                        document.add(new Paragraph("Data do Pedido: "+prod.getDataPedido().toString()));
                        document.add(new Paragraph("Funcionario responsavel por venda: "+prod.getFuncionario().getNome()));
                        document.add(new Paragraph("Cliente: "+prod.getCliente().getNome()));   
                        document.add(new Paragraph("Valor da Venda: "+prod.getValorCompra()+" reais"));

                        total+=prod.getValorCompra();
                    }
                   
                }
                
                Paragraph tot = new Paragraph("\nValor total das vendas: "+total+" reais",fonteNegrito2);
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

    public void geraRelatorioVendaF(JFrame tela, int func, Date dataIni, Date dataFim) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        List<Pedido> lista = new PedidoDao().listarRelatorioPedido(dataIni, dataFim);
        
        
        Document document = new Document();
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(tela, "Nao existe vendas nessa data", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
        else{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Public\\relatorioVendaFuncionario.pdf"));
                document.open();

                com.itextpdf.text.Font fonteNegrito1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20,Font.BOLD,BaseColor.BLACK);

                Paragraph preface = new Paragraph("Relatorio de Venda de Produtos",fonteNegrito1);
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
                    
                for(Pedido prod : lista){
                    
                    if(prod.getFuncionario().getId() == func){
                    Paragraph id = new Paragraph("\nPedido: "+prod.getId(),fonteNegrito2);
                    id.setAlignment(Element.ALIGN_LEFT);// centraliza texto
                    document.add(id);
                    document.add(new Paragraph("Data do Pedido: "+prod.getDataPedido().toString()));
                    document.add(new Paragraph("Funcionario responsavel por venda: "+prod.getFuncionario().getNome()));
                    document.add(new Paragraph("Cliente: "+prod.getCliente().getNome()));   
                    document.add(new Paragraph("Valor da Venda: "+prod.getValorCompra()+" reais"));
                    
                    total+=prod.getValorCompra();}
                   
                }
                
                Paragraph tot = new Paragraph("\nValor total das vendas: "+total+" reais",fonteNegrito2);
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
