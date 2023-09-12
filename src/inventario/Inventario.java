package inventario;

import producto.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {
    private String nombre;
    private int numeroMaximoProductos;
    private double saldoCaja;
    private Map<String, List<Producto>> productosEnStock;

    public Inventario(String nombre, int numeroMaximoProductos, double saldoCaja) {
        this.nombre = nombre;
        this.numeroMaximoProductos = numeroMaximoProductos;
        this.saldoCaja = saldoCaja;
        this.productosEnStock = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroMaximoProductos() {
        return numeroMaximoProductos;
    }

    public void setNumeroMaximoProductos(int numeroMaximoProductos) {
        this.numeroMaximoProductos = numeroMaximoProductos;
    }

    public double getSaldoCaja() {
        return saldoCaja;
    }

    public void setSaldoCaja(double saldoCaja) {
        this.saldoCaja = saldoCaja;
    }

    public Map<String, List<Producto>> getProductosEnStock() {
        return productosEnStock;
    }

    public void agregarProducto(Producto producto) {
    	
    	
       
        if (productosEnStock.size() < numeroMaximoProductos) {
            
            List<Producto> listaProductos = productosEnStock.getOrDefault(producto.getIdentificador(), new ArrayList<>());
           
            listaProductos.add(producto);
            
            productosEnStock.put(producto.getIdentificador(), listaProductos);
            
            saldoCaja -= producto.getPrecioVenta() * producto.getCantidadEnStock();
        } else {
            System.out.println("No hay espacio en el inventario para agregar más productos.");
        }
    }

    public void venderProducto(Producto producto) {
    	
    	
        // Stock Dispo
    	
        if (productosEnStock.containsKey(producto.getIdentificador()) && producto.isDisponibleParaVenta()) {
        	
        	
            // Lista Produ
        	
            List<Producto> listaProductos = productosEnStock.get(producto.getIdentificador());
            if (listaProductos != null && listaProductos.size() > 0) {
            	
            	
                // VentaProducto
            	
            	
                Producto productoAVender = listaProductos.get(0);
                int cantidadAVender = producto.getCantidadEnStock();
                if (cantidadAVender > productoAVender.getCantidadEnStock()) {
                    cantidadAVender = productoAVender.getCantidadEnStock();
                }
                productoAVender.setCantidadEnStock(productoAVender.getCantidadEnStock() - cantidadAVender);
                
                // Saldo Caja
                
                saldoCaja += producto.getPrecioVenta() * cantidadAVender;
            }
        } else {
            System.out.println("El producto no se encuentra disponible para la venta: " + producto.getDescripcion());
        }
    }

    public Producto[] getProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (List<Producto> listaProductos : productosEnStock.values()) {
            for (Producto producto : listaProductos) {
                if (producto.isDisponibleParaVenta()) {
                    disponibles.add(producto);
                }
            }
        }
        return disponibles.toArray(new Producto[0]);
    }

    public Producto buscarProductoPorIdentificador(String identificador) {
        if (productosEnStock.containsKey(identificador)) {
            List<Producto> listaProductos = productosEnStock.get(identificador);
            if (listaProductos != null && !listaProductos.isEmpty()) {
                return listaProductos.get(0);
            }
        }
        return null;
    }
}