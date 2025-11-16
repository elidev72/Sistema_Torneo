package model;

import java.time.LocalDate;

public class Jugador extends Persona {
	private float fEstatura;
	private float fPeso;
	private String sPosición;
	private int iNumeroDeCamiseta;
	
	public Jugador(String sApellido, String sNombre, String sDNI, LocalDate ldFechaDeNacimiento, float fEstatura,
			float fPeso, String sPosición, int iNumeroDeCamiseta) {
		super(sApellido, sNombre, sDNI, ldFechaDeNacimiento);
		this.fEstatura = fEstatura;
		this.fPeso = fPeso;
		this.sPosición = sPosición;
		this.iNumeroDeCamiseta = iNumeroDeCamiseta;
	}

	public float getfEstatura() {
		return fEstatura;
	}

	public void setfEstatura(float fEstatura) {
		this.fEstatura = fEstatura;
	}

	public float getfPeso() {
		return fPeso;
	}

	public void setfPeso(float fPeso) {
		this.fPeso = fPeso;
	}

	public String getsPosición() {
		return sPosición;
	}

	public void setsPosición(String sPosición) {
		this.sPosición = sPosición;
	}

	public int getiNumeroDeCamiseta() {
		return iNumeroDeCamiseta;
	}

	public void setiNumeroDeCamiseta(int iNumeroDeCamiseta) {
		this.iNumeroDeCamiseta = iNumeroDeCamiseta;
	}

	@Override
	public String toString() {
		return "Jugador " + super.toString() + ", fEstatura=" + fEstatura + ", fPeso=" + fPeso + ", sPosición=" + sPosición
				+ ", iNumeroDeCamiseta=" + iNumeroDeCamiseta + "]";
	}
	
}
