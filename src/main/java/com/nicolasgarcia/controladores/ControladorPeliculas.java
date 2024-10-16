package com.nicolasgarcia.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
		listaPeliculas.put("Tarzán", "Kevin Lima");		
		listaPeliculas.put("Mulán", "Barry Cook");
		listaPeliculas.put("Oliver", "Kevin Lima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");	
	}
	
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas(Model modelo) {
		modelo.addAttribute("peliculas", listaPeliculas);
		return "index.jsp";
	}
	
	@GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculaPorNombre(@PathVariable("nombre") String nombre, Model modelo) {
        if (listaPeliculas.containsKey(nombre)) {
            String director = listaPeliculas.get(nombre);
            modelo.addAttribute("nombrePelicula", nombre);
            modelo.addAttribute("nombreDirector", director);
            return "detallePelicula.jsp";
        } else {
            modelo.addAttribute("error", "La película no se encuentra en nuestra lista.");
            return "detallePelicula.jsp";
        }
    }
	
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable("nombre") String nombreDirector, Model modelo) {
	    List<String> peliculasDelDirector = new ArrayList<>();
	    
	    // Recorrer el mapa y agregar películas del director
	    for (Map.Entry<String, String> entry : listaPeliculas.entrySet()) {
	        if (entry.getValue().equals(nombreDirector)) {
	            peliculasDelDirector.add(entry.getKey());
	        }
	    }

	    // Verificar si se encontraron películas
	    if (!peliculasDelDirector.isEmpty()) {
	        modelo.addAttribute("peliculasDelDirector", peliculasDelDirector);
	        modelo.addAttribute("nombreDirector", nombreDirector);
	    } else {
	        modelo.addAttribute("error", "No contamos con películas con ese director en nuestra lista.");
	    }
	    
	    return "peliculasPorDirector.jsp";
	}


}
