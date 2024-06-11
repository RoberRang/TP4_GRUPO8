package resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import daoImpl.daoEspecialidad;
import daoImpl.daoMedico;
import daoImpl.daoPaciente;
import daoImpl.daoTurno;
import daoImpl.daoUsuario;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;
import entidad.Turno;
import entidad.Usuario;

@Configuration
public class AppConfig {

    @Bean
    public Medico nuevoMedico() {
        Medico medic = new Medico();
        return medic;
    }
    @Bean Usuario nuevoUsuario() {
        Usuario user = new Usuario();
        return user;
    }
    @Bean
    public Especialidad nuevaEspecialidad() {
        Especialidad espe = new Especialidad();
        return espe;
    }
    @Bean
    public Paciente nuevoPaciente() {
        Paciente pac = new Paciente();
        return pac;
    }
    @Bean
    public Turno nuevoTurno() {
        Turno turn = new Turno();
        return turn;
    }
    @Bean
    public daoMedico nuevoDaoMedico() {
        daoMedico daoMedic = new daoMedico();
        return daoMedic;
    }
    @Bean
    public daoTurno nuevoDaoTurno() {
        daoTurno daoTurn = new daoTurno();
        return daoTurn;
    }
    @Bean
    public daoPaciente nuevoDaoPaciente() {
        daoPaciente daoPac = new daoPaciente();
        return daoPac;
    }
    @Bean
    public daoEspecialidad nuevoDaoEspecialidad() {
        daoEspecialidad daoEsp = new daoEspecialidad();
        return daoEsp;
    }
    @Bean
    public daoUsuario nuevoDaoUsuario() {
        daoUsuario daoUser = new daoUsuario();
        return daoUser;
    }
}
