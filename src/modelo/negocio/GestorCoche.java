package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {

	private DaoCoche daoCoche = new DaoCocheMySQL();
	List<Coche> listaCoches = listarCoches();

	public int alta(Coche c) {

		for (Coche coche : listaCoches) {
			if (!(coche.getMatricula().equals(c.getMatricula())) && c.getMatricula().length() >= 7
					&& c.getKilometros() >= 0) {
				boolean alta = daoCoche.alta(c);
				if (alta) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 2;
			}
		}
		return c.getId();
	}

	public boolean baja(int id) {
		boolean baja = daoCoche.eliminar(id);
		return baja;
	}

	public int modificar(Coche c) {
		if (c.getMatricula().length() >= 7 && c.getKilometros() >= 0) {
			boolean modificado = daoCoche.modificar(c);
			if (modificado) {
				return 0;
			} else {
				return 1;
			}
		}
		return 2;
	}

	public List<Coche> listarCoches() {
		List<Coche> listaCoches = daoCoche.listar();
		return listaCoches;
	}

	public Coche buscarPorId(int id) {
		Coche coche = daoCoche.buscarPorId(id);
		return coche;
	}

	public Coche buscarPorMatricula(String matricula) {
		Coche coche = daoCoche.buscarPorMatricula(matricula);
		return coche;
	}

	public List<Coche> buscarPorMarca(String marca) {
		List<Coche> listaCoches = daoCoche.buscarPorMarca(marca);
		return listaCoches;
	}

	public List<Coche> buscarPorModelo(String modelo) {
		List<Coche> listaCoches = daoCoche.buscarPorModelo(modelo);
		return listaCoches;
	}
}
