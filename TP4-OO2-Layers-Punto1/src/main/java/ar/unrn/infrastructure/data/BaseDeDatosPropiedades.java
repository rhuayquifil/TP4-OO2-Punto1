package ar.unrn.infrastructure.data;

import java.util.Objects;
import java.util.Properties;

import ar.unrn.domain.portsout.DomainException;
import ar.unrn.domain.portsout.Propiedades;

public class BaseDeDatosPropiedades implements Propiedades {

	private Properties propiedades;

	public BaseDeDatosPropiedades(String urlBaseDeDatos, String usuario, String contrasena) throws DomainException {

		if (Objects.isNull(urlBaseDeDatos)) {
			throw new DomainException("Datos nulos urlBaseDeDatos BaseDeDatosPropiedades");
		}

		if (Objects.isNull(usuario)) {
			throw new DomainException("Datos nulos usuario BaseDeDatosPropiedades");
		}

		if (Objects.isNull(contrasena)) {
			throw new DomainException("Datos nulos contrasena BaseDeDatosPropiedades");
		}

		propiedades = new Properties();

		propiedades.put("url", urlBaseDeDatos);
		propiedades.put("usuario", usuario);
		propiedades.put("contrasena", contrasena);
	}

	public String get(String key) {
		return propiedades.getProperty(key);
	}
}
