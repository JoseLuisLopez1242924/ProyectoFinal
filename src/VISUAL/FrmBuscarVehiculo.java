/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISUAL;

import LOGICA.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author jsosa
 */
public class FrmBuscarVehiculo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmBuscarVehiculo.class.getName());

     private FrmReservas Reservas;
     private FrmResepcion Resepcion;
 
    /** Lista completa de vehículos disponibles */
    private List<Vehiculo> listaVehiculos;
    /**
     * Creates new form FrmConsultarVehiculo
     */
    public FrmBuscarVehiculo() {
        initComponents();
        cargarVehiculos();
        configurarFiltro();
    }
    public FrmBuscarVehiculo(FrmReservas Reservas, FrmResepcion Resepcion) {
        initComponents();
        this.Reservas = Reservas;
        this.Resepcion = Resepcion;
        cargarVehiculos();
        configurarFiltro();
    }
 
    // -------------------------------------------------------------------------
    // CARGA INICIAL — solo vehículos DISPONIBLES (statusVeh = true)
    // -------------------------------------------------------------------------
    private void cargarVehiculos() {
        try {
            VehiculoDAO dao = new VehiculoDAO();
            listaVehiculos = new ArrayList<>();
            for (Vehiculo v : dao.listar()) {
                // Solo cargamos los disponibles (no rentados)
                if (v.statusVeh) {
                    listaVehiculos.add(v);
                }
            }
            poblarTabla(listaVehiculos);
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }
     private void cargarReserva() {
      
    }
 
    /** Llena la tabla con la lista recibida */
    private void poblarTabla(List<Vehiculo> lista) {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{
                "Matrícula", "Marca", "Modelo",
                "Tipo Vehículo", "Tipo Motor", "ID Gama",
                "Color", "Estado"
            }, 0
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
 
        for (Vehiculo v : lista) {
            model.addRow(new Object[]{
                v.matricula,
                v.marca,
                v.modelo,
                v.tipoVehiculo == 0 ? "Turístico" : "Normal",
                v.tipoMotor    == 0 ? "Diésel"    : "Gasolina",
                v.idGama,
                v.colorVeh,
                v.statusVeh    ? "Disponible" : "Rentado"   // columna Estado
            });
        }
 
        jTable1.setModel(model);
 
        // Colorear la columna Estado: verde = disponible, rojo = rentado
        jTable1.getColumnModel().getColumn(7).setCellRenderer(
            new javax.swing.table.DefaultTableCellRenderer() {
                public java.awt.Component getTableCellRendererComponent(
                        javax.swing.JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int col) {
                    super.getTableCellRendererComponent(
                            table, value, isSelected, hasFocus, row, col);
                    if ("Disponible".equals(value)) {
                        setForeground(new java.awt.Color(0, 128, 0));
                    } else {
                        setForeground(java.awt.Color.RED);
                    }
                    return this;
                }
            }
        );
    }
 
    // -------------------------------------------------------------------------
    // FILTRO EN TIEMPO REAL (por matrícula o marca/modelo)
    // -------------------------------------------------------------------------
    private void configurarFiltro() {
        Buscar.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e)  { filtrar(); }
            public void removeUpdate(DocumentEvent e)  { filtrar(); }
            public void changedUpdate(DocumentEvent e) { filtrar(); }
        });
    }
 
    private void filtrar() {
        String texto = Buscar.getText().trim().toLowerCase();
        if (listaVehiculos == null) return;
 
        if (texto.isEmpty() || texto.equals("buscar por matrícula o vehículo...")) {
            poblarTabla(listaVehiculos);
            return;
        }
 
        List<Vehiculo> filtrados = new ArrayList<>();
        for (Vehiculo v : listaVehiculos) {
            String matricula = v.matricula.toLowerCase();
            String vehiculo  = (v.marca + " " + v.modelo).toLowerCase();
            if (matricula.contains(texto) || vehiculo.contains(texto)) {
                filtrados.add(v);
            }
        }
        poblarTabla(filtrados);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Buscar.setText("Buscar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Buscar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       if(this.getTitle().equals("Buscar Vehiculo Reseva")){
        int fila = jTable1.getSelectedRow();
        if (fila == -1) return;
 
        String matricula    = jTable1.getValueAt(fila, 0).toString();
        String marca        = jTable1.getValueAt(fila, 1).toString();
        String modelo       = jTable1.getValueAt(fila, 2).toString();
        String tipoVehiculo = jTable1.getValueAt(fila, 3).toString();
        int    idGama;
 
        try {
            idGama = Integer.parseInt(jTable1.getValueAt(fila, 5).toString());
        } catch (NumberFormatException e) {
            idGama = 0;
        }
 
        // Obtener precio de gama para calcular el importe
        double precioGama = 0.0;
        try {
            Gama g = new GamaDAO().buscarPorId(idGama);
            if (g != null) precioGama = g.precio;
        } catch (Exception e) {
            logger.warning("Error al buscar gama: " + e.getMessage());
        }
 
        if (Reservas != null) {
            Reservas.cargarVehiculo(matricula, marca, modelo, tipoVehiculo, precioGama);
            this.dispose(); // cierra al seleccionar
        }
        }
       
       if(this.getTitle().equals("Buscar Vehiculo Recepcion")){
           
       
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new FrmBuscarVehiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Buscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
