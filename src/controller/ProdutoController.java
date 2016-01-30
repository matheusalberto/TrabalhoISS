package controller;

import dao.FornecedorDao;
import dao.ProdutoDao;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Fornecedor;
import model.Produto;
import util.ValidarCNPJ;
import view.CadastrarProduto;

public class ProdutoController {

    private final NumberFormat nf = new DecimalFormat("###,##0.00");

    /*public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelD, JLabel labelE, JLabel labelF, JLabel labelG, JLabel labelH) {
     labelA.setVisible(false);
     labelB.setVisible(false);
     labelC.setVisible(false);
     labelD.setVisible(false);
     labelE.setVisible(false);
     labelF.setVisible(false);
     labelG.setVisible(false);
     labelH.setVisible(false);

     }

     public void habilitarErro(JLabel labelA, JLabel labelPrincipal) {
     labelA.setVisible(true);
     labelPrincipal.setVisible(true);
     }

     public void desabilitarErro(JLabel labelA) {
     labelA.setVisible(false);
     }*/
    public void preencheCampos(JTextField txtDescricao, JTextField txtDataCompra, JTextField txtDataValidade, JTextField txtQuantidade, JTextField txtPrecoCompra, JTextField txtPrecoVenda, Produto produto) throws ParseException {
        txtDescricao.setText(produto.getDescricao());

        String dia, mes, ano;
        GregorianCalendar calendarCompra = new GregorianCalendar();
        calendarCompra.setTime(produto.getDataCompra());
        dia = String.valueOf(calendarCompra.get(GregorianCalendar.DAY_OF_MONTH));
        mes = String.valueOf(calendarCompra.get(GregorianCalendar.MONTH));
        ano = String.valueOf(calendarCompra.get(GregorianCalendar.YEAR));
        txtDataCompra.setText(dia + "/" + mes + "/" + ano);

        calendarCompra.setTime(produto.getDataValidade());
        dia = String.valueOf(calendarCompra.get(GregorianCalendar.DAY_OF_MONTH));
        mes = String.valueOf(calendarCompra.get(GregorianCalendar.MONTH));
        ano = String.valueOf(calendarCompra.get(GregorianCalendar.YEAR));
        txtDataValidade.setText(dia + "/" + mes + "/" + ano);

        txtQuantidade.setText(String.valueOf(produto.getQuantidadeEstoque()));
        txtPrecoCompra.setText(String.valueOf(produto.getPrecoCompra()));
        txtPrecoVenda.setText(String.valueOf(produto.getPrecoVenda()));

    }

    public Produto preencheProduto(int id, String descricao, String fornecedor, String dataCompra, String dataValidade, String quantidade, String precoCompra, String precoVenda) {

        Date dataCorreta1 = null;
        Date dataCorreta2 = null;

        try {
            Calendar d = Calendar.getInstance();
            DateFormat f = DateFormat.getDateInstance();
            String data1, data2;
            data1 = dataCompra;
            data2 = dataValidade;

            dataCorreta1 = f.parse(data1);
            dataCorreta2 = f.parse(data2);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        Produto produto = new Produto();
        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setFornecedor(fornecedor);
        produto.setDataCompra(dataCorreta1);
        produto.setDataValidade(dataCorreta2);
        produto.setQuantidadeEstoque(Double.parseDouble(quantidade));
        produto.setPrecoCompra(Double.parseDouble(precoCompra));
        produto.setPrecoVenda(Double.parseDouble(precoVenda));

        return produto;
    }

    public void preencherTabela(List<Produto> lista, TableModel tableModelProduto, JTable tabelaProdutos) {
        Object[][] dados = new Object[lista.size()][4];
        int i = 0;
        for (Produto c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Descricao", "Quantidade", "Preco Venda"};
        tableModelProduto = new DefaultTableModel(dados, colunas);
        tabelaProdutos.setModel(tableModelProduto);
    }

    public void preencherComboBoFornecedor(JComboBox cbFornecedor) {
        //LISTANDO NO COMBO BOX

        List<Fornecedor> list = new FornecedorDao().listar(""); //PEGO TODOS OS FORNECEDORES CADASTRADOS
        List<String> nomes = new ArrayList<>();
        for (Fornecedor list1 : list) {
            nomes.add(list1.getNome()); //PEGO APENAS OS NOMES DOS FORNECEDORES
        }
        for (String nome : nomes) {
            cbFornecedor.addItem(nome.toString()); //ADICIONO ELES NO COMBO BOX

        }
    }

    public void preencherComboBoFornecedorEditar(JComboBox cbFornecedor, Produto produto) {
        //LISTANDO NO COMBO BOX

        List<Fornecedor> list = new FornecedorDao().listar(""); //PEGO TODOS OS FORNECEDORES CADASTRADOS
        List<String> nomes = new ArrayList<>();
        for (Fornecedor list1 : list) {
            nomes.add(list1.getNome()); //PEGO APENAS OS NOMES DOS FORNECEDORES
        }
        for (String nome : nomes) {
            cbFornecedor.addItem(nome.toString()); //ADICIONO ELES NO COMBO BOX

        }
        cbFornecedor.setSelectedItem(produto.getFornecedor());
    }

    public void cadastrarProduto(JFrame tela, JTextField txtDescricao, JComboBox cbFornecedor, JTextField txtDataCompra, JTextField txtDataValidade, JTextField txtQuantidade, JTextField txtPrecoCompra, JTextField txtPrecoVenda, JComboBox cbUnidade, JComboBox cbUnidadeVenda) {
        if (txtDescricao.getText().trim().isEmpty() || cbFornecedor.getSelectedItem().toString().trim().isEmpty() || txtDataCompra.getText().equals("  /  /    ") || txtDataValidade.getText().equals("  /  /    ") || txtQuantidade.getText().trim().isEmpty() || txtPrecoCompra.getText().trim().isEmpty() || txtPrecoVenda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Favor preencher todos os itens obrigatórios", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        } else {
            Produto produto = new Produto();
            produto.setDescricao(txtDescricao.getText());
            produto.setFornecedor(cbFornecedor.getSelectedItem().toString());

            //formatando a data de compra
            Calendar d1 = Calendar.getInstance();
            DateFormat f1 = DateFormat.getDateInstance();
            String dataCompra;
            dataCompra = txtDataCompra.getText();
            Date dataCorretaCompra = null;
            try {
                dataCorretaCompra = f1.parse(dataCompra);
            } catch (ParseException ex) {
                Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            produto.setDataCompra(dataCorretaCompra);

            //formatando a data de validade
            Calendar d2 = Calendar.getInstance();
            DateFormat f2 = DateFormat.getDateInstance();
            String dataValidade;
            dataValidade = txtDataValidade.getText();
            Date dataCorretaValidade = null;
            try {
                dataCorretaValidade = f2.parse(dataValidade);
            } catch (ParseException ex) {
                Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            produto.setDataValidade(dataCorretaValidade);

            produto.setQuantidadeEstoque(Integer.parseInt(txtQuantidade.getText()));
            produto.setPrecoCompra(Double.parseDouble(txtPrecoCompra.getText()));
            produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
            produto.setUnidade(cbUnidade.getSelectedItem().toString());
            produto.setUnidadeVenda(cbUnidadeVenda.getSelectedItem().toString());

            ProdutoDao ProdutoDao = new ProdutoDao();
            if (ProdutoDao.salvar(produto).equals("SUCESSO")) {

                JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
            } else {
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    public void preencherTabelaCompostos(JTable tabela, TableModel tableModel, Object[] colunas, List<Produto> lista) {
        Object[][] dados = new Object[lista.size()][6]; //Preenche os objetos para popular a tabela 
        int i = 0;
        for (Produto p : lista) {
            dados[i] = p.toArraySelecComp();
            i++;
        }

        tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(20);
    }
    
    public void preencherTabelaManipulacao(JTable tabela, TableModel tableModel, Object[] colunas, List<Produto> lista) {
        Object[][] dados = new Object[lista.size()][5]; //Preenche os objetos para popular a tabela 
        int i = 0;
        for (Produto p : lista) {
            dados[i] = p.toArrayCompManipulado();
            i++;
        }

        tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
        
    }
    
    

    public double adicionarCompostoManipulado(JFrame tela, int linhaSelecionada, JTable tabelaProdutos, double total, JLabel txtTotal, List<Produto> listaCompostos, String strquantidade, JComboBox cbUnidadeDesejada) {

        int id = (int) tabelaProdutos.getValueAt(linhaSelecionada, 0);

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.localizar(id);

        double quantidade = Integer.parseInt(strquantidade);
        double quantAux = Integer.parseInt(strquantidade);
        double preco = (int) produto.getPrecoVenda();
        String unidadeDesejada = cbUnidadeDesejada.getSelectedItem().toString();
        
        //PADRONIZANDO AS UNIDADES PARA GUARDAR NO BANCO DE DADOS
        //PADRÃO ESCOLHIDO É GUARDAR UNIDADE DE SÓLIDO COMO GRAMAS E LIGUIDOS COMO ml
        if(unidadeDesejada.equals("Kg")){
            quantAux = quantAux*1000; 
        }
        else if(unidadeDesejada.equals("mg")){
            quantAux = quantAux/1000;
        }
        else if (unidadeDesejada.equals("l")){
            quantAux = quantAux*1000;
        }
        produto.setQuantidadeSelecionada(quantAux);
        
        double aux = 0;
        //   CALCULANDO O PREÇO  
        if (produto.getUnidadeVenda().equals("g")) {

            if (unidadeDesejada.equals("g")) {

                aux = preco * quantidade;
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
                

            } else if (unidadeDesejada.equals("mg")) {

                aux = preco * (quantidade / 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));

            } else if (unidadeDesejada.equals("Kg")) {

                aux = preco * (quantidade * 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));

            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }

        } else if (produto.getUnidadeVenda().equals("mg")) {

            if (unidadeDesejada.equals("mg")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
                
            } else if (unidadeDesejada.equals("g")) {
                aux = preco * (quantidade * 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
                
            } else if (unidadeDesejada.equals("Kg")) {
                aux = preco * (quantidade * 1000000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }

        } else if (produto.getUnidadeVenda().equals("Kg")) {

            if (unidadeDesejada.equals("Kg")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else if (unidadeDesejada.equals("g")) {
                aux = preco * (quantidade / 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else if (unidadeDesejada.equals("mg")) {
                aux = preco * (quantidade / 1000000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }
        } else if (produto.getUnidadeVenda().equals("l")) {

            if (unidadeDesejada.equals("l")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else if (unidadeDesejada.equals("ml")) {
                aux = preco * (quantidade / 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }

        } else if (produto.getUnidadeVenda().equals("ml")) {

            if (unidadeDesejada.equals("ml")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else if (unidadeDesejada.equals("l")) {
                aux = preco * (quantidade * 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;
                txtTotal.setText(nf.format(total));
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }
        }
        
        //   ATUALIZANDO O ESTOQUE
        if (produto.getUnidade().equals("Kg")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = produto.getQuantidadeEstoque() - quantidade;

                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);

            } else if (unidadeDesejada.equals("g")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("g")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = produto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);

            } else if (unidadeDesejada.equals("g")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("mg")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = produto.getQuantidadeEstoque() - (quantidade * 1000000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("g")) {
                aux = produto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("l")) {

            if (unidadeDesejada.equals("l")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("ml")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("ml")) {

            if (unidadeDesejada.equals("l")) {
                aux = produto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("ml")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }
        }

        return total;
    }

    public double atualizarEstoque(double aux, Produto produto, JFrame tela, double total, ProdutoDao produtoDao, JTable tabelaProdutos, int linhaSelecionada, List<Produto> listaCompostos) {

        if (aux > 0) {

            produto.setQuantidadeEstoque(aux);
            produtoDao.atualizar(produto); //Atualiza estoque

            if (produto.getQuantidadeEstoque() <= 0) { //Se o estoque de determinado produto ficar com 0, retira ele da lista
                ((DefaultTableModel) tabelaProdutos.getModel()).removeRow(linhaSelecionada);
            }

            listaCompostos.add(produto);

            return total;

        } else {
            JOptionPane.showMessageDialog(tela, "Quantidade insuficiente em estoque.", "ERRO", JOptionPane.DEFAULT_OPTION);
            return 0;
        }
    }

    public double removerCompostos(JFrame tela, JTable tabelaManipulacao, int linhaSelecionada, double total, double quantidade ) {

        /*int id = (int) tabelaManipulacao.getValueAt(linhaSelecionada, 0);

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = produtoDao.localizar(id);
        
        int preco = (int) produto.getPrecoVenda();
        String unidadeDesejada = cbUnidadeDesejada.getSelectedItem().toString();

        double aux = 0;
        //   CALCULANDO O PREÇO  
        if (produto.getUnidadeVenda().equals("g")) {

            if (unidadeDesejada.equals("g")) {

                aux = preco * quantidade;
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;

            } else if (unidadeDesejada.equals("mg")) {

                aux = preco * (quantidade / 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;

            } else if (unidadeDesejada.equals("Kg")) {

                aux = preco * (quantidade * 1000);
                total = Double.sum(total, aux);
                total = total * 100;
                total = Math.round(total);
                total = total / 100;

            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }

        } else if (produto.getUnidadeVenda().equals("mg")) {

            if (unidadeDesejada.equals("mg")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
            } else if (unidadeDesejada.equals("g")) {
                aux = preco * (quantidade * 1000);
                total = Double.sum(total, aux);
            } else if (unidadeDesejada.equals("kg")) {
                aux = preco * (quantidade * 1000000);
                total = Double.sum(total, aux);
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }

        } else if (produto.getUnidadeVenda().equals("kg")) {

            if (unidadeDesejada.equals("kg")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
            } else if (unidadeDesejada.equals("g")) {
                aux = preco * (quantidade / 1000);
                total = Double.sum(total, aux);
            } else if (unidadeDesejada.equals("mg")) {
                aux = preco * (quantidade / 1000000);
                total = Double.sum(total, aux);
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }
        } else if (produto.getUnidadeVenda().equals("l")) {

            if (unidadeDesejada.equals("l")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
            } else if (unidadeDesejada.equals("ml")) {
                aux = preco * (quantidade / 1000);
                total = Double.sum(total, aux);
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }

        } else if (produto.getUnidadeVenda().equals("ml")) {

            if (unidadeDesejada.equals("ml")) {
                aux = preco * quantidade;
                total = Double.sum(total, aux);
            } else if (unidadeDesejada.equals("l")) {
                aux = preco * (quantidade * 1000);
                total = Double.sum(total, aux);
            } else {
                JOptionPane.showMessageDialog(tela, "Favor informar uma unidade válida", "Unidade Inválida", JOptionPane.DEFAULT_OPTION);
            }
        }

        //   ATUALIZANDO O ESTOQUE
        if (produto.getUnidade().equals("Kg")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = produto.getQuantidadeEstoque() - quantidade;

                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);

            } else if (unidadeDesejada.equals("g")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("g")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = produto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);

            } else if (unidadeDesejada.equals("g")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("mg")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = produto.getQuantidadeEstoque() - (quantidade * 1000000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("g")) {
                aux = produto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("l")) {

            if (unidadeDesejada.equals("l")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("ml")) {
                aux = produto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }

        } else if (produto.getUnidade().equals("ml")) {

            if (unidadeDesejada.equals("l")) {
                aux = produto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("ml")) {
                aux = produto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, produto, tela, total, produtoDao, tabelaProdutos, linhaSelecionada, listaCompostos);
            }
        }*/
        return total;
    }

}
