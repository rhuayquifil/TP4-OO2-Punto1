package ar.unrn.infrastructure.data;

import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.Notificacion;
import ar.unrn.domain.portsout.Observer;

public class MailNotificacionObserver implements Notificacion, Observer {

	// TENES QUE RESOLVER COMO ENVIAR MAIL

	@Override
	public void actualizar(String nombre, String telefono, String region, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarCorreo(String correoRemitente, String correoDestinatario, String contenidoSujeto,
			String contenidoMensaje) throws InfrastructureExceptions {
		// TODO Auto-generated method stub

	}

}
