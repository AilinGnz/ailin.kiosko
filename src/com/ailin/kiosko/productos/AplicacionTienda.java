package com.ailin.kiosko.productos;

import inventario.Inventario;
import producto.Bebida;
import producto.Producto;
import producto.ProductoEnvasado;
import producto.ProductoLimpieza;
import producto.ProductoNoPerecedero;
import transacciones.Compra;
import transacciones.Venta;
import usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacionTienda {
    public static void main(String[] args) {
    	
    	
        // Inventario
        Inventario inventario = new Inventario("Ailin Kiosko", 100, 1000.0);

        // Produ Envasado
        ProductoEnvasado producto1 = new ProductoEnvasado("AB001", "Arroz Blanco", 2.99, 1.50);
        producto1.setTipoEnvase("Plástico");
        producto1.setEsImportado(false);
        inventario.agregarProducto(producto1);

        ProductoEnvasado producto2 = new ProductoEnvasado("AB002", "Pasta Penne", 1.75, 0.90);
        producto2.setTipoEnvase("Plástico");
        producto2.setEsImportado(false);
        inventario.agregarProducto(producto2);

        ProductoEnvasado producto3 = new ProductoEnvasado("AB003", "Aceite de Oliva Extra Virgen", 5.99, 4.25);
        producto3.setTipoEnvase("Vidrio");
        producto3.setEsImportado(true);
        inventario.agregarProducto(producto3);

        // Bebidas
        Bebida bebida1 = new Bebida("AC001", "Agua Mineral Natural", 0.99, 0.50);
        bebida1.setEsAlcoholica(false);
        bebida1.setEsImportado(false);
        inventario.agregarProducto(bebida1);

        Bebida bebida2 = new Bebida("AC002", "Cerveza Lager", 2.49, 1.25);
        bebida2.setEsAlcoholica(true);
        bebida2.setGraduacionAlcoholica(5.0);
        bebida2.setEsImportado(false);
        inventario.agregarProducto(bebida2);

        Bebida bebida3 = new Bebida("AC003", "Vino Tinto Reserva", 12.99, 8.75);
        bebida3.setEsAlcoholica(true);
        bebida3.setGraduacionAlcoholica(14.0);
        bebida3.setEsImportado(true);
        inventario.agregarProducto(bebida3);

        // Produ Limpieza
        ProductoLimpieza limpieza1 = new ProductoLimpieza("AZ001", "Detergente para Ropa", 3.49, 2.25);
        limpieza1.setTipoAplicacion("ROPA");
        inventario.agregarProducto(limpieza1);

        ProductoLimpieza limpieza2 = new ProductoLimpieza("AZ002", "Limpiador Multiuso", 2.99, 1.80);
        limpieza2.setTipoAplicacion("MULTIUSO");
        inventario.agregarProducto(limpieza2);

        ProductoLimpieza limpieza3 = new ProductoLimpieza("AZ003", "Escoba de Cerdas Duras", 7.99, 5.50);
        limpieza3.setTipoAplicacion("PISOS");
        inventario.agregarProducto(limpieza3);

        // Cliente
        Cliente cliente1 = new Cliente("Juan", "Calle A");

        // Carrito
        List<Producto> carrito = new ArrayList<>();

        // op Cliente
        System.out.println("Bienvenido a " + inventario.getNombre() + "!");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Realizar compra");
        System.out.println("3. Salir");

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                	
                    // Productos disponibles - Mostrar
                    System.out.println("Productos disponibles:");
                    for (Producto producto : inventario.getProductosDisponibles()) {
                        System.out.println(producto.getIdentificador() + ": " + producto.getDescripcion());
                    }

                    System.out.print("Ingrese el identificador del producto que desea agregar al carrito: ");
                    String identificador = scanner.nextLine();

                    Producto productoEnCarrito = inventario.buscarProductoPorIdentificador(identificador);

                    if (productoEnCarrito != null) {
                        carrito.add(productoEnCarrito);
                        System.out.println("Producto agregado al carrito: " + productoEnCarrito.getDescripcion());
                    } else {
                        System.out.println("Producto no disponible o no encontrado.");
                    }

                    break;
                case 2:
                    // Realizar la Compra
                    double totalCompra = 0.0;
                    for (Producto producto : carrito) {
                        totalCompra += producto.getPrecioVenta();
                    }

                    if (cliente1.realizarCompra(totalCompra)) {
                        for (Producto producto : carrito) {
                            inventario.venderProducto(producto); // Actualizar el inventario
                        }

                        System.out.println("Compra realizada con éxito. Total: $" + totalCompra);
                        System.out.println("Saldo en la caja después de la compra: $" + inventario.getSaldoCaja());

                        // Carrito - Vaciar
                        carrito.clear();
                    } else {
                        System.out.println("Saldo insuficiente para realizar la compra.");
                    }

                    break;
                case 3:
                    // Salir
                    salir = true;
                    System.out.println("Gracias por visitar " + inventario.getNombre() + "!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}