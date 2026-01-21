package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private static long nextId = 1;
	
	private final long id;
	private String nombre;
	private String codigoUnico;
	private LocalDate fechaFundacion;
	private Entrenador entrenador;
	private List<Jugador> ltsJugadores = new ArrayList<Jugador>();
	
	public Equipo(String nombre, LocalDate fechaFundacion, Entrenador entrenador) throws Exception {
		super();
		this.id = Equipo.nextId++;
		this.nombre = nombre;
		this.setCodigoUnico(nombre);
		this.fechaFundacion = fechaFundacion;
		this.entrenador = entrenador;
	}

	public static long getNextId() {
		return nextId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

    public void setCodigoUnico(String nombre) {

        if (nombre != null && nombre.length() >= 3) {
            // Toma las primeras 3 letras del nombre
            this.codigoUnico = nombre.substring(0, 3).toUpperCase();
        } else if (nombre != null && nombre.length() < 3) {
            // Si el nombre tiene menos de 3 letras, usamos todo el nombre
            this.codigoUnico = nombre.toUpperCase();
        } else {
            // Si el nombre es nulo, puedes lanzar una excepción o asignar un valor por
            // defecto
            this.codigoUnico = "no tiene nombre"; // Valor por defecto
        }
    }

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getLtsJugadores() {
		return List.copyOf(ltsJugadores);
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", codigoUnico=" + codigoUnico + ", fechaFundacion="
				+ fechaFundacion + ", entrenador=" + entrenador + "]";
	}

	public boolean equals(Equipo equipo) {
		return codigoUnico.equalsIgnoreCase(equipo.getCodigoUnico());
	}

	public boolean agregarJugador(Jugador jugador) throws Exception {
		if(this.getLtsJugadores().contains(jugador))
			throw new Exception("ERROR: El equipo ya contiene al jugador.");
		
		return this.ltsJugadores.add(jugador);
	}
	
	public float promedioDeAltura() {
		float promedio = 0;
		List<Jugador> lstJugador = this.getLtsJugadores();
		
		for(Jugador j: lstJugador)
			promedio += j.getEstatura();
		
		return lstJugador.isEmpty() ? 0f : promedio / lstJugador.size();
	}

	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
}
