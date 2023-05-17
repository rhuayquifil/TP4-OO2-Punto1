package ar.unrn.infrastructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.unrn.domain.portsout.GuardarDatos;
import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.domain.portsout.Propiedades;

public class EnBaseGuardarDatos implements GuardarDatos {

	private Propiedades properties;

	public EnBaseGuardarDatos(Propiedades properties) {
		super();
		this.properties = properties;
	}

	public void sumarParticipante(String nombre, String telefono, String region, String email)
			throws InfrastructureExceptions {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(
						"INSERT INTO participante (nombre, telefono, region, email)" + "VALUES (?, ?, ?, ?);")) {

			guardarRegistro(nombre, telefono, region, email, state);

		} catch (SQLException | NumberFormatException e) {
			throw new InfrastructureExceptions("error al prosesar consulta");
		}
	}

	private void guardarRegistro(String nombre, String telefono, String region, String email,
			java.sql.PreparedStatement state) throws SQLException, InfrastructureExceptions {
		state.setString(1, nombre);
		state.setString(2, telefono);
		state.setString(3, region);
		state.setString(4, email);

		int cantidad = state.executeUpdate();

		if (cantidad <= 0) {
			throw new InfrastructureExceptions("error al ingresar Registro");
		}
	}
}