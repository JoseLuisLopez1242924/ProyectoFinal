package VISUAL;

import LOGICA.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FrmConsultaVehiculos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(FrmConsultaVehiculos.class.getName());

    public FrmConsultaVehiculos() {
        initComponents();
        cargarGamas();
        ejecutarConsulta();
    }

    private void cargarGamas() {
        try {
            cbxGama.removeAllItems();
            cbxGama.addItem("-- Seleccione --");
            for (Gama g : new GamaDAO().listar()) {
                cbxGama.addItem(g.idGama + " - " + g.descripcion);
            }
        } catch (Exception e) { logger.warning(e.getMessage()); }
    }

    private static final String[] COLS = {
        "Matrícula", "Marca", "Modelo", "Tipo Veh.", "Motor",
        "Gama", "Descripción", "Color", "Precio/Día", "Status"
    };

    private void poblarTabla(List<Vehiculo> lista) {
        DefaultTableModel modelo = (DefaultTableModel) tblResultados.getModel();
        modelo.setRowCount(0);
        GamaDAO gamaDAO = new GamaDAO();
        for (Vehiculo v : lista) {
            double precio = 0;
            try {
                Gama g = gamaDAO.buscarPorId(v.idGama);
                if (g != null) precio = g.precioGama;
            } catch (Exception ignored) {}
            modelo.addRow(new Object[]{
                v.matricula,
                v.marca,
                v.modelo,
                v.tipoVehiculo == 0 ? "Turístico" : "Normal",
                v.tipoMotor    == 0 ? "Diésel"    : "Gasolina",
                v.idGama,
                v.descripcionVeh,
                v.colorVeh,
                String.format("%.2f", precio),
                v.statusVeh ? "Disponible" : "Rentado"
            });
        }
        lblTotal.setText("Resultados: " + lista.size());
    }

    private void ejecutarConsulta() {
        try {
            VehiculoDAO dao = new VehiculoDAO();
            int tipo = tabbedPane.getSelectedIndex();
            switch (tipo) {
                case 0: // Por Matrícula
                    String mat = txtMatricula.getText().trim();
                    if (mat.isEmpty()) { poblarTabla(dao.listar()); break; }
                    Vehiculo v = dao.buscarPorMatricula(mat);
                    List<Vehiculo> r0 = new java.util.ArrayList<>();
                    if (v != null) r0.add(v);
                    else JOptionPane.showMessageDialog(this, "Matrícula no encontrada.");
                    poblarTabla(r0);
                    break;
                case 1: // Disponibles
                    poblarTabla(dao.listarDisponibles());
                    break;
                case 2: // Rentados
                    poblarTabla(dao.listarRentados());
                    break;
                case 3: // Por Marca
                    String marca = txtMarca.getText().trim();
                    if (marca.isEmpty()) { poblarTabla(dao.listar()); break; }
                    poblarTabla(dao.buscarPorMarca(marca));
                    break;
                case 4: // Por Gama
                    int idx = cbxGama.getSelectedIndex();
                    if (idx <= 0) { poblarTabla(dao.listar()); break; }
                    String sel = cbxGama.getSelectedItem().toString();
                    int idGama = Integer.parseInt(sel.split(" - ")[0].trim());
                    poblarTabla(dao.buscarPorGama(idGama));
                    break;
                case 5: // Por Precio
                    String minStr = txtPrecioMin.getText().trim();
                    String maxStr = txtPrecioMax.getText().trim();
                    if (minStr.isEmpty() && maxStr.isEmpty()) { poblarTabla(dao.listar()); break; }
                    double min = minStr.isEmpty() ? 0 : Double.parseDouble(minStr.replace(",", "."));
                    double max = maxStr.isEmpty() ? Double.MAX_VALUE : Double.parseDouble(maxStr.replace(",", "."));
                    if (min > max) { JOptionPane.showMessageDialog(this, "El precio mínimo no puede ser mayor que el máximo."); break; }
                    List<Vehiculo> rPrecio = dao.buscarPorPrecio(min, max);
                    if (rPrecio.isEmpty()) JOptionPane.showMessageDialog(this, "No se encontraron vehículos en ese rango de precio.");
                    poblarTabla(rPrecio);
                    break;
                default:
                    poblarTabla(dao.listar());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos para el precio.");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane     = new javax.swing.JTabbedPane();
        pnlMatricula   = new javax.swing.JPanel();
        pnlDisponibles = new javax.swing.JPanel();
        pnlRentados    = new javax.swing.JPanel();
        pnlMarca       = new javax.swing.JPanel();
        pnlGama        = new javax.swing.JPanel();
        pnlPrecio      = new javax.swing.JPanel();
        jLabel1        = new javax.swing.JLabel();
        jLabel2        = new javax.swing.JLabel();
        jLabel3        = new javax.swing.JLabel();
        jLabel4        = new javax.swing.JLabel();
        jLabel5        = new javax.swing.JLabel();
        jLabelDisp     = new javax.swing.JLabel();
        jLabelRent     = new javax.swing.JLabel();
        txtMatricula   = new javax.swing.JTextField();
        txtMarca       = new javax.swing.JTextField();
        txtPrecioMin   = new javax.swing.JTextField();
        txtPrecioMax   = new javax.swing.JTextField();
        cbxGama        = new javax.swing.JComboBox<>();
        BtnBuscar      = new javax.swing.JButton();
        BtnLimpiar     = new javax.swing.JButton();
        lblTotal       = new javax.swing.JLabel();
        jScrollPane1   = new javax.swing.JScrollPane();
        tblResultados  = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Vehículos");

        // ---- Panel Matrícula ----
        jLabel1.setText("Matrícula:");
        pnlMatricula.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        pnlMatricula.add(jLabel1);
        txtMatricula.setPreferredSize(new java.awt.Dimension(150, 26));
        pnlMatricula.add(txtMatricula);

        // ---- Panel Disponibles ----
        jLabelDisp.setText("Muestra todos los vehículos disponibles (no rentados).");
        pnlDisponibles.add(jLabelDisp);

        // ---- Panel Rentados ----
        jLabelRent.setText("Muestra todos los vehículos actualmente rentados.");
        pnlRentados.add(jLabelRent);

        // ---- Panel Marca ----
        jLabel2.setText("Marca:");
        pnlMarca.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        pnlMarca.add(jLabel2);
        txtMarca.setPreferredSize(new java.awt.Dimension(150, 26));
        pnlMarca.add(txtMarca);

        // ---- Panel Gama ----
        jLabel3.setText("Gama:");
        pnlGama.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        pnlGama.add(jLabel3);
        cbxGama.setPreferredSize(new java.awt.Dimension(200, 26));
        pnlGama.add(cbxGama);

        // ---- Panel Precio ----
        jLabel4.setText("Precio mínimo:");
        jLabel5.setText("Precio máximo:");
        pnlPrecio.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        pnlPrecio.add(jLabel4);
        txtPrecioMin.setPreferredSize(new java.awt.Dimension(100, 26));
        pnlPrecio.add(txtPrecioMin);
        pnlPrecio.add(jLabel5);
        txtPrecioMax.setPreferredSize(new java.awt.Dimension(100, 26));
        pnlPrecio.add(txtPrecioMax);

        // ---- Tabs ----
        tabbedPane.addTab("Por Matrícula",  pnlMatricula);
        tabbedPane.addTab("Disponibles",    pnlDisponibles);
        tabbedPane.addTab("Rentados",       pnlRentados);
        tabbedPane.addTab("Por Marca",      pnlMarca);
        tabbedPane.addTab("Por Gama",       pnlGama);
        tabbedPane.addTab("Por Precio",     pnlPrecio);
        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ejecutarConsulta();
            }
        });

        // ---- Botones ----
        BtnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        BtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/refresh-ccw.png")));
        BtnBuscar.setText("Buscar");
        BtnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBuscar.setFocusPainted(false);
        BtnBuscar.setPreferredSize(new java.awt.Dimension(100, 35));
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { BtnBuscarActionPerformed(evt); }
        });

        BtnLimpiar.setBackground(new java.awt.Color(255, 255, 153));
        BtnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISUAL/MULTIMEDIA/eraser (2).png")));
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiar.setFocusPainted(false);
        BtnLimpiar.setPreferredSize(new java.awt.Dimension(100, 35));
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { BtnLimpiarActionPerformed(evt); }
        });

        lblTotal.setText("Resultados: 0");
        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 12));

        // ---- Tabla ----
        tblResultados.setModel(new DefaultTableModel(new Object[][]{}, COLS) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        tblResultados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblResultados.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(tblResultados);

        // ---- Layout ----
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8)
                        .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18)
                        .addComponent(lblTotal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addGap(8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        ejecutarConsulta();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        txtMatricula.setText("");
        txtMarca.setText("");
        txtPrecioMin.setText("");
        txtPrecioMax.setText("");
        cbxGama.setSelectedIndex(0);
        ((DefaultTableModel) tblResultados.getModel()).setRowCount(0);
        lblTotal.setText("Resultados: 0");
    }//GEN-LAST:event_BtnLimpiarActionPerformed

    public void seleccionarPestana(int index) {
        tabbedPane.setSelectedIndex(index);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new FrmConsultaVehiculos().setVisible(true); }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JComboBox<String> cbxGama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDisp;
    private javax.swing.JLabel jLabelRent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlDisponibles;
    private javax.swing.JPanel pnlGama;
    private javax.swing.JPanel pnlMarca;
    private javax.swing.JPanel pnlMatricula;
    private javax.swing.JPanel pnlPrecio;
    private javax.swing.JPanel pnlRentados;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPrecioMin;
    private javax.swing.JTextField txtPrecioMax;
    // End of variables declaration//GEN-END:variables
}
