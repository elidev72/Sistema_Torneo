package test;

import java.time.LocalDate;
import java.util.List;

import model.*;

public class TestGeneral {

	public static void main(String[] args) {
		
		System.out.println("Torneo:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatos.agregarTorneo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Torneo> lstTorneo = Sistema.getInstance().getLtsTorneos();
		for(Torneo t: lstTorneo)
			System.out.println(t);
		
		System.out.println("\nEntrenadores:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatos.agregarEntrenadores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Entrenador e: Sistema.getInstance().getLtsEntrenadores())
			System.out.println(e);
		
		System.out.println("\nEquipos:");
		System.out.println("-------------------------------------");
		Torneo torneo = Sistema.getInstance().traerTorneoPorId(1);
		long idTorneo = torneo.getId();
		try {
			test.TestAgregarDatos.agregarEquipos(idTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Equipo e: Sistema.getInstance().getLtsEquipos())
			System.out.println(e);
		
		System.out.println("\nJugadores de los equipos:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatos.agregarJugadoresEnEquipos();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Equipo e: Sistema.getInstance().getLtsEquipos()) {
			
			System.out.println(e.getNombre());
			for(Jugador j: e.getLtsJugadores())
				System.out.println(j);
			
		}
		
		System.out.println("\nPartidos en el torneo:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatos.agregarPartidoSinJugar(idTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Partido p: torneo.getLtsPartidos())
			System.out.println(p);
		
		String tactica = "Ofensiva";
		System.out.println("\nEntrenadores por tactica " + "(" + tactica + "):");
		System.out.println("-------------------------------------");
		for(Entrenador e: Sistema.getInstance().tacticaPreferidaPorEntrenador(torneo, tactica))
			System.out.println(e);
		
		
		LocalDate fechaInicial = LocalDate.of(1996, 2, 1);
		LocalDate fechaFinal = LocalDate.of(1998, 1, 1);
		System.out.println("\nFutbolistas nacidos entre " + "(" + fechaInicial + ")" + " y " + "(" + fechaFinal + "):");
		System.out.println("-------------------------------------");
		for(Jugador j: Sistema.getInstance().jugadoresNacidosEntreDosFechasDeUnTorneo(torneo, fechaInicial, fechaFinal))
			System.out.println(j);
		
		LocalDate fundado = LocalDate.of(2010, 5, 6);
		System.out.println("\nFundados antes de (" + fundado + "):");
		System.out.println("-------------------------------------");
		for(Equipo e: Sistema.getInstance().fundadosAntesDe(torneo, fundado))
			System.out.println(e);
		
		System.out.println("\nAltura:");
		System.out.println("-------------------------------------");
		try {
			System.out.println(Sistema.getInstance().equipoConMasAltura(torneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("\nTabla de Posiciones:");
		try {
			test.TestAgregarDatos.agregarResultadosPartidos(idTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Sistema.getInstance().tablaPosiciones(idTorneo));
		
		System.out.println("\nPartidos en el torneo:");
		System.out.println("-------------------------------------");
		for(Partido p: torneo.getLtsPartidos())
			System.out.println(p);
		
		System.out.println("\nGoleadores en el torneo:");
		System.out.println("-------------------------------------");
		try {
			System.out.println(Sistema.getInstance().tablaDeGoleadores(idTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("\nAsistidores en el torneo:");
		System.out.println("-------------------------------------");
		try {
			System.out.println(Sistema.getInstance().tablaDeAsistidores(idTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
