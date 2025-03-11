
public class MainAnemico {
	public static void main(String[] args) {
		var tiempo = new TiempoAnemico();
		
		System.out.println("Fecha en formato largo: " + tiempo.getFechaFormatoLargo());
		System.out.println("Fecha en formato corto: " + tiempo.getFechaFormatoCorto());
	}
}
