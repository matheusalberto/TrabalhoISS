
import controller.PedidoController;
import dao.ProdutoDao;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.Produto;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestesMatheus {
    
     private final NumberFormat nf = new DecimalFormat("###,##0.00");

    @Test
    public void testeToArray() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setTelefone("(44)8835-5099");
        cliente.setNome("Pedro");
        cliente.setCpf("918.443.641-78");
        cliente.setSexo('M');
        cliente.setEndereco("RUA Z");
        cliente.setExcluido(0);
        cliente.setEmail("teste@teste.com");

        Object[] obj = new Object[]{1, "Pedro", "teste@teste.com", "(44)8835-5099"};

        Assert.assertArrayEquals(obj, cliente.toArray());
    }

    @Test
    public void testeAdd() {
        PedidoController pedidoController = new PedidoController();
        TableModel tableModelProduto;
        JTable tabelaProdutos = new JTable();
        JLabel texto = new JLabel();
        List<Produto> cesta = new ArrayList<>();
      
        
        Object[] colunas = new Object[]{"Código", "Nome", "Preço R$"};
        List<Produto> lista = new ArrayList<>();
        
        Produto p1 = new Produto();
        p1.setId(1);
        p1.setDescricao("PRODUTO TESTE");
        p1.setDataCompra(new Date());
        p1.setDataValidade(new Date());
        p1.setFornecedor("FORNECEDOR TESTE");
        p1.setPrecoCompra(10.0);
        p1.setPrecoVenda(50.0);
        p1.setQuantidadeEstoque(10);
        
        lista.add(p1);
        
        Object[][] dados = new Object[lista.size()][3]; //Preenche os objetos para popular a tabela 
        int i = 0;
        for (Produto p : lista) {
            dados[i] = p.toArrayCompra();
            i++;
        }
        
        tableModelProduto = new DefaultTableModel(dados, colunas);
        tabelaProdutos.setModel(tableModelProduto);
        
        double total = 0;
        total = adicionarProdutoCesta(p1, 0, tabelaProdutos, total, texto, cesta);
        
        Assert.assertEquals(20.0, total, 20.0);
            
    }    
    
    public double adicionarProdutoCesta(Produto produto, int linhaSelecionada, JTable tabelaProdutos, double total, JLabel txtTotal, List<Produto> listaCesta) {
        
        if(produto == null){
            return -1;
        }
        if(produto.getPrecoVenda() < 0){
            return -2;  
        }
        total = Double.sum(total, produto.getPrecoVenda());
        total = total * 100;
        total = Math.round(total);
        total = total / 100;
        txtTotal.setText(nf.format(total));

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1); //Diminui a quantidade no estoque
        //produtoDao.atualizar(produto); //Atualiza estoque

        if (produto.getQuantidadeEstoque() <= 0) { //Se o estoque de determinado produto ficar com 0, retira ele da lista
            ((DefaultTableModel) tabelaProdutos.getModel()).removeRow(linhaSelecionada);
        }

        listaCesta.add(produto);
        return total;
    }


    public TestesMatheus() {
    }
}
