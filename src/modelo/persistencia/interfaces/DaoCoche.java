package modelo.persistencia.interfaces;

import java.util.List;
import modelo.entidad.Coche;

public interface DaoCoche {

	boolean alta(Coche c);
	
	boolean eliminar(int id);
	
	boolean modificar(Coche c);
	
	List<Coche> listar();
	
	Coche buscarPorId(int id);
	Coche buscarPorMatricula(String matricula);
	List<Coche> buscarPorMarca(String marca);
	List<Coche> buscarPorModelo(String modelo);
}
