package producto;

public class Bebida extends Producto implements Comestible, ConDescuento {
    private boolean esAlcoholica;
    private double graduacionAlcoholica;
    private double porcentajeDescuento;

    public Bebida(String identificador, String descripcion, double precioVenta, double costo) {
        super(identificador, descripcion, precioVenta, costo);
    }

    
    @Override
    public void setFechaVencimiento(String fechaVencimiento) {
        
    }

    @Override
    public String getFechaVencimiento() {
      
        return "";
    }

    @Override
    public void setCalorias(int calorias) {
        
    }

    @Override
    public int getCalorias() {
      
        return 0;
    }

    // interfaz ConDescuento
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
    	
        //Precio con descuento
    	
        double descuento = getPrecioVenta() * (porcentajeDescuento / 100);
        return getPrecioVenta() - descuento;
    }

    // Getter y setter 
    
    public boolean isEsAlcoholica() {
        return esAlcoholica;
    }

    public void setEsAlcoholica(boolean esAlcoholica) {
        this.esAlcoholica = esAlcoholica;
    }

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

	public void setEsImportado(boolean b) {
	
		
	}
}