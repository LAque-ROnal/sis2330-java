package servicio;

import modelo.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SistemaEstudiantesTest {

    private SistemaEstudiantes sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaEstudiantes(); // sistema vacio en cada test
    }

    @Test
    void registrarEstudianteNuevoDevuelveTrue() {
        assertTrue(sistema.registrar(new Estudiante("E1", "Ana", 90.0)));
    }

    @Test
    void registrarCodigoDuplicadoDevuelveFalse() {
        sistema.registrar(new Estudiante("E1", "Ana", 90.0));
        boolean segundo = sistema.registrar(new Estudiante("E1", "Otro", 50.0));
        assertFalse(segundo);
    }

    @Test
    void buscarPorCodigoExistenteDevuelveEstudiante() {
        sistema.registrar(new Estudiante("E1", "Ana", 90.0));
        assertNotNull(sistema.buscarPorCodigo("E1"));
    }

    @Test
    void buscarPorCodigoInexistenteDevuelveNull() {
        assertNull(sistema.buscarPorCodigo("NOEXISTE"));
    }

    @Test
    void actualizarPromedioDeEstudianteExistenteDevuelveTrue() {
        sistema.registrar(new Estudiante("E1", "Ana", 70.0));
        assertTrue(sistema.actualizarPromedio("E1", 95.0));
        assertEquals(95.0, sistema.buscarPorCodigo("E1").getPromedio());
    }

    @Test
    void actualizarPromedioDeEstudianteInexistenteDevuelveFalse() {
        assertFalse(sistema.actualizarPromedio("NOEXISTE", 80.0));
    }

    @Test
    void eliminarEstudianteExistenteDevuelveTrueYLoQuitaDelRanking() {
        sistema.registrar(new Estudiante("E1", "Ana", 90.0));
        assertTrue(sistema.eliminar("E1"));
        assertNull(sistema.buscarPorCodigo("E1"));
        assertEquals(0, sistema.listarRanking().size());
    }

    @Test
    void listarRankingConColeccionVaciaDevuelveListaVacia() {
        // Caso borde: sin estudiantes registrados
        ArrayList<Estudiante> ranking = sistema.listarRanking();
        assertTrue(ranking.isEmpty());
    }

    @Test
    void listarRankingOrdenaPorPromedioDescendente() {
        sistema.registrar(new Estudiante("E1", "Ana", 70.0));
        sistema.registrar(new Estudiante("E2", "Luis", 95.0));
        sistema.registrar(new Estudiante("E3", "Zoe", 80.0));

        ArrayList<Estudiante> ranking = sistema.listarRanking();
        assertEquals("E2", ranking.get(0).getCodigo()); // 95.0 primero
        assertEquals("E3", ranking.get(1).getCodigo()); // 80.0 segundo
        assertEquals("E1", ranking.get(2).getCodigo()); // 70.0 tercero
    }

    @Test
    void topNConNMayorAlTotalDevuelveTodosSinLanzarExcepcion() {
        sistema.registrar(new Estudiante("E1", "Ana", 70.0));
        sistema.registrar(new Estudiante("E2", "Luis", 95.0));

        ArrayList<Estudiante> top = sistema.topN(10); // pide mas de los que hay
        assertEquals(2, top.size());
    }
}