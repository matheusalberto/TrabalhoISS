package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String login;
    private String senha;
    private String nome;
    private String endereco;
    private String telefone;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataContratacao;
    private char sexo;
    @Column(unique = true)
    private String email;
    private String cpf;
    private String tipo; //1-FARMACEUTICO e 2-FUNCIONARIO
    private Integer excluido; //exclusão lógica

    public Funcionario() {

    }

    public Integer getExcluido() {
        return excluido;
    }

    public void setExcluido(Integer excluido) {
        this.excluido = excluido;
    }

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public char getSexo() {
        return sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Object[] toArray() {
        return new Object[]{id, nome, email, telefone, dataContratacao};
    }
    
    public Object[] toArrayTeste() {
        return new Object[]{id, nome, email, telefone};
    }

}
