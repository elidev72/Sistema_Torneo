package model;

import java.util.Objects;

public class EstadisticaPartidoJugador {
	private static long nextId = 1;
	
	private final long id;
	private Jugador jugador;
	private int goles;
	private int asistencias;
	private int minutosJugados;
	
	public EstadisticaPartidoJugador(Jugador jugador, int goles, int asistencias, int minutosJugados) {
		super();
		this.id = EstadisticaPartidoJugador.nextId++;
		this.jugador = jugador;
		this.goles = goles;
		this.asistencias = asistencias;
		this.minutosJugados = minutosJugados;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getMinutosJugados() {
		return minutosJugados;
	}

	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}

	public static long getNextId() {
		return nextId;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "EstadisticaPartidoJugador [id=" + id + ", jugador=" + jugador + ", goles=" + goles
				+ ", asistencias=" + asistencias + ", minutosJugados=" + minutosJugados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(jugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticaPartidoJugador other = (EstadisticaPartidoJugador) obj;
		return Objects.equals(jugador, other.jugador);
	}
	
	
}
