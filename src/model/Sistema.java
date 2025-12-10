package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sistema {
	private static final Sistema instance = new Sistema();
	
	private List<Torneo> ltsTorneos = new ArrayList<Torneo>();
	private List<Equipo> ltsEquipos = new ArrayList<Equipo>();
	private List<Jugador> ltsJugadores = new ArrayList<Jugador>();
	private List<Entrenador> ltsEntrenadores = new ArrayList<Entrenador>();
	
	private Sistema() {}
	
	public static Sistema getInstance() {
		return Sistema.instance;
	}
	
	public List<Torneo> getLtsTorneos() {
		return List.copyOf(ltsTorneos);
	}

	public List<Equipo> getLtsEquipos() {
		return List.copyOf(ltsEquipos);
	}

	public List<Jugador> getLtsJugadores() {
		return List.copyOf(ltsJugadores);
	}

	public List<Entrenador> getLtsEntrenadores() {
		return List.copyOf(ltsEntrenadores);
	}
	
	// Agregar
	public boolean agregarTorneoASistema(String nombre, String temporada, LocalDate fechaDeInicio, LocalDate fechaDeFin) throws Exception {
		Torneo torneo = new Torneo(nombre, temporada, fechaDeInicio, fechaDeFin);
		
		if(this.getLtsTorneos().contains(torneo))
			throw new Exception("ERROR: Torneo ya existe en el Sistema");
		
		return this.ltsTorneos.add(torneo);
	}
	
	public boolean agregarEquipoATorneoYSistema(String nombre, String codigoUnico, LocalDate fechaFundacion, Entrenador entrenador, long idTorneo) throws Exception {
		Torneo torneo = this.traerTorneoPorId(idTorneo);
		
		if(torneo == null)
			throw new Exception("No existe el torneo de id: " + idTorneo);
		
		Equipo equipo = new Equipo(nombre, codigoUnico, fechaFundacion, entrenador);
		
		if(!this.getLtsEquipos().contains(equipo))
			this.ltsEquipos.add(equipo);
		
		return torneo.agregarEquipo(equipo);
	}
	
	public boolean agregarJugadorAEquipoYSistema(String apellido, String nombre, String dni, LocalDate fechaDeNacimiento, float estatura,
			float peso, String posicion, int numeroDeCamiseta, String codigoEquipo) throws Exception {
		Equipo equipo = this.traerEquipoPorCodigoUnico(codigoEquipo);
		
		if(equipo == null)
			throw new Exception("No existe el equipo con codigo: " + codigoEquipo);
		
		Jugador jugador = new Jugador(apellido, nombre, dni, fechaDeNacimiento, estatura, peso, posicion, numeroDeCamiseta);
		
		if(!this.getLtsJugadores().contains(jugador))
			this.ltsJugadores.add(jugador);

		return equipo.agregarJugador(jugador);
	}
	
	public boolean agregarEntrenadorASistema(String apellido, String nombre, String dni, LocalDate fechaDeNacimiento, String estrategiaFavorita) throws Exception {
		Entrenador entrenador = new Entrenador(apellido, nombre, dni, fechaDeNacimiento, estrategiaFavorita);
		boolean agregado = false;
		
		if(!this.getLtsEntrenadores().contains(entrenador))
			agregado = this.ltsEntrenadores.add(entrenador);
		
		return agregado;
	}
	
	private Torneo existeTorneo(long idTorneo) throws Exception {
		Torneo torneo = this.traerTorneoPorId(idTorneo);
		
		if(torneo == null)
			throw new Exception("ERROR: no existe el torneo con id " + idTorneo);
		
		return torneo;
	}
	
	public boolean agregarPartidoEnTorneo(long idTorneo, LocalDateTime fecha, String estadio, Equipo equipoLocal, Equipo equipoVisitante) throws Exception {
		Torneo torneo = existeTorneo(idTorneo);
		
		Partido partido = new Partido(fecha, estadio, equipoLocal, equipoVisitante);
		
		return torneo.agregarPartido(partido);
	}
	
	// Traer
	public Torneo traerTorneoPorId(long id) {
		Torneo aux = null, temp;
		int i = 0, tam = this.ltsTorneos.size();
		
		while(aux == null && i < tam) {
			temp = this.ltsTorneos.get(i);
			
			if(temp.getId() == id)
				aux = temp;
			
			i++;
		}
		
		return aux;
	}

	public Equipo traerEquipoPorCodigoUnico(String codigoUnico) throws Exception {
		Equipo aux = null, temp;
		int i = 0, tam = this.ltsEquipos.size();
		
		while(aux == null && i < tam) {
			temp = this.getLtsEquipos().get(i);
			
			if(temp.getsCodigoUnico().equalsIgnoreCase(codigoUnico))
				aux = temp;
			
			i++;
		}
		
		if(aux == null)
			throw new Exception("ERROR: El equipo no existe en el torneo.");
		
		return aux;
	}
	
	public Entrenador traerEntrenadorPorDni(String dni) throws Exception {
		Entrenador aux = null, temp;
		int i = 0, tam = this.getLtsEntrenadores().size();
		
		while(aux == null && i < tam) {
			temp = this.ltsEntrenadores.get(i);
			
			if(temp.getDni().equalsIgnoreCase(dni))
				aux = temp;
			
			i++;
		}
		
		if(aux == null)
			throw new Exception("No existe el entrenador con DNI: " + dni);
		
		return aux;
	}
	
	public Jugador traerJugadorPorDni(String dni) throws Exception {
		Jugador aux = null, temp;
		int i = 0, tam = this.getLtsJugadores().size();
		
		while(aux == null && i < tam) {
			temp = this.ltsJugadores.get(i);
			
			if(temp.getDni().equalsIgnoreCase(dni))
				aux = temp;
			
			i++;
		}
		
		if(aux == null)
			throw new Exception("No existe el jugador con DNI: " + dni);
		
		return aux;
	}
	
	public List<Entrenador> tacticaPreferidaPorEntrenador(Torneo torneo, String tactica){
		return torneo.tacticaPreferidaPorEntrenador(tactica);
	}
	
	public List<Jugador> jugadoresNacidosEntreDosFechasDeUnTorneo(Torneo torneo, LocalDate fechaInicial, LocalDate fechaFinal){
		return torneo.jugadoresNacidosEntreDosFechas(fechaInicial, fechaFinal);
	}
	
	public List<Equipo> fundadosAntesDe(Torneo torneo, LocalDate ldFecha){
		return torneo.fundadosAntesDe(ldFecha);
	}
	
	public String equipoConMasAltura(Torneo torneo) throws Exception {
		List<Equipo> lstEquipo = torneo.getLtsEquipos();
		if(lstEquipo.isEmpty())
			throw new Exception("ERROR: No se puede calcular altura ya que no hay equipos en el torneo");
		
		float aux, max = Float.NEGATIVE_INFINITY;
		String retorno = " ";
		
		for(Equipo e: lstEquipo) {
			aux = e.promedioDeAltura();
			
			if(max < aux) {
				max = aux;
				retorno = e.getNombre();
			}
			
		}	
			
		return "Equipo más alto es (" + retorno + ") con una altura de: " + max;
	}
	
	public String tablaPosiciones(long idTorneo) {
		Torneo torneo = this.traerTorneoPorId(idTorneo);
		String tabla = torneo.getNombre() + " " + torneo.getTemporada() + ":\n";
		List<Equipo> lstEquiposTorneo = torneo.getLtsEquipos();
		List<EquipoPuntosTorneo> lstEquiposPuntos = new ArrayList<EquipoPuntosTorneo>();
		
		for(Equipo e: lstEquiposTorneo)
			lstEquiposPuntos.add(new EquipoPuntosTorneo(e, torneo.puntosPorEquipo(e)));
		
		lstEquiposPuntos.sort((a, b) -> Integer.compare(b.getPuntos(), a.getPuntos()));
		
		for(EquipoPuntosTorneo e: lstEquiposPuntos)
			tabla += e.getEquipo().getNombre() + " --- " + e.getPuntos() + "pts.\n";
			
		return tabla;
	}
	
	public boolean agregarEstadisticaPartidoTorneo(long idTorneo, long idPartido, String dniJugador, int goles, int asistencias, int minutosJugados) throws Exception {
		Torneo torneo = existeTorneo(idTorneo);
		
		Partido partido = torneo.traerPartidoPorId(idPartido);
		
		return partido.agregarEstadisticaPartido(Sistema.getInstance().traerJugadorPorDni(dniJugador), goles, asistencias, minutosJugados);
	}
	
	public String tablaDeGoleadores(long idTorneo) throws Exception {
		Torneo torneo = this.traerTorneoPorId(idTorneo);
		String tabla = "Goleadores " + torneo.getNombre() + " " + torneo.getTemporada() + ":\n";
		List<EstadisticasTorneoJugador> lst = torneo.listaDeEstadisticaDeJugadores();
		
		lst.sort(Comparator.comparingInt(EstadisticasTorneoJugador::getTotalGoles).reversed()
				.thenComparingInt(EstadisticasTorneoJugador::getTotalMinutosJugados));
		
		for(EstadisticasTorneoJugador e: lst) {
			
			if(e.getTotalGoles() > 0)
				tabla += e.getJugador().getApellido() + " " + e.getJugador().getNombre() + ": " + e.getTotalGoles() + " goles --- " + e.getTotalMinutosJugados() + "min.\n";
			
		}
		
		return tabla;
	}
	
	public String tablaDeAsistidores(long idTorneo) throws Exception {
		Torneo torneo = this.traerTorneoPorId(idTorneo);
		String tabla = "Goleadores " + torneo.getNombre() + " " + torneo.getTemporada() + ":\n";
		List<EstadisticasTorneoJugador> lst = torneo.listaDeEstadisticaDeJugadores();
		
		lst.sort(Comparator.comparingInt(EstadisticasTorneoJugador::getTotalAsistencias).reversed()
				.thenComparingInt(EstadisticasTorneoJugador::getTotalMinutosJugados));
		
		for(EstadisticasTorneoJugador e: lst) {
			
			if(e.getTotalAsistencias() > 0)
				tabla += e.getJugador().getApellido() + " " + e.getJugador().getNombre() + ": " + e.getTotalAsistencias() + " asistencias --- " + e.getTotalMinutosJugados() + "min.\n";
			
		}
		
		return tabla;
	}
}
