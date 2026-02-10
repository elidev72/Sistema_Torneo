package test;

import java.time.LocalDate;
import java.util.List;
import model.*;

public class TestClausura25 {

public static void main(String[] args) {
		
		System.out.println("Torneo:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatosClausura25.agregarTorneo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Torneo> lstTorneo = Sistema.getInstance().getLtsTorneos();
		for(Torneo t: lstTorneo)
			System.out.println(t);
		
		System.out.println("\nEntrenadores:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatosClausura25.agregarEntrenadores();
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
			test.TestAgregarDatosClausura25.agregarEquipos(idTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Equipo e: Sistema.getInstance().getLtsEquipos())
			System.out.println(e);
		
		System.out.println("\nJugadores de los equipos:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatosClausura25.agregarJugadoresEnEquipos();
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
			test.TestAgregarDatosClausura25.agregarPartidoSinJugar(idTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Partido p: torneo.getLtsPartidos())
			System.out.println(p);
		
		String tactica = "5-3-2";
		System.out.println("\nEntrenadores por tactica " + "(" + tactica + "):");
		System.out.println("-------------------------------------");
		for(Entrenador e: Sistema.getInstance().tacticaPreferidaPorEntrenador(torneo, tactica))
			System.out.println(e);
		
		
		LocalDate fechaInicial = LocalDate.of(1995, 2, 1);
		LocalDate fechaFinal = LocalDate.of(1999, 1, 1);
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
			test.TestAgregarDatosClausura25.agregarResultadosPartidos(idTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Sistema.getInstance().tablaPosiciones(idTorneo));
		
		System.out.println("\nPartidos en el torneo:");
		System.out.println("-------------------------------------");
		for(Partido p: torneo.getLtsPartidos())
			System.out.println(p);

		try {
			System.out.println(Sistema.getInstance().tablaDeGoleadores(idTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(Sistema.getInstance().tablaDeAsistidores(idTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}