package view;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private final String nome;
    private final int id;

    public TelaPrincipal(String nomeFuncionario, int idFuncionario) {
        initComponents();
        txtId.setText("[" + idFuncionario + "] ");
        txtFuncionarioAutenticado.setText(nomeFuncionario);
        nome = nomeFuncionario;
        id = idFuncionario;                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        labelUsuario = new javax.swing.JLabel();
        btnPedido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFuncionarioAutenticado = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroFuncionario = new javax.swing.JMenuItem();
        menuCadastroCliente = new javax.swing.JMenuItem();
        menuCadastroFornecedor = new javax.swing.JMenuItem();
        menuCadastroProduto = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemFornecedor = new javax.swing.JMenuItem();
        menuItemFuncionario = new javax.swing.JMenuItem();
        menuItemProduto = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuVenda = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("estou aqui");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPedido.setText("Pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        jLabel1.setText("Funcionário Autenticado:");

        menuCadastro.setText("Cadastros");
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });

        menuCadastroFuncionario.setText("Funcionario");
        menuCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroFuncionario);

        menuCadastroCliente.setText("Cliente");
        menuCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroCliente);

        menuCadastroFornecedor.setText("Fornecedor");
        menuCadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroFornecedorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroFornecedor);

        menuCadastroProduto.setText("Produto");
        menuCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroProduto);

        jMenuBar1.add(menuCadastro);

        menuConsulta.setText("Consultas");

        menuItemCliente.setText("Clientes");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuConsulta.add(menuItemCliente);

        menuItemFornecedor.setText("Fornecedor");
        menuItemFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFornecedorActionPerformed(evt);
            }
        });
        menuConsulta.add(menuItemFornecedor);

        menuItemFuncionario.setText("Funcionário");
        menuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFuncionarioActionPerformed(evt);
            }
        });
        menuConsulta.add(menuItemFuncionario);

        menuItemProduto.setText("Produto");
        menuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutoActionPerformed(evt);
            }
        });
        menuConsulta.add(menuItemProduto);

        jMenuBar1.add(menuConsulta);

        menuRelatorio.setText("Relatorios");
        jMenuBar1.add(menuRelatorio);

        menuVenda.setText("Vendas");
        jMenuBar1.add(menuVenda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnPedido)
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFuncionarioAutenticado)
                .addGap(47, 47, 47)
                .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtFuncionarioAutenticado)
                        .addComponent(txtId))
                    .addComponent(labelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(btnPedido)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroFuncionarioActionPerformed
        CadastrarFuncionario cadastrarFuncionario = new CadastrarFuncionario();
        cadastrarFuncionario.setVisible(true);
    }//GEN-LAST:event_menuCadastroFuncionarioActionPerformed

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed

    }//GEN-LAST:event_menuCadastroActionPerformed

    private void menuCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroClienteActionPerformed
        CadastrarCliente cadastrarCliente = new CadastrarCliente();
        cadastrarCliente.setVisible(true);
    }//GEN-LAST:event_menuCadastroClienteActionPerformed

    private void menuCadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroFornecedorActionPerformed
        CadastrarFornecedor cadastrarFornecedor = new CadastrarFornecedor();
        cadastrarFornecedor.setVisible(true);
    }//GEN-LAST:event_menuCadastroFornecedorActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        BuscaCliente buscaCliente = new BuscaCliente();
        buscaCliente.setVisible(true);
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFornecedorActionPerformed
        BuscaFornecedor buscaFornecedor = new BuscaFornecedor();
        buscaFornecedor.setVisible(true);
    }//GEN-LAST:event_menuItemFornecedorActionPerformed

    private void menuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFuncionarioActionPerformed
        BuscaFuncionario buscaFuncionario = new BuscaFuncionario();
        buscaFuncionario.setVisible(true);
    }//GEN-LAST:event_menuItemFuncionarioActionPerformed

    private void menuCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroProdutoActionPerformed
        CadastrarProduto cadastrarProduto = new CadastrarProduto();
        cadastrarProduto.setVisible(true);
    }//GEN-LAST:event_menuCadastroProdutoActionPerformed

    private void menuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutoActionPerformed
        BuscaProduto buscaProduto = new BuscaProduto();
        buscaProduto.setVisible(true);
    }//GEN-LAST:event_menuItemProdutoActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        RealizarPedido realizarPedido = new RealizarPedido(nome, id);
        realizarPedido.setVisible(true);
    }//GEN-LAST:event_btnPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JLabel labelUsuario;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCadastroCliente;
    private javax.swing.JMenuItem menuCadastroFornecedor;
    private javax.swing.JMenuItem menuCadastroFuncionario;
    private javax.swing.JMenuItem menuCadastroProduto;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemFornecedor;
    private javax.swing.JMenuItem menuItemFuncionario;
    private javax.swing.JMenuItem menuItemProduto;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuVenda;
    private javax.swing.JLabel txtFuncionarioAutenticado;
    private javax.swing.JLabel txtId;
    // End of variables declaration//GEN-END:variables
}
