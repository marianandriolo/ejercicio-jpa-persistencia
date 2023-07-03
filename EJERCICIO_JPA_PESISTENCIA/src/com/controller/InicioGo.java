package com.controller;


import java.util.Iterator;
import java.util.List;

import com.jpa.fachada.GestionArticulos;
import com.jpa.fachada.IGestionArticulos;
import com.jpa.jpa.Articulos;

public class InicioGo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IGestionArticulos gestionArticulos = new GestionArticulos();

		Articulos articuloNuevo = new Articulos();
		articuloNuevo.setCantidad(455);
		articuloNuevo.setCodigoArticulo(1324);
		articuloNuevo.setDescripcionArticulo("vaso de cristal");
		articuloNuevo.setPrecioUnidadArticulo(23.43);

		boolean altaCorrecta = gestionArticulos.alta(articuloNuevo); 

		if (altaCorrecta) {
			System.out.println("oki el alta");
		} else {
			System.out.println("algo fallo");
		}
		articuloNuevo.setCantidad(456);
		articuloNuevo.setPrecioUnidadArticulo(25.43);
		
		boolean modificacionCorrecta = gestionArticulos.modificacion(articuloNuevo);
		
		if(modificacionCorrecta) {
			System.out.println("oki la modificación");
		} else {
			System.out.println("exploto la modificacion");
		}
		
		Articulos articuloConsultado = gestionArticulos.consultarPorCodigo((long)404);

		if (articuloConsultado != null) {
			System.out.println(articuloConsultado);
		}

	boolean bajaCorrecta = gestionArticulos.baja(articuloNuevo);
		
		if(bajaCorrecta) {
			System.out.println("oki la baja");
		} else {
			System.out.println("exploto la baja");
		}
		
		List<Articulos> listaArticulos =  gestionArticulos.consultarTodo(); 

		for (Iterator<Articulos> iterator = listaArticulos.iterator(); iterator.hasNext();) {
			Articulos articulos = iterator.next();
			System.out.println(articulos);
		}

		
	}
}


