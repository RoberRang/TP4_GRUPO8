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
	private int legajo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellido")
	private String apellido;
	
	@Column(name="Sexo")
	private char sexo;
	
	@Column(name="FNac")
	private LocalDate fNac;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="Localidad")
	private String localidad;
	
	@Column(name="Correo")
	private String correo;
	
	@Column(name="Telefono")
	private String telefono; 
	
	//Agregamos atributo del tipo Usuario
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name="Id_Usuario")
	private Usuario usuario;
	
	//Agregamos atributo del tipo Especialidad
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn (name="Id_Especialidad")
	private Especialidad especialidad;
	
	//Agregamos listado de turnos
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn (name="Id_Turno")
	List<Turno> listaTurnos = new ArrayList<Turno>();
	
	public Medico() {
		
	}

	public int getLegajo() {
		return this.legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFNac() {
		return this.fNac;
	}

	public void setFNac(LocalDate fNac) {
		this.fNac = fNac;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTeléfono(String telefono) {
		this.telefono = telefono;
	}
	
	//Getters y Setters para usuario
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	//Getters y Setters para especialidad
	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
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
		return "Medico [Legajo=" + legajo + ", Nombre=" + nombre + ", Apellido=" + apellido + ", Sexo=" + sexo
				+ ", FNac=" + fNac + ", Dirección=" + direccion + ", Localidad=" + localidad + ", Correo=" + correo
				+ ", Teléfono=" + telefono + "]";
	}


}
