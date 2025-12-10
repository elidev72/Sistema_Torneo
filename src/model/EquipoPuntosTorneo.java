package model;

public class EquipoPuntosTorneo {
	private Equipo equipo;
	private int puntos;
	
	public EquipoPuntosTorneo(Equipo equipo, int puntos) {
		super();
		this.equipo = equipo;
		this.puntos = puntos;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public int getPuntos() {
		return puntos;
	}
	
}
