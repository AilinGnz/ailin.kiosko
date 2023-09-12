package transacciones;

import producto.Producto;
import usuarios.Cliente;

public class Venta {
    private Cliente cliente;
    private Producto[] productosVendidos;
    private double totalVenta;

    public Venta(Cliente cliente, Producto[] productosVendidos) {
        this.cliente = cliente;
        this.productosVendidos = productosVendidos;
        calcularTotalVenta();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(Producto[] productosVendidos) {
        this.productosVendidos = productosVendidos;
        calcularTotalVenta();
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    private void calcularTotalVenta() {
        totalVenta = 0;
        for (Producto producto : productosVendidos) {
            totalVenta += producto.getPrecioVenta();
        }
    }
}