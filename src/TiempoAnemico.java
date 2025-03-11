import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TiempoAnemico {
	private LocalDate fecha;
	
	public TiempoAnemico() {
		this.fecha = LocalDate.now();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getFechaFormatoLargo() {
		return fecha.format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES")));
	}
	
	public String getFechaFormatoCorto() {
		return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
