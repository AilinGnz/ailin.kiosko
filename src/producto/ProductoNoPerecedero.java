package producto;

public class ProductoNoPerecedero extends Producto {
    private boolean esFragil;

    public ProductoNoPerecedero(String identificador, String descripcion, double precioVenta, double costo) {
        super(identificador, descripcion, precioVenta, costo);
    }

    public boolean isEsFragil() {
        return esFragil;
    }

    public void setEsFragil(boolean esFragil) {
        this.esFragil = esFragil;
    }
}