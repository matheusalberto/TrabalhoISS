package controller;

import dao.ClienteDao;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import util.ValidarCpf;

public class ClienteController {

    public void verificarSexo(JRadioButton btnA, JRadioButton btnB) {
        if (btnA.isSelected()) {
            btnB.setSelected(false);
        }
    }

    public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelD) {
        labelA.setVisible(false);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);
    }

    public void habilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelPrincipal) {
        labelA.setVisible(true);
        labelB.setVisible(true);
        labelC.setVisible(true);
        labelPrincipal.setVisible(true);
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
        cliente.setExcluido(0); //NÃO FOI EXCLUIDO
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

    public void atualizarCliente(JFrame tela, Cliente cliente, JTextField txtNome) {
        if (!txtNome.getText().trim().isEmpty()) {
            if (new ClienteDao().atualizar(cliente).equals("SUCESSO")) {
                JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                tela.dispose();
            } else {
                JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    public void cadastrarCliente(JFrame tela, Cliente cliente, JLabel txtNaoDigitouCpf, JLabel txtNaoDigitouNome, JLabel txtNaoInformouSexo) {
        ClienteDao clienteDao = new ClienteDao();
        if (!txtNaoDigitouCpf.isVisible() && !txtNaoDigitouNome.isVisible() && !txtNaoInformouSexo.isVisible()) {
            String salvar = clienteDao.salvar(cliente);
            switch (salvar) {
                case "SUCESSO":
                    JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                    tela.dispose();
                    break;
                case "FALHA_CPF":
                    JOptionPane.showMessageDialog(tela, "CPF já existente.", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(tela, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                    break;
            }
        }
    }

    public void validarNome(JFrame tela, Cliente cliente, JTextField txtNome, JLabel txtNaoDigitouNome, JLabel txtItensObrigatorios) {
        if (txtNome.getText().trim().isEmpty()) { //Verifica se o campo nome não está vazio
            habilitarErro(txtNaoDigitouNome, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoDigitouNome);
            cliente.setNome(txtNome.getText());
        }
    }

    public void validarCpf(JFrame tela, Cliente cliente, JTextField txtCpf, JLabel txtNaoDigitouCpf, JLabel txtItensObrigatorios) {
        if (txtCpf.getText().equals("   .   .   -  ")) { //Verifica se o campo de CPF não está vazio
            habilitarErro(txtNaoDigitouCpf, txtItensObrigatorios);
        } else if (ValidarCpf.isCPF(txtCpf.getText())) {
            desabilitarErro(txtNaoDigitouCpf);
            cliente.setCpf(txtCpf.getText());
        } else {
            habilitarErro(txtNaoDigitouCpf, txtItensObrigatorios);
            JOptionPane.showMessageDialog(tela, "CPF inválido", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
    }

    public void validarSexo(JFrame tela, Cliente cliente, JRadioButton btnMasc, JRadioButton btnFemi, JLabel txtNaoInformouSexo, JLabel txtItensObrigatorios) {
        if (!btnMasc.isSelected() && !btnFemi.isSelected()) { //Verifica se o sexo esta selecionado
            habilitarErro(txtNaoInformouSexo, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoInformouSexo);
            if (btnMasc.isSelected()) {
                cliente.setSexo('M');
            } else {
                cliente.setSexo('F');
            }
        }
    }

}
