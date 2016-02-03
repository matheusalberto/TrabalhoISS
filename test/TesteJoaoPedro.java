import controller.CompostoController;
import dao.CompostoDao;
import dao.ProdutoDao;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Composto;
import model.Fornecedor;
import model.Produto;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteJoaoPedro {
    
    private final NumberFormat nf = new DecimalFormat("###,##0.00");
    @Test
    public void testeToArray() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(1);
        fornecedor.setNome("Abeline");
        fornecedor.setCnpj("10.784.655/0001-51");
        fornecedor.setEmail("abeline@hotmai.com");
        fornecedor.setEndereco("Rua dois");
        fornecedor.setTelefone("(44)3031-9867");

        Object[] obj = new Object[]{1,"Abeline","abeline@hotmai.com","(44)3031-9867","Rua dois"};

        Assert.assertArrayEquals(obj, fornecedor.toArray());
    }
    
    @Test
    public void testeCalcularMaoDeObra(){
        int tamListComp = 1;
        double total = 40.0;
        if (tamListComp <= 5) {
            total = total + (total * 0.10); //até 5 compostos: 10% de mão de obra
        } else if (tamListComp <= 10) {
            total = total + (total * 0.15); //de 6 a 10 compostos: 15% de mão de obra
        } else if (tamListComp > 10) {
            total = total + (total * 0.20); // mais de 10 compostos: 20% de mão de obra
        }
        
        CompostoController compostoController = new CompostoController();
        total = compostoController.calcularMaoDeObra(40, 1);
        Assert.assertEquals(44,total,44);
        
    }
    
    
    
    
}
