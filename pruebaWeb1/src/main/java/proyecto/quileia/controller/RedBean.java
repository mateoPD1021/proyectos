package proyecto.quileia.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Id;

import com.mysql.cj.api.log.Log;

import proyecto.quileia.dao.RedDAO;
import proyecto.quileia.model.Dispositivo;
import proyecto.quileia.model.Redes;

@ManagedBean(name="redBean")
@RequestScoped
public class RedBean {
	
	public int pirobo = 0;

	public List<Redes> obtenerRedes() {
		RedDAO redDAO=new RedDAO();
		return redDAO.buscarTodos();
	
	}
	
	public ArrayList datosList() {
		
		DispositivoBean d =new DispositivoBean();
		ArrayList id_array = new ArrayList();
		ArrayList dis_array =new ArrayList();
		int cont=0;
	
		List<Redes> listaR = obtenerRedes();
		List<Dispositivo> listaD = d.obtenerDis();
		
		
//		
//		listaR.forEach(conexion -> {
//
//			pirobo = 0;
//			
//			listaD.forEach(resp2 -> {
//				System.out.println(resp2.getCon_actual());
//				System.out.println(conexion.getId());
//				if(resp2.getCon_actual() == conexion.getId()) {
//					pirobo++;
//				}
//				
//			});
//			System.out.println("Entro ----------antes del remove----------------");
//			
//			if(pirobo>=3) {
//				listaR.remove(conexion.getId());
//				System.out.println("se removio"+ conexion.getNombre());
//			}
//			System.out.println("Entro ---------------------------");
//		
//		});
		
		
		
		
		
		for(int indice = 0;indice<obtenerRedes().size();indice++)
		{	
			id_array.add(obtenerRedes().get(indice).getId());
			//System.out.println("***************************");
		    //System.out.println(id_array);
		    
		}
		
		for(int indiceD = 0;indiceD<d.obtenerDis().size();indiceD++)
		{
			dis_array.add(d.obtenerDis().get(indiceD).getCon_actual());
			Collections.sort(dis_array);
			
		}	
		
		

//		try {
//			
//	        int contador=0;
//	        int aux=(int) dis_array.get(0);
//	        for (int i = 0; i < dis_array.size(); i++) {
//	            if(aux == (int)dis_array.get(i)){
//	                contador++;
//	            } else {
//	                System.out.print(contador + ",");
//	                if (contador>3) {
//	                	dis_array.get(100);
//	                }
//	                contador=1;
//	                aux=(int)dis_array.get(i);
//	            }
//	        }
//	        System.out.print(contador );
//			
//
//			System.out.println("***************************");
//			System.out.println(dis_array);
//			System.out.println(dis_array);
//		   
//		} catch (Exception e) {
//		    System.out.println ("El error es: xd");
//		    e.printStackTrace();
//		}
//		
	
		return id_array;
		
	}

	
	public String editar(int id) {
		
		RedDAO redDAO=new RedDAO();
		Redes r=new Redes();
		r=redDAO.buscar(id);
		System.out.println(r);
		
		Map<String, Object> sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("red",r);
		
		return "/faces/editar.xhtml";
	
	}
	
	public String actualizar(Redes red) {
		
		RedDAO redDAO=new RedDAO();
		
		redDAO.actualizar(red);
		
		return "/faces/redes.xhtml";
	}
	
	public	String eliminar(int id) {
		
		RedDAO redDAO=new RedDAO();
		redDAO.eliminar(id);
		System.out.println("Red Eliminada..");
		return "/faces/redes.xhtml";
	}
	
	public String nuevo() {	
		Redes r=new Redes();
		Map<String, Object> sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("red",r);
		
		return "/faces/nuevo.xhtml";
	}
	
	public String guardar(Redes red) {
		RedDAO redDAO=new RedDAO();
		redDAO.agregar(red);
		return "/faces/redes.xhtml";
	}

}
