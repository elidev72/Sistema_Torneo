package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private static long lNextId = 1;
	
	private final long lId;
	private String sNombre;
	private String sCodigoUnico;
	private LocalDate ldFechaFundacion;
	private Entrenador oEntrenador;
	private List<Jugador> ltsJugadores = new ArrayList<Jugador>();
	
	public Equipo(String sNombre, String sCodigoUnico, LocalDate ldFechaFundacion, Entrenador oEntrenador) throws Exception {
		super();
		this.lId = Equipo.lNextId++;
		this.sNombre = sNombre;
		this.setsCodigoUnico(sCodigoUnico);
		this.ldFechaFundacion = ldFechaFundacion;
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

	public void setsCodigoUnico(String sCodigoUnico) throws Exception {
		if (sCodigoUnico == null || sCodigoUnico.isEmpty())
	        throw new Exception("ERROR: El código único no puede ser nulo o vacío.");
		
		if(sCodigoUnico.length() != 3)
			throw new Exception("ERROR: el codigo debe tener un largo de 3 caracteres.");
		
		this.sCodigoUnico = sCodigoUnico;
	}

	public Entrenador getoEntrenador() {
		return oEntrenador;
	}

	public void setoEntrenador(Entrenador oEntrenador) {
		this.oEntrenador = oEntrenador;
	}

	public List<Jugador> getLtsJugadores() {
		return List.copyOf(ltsJugadores);
	}

	public long getlId() {
		return lId;
	}

	@Override
	public String toString() {
		return "Equipo [lId=" + lId + ", sNombre=" + sNombre + ", sCodigoUnico=" + sCodigoUnico + ", ldFechaFundacion="
				+ ldFechaFundacion + ", oEntrenador=" + oEntrenador + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(sCodigoUnico, other.sCodigoUnico);
	}

	public boolean agregarJugador(Jugador oJugador) throws Exception {
		if(this.getLtsJugadores().contains(oJugador))
			throw new Exception("ERROR: El equipo ya contiene al jugador.");
		
		return this.ltsJugadores.add(oJugador);
	}
	
	public float promedioDeAltura() {
		float fPromedio = 0;
		List<Jugador> lstJugador = this.getLtsJugadores();
		
		for(Jugador j: lstJugador)
			fPromedio += j.getfEstatura();
		
		return lstJugador.isEmpty() ? 0f : fPromedio / lstJugador.size();
	}

	public LocalDate getLdFechaFundacion() {
		return ldFechaFundacion;
	}

	public void setLdFechaFundacion(LocalDate ldFechaFundacion) {
		this.ldFechaFundacion = ldFechaFundacion;
	}
}
