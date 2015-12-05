
package controller;

import dao.FornecedorDao;
import java.text.DateFormat;
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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Fornecedor;
import model.Produto;
import view.CadastrarProduto;

public class ProdutoController {
    
    public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelD, JLabel labelE, JLabel labelF,  JLabel labelG,JLabel labelH) {
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
    }   
    
    public void preencheCampos(JTextField txtDescricao, JTextField txtDataCompra, JTextField txtDataValidade, JTextField txtQuantidade, JTextField txtPrecoCompra,JTextField txtPrecoVenda, Produto produto) throws ParseException {
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
        txtPrecoCompra.setText(String.valueOf( produto.getPrecoCompra()));
        txtPrecoVenda.setText(String.valueOf( produto.getPrecoVenda()));
   
    }
    
    public Produto preencheProduto(int id, String descricao, String fornecedor, String dataCompra, String dataValidade, String quantidade, String precoCompra, String precoVenda) {
        
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
        produto.setFornecedor(fornecedor);
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
}
