package ar.unrn.domain.model;

import java.util.Objects;
import java.util.Properties;

import ar.unrn.domain.portsin.Conexion;

public class DataBaseConexion implements Conexion {

	private Properties propiedades;

	public DataBaseConexion(String urlBaseDeDatos, String usuario, String contrasena) throws AlmacenamientoExceptions {

		if (Objects.isNull(urlBaseDeDatos)) {
			throw new AlmacenamientoExceptions("Datos nulos");
		}

		if (Objects.isNull(usuario)) {
			throw new AlmacenamientoExceptions("Datos nulos");
		}

		if (Objects.isNull(contrasena)) {
			throw new AlmacenamientoExceptions("Datos nulos");
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
