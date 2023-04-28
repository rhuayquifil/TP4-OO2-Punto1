package ar.unrn.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import ar.unrn.domain.model.DefaultRegistroParticipante;
import ar.unrn.domain.portsout.InfrastructureExceptions;
import ar.unrn.infrastructure.data.BaseDeDatosPropiedades;
import ar.unrn.infrastructure.data.EnBaseGuardarDatos;
import ar.unrn.infrastructure.ui.AgregarParticipanteFrame;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarParticipanteFrame frame = new AgregarParticipanteFrame(
							new DefaultRegistroParticipante(new EnBaseGuardarDatos(
									new BaseDeDatosPropiedades("jdbc:mysql://127.0.0.1/base_tp4_punto1", "root", ""))));

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					;
				} catch (InfrastructureExceptions e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}
}
