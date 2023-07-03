package com.jpa.dao;

import java.util.List;

import com.jpa.jpa.Articulos;

public interface IArticulosDAO {
	
	public void alta(Articulos articulo_nuevo) ;
	public void baja(Articulos articulo_nuevo);
	Articulos modificacion(Articulos articulo_nuevo);
	Articulos consultarPorCodigo(Long codigoArticulo);
	List<Articulos> consultarTodo();

}
