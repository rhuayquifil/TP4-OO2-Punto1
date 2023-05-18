package ar.unrn.domain.portsout;

import java.util.HashMap;

public interface Observer {

	void actualizar(HashMap<String, String> listaDatos) throws InfrastructureExceptions;
}
