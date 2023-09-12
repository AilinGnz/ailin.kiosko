package producto;

public class ProductoEnvasado extends Producto implements Comestible, ConDescuento {
    private String tipoEnvase;
    private boolean esImportado;
    private String fechaVencimiento;
    private int calorias;
    private double porcentajeDescuento;

    public ProductoEnvasado(String identificador, String descripcion, double precioVenta, double costo) {
        super(identificador, descripcion, precioVenta, costo);
    }

   
    @Override
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public int getCalorias() {
        return calorias;
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

    
    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public boolean isEsImportado() {
        return esImportado;
    }

    public void setEsImportado(boolean esImportado) {
        this.esImportado = esImportado;
    }
}