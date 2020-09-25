package proyecto.quileia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mysql.cj.api.Query;

import proyecto.quileia.model.JPAUtil;
import proyecto.quileia.model.Redes;

public class RedDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
		
	//Agregar una red 
	public void agregar (Redes red) {
		entity.getTransaction().begin();
		entity.persist(red);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}
	//Editar una red
	public void actualizar(Redes red) {
		entity.getTransaction().begin();
		entity.merge(red);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
		
	}
	
	public Redes buscar (int id) {
		
		Redes r = new Redes();
		r=entity.find(Redes.class, id);
		// JPAUtil.shutdown();
		return r;
		
	}
	
	public void eliminar(int id) {
		
		Redes r = new Redes();
		r=entity.find(Redes.class, id);
		entity.getTransaction().begin();
		entity.remove(r);
		entity.getTransaction().commit();
		
	}
	
	
	
	public List<Redes> buscarTodos(){
		
		List<Redes> listaRedes = new ArrayList<> ();
		javax.persistence.Query q = entity.createQuery("SELECT r FROM Redes r");
		listaRedes= q.getResultList();
		return listaRedes;	
	}
	
	
	

}
