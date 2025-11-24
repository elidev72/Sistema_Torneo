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
	public boolean agregarTorneoASistema(String sNombre, String sTemporada, LocalDate ldFechaDeInicio, LocalDate ldFechaDeFin) throws Exception {
		Torneo oTorneo = new Torneo(sNombre, sTemporada, ldFechaDeInicio, ldFechaDeFin);
		
		if(this.getLtsTorneos().contains(oTorneo))
			throw new Exception("ERROR: Torneo ya existe en el Sistema");
		
		return this.ltsTorneos.add(oTorneo);
	}
	
	public boolean agregarEquipoATorneoYSistema(String sNombre, String sCodigoUnico, LocalDate ldFechaFundacion, Entrenador oEntrenador, long lIdTorneo) throws Exception {
		Torneo oTorneo = this.traerTorneoPorId(lIdTorneo);
		
		if(oTorneo == null)
			throw new Exception("No existe el torneo de id: " + lIdTorneo);
		
		Equipo oEquipo = new Equipo(sNombre, sCodigoUnico, ldFechaFundacion, oEntrenador);
		
		if(!this.getLtsEquipos().contains(oEquipo))
			this.ltsEquipos.add(oEquipo);
		
		return oTorneo.agregarEquipo(oEquipo);
	}
	
	public boolean agregarJugadorAEquipoYSistema(String sApellido, String sNombre, String sDNI, LocalDate ldFechaDeNacimiento, float fEstatura,
			float fPeso, String sPosición, int iNumeroDeCamiseta, String sCodigoEquipo) throws Exception {
		Equipo oEquipo = this.traerEquipoPorCodigoUnico(sCodigoEquipo);
		
		if(oEquipo == null)
			throw new Exception("No existe el equipo con codigo: " + sCodigoEquipo);
		
		Jugador oJugador = new Jugador(sApellido, sNombre, sDNI, ldFechaDeNacimiento, fEstatura, fPeso, sPosición, iNumeroDeCamiseta);
		
		if(!this.getLtsJugadores().contains(oJugador))
			this.ltsJugadores.add(oJugador);

		return oEquipo.agregarJugador(oJugador);
	}
	
	public boolean agregarEntrenadorASistema(String sApellido, String sNombre, String sDNI, LocalDate ldFechaDeNacimiento, String sEstrategiaFavorita) throws Exception {
		Entrenador oEntrenador = new Entrenador(sApellido, sNombre, sDNI, ldFechaDeNacimiento, sEstrategiaFavorita);
		boolean bAgregado = false;
		
		if(!this.getLtsEntrenadores().contains(oEntrenador))
			bAgregado = this.ltsEntrenadores.add(oEntrenador);
		
		return bAgregado;
	}
	
	private Torneo existeTorneo(long lIdTorneo) throws Exception {
		Torneo oTorneo = this.traerTorneoPorId(lIdTorneo);
		
		if(oTorneo == null)
			throw new Exception("ERROR: no existe el torneo con id " + lIdTorneo);
		
		return oTorneo;
	}
	
	public boolean agregarPartidoEnTorneo(long lIdTorneo, LocalDateTime ldtFecha, String sEstadio, Equipo oEquipoLocal, Equipo oEquipoVisitante) throws Exception {
		Torneo oTorneo = existeTorneo(lIdTorneo);
		
		Partido oPartido = new Partido(ldtFecha, sEstadio, oEquipoLocal, oEquipoVisitante);
		
		return oTorneo.agregarPartido(oPartido);
	}
	
	// Traer
	public Torneo traerTorneoPorId(long lId) {
		Torneo oAux = null, oTemp;
		int i = 0, iTam = this.ltsTorneos.size();
		
		while(oAux == null && i < iTam) {
			oTemp = this.ltsTorneos.get(i);
			
			if(oTemp.getlId() == lId)
				oAux = oTemp;
			
			i++;
		}
		
		return oAux;
	}

	public Equipo traerEquipoPorCodigoUnico(String sCodigoUnico) throws Exception {
		Equipo oAux = null, oTemp;
		int i = 0, iTam = this.ltsEquipos.size();
		
		while(oAux == null && i < iTam) {
			oTemp = this.getLtsEquipos().get(i);
			
			if(oTemp.getsCodigoUnico().equalsIgnoreCase(sCodigoUnico))
				oAux = oTemp;
			
			i++;
		}
		
		if(oAux == null)
			throw new Exception("ERROR: El equipo no existe en el torneo.");
		
		return oAux;
	}
	
	public Entrenador traerEntrenadorPorsDNI(String sDNI) throws Exception {
		Entrenador oAux = null, oTemp;
		int i = 0, iTam = this.getLtsEntrenadores().size();
		
		while(oAux == null && i < iTam) {
			oTemp = this.ltsEntrenadores.get(i);
			
			if(oTemp.getsDNI().equalsIgnoreCase(sDNI))
				oAux = oTemp;
			
			i++;
		}
		
		if(oAux == null)
			throw new Exception("No existe el entrenador con DNI: " + sDNI);
		
		return oAux;
	}
	
	public Jugador traerJugadorPorsDNI(String sDNI) throws Exception {
		Jugador oAux = null, oTemp;
		int i = 0, iTam = this.getLtsJugadores().size();
		
		while(oAux == null && i < iTam) {
			oTemp = this.ltsJugadores.get(i);
			
			if(oTemp.getsDNI().equalsIgnoreCase(sDNI))
				oAux = oTemp;
			
			i++;
		}
		
		if(oAux == null)
			throw new Exception("No existe el jugador con DNI: " + sDNI);
		
		return oAux;
	}
	
	public List<Entrenador> tacticaPreferidaPorEntrenador(Torneo oTorneo, String sTactica){
		return oTorneo.tacticaPreferidaPorEntrenador(sTactica);
	}
	
	public List<Jugador> jugadoresNacidosEntreDosFechasDeUnTorneo(Torneo oTorneo, LocalDate ldFechaInicial, LocalDate ldFechaFinal){
		return oTorneo.jugadoresNacidosEntreDosFechas(ldFechaInicial, ldFechaFinal);
	}
	
	public List<Equipo> fundadosAntesDe(Torneo oTorneo, LocalDate ldFecha){
		return oTorneo.fundadosAntesDe(ldFecha);
	}
	
	public String equipoConMasAAltura(Torneo oTorneo) throws Exception {
		List<Equipo> lstEquipo = oTorneo.getLtsEquipos();
		if(lstEquipo.isEmpty())
			throw new Exception("ERROR: No se puede calcular altura ya que no hay equipos en el torneo");
		
		float fAux, fMax = Float.NEGATIVE_INFINITY;
		String sRetorno = " ";
		
		for(Equipo e: lstEquipo) {
			fAux = e.promedioDeAltura();
			
			if(fMax < fAux) {
				fMax = fAux;
				sRetorno = e.getsNombre();
			}
			
		}	
			
		return "Equipo más alto es (" + sRetorno + ") con una altura de: " + fMax;
	}
	
	public String tablaPosiciones(long lIdTorneo) {
		Torneo oTorneo = this.traerTorneoPorId(lIdTorneo);
		String sTabla = oTorneo.getsNombre() + " " + oTorneo.getsTemporada() + ":\n";
		List<Equipo> lstEquiposTorneo = oTorneo.getLtsEquipos();
		List<EquipoPuntosTorneo> lstEquiposPuntos = new ArrayList<EquipoPuntosTorneo>();
		
		for(Equipo e: lstEquiposTorneo)
			lstEquiposPuntos.add(new EquipoPuntosTorneo(e, oTorneo.puntosPorEquipo(e)));
		
		lstEquiposPuntos.sort((a, b) -> Integer.compare(b.getiPuntos(), a.getiPuntos()));
		
		for(EquipoPuntosTorneo e: lstEquiposPuntos)
			sTabla += e.getoEquipo().getsNombre() + " --- " + e.getiPuntos() + "pts.\n";
			
		return sTabla;
	}
	
	public boolean agregarEstadisticaPartidoTorneo(long lIdTorneo, long lIdPartido, String sDNIJugador, int iGoles, int iAsistencias, int iMinutosJugados) throws Exception {
		Torneo oTorneo = existeTorneo(lIdTorneo);
		
		Partido partido = oTorneo.traerPartidoPorId(lIdPartido);
		
		return partido.agregarEstadisticaPartido(Sistema.getInstance().traerJugadorPorsDNI(sDNIJugador), iGoles, iAsistencias, iMinutosJugados);
	}
	
	public String tablaDeGoleadores(long lIdTorneo) throws Exception {
		Torneo oTorneo = this.traerTorneoPorId(lIdTorneo);
		String sTabla = "Goleadores " + oTorneo.getsNombre() + " " + oTorneo.getsTemporada() + ":\n";
		List<EstadisticasTorneoJugador> lst = oTorneo.listaDeEstadisticaDeJugadores();
		
		lst.sort(Comparator.comparingInt(EstadisticasTorneoJugador::getiTotalGoles).reversed()
				.thenComparingInt(EstadisticasTorneoJugador::getiTotalMinutosJugados));
		
		for(EstadisticasTorneoJugador e: lst) {
			
			if(e.getiTotalGoles() > 0)
				sTabla += e.getoJugador().getsApellido() + " " + e.getoJugador().getsNombre() + ": " + e.getiTotalGoles() + " goles --- " + e.getiTotalMinutosJugados() + "min.\n";
			
		}
		
		return sTabla;
	}
	
	public String tablaDeAsistidores(long lIdTorneo) throws Exception {
		Torneo oTorneo = this.traerTorneoPorId(lIdTorneo);
		String sTabla = "Goleadores " + oTorneo.getsNombre() + " " + oTorneo.getsTemporada() + ":\n";
		List<EstadisticasTorneoJugador> lst = oTorneo.listaDeEstadisticaDeJugadores();
		
		lst.sort(Comparator.comparingInt(EstadisticasTorneoJugador::getiTotalAsistencias).reversed()
				.thenComparingInt(EstadisticasTorneoJugador::getiTotalMinutosJugados));
		
		for(EstadisticasTorneoJugador e: lst) {
			
			if(e.getiTotalAsistencias() > 0)
				sTabla += e.getoJugador().getsApellido() + " " + e.getoJugador().getsNombre() + ": " + e.getiTotalAsistencias() + " asistencias --- " + e.getiTotalMinutosJugados() + "min.\n";
			
		}
		
		return sTabla;
	}
}
