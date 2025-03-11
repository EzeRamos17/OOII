import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TiempoNoAnemico {
	private LocalDate fecha;
	
	public TiempoNoAnemico() {
		this.fecha = LocalDate.now();
	}
	
	public void imprimirFechaFormatoLargo() {
		String formatoLargo = fecha.format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES")));
		System.out.println("Fecha en formato largo: " + formatoLargo);
	}
	
	public void imprimirFechaFormatoCorto() {
		String formatoCorto = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Fecha en formato corto: " + formatoCorto);
	}
}
