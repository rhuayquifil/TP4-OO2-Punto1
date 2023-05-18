package ar.unrn.domain.portsout;

import java.util.HashMap;

public interface GuardarDatos {

	void sumarParticipante(HashMap<String, String> listaDatos) throws InfrastructureExceptions;

}
