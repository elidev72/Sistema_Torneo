package model;

import java.time.LocalDate;

public class Jugador extends Persona {
	private float estatura;
	private float peso;
	private String posicion;
	private int numeroDeCamiseta;
	
	public Jugador(String apellido, String nombre, String dni, LocalDate fechaDeNacimiento, float estatura,
			float peso, String posicion, int numeroDeCamiseta) throws Exception {
		super(apellido, nombre, dni, fechaDeNacimiento);
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
		this.numeroDeCamiseta = numeroDeCamiseta;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getNumeroDeCamiseta() {
		return numeroDeCamiseta;
	}

	public void setNumeroDeCamiseta(int numeroDeCamiseta) {
		this.numeroDeCamiseta = numeroDeCamiseta;
	}

	@Override
	public String toString() {
		return "Jugador " + super.toString() + ", estatura=" + estatura + ", peso=" + peso + ", posicion=" + posicion
				+ ", numeroDeCamiseta=" + numeroDeCamiseta + "]";
	}	
	
}
