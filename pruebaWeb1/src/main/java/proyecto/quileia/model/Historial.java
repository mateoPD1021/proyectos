package proyecto.quileia.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit_dispositivos")
public class Historial {

	@Id
	@Column
	private int id;
	@Column
	private String mac;
	@Column
	private int conexion_actual;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getConexion_actual() {
		return conexion_actual;
	}
	public void setConexion_actual(int conexion_actual) {
		this.conexion_actual = conexion_actual;
	}
	
	@Override
	public String toString() {
		return "HistorialBean [id=" + id + ", mac=" + mac + ", conexion_actual=" + conexion_actual + "]";
	}

}
