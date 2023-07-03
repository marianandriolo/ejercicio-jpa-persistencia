package com.jpa.fachada;

import java.util.List;

import com.jpa.jpa.Articulos;

public interface IGestionArticulos {

	boolean alta(Articulos articulos);

	boolean baja(Articulos articulos);

	boolean modificacion(Articulos articulos);

	Articulos consultarPorCodigo(Long codigoArticulo);

	List<Articulos> consultarTodo();

}
