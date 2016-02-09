/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PagamentoDao;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Pagamento;
import model.Pedido;
import model.Produto;
import util.PagamentoPdf;


/**
 *
 * @author Thiago
 */
public class PagamentoController {
    
    private final NumberFormat nf = new DecimalFormat("###,##0.00");

    public void preencherTabelaProdutos(JTable tabela, Object[] colunas, List<Produto> lista) {
        Object[][] dados = new Object[lista.size()][3]; //Preenche os objetos para popular a tabela
        int i = 0;
        for (Produto produto : lista) {
            dados[i] = produto.toArrayPagamento();
            i++;
        }

        DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(312);
    }

    public void pagamento(JFrame tela, String tipo, double valorCompra, Cliente cliente, Pedido pedido, Date dataPagamento, List<Produto> produtos) {
        
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setTipoPagamento(tipo);
        pagamento.setValorCompra(valorCompra);
        pagamento.setCliente(cliente);
        pagamento.setDataPagamento(dataPagamento);

        String salvar = new PagamentoDao().salvar(pagamento);
        System.out.println(salvar);
                     
        PagamentoPdf pagamentoPdf = new PagamentoPdf();
        pagamentoPdf.gerarPdf(produtos, pedido);

        switch (salvar) {
            case "SUCESSO":
                JOptionPane.showMessageDialog(tela, "Pagamento efetuado com sucesso", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                break;
        }

    }

    public String computarDesconto(JLabel txtTotal, JFormattedTextField txtDesconto) {
        String total = null;
        
        total = txtTotal.getText();
        
        double valorTotal = 0.00;
        double valorDesconto = 0.00;
        
        valorTotal = Double.parseDouble(total.replace(',','.'));
        
        valorDesconto = Double.parseDouble(txtDesconto.getText().replace(',','.'));
        
        if(valorDesconto < 0.00){
            JOptionPane.showMessageDialog(null, "Valor Inválido");
            return String.valueOf(valorTotal);
        }
        //total = (String.valueOf(valorTotal - valorDesconto).replace('.', ','));
        
        valorTotal = valorTotal - valorDesconto;
        
        valorTotal = valorTotal * 100;
        valorTotal = Math.round(valorTotal);
        valorTotal = valorTotal / 100;
        total = String.valueOf(nf.format(valorTotal));
        
        return total;
    }

}
