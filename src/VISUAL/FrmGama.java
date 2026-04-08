package VISUAL;

import LOGICA.Gama;
import LOGICA.GamaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class FrmGama extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmGama.class.getName());
    private int nivelAccesoActual = 1;

    public FrmGama() {
        initComponents();
        aplicarPlaceholders();
        cargarTabla();
    }

    public FrmGama(int nivelAcceso) {
        initComponents();
        this.nivelAccesoActual = nivelAcceso;
        aplicarPlaceholders();
        //aplicarAcceso();
        cargarTabla();
    }

    /*private void aplicarAcceso() {
        boolean esAdmin = (nivelAccesoActual == 0);
        BtnGuardar.setVisible(esAdmin);
        BtnModificar.setVisible(esAdmin);
        BtnEliminar.setVisible(esAdmin);
        txtDescripcion.setEnabled(esAdmin);
        txtPrecio.setEnabled(esAdmin);
    }*/

    // PLACEHOLDER PARA JTEXTFIELD
    private void setPlaceholder(JTextField field, String placeholder) {
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

    // VALIDAR CAMPOS OBLIGATORIOS
    public boolean validar() {
        String id = txtIdGama.getText();
        String desc = txtDescripcion.getText();
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

    // LIMPIAR CAMPOS
    public void limpiar() {
        aplicarPlaceholders();
    }

    // CARGAR TABLA
    public void cargarTabla() {
        try {
            GamaDAO dao = new GamaDAO();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            for (Gama g : dao.listar()) {
                modelo.addRow(new Object[]{ g.idGama, g.descripcion, g.precio });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdGama = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Gamas");

        BtnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save-all.png")));
        BtnGuardar.addActionListener(this::BtnGuardarActionPerformed);

        BtnModificar.setBackground(new java.awt.Color(255, 255, 153));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/pencil.png")));
        BtnModificar.addActionListener(this::BtnModificarActionPerformed);

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/trash-2.png")));
        BtnEliminar.addActionListener(this::BtnEliminarActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String[] { "ID Gama", "Descripción", "Precio" }
        ) {
            Class[] types = new Class[]{ Integer.class, String.class, Double.class };
            public Class getColumnClass(int c) { return types[c]; }
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        // EVENTO AL SALIR DEL CAMPO ID: valida si existe → "Modificando" o "Creando"
        txtIdGama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdGamaFocusLost(evt);
            }
        });

        jLabel1.setText("ID Gama");
        jLabel2.setText("Descripción");
        jLabel3.setText("Precio");

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
                .addComponent(BtnGuardar)
                .addGap(10, 10, 10)
                .addComponent(BtnEliminar)
                .addGap(10, 10, 10)
                .addComponent(BtnModificar)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtIdGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnModificar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // BOTON GUARDAR
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!validar()) return;
            GamaDAO dao = new GamaDAO();
            Gama g = new Gama(
                Integer.parseInt(txtIdGama.getText()),
                txtDescripcion.getText(),
                Double.parseDouble(txtPrecio.getText())
            );
            dao.guardar(g);
            JOptionPane.showMessageDialog(null, "Guardado");
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BOTON ELIMINAR
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
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
            e.printStackTrace();
        }
    }

    // BOTON MODIFICAR
    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int fila = jTable1.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una gama de la tabla");
                return;
            }
            int id = (int) jTable1.getValueAt(fila, 0);
            Gama g = new Gama(
                id,
                txtDescripcion.getText(),
                Double.parseDouble(txtPrecio.getText())
            );
            new GamaDAO().modificar(g);
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CLICK EN TABLA: rellena los campos
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            txtIdGama.setText(jTable1.getValueAt(fila, 0).toString());
            txtIdGama.setForeground(java.awt.Color.BLACK);
            txtDescripcion.setText(jTable1.getValueAt(fila, 1).toString());
            txtDescripcion.setForeground(java.awt.Color.BLACK);
            txtPrecio.setText(jTable1.getValueAt(fila, 2).toString());
            txtPrecio.setForeground(java.awt.Color.BLACK);
        }
    }

    // EVENTO AL SALIR DEL CAMPO ID: "Creando" o "Modificando"
    private void txtIdGamaFocusLost(java.awt.event.FocusEvent evt) {
        String idStr = txtIdGama.getText().trim();
        if (idStr.isEmpty() || idStr.equals("ID Gama")) return;
        try {
            int id = Integer.parseInt(idStr);
            GamaDAO dao = new GamaDAO();
            Gama encontrada = dao.buscarPorId(id);
            if (encontrada != null) {
                JOptionPane.showMessageDialog(null, "Modificando");
                txtDescripcion.setText(encontrada.descripcion);
                txtDescripcion.setForeground(java.awt.Color.BLACK);
                txtPrecio.setText(String.valueOf(encontrada.precio));
                txtPrecio.setForeground(java.awt.Color.BLACK);
            } else {
                JOptionPane.showMessageDialog(null, "Creando");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                aplicarPlaceholders();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID Gama debe ser un número entero");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmGama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdGama;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
