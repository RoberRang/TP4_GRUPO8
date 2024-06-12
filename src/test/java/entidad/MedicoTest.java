package entidad;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;


public class MedicoTest {

    private Medico medico;
    @Test
    public void testGetApellido() {
    // Ejemplo: Verificar que el apellido se obtenga correctamente
        medico = new Medico();
        medico.setApellido("Perez");
        assertEquals("Perez", medico.getApellido());
    }

    @Test
    public void testGetCorreo() {
        medico = new Medico();
        medico.setCorreo("Perez@mail.com");
        assertEquals("Perez@mail.com", medico.getCorreo());
    }

    @Test
    public void testGetDirección() {
        medico = new Medico();
        medico.setDireccion("Su casa 123");
        assertEquals("Su casa 123", medico.getDireccion());
    }

    @Test
    public void testGetEspecialidad() {
        medico = new Medico();
        Especialidad esp = new Especialidad();
        esp.setId((long)1);
        esp.setNombre("Gastroenterologia");
        medico.setEspecialidad(esp);
        assertEquals("Gastroenterologia", esp.getNombre());
    }

    @Test
    public void testGetFNac() {
        medico = new Medico();
        LocalDate ld = LocalDate.parse("02-01-1981", DateTimeFormatter.ofPattern("dd-MM-yyyy"));        
        medico.setFNac(ld);
        assertEquals(ld, medico.getFNac());
    }

    @Test
    public void testGetLegajo() {
        medico = new Medico();
        medico.setLegajo(123);
        assertEquals(123, medico.getLegajo());
    }

    @Test
    public void testGetLocalidad() {
        medico = new Medico();
        medico.setLocalidad("Localidad");
        assertEquals("Localidad", medico.getLocalidad());
    }

    @Test
    public void testGetNombre() {
        medico = new Medico();
        medico.setNombre("Juan");
        assertEquals("Juan", medico.getNombre());
    }

    @Test
    public void testGetSexo() {
        medico = new Medico();
        medico.setSexo('M');
        assertEquals('M', medico.getSexo());
    }

    @Test
    public void testGetTeléfono() {
        medico = new Medico();
        medico.setTeléfono("5555-5555");
        assertEquals("5555-5555", medico.getTelefono());
    }

    @Test
    public void testGetUsuario() {
        medico = new Medico();
        Usuario user = new Usuario();
        user.setId((long)1);
        user.setNombre("Med_0100");
        medico.setUsuario(user);
        assertEquals("Med_0100", user.getNombre());
    }    
}
