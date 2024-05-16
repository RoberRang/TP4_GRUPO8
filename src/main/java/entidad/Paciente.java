package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Pacientes")
public class Paciente implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Localidad")
    private String localidad;

    @Column(name = "Provincia")
    private String provincia;

    @Column(name = "FechaNacimiento")
    private String fechaNacimiento;

    @Column(name = "CorreoElectronico")
    private String correoElectronico;
    
    
  //Agregamos listado de turnos
  	@OneToMany(cascade = {CascadeType.ALL})
  	@JoinColumn (name="id_Turno")
  	List<Turno> listaTurnos = new ArrayList<Turno>();

    // Constructor en blanco
    public Paciente() {
        // Deja los atributos en sus valores por defecto
    }

    // Constructor con todos los atributos
    public Paciente(String nombre, String apellido, String dni, String telefono,
                    String direccion, String localidad, String provincia,
                    String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }

    // Getters y Setters
    // Puedes generar automáticamente estos métodos en tu IDE para acceder a las propiedades.

    // Método toString
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }

    // Otros métodos relacionados con el paciente (opcional)
}

