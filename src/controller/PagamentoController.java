/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PagamentoDao;
import dao.PedidoDao;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Pagamento;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Thiago
 */
public class PagamentoController {

    public void preencherTabelaProdutos(JTable tabela, Object[] colunas, List<Produto> lista) {
        Object[][] dados = new Object[lista.size()][3]; //Preenche os objetos para popular a tabela
        int i = 0;
        for (Produto produto : lista) {
            dados[i] = produto.toArray();
            i++;
        }

        DefaultTableModel tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(312);
    }

    public void pagamento(JFrame tela, String tipo, double valorCompra, Cliente cliente, Pedido pedido, Date dataPagamento) {
        
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setTipoPagamento(tipo);
        pagamento.setValorCompra(valorCompra);
        pagamento.setCliente(cliente);
        pagamento.setDataPagamento(dataPagamento);

        String salvar = new PagamentoDao().salvar(pagamento);

        switch (salvar) {
            case "SUCESSO":
                JOptionPane.showMessageDialog(tela, "Pedido feito com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                break;
        }

    }

}
