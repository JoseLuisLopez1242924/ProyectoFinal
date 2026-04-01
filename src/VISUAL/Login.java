/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(490, 260));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_login.setBackground(new java.awt.Color(0, 0, 0));
        lb_login.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lb_login.setForeground(new java.awt.Color(0, 0, 0));
        lb_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_login.setText("LOGIN");
        jPanel1.add(lb_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 44, 229, 35));

        lb_usuario.setBackground(new java.awt.Color(0, 0, 0));
        lb_usuario.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        lb_usuario.setForeground(new java.awt.Color(0, 0, 0));
        lb_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_usuario.setText("Usuario:");
        jPanel1.add(lb_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 112, 97, 33));

        lb_pass.setBackground(new java.awt.Color(255, 255, 255));
        lb_pass.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        lb_pass.setForeground(new java.awt.Color(0, 0, 0));
        lb_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pass.setText("Contraseña:");
        jPanel1.add(lb_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 163, 97, 33));

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 116, 220, -1));

        psw_pass.setOpaque(true);
        psw_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psw_passKeyPressed(evt);
            }
        });
        jPanel1.add(psw_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 167, 220, -1));

        btn_ini.setText("INICIAR SESIÓN");
        btn_ini.addActionListener(this::btn_iniActionPerformed);
        jPanel1.add(btn_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 214, 137, 36));

        lblSoporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoporte.setText("Contactar con Soporte");
        lblSoporte.setForeground(java.awt.Color.BLUE);
        lblSoporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSoporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoporteMouseClicked(evt);
            }
        });
        jPanel1.add(lblSoporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 256, 137, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/images.png"))); // NOI18N
        jLabel1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
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
