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
		Torneo oTorneo = Sistema.getInstance().traerTorneoPorId(1);
		long lIdTorneo = oTorneo.getlId();
		try {
			test.TestAgregarDatos.agregarEquipos(lIdTorneo);
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
			
			System.out.println(e.getsNombre());
			for(Jugador j: e.getLtsJugadores())
				System.out.println(j);
			
		}
		
		System.out.println("\nPartidos en el torneo:");
		System.out.println("-------------------------------------");
		try {
			test.TestAgregarDatos.agregarPartidoSinJugar(lIdTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Partido p: oTorneo.getLtsPartidos())
			System.out.println(p);
		
		String sTactica = "Ofensiva";
		System.out.println("\nEntrenadores por tactica " + "(" + sTactica + "):");
		System.out.println("-------------------------------------");
		for(Entrenador e: Sistema.getInstance().tacticaPreferidaPorEntrenador(oTorneo, sTactica))
			System.out.println(e);
		
		
		LocalDate ldFechaInicial = LocalDate.of(1996, 2, 1);
		LocalDate ldFechaFinal = LocalDate.of(1998, 1, 1);
		System.out.println("\nFutbolistas nacidos entre " + "(" + ldFechaInicial + ")" + " y " + "(" + ldFechaFinal + "):");
		System.out.println("-------------------------------------");
		for(Jugador j: Sistema.getInstance().jugadoresNacidosEntreDosFechasDeUnTorneo(oTorneo, ldFechaInicial, ldFechaFinal))
			System.out.println(j);
		
		LocalDate ldFundado = LocalDate.of(2010, 5, 6);
		System.out.println("\nFundados antes de (" + ldFundado + "):");
		System.out.println("-------------------------------------");
		for(Equipo e: Sistema.getInstance().fundadosAntesDe(oTorneo, ldFundado))
			System.out.println(e);
		
		System.out.println("\nAltura:");
		System.out.println("-------------------------------------");
		try {
			System.out.println(Sistema.getInstance().equipoConMasAAltura(oTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("\nTabla de Posiciones:");
		try {
			test.TestAgregarDatos.agregarResultadosPartidos(lIdTorneo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(Sistema.getInstance().tablaPosiciones(lIdTorneo));
		
		System.out.println("\nPartidos en el torneo:");
		System.out.println("-------------------------------------");
		for(Partido p: oTorneo.getLtsPartidos())
			System.out.println(p);
		
		System.out.println("\nGoleadores en el torneo:");
		System.out.println("-------------------------------------");
		try {
			System.out.println(Sistema.getInstance().tablaDeGoleadores(lIdTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("\nAsistidores en el torneo:");
		System.out.println("-------------------------------------");
		try {
			System.out.println(Sistema.getInstance().tablaDeAsistidores(lIdTorneo));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
