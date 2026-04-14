/*
 * Mantenimiento de Gamas
 */
package VISUAL;

import LOGICA.Gama;
import LOGICA.GamaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmGama extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmGama.class.getName());
    private int nivelAccesoActual = 1;

    public FrmGama() {
        initComponents();
        aplicarPlaceholders();
        cargarTabla();
        OcultarBotones();
    }

    public FrmGama(int nivelAcceso) {
        initComponents();
        this.nivelAccesoActual = nivelAcceso;
        aplicarPlaceholders();
        cargarTabla();
        OcultarBotones();
    }

    public void OcultarBotones() {
        BtnGuardar.setEnabled(true);
        BtnEliminar.setEnabled(false);
        BtnModificar.setEnabled(false);
        BtnLimpiar.setEnabled(false);
        lblEstado.setText(" ");
    }

    public void MostrarBotones() {
        BtnGuardar.setEnabled(false);
        BtnEliminar.setEnabled(true);
        BtnModificar.setEnabled(true);
        BtnLimpiar.setEnabled(true);
    }

    private void setPlaceholder(javax.swing.JTextField field, String placeholder) {
        field.setForeground(java.awt.Color.GRAY);
        field.setText(placeholder);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(java.awt.Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(java.awt.Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
    }

    private void aplicarPlaceholders() {
        setPlaceholder(txtIdGama, "ID Gama");
        setPlaceholder(txtDescripcion, "Descripción");
        setPlaceholder(txtPrecio, "Precio");
    }

    public boolean validar() {
        String id     = txtIdGama.getText();
        String desc   = txtDescripcion.getText();
        String precio = txtPrecio.getText();
        if (id.isEmpty() || id.equals("ID Gama") ||
            desc.isEmpty() || desc.equals("Descripción") ||
            precio.isEmpty() || precio.equals("Precio")) {
            JOptionPane.showMessageDialog(null, "Campos obligatorios");
            return false;
        }
        try {
            Integer.parseInt(id);
            Double.parseDouble(precio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID Gama debe ser entero y Precio debe ser numérico");
            return false;
        }
        return true;
    }

    public void limpiar() {
        aplicarPlaceholders();
        OcultarBotones();
    }

    public void cargarTabla() {
        try {
            GamaDAO dao = new GamaDAO();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            for (Gama g : dao.listar()) {
                modelo.addRow(new Object[]{ g.idGama, g.descripcion, g.precio });
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtIdGama = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Gamas");

        jLabel1.setText("# Gama");
        jLabel2.setText("Descripción");
        jLabel3.setText("Precio");

        lblEstado.setText(" ");
        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblEstado.setForeground(new java.awt.Color(0, 128, 0));

        txtIdGama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdGamaFocusLost(evt);
            }
        });

        BtnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save-all.png")));
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.setFocusPainted(false);
        BtnGuardar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/trash-2.png")));
        BtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminar.setFocusPainted(false);
        BtnEliminar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(153, 153, 255));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/refresh-ccw.png")));
        BtnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificar.setFocusPainted(false);
        BtnModificar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        BtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/eraser (2).png")));
        BtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiar.setFocusPainted(false);
        BtnLimpiar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID Gama", "Descripción", "Precio" }
        ) {
            Class[] types = new Class[]{ Integer.class, String.class, Double.class };
            public Class getColumnClass(int c) { return types[c]; }
            public boolean isCellEditable(int r, int c) { return false; }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblEstado)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdGamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdGamaFocusLost
        String idStr = txtIdGama.getText().trim();
        if (idStr.isEmpty() || idStr.equals("ID Gama")) return;
        try {
            int id = Integer.parseInt(idStr);
            Gama encontrada = new GamaDAO().buscarPorId(id);
            if (encontrada != null) {
                // EXISTE → modo modificar, poblar campos sin limpiar el ID
                lblEstado.setText("✎  Modificando");
                lblEstado.setForeground(new java.awt.Color(0, 100, 200));
                txtDescripcion.setText(encontrada.descripcion);
                txtDescripcion.setForeground(java.awt.Color.BLACK);
                txtPrecio.setText(String.valueOf(encontrada.precio));
                txtPrecio.setForeground(java.awt.Color.BLACK);
                MostrarBotones();
                BtnGuardar.setEnabled(false); // ya existe, no guardar nuevo
            } else {
                // NO EXISTE → modo crear, NO limpiar el ID
                lblEstado.setText("✚  Nuevo registro");
                lblEstado.setForeground(new java.awt.Color(0, 150, 0));
                txtDescripcion.setText("");
                txtDescripcion.setForeground(java.awt.Color.BLACK);
                txtPrecio.setText("");
                txtPrecio.setForeground(java.awt.Color.BLACK);
                BtnGuardar.setEnabled(true);
                BtnEliminar.setEnabled(false);
                BtnModificar.setEnabled(false);
                BtnLimpiar.setEnabled(true);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID Gama debe ser un número entero");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }//GEN-LAST:event_txtIdGamaFocusLost

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        try {
            if (!validar()) return;
            int id = Integer.parseInt(txtIdGama.getText());
            if (new GamaDAO().buscarPorId(id) != null) {
                JOptionPane.showMessageDialog(null, "Ya existe una Gama con ese ID.", "Duplicado", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Gama g = new Gama(id, txtDescripcion.getText(), Double.parseDouble(txtPrecio.getText()));
            new GamaDAO().guardar(g);
            JOptionPane.showMessageDialog(null, "Guardado correctamente.");
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        try {
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una gama de la tabla");
                return;
            }
            int id = (int) jTable1.getValueAt(fila, 0);
            new GamaDAO().eliminar(id);
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        try {
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una gama de la tabla");
                return;
            }
            if (!validar()) return;
            int id = Integer.parseInt(txtIdGama.getText());
            Gama g = new Gama(id, txtDescripcion.getText(), Double.parseDouble(txtPrecio.getText()));
            new GamaDAO().modificar(g);
            JOptionPane.showMessageDialog(null, "Modificado correctamente.");
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            txtIdGama.setText(jTable1.getValueAt(fila, 0).toString());
            txtIdGama.setForeground(java.awt.Color.BLACK);
            txtDescripcion.setText(jTable1.getValueAt(fila, 1).toString());
            txtDescripcion.setForeground(java.awt.Color.BLACK);
            txtPrecio.setText(jTable1.getValueAt(fila, 2).toString());
            txtPrecio.setForeground(java.awt.Color.BLACK);
            lblEstado.setText("✎  Modificando");
            lblEstado.setForeground(new java.awt.Color(0, 100, 200));
            MostrarBotones();
            BtnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new FrmGama().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdGama;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
