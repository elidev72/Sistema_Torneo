package model;

import java.time.LocalDate;

public class Entrenador extends Persona {
	private String sEstrategiaFavorita;

	public Entrenador(String sApellido, String sNombre, String sDNI, LocalDate ldFechaDeNacimiento,
			String sEstrategiaFavorita) {
		super(sApellido, sNombre, sDNI, ldFechaDeNacimiento);
		this.sEstrategiaFavorita = sEstrategiaFavorita;
	}

	public String getsEstrategiaFavorita() {
		return sEstrategiaFavorita;
	}

	public void setsEstrategiaFavorita(String sEstrategiaFavorita) {
		this.sEstrategiaFavorita = sEstrategiaFavorita;
	}

	@Override
	public String toString() {
		return "Entrenador " + super.toString() + ", sEstrategiaFavorita=" + sEstrategiaFavorita + "]";
	}
	
	
}
