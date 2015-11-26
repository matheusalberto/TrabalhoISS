package view;

import controller.ClienteController;
import dao.ClienteDao;
import javax.swing.JOptionPane;
import model.Cliente;
import util.ValidarCpf;

public class CadastrarCliente extends javax.swing.JFrame {

    ClienteController controller = new ClienteController();

    public CadastrarCliente() {
        initComponents();
        controller.desabilitarErros(txtNaoDigitouCpf, txtNaoDigitouNome, txtNaoDigitouEmail, txtItensObrigatorios, txtNaoInformouSexo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        btnMasc = new javax.swing.JRadioButton();
        btnFemi = new javax.swing.JRadioButton();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtItensObrigatorios = new javax.swing.JLabel();
        txtNaoDigitouNome = new javax.swing.JLabel();
        txtNaoDigitouCpf = new javax.swing.JLabel();
        txtNaoDigitouEmail = new javax.swing.JLabel();
        txtNaoInformouSexo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO DE CLIENTE");

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("CPF:");

        jLabel5.setText("E-mail:");

        jLabel6.setText("Telefone:");

        jLabel7.setText("Sexo:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnMasc.setText("Masculino");
        btnMasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMascActionPerformed(evt);
            }
        });

        btnFemi.setText("Feminino");
        btnFemi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFemiActionPerformed(evt);
            }
        });

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

        txtItensObrigatorios.setForeground(new java.awt.Color(255, 0, 0));
        txtItensObrigatorios.setText("* Itens Obrigatórios");

        txtNaoDigitouNome.setForeground(new java.awt.Color(255, 0, 0));
        txtNaoDigitouNome.setText("*");

        txtNaoDigitouCpf.setForeground(new java.awt.Color(255, 0, 0));
        txtNaoDigitouCpf.setText("*");

        txtNaoDigitouEmail.setForeground(new java.awt.Color(255, 0, 0));
        txtNaoDigitouEmail.setText("*");

        txtNaoInformouSexo.setForeground(new java.awt.Color(255, 0, 0));
        txtNaoInformouSexo.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtEndereco)
                            .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(txtTelefone)
                            .addComponent(txtEmail)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMasc)
                                .addGap(18, 18, 18)
                                .addComponent(btnFemi))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNaoDigitouNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNaoDigitouCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNaoDigitouEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNaoInformouSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtItensObrigatorios)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaoDigitouNome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaoDigitouCpf))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNaoDigitouEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnMasc)
                    .addComponent(btnFemi)
                    .addComponent(txtNaoInformouSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(txtItensObrigatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCadastrar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMascActionPerformed
        controller.verificarSexo(btnMasc, btnFemi);
    }//GEN-LAST:event_btnMascActionPerformed

    private void btnFemiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFemiActionPerformed
        controller.verificarSexo(btnFemi, btnMasc);
    }//GEN-LAST:event_btnFemiActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Cliente cliente = new Cliente();               
        
        if (txtNome.getText().trim().isEmpty()) {
            controller.habilitarErro(txtNaoDigitouNome, txtItensObrigatorios);
        } else {
            controller.desabilitarErro(txtNaoDigitouNome);
            cliente.setNome(txtNome.getText());
        }
        if (txtCpf.getText().trim().isEmpty()) {
            controller.habilitarErro(txtNaoDigitouCpf, txtItensObrigatorios);
        } else if (ValidarCpf.isCPF(txtCpf.getText())) {
            controller.desabilitarErro(txtNaoDigitouCpf);
            cliente.setCpf(txtCpf.getText());
        } else {
            controller.habilitarErro(txtNaoDigitouCpf, txtItensObrigatorios);
            JOptionPane.showMessageDialog(this, "CPF inválido", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
        }
        if (txtEmail.getText().trim().isEmpty()) {
            controller.habilitarErro(txtNaoDigitouEmail, txtItensObrigatorios);
        } else {
            controller.desabilitarErro(txtNaoDigitouEmail);
            cliente.setEmail(txtEmail.getText());
        }
        if (!btnMasc.isSelected() && !btnFemi.isSelected()) {
            controller.habilitarErro(txtNaoInformouSexo, txtItensObrigatorios);
        } else {
            controller.desabilitarErro(txtNaoInformouSexo);
            if (btnMasc.isSelected()) {
                cliente.setSexo('M');
            } else {
                cliente.setSexo('F');
            }
        }

        cliente.setEndereco(txtEndereco.getText());
        cliente.setTelefone(txtTelefone.getText());
        ClienteDao clienteDao = new ClienteDao();
        
        if (!txtNaoDigitouCpf.isVisible() && !txtNaoDigitouEmail.isVisible() && !txtNaoDigitouNome.isVisible() && !txtNaoInformouSexo.isVisible()) {
            if (clienteDao.salvar(cliente).equals("SUCESSO")) {
                JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso.", "Sucesso", JOptionPane.DEFAULT_OPTION);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Tente novamente", "Algo deu errado", JOptionPane.DEFAULT_OPTION);
            }
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnFemi;
    private javax.swing.JRadioButton btnMasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JLabel txtItensObrigatorios;
    private javax.swing.JLabel txtNaoDigitouCpf;
    private javax.swing.JLabel txtNaoDigitouEmail;
    private javax.swing.JLabel txtNaoDigitouNome;
    private javax.swing.JLabel txtNaoInformouSexo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
