package UTNFRGP.TP4_GRUPO8;

import java.time.LocalDate;

import entidad.Medico;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Medico med1 = new Medico();
		med1.setNombre("Daniel");
		med1.setApellido("Diaz");
		med1.setSexo('M');
		med1.setFNac(LocalDate.parse("1988-05-24"));
		med1.setDirección("Calle Nula 123");
		med1.setLocalidad("Belgrano");
		med1.setCorreo("danieldiaz@intramed.net");
		med1.setTeléfono("1167891452");
    }
}
