
package VISUAL;

import LOGICA.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FrmReservas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmReservas.class.getName());       
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 
    private String idClienteSeleccionado   = "";
    private String matriculaSeleccionada   = "";
    private double precioVehiculoSeleccionado = 0.0;
    
    public FrmReservas() {
        initComponents();
        configurarFechas();
    }

    // CONFIGURACIÓN INICIAL
    private void configurarFechas() {
        // Fecha de hoy como valor por defecto
        txtFechaInicio.setText(LocalDate.now().format(FMT));
        txtFechaFin.setText(LocalDate.now().format(FMT));
    }
 
    // MÉTODOS PÚBLICOS LLAMADOS DESDE LOS FORMULARIOS HIJOS
 

    public void cargarCliente(String idCedula, String nombre, String apellidos, String direccion, String email, String telefono) {
        idClienteSeleccionado = idCedula;
 
        lblCliente.setText(nombre + " " + apellidos);
 
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Cédula:     " + idCedula);
        model.addElement("Dirección:  " + direccion);
        model.addElement("Email:      " + email);
        model.addElement("Teléfono:   " + telefono);
        ltDatosCliente.setModel(model);
    }

    public void cargarVehiculo(String matricula, String marca, String modelo,
                                String tipoVehiculo, double precio) {
        matriculaSeleccionada          = matricula;
        precioVehiculoSeleccionado     = precio;
        lblInfovehiculo.setText(marca + " " + modelo + " | " + tipoVehiculo
                + " | Precio/día: $" + String.format("%.2f", precio));
    }
 

    // CALCULAR DÍAS E IMPORTE
    private long calcularDias() {
        try {
            LocalDate inicio = LocalDate.parse(txtFechaInicio.getText().trim(), FMT);
            LocalDate fin    = LocalDate.parse(txtFechaFin.getText().trim(),    FMT);
            if (fin.isBefore(inicio)) return 0;
            return ChronoUnit.DAYS.between(inicio, fin);
        } catch (Exception e) {
            return 0;
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        BtnBuscarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltDatosCliente = new javax.swing.JList<>();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        lblCliente1 = new javax.swing.JLabel();
        lblCliente2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblInfovehiculo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCliente.setBackground(new java.awt.Color(102, 102, 102));
        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente.setText("Clientes");

        BtnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/search.png"))); // NOI18N
        BtnBuscarCliente.setText("Buscar Cliente");
        BtnBuscarCliente.setPreferredSize(new java.awt.Dimension(34, 20));
        BtnBuscarCliente.addActionListener(this::BtnBuscarClienteActionPerformed);

        TablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehiculo", "Matricula", "Precio", "Desde", "Hasta", "Cant Dias", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaDetalle);
        if (TablaDetalle.getColumnModel().getColumnCount() > 0) {
            TablaDetalle.getColumnModel().getColumn(4).setResizable(false);
            TablaDetalle.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/search.png"))); // NOI18N
        jButton1.setText("Buscar Vehiculo");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jScrollPane2.setViewportView(ltDatosCliente);

        lblCliente1.setBackground(new java.awt.Color(102, 102, 102));
        lblCliente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente1.setText("Desde");

        lblCliente2.setBackground(new java.awt.Color(102, 102, 102));
        lblCliente2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente2.setText("Hasta");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/plus.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        lblInfovehiculo.setText("InfoVehiculo");

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("0.00");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL:");

        btnRentar.setText("Rentar");
        btnRentar.addActionListener(this::btnRentarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BtnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRentar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblInfovehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfovehiculo)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(btnRentar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarClienteActionPerformed
       FrmConsultarCliente frm = new FrmConsultarCliente(this);
       frm.setVisible(true);
    }//GEN-LAST:event_BtnBuscarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmConsultarVehiculo frm = new FrmConsultarVehiculo(this);
        frm.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if (matriculaSeleccionada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero seleccione un vehículo.");
            return;
        }
        if (txtFechaInicio.getText().trim().isEmpty() || txtFechaFin.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese las fechas Desde y Hasta.");
            return;
        }
 
        long dias = calcularDias();
        if (dias <= 0) {
            JOptionPane.showMessageDialog(this,
                    "La fecha Hasta debe ser posterior a la fecha Desde.");
            return;
        }
 
        double importe = precioVehiculoSeleccionado * dias;
 
        // Obtener descripción del vehículo desde lblInfovehiculo
        String infoVeh = lblInfovehiculo.getText();
 
        DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
        model.addRow(new Object[]{
            infoVeh,
            matriculaSeleccionada,
            String.format("%.2f", precioVehiculoSeleccionado),
            txtFechaInicio.getText().trim(),
            txtFechaFin.getText().trim(),
            dias,
            String.format("%.2f", importe)
        });
 
        // Actualizar total
        actualizarTotal();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentarActionPerformed
 if (idClienteSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente.");
            return;
        }
 
        DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay vehículos agregados.");
            return;
        }
 
        // Confirmar acción
        int resp = JOptionPane.showConfirmDialog(this,
                "¿Confirmar renta para " + lblCliente.getText() + "?",
                "Confirmar Renta", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) return;
 
        // Guardar en archivo TXT
        // Formato: idCliente; vehiculo; matricula; precio; desde; hasta; cantDias; importe
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("reservas.txt", true))) {
 
            for (int i = 0; i < model.getRowCount(); i++) {
                String vehiculo  = model.getValueAt(i, 0).toString();
                String matricula = model.getValueAt(i, 1).toString();
                String precio    = model.getValueAt(i, 2).toString();
                String desde     = model.getValueAt(i, 3).toString();
                String hasta     = model.getValueAt(i, 4).toString();
                String dias      = model.getValueAt(i, 5).toString();
                String importe   = model.getValueAt(i, 6).toString();
 
                String linea = idClienteSeleccionado + "; "
                        + vehiculo + "; "
                        + matricula + "; "
                        + precio + "; "
                        + desde + "; "
                        + hasta + "; "
                        + dias + "; "
                        + importe;
 
                bw.write(linea);
                bw.newLine();
 
                // Marcar el vehículo como rentado en el archivo de vehículos
                try {
                    Vehiculo v = new VehiculoDAO().buscarPorMatricula(matricula);
                    if (v != null) {
                        v.statusVeh = false;
                        new VehiculoDAO().modificar(v);
                    }
                } catch (Exception ex) {
                    logger.warning("Error al actualizar status vehículo: " + ex.getMessage());
                }
            }
 
            JOptionPane.showMessageDialog(this,
                    "Renta guardada correctamente en reservas.txt");
 
            // Limpiar formulario
            limpiarFormulario();
 
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar la reserva: " + e.getMessage());
            logger.warning(e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnRentarActionPerformed
    /** Recalcula y muestra el total sumando todos los importes de la tabla */
    private void actualizarTotal() {
        DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                total += Double.parseDouble(model.getValueAt(i, 6).toString());
            } catch (Exception ignored) {}
        }
        jLabel1.setText(String.format("%.2f", total));
    }
 
    /** Guarda todas las filas de la tabla en un archivo TXT */
    private void BtnRentarActionPerformed() {
        if (idClienteSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente.");
            return;
        }
 
        DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay vehículos agregados.");
            return;
        }
 
        // Confirmar acción
        int resp = JOptionPane.showConfirmDialog(this,
                "¿Confirmar renta para " + lblCliente.getText() + "?",
                "Confirmar Renta", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) return;
 
        // Guardar en archivo TXT
        // Formato: idCliente; vehiculo; matricula; precio; desde; hasta; cantDias; importe
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("reservas.txt", true))) {
 
            for (int i = 0; i < model.getRowCount(); i++) {
                String vehiculo  = model.getValueAt(i, 0).toString();
                String matricula = model.getValueAt(i, 1).toString();
                String precio    = model.getValueAt(i, 2).toString();
                String desde     = model.getValueAt(i, 3).toString();
                String hasta     = model.getValueAt(i, 4).toString();
                String dias      = model.getValueAt(i, 5).toString();
                String importe   = model.getValueAt(i, 6).toString();
 
                String linea = idClienteSeleccionado + "; "
                        + vehiculo + "; "
                        + matricula + "; "
                        + precio + "; "
                        + desde + "; "
                        + hasta + "; "
                        + dias + "; "
                        + importe;
 
                bw.write(linea);
                bw.newLine();
 
                // Marcar el vehículo como rentado en el archivo de vehículos
                try {
                    Vehiculo v = new VehiculoDAO().buscarPorMatricula(matricula);
                    if (v != null) {
                        v.statusVeh = false;
                        new VehiculoDAO().modificar(v);
                    }
                } catch (Exception ex) {
                    logger.warning("Error al actualizar status vehículo: " + ex.getMessage());
                }
            }
 
            JOptionPane.showMessageDialog(this,
                    "Renta guardada correctamente en reservas.txt");
 
            // Limpiar formulario
            limpiarFormulario();
 
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar la reserva: " + e.getMessage());
            logger.warning(e.getMessage());
        }
    }
   /** Limpia todos los campos y la tabla */
    private void limpiarFormulario() {
        idClienteSeleccionado          = "";
        matriculaSeleccionada          = "";
        precioVehiculoSeleccionado     = 0.0;
        lblCliente.setText("(Sin cliente seleccionado)");
        lblInfovehiculo.setText("(Sin vehículo seleccionado)");
        ltDatosCliente.setModel(new DefaultListModel<>());
        configurarFechas();
        jLabel1.setText("0.00");
        ((DefaultTableModel) TablaDetalle.getModel()).setRowCount(0);
    }
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
        java.awt.EventQueue.invokeLater(() -> new FrmReservas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarCliente;
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JButton btnRentar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblCliente2;
    private javax.swing.JLabel lblInfovehiculo;
    private javax.swing.JList<String> ltDatosCliente;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
