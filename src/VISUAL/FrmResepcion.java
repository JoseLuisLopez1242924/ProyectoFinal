package VISUAL;

import LOGICA.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FrmResepcion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmResepcion.class.getName());
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 
    
    private static final String FILE_RESERVAS    = "src/DOCUMENTOS/reservas.txt";
    private static final String FILE_RECEPCIONES = "src/DOCUMENTOS/recepciones.txt";
    
    
    private String idClienteActual = "";
    private String idClienteSeleccionado = "";
    private List<String[]> lineasClienteActual = new ArrayList<>();
    
    public FrmResepcion() {
        initComponents();
        btnBuscarVehiculo.setEnabled(false);
        limpiarFormulario();
    }
    
    public void MostrarBotones(){
     btnBuscarVehiculo.setEnabled(true);
    }
      
    public void cargarCliente(String idCedula, String nombre, String apellidos, String direccion, String email, String telefono) {
        idClienteActual = idCedula;
        idClienteSeleccionado = idCedula;
        
        lblCliente.setText(nombre + " " + apellidos);
 
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Cédula:     " + idCedula);
        model.addElement("Dirección:  " + direccion);
        model.addElement("Email:      " + email);
        model.addElement("Teléfono:   " + telefono);
        ltDatosCliente.setModel(model);
    }
    
    private List<String[]> leerReservas() {
        List<String[]> lista = new ArrayList<>();
        File f = new File(FILE_RESERVAS);
        if (!f.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] campos = linea.split(";");
                // Normalizar a 9 campos (índice 8 = entregado)
                String[] normalizado = new String[9];
                for (int i = 0; i < 9; i++) {
                    normalizado[i] = (i < campos.length) ? campos[i].trim() : "";
                }
                if (normalizado[9].isEmpty()) normalizado[9] = "false"; // campo oculto por defecto
                lista.add(normalizado);
            }
        } catch (IOException e) {
            logger.warning("Error leyendo reservas: " + e.getMessage());
        }
        return lista;
    }
 
    private void escribirReservas(List<String[]> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_RESERVAS, false))) {
            for (String[] campos : lista) {
                bw.write(String.join("; ", campos));
                bw.newLine();
            }
        } catch (IOException e) {
            logger.warning("Error escribiendo reservas: " + e.getMessage());
        }
    }
 
    private String generarCodigoRecepcion() {
        int maxNum = 0;
        File f = new File(FILE_RECEPCIONES);
        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;
                    String[] campos = linea.split(";");
                    if (campos.length > 0) {
                        String cod = campos[0].trim();
                        if (cod.matches("V\\d{5}")) {
                            int num = Integer.parseInt(cod.substring(1));
                            if (num > maxNum) maxNum = num;
                        }
                    }
                }
            } catch (IOException e) {
                logger.warning("Error leyendo recepciones: " + e.getMessage());
            }
        }
        return String.format("V%05d", maxNum + 1);
    }

 
   /* public void cargarVehiculo(String matricula, String infoVehiculo, String precio, String desde, String hasta, String dias, String importe) {
        lblInfovehiculo.setText(infoVehiculo + "  |  Matrícula: " + matricula +
                "  |  Precio/día: $" + precio);
    }*/
 
    private void ejecutarRecepcion() {
        if (idClienteActual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente."); return;
        }
        DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay vehículos en la tabla de detalle."); return;
        }
 
        int resp = JOptionPane.showConfirmDialog(this,
                "¿Confirmar recepción para " + lblCliente.getText() + "?",
                "Confirmar Recepción", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) return;
 
        String fechaRecepcion = LocalDate.now().format(FMT);
        String codigoRecepcion = generarCodigoRecepcion();
 
        // Leer todas las reservas para actualizar entregado=true
        List<String[]> todasReservas = leerReservas();
 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_RECEPCIONES, true))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String infoVeh  = model.getValueAt(i, 0).toString();
                String matricula = model.getValueAt(i, 1).toString();
                String precio   = model.getValueAt(i, 2).toString();
                String desde    = model.getValueAt(i, 3).toString();
                String hasta    = model.getValueAt(i, 4).toString();
                String dias     = model.getValueAt(i, 5).toString();
                String importe  = model.getValueAt(i, 6).toString();
 
                // Guardar en recepciones.txt
                // Formato: codigo; idCliente; vehiculo; matricula; precio; desde; hasta; dias; importe; fechaRecepcion
                String lineaRecepcion = codigoRecepcion + "; "
                        + idClienteActual + "; "
                        + infoVeh + "; "
                        + matricula + "; "
                        + precio + "; "
                        + desde + "; "
                        + hasta + "; "
                        + dias + "; "
                        + importe + "; "
                        + fechaRecepcion;
                bw.write(lineaRecepcion);
                bw.newLine();
 
                // Marcar entregado=true en reservas.txt
                for (String[] campos : todasReservas) {
                    if (campos[0].equalsIgnoreCase(idClienteActual)
                            && campos[2].equalsIgnoreCase(matricula)
                            && "false".equalsIgnoreCase(campos[8])) {
                        campos[8] = "true";
                        break; // solo la primera coincidencia pendiente
                    }
                }
 
                // Liberar vehículo (statusVeh = true = disponible)
                try {
                    Vehiculo v = new VehiculoDAO().buscarPorMatricula(matricula);
                    if (v != null) {
                        v.statusVeh = true;
                        new VehiculoDAO().modificar(v);
                    }
                } catch (Exception ex) {
                    logger.warning("Error liberando vehículo " + matricula + ": " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar recepción: " + e.getMessage());
            return;
        }
 
        // Persistir reservas actualizadas
        escribirReservas(todasReservas);
 
        JOptionPane.showMessageDialog(this,
                "Recepción guardada correctamente.\nCódigo: " + codigoRecepcion);
        limpiarFormulario();
    }
    
    
    private void limpiarFormulario() {
        idClienteActual = "";
        lineasClienteActual.clear();
        lblCliente.setText("(Sin cliente seleccionado)");
   //     lblInfovehiculo.setText("(Sin vehículo seleccionado)");
        ltDatosCliente.setModel(new DefaultListModel<>());
        ((DefaultTableModel) TablaDetalle.getModel()).setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnBuscarVehiculo = new javax.swing.JButton();
        btnRecibir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltDatosCliente = new javax.swing.JList<>();
        lblCliente = new javax.swing.JLabel();
        BtnBuscarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL:");

        btnBuscarVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarVehiculo.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/search.png"))); // NOI18N
        btnBuscarVehiculo.setText("Buscar Vehiculo");
        btnBuscarVehiculo.addActionListener(this::btnBuscarVehiculoActionPerformed);

        btnRecibir.setBackground(new java.awt.Color(255, 255, 255));
        btnRecibir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRecibir.setForeground(new java.awt.Color(0, 0, 0));
        btnRecibir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save.png"))); // NOI18N
        btnRecibir.setText("Recibir");
        btnRecibir.addActionListener(this::btnRecibirActionPerformed);

        jScrollPane2.setViewportView(ltDatosCliente);

        lblCliente.setBackground(new java.awt.Color(102, 102, 102));
        lblCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCliente.setText("Clientes");

        BtnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        BtnBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
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

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRecibir)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecibir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed

    FrmBuscarReservas frm = new FrmBuscarReservas(this, idClienteActual);
    frm.setVisible(true);
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed

    private void btnRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirActionPerformed
   int fila = TablaDetalle.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un vehículo de la tabla.");
        return;
    }

    // Columnas: 0=Vehiculo, 1=Matricula, 2=Precio, 3=Desde, 4=Hasta, 5=CantDias, 6=Importe
    String vehiculo  = TablaDetalle.getValueAt(fila, 0).toString();
    String matricula = TablaDetalle.getValueAt(fila, 1).toString();
    String precio    = TablaDetalle.getValueAt(fila, 2).toString();
    String desde     = TablaDetalle.getValueAt(fila, 3).toString();
    String hasta     = TablaDetalle.getValueAt(fila, 4).toString();
    String dias      = TablaDetalle.getValueAt(fila, 5).toString();
    String importe   = TablaDetalle.getValueAt(fila, 6).toString();

    int resp = JOptionPane.showConfirmDialog(this,
        "¿Confirmar recepción del vehículo: " + matricula + "?",
        "Confirmar Recepción", JOptionPane.YES_NO_OPTION);
    if (resp != JOptionPane.YES_OPTION) return;

    String fechaRecepcion  = LocalDate.now().format(FMT);
    String codigoRecepcion = generarCodigoRecepcion();

    // Guardar en recepciones.txt
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_RECEPCIONES, true))) {
        String linea = codigoRecepcion + "; "
            + idClienteActual + "; "
            + vehiculo + "; "
            + matricula + "; "
            + precio + "; "
            + desde + "; "
            + hasta + "; "
            + dias + "; "
            + importe + "; "
            + fechaRecepcion;
        bw.write(linea);
        bw.newLine();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar recepción: " + e.getMessage());
        return;
    }

    // Marcar entregado=true en reservas.txt
    actualizarEstadoReserva(idClienteActual, matricula);

    // Liberar el vehículo (statusVeh = true)
    try {
        Vehiculo v = new VehiculoDAO().buscarPorMatricula(matricula);
        if (v != null) {
            v.statusVeh = true;
            new VehiculoDAO().modificar(v);
        }
    } catch (Exception e) {
        logger.warning("Error liberando vehículo: " + e.getMessage());
    }

    JOptionPane.showMessageDialog(this,
        "Recepción guardada correctamente.\nCódigo: " + codigoRecepcion);

    // Quitar la fila recibida de la tabla
    ((DefaultTableModel) TablaDetalle.getModel()).removeRow(fila);
    actualizarTotal();
    }                                         
    //Recalcula y muestra el total sumando todos los importes de la tabla
    private void actualizarTotal() {
        DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                total += Double.parseDouble(model.getValueAt(i, 6).toString());
            } catch (Exception ignored) {}
        }
        jLabel1.setText(String.format("%.2f", total));
 


    }//GEN-LAST:event_btnRecibirActionPerformed

    public void agregarVehiculo(String vehiculo, String matricula, String precio, String desde, String hasta, String dias, String importe) {

    DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();

    model.addRow(new Object[]{
        vehiculo,
        matricula,
        precio,
        desde,
        hasta,
        dias,
        importe
    });
    
    actualizarTotal();
}
    
    private void actualizarEstadoReserva(String idCliente, String matricula) {
     File inputFile = new File(FILE_RESERVAS);
    File tempFile  = new File(FILE_RESERVAS + ".tmp");

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
         BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

        boolean yaActualizado = false; // solo la primera coincidencia pendiente
        String linea;

        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                String[] datos = linea.split(";");
                // El formato de reservas.txt es: idReserva; idCliente; vehiculo; matricula; ....; false
                // índices (con espacios recortados): 0=idReserva, 1=idCliente, 3=matricula, 9=entregado
                if (!yaActualizado
                        && datos.length >= 10
                        && datos[1].trim().equals(idCliente)
                        && datos[3].trim().equalsIgnoreCase(matricula)
                        && datos[9].trim().equalsIgnoreCase("false")) {

                    datos[9] = " true";
                    linea = String.join(";", datos);
                    yaActualizado = true;
                }
            }
            bw.write(linea);
            bw.newLine();
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error actualizando reserva: " + e.getMessage());
        return;
    }

    if (!inputFile.delete()) {
        logger.warning("No se pudo eliminar el archivo original de reservas.");
        return;
    }
    if (!tempFile.renameTo(inputFile)) {
        logger.warning("No se pudo renombrar el archivo temporal.");
    }
}
    
    private void BtnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarClienteActionPerformed
    FrmBuscarCliente frm = new FrmBuscarCliente(null, this);
    frm.setTitle("Buscar Cliente Resepcion");
    frm.setVisible(true);
    MostrarBotones();
    DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
    model.setRowCount(0);
    actualizarTotal();
    }//GEN-LAST:event_BtnBuscarClienteActionPerformed
    
    private void actualizarTotal1() {

    DefaultTableModel model = (DefaultTableModel) TablaDetalle.getModel();
    double total = 0;

    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            total += Double.parseDouble(model.getValueAt(i, 6).toString());
        } catch (Exception e) {
            // por si hay error de formato
        }
    }

    jLabel1.setText(String.format("%.2f", total));
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
        java.awt.EventQueue.invokeLater(() -> new FrmResepcion().setVisible(true));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarCliente;
    private javax.swing.JTable TablaDetalle;
    private javax.swing.JButton btnBuscarVehiculo;
    private javax.swing.JButton btnRecibir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JList<String> ltDatosCliente;
    // End of variables declaration//GEN-END:variables
}
