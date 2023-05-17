package ar.unrn.domain.model;

import java.util.List;
import java.util.Objects;

import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.RegistroParticipante;
import ar.unrn.domain.portsout.GuardarDatos;
import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.Observer;

public class DefaultRegistroParticipante extends Observable implements RegistroParticipante {

	private GuardarDatos guardarDatos;

	public DefaultRegistroParticipante(GuardarDatos guardarDatos, List<Observer> subscriptores) {
		this.guardarDatos = guardarDatos;

		for (Observer observer : subscriptores) {
			this.subscribir(observer);
		}
	}

	@Override
	public void sumarParticipante(String nombre, String telefono, String region, String email) throws DomainException {

		Objects.requireNonNull(nombre, "Nombre no puede ser nulo");
		if (nombre.isEmpty()) {
			throw new DomainException("Debe cargar un nombre");
		}

		Objects.requireNonNull(telefono, "Telefono no puede ser nulo");
		if (telefono.isEmpty()) {
			throw new DomainException("Debe cargar un telefono");
		}

		if (!validarTelefono(telefono)) {
			throw new DomainException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}

		Objects.requireNonNull(region, "Region no puede ser nulo");
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
			throw new DomainException("Region desconocida. Las conocidas son: China, US, Europa");
		}

		Objects.requireNonNull(email, "El Email no puede ser nulo");
		if (!validarEmail(email)) {
			throw new DomainException("Debe cargar un email");
		}

		try {
			this.guardarDatos.sumarParticipante(nombre, telefono, region);

			// ACA TENES QUE NOTIFICAR EL CAMBIO A LOS SUBS

			this.notificar(nombre, telefono, region, email);
		} catch (InfrastructureExceptions e) {
			throw new DomainException(e.getMessage());
		}
	}

	private boolean validarEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
}
