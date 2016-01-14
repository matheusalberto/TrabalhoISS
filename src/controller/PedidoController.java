package controller;

import dao.ProdutoDao;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.Produto;

public class PedidoController {

    public void cancelarPedido(List<Produto> listaCesta) {       
        for (Produto produto : listaCesta) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1);
            new ProdutoDao().atualizarQuantidadeEstoque(produto.getId());
        }
    }

    public void preencherTabelaCliente(JTable tabela, TableModel tableModel, Object[] colunas, List<Cliente> lista) {
        Object[][] dados = new Object[lista.size()][2]; //Preenche os objetos para popular a tabela
        int i = 0;
        for (Cliente cliente : lista) {
            dados[i] = cliente.toArrayIdNome();
            i++;
        }
        
        tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(312);
    }

    public void preencherTabelaProdutos(JTable tabela, TableModel tableModel, Object[] colunas, List<Produto> lista) {
        Object[][] dados = new Object[lista.size()][3]; //Preenche os objetos para popular a tabela 
        int i = 0;
        for (Produto p : lista) {
            dados[i] = p.toArrayCompra();
            i++;
        }
        
        tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(270);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
    }
}
