package proyecto.quileia.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import proyecto.quileia.dao.DispositivoDAO;
import proyecto.quileia.model.Dispositivo;


@ManagedBean(name="disBean")
@RequestScoped


public class DispositivoBean {

	public List<Dispositivo> obtenerDis() {
		DispositivoDAO disDAO=new DispositivoDAO();
		return disDAO.buscarTodos();
		

	}
	
	public String editar(int id) {
		
		DispositivoDAO disDAO=new DispositivoDAO();
		Dispositivo d=new Dispositivo();
		d=disDAO.buscar(id);
		System.out.println(d);
		
		Map<String, Object> sessionMapd= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMapd.put("dispositivo",d);
		
		return "/faces/editarD.xhtml";
	
	}
	
	public String actualizar(Dispositivo dispositivo) {
		
		DispositivoDAO disDAO=new DispositivoDAO();
		
		disDAO.actualizar(dispositivo);
		
		return "/faces/dispositivos.xhtml";
	}
	
	public	String eliminar(int id) {
		
		DispositivoDAO disDAO=new DispositivoDAO();
		disDAO.eliminar(id);
		System.out.println("dis Eliminada..");
		return "/faces/dispositivos.xhtml";
	}
	
	public String nuevo() {	
		Dispositivo d=new Dispositivo();
		Map<String, Object> sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("dispositivo",d);
		
		return "/faces/nuevoD.xhtml";
	}
	
	public String guardar(Dispositivo dispositivo) {

		DispositivoDAO disDAO=new DispositivoDAO();
		disDAO.agregar(dispositivo);
		return "/faces/dispositivos.xhtml";
	}
	

	
}