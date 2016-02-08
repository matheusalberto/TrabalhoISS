package br.com.bean;

import br.com.dao.ClienteDao;
import br.com.model.Cliente;
import br.com.util.ValidarCpf;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ClienteBean {

    private Cliente cliente = new Cliente();
    private ClienteDao clienteDao = new ClienteDao();

    public ClienteBean() {
    }
    
    public String email(){
        return "email";
    }

    public String cadastrar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if(cliente.getNome().isEmpty()){
            ctx.addMessage("mensagemErro", new FacesMessage("Digite o nome!"));
            return "";
        }
        if(cliente.getCpf().isEmpty()){
            ctx.addMessage("mensagemErro", new FacesMessage("Digite o cpf!"));
            return "";
        } else if (!ValidarCpf.isCPF(cliente.getCpf())){
            ctx.addMessage("mensagemErro", new FacesMessage("CPF inválido!"));
            return "";
        }     
        if(cliente.getTelefone().length() != 10){
            ctx.addMessage("mensagemErro", new FacesMessage("Telefone inválido!"));
            return "";
        }
        
        String cpf = cliente.getCpf().substring(0, 3) + ".";
        cpf = cpf + cliente.getCpf().substring(3, 6) + ".";
        cpf = cpf + cliente.getCpf().substring(6, 9) + "-";
        cpf = cpf + cliente.getCpf().substring(9, 11);
        cliente.setCpf(cpf);
        
        String telefone = "(" + cliente.getTelefone().substring(0,2) + ")";
        telefone = telefone + cliente.getTelefone().substring(2, 6) + "-";
        telefone = telefone + cliente.getTelefone().substring(6, 10);
        cliente.setTelefone(telefone);
        
        String salvar = clienteDao.salvar(cliente);        
        switch (salvar) {            
            case "SUCESSO":
                ctx.addMessage("mensagemSucesso", new FacesMessage("Cliente cadastrado com sucesso!"));
                break;
            case "FALHA_CPF":
                ctx.addMessage("mensagemCpfExistente", new FacesMessage("CPF já existente!"));
                break;
            default:
                ctx.addMessage("mensagemErro", new FacesMessage("Algo deu errado, tente novamente!"));
                break;
        }
        cliente.setNome(null);
        cliente.setEndereco(null);
        cliente.setCpf(null);
        cliente.setEmail(null);
        cliente.setTelefone(null);
        return "index";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
