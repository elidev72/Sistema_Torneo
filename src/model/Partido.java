package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Partido {
	private static long lNextId = 1;
	
	private final long lId;
	private LocalDateTime ldtFecha;
	private String sEstadio;
	private Equipo oEquipoLocal;
	private Equipo oEquipoVisitante;
	private List<EstadisticaPartidoJugador> ltsEstadisticasJugadores = new ArrayList<EstadisticaPartidoJugador>();
	
	public Partido(long lId, LocalDateTime ldtFecha, String sEstadio, Equipo oEquipoLocal, Equipo oEquipoVisitante) {
		super();
		this.lId = lId;
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
		return ltsEstadisticasJugadores;
	}

	public long getlId() {
		return lId;
	}
	
}
