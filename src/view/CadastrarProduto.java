package view;

import controller.CompostoController;
import controller.ProdutoController;
import dao.ClienteDao;
import dao.FornecedorDao;
import dao.ProdutoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    CompostoController compController = new CompostoController();

    public CadastrarProduto() {
        initComponents();
        //controller.desabilitarErros(txtErro,txtSemDescricao, txtSemFornecedor, txtSemDataCompra, txtSemDataValida, txtSemQuantidade, txtSemPrecoCompra, txtSemPrecoVenda);

        controller.preencherComboBoFornecedor(cbFornecedor);

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
        txtSemFornecedor = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbUnidade = new javax.swing.JComboBox();
        cbUnidadeVenda = new javax.swing.JComboBox();
        btnProd = new javax.swing.JRadioButton();
        btnComp = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtSemDataValida1 = new javax.swing.JLabel();

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

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorActionPerformed(evt);
            }
        });

        txtSemFornecedor.setForeground(new java.awt.Color(255, 0, 0));
        txtSemFornecedor.setText("*");

        jLabel11.setText("Unidade de preço para a venda:");

        cbUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "un", "Kg", "g", "mg", "l", "ml" }));
        cbUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadeActionPerformed(evt);
            }
        });

        cbUnidadeVenda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "un", "g", "mg", "l", "ml" }));
        cbUnidadeVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadeVendaActionPerformed(evt);
            }
        });

        btnProd.setText("Produto");
        btnProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdActionPerformed(evt);
            }
        });

        btnComp.setText("Composto");
        btnComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo:");

        txtSemDataValida1.setForeground(new java.awt.Color(255, 0, 0));
        txtSemDataValida1.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtErro)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPrecoCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSemQuantidade)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbUnidadeVenda, 0, 340, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSemPrecoCompra)
                            .addComponent(txtSemPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDataCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                    .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDescricao)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(29, 29, 29)
                                .addComponent(btnProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnComp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSemDataValida1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSemDescricao)
                            .addComponent(txtSemFornecedor)
                            .addComponent(txtSemDataCompra)
                            .addComponent(txtSemDataValida))))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProd)
                    .addComponent(btnComp)
                    .addComponent(jLabel5)
                    .addComponent(txtSemDataValida1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSemDescricao)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtSemFornecedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtSemDataCompra, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemDataValida))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSemQuantidade)
                    .addComponent(cbUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbUnidadeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(txtErro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        if (btnProd.isSelected()) {
            controller.cadastrarProduto(this, txtDescricao, cbFornecedor, txtDataCompra, txtDataValidade, txtQuantidade, txtPrecoCompra, txtPrecoVenda, cbUnidade, cbUnidadeVenda);
        }
        else if(btnComp.isSelected()){
            compController.cadastrarComposto(this, txtDescricao, cbFornecedor, txtDataCompra, txtDataValidade, txtQuantidade, txtPrecoCompra, txtPrecoVenda, cbUnidade, cbUnidadeVenda);
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFornecedorActionPerformed

    private void cbUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadeActionPerformed

    }//GEN-LAST:event_cbUnidadeActionPerformed

    private void cbUnidadeVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadeVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUnidadeVendaActionPerformed

    private void btnCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompActionPerformed
        if (btnComp.isSelected()) {
            btnProd.setEnabled(false);
        }
        else{
            btnProd.setEnabled(true);
        }
      
    }//GEN-LAST:event_btnCompActionPerformed

    private void btnProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdActionPerformed

        if (btnProd.isSelected()) {
            cbUnidade.setEnabled(false);
            cbUnidadeVenda.setEnabled(false);
            btnComp.setEnabled(false);
        }
        else{
            btnComp.setEnabled(true);
        }

    }//GEN-LAST:event_btnProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnComp;
    private javax.swing.JRadioButton btnProd;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JComboBox cbUnidade;
    private javax.swing.JComboBox cbUnidadeVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel txtSemDataValida1;
    private javax.swing.JLabel txtSemDescricao;
    private javax.swing.JLabel txtSemFornecedor;
    private javax.swing.JLabel txtSemPrecoCompra;
    private javax.swing.JLabel txtSemPrecoVenda;
    private javax.swing.JLabel txtSemQuantidade;
    // End of variables declaration//GEN-END:variables
}
