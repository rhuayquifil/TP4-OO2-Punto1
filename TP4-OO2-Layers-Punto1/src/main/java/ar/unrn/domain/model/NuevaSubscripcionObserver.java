package ar.unrn.domain.model;

import java.util.HashMap;

import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.Notificacion;
import ar.unrn.domain.portsout.Observer;

public class NuevaSubscripcionObserver implements Observer {

	private Notificacion notificacion;

	public NuevaSubscripcionObserver(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	@Override
	public void actualizar(HashMap<String, String> listaDatos) throws InfrastructureExceptions {

		this.notificacion.enviarCorreo("TP6-OO2-Observer@unrn.com.ar", listaDatos.get("email"), "Inscripcion Existosa!",
				"Nombre: " + listaDatos.get("nombre") + "\n" + "Telefono: " + listaDatos.get("telefono") + "\n"
						+ "Region: " + listaDatos.get("region") + "\n" + "Email Registrado: : "
						+ listaDatos.get("email") + "\n");

		System.out.println("Inscripcion Existosa!\n" + "Nombre: " + listaDatos.get("nombre") + "\n" + "Telefono: "
				+ listaDatos.get("telefono") + "\n" + "Region: " + listaDatos.get("region") + "\n"
				+ "Email Registrado: : " + listaDatos.get("email") + "\n");
	}

}
