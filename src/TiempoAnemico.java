import java.time.LocalDate;

public class TiempoAnemico {
	private LocalDate fecha;

	public TiempoAnemico() {
		this.fecha = LocalDate.now();
	}

	public LocalDate getFecha() {
		return fecha;
	}
}
