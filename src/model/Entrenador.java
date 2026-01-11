package model;

import java.time.LocalDate;

public class Entrenador extends Persona {
	private String estrategiaFavorita;

	public Entrenador(String apellido, String nombre, String dni, LocalDate fechaDeNacimiento,
			String estrategiaFavorita) throws Exception {
		super(apellido, nombre, dni, fechaDeNacimiento);
		this.estrategiaFavorita = estrategiaFavorita;
	}

	public String getEstrategiaFavorita() {
		return estrategiaFavorita;
	}

	public void setEstrategiaFavorita(String estrategiaFavorita) {
		this.estrategiaFavorita = estrategiaFavorita;
	}

	@Override
	public String toString() {
		return "Entrenador " + super.toString() + ", estrategiaFavorita=" + estrategiaFavorita + "]";
	}
	
	
}
