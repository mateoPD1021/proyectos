package proyecto.quileia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="conexion_red")

public class Redes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int tipo;
	@Column
	private String nombre;
	@Column
	private String tipo_cifrado;
	@Column
	private String usr;
	@Column
	private String pass;
	@Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo_cifrado() {
		return tipo_cifrado;
	}
	public void setTipo_cifrado(String tipo_cifrado) {
		this.tipo_cifrado = tipo_cifrado;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Redes [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", tipo_cifrado=" + tipo_cifrado + ", usr="
				+ usr + ", pass=" + pass + "]";
	}
	
	

}
