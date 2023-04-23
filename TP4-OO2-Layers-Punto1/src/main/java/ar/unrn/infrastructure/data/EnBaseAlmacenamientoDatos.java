package ar.unrn.infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.unrn.domain.portsout.AlmacenamientoDatos;
import ar.unrn.domain.portsout.Propiedades;
import ar.unrn.domain.portsout.DomainException;

public class EnBaseAlmacenamientoDatos implements AlmacenamientoDatos {

	private Propiedades properties;

	public EnBaseAlmacenamientoDatos(Propiedades properties) {
		super();
		this.properties = properties;
	}

	public void sumarParticipante(String nombre, String telefono, String region) throws DomainException {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(
						"INSERT INTO participante (nombre, telefono, region)" + "VALUES (?, ?, ?);")) {

			guardarRegistro(nombre, telefono, region, state);

		} catch (SQLException | NumberFormatException e) {
			throw new DomainException("error al prosesar consulta");
		}
	}

	private void guardarRegistro(String nombre, String telefono, String region, java.sql.PreparedStatement state)
			throws SQLException, DomainException {
		state.setString(1, nombre);
		state.setString(2, telefono);
		state.setString(3, region);

		int cantidad = state.executeUpdate();

		if (cantidad <= 0) {
			throw new DomainException("error al ingresar Registro");
		}
	}
}