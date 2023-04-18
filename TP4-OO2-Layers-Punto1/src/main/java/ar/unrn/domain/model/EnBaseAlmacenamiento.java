package ar.unrn.domain.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.unrn.domain.portsin.Almacenamiento;
import ar.unrn.domain.portsin.Conexion;

public class EnBaseAlmacenamiento implements Almacenamiento {

	private Conexion properties;

	public EnBaseAlmacenamiento(Conexion properties) {
		super();
		this.properties = properties;
	}

	public void sumarParticipante(String nombre, String telefono, String region) throws AlmacenamientoExceptions {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(
						"INSERT INTO participante (nombre, telefono, region)" + "VALUES (?, ?, ?);")) {

			if (nombre.isEmpty()) {
				throw new AlmacenamientoExceptions("Debe cargar un nombre");
			}
			if (telefono.isEmpty()) {
				throw new AlmacenamientoExceptions("Debe cargar un telefono");
			}
			if (!validarTelefono(telefono)) {
				throw new AlmacenamientoExceptions("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
			}
			if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
				throw new AlmacenamientoExceptions("Region desconocida. Las conocidas son: China, US, Europa");
			}

			state.setString(1, nombre);
			state.setString(2, telefono);
			state.setString(3, region);

			int cantidad = state.executeUpdate();

			if (cantidad <= 0) {
				throw new AlmacenamientoExceptions("error al ingresar Registro");
			}

		} catch (SQLException | NumberFormatException e) {
			throw new AlmacenamientoExceptions("error al prosesar consulta");
		}
	}

	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

//			if (nombre.getText().equals("")) {
//				JOptionPane.showMessageDialog(this, "Debe cargar un nombre");
//				return;
//			}
//			if (telefono.getText().equals("")) {
//				JOptionPane.showMessageDialog(this, "Debe cargar un telefono");
//				return;
//			}
//			if (!validarTelefono(telefono.getText())) {
//				JOptionPane.showMessageDialog(this, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
//				return;
//			}
//			if (!region.getText().equals("China") && !region.getText().equals("US") && !region.getText().equals("Europa")) {
//				JOptionPane.showMessageDialog(this, "Region desconocida. Las conocidas son: China, US, Europa");
//				return;
//			}
//			PreparedStatement st = dbConn
//					.prepareStatement("insert into participantes(nombre, telefono, region) values(?,?,?)");
//			try {
//				st.setString(1, nombre.getText());
//				st.setString(2, telefono.getText());
//				st.setString(3, region.getText());
//				st.executeUpdate();
//			} finally {
//				st.close();
//			}
//			dispose();
//		}
//
//		private boolean validarTelefono(String telefono) {
//			String regex = "\\d{4}-\\d{6}";
//			return telefono.matches(regex);
//		}
//	}

}
