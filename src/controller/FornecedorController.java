
package controller;

import dao.FornecedorDao;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Fornecedor;
import model.Funcionario;
import util.ValidarCNPJ;

public class FornecedorController {
    
    public void mostrarErro(JLabel erro){
        erro.setVisible(true);
    }
    
    public void ocultarErro(JLabel erro){
        erro.setVisible(false);
    }
    
    public Fornecedor preencheFornecedor(int id, String nome, String endereco, String cnpj, String telefone, String email){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        fornecedor.setExcluido(0);
        fornecedor.setNome(nome);
        fornecedor.setCnpj(cnpj);
        fornecedor.setEmail(email);
        fornecedor.setEndereco(endereco);
        fornecedor.setTelefone(telefone);
        
        return fornecedor;
    }
    
    public void preencheCampos(JTextField txtNome,JTextField txtEndereco, JTextField txtCnpj, JTextField txtTelefone, JTextField txtEmail, Fornecedor fornecedor){
        txtNome.setText(fornecedor.getNome());
        txtEndereco.setText(fornecedor.getEndereco());
        txtCnpj.setText(fornecedor.getCnpj());
        txtTelefone.setText(fornecedor.getTelefone());
        txtEmail.setText(fornecedor.getEmail());
    }
    
     public void preencherTabela(List<Fornecedor> lista, TableModel tableModelFornecedor, JTable tabelaFornecedores) {
        Object[][] dados = new Object[lista.size()][5];
        int i = 0;
        for (Fornecedor c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Nome", "E-mail", "Telefone", "Endereço"};
        tableModelFornecedor = new DefaultTableModel(dados, colunas);
        tabelaFornecedores.setModel(tableModelFornecedor);
    }
     
     public void cadastrarFornecedor(JFrame tela,JTextField txtNome, JTextField txtCnpj, JTextField txtEndereco, JTextField txtEmail, JTextField txtTelefone,JLabel txtErro){
         if (txtNome.getText().trim().isEmpty() || txtCnpj.getText().equals("  .   .   /    -  ") || txtEndereco.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() || txtTelefone.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(tela, "Favor preencher todos os itens obrigatórios","Algo deu errado",JOptionPane.DEFAULT_OPTION);
        }
        else{
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(txtNome.getText());
            fornecedor.setEndereco(txtEndereco.getText());
            if(ValidarCNPJ.isCNPJ(txtCnpj.getText())){
                fornecedor.setCnpj(txtCnpj.getText());
            }
            else{
                JOptionPane.showMessageDialog(tela, "CNPJ Inválido","Algo deu errado",JOptionPane.DEFAULT_OPTION);
                return;
            }
            fornecedor.setTelefone(txtTelefone.getText());
            fornecedor.setEmail(txtEmail.getText());
            fornecedor.setExcluido(0);
            
            
            FornecedorDao FornecedorDao = new FornecedorDao();
            if(FornecedorDao.salvar(fornecedor).equals("SUCESSO")){
                
                JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
            }
            else{
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
            }
        }
     }
}
