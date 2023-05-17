package ar.unrn.domain.portsout;

public interface GuardarDatos {

	void sumarParticipante(String nombre, String telefono, String region, String email) throws InfrastructureExceptions;

}
