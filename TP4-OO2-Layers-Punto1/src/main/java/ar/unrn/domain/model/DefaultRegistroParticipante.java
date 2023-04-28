package ar.unrn.domain.model;

import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.RegistroParticipante;
import ar.unrn.domain.portsout.GuardarDatos;
import ar.unrn.domain.portsout.InfrastructureExceptions;

public class DefaultRegistroParticipante implements RegistroParticipante {

	private GuardarDatos guardarDatos;

	public DefaultRegistroParticipante(GuardarDatos guardarDatos) {
		this.guardarDatos = guardarDatos;
	}

	@Override
	public void sumarParticipante(String nombre, String telefono, String region) throws DomainException {
		if (nombre.isEmpty()) {
			throw new DomainException("Debe cargar un nombre");
		}
		if (telefono.isEmpty()) {
			throw new DomainException("Debe cargar un telefono");
		}
		if (!validarTelefono(telefono)) {
			throw new DomainException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		}
		if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
			throw new DomainException("Region desconocida. Las conocidas son: China, US, Europa");
		}

		try {
			this.guardarDatos.sumarParticipante(nombre, telefono, region);
		} catch (InfrastructureExceptions e) {
			throw new DomainException(e.getMessage());
		}
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}
}
