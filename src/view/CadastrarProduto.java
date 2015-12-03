package view;

import controller.ProdutoController;
import dao.ClienteDao;
import dao.FornecedorDao;
import dao.ProdutoDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.Produto;

public class CadastrarProduto extends javax.swing.JFrame {

    ProdutoController controller = new ProdutoController();

    public CadastrarProduto() {
        initComponents();
        controller.desabilitarErros(txtErro, txtSemDescricao, txtSemDataCompra, txtSemDataValida, txtSemQuantidade, txtSemPrecoCompra, txtSemPrecoVenda);
        
        //LISTANDO NO COMBO BOX
        List<Fornecedor> list = new FornecedorDao().listar(""); //PEGO TODOS OS FORNECEDORES CADASTRADOS
        List<String> nomes = new ArrayList<>(); 
        for (Fornecedor list1 : list) { 
            nomes.add(list1.getNome()); //PEGO APENAS OS NOMES DOS FORNECEDORES
        }
        for (String nome : nomes) {
            cbFornecedor.addItem(nome); //ADICIONO ELES NO COMBO BOX
        }
        //PRA PEGAR O QUE ESTA DENTRO DO COMBO BOX FAZ cbFornecedor.getSelectedItem()
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtPrecoCompra = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtErro = new javax.swing.JLabel();
        txtSemDescricao = new javax.swing.JLabel();
        txtSemDataCompra = new javax.swing.JLabel();
        txtSemDataValida = new javax.swing.JLabel();
        txtSemQuantidade = new javax.swing.JLabel();
        txtSemPrecoCompra = new javax.swing.JLabel();
        txtSemPrecoVenda = new javax.swing.JLabel();
        txtDataCompra = new javax.swing.JFormattedTextField();
        txtDataValidade = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE PRODUTO");

        jLabel2.setText("Descrição:");

        jLabel7.setText("Data de compra:");

        jLabel8.setText("Quantidade:");

        jLabel9.setText("Preço de compra:");

        jLabel10.setText("Preço de venda:");

        jLabel3.setText("Data de validade:");

        btnCadastrar.setText("OK");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtErro.setForeground(new java.awt.Color(255, 0, 0));
        txtErro.setText("Todos os campos são obrigatórios");

        txtSemDescricao.setForeground(new java.awt.Color(255, 0, 0));
        txtSemDescricao.setText("*");

        txtSemDataCompra.setForeground(new java.awt.Color(255, 0, 0));
        txtSemDataCompra.setText("*");

        txtSemDataValida.setForeground(new java.awt.Color(255, 0, 0));
        txtSemDataValida.setText("*");

        txtSemQuantidade.setForeground(new java.awt.Color(255, 0, 0));
        txtSemQuantidade.setText("*");

        txtSemPrecoCompra.setForeground(new java.awt.Color(255, 0, 0));
        txtSemPrecoCompra.setText("*");

        txtSemPrecoVenda.setForeground(new java.awt.Color(255, 0, 0));
        txtSemPrecoVenda.setText("*");

        try {
            txtDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Fornecedor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3)
                                    .addComponent(txtErro)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(btnCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDataValidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(txtDataCompra, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(cbFornecedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSemDescricao)
                            .addComponent(txtSemDataCompra)
                            .addComponent(txtSemDataValida)
                            .addComponent(txtSemQuantidade)
                            .addComponent(txtSemPrecoCompra)
                            .addComponent(txtSemPrecoVenda)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1)))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSemDataCompra, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSemDataValida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemQuantidade))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtSemPrecoCompra))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemPrecoVenda))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCadastrar)
                    .addComponent(txtErro))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        Produto produto = new Produto();

        try {
            if (txtDescricao.getText().trim().isEmpty()) {
                controller.habilitarErro(txtSemDescricao, txtErro);
            } else {
                controller.desabilitarErro(txtSemDescricao);
                produto.setDescricao(txtDescricao.getText());
            }

            if (txtDataCompra.getText().equals("  /  /    ")) {
                controller.habilitarErro(txtSemDataCompra, txtErro);
            } else {
                controller.desabilitarErro(txtSemDataCompra);
                Calendar d = Calendar.getInstance();
                DateFormat f = DateFormat.getDateInstance();
                String data;
                data = txtDataCompra.getText();
                Date dataCorreta;
                dataCorreta = f.parse(data);
                produto.setDataCompra(dataCorreta);
            }

            if (txtDataValidade.getText().equals("  /  /    ")) {
                controller.habilitarErro(txtSemDataValida, txtErro);
            } else {
                controller.desabilitarErro(txtSemDataValida);
                Calendar d = Calendar.getInstance();
                DateFormat f = DateFormat.getDateInstance();
                String data;
                data = txtDataValidade.getText();
                Date dataCorreta;
                dataCorreta = f.parse(data);
                produto.setDataValidade(dataCorreta);
            }

            if (txtQuantidade.getText().trim().isEmpty()) {
                controller.habilitarErro(txtSemQuantidade, txtErro);
            } else {
                controller.desabilitarErro(txtSemQuantidade);
                produto.setQuantidadeEstoque(Integer.parseInt(txtQuantidade.getText()));
            }

            if (txtPrecoCompra.getText().trim().isEmpty()) {
                controller.habilitarErro(txtSemPrecoCompra, txtErro);
            } else {
                controller.desabilitarErro(txtSemPrecoCompra);
                produto.setPrecoCompra(Double.parseDouble(txtPrecoCompra.getText()));
            }

            if (txtPrecoVenda.getText().trim().isEmpty()) {
                controller.habilitarErro(txtSemPrecoVenda, txtErro);
            } else {
                controller.desabilitarErro(txtSemPrecoVenda);
                produto.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        ProdutoDao produtoDao = new ProdutoDao();
        if (!txtSemDescricao.isVisible() && !txtSemDataCompra.isVisible() && !txtSemDataValida.isVisible() && !txtSemQuantidade.isVisible() && !txtSemPrecoCompra.isVisible() && !txtSemPrecoVenda.isVisible()) {
            if (produtoDao.salvar(produto).equals("SUCESSO")) {
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
            }
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField txtDataCompra;
    private javax.swing.JFormattedTextField txtDataValidade;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JLabel txtErro;
    private javax.swing.JTextField txtPrecoCompra;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JLabel txtSemDataCompra;
    private javax.swing.JLabel txtSemDataValida;
    private javax.swing.JLabel txtSemDescricao;
    private javax.swing.JLabel txtSemPrecoCompra;
    private javax.swing.JLabel txtSemPrecoVenda;
    private javax.swing.JLabel txtSemQuantidade;
    // End of variables declaration//GEN-END:variables
}
