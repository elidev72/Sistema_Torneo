package model;

public class EstadisticasTorneoJugador {
	private Jugador jugador;
    private int totalGoles = 0;
    private int totalAsistencias = 0;
    private int totalMinutosJugados = 0;
    
	public EstadisticasTorneoJugador(Jugador jugador) {
		super();
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getTotalGoles() {
		return totalGoles;
	}

	public int getTotalAsistencias() {
		return totalAsistencias;
	}

	public int getTotalMinutosJugados() {
		return totalMinutosJugados;
	}
    
	public void sumarEstadisticaPartido(int goles, int asistencias, int minutos) {
        this.totalGoles += goles;
        this.totalAsistencias += asistencias;
        this.totalMinutosJugados += minutos; 
    }

	@Override
	public String toString() {
		return "EstadisticasTorneoJugador [jugador=" + jugador.getApellido() + " " + jugador.getNombre() + ", totalGoles=" + totalGoles
				+ ", totalAsistencias=" + totalAsistencias + ", totalMinutosJugados=" + totalMinutosJugados + "]";
	}
	
}
