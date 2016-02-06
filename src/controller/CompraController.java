
package controller;

import dao.ClienteDao;
import dao.CompraDao;
import dao.FornecedorDao;
import dao.PagamentoDao;
import dao.PedidoDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.Compra;
import model.Fornecedor;
import model.Funcionario;
import model.Pagamento;
import model.Pedido;
import model.Produto;
import org.jdesktop.swingx.JXDatePicker;
import view.CadastrarProduto;

public class CompraController {
    
        public void desabilitarErros(JLabel labelA,JLabel labelB, JLabel labelC, JLabel labelD, JLabel labelE) {
        labelA.setVisible(true);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);
        labelE.setVisible(false);
        
        }
    
        public void habilitarErro(JLabel labelA, JLabel labelPrincipal) {
            labelA.setVisible(true);
            labelPrincipal.setVisible(true);
        }

        public void desabilitarErro(JLabel labelA) {
            labelA.setVisible(false);
        }   
    
        public void validarFornecedor(JFrame tela, Compra compra, JComboBox cbFornecedor, JLabel txtSemFornecedor, JLabel txtErro){
            if (cbFornecedor.getSelectedItem().toString().trim().isEmpty()) {
                    habilitarErro(txtSemFornecedor, txtErro);
                } else {
                    desabilitarErro(txtSemFornecedor);
                    compra.setFornecedor(cbFornecedor.getSelectedItem().toString());
                }
        }

        public void validarDescricao(JFrame tela, Compra compra, JTextField txtDescricao, JLabel txtSemDescricao, JLabel txtErro) {

            if (txtDescricao.getText().trim().isEmpty()) {
                habilitarErro(txtSemDescricao, txtErro);
            } else {
                desabilitarErro(txtSemDescricao);
                compra.setDescricao(txtDescricao.getText());
            }
        }
    
        public void validarPreco(JFrame tela, Compra compra, JTextField txtPrecoCompra, JLabel txtSemPreco, JLabel txtErro) {

            if ((txtPrecoCompra.getText().trim().isEmpty()) || ((Double.parseDouble(txtPrecoCompra.getText()) < 1))) {
                        habilitarErro(txtSemPreco, txtErro);
                    } else {
                        desabilitarErro(txtSemPreco);
                        compra.setValorCompra(Double.parseDouble(txtPrecoCompra.getText()));
                    }
        }
    
        public void validarPagto(JFrame tela, Compra compra, JRadioButton btnSim, JRadioButton btnNao, JLabel txtSemPagto, JLabel txtErro) {

            if (!btnSim.isSelected() && !btnNao.isSelected()) { //Verifica se foi pago
                habilitarErro(txtSemPagto, txtErro);
            } else {
                desabilitarErro(txtSemPagto);
                if (btnSim.isSelected()) {
                    compra.setPagto('S');
                } else {
                    compra.setPagto('N');
                }
            }
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
        
        public void cadastrarCompra(JFrame tela, Compra compra, JLabel txtSemForncedor, JLabel txtSemDescricao, JLabel txtSemPreco, JLabel txtSemPagto) {
        CompraDao compraDao = new CompraDao();
        if (!txtSemForncedor.isVisible() && !txtSemDescricao.isVisible() && !txtSemPreco.isVisible() && !txtSemPagto.isVisible()) {
            String salvar = compraDao.salvar(compra);
            switch (salvar) {
                case "SUCESSO":
                    JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                    tela.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                    break;
            }
        }
    }

    public void preencheCampos(JTextField txtDescricao, JXDatePicker txtDataCompra, JXDatePicker txtDataEntrega, JTextField txtValorCompra, JRadioButton btnSim, JRadioButton btnNao, Compra compra) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        txtDescricao.setText(compra.getDescricao());
        txtDataCompra.setDate(compra.getDataCompra());
        txtDataEntrega.setDate(compra.getDataEntrega());
        txtValorCompra.setText(String.valueOf( compra.getValorCompra()));
        if (compra.getPagto()== 'S') {
            btnSim.setSelected(true);
        } else {
            btnNao.setSelected(true);
        }
    
    }
    
    public Compra preencheCompra(Integer id, String fornecedor, String descricao, Date dataCompra, Date Entrega, String preco, JRadioButton btnSim, JRadioButton btnNao) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Compra compra = new Compra();
        compra.setId(id);
        compra.setExcluido(0); //NÃO FOI EXCLUIDO
        compra.setFornecedor(fornecedor);
        compra.setDescricao(descricao);
        compra.setDataCompra(dataCompra);
        compra.setDataEntrega(Entrega);
        compra.setValorCompra(Double.parseDouble(preco));
        if (btnSim.isSelected()) {
            compra.setPagto('S');
        } else {
            compra.setPagto('N');
        }
        return compra;
    }
    
 
    
   

    public void preencherTabela(List<Compra> lista, TableModel tableModelCompra, JTable tabelaCompras) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Object[][] dados = new Object[lista.size()][7];
        int i = 0;
        for (Compra c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Fornecedor", "Descricao", "Data Compra", "Data Entrega","Valor Compra", "Pago"};
        tableModelCompra = new DefaultTableModel(dados, colunas);
        tabelaCompras.setModel(tableModelCompra);
    
    }

    public void preencherComboBoFornecedorEditar(JComboBox cbFornecedor, Compra compra) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        List<Fornecedor> list = new FornecedorDao().listar(""); //PEGO TODOS OS FORNECEDORES CADASTRADOS
        List<String> nomes = new ArrayList<>(); 
        for (Fornecedor list1 : list) { 
            nomes.add(list1.getNome()); //PEGO APENAS OS NOMES DOS FORNECEDORES
        }
        for (String nome : nomes) {
            cbFornecedor.addItem(nome.toString()); //ADICIONO ELES NO COMBO BOX
            
        }
        cbFornecedor.setSelectedItem(compra.getFornecedor());
        cbFornecedor.disable();
    
    }

    
}
    
    

