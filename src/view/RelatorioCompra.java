
package view;

import controller.RelatorioCompraController;
import javax.swing.JOptionPane;


public class RelatorioCompra extends javax.swing.JFrame {
    
    RelatorioCompraController controller = new RelatorioCompraController();

    public RelatorioCompra() {
        initComponents();
        txtNaoInformadoFiltro.setVisible(true);
        txtItensObrigatorios.setVisible(true);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCompra = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtNaoInformadoFiltro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtItensObrigatorios = new javax.swing.JLabel();
        txtDataIni = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        txtDataFim = new org.jdesktop.swingx.JXDatePicker();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNaoEntregue = new javax.swing.JRadioButton();
        btnNaoPagas = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCompra.setText("Compras Realizadas nesse intervalo de tempo");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtros para relatorio:");

        txtNaoInformadoFiltro.setForeground(new java.awt.Color(255, 0, 0));
        txtNaoInformadoFiltro.setText("*");

        jLabel4.setText("Data inicial:");

        txtItensObrigatorios.setForeground(new java.awt.Color(255, 0, 0));
        txtItensObrigatorios.setText("* Itens Obrigatórios");

        jLabel5.setText("Data final:");

        btnOk.setText("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("RELATÓRIO DE COMPRA");

        btnNaoEntregue.setText("Compras não entregues");
        btnNaoEntregue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoEntregueActionPerformed(evt);
            }
        });

        btnNaoPagas.setText("Compras que não foram pagas");
        btnNaoPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaoPagasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCompra)
                            .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(btnOk)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNaoPagas)
                                .addGap(74, 74, 74)
                                .addComponent(txtNaoInformadoFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnNaoEntregue)
                            .addComponent(txtItensObrigatorios))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompra)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNaoPagas)
                    .addComponent(txtNaoInformadoFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNaoEntregue)
                .addGap(18, 18, 18)
                .addComponent(txtItensObrigatorios)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOk))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        if (btnCompra.isSelected()) {
            btnNaoEntregue.setSelected(false);
            btnNaoPagas.setSelected(false);

        }
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (btnCompra.isSelected()) {
            controller.geraRelatorioCompra(this, txtDataIni.getDate(), txtDataFim.getDate());
        }
        else if(btnNaoPagas.isSelected()) {
            controller.geraRelatorioPagto(this, txtDataIni.getDate(),txtDataFim.getDate());
        }
        else if(btnNaoEntregue.isSelected()){
            controller.geraRelatorioEntregue(this, txtDataIni.getDate(),txtDataFim.getDate());
        }
        else{
            JOptionPane.showMessageDialog(this, "Existem campos obrigatorios", "Algo deu errado", JOptionPane.DEFAULT_OPTION);

        }

    }//GEN-LAST:event_btnOkActionPerformed

    private void btnNaoEntregueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoEntregueActionPerformed
        if (btnNaoEntregue.isSelected()) {
            btnCompra.setSelected(false);
            btnNaoPagas.setSelected(false);
        }
    }//GEN-LAST:event_btnNaoEntregueActionPerformed

    private void btnNaoPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaoPagasActionPerformed
        if (btnNaoPagas.isSelected()) {
            btnCompra.setSelected(false);
            btnNaoEntregue.setSelected(false);
        }
    }//GEN-LAST:event_btnNaoPagasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnCompra;
    private javax.swing.JRadioButton btnNaoEntregue;
    private javax.swing.JRadioButton btnNaoPagas;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private org.jdesktop.swingx.JXDatePicker txtDataFim;
    private org.jdesktop.swingx.JXDatePicker txtDataIni;
    private javax.swing.JLabel txtItensObrigatorios;
    private javax.swing.JLabel txtNaoInformadoFiltro;
    // End of variables declaration//GEN-END:variables
}
