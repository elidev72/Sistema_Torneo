package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Torneo {
	private static long nextId = 1;
	
	private final long id;
	private String nombre;
	private String temporada;
	private LocalDate fechaDeInicio;
	private LocalDate fechaDeFin;
	private List<Equipo> ltsEquipos = new ArrayList<Equipo>();
	private List<Partido> ltsPartidos = new ArrayList<Partido>();
	
	public Torneo(String nombre, String temporada, LocalDate fechaDeInicio, LocalDate fechaDeFin) throws Exception {
		this.id = Torneo.nextId++;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaDeInicio = fechaDeInicio;
		this.setFechaDeFin(fechaDeFin);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}
	
	private void validarFechas(LocalDate inicio, LocalDate fin) throws Exception {
		if (inicio.isAfter(fin))
	        throw new Exception("ERROR: La fecha de inicio (" + inicio + ") no puede ser posterior a la fecha de fin (" + fin + ").");
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) throws Exception {
		this.validarFechas(fechaDeInicio, this.fechaDeFin);
		this.fechaDeInicio = fechaDeInicio;
	}

	public LocalDate getFechaDeFin() {
		return fechaDeFin;
	}

	public void setFechaDeFin(LocalDate fechaDeFin) throws Exception {
		this.validarFechas(this.fechaDeInicio, fechaDeFin);
		this.fechaDeFin = fechaDeFin;
	}

	public List<Equipo> getLtsEquipos() {
		return List.copyOf(ltsEquipos);
	}

	public static long getNextId() {
		return nextId;
	}

	public long getId() {
		return id;
	}

	public List<Partido> getLtsPartidos() {
		return List.copyOf(ltsPartidos);
	}

	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaDeInicio="
				+ fechaDeInicio + ", fechaDeFin=" + fechaDeFin + "]";
	}

	public boolean equals(Torneo torneo) {
		return nombre.equalsIgnoreCase(torneo.getNombre()) && temporada.equalsIgnoreCase(torneo.getTemporada());
	}

	public boolean agregarEquipo(Equipo equipo) throws Exception {
		if(this.getLtsEquipos().contains(equipo))
			throw new Exception("ERROR: El equipo ya esta en el torneo");
		
		return this.ltsEquipos.add(equipo);
	}
	
	public boolean agregarPartido(Partido partido) throws Exception {
		if(this.getLtsPartidos().contains(partido))
			throw new Exception("ERROR: El partido ya esta en el torneo");
		
		return this.ltsPartidos.add(partido);
	}
	
	public List<Entrenador> tacticaPreferidaPorEntrenador(String tactica){
		List<Entrenador> lstEntrenadores = new ArrayList<Entrenador>();
		
		for(Equipo e: this.getLtsEquipos()) {
			Entrenador entrenador = e.getEntrenador();
			
			if(entrenador.getEstrategiaFavorita().equalsIgnoreCase(tactica))
				lstEntrenadores.add(entrenador);
			
		}
		
		return lstEntrenadores;
	}
	
	public List<Equipo> fundadosAntesDe(LocalDate ldFecha){
		List<Equipo> lstEquipo = new ArrayList<Equipo>();
		
		for(Equipo e: this.getLtsEquipos()) {
			
			if(e.getFechaFundacion().isBefore(ldFecha))
				lstEquipo.add(e);
			
		}
		
		return lstEquipo;
	}
	
	public List<Jugador> jugadoresNacidosEntreDosFechas(LocalDate fechaInicial, LocalDate fechaFinal){
		List<Jugador> lstJugador = new ArrayList<Jugador>();
		
		for(Equipo e: this.getLtsEquipos()) {
			
			for(Jugador j: e.getLtsJugadores()) {
				LocalDate ldAux = j.getFechaDeNacimiento();
				
				if(ldAux.isAfter(fechaInicial) && ldAux.isBefore(fechaFinal))
					lstJugador.add(j);
				
			}
			
		}
		
		return lstJugador;
	}
	
	public int puntosPorEquipo(Equipo equipo) {
		int puntos = 0;
		
		List<Partido> partidos = this.getLtsPartidos();
		for(Partido p: partidos) {
			
			if(p.getEquipoLocal().equals(equipo) || p.getEquipoVisitante().equals(equipo)) {
				Equipo ganador = p.ganador();
				
				if(ganador == null) {
					puntos++;
				}
				else if(ganador.equals(equipo))
					puntos += 3;
				
			}
			
			
		}
		
		return puntos;
	}
	
	public Partido traerPartidoPorId(long id) throws Exception {
		Partido partido = null;
		int i = 0, tam = this.ltsPartidos.size();
		
		while(partido == null && i<tam) {
			Partido aux = this.getLtsPartidos().get(i);
			
			if(aux.getId() == id)
				partido = aux;
			
			i++;
		}
		
		if(partido == null)
			throw new Exception("ERROR: El partido no existe en el torneo.");
		
		return partido;
	}
	
	public EstadisticasTorneoJugador calculoEstadisticasJugadorPorTorneo(Jugador jugador) throws Exception {
		boolean existe = false;
		int i = 0, tam = this.ltsEquipos.size();
		
		while(!existe && i < tam) {
			List<Jugador> lst = this.ltsEquipos.get(i).getLtsJugadores();
			
			if(lst.contains(jugador))
				existe = true;
			
			i++;
		}
		
		if(!existe)
			throw new Exception("El jugador no existe en el torneo.");
		
		EstadisticasTorneoJugador ETJ = new EstadisticasTorneoJugador(jugador);
		
		for(Partido p: this.ltsPartidos) {
			
			for(EstadisticaPartidoJugador j: p.getLtsEstadisticasJugadores()) {
				
				if(j.getJugador().equals(jugador)) 
					ETJ.sumarEstadisticaPartido(j.getGoles(), j.getAsistencias(), j.getMinutosJugados());
				
			}
				
		}
		
		return ETJ;
	}
	
	public List<EstadisticasTorneoJugador> listaDeEstadisticaDeJugadores() throws Exception{
		List<EstadisticasTorneoJugador> lst = new ArrayList<>();
		
		for(Equipo e: this.ltsEquipos) {
			
			for(Jugador j: e.getLtsJugadores()) {
				EstadisticasTorneoJugador aux = this.calculoEstadisticasJugadorPorTorneo(j);
				
				if(aux.getTotalAsistencias() > 0 || aux.getTotalGoles() > 0)
					lst.add(aux);
				
			}
			
		}
		
		return lst;
	}
	
}
