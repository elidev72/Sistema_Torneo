package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Partido {
	private static long lNextId = 1;
	
	private final long lId;
	private LocalDateTime ldtFecha;
	private String sEstadio;
	private Equipo oEquipoLocal;
	private Equipo oEquipoVisitante;
	private List<EstadisticaPartidoJugador> ltsEstadisticasJugadores = new ArrayList<EstadisticaPartidoJugador>();
	
	public Partido(LocalDateTime ldtFecha, String sEstadio, Equipo oEquipoLocal, Equipo oEquipoVisitante) {
		super();
		this.lId = Partido.lNextId++;
		this.ldtFecha = ldtFecha;
		this.sEstadio = sEstadio;
		this.oEquipoLocal = oEquipoLocal;
		this.oEquipoVisitante = oEquipoVisitante;
	}

	public static long getlNextId() {
		return lNextId;
	}
	public LocalDateTime getLdtFecha() {
		return ldtFecha;
	}

	public void setLdtFecha(LocalDateTime ldtFecha) {
		this.ldtFecha = ldtFecha;
	}

	public String getsEstadio() {
		return sEstadio;
	}

	public void setsEstadio(String sEstadio) {
		this.sEstadio = sEstadio;
	}

	public Equipo getoEquipoLocal() {
		return oEquipoLocal;
	}

	public void setoEquipoLocal(Equipo oEquipoLocal) {
		this.oEquipoLocal = oEquipoLocal;
	}

	public Equipo getoEquipoVisitante() {
		return oEquipoVisitante;
	}

	public void setoEquipoVisitante(Equipo oEquipoVisitante) {
		this.oEquipoVisitante = oEquipoVisitante;
	}

	public List<EstadisticaPartidoJugador> getLtsEstadisticasJugadores() {
		return List.copyOf(ltsEstadisticasJugadores);
	}

	public long getlId() {
		return lId;
	}

	@Override
	public String toString() {
		String sRetorno = "Partido [lId=" + lId + ", ldtFecha=" + Utils.obtenerFechaFormateada(ldtFecha) + ", sEstadio=" + sEstadio + " | "
				+ oEquipoLocal.getsNombre();
		
		if(!this.getLtsEstadisticasJugadores().isEmpty()) {
			sRetorno += " " + this.calcularGoles(oEquipoLocal) + " - " + this.calcularGoles(oEquipoVisitante) + " " + oEquipoVisitante.getsNombre() + " | Resultado: ";
			
			if(this.ganador() != null) {
				sRetorno += "Ganó " + this.ganador().getsNombre();
			} else
				sRetorno += "Empate";
			
		} else
			sRetorno += " vs " + oEquipoVisitante.getsNombre() + " | Estado: Sin disputar";
		
		return sRetorno + "]";
	}
	
	public boolean equals(Partido partido) {
		return oEquipoLocal.equals(partido.getoEquipoLocal()) && oEquipoVisitante.equals(partido.getoEquipoVisitante());
	}

	private int calcularGoles(Equipo oEquipo) {
		int iGoles = 0;
		
		for(EstadisticaPartidoJugador e: this.getLtsEstadisticasJugadores()) {
			
			if(oEquipo.getLtsJugadores().contains(e.getoJugador()))
				iGoles += e.getiGoles();
			
		}
		
		return iGoles;
	}
	
	public Equipo ganador() {
		Equipo oGanador = null;
		
		if(this.calcularGoles(this.getoEquipoLocal()) < this.calcularGoles(getoEquipoVisitante())) {
			oGanador = this.oEquipoVisitante;
		} 
		else if(this.calcularGoles(this.getoEquipoLocal()) > this.calcularGoles(getoEquipoVisitante()))
			oGanador = this.oEquipoLocal;
		
		return oGanador;
	}
	
	public boolean agregarEstadisticaPartido(Jugador oJugador, int iGoles, int iAsistencias, int iMinutosJugados) throws Exception {
		List<Jugador> lst = new ArrayList<>(this.getoEquipoLocal().getLtsJugadores());
		lst.addAll(this.getoEquipoVisitante().getLtsJugadores());
		
		if(!lst.contains(oJugador))
			throw new Exception("ERROR: Jugador no pertenece a ninguno de los 2 equipos.");
		
		EstadisticaPartidoJugador aux = new EstadisticaPartidoJugador(oJugador, iGoles, iAsistencias, iMinutosJugados);
		if(this.getLtsEstadisticasJugadores().contains(aux))
			throw new Exception("ERROR: Jugador ya tiene estadisticas en el partido.");
		
		return this.ltsEstadisticasJugadores.add(aux);
	}
	
}
