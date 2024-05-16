package entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medicos")
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Legajo;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Apellido")
	private String Apellido;
	
	@Column(name="Sexo")
	private char Sexo;
	
	@Column(name="FNac")
	private LocalDate FNac;
	
	@Column(name="Direccion")
	private String Dirección;
	
	@Column(name="Localidad")
	private String Localidad;
	
	@Column(name="Correo")
	private String Correo;
	
	@Column(name="Telefono")
	private String Teléfono; 
	
	//Agregamos atributo del tipo Usuario
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name="usuario")
	private Usuario Usuario;
	
	//Agregamos atributo del tipo Especialidad
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name="especialidad")
	private Especialidad Especialidad;
	
	//Agregamos listado de turnos
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn (name="id_Turno")
	List<Turno> listaTurnos = new ArrayList<Turno>();
	
	public Medico() {
		
	}

	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}

	public LocalDate getFNac() {
		return FNac;
	}

	public void setFNac(LocalDate fNac) {
		FNac = fNac;
	}

	public String getDirección() {
		return Dirección;
	}

	public void setDirección(String dirección) {
		Dirección = dirección;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getTeléfono() {
		return Teléfono;
	}

	public void setTeléfono(String teléfono) {
		Teléfono = teléfono;
	}
	
	//Getters y Setters para usuario
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	//Getters y Setters para especialidad
	public Especialidad getEspecialidad() {
		return Especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		Especialidad = especialidad;
	}

	//Getters y Setters para lista turnos
	public List<Turno> getListaTurnos() {
		return listaTurnos;
	}

	public void setListaTurnos(List<Turno> listaTurnos) {
		this.listaTurnos = listaTurnos;
	}

	@Override
	public String toString() {
		return "Medico [Legajo=" + Legajo + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo
				+ ", FNac=" + FNac + ", Dirección=" + Dirección + ", Localidad=" + Localidad + ", Correo=" + Correo
				+ ", Teléfono=" + Teléfono + "]";
	}


}
