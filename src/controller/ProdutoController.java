
package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Produto;
import view.CadastrarProduto;

public class ProdutoController {
    
    public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelD, JLabel labelE, JLabel labelF,  JLabel labelG) {
        labelA.setVisible(false);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);
        labelE.setVisible(false);
        labelF.setVisible(false);
        labelG.setVisible(false);
        
    }
    
    public void habilitarErro(JLabel labelA, JLabel labelPrincipal) {
        labelA.setVisible(true);
        labelPrincipal.setVisible(true);
    }

    public void desabilitarErro(JLabel labelA) {
        labelA.setVisible(false);
    }
    
    public void preencheCampos(JTextField txtDescricao, JTextField txtDataCompra, JTextField txtDataValidade, JTextField txtQuantidade, JTextField txtPrecoCompra,JTextField txtPrecoVenda, Produto produto) throws ParseException {
        txtDescricao.setText(produto.getDescricao());
        
        String data1 = txtDataCompra.getText();
        String data2 = txtDataValidade.getText();
        DateFormat f = DateFormat.getInstance();
        Date dataCorreta1 = f.parse(data1);
        Date dataCorreta2 = f.parse(data2);
        
        txtDataCompra.setText(produto.getDataCompra().toString());
        txtDataValidade.setText(produto.getDataValidade().toString());
        
        txtQuantidade.setText(String.valueOf( produto.getQuantidadeEstoque()));
        txtPrecoCompra.setText(String.valueOf( produto.getPrecoCompra()));
        txtPrecoVenda.setText(String.valueOf( produto.getPrecoVenda()));
   
    }
    
    public Produto preencheProduto(int id, String descricao, String dataCompra, String dataValidade, String quantidade, String precoCompra, String precoVenda) {
        
        Date dataCorreta1 = null;
        Date dataCorreta2 = null;
        
        try{
                Calendar d =  Calendar.getInstance();
                DateFormat f = DateFormat.getDateInstance();
                String data1, data2;
                data1 = dataCompra;
                data2 = dataValidade;
                
                dataCorreta1 = f.parse(data1);
                dataCorreta2 = f.parse(data2);
        }
        catch (ParseException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Produto produto = new Produto();
        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setDataCompra(dataCorreta1);
        produto.setDataValidade(dataCorreta2);
        produto.setQuantidadeEstoque(Integer.parseInt(quantidade));
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
    
}
