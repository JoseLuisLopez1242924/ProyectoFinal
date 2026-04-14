
/*
 * Movimiento de Reservas - Clientes
 */
package VISUAL;

import LOGICA.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FrmReserva extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmReserva.class.getName());
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int nivelAcceso = 1;

    public FrmReserva() {
        initComponents();
        limpiar();
        cargarTablaPadre();
    }

    public FrmReserva(int nivelAcceso) {
        initComponents();
        this.nivelAcceso = nivelAcceso;
        limpiar();
        cargarTablaPadre();
        BtnEliminar.setEnabled(nivelAcceso == 0);
    }

    // -------------------------------------------------------------------------
    // LIMPIAR
    // -------------------------------------------------------------------------
    public void limpiar() {
        txtMatricula.setText("");
        txtDescVehiculo.setText("");
        txtCedula.setText("");
        txtNombreCliente.setText("");
        txtOferta.setText("");
        txtFechaReserva.setText(LocalDate.now().format(FMT));
        txtFechaReserva.setEditable(false);
        txtFechaSalida.setText("");
        txtFechaEntrada.setText("");
        txtDias.setText("0");
        txtTotal.setText("0.00");
        txtObservacion.setText("");
        tblHijo.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Matrícula", "Cédula", "Oferta", "F.Reserva", "F.Salida", "F.Entrada", "Días", "Total"}
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
    }

    // -------------------------------------------------------------------------
    // VALIDAR
    // -------------------------------------------------------------------------
    public boolean validar() {
        if (txtMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La matrícula es obligatoria."); return false;
        }
        if (txtCedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La cédula es obligatoria."); return false;
        }
        if (txtFechaSalida.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha de salida es obligatoria."); return false;
        }
        if (txtFechaEntrada.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La fecha de entrada es obligatoria."); return false;
        }
        try {
            LocalDate reserva = LocalDate.parse(txtFechaReserva.getText(), FMT);
            LocalDate salida  = LocalDate.parse(txtFechaSalida.getText(), FMT);
            LocalDate entrada = LocalDate.parse(txtFechaEntrada.getText(), FMT);
            if (salida.isBefore(reserva)) {
                JOptionPane.showMessageDialog(this, "Fecha Salida no puede ser menor que Fecha Reserva."); return false;
            }
            if (entrada.isBefore(reserva)) {
                JOptionPane.showMessageDialog(this, "Fecha Entrada no puede ser menor que Fecha Reserva."); return false;
            }
            if (entrada.isBefore(salida)) {
                JOptionPane.showMessageDialog(this, "Fecha Entrada no puede ser menor que Fecha Salida."); return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy."); return false;
        }
        return true;
    }

    // -------------------------------------------------------------------------
    // CALCULAR DÍAS Y TOTAL
    // -------------------------------------------------------------------------
    private void calcularTotal() {
        try {
            if (txtFechaSalida.getText().trim().isEmpty() || txtFechaEntrada.getText().trim().isEmpty()) return;
            LocalDate salida  = LocalDate.parse(txtFechaSalida.getText(), FMT);
            LocalDate entrada = LocalDate.parse(txtFechaEntrada.getText(), FMT);
            if (entrada.isBefore(salida)) return;
            long dias = ChronoUnit.DAYS.between(salida, entrada);
            txtDias.setText(String.valueOf(dias));
            double precio = obtenerPrecioBase();
            txtTotal.setText(String.format("%.2f", precio * dias));
        } catch (Exception ex) { /* fechas incompletas */ }
    }

    private double obtenerPrecioBase() {
        try {
            String idOf = txtOferta.getText().trim();
            if (!idOf.isEmpty()) {
                Oferta o = new OfertaDAO().buscarPorId(Integer.parseInt(idOf));
                if (o != null) return o.precioOferta;
            }
            String mat = txtMatricula.getText().trim();
            if (!mat.isEmpty()) {
                Vehiculo v = new VehiculoDAO().buscarPorMatricula(mat);
                if (v != null) {
                    Gama g = new GamaDAO().buscarPorId(v.idGama);
                    //if (g != null) return g.precioGama;
                }
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
        return 0;
    }

    // -------------------------------------------------------------------------
    // CARGAR TABLA PADRE (todas las reservas)
    // -------------------------------------------------------------------------
    public void cargarTablaPadre() {
        try {
            ReservaDAO dao = new ReservaDAO();
            DefaultTableModel modelo = (DefaultTableModel) tblPadre.getModel();
            modelo.setRowCount(0);
            for (Reserva r : dao.listar()) {
                modelo.addRow(new Object[]{
                    r.idMatricula, r.idCedula, r.fechaReserva, r.fechaSalida, r.fechaEntrada, r.diaReserva, r.totalReservas
                });
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }

    // -------------------------------------------------------------------------
    // CARGAR TABLA HIJO (detalle de la reserva seleccionada)
    // -------------------------------------------------------------------------
    private void cargarTablaHijo(String idMatricula) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblHijo.getModel();
            modelo.setRowCount(0);
            for (Reserva r : new ReservaDAO().listar()) {
                if (r.idMatricula.equalsIgnoreCase(idMatricula)) {
                    modelo.addRow(new Object[]{
                        r.idMatricula, r.idCedula, r.idOferta,
                        r.fechaReserva, r.fechaSalida, r.fechaEntrada,
                        r.diaReserva, r.totalReservas, r.observacion
                    });
                }
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }

    // -------------------------------------------------------------------------
    // INIT COMPONENTS
    // -------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1  = new javax.swing.JLabel();
        jLabel2  = new javax.swing.JLabel();
        jLabel3  = new javax.swing.JLabel();
        jLabel4  = new javax.swing.JLabel();
        jLabel5  = new javax.swing.JLabel();
        jLabel6  = new javax.swing.JLabel();
        jLabel7  = new javax.swing.JLabel();
        jLabel8  = new javax.swing.JLabel();
        jLabel9  = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMatricula     = new javax.swing.JTextField();
        txtDescVehiculo  = new javax.swing.JTextField();
        txtCedula        = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtOferta        = new javax.swing.JTextField();
        txtFechaReserva  = new javax.swing.JTextField();
        txtFechaSalida   = new javax.swing.JTextField();
        txtFechaEntrada  = new javax.swing.JTextField();
        txtDias          = new javax.swing.JTextField();
        txtTotal         = new javax.swing.JTextField();
        txtObservacion   = new javax.swing.JTextField();
        BtnGuardar  = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnLimpiar  = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPadre     = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHijo      = new javax.swing.JTable();
        jSeparator1  = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimiento de Reservas - Clientes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        // Labels
        jLabel1.setText("Matrícula *");
        jLabel2.setText("Vehículo");
        jLabel3.setText("ID Cédula *");
        jLabel4.setText("Cliente");
        jLabel5.setText("ID Oferta");
        jLabel6.setText("F. Reserva");
        jLabel7.setText("F. Salida *");
        jLabel8.setText("F. Entrada *");
        jLabel9.setText("Días");
        jLabel10.setText("Total RD$");
        jLabel11.setText("Observación");

        // Campos no editables
        txtDescVehiculo.setEditable(false);
        txtDescVehiculo.setBackground(new java.awt.Color(240, 240, 240));
        txtNombreCliente.setEditable(false);
        txtNombreCliente.setBackground(new java.awt.Color(240, 240, 240));
        txtDias.setEditable(false);
        txtDias.setBackground(new java.awt.Color(240, 240, 240));
        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(240, 240, 240));

        // Eventos
        txtMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) { txtMatriculaFocusLost(evt); }
        });
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) { txtCedulaFocusLost(evt); }
        });
        txtOferta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) { txtOfertaFocusLost(evt); }
        });
        txtFechaSalida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) { txtFechaSalidaFocusLost(evt); }
        });
        txtFechaEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) { txtFechaEntradaFocusLost(evt); }
        });

        // Botones
        BtnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        BtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/save-all.png")));
        BtnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnGuardar.setFocusPainted(false);
        BtnGuardar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { BtnGuardarActionPerformed(evt); }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 153, 153));
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/trash-2.png")));
        BtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEliminar.setFocusPainted(false);
        BtnEliminar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { BtnEliminarActionPerformed(evt); }
        });

        BtnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        BtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/eraser (2).png")));
        BtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiar.setFocusPainted(false);
        BtnLimpiar.setPreferredSize(new java.awt.Dimension(35, 35));
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { BtnLimpiarActionPerformed(evt); }
        });

        // Tabla PADRE
        tblPadre.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Matrícula", "Cédula", "F.Reserva", "F.Salida", "F.Entrada", "Días", "Total"}
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        tblPadre.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPadre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { tblPadreMousClicked(evt); }
        });
        jScrollPane1.setViewportView(tblPadre);

        // Tabla HIJO
        tblHijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Matrícula", "Cédula", "Oferta", "F.Reserva", "F.Salida", "F.Entrada", "Días", "Total", "Observación"}
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        tblHijo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblHijo);

        // LAYOUT
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            // FILA 1: Matrícula | Vehículo | Cédula | Cliente | Oferta | Botones
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDescVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            // FILA 2: F.Reserva | F.Salida | F.Entrada | Días | Total | Observación
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
            // SEPARADOR
            .addComponent(jSeparator1)
            // TABLA PADRE
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            // TABLA HIJO
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                // Labels fila 1
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)
                    .addComponent(jLabel4).addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                // Campos fila 1 + botones
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                // Labels fila 2
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6).addComponent(jLabel7).addComponent(jLabel8)
                    .addComponent(jLabel9).addComponent(jLabel10).addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                // Campos fila 2
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                // Tabla padre
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                // Tabla hijo
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // -------------------------------------------------------------------------
    // EVENTOS FOCUS
    // -------------------------------------------------------------------------
    private void txtMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusLost
        String mat = txtMatricula.getText().trim();
        if (mat.isEmpty()) return;
        try {
            Vehiculo v = new VehiculoDAO().buscarPorMatricula(mat);
            if (v != null) {
                txtDescVehiculo.setText(v.marca + " " + v.modelo + " - " + v.descripcionVeh);
            } else {
                JOptionPane.showMessageDialog(this, "Matrícula no encontrada.");
                txtDescVehiculo.setText("");
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }//GEN-LAST:event_txtMatriculaFocusLost

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        String ced = txtCedula.getText().trim();
        if (ced.isEmpty()) return;
        try {
            Cliente c = new ClienteDAO().buscarPorId(ced);
            if (c != null) {
                txtNombreCliente.setText(c.nombre + " " + c.apellidos);
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
                txtNombreCliente.setText("");
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtOfertaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOfertaFocusLost
        String idOf = txtOferta.getText().trim();
        if (idOf.isEmpty()) return;
        try {
            Oferta o = new OfertaDAO().buscarPorId(Integer.parseInt(idOf));
            if (o == null) {
                JOptionPane.showMessageDialog(this, "Oferta no encontrada.");
                txtOferta.setText("");
            } else {
                calcularTotal();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID Oferta debe ser numérico.");
            txtOferta.setText("");
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }//GEN-LAST:event_txtOfertaFocusLost

    private void txtFechaSalidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaSalidaFocusLost
        calcularTotal();
    }//GEN-LAST:event_txtFechaSalidaFocusLost

    private void txtFechaEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaEntradaFocusLost
        calcularTotal();
    }//GEN-LAST:event_txtFechaEntradaFocusLost

    // -------------------------------------------------------------------------
    // CLICK TABLA PADRE → carga detalle en tabla hijo y rellena campos
    // -------------------------------------------------------------------------
    private void tblPadreMousClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPadreMousClicked
        int fila = tblPadre.getSelectedRow();
        if (fila == -1) return;
        String mat = tblPadre.getValueAt(fila, 0).toString();
        cargarTablaHijo(mat);
        // Rellenar campos con la reserva seleccionada
        try {
            for (Reserva r : new ReservaDAO().listar()) {
                if (r.idMatricula.equalsIgnoreCase(mat)) {
                    txtMatricula.setText(r.idMatricula);
                    txtCedula.setText(r.idCedula);
                    txtOferta.setText(r.idOferta);
                    txtFechaReserva.setText(r.fechaReserva);
                    txtFechaSalida.setText(r.fechaSalida);
                    txtFechaEntrada.setText(r.fechaEntrada);
                    txtDias.setText(String.valueOf(r.diaReserva));
                    txtTotal.setText(String.format("%.2f", r.totalReservas));
                    txtObservacion.setText(r.observacion);
                    // Info vehículo y cliente
                    Vehiculo v = new VehiculoDAO().buscarPorMatricula(r.idMatricula);
                    if (v != null) txtDescVehiculo.setText(v.marca + " " + v.modelo + " - " + v.descripcionVeh);
                    Cliente c = new ClienteDAO().buscarPorId(r.idCedula);
                    if (c != null) txtNombreCliente.setText(c.nombre + " " + c.apellidos);
                    break;
                }
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }//GEN-LAST:event_tblPadreMousClicked

    // -------------------------------------------------------------------------
    // BOTÓN GUARDAR
    // -------------------------------------------------------------------------
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (!validar()) return;
        try {
            String mat    = txtMatricula.getText().trim();
            String ced    = txtCedula.getText().trim();
            String oferta = txtOferta.getText().trim();
            String fRes   = txtFechaReserva.getText().trim();
            String fSal   = txtFechaSalida.getText().trim();
            String fEnt   = txtFechaEntrada.getText().trim();
            String obs    = txtObservacion.getText().trim();
            int    dias   = Integer.parseInt(txtDias.getText().trim());
            double total  = Double.parseDouble(txtTotal.getText().trim().replace(",", "."));

            // Verificar que el vehículo esté disponible (statusVeh = true)
            Vehiculo v = new VehiculoDAO().buscarPorMatricula(mat);
            if (v == null) { JOptionPane.showMessageDialog(this, "Vehículo no encontrado."); return; }
            if (!v.statusVeh) { JOptionPane.showMessageDialog(this, "El vehículo ya está reservado."); return; }

            new ReservaDAO().guardar(new Reserva(mat, ced, oferta, fRes, fSal, fEnt, obs, dias, total));

            // Marcar vehículo como NO disponible (reservado)
            v.statusVeh = false;
            new VehiculoDAO().modificar(v);

            JOptionPane.showMessageDialog(this, "Reserva guardada correctamente.");
            cargarTablaPadre();
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    // -------------------------------------------------------------------------
    // BOTÓN ELIMINAR (solo Admin) — libera el vehículo
    // -------------------------------------------------------------------------
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        int fila = tblPadre.getSelectedRow();
        if (fila == -1) { JOptionPane.showMessageDialog(this, "Seleccione una reserva de la tabla."); return; }
        String mat = tblPadre.getValueAt(fila, 0).toString();
        int ok = JOptionPane.showConfirmDialog(this,
            "¿Eliminar reserva de matrícula " + mat + "?\nEl vehículo quedará disponible.",
            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (ok != JOptionPane.YES_OPTION) return;
        try {
            new ReservaDAO().eliminar(mat);
            // Liberar vehículo (statusVeh = true)
            Vehiculo v = new VehiculoDAO().buscarPorMatricula(mat);
            if (v != null) { v.statusVeh = true; new VehiculoDAO().modificar(v); }
            JOptionPane.showMessageDialog(this, "Reserva eliminada. Vehículo liberado.");
            cargarTablaPadre();
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    // -------------------------------------------------------------------------
    // BOTÓN LIMPIAR
    // -------------------------------------------------------------------------
    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new FrmReserva().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JLabel  jLabel1;
    private javax.swing.JLabel  jLabel2;
    private javax.swing.JLabel  jLabel3;
    private javax.swing.JLabel  jLabel4;
    private javax.swing.JLabel  jLabel5;
    private javax.swing.JLabel  jLabel6;
    private javax.swing.JLabel  jLabel7;
    private javax.swing.JLabel  jLabel8;
    private javax.swing.JLabel  jLabel9;
    private javax.swing.JLabel  jLabel10;
    private javax.swing.JLabel  jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator  jSeparator1;
    private javax.swing.JTable  tblPadre;
    private javax.swing.JTable  tblHijo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtDescVehiculo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtOferta;
    private javax.swing.JTextField txtFechaReserva;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextField txtFechaEntrada;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
