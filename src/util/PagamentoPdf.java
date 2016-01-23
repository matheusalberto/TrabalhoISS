/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.DateFormat;
import java.text.Format;
import java.util.List;
import java.util.Locale;
import model.Pedido;
import model.Produto;

public class PagamentoPdf {

    public void gerarPdf(List<Produto> produtos, Pedido pedido) {

        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("pagamento"+pedido.getId()+".pdf"));

            documento.open();

            documento.addTitle("Farmácia de Manipulação");
            documento.add(new Paragraph("Pedido nº: " + pedido.getId()));
            documento.add(new Paragraph());
            for (Produto produto : produtos) {
                documento.add(new Paragraph("Id: " + produto.getId() +" || "+ "   Descrição: " + produto.getDescricao()+" || " + "   Preço: " + produto.getPrecoVenda()));
                documento.add(new Paragraph(" "));
            }
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            Locale brasil = new Locale("pt","BR");
            Format f1 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
            documento.add(new Paragraph("Data compra: " + f1.format(pedido.getDataPedido())));

        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }

        documento.close();
    }

}
