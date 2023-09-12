package producto;

public interface ConDescuento {

	void setPorcentajeDescuento(double porcentajeDescuento);
    double getPorcentajeDescuento();
    double calcularPrecioVentaConDescuento();
}