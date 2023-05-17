package ar.unrn.domain.model;

import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.Notificacion;
import ar.unrn.domain.portsout.Observer;

public class NuevaSubscripcionObserver implements Observer {

	private Notificacion notificacion;

	public NuevaSubscripcionObserver(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	@Override
	public void actualizar(String nombre, String telefono, String region, String emailDestinatario)
			throws InfrastructureExceptions {
		this.notificacion.enviarCorreo("TP6-OO2-Observer@unrn.com.ar", emailDestinatario, "Inscripcion Existosa!",
				"Nombre: " + nombre + "\n" + "Telefono: " + telefono + "\n" + "Region: " + region + "\n"
						+ "Email Registrado: : " + emailDestinatario + "\n");

		System.out.println("Inscripcion Existosa!\n" + "Nombre: " + nombre + "\n" + "Telefono: " + telefono + "\n"
				+ "Region: " + region + "\n" + "Email Registrado: : " + emailDestinatario + "\n");
	}

}
