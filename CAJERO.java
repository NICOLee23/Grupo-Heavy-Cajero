
package INTERFACES;
//import CODIGOS.Cajero;
import CODIGOS.Cliente;
import CODIGOS.Cuenta;
import CODIGOS.Movimiento;
import CODIGOS.RegistroArchivos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * @author 
 */
public class CAJERO extends javax.swing.JFrame {
    
    REGISTRO datos = new REGISTRO();
    DefaultTableModel modelMovimientos = new DefaultTableModel();
    boolean opcionDepositar = false;
    boolean opcionRetirar = false;
    boolean opcionConsultarSaldo = false;
    boolean opcionTransferir = false;
    boolean opcionCambiarContraseña = false;
    
    private Cliente cliente;
    private Cuenta cuenta;
    private Cliente clienteActual;
    private Cuenta cuentaActual;
    private Cuenta cuentaDestino;
    
    private boolean esperandoNumeroCuenta = true;
    private String numeroCuentaDestino = null;

    String nuevoNumero;
    double cantidad = 0;
    //Cajero cajero = new Cajero();
    
    public CAJERO() {
        initComponents();
        
        modelMovimientos.addColumn("CUENTA");
        modelMovimientos.addColumn("FECHA");
        modelMovimientos.addColumn("TIPO");
        modelMovimientos.addColumn("MONTO");
        tbl_movimientos.setModel(modelMovimientos);
        
        jlb_cantidad.setText(" ");
        
        jpanel_seleccion.setVisible(false);
        panel_opciones.setVisible(false);
        panel_ConsultaSaldo.setVisible(false);
        jPanel_contraseña.setVisible(false);
        
        jpanel_seleccion.setVisible(false);
        panel_opciones.setVisible(false);
        jPanel_contraseña.setVisible(false);
        
        habilitarBotonesPrincipales(false);
        habilitarBotonesNumericos(false);
        habilitarBotonesControl(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_7 = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btn_cancelar = new javax.swing.JButton();
        btn_aceptar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlb_titulo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        panel_opciones = new javax.swing.JPanel();
        jlb_opciones = new javax.swing.JLabel();
        jlb_cantidad = new javax.swing.JLabel();
        jpanel_seleccion = new javax.swing.JPanel();
        jlb_movCliente = new javax.swing.JLabel();
        jlb_movTipoCuneta = new javax.swing.JLabel();
        jcb_movTipoCuenta = new javax.swing.JComboBox<>();
        btn_aceptar1 = new javax.swing.JButton();
        jlb_selec_nombre = new javax.swing.JLabel();
        jPanel_contraseña = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        panel_ConsultaSaldo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jlb_ConsultaSaldo = new javax.swing.JLabel();
        jlb_Consulta_TipoMoneda = new javax.swing.JLabel();
        btn_depositar = new javax.swing.JButton();
        btn_retirar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_ConsultarSaldo = new javax.swing.JButton();
        btn_transferir = new javax.swing.JButton();
        btn_CambiarContraseña = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_movimientos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jlb_saldoActual = new javax.swing.JLabel();
        panel_DatosCuenta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlb_TipoCuenta1 = new javax.swing.JLabel();
        jlb_MontoInicial = new javax.swing.JLabel();
        jlb_Direccion = new javax.swing.JLabel();
        jlb_Cedula = new javax.swing.JLabel();
        jlb_Telefono = new javax.swing.JLabel();
        jlb_Nombre = new javax.swing.JLabel();
        btn_OK = new javax.swing.JButton();
        jlb_datosNombre = new javax.swing.JLabel();
        jlb_datosTelefono = new javax.swing.JLabel();
        jlb_datosCedula = new javax.swing.JLabel();
        jlb_datosDireccion = new javax.swing.JLabel();
        jlb_datosNumeroCuenta = new javax.swing.JLabel();
        jlb_datosMontoInicial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlb_datosTipoCuenta = new javax.swing.JLabel();
        jlb_datosTipoMoneda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        btn_1.setText("1");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });

        btn_2.setText("2");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });

        btn_3.setText("3");
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });

        btn_4.setText("4");
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });

        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });

        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });

        btn_9.setText("9");
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });

        btn_7.setText("7");
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });

        btn_0.setText("0");
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });

        btn_8.setText("8");
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 0));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_aceptar.setBackground(new java.awt.Color(51, 255, 0));
        btn_aceptar.setText("ACEPTAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        btn_borrar.setBackground(new java.awt.Color(255, 0, 51));
        btn_borrar.setText("BORRAR");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_0, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlb_titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_titulo.setText("CAJERO GRUPO HEAVY");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panel_opciones.setBackground(new java.awt.Color(204, 255, 204));

        jlb_opciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_opciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_opciones.setText("OPCION");

        jlb_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_cantidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlb_cantidad.setText("CANTIDAD");
        jlb_cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 153), 2));

        javax.swing.GroupLayout panel_opcionesLayout = new javax.swing.GroupLayout(panel_opciones);
        panel_opciones.setLayout(panel_opcionesLayout);
        panel_opcionesLayout.setHorizontalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_opcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlb_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_opcionesLayout.setVerticalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanel_seleccion.setBackground(new java.awt.Color(204, 255, 204));
        jpanel_seleccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpanel_seleccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb_movCliente.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_movCliente.setText("Cliente:");
        jpanel_seleccion.add(jlb_movCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        jlb_movTipoCuneta.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_movTipoCuneta.setText("Tipo cuenta:");
        jpanel_seleccion.add(jlb_movTipoCuneta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 70, 30));

        jcb_movTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_movTipoCuentaActionPerformed(evt);
            }
        });
        jpanel_seleccion.add(jcb_movTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 160, 30));

        btn_aceptar1.setText("ACEPTAR");
        btn_aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar1ActionPerformed(evt);
            }
        });
        jpanel_seleccion.add(btn_aceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 30));
        jpanel_seleccion.add(jlb_selec_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, 30));

        jPanel_contraseña.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel_contraseñaLayout = new javax.swing.GroupLayout(jPanel_contraseña);
        jPanel_contraseña.setLayout(jPanel_contraseñaLayout);
        jPanel_contraseñaLayout.setHorizontalGroup(
            jPanel_contraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_contraseñaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel_contraseñaLayout.setVerticalGroup(
            jPanel_contraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_contraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_ConsultaSaldo.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("EL SALDO DE TU CUENTA ES: ");

        jlb_ConsultaSaldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlb_ConsultaSaldo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jlb_Consulta_TipoMoneda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlb_Consulta_TipoMoneda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panel_ConsultaSaldoLayout = new javax.swing.GroupLayout(panel_ConsultaSaldo);
        panel_ConsultaSaldo.setLayout(panel_ConsultaSaldoLayout);
        panel_ConsultaSaldoLayout.setHorizontalGroup(
            panel_ConsultaSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ConsultaSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlb_ConsultaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_Consulta_TipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panel_ConsultaSaldoLayout.setVerticalGroup(
            panel_ConsultaSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ConsultaSaldoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ConsultaSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_Consulta_TipoMoneda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlb_ConsultaSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panel_opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_ConsultaSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jpanel_seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jpanel_seleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_ConsultaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_depositar.setBackground(new java.awt.Color(204, 255, 204));
        btn_depositar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_depositar.setText("DEPOSITAR");
        btn_depositar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_depositar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_depositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_depositarActionPerformed(evt);
            }
        });

        btn_retirar.setBackground(new java.awt.Color(204, 255, 204));
        btn_retirar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_retirar.setText("RETIRO");
        btn_retirar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retirarActionPerformed(evt);
            }
        });

        btn_salir.setBackground(new java.awt.Color(204, 255, 204));
        btn_salir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        btn_ConsultarSaldo.setBackground(new java.awt.Color(204, 255, 204));
        btn_ConsultarSaldo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ConsultarSaldo.setText("CONSULTAR");
        btn_ConsultarSaldo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_ConsultarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarSaldoActionPerformed(evt);
            }
        });

        btn_transferir.setBackground(new java.awt.Color(204, 255, 204));
        btn_transferir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_transferir.setText("TRANSFERIR");
        btn_transferir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_transferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transferirActionPerformed(evt);
            }
        });

        btn_CambiarContraseña.setBackground(new java.awt.Color(204, 255, 204));
        btn_CambiarContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_CambiarContraseña.setText("CAMBIAR CONTRASEÑA");
        btn_CambiarContraseña.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_CambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CambiarContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_transferir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ConsultarSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_depositar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_retirar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btn_depositar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(btn_retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btn_ConsultarSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(btn_transferir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CambiarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );

        btn_depositar.getAccessibleContext().setAccessibleName("110");
        btn_retirar.getAccessibleContext().setAccessibleName("110");
        btn_salir.getAccessibleContext().setAccessibleName("110");
        btn_ConsultarSaldo.getAccessibleContext().setAccessibleName("110");
        btn_transferir.getAccessibleContext().setAccessibleName("110");
        btn_CambiarContraseña.getAccessibleContext().setAccessibleName("110");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        tbl_movimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_movimientos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SALDO ACTUAL:");

        jlb_saldoActual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlb_saldoActual.setForeground(new java.awt.Color(255, 255, 255));
        jlb_saldoActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_saldoActual.setText("0000 BS");

        panel_DatosCuenta.setBackground(new java.awt.Color(204, 255, 204));
        panel_DatosCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATOS DE LA CUENTA");

        jlb_TipoCuenta1.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_TipoCuenta1.setText("Número de Cuenta:");

        jlb_MontoInicial.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_MontoInicial.setText("Monto Inicial: ");

        jlb_Direccion.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_Direccion.setText("Dirección:");

        jlb_Cedula.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_Cedula.setText("Cedula:");

        jlb_Telefono.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_Telefono.setText("Telefono:");

        jlb_Nombre.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jlb_Nombre.setText("Nombre:");

        btn_OK.setText("OK");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });

        jlb_datosNombre.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N

        jlb_datosTelefono.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N

        jlb_datosCedula.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N

        jlb_datosDireccion.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N

        jlb_datosMontoInicial.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tipo Cuenta:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo Moneda:");

        javax.swing.GroupLayout panel_DatosCuentaLayout = new javax.swing.GroupLayout(panel_DatosCuenta);
        panel_DatosCuenta.setLayout(panel_DatosCuentaLayout);
        panel_DatosCuentaLayout.setHorizontalGroup(
            panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                                        .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlb_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlb_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlb_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlb_datosDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlb_datosCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlb_datosTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlb_datosNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                                        .addComponent(jlb_TipoCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlb_datosNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32))
                            .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlb_MontoInicial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_datosMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlb_datosTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlb_datosTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_DatosCuentaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panel_DatosCuentaLayout.setVerticalGroup(
            panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                        .addComponent(jlb_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlb_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlb_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlb_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                        .addComponent(jlb_datosNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlb_datosTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlb_datosCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jlb_datosDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                        .addComponent(jlb_TipoCuenta1)
                        .addGap(24, 24, 24)
                        .addComponent(jlb_MontoInicial))
                    .addGroup(panel_DatosCuentaLayout.createSequentialGroup()
                        .addComponent(jlb_datosNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlb_datosMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jlb_datosTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_DatosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jlb_datosTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_OK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_saldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_DatosCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_DatosCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_saldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void habilitarBotonesPrincipales(boolean estado) {
        btn_depositar.setEnabled(estado);
        btn_retirar.setEnabled(estado);
        btn_salir.setEnabled(estado);
        btn_ConsultarSaldo.setEnabled(estado);
        btn_transferir.setEnabled(estado);
        btn_CambiarContraseña.setEnabled(estado);
    }

    private void habilitarBotonesNumericos(boolean estado) {
        btn_1.setEnabled(estado);
        btn_2.setEnabled(estado);
        btn_3.setEnabled(estado);
        btn_4.setEnabled(estado);
        btn_5.setEnabled(estado);
        btn_6.setEnabled(estado);
        btn_7.setEnabled(estado);
        btn_8.setEnabled(estado);
        btn_9.setEnabled(estado);
        btn_0.setEnabled(estado);
    }

    private void habilitarBotonesControl(boolean estado) {
        btn_cancelar.setEnabled(estado);
        btn_borrar.setEnabled(estado);
        btn_aceptar.setEnabled(estado);
    }
    
    private void manejarSeleccionOpcion(String mensaje, boolean depositar, boolean retirar, boolean consultarSaldo, boolean transferir, boolean cambiarContraseña) {
        opcionDepositar = depositar;
        opcionRetirar = retirar;
        opcionConsultarSaldo = consultarSaldo;
        opcionTransferir = transferir;
        opcionCambiarContraseña = cambiarContraseña;

        habilitarBotonesPrincipales(false);
        if (opcionDepositar || opcionRetirar || opcionTransferir || opcionCambiarContraseña) {
            panel_opciones.setVisible(true);
        }
        jlb_opciones.setText(mensaje);

        habilitarBotonesNumericos(true);
        habilitarBotonesControl(true);
    }
    
    private void btn_depositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_depositarActionPerformed
        manejarSeleccionOpcion("[DEPOSITO] Ingrese la cantidad a depositar", true, false, false, false, false);
    }//GEN-LAST:event_btn_depositarActionPerformed

    private void btn_retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retirarActionPerformed
        manejarSeleccionOpcion("[RETIRO] Ingrese la cantidad a retirar", false, true, false, false, false);
    }//GEN-LAST:event_btn_retirarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        JOptionPane.showMessageDialog(null, "Gracias vuelva pronto");
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_ConsultarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarSaldoActionPerformed
        manejarSeleccionOpcion("[CONSULTA DE SALDO]", false, false, true, false, false);
        realizarConsultaDeSaldo();
    }//GEN-LAST:event_btn_ConsultarSaldoActionPerformed

    private void btn_transferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transferirActionPerformed
        numeroCuentaDestino = null;
        esperandoNumeroCuenta = true;
        manejarSeleccionOpcion("[TRANSFERENCIA] Ingrese el número de la cuenta a transferir", false, false, false, true, false);
    }//GEN-LAST:event_btn_transferirActionPerformed

    private void btn_CambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CambiarContraseñaActionPerformed
        manejarSeleccionOpcion("[CAMBIO DE CONTRASEÑA] Ingresa tu nueva contraseña", false, false, false, false, true);
    }//GEN-LAST:event_btn_CambiarContraseñaActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        agregarNumeroCampos("1");
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        agregarNumeroCampos("2");
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        agregarNumeroCampos("3");
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        agregarNumeroCampos("4");
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        agregarNumeroCampos("5");
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        agregarNumeroCampos("6");
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        agregarNumeroCampos("7");
    }//GEN-LAST:event_btn_7ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        agregarNumeroCampos("8");
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        agregarNumeroCampos("9");
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        agregarNumeroCampos("0");
    }//GEN-LAST:event_btn_0ActionPerformed

    private void agregarNumeroCampos(String numero) {
        if (esperandoNumeroCuenta) {
            jlb_cantidad.setText(jlb_cantidad.getText() + numero);
        } else {
            jlb_cantidad.setText(jlb_cantidad.getText() + numero);
            jPasswordField1.setText(jPasswordField1.getText() + numero);
        }
    }
    
    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        jlb_cantidad.setText(" ");
        jPasswordField1.setText(" ");
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        jlb_cantidad.setText(eliminarUltimoCaracter(jlb_cantidad.getText()));
        jPasswordField1.setText(eliminarUltimoCaracter(jPasswordField1.getText()));
    }//GEN-LAST:event_btn_borrarActionPerformed

    private String eliminarUltimoCaracter(String carater) {
        if (carater != null && carater.length() > 0) {
            carater = carater.substring(0, carater.length() - 1);
        }
        return carater.isEmpty() ? " " : carater;
    }
    
    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        if (opcionTransferir) {
            if (esperandoNumeroCuenta) {
                numeroCuentaDestino = jlb_cantidad.getText().trim();
                if (numeroCuentaDestino.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Número de cuenta destino inválido.");
                    return;
                }

                cuentaDestino = datos.buscarCuentaPorNumero("RegistroClientes.txt", numeroCuentaDestino); // Asegúrate de que se busque la cuenta destino aquí

                if (cuentaDestino == null) {
                    JOptionPane.showMessageDialog(null, "Número de cuenta destino no encontrado.");
                    return;
                }

                esperandoNumeroCuenta = false;
                jlb_cantidad.setText("");
                manejarSeleccionOpcion("[TRANSFERENCIA] Ingrese la cantidad a transferir", false, false, false, true, false);
                //jlb_saldoCuentaDestino.setText(String.valueOf(cuentaDestino.getSaldoActual())); // Mostrar saldo actual de cuenta destino
            } else {
                realizarTransferencia();
            }
        } else {
            realizarOperacion();
    }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void agregarMovimiento(String tipo, double monto, String numeroCuenta) {
        if (cuentaActual != null) {
            Movimiento movimiento = new Movimiento(tipo, monto, new Date());
            cuentaActual.agregarMovimiento(movimiento);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("es", "ES"));
            String fechaFormateada = sdf.format(movimiento.getFecha());

            modelMovimientos.addRow(new Object[]{
                numeroCuenta,
                fechaFormateada,
                movimiento.getTipo(),
                movimiento.getMonto()
            });
            RegistroArchivos.registrarMovimientoEnArchivo("Movimientos.txt", numeroCuenta, movimiento);
        }
    }

    private void realizarOperacion() {
        if (opcionDepositar) {
            realizarDeposito();
        } else if (opcionRetirar) {
            realizarRetiro();
        } else if(opcionConsultarSaldo){
            JOptionPane.showMessageDialog(null, "Consulta realizado con éxito.");
        }  else if(opcionCambiarContraseña){
            realizarCambioDeContraseña();
        }
        resetearOperaciones();
    }

    private void realizarDeposito() {
        cantidad = Double.parseDouble(jlb_cantidad.getText().trim());
        if (cuentaActual != null) {
            cuentaActual.setSaldoActual(cuentaActual.getSaldoActual() + cantidad);
            jlb_saldoActual.setText(String.valueOf(cuentaActual.getSaldoActual()));
            agregarMovimiento("Depósito", cantidad , cuentaActual.getNumeroCuenta());
            JOptionPane.showMessageDialog(null, "Depósito realizado con éxito.");

            RegistroArchivos.actualizarSaldoEnArchivo("RegistroClientes.txt", clienteActual.getCedula(), cuentaActual.getNumeroCuenta(), cuentaActual.getSaldoActual());
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta.");
        }
    }

    private void realizarRetiro() {
        cantidad = Double.parseDouble(jlb_cantidad.getText().trim());
            if (cuentaActual != null) {
                if (cuentaActual.getSaldoActual() >= cantidad) {
                    cuentaActual.setSaldoActual(cuentaActual.getSaldoActual() - cantidad);
                    jlb_saldoActual.setText(String.valueOf(cuentaActual.getSaldoActual()));
                    agregarMovimiento("Retiro", cantidad , cuentaActual.getNumeroCuenta());
                    JOptionPane.showMessageDialog(null, "Retiro realizado con éxito.");
                    System.out.println(clienteActual.getCedula());
                    System.out.println(cuentaActual.getNumeroCuenta());
                    System.out.println(cuentaActual.getSaldoActual());


                    RegistroArchivos.actualizarSaldoEnArchivo("RegistroClientes.txt", clienteActual.getCedula(), cuentaActual.getNumeroCuenta(), cuentaActual.getSaldoActual());
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una cuenta.");
            }
    }

    
    private void realizarConsultaDeSaldo() {
        if (cuentaActual != null) {
                panel_ConsultaSaldo.setVisible(true);
                jlb_ConsultaSaldo.setText(String.valueOf(cuentaActual.getSaldoActual()));
                jlb_Consulta_TipoMoneda.setText(cuentaActual.getTipoMOneda());
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta.");
        }
           
    }
    
    private void realizarTransferencia() {
        try {
            // Obtener cantidad a transferir
            double cantidadTransferir = Double.parseDouble(jlb_cantidad.getText().trim());
            if (cantidadTransferir <= 0) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                return;
            }

            // Verificar si la cuenta actual tiene suficiente saldo
            if (cuentaActual != null && cuentaActual.getSaldoActual() >= cantidadTransferir) {
                cuentaDestino = datos.buscarCuentaPorNumero("RegistroClientes.txt", numeroCuentaDestino);

                if (cuentaDestino != null && cuentaDestino.getTipoMOneda() != null) {
                    System.out.println("Saldo actual de cuenta destino antes de la transferencia: " + cuentaDestino.getSaldoActual());
                    double cantidadConvertida = cantidadTransferir;

                    // Verificar si el tipo de moneda es diferente
                    if (!cuentaActual.getTipoMOneda().equals(cuentaDestino.getTipoMOneda())) {
                        // Realizar conversión de moneda
                        cantidadConvertida = convertirMoneda(cantidadTransferir, cuentaActual.getTipoMOneda(), cuentaDestino.getTipoMOneda());
                    }

                    // Actualizar saldos
                    cuentaActual.setSaldoActual(cuentaActual.getSaldoActual() - cantidadTransferir);
                    double nuevoSaldoDestino = cuentaDestino.getSaldoActual() + cantidadConvertida; // Sumar el monto transferido convertido
                    cuentaDestino.setSaldoActual(nuevoSaldoDestino);
                    System.out.println("Nuevo saldo de cuenta destino después de la transferencia: " + cuentaDestino.getSaldoActual());

                    // Actualizar en la interfaz
                    //jlb_saldoCuentaDestino.setText(String.valueOf(nuevoSaldoDestino));
                    jlb_saldoActual.setText(String.valueOf(cuentaActual.getSaldoActual()));
                    agregarMovimiento("Transferencia salida", cantidadTransferir, cuentaActual.getNumeroCuenta());
                    agregarMovimiento("Transferencia entrada", cantidadConvertida, cuentaDestino.getNumeroCuenta());

                    // Actualizar archivo
                    RegistroArchivos.actualizarSaldoEnArchivo("RegistroClientes.txt", clienteActual.getCedula(), cuentaActual.getNumeroCuenta(), cuentaActual.getSaldoActual());
                    RegistroArchivos.actualizarSaldoEnArchivo("RegistroClientes.txt", cuentaDestino.getCedula(), cuentaDestino.getNumeroCuenta(), cuentaDestino.getSaldoActual());

                    JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Número de cuenta destino no encontrado o tipo de moneda nulo.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida.");
        }

        resetearOperaciones();
    }
    private void realizarCambioDeContraseña() {
        cantidad = Double.parseDouble(jlb_cantidad.getText().trim());
        if (clienteActual != null) {
            clienteActual.setContraseña(jlb_cantidad.getText());
            jlb_saldoActual.setText(String.valueOf(cuentaActual.getSaldoActual()));
            agregarMovimiento("Cambio de contraseña", 0.0 , cuentaActual.getNumeroCuenta());
            JOptionPane.showMessageDialog(null, "Cambio de contraseña exitosa.");

            RegistroArchivos.actualizarContraseñaEnArchivo("RegistroClientes.txt", clienteActual.getCedula(), clienteActual.getContraseña());
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta.");
        }
    }
    
    private double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) {
        double tasaConversion = 1.0;

        // Definir tasas de conversión 
        double bolivianosADolares = 0.14;
        double bolivianosAEuros = 0.12; 
        double dolaresABolivianos = 7.00;
        double dolaresAEuros = 0.92; 
        double eurosABolivianos = 8.30; 
        double eurosADolares = 1.09;

        // Calcular la tasa de conversión basada en las monedas de origen y destino
        if (monedaOrigen.equals("BOLIVIANOS") && monedaDestino.equals("DOLARES")) {
            tasaConversion = bolivianosADolares;
        } else if (monedaOrigen.equals("BOLIVIANOS") && monedaDestino.equals("EUROS")) {
            tasaConversion = bolivianosAEuros;
        } else if (monedaOrigen.equals("DOLARES") && monedaDestino.equals("BOLIVIANOS")) {
            tasaConversion = dolaresABolivianos;
        } else if (monedaOrigen.equals("DOLARES") && monedaDestino.equals("EUROS")) {
            tasaConversion = dolaresAEuros;
        } else if (monedaOrigen.equals("EUROS") && monedaDestino.equals("BOLIVIANOS")) {
            tasaConversion = eurosABolivianos;
        } else if (monedaOrigen.equals("EUROS") && monedaDestino.equals("DOLARES")) {
            tasaConversion = eurosADolares;
        }

        // Realizar la conversión
        return cantidad * tasaConversion;
    }

    
    private void resetearOperaciones() {
        esperandoNumeroCuenta = false;
        //esperandoCantidadTransferir = false;
        numeroCuentaDestino = "";
        
        panel_opciones.setVisible(false);
        panel_ConsultaSaldo.setVisible(false);
        jlb_cantidad.setText(" ");
        jPasswordField1.setText(" ");

        habilitarBotonesPrincipales(true);
        habilitarBotonesNumericos(false);
        habilitarBotonesControl(false);

        opcionDepositar = false;
        opcionRetirar = false;
        opcionConsultarSaldo = false;
        opcionTransferir = false;
        opcionCambiarContraseña = false;
    }
    
    private void jcb_movTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_movTipoCuentaActionPerformed
        int selectedIndex = jcb_movTipoCuenta.getSelectedIndex();
        if (selectedIndex >= 0) {
            cuentaActual = clienteActual.getCuentas().get(selectedIndex);
            jlb_saldoActual.setText(String.valueOf(cuentaActual.getSaldoActual()));
        }
    }//GEN-LAST:event_jcb_movTipoCuentaActionPerformed

    private void btn_aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar1ActionPerformed
        habilitarBotonesPrincipales(true);
        habilitarBotonesNumericos(true);
        habilitarBotonesControl(true);
        verDatos();
    }//GEN-LAST:event_btn_aceptar1ActionPerformed

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        panel_DatosCuenta.setVisible(false);
    }//GEN-LAST:event_btn_OKActionPerformed

    public void verificarCliente() {
        boolean clienteEncontrado = false;
        do {
            String identificador = JOptionPane.showInputDialog("Ingrese su identificador:");
            if (identificador != null && !identificador.trim().isEmpty()) {
                identificador = identificador.trim();
                String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
                if (contraseña != null && !contraseña.trim().isEmpty()) {
                    contraseña = contraseña.trim();
                    clienteActual = datos.buscarClientePorIdentificadorYContraseña(identificador, contraseña);
                    if (clienteActual != null) {
                        JOptionPane.showMessageDialog(null, "Cliente verificado: " + clienteActual.getNombre());
                        mostrarCuentasCliente(clienteActual);
                        clienteEncontrado = true;
                    } else {
                        int opcion = JOptionPane.showOptionDialog(null, "Identificador o contraseña incorrecta. ¿Desea volver a intentarlo?", "Cliente no encontrado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, "Sí");
                        if (opcion != JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Si aún no es cliente, puede registrarse.");
                            System.exit(0);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña inválida. Por favor, inténtelo de nuevo.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Identificador inválido. Por favor, inténtelo de nuevo.");
            }
        } while (!clienteEncontrado);
    }
    
    private void mostrarCuentasCliente(Cliente cliente) {
        if (cliente != null && cliente.getCuentas() != null) {
            jcb_movTipoCuenta.removeAllItems();
            for (Cuenta cuenta : cliente.getCuentas()) {
                jlb_selec_nombre.setText(cliente.getNombre());
                jcb_movTipoCuenta.addItem(cuenta.getTipoCuenta() + " - " + cuenta.getTipoMOneda());
            }
            jpanel_seleccion.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "El cliente no tiene cuentas asociadas.");
        }
    }
    
    public void verDatos() {
        if (cuentaActual == null) {
            JOptionPane.showMessageDialog(null, "No hay una cuenta actual seleccionada.");
            return;
        }

        modelMovimientos.setRowCount(0); // Limpiar tabla
        ArrayList<Movimiento> movimientos = RegistroArchivos.cargarMovimientosDesdeArchivo("Movimientos.txt", cuentaActual.getNumeroCuenta());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("es", "ES"));

        for (Movimiento movimiento : movimientos) {
            modelMovimientos.addRow(new Object[]{
                cuentaActual.getNumeroCuenta(),
                sdf.format(movimiento.getFecha()),
                movimiento.getTipo(),
                movimiento.getMonto()
            });
        }

        // Mostrar datos del cliente
        if (clienteActual != null) {
            jlb_datosNombre.setText(clienteActual.getNombre());
            jlb_datosTelefono.setText(clienteActual.getTelefono());
            jlb_datosCedula.setText(clienteActual.getCedula());
            jlb_datosDireccion.setText(clienteActual.getDireccion());
        }

        // Mostrar datos de la cuenta
        if (clienteActual != null && clienteActual.getCuentas().size() > 0) {
            cuentaActual = clienteActual.getCuentas().get(jcb_movTipoCuenta.getSelectedIndex());
            jlb_datosTipoMoneda.setText(cuentaActual.getTipoMOneda());
            jlb_datosTipoCuenta.setText(cuentaActual.getTipoCuenta());
            jlb_datosNumeroCuenta.setText(cuentaActual.getNumeroCuenta());
            jlb_datosMontoInicial.setText(convertirAMoneda(cuentaActual.getSaldoInicial()));
            jlb_saldoActual.setText(String.valueOf(cuentaActual.getSaldoActual()));
        } else {
            JOptionPane.showMessageDialog(null, "El cliente no tiene cuentas asociadas.");
        }
    }

    // Método para convertir monto a representación de moneda
    private String convertirAMoneda(double monto) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        return formatter.format(monto);
    }

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new CAJERO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_CambiarContraseña;
    private javax.swing.JButton btn_ConsultarSaldo;
    private javax.swing.JButton btn_OK;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_aceptar1;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_depositar;
    private javax.swing.JButton btn_retirar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_transferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_contraseña;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcb_movTipoCuenta;
    private javax.swing.JLabel jlb_Cedula;
    private javax.swing.JLabel jlb_ConsultaSaldo;
    private javax.swing.JLabel jlb_Consulta_TipoMoneda;
    private javax.swing.JLabel jlb_Direccion;
    private javax.swing.JLabel jlb_MontoInicial;
    private javax.swing.JLabel jlb_Nombre;
    private javax.swing.JLabel jlb_Telefono;
    private javax.swing.JLabel jlb_TipoCuenta1;
    private javax.swing.JLabel jlb_cantidad;
    private javax.swing.JLabel jlb_datosCedula;
    private javax.swing.JLabel jlb_datosDireccion;
    private javax.swing.JLabel jlb_datosMontoInicial;
    private javax.swing.JLabel jlb_datosNombre;
    private javax.swing.JLabel jlb_datosNumeroCuenta;
    private javax.swing.JLabel jlb_datosTelefono;
    private javax.swing.JLabel jlb_datosTipoCuenta;
    private javax.swing.JLabel jlb_datosTipoMoneda;
    private javax.swing.JLabel jlb_movCliente;
    private javax.swing.JLabel jlb_movTipoCuneta;
    private javax.swing.JLabel jlb_opciones;
    private javax.swing.JLabel jlb_saldoActual;
    private javax.swing.JLabel jlb_selec_nombre;
    private javax.swing.JLabel jlb_titulo;
    private javax.swing.JPanel jpanel_seleccion;
    private javax.swing.JPanel panel_ConsultaSaldo;
    private javax.swing.JPanel panel_DatosCuenta;
    private javax.swing.JPanel panel_opciones;
    private javax.swing.JTable tbl_movimientos;
    // End of variables declaration//GEN-END:variables
}
