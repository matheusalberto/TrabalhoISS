/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Funcionario;


public class FuncionarioController {
    public void CadastrarFuncionario(String nome, String endereco, String telefone, String login, String senha,
            char sexo, String email, String cpf, int nivelAcesso, int tipo, Date data) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setEmail(email);
        funcionario.setEndereco(endereco);
        funcionario.setCpf(cpf);
        funcionario.setLogin(login);
        funcionario.setSenha(senha);
        funcionario.setSexo(sexo);
        funcionario.setTelefone(telefone);
        funcionario.setTipo(tipo);
        funcionario.setDataContratacao(data);

        FuncionarioDao funcDao = new FuncionarioDao();
        String salvar = funcDao.salvar(funcionario);
        switch(salvar) {
            case "SUCESSO":
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "", JOptionPane.DEFAULT_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
                    break;
        
        
        }
    }
    
    public void preencherTabela(List<Funcionario> lista, TableModel tableModelFuncionario, JTable tabelaFuncionarios) {
        Object[][] dados = new Object[lista.size()][4];
        int i = 0;
        for (Funcionario c : lista) {
            dados[i] = c.toArray();
            i++;
        }

        Object[] colunas = new Object[]{"Código", "Nome", "E-mail", "Telefone"};
        tableModelFuncionario = new DefaultTableModel(dados, colunas);
        tabelaFuncionarios.setModel(tableModelFuncionario);
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
