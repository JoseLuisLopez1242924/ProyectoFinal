package VISUAL;

import LOGICA.VehiculoDAO;
import LOGICA.ClienteDAO;
import javax.swing.*;
import java.awt.*;

public class Menu extends javax.swing.JFrame {
    
    private int nivelAcceso = 1; // por defecto usuario normal

    public Menu() {
        initComponents();
        this.setExtendedState(Menu.MAXIMIZED_BOTH);
        aplicarEstiloCards();
        cargarDashboard();
    }
    //BLOQUEO POR EL NIVEL DE ACCESO
    public void setAcceso(int acceso) {
        this.nivelAcceso = acceso;
        if (acceso != 0) {
            MI_Mant_usu.setEnabled(false);
            MI_Mant_Gamas.setEnabled(false); // GAMAS
            MI_Mant_Vehiculos.setEnabled(false); // VEHICULOS
            Ofertas.setEnabled(false); // OFERTAS
            // CLIENTES (jMenuItem3) queda visible
            //menu_mov.setVisible(false);
            //menu_cons.setVisible(false);
        }
    }
    //cargar nombre el laber
    public void setNombreUsuario(String nombre) {
    LblUsuario.setText("Bienvenido " + nombre + "!!");
    }

    // ── DASHBOARD ────────────────────────────────────────────────────────────
    private void aplicarEstiloCards() {
        estilizarCard(lblVehiculos,   "🚗 Total Vehículos", "...", new Color(52, 152, 219));
        estilizarCard(lblDisponibles, "✅ Disponibles",      "...", new Color(39, 174, 96));
        estilizarCard(lblClientes,    "👤 Clientes",         "...", new Color(155, 89, 182));
    }

    private void estilizarCard(JLabel lbl, String titulo, String valor, Color color) {
        lbl.setOpaque(true);
        lbl.setBackground(color);
        lbl.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color.darker(), 2, true),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        lbl.setText("<html><div style='text-align:center;color:white;'>"
            + "<div style='font-size:10px;'>" + titulo + "</div>"
            + "<div style='font-size:20px; font-weight:bold; margin-top:2px;'>" + valor + "</div>"
            + "</div></html>");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setPreferredSize(new Dimension(110, 65));
    }

    private void cargarDashboard() {
        try {
            VehiculoDAO vDao = new VehiculoDAO();
            int total        = vDao.listar().size();
            int disponibles  = vDao.listarDisponibles().size();
            int clientes     = new ClienteDAO().listar().size();

            estilizarCard(lblVehiculos,   "🚗 Total Vehículos", String.valueOf(total),      new Color(52, 152, 219));
            estilizarCard(lblDisponibles, "✅ Disponibles",      String.valueOf(disponibles), new Color(39, 174, 96));
            estilizarCard(lblClientes,    "👤 Clientes",         String.valueOf(clientes),    new Color(155, 89, 182));
        } catch (Exception e) {
            // si falla la carga, los cards quedan con "..."
        }
    }
    // ─────────────────────────────────────────────────────────────────────────

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        lblVehiculos = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblDisponibles = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        mb_menu = new javax.swing.JMenuBar();
        menu_ini = new javax.swing.JMenu();
        menu_mant = new javax.swing.JMenu();
        MI_Mant_usu = new javax.swing.JMenuItem();
        MI_Mant_Gamas = new javax.swing.JMenuItem();
        MI_Mant_Vehiculos = new javax.swing.JMenuItem();
        Ofertas = new javax.swing.JMenuItem();
        MI_Mant_Cliente = new javax.swing.JMenuItem();
        menu_mov = new javax.swing.JMenu();
        MI_Reservas = new javax.swing.JMenuItem();
        MI_Recepcion = new javax.swing.JMenuItem();
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

        panel_menu.setBackground(new java.awt.Color(245, 247, 250));

        lblVehiculos.setText("VEHICULOS");
        lblClientes.setText("CLIENTES");
        lblDisponibles.setText("DISPONIBLES");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/images.png"))); // NOI18N

        // Panel central que se centra siempre, sin importar el tamaño de ventana
        panel_menu.setLayout(new java.awt.BorderLayout());

        javax.swing.JPanel pnlCentro = new javax.swing.JPanel(new java.awt.GridBagLayout());
        pnlCentro.setOpaque(false);
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        // Logo
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new java.awt.Insets(0, 0, 40, 0);
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        pnlCentro.add(jLabel1, gbc);

        // Cards
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(0, 20, 0, 20);
        gbc.gridx = 0; pnlCentro.add(lblVehiculos,   gbc);
        gbc.gridx = 1; pnlCentro.add(lblDisponibles, gbc);
        gbc.gridx = 2; pnlCentro.add(lblClientes,    gbc);

        panel_menu.add(pnlCentro, java.awt.BorderLayout.CENTER);

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

        MI_Mant_usu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/user.png"))); // NOI18N
        MI_Mant_usu.setText("USUARIOS");
        MI_Mant_usu.addActionListener(this::MI_Mant_usuActionPerformed);
        menu_mant.add(MI_Mant_usu);

        MI_Mant_Gamas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/chart-no-axes-gantt.png"))); // NOI18N
        MI_Mant_Gamas.setText("GAMAS");
        MI_Mant_Gamas.addActionListener(this::MI_Mant_GamasActionPerformed);
        menu_mant.add(MI_Mant_Gamas);

        MI_Mant_Vehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/car.png"))); // NOI18N
        MI_Mant_Vehiculos.setText("VEHICULOS");
        MI_Mant_Vehiculos.addActionListener(this::MI_Mant_VehiculosActionPerformed);
        menu_mant.add(MI_Mant_Vehiculos);

        Ofertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/badge-dollar-sign.png"))); // NOI18N
        Ofertas.setText("OFERTAS");
        Ofertas.addActionListener(this::OfertasActionPerformed);
        menu_mant.add(Ofertas);

        MI_Mant_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/users.png"))); // NOI18N
        MI_Mant_Cliente.setText("CLIENTE");
        MI_Mant_Cliente.addActionListener(this::MI_Mant_ClienteActionPerformed);
        menu_mant.add(MI_Mant_Cliente);

        mb_menu.add(menu_mant);

        menu_mov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/arrow-down-up.png"))); // NOI18N
        menu_mov.setText("MOVIMIENTOS");

        MI_Reservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/arrow-right-from-line.png"))); // NOI18N
        MI_Reservas.setText("RESERVAS");
        MI_Reservas.addActionListener(this::MI_ReservasActionPerformed);
        menu_mov.add(MI_Reservas);

        MI_Recepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/arrow-left-from-line.png"))); // NOI18N
        MI_Recepcion.setText("RECEPCION");
        MI_Recepcion.addActionListener(this::MI_RecepcionActionPerformed);
        menu_mov.add(MI_Recepcion);

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
        MI_Vehiculos.addActionListener(this::MI_VehiculosActionPerformed);
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

        // ContentPane con BorderLayout para que panel_menu ocupe todo y se centre
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().setBackground(new java.awt.Color(245, 247, 250));
        getContentPane().add(panel_menu, java.awt.BorderLayout.CENTER);

        // LblUsuario abajo a la izquierda
        javax.swing.JPanel pnlSur = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pnlSur.setBackground(new java.awt.Color(224, 224, 224));
        pnlSur.add(LblUsuario);
        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MI_Mant_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Mant_usuActionPerformed
    FrmUsuarios frm = new FrmUsuarios();
    frm.setVisible(true);
    }//GEN-LAST:event_MI_Mant_usuActionPerformed

    private void MI_Mant_GamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Mant_GamasActionPerformed
        java.awt.EventQueue.invokeLater(() -> new FrmGama(nivelAcceso).setVisible(true));
    }//GEN-LAST:event_MI_Mant_GamasActionPerformed

    private void MI_ReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ReservasActionPerformed
        new FrmReservas().setVisible(true);
    }//GEN-LAST:event_MI_ReservasActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        
    }//GEN-LAST:event_formWindowStateChanged

    private void MI_Mant_VehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Mant_VehiculosActionPerformed
    FrmVehiculos frm = new FrmVehiculos();
    frm.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_MI_Mant_VehiculosActionPerformed

    private void MI_Mant_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_Mant_ClienteActionPerformed
        FrmClientes frm = new FrmClientes();
        frm.setVisible(true);
    }//GEN-LAST:event_MI_Mant_ClienteActionPerformed

    private void menu_iniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_iniMouseClicked
     Login login = new Login();
    login.setVisible(true);

    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_menu_iniMouseClicked

    private void OfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OfertasActionPerformed
        new FrmOferta().setVisible(true);
    }//GEN-LAST:event_OfertasActionPerformed

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

    private void MI_VehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_VehiculosActionPerformed
        new FrmConsultaVehiculos().setVisible(true);
    }//GEN-LAST:event_MI_VehiculosActionPerformed

    private void MI_RecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_RecepcionActionPerformed
        new FrmResepcion().setVisible(true);
    }//GEN-LAST:event_MI_RecepcionActionPerformed

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
    private javax.swing.JMenuItem MI_Mant_Cliente;
    private javax.swing.JMenuItem MI_Mant_Gamas;
    private javax.swing.JMenuItem MI_Mant_Vehiculos;
    private javax.swing.JMenuItem MI_Mant_usu;
    private javax.swing.JMenuItem MI_Marca;
    private javax.swing.JMenuItem MI_Matricula;
    private javax.swing.JMenuItem MI_Ofertas;
    private javax.swing.JMenuItem MI_Precio;
    private javax.swing.JMenuItem MI_Rango;
    private javax.swing.JMenuItem MI_Recep_Fecha;
    private javax.swing.JMenuItem MI_Recepcion;
    private javax.swing.JMenuItem MI_Rent;
    private javax.swing.JMenuItem MI_Reser_Dias;
    private javax.swing.JMenuItem MI_Reser_Fecha;
    private javax.swing.JMenuItem MI_Reservas;
    private javax.swing.JMenuItem MI_Vehiculos;
    private javax.swing.JMenuItem Ofertas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblVehiculos;
    private javax.swing.JMenuBar mb_menu;
    private javax.swing.JMenu menu_cons;
    private javax.swing.JMenu menu_ini;
    private javax.swing.JMenu menu_mant;
    private javax.swing.JMenu menu_mov;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables

}
