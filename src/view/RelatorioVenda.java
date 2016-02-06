
package view;

import controller.ClienteController;
import controller.FuncionarioController;

import controller.RelatorioVendaController;
import dao.ClienteDao;
import dao.FuncionarioDao;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.Funcionario;

public class RelatorioVenda extends javax.swing.JFrame {
    
    private final ClienteController controllerC = new ClienteController();
    private final TableModel tableModelCliente = new DefaultTableModel();
    private List<Cliente> listaCliente;
    private String clientes;
    
    private final FuncionarioController controllerF = new FuncionarioController();
    private final TableModel tableModelFuncionario = new DefaultTableModel();
    private List<Funcionario> listaFuncionario;
    private String funcionarios;
   // RelatorioPedidoController controller = new RelatorioPedidoController();
    RelatorioVendaController controller = new RelatorioVendaController();
    
    public RelatorioVenda() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btkOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscaC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btnOkC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        btnOkF = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDataIni = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        txtDataFim = new org.jdesktop.swingx.JXDatePicker();
        btnVenda = new javax.swing.JRadioButton();
        btnVendaF = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnVendaC = new javax.swing.JRadioButton();
        txtNaoInformadoFiltro = new javax.swing.JLabel();
        txtItensObrigatorios = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btkOk.setText("OK");
        btkOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite o nome do cliente:");

        txtBuscaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaCKeyPressed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaClientes);

        btnOkC.setText("OK");
        btnOkC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkCActionPerformed(evt);
            }
        });

        jLabel2.setText("Digite o nome do funcionario:");

        txtBuscaF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaFKeyPressed(evt);
            }
        });

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabelaFuncionarios);

        btnOkF.setText("OK");
        btnOkF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkFActionPerformed(evt);
            }
        });

        jLabel4.setText("Data inicial:");

        jLabel5.setText("Data final:");

        btnVenda.setText("Vendas em geral");
        btnVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaActionPerformed(evt);
            }
        });

        btnVendaF.setText("Vedas realizadas por funcionario selecionado");
        btnVendaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaFActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtros para relatorio:");

        btnVendaC.setText("Vendas para cliente selecionado");
        btnVendaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaCActionPerformed(evt);
            }
        });

        txtNaoInformadoFiltro.setForeground(new java.awt.Color(255, 0, 0));
        txtNaoInformadoFiltro.setText("*");

        txtItensObrigatorios.setForeground(new java.awt.Color(255, 0, 0));
        txtItensObrigatorios.setText("* Itens Obrigatórios");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("RELATÓRIO DE VENDA");

        tnCancelar.setText("Cancelar");
        tnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtBuscaC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnOkC, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBuscaF, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnOkF, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tnCancelar)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVendaC)
                                        .addGap(74, 74, 74)
                                        .addComponent(txtNaoInformadoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtItensObrigatorios)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnVenda)
                                    .addComponent(btnVendaF)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btkOk)
                                        .addGap(18, 18, 18)))))
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVenda)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVendaC)
                    .addComponent(txtNaoInformadoFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVendaF)
                .addGap(18, 18, 18)
                .addComponent(txtItensObrigatorios)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tnCancelar)
                    .addComponent(btkOk))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btkOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkOkActionPerformed
        if (btnVenda.isSelected()) {
            controller.geraRelatorioVenda(this, txtDataIni.getDate(), txtDataFim.getDate());
        }
        else if(btnVendaC.isSelected()) {
            
            int linhaSelecionada = tabelaClientes.getSelectedRow();
            

            if (linhaSelecionada >= 0) {
                int id = (int) tabelaClientes.getValueAt(linhaSelecionada, 0);
                Cliente cliente = new ClienteDao().localizar(id);
                
                //JOptionPane.showMessageDialog(this, ("aqui "+cliente.getId()), "Algo deu errado", JOptionPane.DEFAULT_OPTION);

        
                controller.geraRelatorioVendaC(this,id, txtDataIni.getDate(),txtDataFim.getDate());
            }
            else{
                 JOptionPane.showMessageDialog(this, "É necessario que um cliente seja seleceionado", "Algo deu errado", JOptionPane.DEFAULT_OPTION);

            }
        }
        else if(btnVendaF.isSelected()){
            int linhaSelecionada = tabelaFuncionarios.getSelectedRow();

            if (linhaSelecionada >= 0) {
                int id = (int) tabelaFuncionarios.getValueAt(linhaSelecionada, 0);
                Funcionario funcionario = new FuncionarioDao().localizar(id);
                controller.geraRelatorioVendaF(this, funcionario.getId(), txtDataIni.getDate(), txtDataFim.getDate());
            }
            else{
                 JOptionPane.showMessageDialog(this, "É necessario que um funcionario seja seleceionado", "Algo deu errado", JOptionPane.DEFAULT_OPTION);

            }
        }    
        else{
            JOptionPane.showMessageDialog(this, "Existem campos obrigatorios", "Algo deu errado", JOptionPane.DEFAULT_OPTION);

        }
        
    }//GEN-LAST:event_btkOkActionPerformed

    private void txtBuscaCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaCKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnOkC.doClick();
        }
    }//GEN-LAST:event_txtBuscaCKeyPressed

    private void btnOkCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkCActionPerformed
        clientes = txtBuscaC.getText().trim();
        ClienteDao dao = new ClienteDao();
        listaCliente = dao.listar(clientes);
        controllerC.preencherTabela(listaCliente, tableModelCliente, tabelaClientes);
    }//GEN-LAST:event_btnOkCActionPerformed

    private void txtBuscaFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnOkF.doClick();
        }
    }//GEN-LAST:event_txtBuscaFKeyPressed

    private void btnOkFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkFActionPerformed
        funcionarios = txtBuscaF.getText().trim();
        FuncionarioDao dao = new FuncionarioDao();
        listaFuncionario = dao.listar(funcionarios);

        controllerF.preencherTabela(listaFuncionario, tableModelFuncionario, tabelaFuncionarios);
    }//GEN-LAST:event_btnOkFActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        if (btnVenda.isSelected()) {
            btnVendaF.setSelected(false);
            btnVendaC.setSelected(false);

        }
    }//GEN-LAST:event_btnVendaActionPerformed

    private void btnVendaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaFActionPerformed
        if (btnVendaF.isSelected()) {
            btnVenda.setSelected(false);
            btnVendaC.setSelected(false);
        }
    }//GEN-LAST:event_btnVendaFActionPerformed

    private void btnVendaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaCActionPerformed
        if (btnVendaC.isSelected()) {
            btnVenda.setSelected(false);
            btnVendaF.setSelected(false);
        }
    }//GEN-LAST:event_btnVendaCActionPerformed

    private void tnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_tnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btkOk;
    private javax.swing.JButton btnOkC;
    private javax.swing.JButton btnOkF;
    private javax.swing.JRadioButton btnVenda;
    private javax.swing.JRadioButton btnVendaC;
    private javax.swing.JRadioButton btnVendaF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JButton tnCancelar;
    private javax.swing.JTextField txtBuscaC;
    private javax.swing.JTextField txtBuscaF;
    private org.jdesktop.swingx.JXDatePicker txtDataFim;
    private org.jdesktop.swingx.JXDatePicker txtDataIni;
    private javax.swing.JLabel txtItensObrigatorios;
    private javax.swing.JLabel txtNaoInformadoFiltro;
    // End of variables declaration//GEN-END:variables
}
