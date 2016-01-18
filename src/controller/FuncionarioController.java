/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Funcionario;
import util.ValidarCpf;

public class FuncionarioController {
    //verifica se as labels que representam a falta de um dos dados não está visivel, se não estiver então tenta salvar o funcionario
    public void cadastrarFuncionario(JFrame tela, Funcionario funcionario, JLabel txtNaoDigitouCpf, JLabel txtNaoDigitouNome, JLabel txtNaoInformouSexo,
            JLabel txtNaoDigitouData, JLabel txtNaoDigitouEnd, JLabel txtNaoDigitouLogin, JLabel txtNaoDigitouSenha, JLabel txtNaoInformouTipo) {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        if (!txtNaoDigitouCpf.isVisible() && !txtNaoDigitouNome.isVisible() && !txtNaoInformouSexo.isVisible()
                && !txtNaoDigitouData.isVisible() && !txtNaoDigitouEnd.isVisible() && !txtNaoDigitouLogin.isVisible() && !txtNaoDigitouSenha.isVisible()
                && !txtNaoInformouTipo.isVisible()) {
            String salvar = funcionarioDao.salvar(funcionario);
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

    public void validarData(JFrame tela, Funcionario funcionario, JTextField txtData, JLabel txtNaoDigitouData, JLabel txtItensObrigatorios) throws ParseException {
        if (txtData.getText().equals("  /  /    ")) {
            habilitarErro(txtNaoDigitouData, txtItensObrigatorios);
        } else {
            DateFormat f = DateFormat.getDateInstance();
            String data = txtData.getText();
            Date dataCorreta = f.parse(data);
            desabilitarErro(txtNaoDigitouData);
            funcionario.setDataContratacao(dataCorreta);
        }
    }

    public void validarLogin(JFrame tela, Funcionario funcionario, JTextField txtLogin, JLabel txtNaoDigitouLogin, JLabel txtItensObrigatorios) {
        if (txtLogin.getText().trim().isEmpty()) { //Verifica se o campo nome não está vazio
            habilitarErro(txtNaoDigitouLogin, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoDigitouLogin);
            funcionario.setLogin(txtLogin.getText());
        }
    }

    public void validarNome(JFrame tela, Funcionario funcionario, JTextField txtNome, JLabel txtNaoDigitouNome, JLabel txtItensObrigatorios) {
        if (txtNome.getText().trim().isEmpty()) { //Verifica se o campo nome não está vazio
            habilitarErro(txtNaoDigitouNome, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoDigitouNome);
            funcionario.setNome(txtNome.getText());
        }
    }

    public void validarCpf(JFrame tela, Funcionario funcionario, JTextField txtCpf, JLabel txtNaoDigitouCpf, JLabel txtItensObrigatorios) {
        if (txtCpf.getText().equals("   .   .   -  ")) { //Verifica se o campo de CPF não está vazio
            habilitarErro(txtNaoDigitouCpf, txtItensObrigatorios);
        } else if (ValidarCpf.isCPF(txtCpf.getText())) {
            desabilitarErro(txtNaoDigitouCpf);
            funcionario.setCpf(txtCpf.getText());
        } else {
            habilitarErro(txtNaoDigitouCpf, txtItensObrigatorios);
            JOptionPane.showMessageDialog(tela, "CPF inválido", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
    }


    public void validarSenha(JFrame tela, Funcionario funcionario, JTextField txtSenha, JLabel txtNaoDigitouSenha, JLabel txtItensObrigatorios) {
        if (txtSenha.getText().trim().isEmpty()) { //Verifica se a senha está vazio
            habilitarErro(txtNaoDigitouSenha, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoDigitouSenha);
            funcionario.setSenha(txtSenha.getText());
        }
    }

    public void validarEndereco(JFrame tela, Funcionario funcionario, JTextField txtEnd, JLabel txtNaoDigitouEnd, JLabel txtItensObrigatorios) {
        if (txtEnd.getText().trim().isEmpty()) { //Verifica se o campo endereço está vazio
            habilitarErro(txtNaoDigitouEnd, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoDigitouEnd);
            funcionario.setEndereco(txtEnd.getText());
        }
    }

    public void validarSexo(JFrame tela, Funcionario funcionario, JRadioButton btnMasc, JRadioButton btnFemi, JLabel txtNaoInformouSexo, JLabel txtItensObrigatorios) {
        if (!btnMasc.isSelected() && !btnFemi.isSelected()) { //Verifica se o sexo esta selecionado
            habilitarErro(txtNaoInformouSexo, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoInformouSexo);
            if (btnMasc.isSelected()) {
                funcionario.setSexo('M');
            } else {
                funcionario.setSexo('F');
            }
        }
    }

    public void validarTipo(JFrame tela, Funcionario funcionario, JRadioButton btnComum, JRadioButton btnFarmaceutico, JLabel txtNaoInformouTipo, JLabel txtItensObrigatorios) {
        if (!btnComum.isSelected() && !btnFarmaceutico.isSelected()) { //Verifica se o tipo esta selecionado
            habilitarErro(txtNaoInformouTipo, txtItensObrigatorios);
        } else {
            desabilitarErro(txtNaoInformouTipo);
            if (btnFarmaceutico.isSelected()) {
                funcionario.setTipo("1");
            } else {
                funcionario.setTipo("2");
            }
        }
    }

    //preencer a tabela com os dados listados a baixo
    public void preencherTabela(List<Funcionario> lista, TableModel tableModelFuncionario, JTable tabelaFuncionarios) {
        Object[][] dados = new Object[lista.size()][5];
        int i = 0;
        for (Funcionario c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Nome", "E-mail", "Telefone", "Data Contratação"};
        tableModelFuncionario = new DefaultTableModel(dados, colunas);
        tabelaFuncionarios.setModel(tableModelFuncionario);
    }

    //desabilita as labels que mostram que um dado está faltando
    public void desabilitarErros(JLabel labelA, JLabel labelB, JLabel labelC, JLabel labelD, JLabel labelE,
            JLabel labelF, JLabel labelG, JLabel labelH, JLabel labelI) {
        labelA.setVisible(false);
        labelB.setVisible(false);
        labelC.setVisible(false);
        labelD.setVisible(false);
        labelE.setVisible(false);
        labelF.setVisible(false);
        labelG.setVisible(false);
        labelH.setVisible(false);
        labelI.setVisible(false);

    }

    //habilita a label que diz que o dado está faltando
    public void habilitarErro(JLabel labelA, JLabel labelPrincipal) {
        labelA.setVisible(true);
        labelPrincipal.setVisible(true);
    }

    //desabilita a label que diz que o dado está faltando
    public void desabilitarErro(JLabel labelA) {
        labelA.setVisible(false);
    }

    public void preencheCampos(JTextField txtNome, JTextField txtEndereco, JTextField txtCpf, JTextField txtEmail, JTextField txtTelefone, JRadioButton btnMasc, JRadioButton btnFemi, Funcionario funcionario) {
        txtNome.setText(funcionario.getNome());
        txtEndereco.setText(funcionario.getEndereco());
        txtCpf.setText(funcionario.getCpf());
        txtEmail.setText(funcionario.getEmail());
        txtTelefone.setText(funcionario.getTelefone());
        if (funcionario.getSexo() == 'M') {
            btnMasc.setSelected(true);
        } else {
            btnFemi.setSelected(true);
        }
    }

    public Funcionario preencheFuncionario(int id, String nome, String endereco, String cpf, String email, String telefone, JRadioButton btnMasc, JRadioButton btnFemi) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setEndereco(endereco);
        funcionario.setTelefone(telefone);
        if (btnMasc.isSelected()) {
            funcionario.setSexo('M');
        } else {
            funcionario.setSexo('F');
        }
        return funcionario;
    }

}
