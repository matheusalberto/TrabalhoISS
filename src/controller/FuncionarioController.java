/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.util.Calendar;
import model.Funcionario;

//terminar de cadastrar aqui no controller, ver quais atributos falta paassar certo
//e tratar o tipo que é passado
public class FuncionarioController {
    //Cadastra um funcionario no banco da dados
    public void CadastrarFuncionario(String nome, String endereco, String telefone, String login, String senha,
            char sexo, String email, String cpf, int nivelAcesso, int tipo) {
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

        FuncionarioDao funcDao = new FuncionarioDao();
        funcDao.salvar(funcionario);
    }

}
