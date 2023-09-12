package producto;

public class Producto {
	private String identificador;
    private String descripcion;
    private int cantidadEnStock;
    private double precioVenta;
    private double costo;
    private boolean disponibleParaVenta;

    public Producto(String identificador, String descripcion, double precioVenta, double costo) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.costo = costo;
        this.cantidadEnStock = 0;
        this.disponibleParaVenta = true;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isDisponibleParaVenta() {
        return disponibleParaVenta;
    }

    public void setDisponibleParaVenta(boolean disponibleParaVenta) {
        this.disponibleParaVenta = disponibleParaVenta;
    }
}