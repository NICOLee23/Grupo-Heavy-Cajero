
package CODIGOS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
/**
 * @
 */

public class RegistroArchivos {
    
    // Método para guardar un cliente en el archivo
    public static void guardarClienteEnArchivo(Cliente cliente, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write("Cliente: " + cliente.getNombre() + "\n");
            writer.write("Teléfono: " + cliente.getTelefono() + "\n");
            writer.write("Cédula: " + cliente.getCedula() + "\n");
            writer.write("Dirección: " + cliente.getDireccion() + "\n");
            writer.write("Contraseña: " + cliente.getContraseña()+ "\n");
            writer.write("Cuentas: \n");
            for (Cuenta cuenta : cliente.getCuentas()) {
                writer.write("    Número de Cuenta: " + cuenta.getNumeroCuenta() + "\n");
                writer.write("    Tipo de Cuenta: " + cuenta.getTipoCuenta() + "\n");
                writer.write("    Tipo de Moneda: " + cuenta.getTipoMOneda() + "\n");
                writer.write("    Saldo Inicial: " + cuenta.getSaldoInicial() + "\n");
                writer.write("    Saldo Actual: " + cuenta.getSaldoActual()+ "\n");
            }
            writer.write("=========================================\n");
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    // Método para agregar una cuenta a un cliente en el archivo
    public static void agregarCuentaAClienteEnArchivo(Cliente cliente, Cuenta cuenta, String nombreArchivo) {
        // Primero leemos todo el contenido del archivo
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Buscamos el cliente en el archivo y agregamos la cuenta
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            boolean clienteEncontrado = false;
            for (String linea : lineas) {
                writer.write(linea + "\n");
                if (linea.contains("Cliente: " + cliente.getNombre())) {
                    clienteEncontrado = true;
                }
                if (clienteEncontrado && linea.contains("Cuentas: ")) {
                    writer.write("    Número de Cuenta: " + cuenta.getNumeroCuenta() + "\n");
                    writer.write("    Tipo de Cuenta: " + cuenta.getTipoCuenta() + "\n");
                    writer.write("    Tipo de Moneda: " + cuenta.getTipoMOneda() + "\n");
                    writer.write("    Saldo Inicial: " + cuenta.getSaldoInicial() + "\n");
                    writer.write("    Saldo Actual: " + cuenta.getSaldoActual()+ "\n");
                    clienteEncontrado = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar los datos desde el archivo
    public static ArrayList<Cliente> cargarDatosDesdeArchivo(String nombreArchivo) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("Cliente: ")) {
                    if (cliente != null) {
                        listaClientes.add(cliente);
                    }
                    cliente = new Cliente();
                    cliente.setNombre(linea.substring("Cliente: ".length()).trim());
                    //System.out.println("Nuevo cliente: " + cliente.getNombre());
                } else if (linea.startsWith("Teléfono: ")) {
                    cliente.setTelefono(linea.substring("Teléfono: ".length()).trim());
                } else if (linea.startsWith("Cédula: ")) {
                    cliente.setCedula(linea.substring("Cédula: ".length()).trim());
                } else if (linea.startsWith("Dirección: ")) {
                    cliente.setDireccion(linea.substring("Dirección: ".length()).trim());
                } else if (linea.startsWith("Contraseña: ")) {
                    cliente.setContraseña(linea.substring("Contraseña: ".length()).trim());
                } else if (linea.startsWith("Número de Cuenta: ")) {
                    if (cliente != null) {
                        Cuenta cuenta = new Cuenta();
                        cuenta.setNumeroCuenta(linea.substring("Número de Cuenta: ".length()).trim());

                        linea = reader.readLine().trim();
                        cuenta.setTipoCuenta(linea.substring("Tipo de Cuenta: ".length()).trim());

                        linea = reader.readLine().trim();
                        cuenta.setTipoMOneda(linea.substring("Tipo de Moneda: ".length()).trim());

                        linea = reader.readLine().trim();
                        cuenta.setSaldoInicial(Double.parseDouble(linea.substring("Saldo Inicial: ".length()).trim()));

                        linea = reader.readLine().trim();
                        cuenta.setSaldoActual(Double.parseDouble(linea.substring("Saldo Actual: ".length()).trim()));
                        
                        cliente.agregarCuenta(cuenta);
                    }
                } else if (linea.startsWith("=========================================")) {
                    if (cliente != null) {
                        listaClientes.add(cliente);
                        System.out.println("Datos del cliente " + cliente.getNombre()+ " cargados exitosamente desde: " + nombreArchivo);
                        cliente = null;
                    }
                    
                }
            }
            if (cliente != null) {
                listaClientes.add(cliente);
                
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los datos de clientes desde el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico: " + e.getMessage());
        }

        return listaClientes;
    }
    
    public static void actualizarSaldoEnArchivo(String archivo, String cedulaCliente, String numeroCuenta, double nuevoSaldoActual) {
        File archivoEntrada = new File(archivo);
        File archivoTemporal = new File("archivoTemporal.txt");

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String lineaActual;
            boolean clienteEncontrado = false;
            boolean cuentaEncontrada = false;

            while ((lineaActual = lector.readLine()) != null) {
                // Verificar si es la cédula del cliente correcto
                if (lineaActual.trim().equals("Cédula: " + cedulaCliente)) {
                    clienteEncontrado = true;
                    escritor.write(lineaActual);
                    escritor.newLine();
                    continue;
                }

                // Si estamos en el cliente correcto, verificar la cuenta
                if (clienteEncontrado && lineaActual.trim().equals("Número de Cuenta: " + numeroCuenta)) {
                    cuentaEncontrada = true;
                    escritor.write(lineaActual);
                    escritor.newLine();
                    continue;
                }

                // Si estamos en la cuenta correcta y encontramos la línea de saldo actual, actualizarla
                if (cuentaEncontrada && lineaActual.trim().startsWith("Saldo Actual: ")) {
                    escritor.write("    Saldo Actual: " + nuevoSaldoActual);
                    escritor.newLine();
                    cuentaEncontrada = false; // Resetear para no afectar otras cuentas
                    continue;
                }

                // Resetear la bandera de cliente si llegamos al final de sus datos
                if (lineaActual.trim().equals("=========================================")) {
                    clienteEncontrado = false;
                }

                // Escribir la línea actual solo si no es la línea vieja de saldo actual
                escritor.write(lineaActual);
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        if (archivoEntrada.delete()) {
            if (!archivoTemporal.renameTo(archivoEntrada)) {
                System.err.println("No se pudo renombrar el archivo temporal.");
            } else {
                System.out.println("Archivo original reemplazado exitosamente.");
            }
        } else {
            System.err.println("No se pudo eliminar el archivo original.");
        }
    }
    
    public static void actualizarContraseñaEnArchivo(String archivo, String cedulaCliente, String contraseña) {
        File archivoEntrada = new File(archivo);
        File archivoTemporal = new File("archivoTemporal.txt");

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String lineaActual;
            boolean clienteEncontrado = false;
            //boolean cuentaEncontrada = false;

            while ((lineaActual = lector.readLine()) != null) {
                // Verificar si es la cédula del cliente correcto
                if (lineaActual.trim().equals("Cédula: " + cedulaCliente)) {
                    clienteEncontrado = true;
                    escritor.write(lineaActual);
                    escritor.newLine();
                    continue;
                }
                // Si estamos en la cuenta correcta y encontramos la línea de saldo actual, actualizarla
                if (clienteEncontrado && lineaActual.trim().startsWith("Contraseña: ")) {
                    escritor.write("Contraseña: " + contraseña);
                    escritor.newLine();
                    clienteEncontrado = false; 
                    continue;
                }

                // Resetear la bandera de cliente si llegamos al final de sus datos
                if (lineaActual.trim().equals("=========================================")) {
                    clienteEncontrado = false;
                }

                // Escribir la línea actual solo si no es la línea vieja de saldo actual
                escritor.write(lineaActual);
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reemplazar el archivo original con el archivo temporal
        if (archivoEntrada.delete()) {
            if (!archivoTemporal.renameTo(archivoEntrada)) {
                System.err.println("No se pudo renombrar el archivo temporal.");
            } else {
                System.out.println("Archivo original reemplazado exitosamente.");
            }
        } else {
            System.err.println("No se pudo eliminar el archivo original.");
        }
    }
    
    public static void registrarMovimientoEnArchivo(String archivo, String numeroCuenta, Movimiento movimiento) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("es", "ES"));
            String fechaFormateada = sdf.format(movimiento.getFecha());

            escritor.write("Número de Cuenta: " + numeroCuenta);
            escritor.newLine();
            escritor.write("Fecha: " + fechaFormateada);
            escritor.newLine();
            escritor.write("Tipo: " + movimiento.getTipo());
            escritor.newLine();
            escritor.write("Monto: " + movimiento.getMonto());
            escritor.newLine();
            escritor.write("=========================================");
            escritor.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static ArrayList<Movimiento> cargarMovimientosDesdeArchivo(String archivo, String numeroCuenta) {
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            Movimiento movimiento = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", new Locale("es", "ES"));

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Número de Cuenta: ")) {
                    String cuenta = linea.substring("Número de Cuenta: ".length()).trim();
                    if (cuenta.equals(numeroCuenta)) {
                        movimiento = new Movimiento();
                    } else {
                        movimiento = null;
                    }
                } else if (movimiento != null) {
                    if (linea.startsWith("Fecha: ")) {
                        Date fecha = sdf.parse(linea.substring("Fecha: ".length()).trim());
                        movimiento.setFecha(fecha);
                    } else if (linea.startsWith("Tipo: ")) {
                        movimiento.setTipo(linea.substring("Tipo: ".length()).trim());
                    } else if (linea.startsWith("Monto: ")) {
                        movimiento.setMonto(Double.parseDouble(linea.substring("Monto: ".length()).trim()));
                    } else if (linea.startsWith("=========================================")) {
                        movimientos.add(movimiento);
                        movimiento = null;
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return movimientos;
    }


}
