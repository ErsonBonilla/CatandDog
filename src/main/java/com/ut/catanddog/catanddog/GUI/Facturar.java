package com.ut.catanddog.catanddog.GUI;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.ut.catanddog.catanddog.Logica.Controladora;
import com.ut.catanddog.catanddog.Logica.Dueño;
import com.ut.catanddog.catanddog.Logica.Mascota;
import com.ut.catanddog.catanddog.Logica.Servicio;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Facturar extends javax.swing.JFrame {

    Controladora control = null;
    int num_cliente;
    Mascota masco;

    public Facturar() {
        control = new Controladora();
        initComponents();

        cargarTablaServicios();
        cargarClientesEnComboBox();

        txtSubtotal.setEditable(false);
        txtIva.setEditable(false);
        txtTotalPagar.setEditable(false);
        txtCambio.setEditable(false);
        txtFacturaNo.setEditable(false);

        txtSubtotal.setText("0.0");
        txtIva.setText("0.0");
        txtTotalPagar.setText("0.0");

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        cargarServiciosEnComboBox();
        cmbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServicioActionPerformed(evt);
            }
        });

        cargarMascotasEnComboBox();
        cmbMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServicioActionPerformed(evt);
            }
        });

        configurarSiguienteIdFactura();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFacturaNo = new javax.swing.JTextField();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbServicio = new javax.swing.JComboBox<>();
        txtClienteBuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnAñadirServicio = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        cmbMascota = new javax.swing.JComboBox<>();
        txtFecha1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        btnCalcularCambio = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrarVenta = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24));
        jLabel1.setText("Cat and Dog");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel3.setText("Servicio:");

        txtFacturaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaNoActionPerformed(evt);
            }
        });

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:", " " }));
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel4.setText("Factura No:");

        cmbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Servicio:", " " }));
        cmbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbServicioActionPerformed(evt);
            }
        });

        txtClienteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setText("Cantidad:");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnBuscarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnAñadirServicio.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnAñadirServicio.setText("Añadir Servicio");
        btnAñadirServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirServicioActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaServicios);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel13.setText("Mascota:");

        cmbMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Mascota:", " " }));
        cmbMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMascotaActionPerformed(evt);
            }
        });

        txtFecha1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtFecha1.setText("Fecha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidad)
                            .addComponent(cmbCliente, 0, 151, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtClienteBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarCliente))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAñadirServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFacturaNo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClienteBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCliente)
                        .addComponent(jLabel4)
                        .addComponent(txtFacturaNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirServicio)
                    .addComponent(jLabel13)
                    .addComponent(cmbMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel7.setText("Total a Pagar:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel8.setText("Subtotal:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel9.setText("Iva:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel10.setText("Cambio:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel11.setText("Efectivo:");

        txtSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtSubtotal.setEnabled(false);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });

        txtIva.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtIva.setEnabled(false);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });

        txtEfectivo.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });

        txtCambio.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtCambio.setEnabled(false);
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });

        txtTotalPagar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        txtTotalPagar.setEnabled(false);
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        btnCalcularCambio.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnCalcularCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcularCambio.png")));
        btnCalcularCambio.setText("Calcular Cambio");
        btnCalcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularCambioActionPerformed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Pendiente", "Pagado", "Atrasado", "Anulado" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel12.setText("Estado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTotalPagar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(txtIva)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularCambio))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcularCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnRegistrarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrarVenta.png")));
        btnRegistrarVenta.setText("Registrar Venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Regresar.png")));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarVenta)
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFacturaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaNoActionPerformed
    }//GEN-LAST:event_txtFacturaNoActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbServicioActionPerformed
    }//GEN-LAST:event_cmbServicioActionPerformed

    private void btnCalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularCambioActionPerformed
        String totalPagarTexto = txtTotalPagar.getText().trim();
        String efectivoTexto = txtEfectivo.getText().trim();

        if (totalPagarTexto.isEmpty() || efectivoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete ambos campos.");
            return;
        }

        try {
            double totalPagar = Double.parseDouble(totalPagarTexto);
            double efectivo = Double.parseDouble(efectivoTexto);

            if (efectivo >= totalPagar) {
                double cambio = efectivo - totalPagar;
                txtCambio.setText(String.format("%.2f", cambio));
            } else {
                JOptionPane.showMessageDialog(null, "El efectivo debe ser mayor o igual al total a pagar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
        }
    }//GEN-LAST:event_btnCalcularCambioActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        String estado = (String) cmbEstado.getSelectedItem();
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(txtFecha.getDate());
        String iva = txtIva.getText();
        String subtotalFactu = txtSubtotal.getText();
        String total_pagar = txtTotalPagar.getText();
        String nombreDueño = (String) cmbCliente.getSelectedItem();

        int cantidad = (int) tablaServicios.getValueAt(0, 2);
        String nombreServicio = (String) tablaServicios.getValueAt(0, 1);
        double precioUnitario = (double) tablaServicios.getValueAt(0, 3);
        double porcentajeIva = (double) tablaServicios.getValueAt(0, 5);
        String mascota = (String) cmbMascota.getSelectedItem();

        control.guardarFactura(estado, fecha, iva, subtotalFactu, total_pagar, nombreDueño, cantidad, nombreServicio, precioUnitario, porcentajeIva, mascota);

        JOptionPane optionPane = new JOptionPane("Se guardó correctamente");
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Guardado Exitoso");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        int siguienteIdFactura = Integer.parseInt(txtFacturaNo.getText()) + 1;
        txtFacturaNo.setText(String.valueOf(siguienteIdFactura));

        Document document = new Document();
        try {
            String filePath = "C:/Facturas/Factura_" + txtFacturaNo.getText() + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            try {
                Image logo = Image.getInstance(getClass().getResource("/imagenes/CatandDog.jpeg"));
                logo.scaleToFit(100, 100);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);
            } catch (BadElementException | IOException e) {
                e.printStackTrace();
            }

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph title = new Paragraph("Factura Electrónica", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Font messageFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
            Paragraph additionalMessage = new Paragraph("Factura impresa por Computadora resolución Dian No 18764052371431 de 2023-07-26 Vigencia 12 MESES", messageFont);
            additionalMessage.setAlignment(Element.ALIGN_CENTER);
            document.add(additionalMessage);

            document.add(new Paragraph(" "));

            Font subtitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Paragraph subtitle = new Paragraph("Sede Principal Cádiz Carrera 4B #31-14 Pbx. 2645486", subtitleFont);
            subtitle.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle);

            Font subtitleFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Paragraph subtitle1 = new Paragraph("Sede Vergel Centro Comercial Vergel Local 112", subtitleFont1);
            subtitle1.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle1);

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            table.addCell("Factura No:");
            table.addCell(txtFacturaNo.getText());
            table.addCell("Estado:");
            table.addCell(estado);
            table.addCell("Fecha:");
            table.addCell(fecha);
            table.addCell("IVA:");
            table.addCell(iva);
            table.addCell("Subtotal:");
            table.addCell(subtotalFactu);
            table.addCell("Total a pagar:");
            table.addCell(total_pagar);
            table.addCell("Nombre del dueño:");
            table.addCell(nombreDueño);
            table.addCell("Cantidad:");
            table.addCell(String.valueOf(cantidad));
            table.addCell("Nombre del servicio:");
            table.addCell(nombreServicio);
            table.addCell("Precio unitario:");
            table.addCell(String.valueOf(precioUnitario));
            table.addCell("Porcentaje de IVA:");
            table.addCell(String.valueOf(porcentajeIva));
            table.addCell("Mascota:");
            table.addCell(mascota);

            document.add(table);
            document.add(new Paragraph(" "));

            Barcode128 barcode = new Barcode128();
            barcode.setCode(txtFacturaNo.getText());
            Image code128Image = barcode.createImageWithBarcode(writer.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            code128Image.setAlignment(Element.ALIGN_CENTER);
            document.add(code128Image);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnAñadirServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirServicioActionPerformed
        String nombreServicio = (String) cmbServicio.getSelectedItem();
        String cantidadTexto = txtCantidad.getText().trim();

        if (nombreServicio != null && !cantidadTexto.isEmpty()) {
            try {
                int cantidad = Integer.parseInt(cantidadTexto);

                Servicio servicio = obtenerServicioPorNombre(nombreServicio);

                if (servicio != null) {
                    double precioUnitario = servicio.getPrecio();
                    double subtotal = precioUnitario * cantidad;
                    double iva = subtotal * 0.19;
                    double total = subtotal + iva;

                    DefaultTableModel modeloTabla = (DefaultTableModel) tablaServicios.getModel();

                    Object[] fila = {
                        modeloTabla.getRowCount() + 1,
                        servicio.getNombre(),
                        cantidad,
                        precioUnitario,
                        subtotal,
                        iva,
                        total,
                        "Eliminar"
                    };

                    modeloTabla.addRow(fila);
                    actualizarTotales();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un servicio y/o ingrese una cantidad.");
        }
    }//GEN-LAST:event_btnAñadirServicioActionPerformed

    private void txtClienteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteBuscarActionPerformed
        buscarYSeleccionarCliente();
    }//GEN-LAST:event_txtClienteBuscarActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        buscarYSeleccionarCliente();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        String cantidadStr = txtCantidad.getText();
        try {
            int cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.");
        }
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
    }//GEN-LAST:event_txtCambioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmbMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMascotaActionPerformed
    }//GEN-LAST:event_cmbMascotaActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
    }//GEN-LAST:event_cmbEstadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirServicio;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCalcularCambio;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbMascota;
    private javax.swing.JComboBox<String> cmbServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClienteBuscar;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFacturaNo;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JLabel txtFecha1;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables

    private void cargarClientesEnComboBox() {
        cmbCliente.removeAllItems();
        List<Mascota> listaMascotas = control.traerMascotas();
        Set<String> nombresDueños = new HashSet<>();
        for (Mascota mascota : listaMascotas) {
            Dueño dueño = mascota.getUnDueño();
            nombresDueños.add(dueño.getNombre());
        }
        for (String nombreDueño : nombresDueños) {
            cmbCliente.addItem(nombreDueño);
        }
    }

    private void buscarYSeleccionarCliente() {
        String nombreBuscado = txtClienteBuscar.getText().trim();
        if (nombreBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre para buscar.");
            return;
        }
        boolean encontrado = false;
        for (int i = 0; i < cmbCliente.getItemCount(); i++) {
            String nombre = cmbCliente.getItemAt(i);
            if (nombre.equalsIgnoreCase(nombreBuscado)) {
                cmbCliente.setSelectedIndex(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "Dueño no encontrado.");
        }
    }

    private void cargarServiciosEnComboBox() {
        cmbServicio.removeAllItems();
        List<Servicio> listaServicios = control.traerListaServicios();
        if (listaServicios == null || listaServicios.isEmpty()) {
            return;
        }
        for (Servicio servicio : listaServicios) {
            cmbServicio.addItem(servicio.getNombre());
        }
    }

    private Servicio obtenerServicioPorNombre(String nombreServicio) {
        List<Servicio> listaServicios = control.traerListaServicios();
        if (listaServicios != null) {
            for (Servicio servicio : listaServicios) {
                if (servicio.getNombre().equals(nombreServicio)) {
                    return servicio;
                }
            }
        }
        return null;
    }

    private void cargarTablaServicios() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7;
            }
        };
        String titulos[] = {"Num", "Servicio", "Cantidad", "Precio Unitario", "Subtotal", "IVA", "Total", "Acción"};
        modeloTabla.setColumnIdentifiers(titulos);
        tablaServicios.setModel(modeloTabla);
        tablaServicios.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());
        tablaServicios.getColumnModel().getColumn(7).setCellEditor(new ButtonEditor(new JCheckBox(), tablaServicios, this::actualizarTotales));
    }

    private void actualizarTotales() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaServicios.getModel();
        BigDecimal totalSubtotal = BigDecimal.ZERO;
        BigDecimal totalIva = BigDecimal.ZERO;
        BigDecimal totalPagar = BigDecimal.ZERO;

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            BigDecimal subtotal = new BigDecimal((double) modeloTabla.getValueAt(i, 4));
            BigDecimal iva = new BigDecimal((double) modeloTabla.getValueAt(i, 5));

            totalSubtotal = totalSubtotal.add(subtotal);
            totalIva = totalIva.add(iva);
            totalPagar = totalPagar.add(subtotal.add(iva));
        }

        totalSubtotal = totalSubtotal.setScale(2, RoundingMode.HALF_UP);
        totalIva = totalIva.setScale(2, RoundingMode.HALF_UP);
        totalPagar = totalPagar.setScale(2, RoundingMode.HALF_UP);

        txtSubtotal.setText(totalSubtotal.toString());
        txtIva.setText(totalIva.toString());
        txtTotalPagar.setText(totalPagar.toString());
    }

    private void cargarMascotasEnComboBox() {
        cmbMascota.removeAllItems();
        List<Mascota> listaMascotas = control.traerMascotas();
        Set<String> nombresMascotas = new HashSet<>();
        for (Mascota mascota : listaMascotas) {
            nombresMascotas.add(mascota.getNombre());
        }
        for (String nombreMascota : nombresMascotas) {
            cmbMascota.addItem(nombreMascota);
        }
    }

    private void configurarSiguienteIdFactura() {
        int ultimoIdFactura = control.obtenerUltimoIdFactura();
        int siguienteIdFactura = ultimoIdFactura + 1;
        txtFacturaNo.setText(String.valueOf(siguienteIdFactura));
    }

}
