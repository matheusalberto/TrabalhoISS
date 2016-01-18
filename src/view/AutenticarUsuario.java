package view;

import dao.FuncionarioDao;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Funcionario;

public class AutenticarUsuario extends javax.swing.JFrame {

    private final String loginPadrao = "admin";
    private final String senhaPadrao = "123456";

    public AutenticarUsuario() {
        initComponents();
        Funcionario funcionario = new Funcionario(loginPadrao, senhaPadrao);
        new FuncionarioDao().salvar(funcionario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FARMÁCIA DE MANIPULAÇÃO");

        jLabel2.setText("Login:");

        jLabel3.setText("Senha:");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogin)
                            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnOk))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        Funcionario func = new Funcionario();
        func.setLogin(txtLogin.getText());
        func.setSenha(String.valueOf(txtSenha.getPassword()));
        FuncionarioDao funcionario = new FuncionarioDao();
        String nome = funcionario.localizar(txtLogin.getText()).getNome();
        int id = funcionario.localizar(txtLogin.getText()).getId();
        if (new FuncionarioDao().consultar(func)) {
            TelaPrincipal telaPrincipal = new TelaPrincipal(nome, id);
            telaPrincipal.setVisible(true);
            this.dispose();
            //JOptionPane.showMessageDialog(this, "OPA, DEU BOM SIM!", "S U C E S S O !", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(this, "ALGO DEU ERRADO!", "T E N T E  N O V A M E N T E !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Funcionario func = new Funcionario();
            func.setLogin(txtLogin.getText());
            func.setSenha(String.valueOf(txtSenha.getPassword()));
            FuncionarioDao funcionario = new FuncionarioDao();
            String nome = funcionario.localizar(txtLogin.getText()).getNome();
            int id = funcionario.localizar(txtLogin.getText()).getId();

            if (new FuncionarioDao().consultar(func)) {
                TelaPrincipal telaPrincipal = new TelaPrincipal(nome, id);
                telaPrincipal.setVisible(true);
                this.dispose();
                //JOptionPane.showMessageDialog(this, "OPA, DEU BOM SIM!", "D E U  C E R T O !", JOptionPane.DEFAULT_OPTION);
            } else {
                JOptionPane.showMessageDialog(this, "ALGO DEU ERRADO!", "T E N T E  N O V A M E N T E !", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutenticarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
