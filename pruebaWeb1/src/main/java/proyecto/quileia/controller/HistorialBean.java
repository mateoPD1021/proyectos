package proyecto.quileia.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import proyecto.quileia.dao.HistorialDAO;

import proyecto.quileia.model.Historial;


@ManagedBean(name="histBean")
@RequestScoped
public class HistorialBean {
	
	public List<Historial> obtenerHis() {
		
		HistorialDAO hisDAO= new HistorialDAO();
		return hisDAO.buscarTodos();

	
	}
}

