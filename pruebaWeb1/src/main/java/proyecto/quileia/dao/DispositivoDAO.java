package proyecto.quileia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import proyecto.quileia.model.Dispositivo;
import proyecto.quileia.model.JPAUtil;


public class DispositivoDAO {
	
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Agregar un dispositivo 
	public void agregar (Dispositivo dis) {
		entity.getTransaction().begin();
		entity.persist(dis);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Editar un dispositivo

	public void actualizar(Dispositivo dis) {
		entity.getTransaction().begin();
		entity.merge(dis);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	
	public Dispositivo buscar (int id) {
		
		Dispositivo d = new Dispositivo();
		d=entity.find(Dispositivo.class, id);
		// JPAUtil.shutdown();
		return d;
		
	}
	
	public void eliminar(int id) {
		
		Dispositivo d = new Dispositivo();
		d=entity.find(Dispositivo.class, id);
		entity.getTransaction().begin();
		entity.remove(d);
		entity.getTransaction().commit();
		
	}
	
	
	
	public List<Dispositivo> buscarTodos(){
		
		List<Dispositivo> listaDisp = new ArrayList<> ();
		javax.persistence.Query q = entity.createQuery("SELECT d FROM Dispositivo d");
		listaDisp= q.getResultList();
		return listaDisp;	
	}
	
	

}
