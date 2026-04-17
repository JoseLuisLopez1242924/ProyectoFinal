package VISUAL;

import java.awt.event.ActionEvent;


public class Menu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());
    private int nivelAcceso = 1; // por defecto usuario normal

    public Menu() {
        initComponents();
        this.setExtendedState(Menu.MAXIMIZED_BOTH);
    }
    //BLOQUEO POR EL NIVEL DE ACCESO
    public void setAcceso(int acceso) {
        this.nivelAcceso = acceso;
        if (acceso != 0) {
            menu_mant_usu.setEnabled(false);
            jMenuItem1.setEnabled(false); // GAMAS
            jMenuItem2.setEnabled(false); // VEHICULOS
            jMenuItem4.setEnabled(false); // OFERTAS
            // CLIENTES (jMenuItem3) queda visible
            //menu_mov.setVisible(false);
            //menu_cons.setVisible(false);
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
        jMenuItem4 = new javax.swing.JMenuItem();
        btnCliente = new javax.swing.JMenuItem();
        menu_mov = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menu_cons = new javax.swing.JMenu();
        MI_Cliente = new javax.swing.JMenuItem();
        MI_ID_Cliente = new javax.swing.JMenuItem();
        MI_Rango = new javax.swing.JMenuItem();
        MI_Vehiculos = new javax.swing.JMenuItem();
        MI_Matricula = new javax.swing.JMenuItem();
        MI_Dispo = new javax.swing.JMenuItem();
        MI_Rent = new javax.swing.JMenuItem();
        MI_Marca = new javax.swing.JMenuItem();
        MI_Gama = new javax.swing.JMenuItem();
        MI_Ofertas = new javax.swing.JMenuItem();
        MI_Precio = new javax.swing.JMenuItem();
        MI_Reser_Fecha = new javax.swing.JMenuItem();
        MI_Reser_Dias = new javax.swing.JMenuItem();
        MI_Recep_Fecha = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRINCIPAL");
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        addWindowStateListener(this::formWindowStateChanged);

        panel_menu.setBackground(new java.awt.Color(255, 255, 255));

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
        LblUsuario.setText("USUARIO");
        LblUsuario.setToolTipText("");

        mb_menu.setBackground(new java.awt.Color(224, 224, 224));
        mb_menu.setToolTipText("");
        mb_menu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        menu_ini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/user-key (1).png"))); // NOI18N
        menu_ini.setText("SESION");
        menu_ini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_iniMouseClicked(evt);
            }
        });
        mb_menu.add(menu_ini);

        menu_mant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/bolt.png"))); // NOI18N
        menu_mant.setText("MANTENIMIENTOS");

        menu_mant_usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/user.png"))); // NOI18N
        menu_mant_usu.setText("USUARIOS");
        menu_mant_usu.addActionListener(this::menu_mant_usuActionPerformed);
        menu_mant.add(menu_mant_usu);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/chart-no-axes-gantt.png"))); // NOI18N
        jMenuItem1.setText("GAMAS");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        menu_mant.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/car.png"))); // NOI18N
        jMenuItem2.setText("VEHICULOS");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        menu_mant.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/badge-dollar-sign.png"))); // NOI18N
        jMenuItem4.setText("OFERTAS");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        menu_mant.add(jMenuItem4);

        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/users.png"))); // NOI18N
        btnCliente.setText("CLIENTE");
        btnCliente.addActionListener(this::btnClienteActionPerformed);
        menu_mant.add(btnCliente);

        mb_menu.add(menu_mant);

        menu_mov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/arrow-down-up.png"))); // NOI18N
        menu_mov.setText("MOVIMIENTOS");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/arrow-right-from-line.png"))); // NOI18N
        jMenuItem5.setText("RESERVAS");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        menu_mov.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/arrow-left-from-line.png"))); // NOI18N
        jMenuItem6.setText("RECEPCION");
        jMenuItem6.addActionListener(this::jMenuItem6ActionPerformed);
        menu_mov.add(jMenuItem6);

        mb_menu.add(menu_mov);

        menu_cons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/file-text.png"))); // NOI18N
        menu_cons.setText("CONSULTAS");

        MI_Cliente.setText("CLIENTES");
        MI_Cliente.addActionListener(this::MI_ClienteActionPerformed);
        menu_cons.add(MI_Cliente);

        MI_ID_Cliente.setText("ID CLIENTE");
        menu_cons.add(MI_ID_Cliente);

        MI_Rango.setText("RANGO ID CLIENTE");
        menu_cons.add(MI_Rango);

        MI_Vehiculos.setText("VEHICULOS");
        menu_cons.add(MI_Vehiculos);

        MI_Matricula.setText("MATRICULA");
        MI_Matricula.addActionListener(this::MI_MatriculaActionPerformed);
        menu_cons.add(MI_Matricula);

        MI_Dispo.setText("DISPONIBLES");
        MI_Dispo.addActionListener(this::MI_DispoActionPerformed);
        menu_cons.add(MI_Dispo);

        MI_Rent.setText("RENTADOS");
        MI_Rent.addActionListener(this::MI_RentActionPerformed);
        menu_cons.add(MI_Rent);

        MI_Marca.setText("MARCA");
        MI_Marca.addActionListener(this::MI_MarcaActionPerformed);
        menu_cons.add(MI_Marca);

        MI_Gama.setText("GAMA");
        MI_Gama.addActionListener(this::MI_GamaActionPerformed);
        menu_cons.add(MI_Gama);

        MI_Ofertas.setText("OFERTAS");
        menu_cons.add(MI_Ofertas);

        MI_Precio.setText("PRECIO");
        menu_cons.add(MI_Precio);

        MI_Reser_Fecha.setText("RESERVA FECHAS");
        MI_Reser_Fecha.addActionListener(this::MI_Reser_FechaActionPerformed);
        menu_cons.add(MI_Reser_Fecha);

        MI_Reser_Dias.setText("RESERVA DIAS");
        menu_cons.add(MI_Reser_Dias);

        MI_Recep_Fecha.setText("RECEPCION FECHA");
        menu_cons.add(MI_Recep_Fecha);

        mb_menu.add(menu_cons);

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
    FrmUsuarios frm = new FrmUsuarios();
    frm.setVisible(true);
    }//GEN-LAST:event_menu_mant_usuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        java.awt.EventQueue.invokeLater(() -> new FrmGama(nivelAcceso).setVisible(true));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new FrmReserva(nivelAcceso).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        
    }//GEN-LAST:event_formWindowStateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    FrmVehiculos frm = new FrmVehiculos();
    frm.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        FrmClientes frm = new FrmClientes();
        frm.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void menu_iniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iniMouseClicked
     Login login = new Login();
    login.setVisible(true);

    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_menu_iniMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new FrmOferta().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void MI_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_ClienteActionPerformed

    private void MI_Reser_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Reser_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_Reser_FechaActionPerformed

    private void MI_MatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_MatriculaActionPerformed
        new FrmConsultaGama().setVisible(true);
    }//GEN-LAST:event_MI_MatriculaActionPerformed

    private void MI_DispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_DispoActionPerformed
        new FrmConsultaDisponibles().setVisible(true);
    }//GEN-LAST:event_MI_DispoActionPerformed

    private void MI_RentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RentActionPerformed
        new FrmConsultaRentados().setVisible(true);
    }//GEN-LAST:event_MI_RentActionPerformed

    private void MI_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_MarcaActionPerformed
        new FrmConsultaMarca().setVisible(true);
    }//GEN-LAST:event_MI_MarcaActionPerformed

    private void MI_GamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_GamaActionPerformed
        new FrmConsultaGama().setVisible(true);
    }//GEN-LAST:event_MI_GamaActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmConsultaMatricula().setVisible(true);
    }                                           

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmConsultaDisponibles().setVisible(true);
    }                                           

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmConsultaRentados().setVisible(true);
    }                                           

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmConsultaMarca().setVisible(true);
    }                                           

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmConsultaGama().setVisible(true);
    }                                           

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JMenuItem MI_Cliente;
    private javax.swing.JMenuItem MI_Dispo;
    private javax.swing.JMenuItem MI_Gama;
    private javax.swing.JMenuItem MI_ID_Cliente;
    private javax.swing.JMenuItem MI_Marca;
    private javax.swing.JMenuItem MI_Matricula;
    private javax.swing.JMenuItem MI_Ofertas;
    private javax.swing.JMenuItem MI_Precio;
    private javax.swing.JMenuItem MI_Rango;
    private javax.swing.JMenuItem MI_Recep_Fecha;
    private javax.swing.JMenuItem MI_Rent;
    private javax.swing.JMenuItem MI_Reser_Dias;
    private javax.swing.JMenuItem MI_Reser_Fecha;
    private javax.swing.JMenuItem MI_Vehiculos;
    private javax.swing.JMenuItem btnCliente;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuBar mb_menu;
    private javax.swing.JMenu menu_cons;
    private javax.swing.JMenu menu_ini;
    private javax.swing.JMenu menu_mant;
    private javax.swing.JMenuItem menu_mant_usu;
    private javax.swing.JMenu menu_mov;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables

    private void jMenuItem6ActionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
