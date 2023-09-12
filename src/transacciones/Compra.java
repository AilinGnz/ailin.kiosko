package transacciones;

import producto.Producto;
import usuarios.Cliente;

public class Compra {
    private Cliente proveedor;
    private Producto[] productosComprados;
    private double totalCompra;

    public Compra(Cliente proveedor, Producto[] productosComprados) {
        this.proveedor = proveedor;
        this.productosComprados = productosComprados;
        calcularTotalCompra();
    }

    public Cliente getProveedor() {
        return proveedor;
    }

    public void setProveedor(Cliente proveedor) {
        this.proveedor = proveedor;
    }

    public Producto[] getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(Producto[] productosComprados) {
        this.productosComprados = productosComprados;
        calcularTotalCompra();
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    private void calcularTotalCompra() {
        totalCompra = 0;
        for (Producto producto : productosComprados) {
            totalCompra += producto.getCosto();
        }
    }
}