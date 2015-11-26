package controller;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;

public class ClienteController {

    public void verificarSexo(JRadioButton btnA, JRadioButton btnB) {
        if (btnA.isSelected()) {
            btnB.setSelected(false);
        }
    }

    public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelD, JLabel labelE) {
        labelA.setVisible(false);
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

    public void preencheCampos(JTextField txtNome, JTextField txtEndereco, JTextField txtCpf, JTextField txtEmail, JTextField txtTelefone, JRadioButton btnMasc, JRadioButton btnFemi, Cliente cliente) {
        txtNome.setText(cliente.getNome());
        txtEndereco.setText(cliente.getEndereco());
        txtCpf.setText(cliente.getCpf());
        txtEmail.setText(cliente.getEmail());
        txtTelefone.setText(cliente.getTelefone());
        if (cliente.getSexo() == 'M') {
            btnMasc.setSelected(true);
        } else {
            btnFemi.setSelected(true);
        }
    }

    public Cliente preencheCliente(int id, String nome, String endereco, String cpf, String email, String telefone, JRadioButton btnMasc, JRadioButton btnFemi) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        if (btnMasc.isSelected()) {
            cliente.setSexo('M');
        } else {
            cliente.setSexo('F');
        }
        return cliente;
    }

    public void preencherTabela(List<Cliente> lista, TableModel tableModelCliente, JTable tabelaClientes) {
        Object[][] dados = new Object[lista.size()][4];
        int i = 0;
        for (Cliente c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Nome", "E-mail", "Telefone"};
        tableModelCliente = new DefaultTableModel(dados, colunas);
        tabelaClientes.setModel(tableModelCliente);
    }

}
