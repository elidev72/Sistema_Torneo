package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Torneo {
	private static long lNextId = 1;
	
	private final long lId;
	private String sNombre;
	private String sTemporada;
	private LocalDate ldFechaDeInicio;
	private LocalDate ldFechaDeFin;
	private List<Equipo> ltsEquipos = new ArrayList<Equipo>();
	private List<Partido> ltsPartidos = new ArrayList<Partido>();
	
	public Torneo(String sNombre, String sTemporada, LocalDate ldFechaDeInicio, LocalDate ldFechaDeFin) throws Exception {
		this.lId = Torneo.lNextId++;
		this.sNombre = sNombre;
		this.sTemporada = sTemporada;
		this.ldFechaDeInicio = ldFechaDeInicio;
		this.setLdFechaDeFin(ldFechaDeFin);
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsTemporada() {
		return sTemporada;
	}

	public void setiTemporada(String sTemporada) {
		this.sTemporada = sTemporada;
	}

	public LocalDate getLdFechaDeInicio() {
		return ldFechaDeInicio;
	}
	
	private void validarFechas(LocalDate ldInicio, LocalDate ldFin) throws Exception {
		if (ldInicio.isAfter(ldFin))
	        throw new Exception("ERROR: La fecha de inicio (" + ldInicio + ") no puede ser posterior a la fecha de fin (" + ldFin + ").");
	}

	public void setLdFechaDeInicio(LocalDate ldFechaDeInicio) throws Exception {
		this.validarFechas(ldFechaDeInicio, this.ldFechaDeFin);
		this.ldFechaDeInicio = ldFechaDeInicio;
	}

	public LocalDate getLdFechaDeFin() {
		return ldFechaDeFin;
	}

	public void setLdFechaDeFin(LocalDate ldFechaDeFin) throws Exception {
		this.validarFechas(this.ldFechaDeInicio, ldFechaDeFin);
		this.ldFechaDeFin = ldFechaDeFin;
	}

	public List<Equipo> getLtsEquipos() {
		return List.copyOf(ltsEquipos);
	}

	public static long getlNextId() {
		return lNextId;
	}

	public long getlId() {
		return lId;
	}

	public List<Partido> getLtsPartidos() {
		return List.copyOf(ltsPartidos);
	}

	@Override
	public String toString() {
		return "Torneo [lId=" + lId + ", sNombre=" + sNombre + ", sTemporada=" + sTemporada + ", ldFechaDeInicio="
				+ ldFechaDeInicio + ", ldFechaDeFin=" + ldFechaDeFin + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneo other = (Torneo) obj;
		return Objects.equals(sNombre, other.sNombre) && Objects.equals(sTemporada, other.sTemporada);
	}

	public boolean agregarEquipo(Equipo oEquipo) throws Exception {
		if(this.getLtsEquipos().contains(oEquipo))
			throw new Exception("ERROR: El equipo ya esta en el torneo");
		
		return this.ltsEquipos.add(oEquipo);
	}
	
	public boolean agregarPartido(Partido oPartido) throws Exception {
		if(this.getLtsPartidos().contains(oPartido))
			throw new Exception("ERROR: El partido ya esta en el torneo");
		
		return this.ltsPartidos.add(oPartido);
	}
	
	public List<Entrenador> tacticaPreferidaPorEntrenador(String sTactica){
		List<Entrenador> lstEntrenadores = new ArrayList<Entrenador>();
		
		for(Equipo e: this.getLtsEquipos()) {
			Entrenador oEntrenador = e.getoEntrenador();
			
			if(oEntrenador.getsEstrategiaFavorita().equalsIgnoreCase(sTactica))
				lstEntrenadores.add(oEntrenador);
			
		}
		
		return lstEntrenadores;
	}
	
	public List<Equipo> fundadosAntesDe(LocalDate ldFecha){
		List<Equipo> lstEquipo = new ArrayList<Equipo>();
		
		for(Equipo e: this.getLtsEquipos()) {
			
			if(e.getLdFechaFundacion().isBefore(ldFecha))
				lstEquipo.add(e);
			
		}
		
		return lstEquipo;
	}
	
	public List<Jugador> jugadoresNacidosEntreDosFechas(LocalDate ldFechaInicial, LocalDate ldFechaFinal){
		List<Jugador> lstJugador = new ArrayList<Jugador>();
		
		for(Equipo e: this.getLtsEquipos()) {
			
			for(Jugador j: e.getLtsJugadores()) {
				LocalDate ldAux = j.getLtFechaDeNacimiento();
				
				if(ldAux.isAfter(ldFechaInicial) && ldAux.isBefore(ldFechaFinal))
					lstJugador.add(j);
				
			}
			
		}
		
		return lstJugador;
	}
	
	public int puntosPorEquipo(Equipo oEquipo) {
		int iPuntos = 0;
		
		List<Partido> partidos = this.getLtsPartidos();
		for(Partido p: partidos) {
			
			if(p.getoEquipoLocal().equals(oEquipo) || p.getoEquipoVisitante().equals(oEquipo)) {
				Equipo oGanador = p.ganador();
				
				if(oGanador == null) {
					iPuntos++;
				}
				else if(oGanador.equals(oEquipo))
					iPuntos += 3;
				
			}
			
			
		}
		
		return iPuntos;
	}
	
	public Partido traerPartidoPorId(long lId) throws Exception {
		Partido oPartido = null;
		int i = 0, iTam = this.ltsPartidos.size();
		
		while(oPartido == null && i<iTam) {
			Partido aux = this.getLtsPartidos().get(i);
			
			if(aux.getlId() == lId)
				oPartido = aux;
			
			i++;
		}
		
		if(oPartido == null)
			throw new Exception("ERROR: El partido no existe en el torneo.");
		
		return oPartido;
	}
	
}
