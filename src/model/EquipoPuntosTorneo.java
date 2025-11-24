package model;

public class EquipoPuntosTorneo {
	private Equipo oEquipo;
	private int iPuntos;
	
	public EquipoPuntosTorneo(Equipo oEquipo, int iPuntos) {
		super();
		this.oEquipo = oEquipo;
		this.iPuntos = iPuntos;
	}

	public Equipo getoEquipo() {
		return oEquipo;
	}

	public int getiPuntos() {
		return iPuntos;
	}
	
}
