package UTNFRGP.TP4_GRUPO8;

import java.time.LocalDate;

import dao.daoMedico;
import entidad.Medico;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	daoMedico daomed = new daoMedico();

        for (int i= 1; i<13; i++) {
    		Medico med1 = new Medico();
            med1.setNombre("Medico_Nom_"+i);
            med1.setApellido("Medico_Ape_"+i);
            med1.setSexo('M');
            med1.setFNac(LocalDate.parse("1988-05-01"));
            med1.setDirección("Calle Nula "+i);
            med1.setLocalidad("Localidad_"+i);
            med1.setCorreo("medico_"+i+"_@intramed.net");
            med1.setTeléfono("telefono_"+i);
            daomed.Add(med1);
    	}
				
    }
}
