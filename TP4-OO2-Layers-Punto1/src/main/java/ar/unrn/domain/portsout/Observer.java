package ar.unrn.domain.portsout;

public interface Observer {

	void actualizar(String nombre, String telefono, String region, String emailDestinatario)
			throws InfrastructureExceptions;
}
