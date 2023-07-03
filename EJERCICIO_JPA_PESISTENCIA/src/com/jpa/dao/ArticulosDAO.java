package com.jpa.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpa.jpa.Articulos;

public class ArticulosDAO implements IArticulosDAO {
	
	public static final String CODIGO_ARTICULO = "codigoArticulo";
	public static final String DESCRIPCION_ARTICULO= "descripcionArticulo";
	public static final String PRECIO_UNIDAD_ARTICULO= "precioUnidadArticulo";
	public static final String CANTIDAD = "cantidad";
	
	protected EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}
	
	public void alta(Articulos articulo_nuevo) {
		EntityManagerHelper.log("articulo por crear", Level.INFO, null);
		try {
			getEntityManager().persist(articulo_nuevo);
			EntityManagerHelper.log("articulo creado", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("alta incorrecta exploto", Level.SEVERE, re);
			throw re;
		}
	}
	
	@Override
	public Articulos modificacion(Articulos articulo_nuevo) {
		EntityManagerHelper.log("por realizar modificación", Level.INFO, null);
		try {
			Articulos modificacion = getEntityManager().merge(articulo_nuevo);
			EntityManagerHelper.log("modificación hecha", Level.INFO, null);
			return modificacion;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("ha fallado la modificacion", Level.SEVERE, re);
			throw re;
		}
	}
	
	public void baja(Articulos articulo_nuevo) {
		EntityManagerHelper.log("por borrar el articulo", Level.INFO, null);
		try {
			articulo_nuevo = getEntityManager().getReference(Articulos.class,
					articulo_nuevo.getCodigoArticulo());
			getEntityManager().remove(articulo_nuevo);
			EntityManagerHelper.log("articulo borrado", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("esto ha explotado no se pudo hacer la baja", Level.SEVERE, re);
			throw re;
		}
	}
	
	@Override
	public Articulos consultarPorCodigo(Long codigoArticulo) {
		EntityManagerHelper.log("por consultar el codigo", Level.INFO, null);
		try {
			Articulos articulo = getEntityManager().find(Articulos.class, codigoArticulo);
			EntityManagerHelper.log("articulo consultado", Level.INFO, null);
			return articulo;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("consulta fallida", Level.SEVERE, re);
			throw re;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Articulos> consultarTodo() {
		EntityManagerHelper.log("metodo para consultar todos los articulos en curso", Level.INFO, null);
		try {
			final String queryString = "select model from Articulos model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("No se pudo encontrar ningún artículo", Level.SEVERE, re);
			throw re;
		}
	}

}
