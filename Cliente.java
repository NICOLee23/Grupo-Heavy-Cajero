package CODIGOS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 */
// Representa un cliente en el sistema.
// Cada cliente tiene un identificador, nombre, teléfono, cédula, dirección y contraseña.
public class Cliente {
    private String nombre;
    private String telefono;
    private String cedula;
    private String direccion;
    private String contraseña;
    private List<Cuenta> cuentas;
    private String identificador;

    // Constructor principal
    public Cliente(String identificador, String nombre, String contraseña) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.cuentas = new ArrayList<>();
    }

    // Constructor por defecto para crear un cliente con identificador, nombre y contraseña.
    public Cliente() {
        this.cuentas = new ArrayList<>();
    }

    // Getters y Setters
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Métodos para agregar y obtener cuentas
    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
}
