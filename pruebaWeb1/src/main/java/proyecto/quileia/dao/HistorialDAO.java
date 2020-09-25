package proyecto.quileia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import proyecto.quileia.model.Historial;
import proyecto.quileia.model.JPAUtil;


public class HistorialDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();	
	public Historial buscar (int id) {
		
		Historial h = new Historial();
		h=entity.find(Historial.class, id);
		// JPAUtil.shutdown();
		return h;
		
	}
	
	
	
	public List<Historial> buscarTodos(){
		
		List<Historial> listaHistorial = new ArrayList<> ();
		javax.persistence.Query q = entity.createQuery("SELECT h FROM Historial h");
		listaHistorial= q.getResultList();
		return listaHistorial;	
	}
	
	
	

}
