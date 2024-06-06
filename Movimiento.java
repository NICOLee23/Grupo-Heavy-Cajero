package CODIGOS;

import java.util.Date;
//La clase Movimiento representa una transacción con un tipo, monto y fecha.
public class Movimiento {
    private String tipo;
    private double monto;
    private Date fecha;

    public Movimiento() {
    }
//Constructor con parámetros de la clase Movimiento.
    public Movimiento(String tipo, double monto, Date fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
