package VISUAL;

import LOGICA.Usuario;
import LOGICA.UsuarioDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.io.*;

public class FrmUsuario extends javax.swing.JFrame {
    
 private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmUsuario.class.getName());
    
    public FrmUsuario() {
    initComponents();
    cargarTabla();
 }
 

    @SuppressWarnings("unchecked")

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
        jLabel7 = new javax.swing.JLabel();

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
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        CbxAcceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin", " " }));
        CbxAcceso.addActionListener(this::CbxAccesoActionPerformed);



        txtApellido.addActionListener(this::txtApellidoActionPerformed);

        jLabel1.setText("Apellido");

        jLabel2.setText("Nombre");

        jLabel3.setText("E-Mail");

        jLabel4.setText("Usuario");

        jLabel5.setText("Contraseña");

        jLabel6.setText("Acceso");

        jLabel7.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()

                        .addGap(12, 12, 12))
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
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CbxAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
    }// </editor-fold>

    //METODO PARA VALIDAR DE QUE LO CAMPOR SEAN OBLIGATORIOS
    public boolean validar() {
        if (txtNombre.getText().isEmpty() ||
                txtUsuario.getText().isEmpty() ||
                txtMail.getText().isEmpty() ||
                jPasswordField1.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Campos obligatorios");
            return false;
        }
        return true;
    }

    // LIMPIAR LOS CAMPOS
    public void limpiar() {
        txtNombre.setText("");
        txtUsuario.setText("");
        txtMail.setText("");
        jPasswordField1.setText("");
        txtApellido.setText("");
    }

    // METODO DE CARGAR LA TABLA
    public void cargarTabla() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);

            for (Usuario u : dao.listar()) {
                modelo.addRow(new Object[]{
                        u.usuario,          // col 0
                        u.nombre,           // col 1
                        u.apellido,         // col 2
                        u.correo,           // col 3
                        u.acceso            // col 4
                        // ← u.clave NO se agrega, pero se carga al hacer clic
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BOTON DE GUARDADO
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
    try {
        if (!validar()) return;

        UsuarioDAO dao = new UsuarioDAO();

        Usuario u = new Usuario(
            txtUsuario.getText(),
            jPasswordField1.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtMail.getText(),
            CbxAcceso.getSelectedIndex()
        );

        dao.guardar(u);
        JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
        cargarTabla();
        limpiar();

    } catch (IllegalArgumentException e) {
        // Mensaje específico cuando el usuario ya existe
        JOptionPane.showMessageDialog(null, e.getMessage(), 
            "Usuario duplicado", JOptionPane.WARNING_MESSAGE);

    } catch (Exception e) {
        e.printStackTrace();
    }        
    }                                          

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    // BOTON DE ELIMINAR
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    try {
        int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");
            return;
        }

        String usuario = jTable1.getValueAt(fila, 0).toString();

        UsuarioDAO dao = new UsuarioDAO();
        dao.eliminar(usuario);

        cargarTabla();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    // BOTON DE MODIFICAR
    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {
       try {
        int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar que los campos no estén vacíos
        if (!validar()) return;

        String usuarioOriginal = jTable1.getValueAt(fila, 0).toString();

        UsuarioDAO dao = new UsuarioDAO();

        Usuario u = new Usuario(
            usuarioOriginal,               // ← usa el usuario de la tabla, no del textfield
            jPasswordField1.getText(),
            txtNombre.getText(),
            txtApellido.getText(),
            txtMail.getText(),
            CbxAcceso.getSelectedIndex()
        );

        dao.modificar(u);
        JOptionPane.showMessageDialog(null, "Usuario modificado correctamente.");
        cargarTabla();
        limpiar();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al modificar: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    // EVENTO PARA PASAR LOS DATOS DE LA TABLA A LOS TEXTBOX
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
         int fila = jTable1.getSelectedRow();

    if (fila != -1) {
        String usuarioSeleccionado = jTable1.getValueAt(fila, 0).toString();

        try {
            UsuarioDAO dao = new UsuarioDAO();
            for (Usuario u : dao.listar()) {
                if (u.usuario.equals(usuarioSeleccionado)) {
                    jPasswordField1.setText(u.password); // ← era u.clave, correcto es u.password
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtUsuario.setText(jTable1.getValueAt(fila, 0).toString());
        txtNombre.setText(jTable1.getValueAt(fila, 1).toString());
        txtApellido.setText(jTable1.getValueAt(fila, 2).toString());
        txtMail.setText(jTable1.getValueAt(fila, 3).toString());
        CbxAcceso.setSelectedIndex((int) jTable1.getValueAt(fila, 4)); // ← índice correcto
    }
    }                                    

    private void CbxAccesoActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
    }                                         

    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> new FrmUsuario().setVisible(true));
    }
  
    // Variables declaration - do not modify                     
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration                   
}