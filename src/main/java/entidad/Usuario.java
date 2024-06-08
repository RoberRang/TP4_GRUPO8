package entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Password")
    private String password;

    
    //Agregamos Medico
    //@OneToOne(mappedBy="usuario", fetch= FetchType.EAGER)
    private Medico medico;
    
    // Constructor en blanco
    public Usuario() {
        // Puedes inicializar atributos aquí si es necesario
    }
    
    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Agregamos getters y setters para Medico   
    public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	
    /* Método toString
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + password + '\'' +
                '}';
    }*/
	
	// toString() actualizado
	@Override
	public String toString() {
		String mensaje = "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", medico=" ;
		if(medico != null)
			mensaje+= medico.getNombre() + ", " + medico.getApellido() + " - " + medico.getEspecialidad() +"]";
		return mensaje;
	}

}
