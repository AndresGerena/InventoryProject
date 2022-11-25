package Main;

import java.util.*;

import Controller.Suppliers;
import Controller.Clients;
import Controller.UAdmins;

public class Main {

    static int op, opc, opa, op2;
    public static String[] productos;
    public static Scanner sc = new Scanner(System.in);

    //----Data Base----
    public static Suppliers sp = new Suppliers();
    public static UAdmins adm = new UAdmins();
    public static Clients clt = new Clients();
    //--------

    //----Factory Pattern----
    //......
    //--------
    public static void main(String[] args) {
        
        sp.readSupplier();
        
        System.out.println("Bienvenido al programa:\n----------PROYECTO INVENTARIO----------");
        System.out.println("Creado por: \nAndrés Gerena\nFabián Suarez\nCamila Mosquera\nSantiago Carvajal\nValery Ospina");
        do {
            System.out.println("\n--------INDIQUE SU ROL--------");
            System.out.println("1- Cliente \n2- Admin \n3- Salir del programa");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    do {
                        System.out.println("\n------MENÚ DE CLIENTE------");
                        System.out.println("Qué desea hacer? \n1- Ver lista de productos \n2- Comprar productos \n3- Volver");
                        opc = Integer.parseInt(sc.nextLine());
                        switch (opc) {
                            case 1:
                                System.out.println("\n----LISTA DE PRODUCTOS----");
                                break;

                            case 2:
                                System.out.println("\n----COMPRAR PRODUCTO----");
                                do {

                                    //Cuál producto?????? ingrese código
                                    System.out.println("\n---MÉTODO DE PAGO---");
                                    System.out.println("1- Banco \n2- DaviPlata \n3- Volver");
                                    op2 = Integer.parseInt(sc.nextLine());
                                    switch (op2) {
                                        case 1:
                                            System.out.println("\n--BANCO--");
                                            System.out.println("\n");
                                            //new FactoryPattern();
                                            //PetShop ps = new PetShop();
                                            //ps.generarPago();

                                            break;

                                        case 2:
                                            System.out.println("\n--DAVIPLATA--");
                                            //new FactoryPattern();

                                            break;

                                        case 3:
                                            break;

                                        default:
                                            System.out.println("\nOpción no valida!!!");
                                    }
                                } while (op2 != 3);
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("\nOpción no valida!!!");
                        }
                    } while (opc != 3);
                    break;

                case 2:
                    opa = 0;
                    do {
                        System.out.println("\n------MENÚ DE ADMIN------");
                        System.out.println("Qué desea hacer? \n1- Ver lista de productos \n2- Agregar producto \n3- Volver"); //Se piensan implementar las opciones actualizar y borrar producto
                        opa = Integer.parseInt(sc.nextLine());
                        switch (opa) {
                            case 1:
                                System.out.println("\n----LISTA DE PRODUCTOS----");
                                break;

                            case 2:
                                System.out.println("\n----AGREGAR PRODUCTO----");
                                System.out.println("Ingrese el código del producto: ");
                                int codigo = Integer.parseInt(sc.nextLine());
                                System.out.println("Ingrese el nombre del producto: ");
                                String nombre = sc.nextLine();
                                System.out.println("Ingrese el precio del producto: ");
                                String precio = sc.nextLine();
                                System.out.println("Ingrese el stock del producto: ");
                                int stock = Integer.parseInt(sc.nextLine());
                                System.out.println("Ingrese la fecha de vencimiento del producto: ");
                                String vencimiento = sc.nextLine();
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("\nOpción no valida!!!");
                        }
                    } while (opa != 3);
                    break;

                case 3:
                    System.out.println("\nHasta luego");
                    break;

                default:
                    System.out.println("\nOpción no valida!!!");
            }
        } while (op != 3);
    }
}
