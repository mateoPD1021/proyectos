package proyecto.quileia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="dispositivo")

public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String mac;
	@Column
	private String tipo;
	@Column
	private boolean conectado;
	@Column
	private int conexion_actual;
	@Column
	private String ip;
	
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isConectado() {
		return conectado;
	}
	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}
	public int getCon_actual() {
		return conexion_actual;
	}
	public void setCon_actual(int con_actual) {
		this.conexion_actual = con_actual;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", mac=" + mac + ", tipo=" + tipo + ", conectado=" + conectado
				+ ", conexion_actual=" + conexion_actual + ", ip=" + ip + "]";
	}
	

	

}
