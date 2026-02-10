package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import model.*;

public class TestAgregarDatosClausura25 {

    public static void agregarTorneo() throws Exception {
        // Datos del Torneo según PDF
        Sistema.getInstance().agregarTorneoASistema("Torneo Clausura", "2025", LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 14));
    }

    public static void agregarEntrenadores() throws Exception {
        // Entrenadores con sus respectivas tácticas
        Sistema.getInstance().agregarEntrenadorASistema("Gómez", "Carlos", "12345678", LocalDate.of(1980, 1, 1), "4-4-2");
        Sistema.getInstance().agregarEntrenadorASistema("Martínez", "Luis", "22345678", LocalDate.of(1982, 1, 1), "4-3-3");
        Sistema.getInstance().agregarEntrenadorASistema("Pérez", "Jorge", "32345678", LocalDate.of(1985, 1, 1), "3-5-2");
        Sistema.getInstance().agregarEntrenadorASistema("Suárez", "Andrés", "42345678", LocalDate.of(1983, 1, 1), "5-3-2");
    }

    public static void agregarEquipos(long idTorneo) throws Exception {
        // Registro con los NUEVOS códigos solicitados
        Sistema.getInstance().agregarEquipoATorneoYSistema("Leones", LocalDate.of(2010, 1, 1), Sistema.getInstance().traerEntrenadorPorDni("12345678"), idTorneo); // Genera LEO
        Sistema.getInstance().agregarEquipoATorneoYSistema("Tigres", LocalDate.of(2012, 3, 15), Sistema.getInstance().traerEntrenadorPorDni("22345678"), idTorneo); // Genera TIG
        Sistema.getInstance().agregarEquipoATorneoYSistema("Halcones", LocalDate.of(2015, 7, 20), Sistema.getInstance().traerEntrenadorPorDni("32345678"), idTorneo); // Genera HAL
        Sistema.getInstance().agregarEquipoATorneoYSistema("Lobos", LocalDate.of(2013, 9, 5), Sistema.getInstance().traerEntrenadorPorDni("42345678"), idTorneo); // Genera LOB
    }

    public static void agregarPartidoSinJugar(long idTorneo) throws Exception {
        // Cronograma de partidos usando los nuevos códigos
        Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 10), LocalTime.of(15, 0)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("LEO"), Sistema.getInstance().traerEquipoPorCodigoUnico("TIG"));
        Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 17), LocalTime.of(16, 0)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("HAL"), Sistema.getInstance().traerEquipoPorCodigoUnico("LOB"));
        Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 24), LocalTime.of(15, 0)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("LEO"), Sistema.getInstance().traerEquipoPorCodigoUnico("HAL"));
        Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 31), LocalTime.of(16, 0)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("TIG"), Sistema.getInstance().traerEquipoPorCodigoUnico("LOB"));
        Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 7), LocalTime.of(15, 30)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("LEO"), Sistema.getInstance().traerEquipoPorCodigoUnico("LOB"));
        Sistema.getInstance().agregarPartidoEnTorneo(idTorneo, LocalDateTime.of(LocalDate.of(2025, 10, 14), LocalTime.of(15, 30)), "Estadio Central", Sistema.getInstance().traerEquipoPorCodigoUnico("TIG"), Sistema.getInstance().traerEquipoPorCodigoUnico("HAL"));
    }

    public static void agregarJugadoresEnEquipos() throws Exception {
        // Leones (LEO)
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Pérez", "Juan", "10000001", LocalDate.of(2000, 2, 10), 1.80f, 75.0f, "Delantero", 9, "LEO");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("López", "Martín", "10000002", LocalDate.of(1998, 6, 12), 1.82f, 78.0f, "Defensor", 2, "LEO");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Díaz", "Lucas", "10000003", LocalDate.of(2001, 4, 18), 1.75f, 70.0f, "Mediocampista", 5, "LEO");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Ruiz", "Franco", "10000004", LocalDate.of(1999, 11, 3), 1.85f, 82.0f, "Arquero", 1, "LEO");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Torres", "Agustín", "10000005", LocalDate.of(2002, 7, 21), 1.78f, 74.0f, "Delantero", 11, "LEO");

        // Tigres (TIG)
        Sistema.getInstance().agregarJugadorAEquipoYSistema("González", "Diego", "10000006", LocalDate.of(1999, 2, 4), 1.83f, 80.0f, "Arquero", 1, "TIG");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Romero", "Nicolás", "10000007", LocalDate.of(1997, 9, 10), 1.80f, 77.0f, "Defensor", 4, "TIG");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Sosa", "Rodrigo", "10000008", LocalDate.of(2000, 12, 12), 1.74f, 71.0f, "Mediocampista", 8, "TIG");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Vera", "Matías", "10000009", LocalDate.of(2002, 1, 5), 1.79f, 75.0f, "Delantero", 7, "TIG");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Castro", "Pablo", "10000010", LocalDate.of(1998, 5, 22), 1.81f, 79.0f, "Defensor", 3, "TIG");

        // Halcones (HAL)
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Cabrera", "Emiliano", "10000011", LocalDate.of(1999, 3, 14), 1.86f, 83.0f, "Arquero", 1, "HAL");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Morales", "Javier", "10000012", LocalDate.of(2001, 10, 19), 1.79f, 76.0f, "Defensor", 2, "HAL");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Rivas", "Gonzalo", "10000013", LocalDate.of(2000, 8, 30), 1.77f, 74.0f, "Mediocampista", 10, "HAL");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Fernández", "Lautaro", "10000014", LocalDate.of(2003, 2, 17), 1.83f, 78.0f, "Delantero", 9, "HAL");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Blanco", "Mateo", "10000015", LocalDate.of(2002, 4, 23), 1.72f, 69.0f, "Mediocampista", 6, "HAL");

        // Lobos (LOB)
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Herrera", "Facundo", "10000016", LocalDate.of(1998, 12, 8), 1.84f, 81.0f, "Arquero", 1, "LOB");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Ramos", "Ignacio", "10000017", LocalDate.of(1999, 9, 1), 1.80f, 77.0f, "Defensor", 4, "LOB");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Benítez", "Tomás", "10000018", LocalDate.of(2000, 5, 15), 1.74f, 72.0f, "Mediocampista", 5, "LOB");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Luna", "Sebastián", "10000019", LocalDate.of(2001, 7, 7), 1.81f, 76.0f, "Delantero", 7, "LOB");
        Sistema.getInstance().agregarJugadorAEquipoYSistema("Correa", "Enzo", "10000020", LocalDate.of(2002, 3, 28), 1.78f, 75.0f, "Defensor", 2, "LOB");
    }

    public static void agregarResultadosPartidos(long idTorneo) throws Exception {
        // Las estadísticas se cargan por DNI de jugador, el código de equipo no afecta aquí directamente
        // Partido 1 (LEO vs TIG)
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 1, "10000001", 1, 0, 90); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 1, "10000005", 1, 0, 85); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 1, "10000009", 1, 0, 90); 

        // Partido 2 (HAL vs LOB)
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 2, "10000014", 1, 0, 90); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 2, "10000019", 1, 0, 90); 

        // Partido 3 (LEO vs HAL)
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 3, "10000001", 2, 0, 90); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 3, "10000005", 1, 0, 90); 

        // Partido 4 (TIG vs LOB)
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000019", 1, 0, 90); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 4, "10000020", 1, 0, 90); 

        // Partido 5 (LEO vs LOB)
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 5, "10000005", 1, 0, 90); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 5, "10000019", 2, 0, 80); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 5, "10000020", 1, 0, 90); 

        // Partido 6 (TIG vs HAL)
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000008", 1, 0, 80); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000009", 1, 0, 90); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000013", 1, 0, 85); 
        Sistema.getInstance().agregarEstadisticaPartidoTorneo(idTorneo, 6, "10000014", 1, 0, 90); 
    }
}