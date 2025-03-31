import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainAnemico {
    public static void main(String[] args) {
        var tiempo = new TiempoAnemico();

        System.out.println("Fecha en formato largo: " + tiempo.getFecha().format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"))));
        System.out.println("Fecha en formato corto: " + tiempo.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
