package model;

import java.time.LocalDate;

public abstract class Persona {
	private static long lNextId = 1;
	
	private final long lId;
	private String sApellido;
	private String sNombre;
	private String sDNI;
	private LocalDate ldFechaDeNacimiento;	

	public Persona(String sApellido, String sNombre, String sDNI, LocalDate ldFechaDeNacimiento) {
		super();
		this.lId = Persona.lNextId++;
		this.sApellido = sApellido;
		this.sNombre = sNombre;
		this.sDNI = sDNI;
		this.ldFechaDeNacimiento = ldFechaDeNacimiento;
	}

	public String getsApellido() {
		return sApellido;
	}

	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsDNI() {
		return sDNI;
	}

	public void setsDNI(String sDNI) {
		this.sDNI = sDNI;
	}

	public LocalDate getDtFechaDeNacimiento() {
		return ldFechaDeNacimiento;
	}

	public void setDtFechaDeNacimiento(LocalDate ldFechaDeNacimiento) {
		this.ldFechaDeNacimiento = ldFechaDeNacimiento;
	}

	public long getlId() {
		return lId;
	}

	public static long getlNextId() {
		return lNextId;
	}

	@Override
	public String toString() {
		return "[lId=" + lId + ", sApellido=" + sApellido + ", sNombre=" + sNombre + ", sDNI=" + sDNI
				+ ", dtFechaDeNacimiento=" + ldFechaDeNacimiento;
	}
	
	
}
