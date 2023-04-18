package ar.unrn.main;

import java.awt.EventQueue;
import java.sql.SQLException;

import ar.unrn.domain.model.DataBaseConexion;
import ar.unrn.domain.model.EnBaseAlmacenamiento;
import ar.unrn.infrastructure.ui.AgregarParticipanteFrame;

public class Main {
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarParticipanteFrame frame = new AgregarParticipanteFrame(new EnBaseAlmacenamiento(
							new DataBaseConexion("jdbc:mysql://127.0.0.1/registro_tp4_oo2", "root", "")));

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					;
				} catch (Exception e) {
					System.out.println(e);

				}
			}
		});
	}
}