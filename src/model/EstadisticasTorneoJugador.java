package model;

public class EstadisticasTorneoJugador {
	private Jugador oJugador;
    private int iTotalGoles = 0;
    private int iTotalAsistencias = 0;
    private int iTotalMinutosJugados = 0;
    
	public EstadisticasTorneoJugador(Jugador oJugador) {
		super();
		this.oJugador = oJugador;
	}

	public Jugador getoJugador() {
		return oJugador;
	}

	public int getiTotalGoles() {
		return iTotalGoles;
	}

	public int getiTotalAsistencias() {
		return iTotalAsistencias;
	}

	public int getiTotalMinutosJugados() {
		return iTotalMinutosJugados;
	}
    
	public void sumarEstadisticaPartido(int goles, int asistencias, int minutos) {
        this.iTotalGoles += goles;
        this.iTotalAsistencias += asistencias;
        this.iTotalMinutosJugados += minutos; 
    }

	@Override
	public String toString() {
		return "EstadisticasTorneoJugador [oJugador=" + oJugador.getsApellido() + " " + oJugador.getsNombre() + ", iTotalGoles=" + iTotalGoles
				+ ", iTotalAsistencias=" + iTotalAsistencias + ", iTotalMinutosJugados=" + iTotalMinutosJugados + "]";
	}
	
}
