package model;

import java.util.Objects;

public class EstadisticaPartidoJugador {
	private static long lNextId = 1;
	
	private final long lId;
	private Jugador oJugador;
	private int iGoles;
	private int iAsistencias;
	private int iMinutosJugados;
	
	public EstadisticaPartidoJugador(Jugador oJugador, int iGoles, int iAsistencias, int iMinutosJugados) {
		super();
		this.lId = EstadisticaPartidoJugador.lNextId++;
		this.oJugador = oJugador;
		this.iGoles = iGoles;
		this.iAsistencias = iAsistencias;
		this.iMinutosJugados = iMinutosJugados;
	}

	public Jugador getoJugador() {
		return oJugador;
	}

	public void setoJugador(Jugador oJugador) {
		this.oJugador = oJugador;
	}

	public int getiGoles() {
		return iGoles;
	}

	public void setiGoles(int iGoles) {
		this.iGoles = iGoles;
	}

	public int getiAsistencias() {
		return iAsistencias;
	}

	public void setiAsistencias(int iAsistencias) {
		this.iAsistencias = iAsistencias;
	}

	public int getiMinutosJugados() {
		return iMinutosJugados;
	}

	public void setiMinutosJugados(int iMinutosJugados) {
		this.iMinutosJugados = iMinutosJugados;
	}

	public static long getlNextId() {
		return lNextId;
	}

	public long getlId() {
		return lId;
	}

	@Override
	public String toString() {
		return "EstadisticaPartidoJugador [lId=" + lId + ", oJugador=" + oJugador + ", iGoles=" + iGoles
				+ ", iAsistencias=" + iAsistencias + ", iMinutosJugados=" + iMinutosJugados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(oJugador);
	}
	
	public boolean equals(EstadisticaPartidoJugador estadisticaPartidoJugador) {
		return lId == estadisticaPartidoJugador.getlId() && oJugador.equals(estadisticaPartidoJugador.getoJugador());
	}
	
}
