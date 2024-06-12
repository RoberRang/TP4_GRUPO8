package UTNFRGP.TP4_GRUPO8;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import daoImpl.daoEspecialidad;
import daoImpl.daoMedico;
import daoImpl.daoPaciente;
import daoImpl.daoTurno;
import daoImpl.daoUsuario;
import entidad.Especialidad;
import entidad.EstadoTurno;
import entidad.Medico;
import entidad.Paciente;
import entidad.Turno;
import entidad.Usuario;
import negocioImpl.EspecialidadNegocio;
import negocioImpl.MedicoNegocio;
import negocioImpl.PacienteNegocio;
import negocioImpl.TurnoNegocio;
import negocioImpl.UsuarioNegocio;
import resources.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        //Inicializamos beans de negocio
        EspecialidadNegocio especialidadNeg = (EspecialidadNegocio)appContext.getBean("beanEspecialidadNegocio");
        UsuarioNegocio usuarioNeg = (UsuarioNegocio)appContext.getBean("beanUsuarioNegocio");
        MedicoNegocio medicoNeg = (MedicoNegocio)appContext.getBean("beanMedicoNegocio");
        PacienteNegocio pacienteNeg = (PacienteNegocio)appContext.getBean("beanPacienteNegocio");
        TurnoNegocio turnoNeg = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
        
    	
    	for (int i = 1; i < 13; i++) {
    	    Especialidad espe = (Especialidad) appContext.getBean("beanEspecialidad"); // new Especialidad();
    	    espe.setNombre("Gastroenterologia_" + i);
    	    especialidadNeg.Add(espe);
    	}
    	
    	
    	for (int i = 1; i < 13; i++) {
    	    Usuario user = (Usuario) appContext.getBean("beanUsuario"); // new Usuario();
    	    user.setNombre("Dr.Jaime_" + i);
    	    user.setPassword("inicio01."+i);
    	    usuarioNeg.Add(user);
    	}    	
        
    	
    	List<Especialidad> especialidades = especialidadNeg.ReadAll();
    	List<Usuario> usuarios = usuarioNeg.ReadAll();

    	for (int i = 1; i < 13; i++) {
    		
    	    Medico med1 = (Medico) appContext.getBean("beanMedico"); // new Medico();
    	    med1.setNombre("Medico_Nom_" + i);
    	    med1.setApellido("Medico_Ape_" + i);
    	    med1.setSexo('M');
    	    med1.setFNac(LocalDate.parse("1988-05-01"));
    	    med1.setDireccion("Calle Nula " + i);
    	    med1.setLocalidad("Localidad_" + i);
    	    med1.setCorreo("medico_" + i + "_@intramed.net");
    	    med1.setTeléfono("telefono_" + i);
            med1.setActivo(true);
    	    
    	    // Asignacion de una especialidad al médico y usuario 
    	    // asignamos una especialidad y el usuario a cada médico de forma secuencial
    	    Especialidad especialidad = especialidades.get(i - 1); // con i-1 porque el indice arranca en 0
    	    Usuario usuario = usuarios.get(i-1);
    	    
    	    med1.setUsuario(usuario);
    	    med1.setEspecialidad(especialidad);
    	    
    	    medicoNeg.Add(med1);
    	}
    	
    	
    	for (int i = 1; i < 13; i++) {
    		
    	    Paciente pac1 = (Paciente) appContext.getBean("beanPaciente"); // new Paciente();
    	    
    	    pac1.setNombre("Pedrito_" + i);
    	    pac1.setApellido("Ramirez_"+i);
    	    pac1.setCorreoElectronico("paciente_90@gmail.com_"+i);
    	    pac1.setDireccion("La plata 403_"+i);
    	    pac1.setDni("2588632_"+i);
    	    pac1.setFechaNacimiento("1988-05-01");
    	    pac1.setLocalidad("CABA_"+i);
    	    pac1.setProvincia("Buenos Aires_"+i);
    	    pac1.setTelefono("215585_"+i);
    	    pac1.setActivo(true);
    	    pacienteNeg.Add(pac1);
    	}
    	
    	//Alta de turnos 
    
    	
    	List<Medico> medicos = medicoNeg.ReadAll();
    	List<Paciente> pacientes = pacienteNeg.ReadAll();

    	
    	for (int i = 1; i < 13; i++) {
    		
    	    Turno turn1 = (Turno) appContext.getBean("beanTurno"); // new Turno();
    	    
    	    turn1.setEstado(EstadoTurno.PENDIENTE);
    	    turn1.setFecha("1988-05-01");
    	    turn1.setHora("20:0"+i);
    	    turn1.setObservacion("Descompuesto"+i);
    	    
    	    Medico medico = medicos.get(i-1);
    	    Paciente paciente = pacientes.get(i-1);
    	    
    	    turn1.setMedico(medico);
    	    turn1.setPaciente(paciente);
    	    
    	    
    	    turnoNeg.Add(turn1);
    	}
    	
    	//ABML TP4 
  
        
        //Alta, modificacion y borrado de paciente
        
        Paciente pac2 = (Paciente) appContext.getBean("beanPaciente");// new Paciente();
	    
        pac2.setNombre("PRUEBA_ABML");
        pac2.setApellido("Ramirez");
        pac2.setCorreoElectronico("paciente_90@gmail.com");
        pac2.setDireccion("La plata 403");
        pac2.setDni("2588632");
        pac2.setFechaNacimiento("1988-05-01");
        pac2.setLocalidad("CABA");
        pac2.setProvincia("Buenos Aires");
        pac2.setTelefono("215585");
        pac2.setActivo(true);
	    
        pacienteNeg.Add(pac2);
	    
        pacienteNeg.Delete(pac2);
	    
	    
	      Paciente pac3 = (Paciente) appContext.getBean("beanPaciente"); //new Paciente();
		    
	        pac3.setNombre("PRUEBA_ABML2");
	        pac3.setApellido("Fernandez");
	        pac3.setCorreoElectronico("paciente_90@gmail.com");
	        pac3.setDireccion("La plata 403");
	        pac3.setDni("2588632");
	        pac3.setFechaNacimiento("1988-05-01");
	        pac3.setLocalidad("CABA");
	        pac3.setProvincia("Buenos Aires");
	        pac3.setTelefono("215585");
		    
	        pacienteNeg.Add(pac3);
		    
		    pac3.setDni("11111111");
		    pac3.setCorreoElectronico("CORREOMOFICADO POR ABML");
		    pac3.setProvincia("MENDOZA");
            pac3.setActivo(false);
            pacienteNeg.Update(pac3);
	    
	    // Listado de turnos con sus relaciones 
	  	
    	List<Turno> todosLosTurnos = turnoNeg.ReadAll();
        for (Turno turno : todosLosTurnos) {
            System.out.println("Id Turno: " + turno.getId() + ", Fecha: " + turno.getFecha() + ", Médico: " + turno.getMedico().getNombre());
            
            Usuario usuarioDelMedico = turno.getMedico().getUsuario();
            System.out.println("   Usuario del Médico: " + usuarioDelMedico.getNombre());
        }
        
       
      //Alta, Modificacion y borrado de turno
        
        Turno turn1 = (Turno) appContext.getBean("beanTurno"); //new Turno();
	   
	    turn1.setEstado(EstadoTurno.PENDIENTE);
	    turn1.setFecha("1988-05-18");
	    turn1.setHora("20:00");
	    turn1.setObservacion("N/A");
	    
	    Medico medico = medicos.get(1);
	    Paciente paciente = pacientes.get(1);
	    
	    turn1.setMedico(medico);
	    turn1.setPaciente(paciente);
	    
	    turnoNeg.Add(turn1);
	    
	    //Modificacion
        turn1.setEstado(EstadoTurno.PRESENTE);
        turn1.setObservacion("Paciente atendido por control");
        turnoNeg.Update(turn1);
        
        System.out.println(turn1.toString());
        
        //Baja
        turnoNeg.Delete(turn1);
        
     // mostrar los datos bidireccionados de un medico con su usuario
        
        for (Medico medico1 : medicos) {
            System.out.println(medico1);
            System.out.println(medico1.getUsuario());               
            int length = medico1.toString().length();
        
            for (int i = 0; i < length; i++) {
                System.out.print("-");
            }
            System.out.println(); 
        }
       
      //Alta, Modificacion y borrado de turno

        MedicoNegocio medicoNeg1 = (MedicoNegocio)appContext.getBean("beanMedicoNegocio");
        List<Medico> medicos1 = medicoNeg1.ReadAll();
        //TurnoNegocio turnoNeg1 = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
        PacienteNegocio pacienteNeg1 = (PacienteNegocio)appContext.getBean("beanPacienteNegocio");
        List<Paciente> pacientes1 = pacienteNeg1.ReadAll();
        
        //Agrego turnos 01-01-2025 para prueba
        Turno turn2 = (Turno) appContext.getBean("beanTurno"); //new Turno();
        turn2.setEstado(EstadoTurno.PENDIENTE);
        turn2.setFecha("2025-01-01");
        turn2.setHora("20:00");
        turn2.setObservacion("N/A");

        Medico medico1 = medicos1.get(2);
        Paciente paciente1 = pacientes1.get(2);

        turn2.setMedico(medico1);
        turn2.setPaciente(paciente1);

        turnoNeg.Add(turn2);
        
        Turno turn3 = (Turno) appContext.getBean("beanTurno"); // new Turno();
        turn3.setEstado(EstadoTurno.PENDIENTE);
        turn3.setFecha("2025-01-01");
        turn3.setHora("15:00");
        turn3.setObservacion("N/A");
        turn3.setMedico(medico1);
        turn3.setPaciente(paciente1);
        
        turnoNeg.Add(turn3);
        
        Turno turn4 = (Turno) appContext.getBean("beanTurno"); // new Turno();
        turn4.setEstado(EstadoTurno.PENDIENTE);
        turn4.setFecha("2025-01-01");
        turn4.setHora("18:00");
        turn4.setObservacion("N/A");
        turn4.setMedico(medico1);
        turn4.setPaciente(paciente1);
        
        turnoNeg.Add(turn4);
         
        Turno turn5 = (Turno) appContext.getBean("beanTurno"); //new Turno();
        turn5.setEstado(EstadoTurno.PRESENTE);
        turn5.setFecha("2025-01-01");
        turn5.setHora("18:00");
        turn5.setObservacion("N/A");
        turn5.setMedico(medico1);
        turn5.setPaciente(paciente1);
        
        turnoNeg.Add(turn5);
        
        Turno turn6 = (Turno) appContext.getBean("beanTurno"); //new Turno();
        turn6.setEstado(EstadoTurno.PRESENTE);
        turn6.setFecha("2025-01-01");
        turn6.setHora("18:00");
        turn6.setObservacion("N/A");
        turn6.setMedico(medico1);
        turn6.setPaciente(paciente1);
        
        turnoNeg.Add(turn6);
        
        Turno turn7 = (Turno) appContext.getBean("beanTurno"); //new Turno();
        turn7.setEstado(EstadoTurno.AUSENTE);
        turn7.setFecha("2025-01-01");
        turn7.setHora("18:00");
        turn7.setObservacion("N/A");
        turn7.setMedico(medico1);
        turn7.setPaciente(paciente1);
        
        turnoNeg.Add(turn7);
    }
}
