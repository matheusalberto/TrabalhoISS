package controller;

import dao.CompostoDao;
import dao.ProdutoDao;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Composto;
import model.Produto;

public class CompostoController {

    private final NumberFormat nf = new DecimalFormat("###,##0.00");

    public void preencherTabelaManipulacao(JTable tabela, TableModel tableModel, Object[] colunas, List<Composto> lista) {
        Object[][] dados = new Object[lista.size()][5]; //Preenche os objetos para popular a tabela 
        int i = 0;
        for (Composto c : lista) {
            dados[i] = c.toArrayCompManipulado();
            i++;
        }

        tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(130);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(130);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(50);

    }

    public void preencherTabelaCompostos(JTable tabela, TableModel tableModel, Object[] colunas, List<Composto> lista) {
        Object[][] dados = new Object[lista.size()][6]; //Preenche os objetos para popular a tabela 
        int i = 0;
        for (Composto c : lista) {
            dados[i] = c.toArraySelecComp();
            i++;
        }

        tableModel = new DefaultTableModel(dados, colunas);
        tabela.setModel(tableModel);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(40);
    }

    public void cadastrarComposto(JFrame tela, JTextField txtDescricao, JComboBox cbFornecedor, JTextField txtDataCompra, JTextField txtDataValidade, JTextField txtQuantidade, JTextField txtPrecoCompra, JTextField txtPrecoVenda, JComboBox cbUnidade, JComboBox cbUnidadeVenda) {
        if (txtDescricao.getText().trim().isEmpty() || cbFornecedor.getSelectedItem().toString().trim().isEmpty() || txtDataCompra.getText().equals("  /  /    ") || txtDataValidade.getText().equals("  /  /    ") || txtQuantidade.getText().trim().isEmpty() || txtPrecoCompra.getText().trim().isEmpty() || txtPrecoVenda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(tela, "Favor preencher todos os itens obrigatórios", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        } else {
            Composto composto = new Composto();
            composto.setDescricao(txtDescricao.getText());
            composto.setFornecedor(cbFornecedor.getSelectedItem().toString());

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
            composto.setDataCompra(dataCorretaCompra);

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
            composto.setDataValidade(dataCorretaValidade);

            composto.setQuantidadeEstoque(Integer.parseInt(txtQuantidade.getText()));
            composto.setPrecoCompra(Double.parseDouble(txtPrecoCompra.getText()));
            composto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
            composto.setUnidade(cbUnidade.getSelectedItem().toString());
            composto.setUnidadeVenda(cbUnidadeVenda.getSelectedItem().toString());

            CompostoDao compostoDao = new CompostoDao();
            if (compostoDao.salvar(composto).equals("SUCESSO")) {

                JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
            } else {
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    public double adicionarCompostoManipulado(JFrame tela, int linhaSelecionada, JTable tabelaCompostos, double total, JLabel txtTotal, List<Composto> listaCompostos, String strquantidade, JComboBox cbUnidadeDesejada) {

        int id = (int) tabelaCompostos.getValueAt(linhaSelecionada, 0);

        CompostoDao compostoDao = new CompostoDao();
        Composto composto = compostoDao.localizar(id);

        double quantidade = Integer.parseInt(strquantidade);
        double quantAux = Integer.parseInt(strquantidade);
        double preco = composto.getPrecoVenda();
        String unidadeDesejada = cbUnidadeDesejada.getSelectedItem().toString();

        //PADRONIZANDO AS UNIDADES PARA GUARDAR NO BANCO DE DADOS
        //PADRÃO ESCOLHIDO É GUARDAR UNIDADE DE SÓLIDO COMO GRAMAS E LIGUIDOS COMO ml
        if (unidadeDesejada.equals("Kg")) {
            quantAux = quantAux * 1000;
        } else if (unidadeDesejada.equals("mg")) {
            quantAux = quantAux / 1000;
        } else if (unidadeDesejada.equals("l")) {
            quantAux = quantAux * 1000;
        }
        composto.setQuantidadeSelecionada(quantAux);

        double aux = 0;
        //   CALCULANDO O PREÇO  
        if (composto.getUnidadeVenda().equals("g")) {

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

        } else if (composto.getUnidadeVenda().equals("mg")) {

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

        } else if (composto.getUnidadeVenda().equals("Kg")) {

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
        } else if (composto.getUnidadeVenda().equals("l")) {

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

        } else if (composto.getUnidadeVenda().equals("ml")) {

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
        if (composto.getUnidade().equals("Kg")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = composto.getQuantidadeEstoque() - quantidade;

                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);

            } else if (unidadeDesejada.equals("g")) {
                aux = composto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = composto.getQuantidadeEstoque() - (quantidade / 1000000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            }

        } else if (composto.getUnidade().equals("g")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = composto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);

            } else if (unidadeDesejada.equals("g")) {
                aux = composto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = composto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            }

        } else if (composto.getUnidade().equals("mg")) {

            if (unidadeDesejada.equals("Kg")) {

                aux = composto.getQuantidadeEstoque() - (quantidade * 1000000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("g")) {
                aux = composto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("mg")) {
                aux = composto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            }

        } else if (composto.getUnidade().equals("l")) {

            if (unidadeDesejada.equals("l")) {
                aux = composto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("ml")) {
                aux = composto.getQuantidadeEstoque() - (quantidade / 1000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            }

        } else if (composto.getUnidade().equals("ml")) {

            if (unidadeDesejada.equals("l")) {
                aux = composto.getQuantidadeEstoque() - (quantidade * 1000);
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            } else if (unidadeDesejada.equals("ml")) {
                aux = composto.getQuantidadeEstoque() - quantidade;
                atualizarEstoque(aux, composto, tela, total, compostoDao, tabelaCompostos, linhaSelecionada, listaCompostos);
            }
        }

        return total;
    }

    public double atualizarEstoque(double aux, Composto composto, JFrame tela, double total, CompostoDao compostoDao, JTable tabelaProdutos, int linhaSelecionada, List<Composto> listaCompostos) {

        if (aux >= 0) {

            composto.setQuantidadeEstoque(aux);
            compostoDao.atualizar(composto); //Atualiza estoque

            if (composto.getQuantidadeEstoque() <= 0) { //Se o estoque de determinado produto ficar com 0, retira ele da lista
                ((DefaultTableModel) tabelaProdutos.getModel()).removeRow(linhaSelecionada);
            }

            listaCompostos.add(composto);

            return total;

        } else {
            JOptionPane.showMessageDialog(tela, "Quantidade insuficiente em estoque.", "ERRO", JOptionPane.DEFAULT_OPTION);
            return 0;
        }
    }

    public double removerCompostos(JFrame tela, JTable tabelaManipulacao, int linhaSelecionada, double total, JLabel txtPreco, List<Composto> listaCompostos) {

        int id = (int) tabelaManipulacao.getValueAt(linhaSelecionada, 0);

        CompostoDao compostoDao = new CompostoDao();
        Composto composto = compostoDao.localizar(id);

        double aux = 0;
        //   CALCULANDO O PREÇO 
        //   A UNIDADE EM ESTOQUE ESTÁ PADRONIZADA PARA GRAMAS(g) ou MILILITROS(ml)

        if (composto.getUnidadeVenda().equals("g")) {

            aux = composto.getQuantidadeSelecionada() * composto.getPrecoVenda();
            total = total - aux;
            txtPreco.setText(nf.format(total));

        } else if (composto.getUnidadeVenda().equals("mg")) {

            aux = (composto.getQuantidadeSelecionada() * 1000) * composto.getPrecoVenda();
            total = total - aux;
            txtPreco.setText(nf.format(total));

        } else if (composto.getUnidadeVenda().equals("Kg")) {

            aux = (composto.getQuantidadeSelecionada() / 1000) * composto.getPrecoVenda();
            total = total - aux;
            txtPreco.setText(nf.format(total));

        } else if (composto.getUnidadeVenda().equals("l")) {

            aux = composto.getQuantidadeSelecionada() * 1000 * composto.getPrecoVenda();
            total = total - aux;
            txtPreco.setText(nf.format(total));

        } else if (composto.getUnidadeVenda().equals("ml")) {

            aux = composto.getQuantidadeSelecionada() * composto.getPrecoVenda();
            total = total - aux;
            txtPreco.setText(nf.format(total));

        }

        //   ATUALIZANDO O ESTOQUE
        if (composto.getUnidade().equals("Kg")) {

            aux = composto.getQuantidadeEstoque() + composto.getQuantidadeSelecionada() / 1000;
            composto.setQuantidadeEstoque(aux);
            compostoDao.atualizar(composto);

        } else if (composto.getUnidade().equals("g")) {

            aux = composto.getQuantidadeEstoque() + composto.getQuantidadeSelecionada();
            composto.setQuantidadeEstoque(aux);
            compostoDao.atualizar(composto);

        } else if (composto.getUnidade().equals("mg")) {

            aux = composto.getQuantidadeEstoque() + (composto.getQuantidadeSelecionada() * 1000);
            composto.setQuantidadeEstoque(aux);
            compostoDao.atualizar(composto);

        } else if (composto.getUnidade().equals("l")) {

            aux = composto.getQuantidadeEstoque() + (composto.getQuantidadeSelecionada() / 1000);
            composto.setQuantidadeEstoque(aux);
            compostoDao.atualizar(composto);

        } else if (composto.getUnidade().equals("ml")) {

            aux = composto.getQuantidadeEstoque() + composto.getQuantidadeSelecionada();
            composto.setQuantidadeEstoque(aux);
            compostoDao.atualizar(composto);

        }

        listaCompostos.remove(linhaSelecionada);
        ((DefaultTableModel) tabelaManipulacao.getModel()).removeRow(linhaSelecionada); //Remove linha 

        return total;
    }

    public void cancelarManipulacao(List<Composto> listaCompostos) {

        double aux = 0;

        for (Composto composto : listaCompostos) {

            if (composto.getUnidade().equals("Kg")) {

                aux = composto.getQuantidadeEstoque() + composto.getQuantidadeSelecionada() / 1000;
                composto.setQuantidadeEstoque(aux);

            } else if (composto.getUnidade().equals("g")) {

                aux = composto.getQuantidadeEstoque() + composto.getQuantidadeSelecionada();
                composto.setQuantidadeEstoque(aux);

            } else if (composto.getUnidade().equals("mg")) {

                aux = composto.getQuantidadeEstoque() + (composto.getQuantidadeSelecionada() * 1000);
                composto.setQuantidadeEstoque(aux);

            } else if (composto.getUnidade().equals("l")) {

                aux = composto.getQuantidadeEstoque() + (composto.getQuantidadeSelecionada() / 1000);
                composto.setQuantidadeEstoque(aux);

            } else if (composto.getUnidade().equals("ml")) {

                aux = composto.getQuantidadeEstoque() + composto.getQuantidadeSelecionada();
                composto.setQuantidadeEstoque(aux);

            }
            new CompostoDao().atualizarQuantidadeEstoqueManip(composto.getId(), aux);

        }
    }

    public Produto finalizarManipulacao(JFrame tela, List<Composto> listaCompostos, double total, String nome) {

        Produto produto = new Produto();
        produto.setDescricao(nome);

        produto.setCompostos(listaCompostos);

        //CALCULADNO A MÃO DE OBRA
        int tamListComp = 0;
        tamListComp = listaCompostos.size();

        total = calcularMaoDeObra(total,tamListComp);
               
        produto.setPrecoVenda(total);
        produto.setQuantidadeEstoque(1);

        ProdutoDao produtoDao = new ProdutoDao();
        String salvar = produtoDao.salvar(produto);

        switch (salvar) {
            case "SUCESSO":
                JOptionPane.showMessageDialog(tela, "Compostos manipulados com sucesso!", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                break;
        }

        return produto;

    }
    
    public double calcularMaoDeObra(double total, int tamListComp){
        
        if (tamListComp <= 5) {
            total = total + (total * 0.10); //até 5 compostos: 10% de mão de obra
        } else if (tamListComp <= 10) {
            total = total + (total * 0.15); //de 6 a 10 compostos: 15% de mão de obra
        } else if (tamListComp > 10) {
            total = total + (total * 0.20); // mais de 10 compostos: 20% de mão de obra
        }
         
        return total;
    }

}
