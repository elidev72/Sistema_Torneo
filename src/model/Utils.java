package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	public static String obtenerFechaFormateada(LocalDateTime fecha) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    String fechaFormateada = fecha.format(formatter);
	    return fechaFormateada;
	}
	
}
