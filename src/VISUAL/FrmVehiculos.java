
package VISUAL;

import LOGICA.Gama;
import LOGICA.GamaDAO;
import LOGICA.Vehiculo;
import LOGICA.VehiculoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmVehiculos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmVehiculos.class.getName());
    
    private int nivelAccesoActual = 1;
 
    public FrmVehiculos() {
        initComponents();
        cargarTabla();
        
    }
   
    public FrmVehiculos(int nivelAcceso) {
        initComponents();
        this.nivelAccesoActual = nivelAcceso;
        //aplicarAcceso();
        cargarTabla();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
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
        BtnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel7.setText("Color");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANTENIMIENTO VEHICULOS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtGamaInfo.addActionListener(this::txtGamaInfoActionPerformed);

        txtMatricula.addActionListener(this::txtMatriculaActionPerformed);

        cbxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turistico", "Normal" }));

        cbxTipoMotor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Disel" }));

        chkCambioAuto.setText("Cambio Auto");

        chkCuero.setText("Interior Cuero");

        chkStatus.setText("Status");
        chkStatus.setBorder(null);

        chkTecho.setText("Techo Electrico");

        chkAire.setText("Aire Acondicionado");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Marca", "Modelo", "Tipo Vehiculo", "Tipo Motor", "Id Gama", "Color Vehiculo", "Statu Vehiculo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/trash-2.png"))); // NOI18N
        BtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminar.setFocusPainted(false);
        BtnEliminar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnEliminar.addActionListener(this::BtnEliminarActionPerformed);

        BtnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save-all.png"))); // NOI18N
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.setFocusPainted(false);
        BtnGuardar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnGuardar.addActionListener(this::BtnGuardarActionPerformed);

        BtnModificar.setBackground(new java.awt.Color(153, 153, 255));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/refresh-ccw.png"))); // NOI18N
        BtnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificar.setFocusPainted(false);
        BtnModificar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnModificar.addActionListener(this::BtnModificarActionPerformed);

        BtnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        BtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/eraser (2).png"))); // NOI18N
        BtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiar.setFocusPainted(false);
        BtnLimpiar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnLimpiar.addActionListener(this::BtnLimpiarActionPerformed);

        jLabel1.setText("Descripcion");

        jLabel2.setText("ID Gama");

        jLabel3.setText("Color");

        jLabel4.setText("Tipo de Motor");

        jLabel5.setText("Gama");

        jLabel6.setText("Matricula");

        jLabel8.setText("Modelo");

        jLabel9.setText("Marca");

        jLabel10.setText("Tipo de Vehiculo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtColor)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbxTipoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel9)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel8)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGamaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(16, 16, 16))
                                    .addComponent(cbxTipoVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGamaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(5, 5, 5)
                                .addComponent(cbxTipoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkStatus)
                    .addComponent(chkCambioAuto)
                    .addComponent(chkCuero)
                    .addComponent(chkAire)
                    .addComponent(chkTecho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //ACCESO
    /*private void aplicarAcceso() {
        boolean esAdmin = (nivelAccesoActual == 0);
        BtnGuardar.setVisible(esAdmin);
        BtnModificar.setVisible(esAdmin);
        BtnEliminar.setVisible(esAdmin);
    }*/
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
     if (!validar()) return;

    try {
        Vehiculo v = buildVehiculo();

        VehiculoDAO dao = new VehiculoDAO();
        dao.guardar(v);

        JOptionPane.showMessageDialog(this, "Vehículo guardado correctamente");

        cargarTabla();
        limpiar();

    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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
         if (!validar()) return;

    try {
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un vehículo");
            return;
        }

        Vehiculo v = buildVehiculo();

        VehiculoDAO dao = new VehiculoDAO();
        dao.modificar(v);

        JOptionPane.showMessageDialog(this, "Vehículo modificado");

        cargarTabla();
        limpiar();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
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

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed
    
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

        java.awt.EventQueue.invokeLater(() -> new FrmVehiculos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JComboBox<String> cbxTipoMotor;
    private javax.swing.JComboBox<String> cbxTipoVehiculo;
    private javax.swing.JCheckBox chkAire;
    private javax.swing.JCheckBox chkCambioAuto;
    private javax.swing.JCheckBox chkCuero;
    private javax.swing.JCheckBox chkStatus;
    private javax.swing.JCheckBox chkTecho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
