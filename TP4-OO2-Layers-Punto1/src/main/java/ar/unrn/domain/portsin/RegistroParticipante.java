package ar.unrn.domain.portsin;

public interface RegistroParticipante {

	void sumarParticipante(String nombre, String telefono, String region, String email) throws DomainException;
}
