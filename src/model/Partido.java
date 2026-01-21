package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Partido {
	private static long nextId = 1;
	
	private final long id;
	private LocalDateTime fecha;
	private String estadio;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private List<EstadisticaPartidoJugador> ltsEstadisticasJugadores = new ArrayList<EstadisticaPartidoJugador>();
	
	public Partido(LocalDateTime fecha, String estadio, Equipo equipoLocal, Equipo equipoVisitante) {
		super();
		this.id = Partido.nextId++;
		this.fecha = fecha;
		this.estadio = estadio;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
	}

	public static long getNextId() {
		return nextId;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public List<EstadisticaPartidoJugador> getLtsEstadisticasJugadores() {
		return List.copyOf(ltsEstadisticasJugadores);
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		String retorno = "Partido [id=" + id + ", fecha=" + Utils.obtenerFechaFormateada(fecha) + ", estadio=" + estadio + " | "
				+ equipoLocal.getNombre();
		
		if(!this.getLtsEstadisticasJugadores().isEmpty()) {
			retorno += " " + this.calcularGoles(equipoLocal) + " - " + this.calcularGoles(equipoVisitante) + " " + equipoVisitante.getNombre() + " | Resultado: ";
			
			if(this.ganador() != null) {
				retorno += "Ganó " + this.ganador().getNombre();
			} else
				retorno += "Empate";
			
		} else
			retorno += " vs " + equipoVisitante.getNombre() + " | Estado: Sin disputar";
		
		return retorno + "]";
	}
	
	public boolean equals(Partido partido) {
		return fecha.equals(partido.getFecha()) && estadio.equalsIgnoreCase(partido.getEstadio());
	}

	private int calcularGoles(Equipo equipo) {
		int goles = 0;
		
		for(EstadisticaPartidoJugador e: this.getLtsEstadisticasJugadores()) {
			
			if(equipo.getLtsJugadores().contains(e.getJugador()))
				goles += e.getGoles();
			
		}
		
		return goles;
	}
	
	public Equipo ganador() {
		Equipo ganador = null;
		
		if(this.calcularGoles(this.getEquipoLocal()) < this.calcularGoles(getEquipoVisitante())) {
			ganador = this.equipoVisitante;
		} 
		else if(this.calcularGoles(this.getEquipoLocal()) > this.calcularGoles(getEquipoVisitante()))
			ganador = this.equipoLocal;
		
		return ganador;
	}
	
	public boolean agregarEstadisticaPartido(Jugador jugador, int goles, int asistencias, int minutosJugados) throws Exception {
		List<Jugador> lst = new ArrayList<>(this.getEquipoLocal().getLtsJugadores());
		lst.addAll(this.getEquipoVisitante().getLtsJugadores());
		
		if(!lst.contains(jugador))
			throw new Exception("ERROR: Jugador no pertenece a ninguno de los 2 equipos.");
		
		EstadisticaPartidoJugador aux = new EstadisticaPartidoJugador(jugador, goles, asistencias, minutosJugados);
		if(this.getLtsEstadisticasJugadores().contains(aux))
			throw new Exception("ERROR: Jugador ya tiene estadisticas en el partido.");
		
		return this.ltsEstadisticasJugadores.add(aux);
	}
	
}
