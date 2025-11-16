package model;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private static long lNextId = 1;
	
	private final long lId;
	private String sNombre;
	private String sCodigoUnico;
	private Entrenador oEntrenador;
	private List<Jugador> ltsJugadores = new ArrayList<Jugador>();
	
	public Equipo(String sNombre, String sCodigoUnico, Entrenador oEntrenador) {
		super();
		this.lId = Equipo.lNextId++;
		this.sNombre = sNombre;
		this.sCodigoUnico = sCodigoUnico;
		this.oEntrenador = oEntrenador;
	}

	public static long getlNextId() {
		return lNextId;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsCodigoUnico() {
		return sCodigoUnico;
	}

	public void setsCodigoUnico(String sCodigoUnico) {
		this.sCodigoUnico = sCodigoUnico;
	}

	public Entrenador getoEntrenador() {
		return oEntrenador;
	}

	public void setoEntrenador(Entrenador oEntrenador) {
		this.oEntrenador = oEntrenador;
	}

	public List<Jugador> getLtsJugadores() {
		return ltsJugadores;
	}

	public long getlId() {
		return lId;
	}

	@Override
	public String toString() {
		return "Equipo [lId=" + lId + ", sNombre=" + sNombre + ", sCodigoUnico=" + sCodigoUnico + ", oEntrenador="
				+ oEntrenador + "]";
	}
	
}
