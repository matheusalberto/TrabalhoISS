package br.com.bean;

import br.com.dao.ClienteDao;
import br.com.model.Texto;
import br.com.util.Email;
import br.com.util.Email2;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TextoBean {
    
    private Texto texto = new Texto();
    private ClienteDao clienteDao = new ClienteDao();
    
    public TextoBean() {
    }
    
    public String enviar(){
        List<String> emails;
        emails = clienteDao.listar();
        Email2.Email(emails, texto.getTexto(), texto.getAssunto());
        return "index";
    }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }    
}
