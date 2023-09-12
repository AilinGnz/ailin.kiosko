package producto;

public class ProductoLimpieza extends Producto implements ConDescuento {
    private String tipoAplicacion;
    private double porcentajeDescuento;

    public ProductoLimpieza(String identificador, String descripcion, double precioVenta, double costo) {
        super(identificador, descripcion, precioVenta, costo);
    }

    
    @Override
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    @Override
    public double calcularPrecioVentaConDescuento() {

        double descuento = getPrecioVenta() * (porcentajeDescuento / 100);
        return getPrecioVenta() - descuento;
    }

   
    public String getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(String tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }
}