package controller;

import dao.PedidoDao;
import dao.ProdutoDao;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.Funcionario;
import model.Pedido;
import model.Produto;
import view.RealizarPagamento;

public class PedidoController {

    private final NumberFormat nf = new DecimalFormat("###,##0.00");

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

    public double adicionarProdutoCesta(int linhaSelecionada, JTable tabelaProdutos, double total, JLabel txtTotal, List<Produto> listaCesta) {
        int id = (int) tabelaProdutos.getValueAt(linhaSelecionada, 0);

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.localizar(id);
        if(produto == null){
            return -1;
        }
        if(produto.getPrecoVenda() < 0){
            return -2;  
        }
        total = Double.sum(total, produto.getPrecoVenda());
        total = total * 100;
        total = Math.round(total);
        total = total / 100;
        txtTotal.setText(nf.format(total));

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1); //Diminui a quantidade no estoque
        produtoDao.atualizar(produto); //Atualiza estoque

        if (produto.getQuantidadeEstoque() <= 0) { //Se o estoque de determinado produto ficar com 0, retira ele da lista
            ((DefaultTableModel) tabelaProdutos.getModel()).removeRow(linhaSelecionada);
        }

        listaCesta.add(produto);
        return total;
    }

    public double removerProdutoCesta(int linhaSelecionada, JTable tabelaCesta, double total, JLabel txtTotal, List<Produto> listaCesta) {
        int id = (int) tabelaCesta.getValueAt(linhaSelecionada, 0);

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.localizar(id);
        total = total - produto.getPrecoVenda();
        total = total * 100;
        total = Math.round(total);
        total = total / 100;
        txtTotal.setText(nf.format(total));

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + 1); //Aumentando a quantidade no estoque
        produtoDao.atualizar(produto); //Atualiza estoque

        listaCesta.remove(linhaSelecionada);
        ((DefaultTableModel) tabelaCesta.getModel()).removeRow(linhaSelecionada); //Remove linha 
        return total;
    }

    public void desabilitarNaoCliente(JLabel labelCod, JLabel labelCliente, JLabel txtNaoCliente) {
        labelCod.setVisible(true);
        labelCliente.setVisible(true);
        txtNaoCliente.setVisible(false);
    }

    public void habilitarNaoCliente(JLabel labelCod, JLabel labelCliente, JLabel txtNaoCliente) {
        labelCod.setVisible(false);
        labelCliente.setVisible(false);
        txtNaoCliente.setVisible(true);
    }

    public void finalizarPedido(JFrame tela, Cliente cliente, Funcionario funcionario, List<Produto> listaCesta, double total) {
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFuncionario(funcionario);
        pedido.setProdutos(listaCesta);
        pedido.setValorCompra(total);
        pedido.setDataPedido(new Date());

        int opcao = JOptionPane.showConfirmDialog(tela, "Deseja realizar o seguinte pedido para " + cliente.getNome() + "?", "Confirmação", JOptionPane.YES_OPTION);
        if (JOptionPane.YES_OPTION == opcao) {
            String salvar = new PedidoDao().salvar(pedido);
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

        RealizarPagamento realizarPagamento = new RealizarPagamento(pedido, listaCesta);
        realizarPagamento.setVisible(true);
    }

}
