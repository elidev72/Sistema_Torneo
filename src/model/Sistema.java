package model;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private static final Sistema oInstance = new Sistema();
	
	private List<Torneo> ltsTorneos = new ArrayList<Torneo>();
	private List<Equipo> ltsEquipos = new ArrayList<Equipo>();
	private List<Jugador> ltsJugadores = new ArrayList<Jugador>();
	private List<Entrenador> ltsEntrenadores = new ArrayList<Entrenador>();
	
	private Sistema() {}
	
	public static Sistema getInstance() {
		return Sistema.oInstance;
	}
}
