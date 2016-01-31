package view;

import controller.PedidoController;
import controller.ProdutoController;
import dao.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Produto;

public class ManipularCompostos extends javax.swing.JFrame {
    private String nomeComposto;
    private final TableModel tableModelSelecao = new DefaultTableModel();
    private final TableModel tableModelManipulacao = new DefaultTableModel();
    private final ProdutoController produtoController = new ProdutoController();
    private double total = 0;
    private final List<Produto> listaCompostos = new ArrayList<>();

    public ManipularCompostos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtCompostos = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtPreco = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaSelecao = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaManipulacao = new javax.swing.JTable();
        cbUnidadeDesejada = new javax.swing.JComboBox();
        txtSemPrecoCompra = new javax.swing.JLabel();
        txtSemPrecoCompra1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manipulação De Compostos");

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 430));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Procure um Composto:");

        txtCompostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompostosActionPerformed(evt);
            }
        });
        txtCompostos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompostosKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Compostos Selecionados:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Adicionados a manipulação:");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnDelete.setMaximumSize(new java.awt.Dimension(65, 41));
        btnDelete.setMinimumSize(new java.awt.Dimension(65, 41));
        btnDelete.setPreferredSize(new java.awt.Dimension(65, 41));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Quantidade:");

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        txtPreco.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPreco.setText("0,00");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Nome/Descrição:");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setText("Preço: R$");

        btnFinalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        tabelaSelecao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabelaSelecao);

        tabelaManipulacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tabelaManipulacao);

        cbUnidadeDesejada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "un", "Kg", "g", "mg", "l", "ml" }));
        cbUnidadeDesejada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadeDesejadaActionPerformed(evt);
            }
        });

        txtSemPrecoCompra.setForeground(new java.awt.Color(255, 0, 0));
        txtSemPrecoCompra.setText("*");

        txtSemPrecoCompra1.setForeground(new java.awt.Color(255, 0, 0));
        txtSemPrecoCompra1.setText("*");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setText("+ taxa de mão de obra");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel17))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCompostos, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSemPrecoCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbUnidadeDesejada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSemPrecoCompra1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24)))
                                .addGap(50, 50, 50)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbUnidadeDesejada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSemPrecoCompra)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSemPrecoCompra1))
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(37, 37, 37)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPreco)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int linhaSelecionada = tabelaManipulacao.getSelectedRow();

        if (linhaSelecionada >= 0) {
            total = produtoController.removerCompostos(this, tabelaManipulacao, linhaSelecionada, total, txtPreco, listaCompostos);
            List<Produto> lista = new ProdutoDao().listarParaManipulacao(nomeComposto);
            Object[] colunas = new Object[]{"id", "Nome", "Quantidade","Estoque","Unidade"};
            produtoController.preencherTabelaManipulacao(tabelaManipulacao, tableModelManipulacao, colunas, listaCompostos);
            
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (txtQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Favor informar a quantidade", "Erro: quantidade não informada", JOptionPane.DEFAULT_OPTION);
        } else {
            
            int linhaSelecionada = tabelaSelecao.getSelectedRow();

            if (linhaSelecionada >= 0) {
                total = produtoController.adicionarCompostoManipulado(this, linhaSelecionada, tabelaSelecao, total, txtPreco, listaCompostos, txtQuantidade.getText(),cbUnidadeDesejada);
                Object[] colunas = new Object[]{"id", "Nome", "Quantidade(g ou ml)", "Estoque", "Unidade"};
                produtoController.preencherTabelaManipulacao(tabelaManipulacao, tableModelManipulacao, colunas, listaCompostos);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja cancelar a manipulação?", "Confirmação", JOptionPane.YES_OPTION);
        if (JOptionPane.YES_OPTION == opcao) {
            
            this.dispose();
            produtoController.cancelarManipulacao(listaCompostos);
            
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        /*if (txtNome.getText().equals("")) { //VAZIO, NÃO INFORMOU O NOME
            JOptionPane.showMessageDialog(this, "Favor inserir um nome para o produto final.", "Algo deu errado.", JOptionPane.ERROR_MESSAGE);
        } else if (listaCompostos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não é possível contnuar, não há compostos para serem manipulados. Favor inserir um composto!", "Algo deu errado.", JOptionPane.ERROR_MESSAGE);
        } else {
           
            produtoController.finalizarManipulacao(this,listaCompostos,total,txtNome.getText());
            
        }*/
            
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtCompostosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompostosKeyTyped

        String nomeComposto;
        nomeComposto = txtCompostos.getText().trim();
        List<Produto> lista = new ProdutoDao().listarParaManipulacao(nomeComposto); //Preenche uma lista com todos os compostos com base no nome digitado      
        Object[] colunas = new Object[]{"id", "Nome", "Preço R$", "Unid. venda", "Estoque", "Unidade"};
        produtoController.preencherTabelaCompostos(tabelaSelecao, tableModelSelecao, colunas, lista);

    }//GEN-LAST:event_txtCompostosKeyTyped

    private void txtCompostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompostosActionPerformed

    private void cbUnidadeDesejadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadeDesejadaActionPerformed

    }//GEN-LAST:event_cbUnidadeDesejadaActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(ManipularCompostos.DISPOSE_ON_CLOSE);
        produtoController.cancelarManipulacao(listaCompostos);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox cbUnidadeDesejada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaManipulacao;
    private javax.swing.JTable tabelaSelecao;
    private javax.swing.JTextField txtCompostos;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel txtPreco;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JLabel txtSemPrecoCompra;
    private javax.swing.JLabel txtSemPrecoCompra1;
    // End of variables declaration//GEN-END:variables
}
