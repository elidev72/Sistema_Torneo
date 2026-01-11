package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Persona {
	private static long nextId = 1;
	
	private final long id;
	private String apellido;
	private String nombre;
	private String dni;
	private LocalDate fechaDeNacimiento;	

	public Persona(String apellido, String nombre, String dni, LocalDate fechaDeNacimiento) throws Exception {
		super();
		this.id = Persona.nextId++;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.setFechaDeNacimiento(fechaDeNacimiento);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) throws Exception {
		LocalDate hoy = LocalDate.now();
		
		Period periodo = Period.between(fechaDeNacimiento, hoy);
	    
	    if (periodo.getYears() < 18)
	        throw new Exception("ERROR: La persona debe tener al menos 18 años.");
		
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public long getId() {
		return id;
	}

	public static long getNextId() {
		return nextId;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", dtFechaDeNacimiento=" + fechaDeNacimiento;
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
		return Objects.equals(dni, other.dni);
	}
	
}
