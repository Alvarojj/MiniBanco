package P2202111232508;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        //variables
        Cliente vc[] = new Cliente[20];
        Cuenta vcuen[] = new Cuenta[20];
        Transaccion vt[] = new Transaccion[20];
        char opcion, tran;
        String menu, Snombre, Scedula, salida;
        int ett, ei, etvc, etvcuen, etvt, swt, enc, ecuenta, etp;
        float rvalor, rsuma;

        //Programa principal
        rsuma = 0;
        enc = 100;
        etvc = 0;
        etvcuen = 0;
        etvt = 0;
        do {
            menu = "*** Menu ***\n1. Registrar clientes\n2. Registrar cuentas\n3. Registrar transacción\n4. Listado de clientes\n5. Listado de cuentas"
                    + "\n6. Listado de transacciónes\n7. Consulta: Monto total de las transacciones de depósito\n0. Salir";
            opcion = JOptionPane.showInputDialog(menu).charAt(0);
            switch (opcion) {
                case '1':
                    ett = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos clientes va a ingresar?"));
                    for (ei = (etvc + 1); ei <= (etvc + ett); ei++) {
                        Snombre = JOptionPane.showInputDialog("Ingrese nombre");
                        Scedula = JOptionPane.showInputDialog("Ingrese cedula");
                        vc[ei] = new Cliente(Scedula, Snombre);
                    }
                    etvc = etvc + ett;
                    break;
                case '2':
                    Scedula = JOptionPane.showInputDialog("Ingrese cedula del titular");
                    swt = Vcedula(vc, etvc, Scedula);
                    if (swt == 1) {
                        enc = enc + 1;
                        etvcuen = etvcuen + 1;
                        vcuen[etvcuen] = new Cuenta(enc, Scedula);
                        JOptionPane.showMessageDialog(null, vcuen[etvcuen].Mostrar(), "Cuenta", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La persona no se encuentra registrada", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case '3':
                    ecuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta"));
                    tran = JOptionPane.showInputDialog("ingrese tipo de transaccione (depósito o retiro)").toUpperCase().charAt(0);
                    swt = Vcuenta(vcuen, etvcuen, ecuenta);
                    if (swt != 0) {
                        rvalor = Float.parseFloat(JOptionPane.showInputDialog("ingrese valor"));
                        if ((rvalor >= 0) && (tran == 'D')) {
                            etvt = etvt + 1;
                            vt[etvt] = new Transaccion(ecuenta, tran, rvalor);
                            vcuen[swt].setrsaldoD(rvalor);
                            rsuma = rsuma + rvalor;
                        } else {
                            if ((rvalor <= vcuen[swt].getRsaldo()) && (rvalor >= 0) && (tran == 'R')) {
                                etvt = etvt + 1;
                                vt[etvt] = new Transaccion(ecuenta, tran, rvalor);
                                vcuen[swt].setrsaldoR(rvalor);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo realizar la transaccion", "WARNING", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se puede realizar la transacción", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                case '4':
                    salida = "";
                    if (etvc > 0) {
                        for (ei = 1; ei <= etvc; ei++) {
                            salida = salida + vc[ei].Mostrar() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Listado de clientes", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ningun cliente registrado", "Listado de clientes", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case '5':
                    salida = "";
                    if (etvcuen > 0) {
                        for (ei = 1; ei <= etvcuen; ei++) {
                            salida = salida + vcuen[ei].Mostrar() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Listado de cuentas", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ninguna cuenta registrada", "Listado de Cuentas", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case '6':
                    salida = "";
                    if (etvt > 0) {
                        for (ei = 1; ei <= etvt; ei++) {
                            salida = salida + vt[ei].Mostrar() + "\n\n";
                        }
                        JOptionPane.showMessageDialog(null, salida, "Listado de transacciones", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay ninguna transacción realizada", "Listado de Transacciones", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case '7':
                    JOptionPane.showMessageDialog(null, "Monto total de transacciones de depósito es: " + rsuma, "Consulta", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case '0':
                    JOptionPane.showMessageDialog(null, "Hasta pronto!", "Saliendo...", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:JOptionPane.showMessageDialog(null, "La opcion elegida no es valida", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcion != '0');
    }

    //validando que la cedula exista
    public static int Vcedula(Cliente vv[], int et, String Scedula) {
        int ei = 1;
        while (ei <= et) {
            if (Scedula.equals(vv[ei].getScedula())) {
                return 1;
            } else {
                ei++;
            }
        }
        return 0;
    }

    //Validando que el numero de cuenta exista
    public static int Vcuenta(Cuenta vv[], int et, int ecuenta) {
        int ei;
        ei = 1;
        while (ei <= et) {
            if (vv[ei].getEcuenta() == ecuenta) {
                return ei;
            } else {
                ei++;
            }
        }
        return 0;
    }
}
