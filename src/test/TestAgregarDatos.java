package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import model.*;

public class TestAgregarDatos {

	public static void agregarTorneo() throws Exception {
		Sistema.getInstance().agregarTorneoASistema("Torneo Inicial", "2025/26", LocalDate.of(2025, 9, 7), LocalDate.of(2025, 11, 16));
	}

	public static void agregarEntrenadores() throws Exception {
		Sistema.getInstance().agregarEntrenadorASistema("Silva", "Ricardo", "40112233", LocalDate.of(1978, 2, 5), "Ofensiva");
		Sistema.getInstance().agregarEntrenadorASistema("Vidal", "Claudio", "41223344", LocalDate.of(1983, 9, 10), "Defensiva");
		Sistema.getInstance().agregarEntrenadorASistema("Castro", "Mario", "42334455", LocalDate.of(1991, 4, 22), "Ofensiva");
		Sistema.getInstance().agregarEntrenadorASistema("Rojas", "Daniel", "43445566", LocalDate.of(1988, 12, 1), "Contragolpe");
	}

	public static void agregarEquipos(long idTorneo) throws Exception {
		Sistema.getInstance().agregarEquipoATorneoYSistema("Aguilas Plateadas", LocalDate.of(2000, 2, 7), Sistema.getInstance().traerEntrenadorPorDni("40112233"), idTorneo);
		Sistema.getInstance().agregarEquipoATorneoYSistema("Tigres del Norte", LocalDate.of(2014, 9, 29), Sistema.getInstance().traerEntrenadorPorDni("42334455"), idTorneo);
		Sistema.getInstance().agregarEquipoATorneoYSistema("Estrella Polar", LocalDate.of(2009, 9, 12), Sistema.getInstance().traerEntrenadorPorDni("43445566"), idTorneo);
		Sistema.getInstance().agregarEquipoATorneoYSistema("Rayo Celeste", LocalDate.of(2015, 4, 30), Sistema.getInstance().traerEntrenadorPorDni("41223344"), idTorneo);
	}

	public static void agregarPartidoSinJugar(long idTorneo) throws Exception {
		Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 9, 7), LocalTime.of(17, 00)), "Estadio Sur", Sistema.getInstance().traerEquipoPorCodigoUnico("AGU"), Sistema.getInstance().traerEquipoPorCodigoUnico("RAY"));
		Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 9, 18), LocalTime.of(17, 00)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("TIG"), Sistema.getInstance().traerEquipoPorCodigoUnico("EST"));

		Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 14), LocalTime.of(17, 00)), "Estadio Sur", Sistema.getInstance().traerEquipoPorCodigoUnico("EST"), Sistema.getInstance().traerEquipoPorCodigoUnico("RAY"));
		Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 19), LocalTime.of(17, 00)), "Estadio Norte", Sistema.getInstance().traerEquipoPorCodigoUnico("TIG"), Sistema.getInstance().traerEquipoPorCodigoUnico("AGU"));

		Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 11, 11), LocalTime.of(17, 00)), "Estadio Norte", Sistema.getInstance().traerEquipoPorCodigoUnico("AGU"), Sistema.getInstance().traerEquipoPorCodigoUnico("EST"));
		Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 11, 11), LocalTime.of(17, 00)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("RAY"), Sistema.getInstance().traerEquipoPorCodigoUnico("TIG"));
	}

	public static void agregarJugadoresEnEquipos() throws Exception {
		// **********************************************************************************
        // APL: ÁGUILAS PLATEADAS (7 Jugadores)
        // **********************************************************************************
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Navarro", "Javier", "10000001", LocalDate.of(1995, 3, 15), 1.88f, 85.2f, "Arquero", 1, "AGU");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Gómez", "Martín", "10000002", LocalDate.of(1998, 7, 21), 1.85f, 79.5f, "Defensor", 4, "AGU");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Alonso", "Pablo", "10000003", LocalDate.of(1996, 11, 30), 1.82f, 78.1f, "Defensor", 3, "AGU");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Ríos", "Andrés", "10000004", LocalDate.of(1994, 5, 8), 1.75f, 72.0f, "Mediocampista", 8, "AGU");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Cruz", "Benjamín", "10000005", LocalDate.of(1999, 1, 1), 1.78f, 75.6f, "Mediocampista", 10, "AGU");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Paz", "Ezequiel", "10000006", LocalDate.of(2000, 9, 12), 1.80f, 76.5f, "Delantero", 9, "AGU");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Vega", "Nicolás", "10000007", LocalDate.of(1997, 4, 25), 1.77f, 74.3f, "Delantero", 11, "AGU");

        // **********************************************************************************
        // TDN: TIGRES DEL NORTE (7 Jugadores)
        // **********************************************************************************
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Castro", "Alejandro", "10000008", LocalDate.of(1993, 10, 1), 1.90f, 87.0f, "Arquero", 1, "TIG");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Herrera", "Guillermo", "10000009", LocalDate.of(1995, 2, 18), 1.86f, 81.0f, "Defensor", 2, "TIG");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Méndez", "Diego", "10000010", LocalDate.of(1998, 6, 28), 1.84f, 79.0f, "Defensor", 5, "TIG");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Soto", "Facundo", "10000011", LocalDate.of(1996, 3, 7), 1.76f, 73.5f, "Mediocampista", 7, "TIG");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("López", "Hugo", "10000012", LocalDate.of(2001, 8, 14), 1.79f, 74.0f, "Mediocampista", 16, "TIG");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Vargas", "Ignacio", "10000013", LocalDate.of(1994, 12, 5), 1.81f, 77.0f, "Delantero", 17, "TIG");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Núñez", "Marcos", "10000014", LocalDate.of(1999, 5, 20), 1.78f, 75.0f, "Delantero", 19, "TIG");

        // **********************************************************************************
        // EPL: ESTRELLA POLAR (7 Jugadores)
        // **********************************************************************************
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Torres", "Juan", "10000015", LocalDate.of(1992, 1, 10), 1.87f, 84.5f, "Arquero", 22, "EST");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Morales", "Rodrigo", "10000016", LocalDate.of(1997, 9, 2), 1.83f, 78.5f, "Defensor", 6, "EST");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Silva", "Lucas", "10000017", LocalDate.of(2000, 3, 29), 1.80f, 77.0f, "Defensor", 13, "EST");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Díaz", "Esteban", "10000018", LocalDate.of(1996, 6, 11), 1.77f, 73.0f, "Mediocampista", 20, "EST");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Ruiz", "Christian", "10000019", LocalDate.of(1993, 8, 24), 1.74f, 71.5f, "Mediocampista", 14, "EST");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Luna", "Federico", "10000020", LocalDate.of(1998, 12, 3), 1.82f, 78.0f, "Delantero", 18, "EST");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Peralta", "Mauricio", "10000021", LocalDate.of(2002, 1, 7), 1.75f, 72.5f, "Delantero", 21, "EST");

        // **********************************************************************************
        // RCL: RAYO CELESTE (7 Jugadores)
        // **********************************************************************************
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Rojas", "David", "10000022", LocalDate.of(1995, 4, 19), 1.89f, 86.0f, "Arquero", 12, "RAY");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Acosta", "Sergio", "10000023", LocalDate.of(1997, 7, 2), 1.84f, 80.0f, "Defensor", 15, "RAY");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Blanco", "Emilio", "10000024", LocalDate.of(1999, 10, 16), 1.81f, 77.5f, "Defensor", 25, "RAY");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Fernández", "Oscar", "10000025", LocalDate.of(1994, 3, 22), 1.76f, 74.0f, "Mediocampista", 28, "RAY");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Velazco", "Alan", "10000026", LocalDate.of(2000, 6, 8), 1.78f, 75.0f, "Mediocampista", 30, "RAY");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Zárate", "Carlos", "10000027", LocalDate.of(1996, 9, 3), 1.83f, 79.0f, "Delantero", 7, "RAY");
		Sistema.getInstance().agregarJugadorAEquipoYSistema("Quiroga", "Pedro", "10000028", LocalDate.of(1998, 11, 19), 1.79f, 76.5f, "Delantero", 19, "RAY");
	}

	public static void agregarResultadosPartidos(long idTorneo) throws Exception {
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 1, "10000004", 1, 2, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 1, "10000005", 1, 1, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 1, "10000007", 1, 0, 40);

		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 2, "10000011", 0, 1, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 2, "10000014", 1, 0, 90);

		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 3, "10000017", 0, 0, 20);

		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000004", 0, 1, 20);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000005", 0, 1, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000007", 2, 0, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000011", 0, 1, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000014", 1, 0, 90);

		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 5, "10000017", 1, 0, 70);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 5, "10000005", 0, 1, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 5, "10000006", 1, 0, 23);

		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000025", 0, 1, 20);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000028", 2, 0, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000014", 0, 1, 90);
		Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000013", 1, 0, 90);
	}
}
