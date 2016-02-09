
/**
 *
 * @author Thiago
 */
import controller.PagamentoController;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import model.Funcionario;
import org.junit.Assert;
import org.junit.Test;

public class TestesMoraes {
    
    private final NumberFormat nf = new DecimalFormat("###,##0.00");

    
    @Test
    public void testeCalculaDesconto(){
        PagamentoController pag = new PagamentoController();
        JLabel txtTotal = new JLabel();
        JFormattedTextField txtDesconto = new JFormattedTextField();
        String total = null;
        
        txtTotal.setText("10,00");
        txtDesconto.setText("5,00");
        
        double valorTotal = 0.00;
        double valorDesconto = 0.00;
        
        valorTotal = Double.parseDouble(txtTotal.getText().replace(',','.'));
        
        valorDesconto = Double.parseDouble(txtDesconto.getText().replace(',','.'));
        
        valorTotal = valorTotal - valorDesconto;
        
        valorTotal = valorTotal * 100;
        valorTotal = Math.round(valorTotal);
        valorTotal = valorTotal / 100;
        total = String.valueOf(nf.format(valorTotal));
        
        Assert.assertEquals(total, pag.computarDesconto(txtTotal, txtDesconto));
    }
    
}
