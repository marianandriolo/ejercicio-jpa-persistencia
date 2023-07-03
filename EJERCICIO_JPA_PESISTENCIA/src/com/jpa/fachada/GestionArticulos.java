package com.jpa.fachada;

import java.util.List;

import com.jpa.dao.ArticulosDAO;
import com.jpa.dao.EntityManagerHelper;
import com.jpa.dao.IArticulosDAO;
import com.jpa.jpa.Articulos;

public class GestionArticulos implements IGestionArticulos {

	private IArticulosDAO articulosDao;

	public GestionArticulos() {
		articulosDao = new ArticulosDAO();
	} 
	
	@Override
	public boolean alta(Articulos articulos) {
		boolean altaCorrecta = true;
		EntityManagerHelper.beginTransaction();
		try {
			articulosDao.alta(articulos);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			altaCorrecta = false;
			if (EntityManagerHelper.getEntityManager().getTransaction().isActive()) {
				EntityManagerHelper.rollback();
			}
		}
		EntityManagerHelper.closeEntityManager();
		return altaCorrecta;
	}
	@Override
	public boolean baja(Articulos articulos) {
		boolean bajaCorrecta = true;
		EntityManagerHelper.beginTransaction();
		try {
			articulosDao.baja(articulos);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			bajaCorrecta = false;
			if (EntityManagerHelper.getEntityManager().getTransaction().isActive()) {
				EntityManagerHelper.rollback();
			}
		}
		EntityManagerHelper.closeEntityManager();
		return bajaCorrecta;
	}
	
	@Override
	public boolean modificacion(Articulos articulos) {
		boolean modificacionCorrecta = true;
		EntityManagerHelper.beginTransaction();
		try {
			articulosDao.modificacion(articulos);
			EntityManagerHelper.commit();;
		} catch (Exception e) {
			modificacionCorrecta = false;
			if (EntityManagerHelper.getEntityManager().getTransaction().isActive()) {
				EntityManagerHelper.rollback();
			}
		}
		EntityManagerHelper.closeEntityManager();
		return modificacionCorrecta;
	}
	@Override
	public Articulos consultarPorCodigo(Long codigoArticulo) {
		Articulos articulo =  articulosDao.consultarPorCodigo(codigoArticulo); 
		EntityManagerHelper.closeEntityManager();
		return articulo;
	}

	@Override
	public List<Articulos> consultarTodo() {
		List<Articulos> lista = articulosDao.consultarTodo();
		EntityManagerHelper.closeEntityManager();
		return lista;
	}

}
	

