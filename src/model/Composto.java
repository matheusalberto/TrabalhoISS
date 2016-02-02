package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "composto")
public class Composto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCompra;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidade;
    private String fornecedor; //necessario ligar a variavel aos fornecedores cadastrados
    private double precoCompra;
    private double precoVenda;
    private double quantidadeEstoque;
    private String unidade;
    private String unidadeVenda;
    private double quantidadeSelecionada;
    @ManyToMany(mappedBy = "compostos")
    private List<Produto> produtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getUnidadeVenda() {
        return unidadeVenda;
    }

    public void setUnidadeVenda(String unidadeVenda) {
        this.unidadeVenda = unidadeVenda;
    }

    public double getQuantidadeSelecionada() {
        return quantidadeSelecionada;
    }

    public void setQuantidadeSelecionada(double quantidadeSelecionada) {
        this.quantidadeSelecionada = quantidadeSelecionada;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }   
    
    public Object[] toArraySelecComp() {
        return  new Object[]{id,descricao, precoVenda,unidadeVenda,quantidadeEstoque,unidade};
    }
    
     public Object[] toArrayCompManipulado() {
        return  new Object[]{id,descricao, quantidadeSelecionada ,quantidadeEstoque,unidade};
    }
    
    
    
}
