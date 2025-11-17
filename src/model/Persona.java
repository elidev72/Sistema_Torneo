package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Persona {
	private static long lNextId = 1;
	
	private final long lId;
	private String sApellido;
	private String sNombre;
	private String sDNI;
	private LocalDate ldFechaDeNacimiento;	

	public Persona(String sApellido, String sNombre, String sDNI, LocalDate ldFechaDeNacimiento) throws Exception {
		super();
		this.lId = Persona.lNextId++;
		this.sApellido = sApellido;
		this.sNombre = sNombre;
		this.sDNI = sDNI;
		this.setLtFechaDeNacimiento(ldFechaDeNacimiento);
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

	public LocalDate getLtFechaDeNacimiento() {
		return ldFechaDeNacimiento;
	}

	public void setLtFechaDeNacimiento(LocalDate ldFechaDeNacimiento) throws Exception {
		LocalDate ldHoy = LocalDate.now();
		
		Period periodo = Period.between(ldFechaDeNacimiento, ldHoy);
	    
	    if (periodo.getYears() < 18)
	        throw new Exception("ERROR: La persona debe tener al menos 18 años.");
		
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(sDNI, other.sDNI);
	}
	
}
