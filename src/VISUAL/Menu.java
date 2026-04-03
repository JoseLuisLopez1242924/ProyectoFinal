package VISUAL;


public class Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());
    private int nivelAcceso = 1; // por defecto usuario normal

    public Menu() {
        initComponents();
        this.setExtendedState(Menu.MAXIMIZED_BOTH);
    }
    //BLOQUEO POR EL NIVEL DE ACCESO
    // Según el enunciado: 0 = Administrador, 1 = usuario normal
    public void setAcceso(int acceso) {
        this.nivelAcceso = acceso;
        if (acceso != 0) {
            // usuario normal: solo puede ver CLIENTES en mantenimientos
            menu_mant_usu.setVisible(false);
            jMenuItem1.setVisible(false); // GAMAS
            jMenuItem2.setVisible(false); // VEHICULOS
            jMenuItem4.setVisible(false); // OFERTAS
            // CLIENTES (jMenuItem3) queda visible
            menu_mov.setVisible(false);
            menu_cons.setVisible(false);
        }
    }
    //cargar nombre el laber
    public void setNombreUsuario(String nombre) {
    LblUsuario.setText("Bienvenido " + nombre + "!!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        LblUsuario = new javax.swing.JLabel();
        mb_menu = new javax.swing.JMenuBar();
        menu_ini = new javax.swing.JMenu();
        menu_mant = new javax.swing.JMenu();
        menu_mant_usu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menu_mov = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menu_cons = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        CambioSesion = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRINCIPAL");
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        addWindowStateListener(this::formWindowStateChanged);

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        LblUsuario.setBackground(new java.awt.Color(204, 204, 204));
        LblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        LblUsuario.setText("USUARIO");
        LblUsuario.setToolTipText("");

        mb_menu.setBackground(new java.awt.Color(204, 204, 204));
        mb_menu.setToolTipText("");

        menu_ini.setText("INICIO");
        mb_menu.add(menu_ini);

        menu_mant.setText("MANTENIMIENTOS");

        menu_mant_usu.setText("USUARIOS");
        menu_mant_usu.addActionListener(this::menu_mant_usuActionPerformed);
        menu_mant.add(menu_mant_usu);

        jMenuItem1.setText("GAMAS");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        menu_mant.add(jMenuItem1);

        jMenuItem2.setText("VEHICULOS");
        menu_mant.add(jMenuItem2);

        jMenuItem3.setText("CLIENTES");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        menu_mant.add(jMenuItem3);

        jMenuItem4.setText("OFERTAS");
        menu_mant.add(jMenuItem4);

        mb_menu.add(menu_mant);

        menu_mov.setText("MOVIMIENTOS");

        jMenuItem5.setText("RESERVAS");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        menu_mov.add(jMenuItem5);

        jMenuItem6.setText("RECEPCION");
        menu_mov.add(jMenuItem6);

        mb_menu.add(menu_mov);

        menu_cons.setText("CONSULTAS");

        jMenuItem7.setText("CLIENTES");
        menu_cons.add(jMenuItem7);

        jMenuItem8.setText("ID CLIENTE");
        menu_cons.add(jMenuItem8);

        jMenuItem9.setText("RANGO");
        menu_cons.add(jMenuItem9);

        jMenuItem10.setText("VEHICULOS");
        menu_cons.add(jMenuItem10);

        jMenuItem11.setText("MATRICULA");
        menu_cons.add(jMenuItem11);

        jMenuItem12.setText("DISPONIBLES");
        menu_cons.add(jMenuItem12);

        jMenuItem13.setText("RENTADOS");
        menu_cons.add(jMenuItem13);

        jMenuItem14.setText("MARCA");
        menu_cons.add(jMenuItem14);

        jMenuItem15.setText("GAMA");
        menu_cons.add(jMenuItem15);

        jMenuItem16.setText("OFERTAS");
        menu_cons.add(jMenuItem16);

        jMenuItem17.setText("PRECIO");
        menu_cons.add(jMenuItem17);

        jMenuItem18.setText("FECHAS RESERVADAS");
        menu_cons.add(jMenuItem18);

        jMenuItem19.setText("DIAS RESERVADOS");
        menu_cons.add(jMenuItem19);

        jMenuItem20.setText("RECEPCION FECHA");
        menu_cons.add(jMenuItem20);

        mb_menu.add(menu_cons);

        mb_menu.add(javax.swing.Box.createHorizontalGlue());

        CambioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/log-out.png"))); // NOI18N
        CambioSesion.setAutoscrolls(true);
        CambioSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CambioSesion.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        CambioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CambioSesionMouseClicked(evt);
            }
        });
        CambioSesion.addActionListener(this::CambioSesionActionPerformed);
        CambioSesion.add(jSeparator1);

        mb_menu.add(CambioSesion);

        setJMenuBar(mb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 252, Short.MAX_VALUE))
            .addComponent(panel_menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblUsuario)
                .addGap(11, 11, 11))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_mant_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_mant_usuActionPerformed

    }//GEN-LAST:event_menu_mant_usuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        java.awt.EventQueue.invokeLater(() -> new FrmGama(nivelAcceso).setVisible(true));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> new FrmClientes(nivelAcceso).setVisible(true));
    }
    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        
    }//GEN-LAST:event_formWindowStateChanged

    private void CambioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambioSesionActionPerformed

    }//GEN-LAST:event_CambioSesionActionPerformed

    private void CambioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CambioSesionMouseClicked
     Login login = new Login();
    login.setVisible(true);

    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_CambioSesionMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu CambioSesion;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar mb_menu;
    private javax.swing.JMenu menu_cons;
    private javax.swing.JMenu menu_ini;
    private javax.swing.JMenu menu_mant;
    private javax.swing.JMenuItem menu_mant_usu;
    private javax.swing.JMenu menu_mov;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables
}
