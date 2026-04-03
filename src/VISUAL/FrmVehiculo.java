
package VISUAL;

import LOGICA.Gama;
import LOGICA.GamaDAO;
import LOGICA.Vehiculo;
import LOGICA.VehiculoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmVehiculo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmVehiculo.class.getName());

    public FrmVehiculo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDescripcion = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtGamaInfo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtIdGama = new javax.swing.JTextField();
        cbxTipoVehiculo = new javax.swing.JComboBox<>();
        cbxTipoMotor = new javax.swing.JComboBox<>();
        chkCambioAuto = new javax.swing.JCheckBox();
        chkCuero = new javax.swing.JCheckBox();
        chkStatus = new javax.swing.JCheckBox();
        chkTecho = new javax.swing.JCheckBox();
        chkAire = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BtnEliminar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDescripcion.setText("Descripcion");

        txtMarca.setText("Marca");

        txtGamaInfo.setText("Gama Info");
        txtGamaInfo.addActionListener(this::txtGamaInfoActionPerformed);

        txtColor.setText("Color");

        txtMatricula.setText("Matricula");

        txtModelo.setText("Modelo");

        txtIdGama.setText("ID Gama");

        cbxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TipoVehiculo" }));

        cbxTipoMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motor" }));

        chkCambioAuto.setText("Cambio Auto");

        chkCuero.setText("Interior Cuero");

        chkStatus.setText("Status");
        chkStatus.setBorder(null);

        chkTecho.setText("Techo Electrico");

        chkAire.setText("Aire Acondicionado");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(this::BtnEliminarActionPerformed);

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(this::BtnGuardarActionPerformed);

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(this::BtnModificarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkStatus)
                        .addGap(18, 18, 18)
                        .addComponent(chkCambioAuto)
                        .addGap(18, 18, 18)
                        .addComponent(chkCuero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkAire)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkTecho))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtColor))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnEliminar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnGuardar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnModificar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGamaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTipoVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTipoMotor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGamaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkStatus)
                    .addComponent(chkCambioAuto)
                    .addComponent(chkCuero)
                    .addComponent(chkAire)
                    .addComponent(chkTecho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //VALIDACION
    public boolean validar() {
        if (txtMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La matrícula es obligatoria.");
            return false;
        }
        if (txtMarca.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La marca es obligatoria.");
            return false;
        }
        if (txtModelo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El modelo es obligatorio.");
            return false;
        }
        if (txtDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción es obligatoria.");
            return false;
        }
        if (txtColor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El color es obligatorio.");
            return false;
        }
        if (txtIdGama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El ID de Gama es obligatorio.");
            return false;
        }
        try {
            Integer.parseInt(txtIdGama.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de Gama debe ser un número entero.");
            return false;
        }
        return true;
    }
    //LIMPIAR
    public void limpiar() {
        txtMatricula.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtDescripcion.setText("");
        txtColor.setText("");
        txtIdGama.setText("");
        txtGamaInfo.setText("");
        cbxTipoVehiculo.setSelectedIndex(0);
        cbxTipoMotor.setSelectedIndex(0);
        chkTecho.setSelected(false);
        chkAire.setSelected(false);
        chkCuero.setSelected(false);
        chkCambioAuto.setSelected(false);
        chkStatus.setSelected(true);
    }
    //CARGAR TABLA
    public void cargarTabla() {
        try {
            VehiculoDAO dao = new VehiculoDAO();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            for (Vehiculo v : dao.listar()) {
                modelo.addRow(new Object[]{
                    v.matricula,
                    v.marca,
                    v.modelo,
                    v.tipoVehiculo == 0 ? "Turístico" : "Normal",
                    v.tipoMotor == 0 ? "Diésel" : "Gasolina",
                    v.idGama,
                    v.colorVeh,
                    v.statusVeh ? "Activo" : "Inactivo"
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //POBLAR CAMPOS DESDE UN VEHICULO
    private void poblarCampos(Vehiculo v) {
        txtMarca.setText(v.marca);
        txtModelo.setText(v.modelo);
        txtDescripcion.setText(v.descripcionVeh);
        txtColor.setText(v.colorVeh);
        txtIdGama.setText(String.valueOf(v.idGama));
        cbxTipoVehiculo.setSelectedIndex(v.tipoVehiculo);
        cbxTipoMotor.setSelectedIndex(v.tipoMotor);
        chkTecho.setSelected(v.techoElectrico);
        chkAire.setSelected(v.aireAcondicionado);
        chkCuero.setSelected(v.interiorCuero);
        chkCambioAuto.setSelected(v.cambioAuto);
        chkStatus.setSelected(v.statusVeh);
        // Mostrar info de gama
        mostrarInfoGama(v.idGama);
    }
    //MOSTRAR INFO GAMA
    private void mostrarInfoGama(int idGama) {
        try {
            Gama g = new GamaDAO().buscarPorId(idGama);
            if (g != null) {
                txtGamaInfo.setText(g.descripcion + "  –  $" + g.precio);
            } else {
                txtGamaInfo.setText("Id Gama no existe");
            }
        } catch (Exception e) {
            txtGamaInfo.setText("");
        }
    }
    //EVENTO: MATRICULA PIERDE FOCO 
    private void txtMatriculaFocusLost() {
        String mat = txtMatricula.getText().trim();
        if (mat.isEmpty()) return;
        try {
            Vehiculo v = new VehiculoDAO().buscarPorMatricula(mat);
            if (v != null) {
                JOptionPane.showMessageDialog(this, "Modificando");
                poblarCampos(v);
            } else {
                JOptionPane.showMessageDialog(this, "Creando");
                // Limpia todo excepto matrícula
                txtMarca.setText(""); txtModelo.setText("");
                txtDescripcion.setText(""); txtColor.setText("");
                txtIdGama.setText(""); txtGamaInfo.setText("");
                cbxTipoVehiculo.setSelectedIndex(0);
                cbxTipoMotor.setSelectedIndex(0);
                chkTecho.setSelected(false); chkAire.setSelected(false);
                chkCuero.setSelected(false); chkCambioAuto.setSelected(false);
                chkStatus.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //EVENTO: ID GAMA PIERDE FOCO
    private void txtIdGamaFocusLost() {
        String idStr = txtIdGama.getText().trim();
        if (idStr.isEmpty()) return;
        try {
            int id = Integer.parseInt(idStr);
            Gama g = new GamaDAO().buscarPorId(id);
            if (g != null) {
                txtGamaInfo.setText(g.descripcion + "  –  $" + g.precio);
            } else {
                txtGamaInfo.setText("Id Gama no existe");
                JOptionPane.showMessageDialog(this, "Id Gama no existe");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de Gama debe ser un número entero.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    private void txtGamaInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGamaInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGamaInfoActionPerformed
    // BOTON GUARDAR
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
     try {
            if (!validar()) return;
            // Verificar que la gama existe antes de guardar
            int idGama = Integer.parseInt(txtIdGama.getText().trim());
            Gama g = new GamaDAO().buscarPorId(idGama);
            if (g == null) {
                JOptionPane.showMessageDialog(this, "Id Gama no existe. No se puede guardar.");
                return;
            }
            Vehiculo v = buildVehiculo();
            new VehiculoDAO().guardar(v);
            JOptionPane.showMessageDialog(this, "Vehículo guardado correctamente.");
            cargarTabla();
            limpiar();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Matrícula duplicada", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed
    //BOTON ELIMINAR
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        try {
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un vehículo de la tabla.");
                return;
            }
            String mat = jTable1.getValueAt(fila, 0).toString();
            new VehiculoDAO().eliminar(mat);
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed
    //BOTON MODIFICAR
    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        try {
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un vehículo de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!validar()) return;
            int idGama = Integer.parseInt(txtIdGama.getText().trim());
            if (new GamaDAO().buscarPorId(idGama) == null) {
                JOptionPane.showMessageDialog(this, "Id Gama no existe. No se puede guardar.");
                return;
            }
            Vehiculo v = buildVehiculo();
            new VehiculoDAO().modificar(v);
            JOptionPane.showMessageDialog(this, "Vehículo modificado correctamente.");
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_BtnModificarActionPerformed
    //CARGAR LOS VALORES DE LA TABLA AL TXTBOX
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int fila = jTable1.getSelectedRow();
        if (fila == -1) return;
        String mat = jTable1.getValueAt(fila, 0).toString();
        try {
            Vehiculo v = new VehiculoDAO().buscarPorMatricula(mat);
            if (v != null) {
                txtMatricula.setText(v.matricula);
                poblarCampos(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
    private Vehiculo buildVehiculo() {
        return new Vehiculo(
            txtMatricula.getText().trim(),
            txtMarca.getText().trim(),
            txtModelo.getText().trim(),
            cbxTipoVehiculo.getSelectedIndex(),
            cbxTipoMotor.getSelectedIndex(),
            Integer.parseInt(txtIdGama.getText().trim()),
            txtDescripcion.getText().trim(),
            chkTecho.isSelected(),
            chkAire.isSelected(),
            chkCuero.isSelected(),
            txtColor.getText().trim(),
            chkCambioAuto.isSelected(),
            chkStatus.isSelected()
        );
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new FrmVehiculo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JComboBox<String> cbxTipoMotor;
    private javax.swing.JComboBox<String> cbxTipoVehiculo;
    private javax.swing.JCheckBox chkAire;
    private javax.swing.JCheckBox chkCambioAuto;
    private javax.swing.JCheckBox chkCuero;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JCheckBox chkTecho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtGamaInfo;
    private javax.swing.JTextField txtIdGama;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
