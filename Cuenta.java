
package CODIGOS;

import java.util.ArrayList;

/**
 * Representa una cuenta bancaria en el sistema.
 * Cada cuenta tiene un tipo, moneda, número de cuenta, saldo inicial y actual, y está asociada a un cliente. 
 * @author 
 */
public class Cuenta {
    String tipoCuenta;
    String tipoMOneda;
    String numeroCuenta;
    double saldoInicial;
    double saldoActual;
    private Cliente cliente; 
    private String cedula;
    
   
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private static int contadorCuentas = 0;
    
    ArrayList<Movimiento> mismovimientos;

    public Cuenta() {
        mismovimientos = new ArrayList<Movimiento>();
        this.numeroCuenta = generarNumeroCuentaUnico();
    }
    private String generarNumeroCuentaUnico() {
        contadorCuentas++;
        return String.format("%010d", contadorCuentas);
    }
    public void agregarMovimiento(Movimiento mov){
        mismovimientos.add(mov);
    }

    public ArrayList<Movimiento> getMismovimientos() {
        return mismovimientos;
    }
    
    public void setMismovimientos(ArrayList<Movimiento> mismovimientos) {
        this.mismovimientos = mismovimientos;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getTipoMOneda() {
        return tipoMOneda;
    }

    public void setTipoMOneda(String tipoMOneda) {
        this.tipoMOneda = tipoMOneda;
    }
    
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }
    
    
}
