package ar.unrn.domain.portsout;

public interface Notificacion {

	void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje) throws InfrastructureExceptions;
}
