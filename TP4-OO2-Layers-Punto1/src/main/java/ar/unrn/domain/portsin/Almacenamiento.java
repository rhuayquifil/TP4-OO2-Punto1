package ar.unrn.domain.portsin;

import ar.unrn.domain.model.AlmacenamientoExceptions;

public interface Almacenamiento {

	void sumarParticipante(String nombre, String telefono, String region) throws AlmacenamientoExceptions;

}
