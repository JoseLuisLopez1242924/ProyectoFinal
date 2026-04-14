/*
 * Mantenimiento de Clientes
 */
package VISUAL;

import LOGICA.Cliente;
import LOGICA.ClienteDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmClientes extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmClientes.class.getName());
    private int nivelAccesoActual = 1;

    public FrmClientes() {
        initComponents();
        aplicarPlaceholders();
        cargarTabla();
    }

    public FrmClientes(int nivelAcceso) {
        initComponents();
        this.nivelAccesoActual = nivelAcceso;
        aplicarPlaceholders();
        cargarTabla();
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

    private void setPlaceholder(javax.swing.JTextArea area, String placeholder) {
        area.setForeground(java.awt.Color.GRAY);
        area.setText(placeholder);
        area.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (area.getText().equals(placeholder)) {
                    area.setText("");
                    area.setForeground(java.awt.Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (area.getText().isEmpty()) {
                    area.setForeground(java.awt.Color.GRAY);
                    area.setText(placeholder);
                }
            }
        });
    }

    private void aplicarPlaceholders() {
        setPlaceholder(txtIdCedula,  "ID Cédula");
        setPlaceholder(txtNombre,    "Nombre");
        setPlaceholder(txtApellidos, "Apellidos");
        setPlaceholder(txtDireccion, "Dirección");
        setPlaceholder(txtEmail,     "Email");
        setPlaceholder(txtTelefono,  "Teléfono");
    }

    public boolean validar() {
        String id        = txtIdCedula.getText();
        String nombre    = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String direccion = txtDireccion.getText();
        String telefono  = txtTelefono.getText();

        if (id.isEmpty() || id.equals("ID Cédula") ||
            nombre.isEmpty() || nombre.equals("Nombre") ||
            apellidos.isEmpty() || apellidos.equals("Apellidos") ||
            direccion.isEmpty() || direccion.equals("Dirección") ||
            telefono.isEmpty() || telefono.equals("Teléfono")) {
            JOptionPane.showMessageDialog(null, "Campos obligatorios");
            return false;
        }
        if (!id.matches("\\d{3}-\\d{7}-\\d{1}")) {
            JOptionPane.showMessageDialog(null, "Formato de cédula inválido. Use: XXX-XXXXXXX-X");
            return false;
        }
        if (!telefono.matches("\\d{3}-\\d{3}-\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Formato de teléfono inválido. Use: XXX-XXX-XXXX");
            return false;
        }
        return true;
    }

    public void limpiar() {
        aplicarPlaceholders();
    }

    public void cargarTabla() {
        try {
            ClienteDAO dao = new ClienteDAO();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            for (Cliente c : dao.listar()) {
                modelo.addRow(new Object[]{ c.idCedula, c.nombre, c.apellidos, c.direccion, c.email, c.telefono });
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdCedula  = new javax.swing.JTextField();
        txtNombre    = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEmail     = new javax.swing.JTextField();
        txtTelefono  = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextArea();
        jScrollDireccion = new javax.swing.JScrollPane();
        BtnGuardar   = new javax.swing.JButton();
        BtnEliminar  = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1      = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Clientes");

        jLabel1.setText("ID Cédula");
        jLabel2.setText("Nombre");
        jLabel3.setText("Apellidos");
        jLabel4.setText("Dirección");
        jLabel5.setText("Email");
        jLabel6.setText("Teléfono");

        txtIdCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdCedulaFocusLost(evt);
            }
        });
        txtIdCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdCedulaKeyReleased(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        txtDireccion.setRows(2);
        txtDireccion.setLineWrap(true);
        txtDireccion.setWrapStyleWord(true);
        jScrollDireccion.setViewportView(txtDireccion);

        BtnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save-all.png")));
        BtnGuardar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/trash-2.png")));
        BtnEliminar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnModificar.setBackground(new java.awt.Color(255, 255, 153));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/pencil.png")));
        BtnModificar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] { "ID Cédula", "Nombre", "Apellidos", "Dirección", "Email", "Teléfono" }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
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
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                .addGap(15, 15, 15))
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
                    .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)
                    .addComponent(jLabel5).addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtIdCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdCedulaFocusLost
        String id = txtIdCedula.getText().trim();
        if (id.isEmpty() || id.equals("ID Cédula")) return;
        if (!id.matches("\\d{3}-\\d{7}-\\d{1}")) return;
        try {
            Cliente encontrado = new ClienteDAO().buscarPorId(id);
            if (encontrado != null) {
                JOptionPane.showMessageDialog(null, "Modificando");
                txtNombre.setText(encontrado.nombre);       txtNombre.setForeground(java.awt.Color.BLACK);
                txtApellidos.setText(encontrado.apellidos); txtApellidos.setForeground(java.awt.Color.BLACK);
                txtDireccion.setText(encontrado.direccion); txtDireccion.setForeground(java.awt.Color.BLACK);
                txtEmail.setText(encontrado.email);         txtEmail.setForeground(java.awt.Color.BLACK);
                txtTelefono.setText(encontrado.telefono);   txtTelefono.setForeground(java.awt.Color.BLACK);
            } else {
                JOptionPane.showMessageDialog(null, "Creando");
                aplicarPlaceholders();
                txtIdCedula.setText(id);
                txtIdCedula.setForeground(java.awt.Color.BLACK);
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }//GEN-LAST:event_txtIdCedulaFocusLost

    private void txtIdCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCedulaKeyReleased
        String texto = txtIdCedula.getText().replaceAll("[^0-9]", "");
        if (texto.length() > 11) texto = texto.substring(0, 11);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (i == 3 || i == 10) sb.append('-');
            sb.append(texto.charAt(i));
        }
        txtIdCedula.setText(sb.toString());
        txtIdCedula.setCaretPosition(sb.length());
        txtIdCedula.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_txtIdCedulaKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        String texto = txtTelefono.getText().replaceAll("[^0-9]", "");
        if (texto.length() > 10) texto = texto.substring(0, 10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (i == 3 || i == 6) sb.append('-');
            sb.append(texto.charAt(i));
        }
        txtTelefono.setText(sb.toString());
        txtTelefono.setCaretPosition(sb.length());
        txtTelefono.setForeground(java.awt.Color.BLACK);
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        try {
            if (!validar()) return;
            Cliente c = new Cliente(
                txtIdCedula.getText(),
                txtNombre.getText(),
                txtApellidos.getText(),
                txtDireccion.getText(),
                txtEmail.getText(),
                txtTelefono.getText()
            );
            new ClienteDAO().guardar(c);
            JOptionPane.showMessageDialog(null, "Guardado");
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
                JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla");
                return;
            }
            String id = jTable1.getValueAt(fila, 0).toString();
            new ClienteDAO().eliminar(id);
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
                JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla");
                return;
            }
            if (!validar()) return;
            String id = txtIdCedula.getText();
            Cliente c = new Cliente(id, txtNombre.getText(), txtApellidos.getText(),
                txtDireccion.getText(), txtEmail.getText(), txtTelefono.getText());
            new ClienteDAO().modificar(c);
            JOptionPane.showMessageDialog(null, "Modificado");
            cargarTabla();
            limpiar();
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            txtIdCedula.setText(jTable1.getValueAt(fila, 0).toString());  txtIdCedula.setForeground(java.awt.Color.BLACK);
            txtNombre.setText(jTable1.getValueAt(fila, 1).toString());    txtNombre.setForeground(java.awt.Color.BLACK);
            txtApellidos.setText(jTable1.getValueAt(fila, 2).toString()); txtApellidos.setForeground(java.awt.Color.BLACK);
            txtDireccion.setText(jTable1.getValueAt(fila, 3).toString()); txtDireccion.setForeground(java.awt.Color.BLACK);
            txtEmail.setText(jTable1.getValueAt(fila, 4).toString());     txtEmail.setForeground(java.awt.Color.BLACK);
            txtTelefono.setText(jTable1.getValueAt(fila, 5).toString());  txtTelefono.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollDireccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
