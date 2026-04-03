package VISUAL;

import LOGICA.Usuario;
import LOGICA.UsuarioDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.io.*;

public class FrmUsuario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmUsuario.class.getName());
    private int nivelAccesoActual = 1; // por defecto user normal

    public FrmUsuario() {
        initComponents();
        aplicarPlaceholders();
        cargarTabla();
    }

    // Constructor que recibe el nivel de acceso del usuario logueado
    public FrmUsuario(int nivelAcceso) {
        initComponents();
        this.nivelAccesoActual = nivelAcceso;
        aplicarPlaceholders();
        aplicarAcceso();
        cargarTabla();
    }

    private void aplicarPlaceholders() {
        setPlaceholder(txtUsuario, "Usuario");
        setPlaceholder(txtNombre, "Nombre");
        setPlaceholder(txtApellido, "Apellido");
        setPlaceholder(txtMail, "Correo electrónico");
        setPlaceholder(jPasswordField1, "Contraseña");
    }

    // Controla visibilidad de botones según nivel de acceso
    // Según el enunciado: 0 = Administrador, 1 = usuario normal
    private void aplicarAcceso() {
        boolean esAdmin = (nivelAccesoActual == 0);
        BtnGuardar.setVisible(esAdmin);
        BtnModificar.setVisible(esAdmin);
        BtnEliminar.setVisible(esAdmin);
        CbxAcceso.setEnabled(esAdmin);
        jPasswordField1.setEnabled(esAdmin);
    }
 
    // METODO UTILITARIO: agrega placeholder (shadow text) a un JTextField
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

    // METODO UTILITARIO: agrega placeholder a un JPasswordField
    private void setPlaceholder(javax.swing.JPasswordField field, String placeholder) {
        field.setForeground(java.awt.Color.GRAY);
        field.setEchoChar((char) 0);
        field.setText(placeholder);
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (new String(field.getPassword()).equals(placeholder)) {
                    field.setText("");
                    field.setForeground(java.awt.Color.BLACK);
                    field.setEchoChar('\u2022');
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getPassword().length == 0) {
                    field.setForeground(java.awt.Color.GRAY);
                    field.setEchoChar((char) 0);
                    field.setText(placeholder);
                }
            }
        });
    }
    // METODO PARA VALIDAR QUE LOS CAMPOS SEAN OBLIGATORIOS
    public boolean validar() {
    String usuario = txtUsuario.getText();
    String nombre = txtNombre.getText();
    String mail = txtMail.getText();

    if (usuario.isEmpty() || usuario.equals("Usuario") ||
        nombre.isEmpty() || nombre.equals("Nombre") ||
        mail.isEmpty() || mail.equals("Correo electrónico") ||
        jPasswordField1.getPassword().length == 0 ||
        new String(jPasswordField1.getPassword()).equals("Contraseña")) {

        JOptionPane.showMessageDialog(null, "Campos obligatorios");
        return false;
    }
    return true;
    }
    
    // LIMPIAR LOS CAMPOS
    public void limpiar() {
    aplicarPlaceholders();
    CbxAcceso.setSelectedIndex(0);
    }
    
    // METODO DE CARGAR LA TABLA
    public void cargarTabla() {
    try {
        UsuarioDAO dao = new UsuarioDAO();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for (Usuario u : dao.listar()) {
            modelo.addRow(new Object[]{
                u.usuario, u.nombre, u.apellido, u.correo, u.acceso
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGuardar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPasswordField1 = new javax.swing.JPasswordField();
        CbxAcceso = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        BtnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save-all.png"))); // NOI18N
        BtnGuardar.setToolTipText("");
        BtnGuardar.addActionListener(this::BtnGuardarActionPerformed);

        BtnModificar.setBackground(new java.awt.Color(255, 255, 153));
        BtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/pencil.png"))); // NOI18N
        BtnModificar.addActionListener(this::BtnModificarActionPerformed);

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/trash-2.png"))); // NOI18N
        BtnEliminar.addActionListener(this::BtnEliminarActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Apellido", "E-Mail", "Acceso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        CbxAcceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        CbxAcceso.addActionListener(this::CbxAccesoActionPerformed);

        txtApellido.addActionListener(this::txtApellidoActionPerformed);

        // EVENTO EN TIEMPO REAL: al salir del campo usuario, valida si existe
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        jLabel1.setText("Apellido");

        jLabel2.setText("Nombre");

        jLabel3.setText("E-Mail");

        jLabel4.setText("Usuario");

        jLabel5.setText("Contraseña");

        jLabel6.setText("Acceso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(CbxAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnGuardar)
                .addGap(18, 18, 18)
                .addComponent(BtnEliminar)
                .addGap(18, 18, 18)
                .addComponent(BtnModificar)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(154, 154, 154)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMail)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnGuardar)
                        .addComponent(BtnEliminar)
                        .addComponent(BtnModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbxAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // BOTON DE GUARDADO
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
    try {
        if (!validar()) return;

        UsuarioDAO dao = new UsuarioDAO();

        Usuario u = new Usuario(
            new Random().nextInt(1000),
            txtUsuario.getText(),
            new String(jPasswordField1.getPassword()),
            txtNombre.getText(),
            txtApellido.getText(),
            txtMail.getText(),
            CbxAcceso.getSelectedIndex()
        );

        dao.guardar(u);
        JOptionPane.showMessageDialog(null, "Guardado");

        cargarTabla();
        limpiar();

    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed
    
    // BOTON DE ELIMINAR
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
    try {
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
            return;
        }
        String usuario = jTable1.getValueAt(fila, 0).toString();

        UsuarioDAO dao = new UsuarioDAO();
        dao.eliminarPorUsuario(usuario);

        cargarTabla();
        limpiar();

    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_BtnEliminarActionPerformed
    
    // BOTON DE MODIFICAR
    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
    try {
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
            return;
        }
        String usuarioOriginal = jTable1.getValueAt(fila, 0).toString();

        UsuarioDAO dao = new UsuarioDAO();

        // Usamos el usuario original como clave; el id se conserva dentro de modificarPorUsuario
        Usuario u = new Usuario(
            0,
            usuarioOriginal,
            new String(jPasswordField1.getPassword()),
            txtNombre.getText(),
            txtApellido.getText(),
            txtMail.getText(),
            CbxAcceso.getSelectedIndex()
        );

        dao.modificarPorUsuario(u);

        cargarTabla();
        limpiar();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_BtnModificarActionPerformed

    // EVENTO PARA PASAR LOS DATOS DE LA TABLA A LOS TEXTBOX
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila = jTable1.getSelectedRow();

        if (fila != -1) {
            String loginSeleccionado = jTable1.getValueAt(fila, 0).toString();
            txtUsuario.setText(loginSeleccionado);
            txtNombre.setText(jTable1.getValueAt(fila, 1).toString());
            txtApellido.setText(jTable1.getValueAt(fila, 2).toString());
            txtMail.setText(jTable1.getValueAt(fila, 3).toString());
            int acceso = Integer.parseInt(jTable1.getValueAt(fila, 4).toString());
            CbxAcceso.setSelectedIndex(acceso);

            // Buscar la contraseña real desde el archivo y mostrarla en asteriscos
            try {
                UsuarioDAO dao = new UsuarioDAO();
                for (Usuario u : dao.listar()) {
                    if (u.usuario.equals(loginSeleccionado)) {
                        jPasswordField1.setText(u.password);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void CbxAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbxAccesoActionPerformed
       
    }//GEN-LAST:event_CbxAccesoActionPerformed

    // EVENTO AL PERDER FOCO EN CAMPO USUARIO: valida si existe → "Modificando" o "Creando"
    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {
        String login = txtUsuario.getText().trim();
        if (login.isEmpty()) return;

        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario encontrado = null;
            for (Usuario u : dao.listar()) {
                if (u.usuario.equals(login)) {
                    encontrado = u;
                    break;
                }
            }

            if (encontrado != null) {
                JOptionPane.showMessageDialog(null, "Modificando");
                txtNombre.setText(encontrado.nombre);
                txtApellido.setText(encontrado.apellido);
                txtMail.setText(encontrado.correo);
                jPasswordField1.setText("");
                CbxAcceso.setSelectedIndex(encontrado.acceso);
            } else {
                JOptionPane.showMessageDialog(null, "Creando");
                txtNombre.setText("");
                txtApellido.setText("");
                txtMail.setText("");
                jPasswordField1.setText("");
                CbxAcceso.setSelectedIndex(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> new FrmUsuario().setVisible(true));
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JComboBox<String> CbxAcceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
