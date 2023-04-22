package ar.unrn.domain.portsin;

import ar.unrn.domain.portsout.DomainException;

public interface RegistroParticipante {

	void sumarParticipante(String nombre, String telefono, String region) throws DomainException;
}
