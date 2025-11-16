package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
	private static long lNextId = 1;
	
	private final long lId;
	private String sNombre;
	private int iTemporada;
	private LocalDate ldFechaDeInicio;
	private LocalDate ldFechaDeFin;
	private List<Equipo> ltsEquipos = new ArrayList<Equipo>();
	private List<Partido> ltsPartidos = new ArrayList<Partido>();
	
	public Torneo(String sNombre, int iTemporada, LocalDate ldFechaDeInicio, LocalDate ldFechaDeFin) {
		super();
		this.lId = Torneo.lNextId++;
		this.sNombre = sNombre;
		this.iTemporada = iTemporada;
		this.ldFechaDeInicio = ldFechaDeInicio;
		this.ldFechaDeFin = ldFechaDeFin;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public int getiTemporada() {
		return iTemporada;
	}

	public void setiTemporada(int iTemporada) {
		this.iTemporada = iTemporada;
	}

	public LocalDate getLdFechaDeInicio() {
		return ldFechaDeInicio;
	}

	public void setLdFechaDeInicio(LocalDate ldFechaDeInicio) {
		this.ldFechaDeInicio = ldFechaDeInicio;
	}

	public LocalDate getLdFechaDeFin() {
		return ldFechaDeFin;
	}

	public void setLdFechaDeFin(LocalDate ldFechaDeFin) {
		this.ldFechaDeFin = ldFechaDeFin;
	}

	public List<Equipo> getLtsEquipos() {
		return ltsEquipos;
	}

	public static long getlNextId() {
		return lNextId;
	}

	public long getlId() {
		return lId;
	}

	@Override
	public String toString() {
		return "Torneo [lId=" + lId + ", sNombre=" + sNombre + ", iTemporada=" + iTemporada + ", ldFechaDeInicio="
				+ ldFechaDeInicio + ", ldFechaDeFin=" + ldFechaDeFin + "]";
	}
	
}
