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
import negocioImpl.EspecialidadNegocio;
import negocioImpl.MedicoNegocio;
import negocioImpl.PacienteNegocio;
import negocioImpl.TurnoNegocio;
import negocioImpl.UsuarioNegocio;

@Configuration
public class AppConfig {

    @Bean
    public Medico beanMedico() {
        Medico medic = new Medico();
        return medic;
    }
    @Bean Usuario beanUsuario() {
        Usuario user = new Usuario();
        return user;
    }
    @Bean
    public Especialidad beanEspecialidad() {
        Especialidad espe = new Especialidad();
        return espe;
    }
    @Bean
    public Paciente beanPaciente() {
        Paciente pac = new Paciente();
        return pac;
    }
    @Bean
    public Turno beanTurno() {
        Turno turn = new Turno();
        return turn;
    }
    @Bean
    public daoMedico beanDaoMedico() {
        daoMedico daoMedic = new daoMedico();
        return daoMedic;
    }
    @Bean
    public daoTurno beanDaoTurno() {
        daoTurno daoTurn = new daoTurno();
        return daoTurn;
    }
    @Bean
    public daoPaciente beanDaoPaciente() {
        daoPaciente daoPac = new daoPaciente();
        return daoPac;
    }
    @Bean
    public daoEspecialidad beanDaoEspecialidad() {
        daoEspecialidad daoEsp = new daoEspecialidad();
        return daoEsp;
    }
    @Bean
    public daoUsuario beanDaoUsuario() {
        daoUsuario daoUser = new daoUsuario();
        return daoUser;
    }
    @Bean
    public MedicoNegocio beanMedicoNegocio() {
        MedicoNegocio medicoNeg = new MedicoNegocio();
        return medicoNeg;
    }
    @Bean
    public TurnoNegocio beanTurnoNegocio() {
        TurnoNegocio turnoNeg = new TurnoNegocio();
        return turnoNeg;
    }
    @Bean
    public PacienteNegocio beanPacienteNegocio() {
        PacienteNegocio pacienteNeg = new PacienteNegocio();
        return pacienteNeg;
    }
    @Bean
    public EspecialidadNegocio beanEspecialidadNegocio() {
        EspecialidadNegocio espcialidadNeg = new EspecialidadNegocio();
        return espcialidadNeg;
    }
    @Bean
    public UsuarioNegocio beanUsuarioNegocio() {
        UsuarioNegocio userNeg = new UsuarioNegocio();
        return userNeg;
    }
}
