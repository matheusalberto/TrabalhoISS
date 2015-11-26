
package controller;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Fornecedor;
import model.Funcionario;

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
        Object[][] dados = new Object[lista.size()][4];
        int i = 0;
        for (Fornecedor c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Nome", "E-mail", "Telefone"};
        tableModelFornecedor = new DefaultTableModel(dados, colunas);
        tabelaFornecedores.setModel(tableModelFornecedor);
    }
}
