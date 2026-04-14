package VISUAL;

import LOGICA.UsuarioDAO;
import javax.swing.JOptionPane;
import LOGICA.Usuario;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    public Login() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_login = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        lb_pass = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        psw_pass = new javax.swing.JPasswordField();
        btn_ini = new javax.swing.JButton();
        lblSoporte = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN RENT CAR");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setMaximumSize(new java.awt.Dimension(490, 260));

        lb_login.setBackground(new java.awt.Color(0, 0, 0));
        lb_login.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lb_login.setForeground(new java.awt.Color(0, 0, 0));
        lb_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_login.setText("LOGIN");

        lb_usuario.setBackground(new java.awt.Color(0, 0, 0));
        lb_usuario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_usuario.setForeground(new java.awt.Color(0, 0, 0));
        lb_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_usuario.setText("Usuario:");

        lb_pass.setBackground(new java.awt.Color(255, 255, 255));
        lb_pass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lb_pass.setForeground(new java.awt.Color(0, 0, 0));
        lb_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pass.setText("Contraseña:");

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });

        psw_pass.setOpaque(true);
        psw_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_passKeyPressed(evt);
            }
        });

        btn_ini.setBackground(new java.awt.Color(212, 212, 212));
        btn_ini.setForeground(new java.awt.Color(0, 0, 0));
        btn_ini.setText("INICIAR SESIÓN");
        btn_ini.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_ini.addActionListener(this::btn_iniActionPerformed);

        lblSoporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoporte.setText("Contactar con Soporte");
        lblSoporte.setForeground(java.awt.Color.BLUE);
        lblSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSoporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoporteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lb_login, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lb_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(psw_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(btn_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lblSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lb_login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(psw_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblSoporte))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/images.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniActionPerformed
    String user = txt_usuario.getText();
    String pass = new String(psw_pass.getPassword());

    UsuarioDAO archivo = new UsuarioDAO();

    Usuario userLog = archivo.validarUsuario(user, pass);

    if (userLog != null) {

        Menu m = new Menu();

        m.setNombreUsuario(userLog.nombre + " " + userLog.apellido);
        m.setAcceso(userLog.acceso);

        m.setVisible(true);
        this.dispose();

    } else {
        JOptionPane.showMessageDialog(this, "Datos incorrectos");
    }
        //CODIGO VIEJO DE BTN LOGIN
    /*String user = txt_usuario.getText();
    String pass = new String(psw_pass.getPassword());

    UsuarioDAO archivo = new UsuarioDAO();

    if (archivo.validarUsuario(user, pass)) {
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Datos incorrectos");
        }*/
    }//GEN-LAST:event_btn_iniActionPerformed

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
        psw_pass.requestFocus();
        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void psw_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psw_passKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btn_ini.doClick();
        }
    }//GEN-LAST:event_psw_passKeyPressed

    private void lblSoporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoporteMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this,"Contacta al soporte al número: +1 (809) 123-4567","Soporte Técnico",javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblSoporteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_pass;
    private javax.swing.JLabel lb_usuario;
    private javax.swing.JLabel lblSoporte;
    private javax.swing.JPasswordField psw_pass;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
