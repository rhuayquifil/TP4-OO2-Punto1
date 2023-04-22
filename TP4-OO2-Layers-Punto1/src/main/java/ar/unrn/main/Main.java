package ar.unrn.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import ar.unrn.domain.model.DefaultRegistroParticipante;
import ar.unrn.domain.portsout.DomainException;
import ar.unrn.infrastructure.data.BaseDeDatosPropiedades;
import ar.unrn.infrastructure.data.EnBaseAlmacenamientoDatos;
import ar.unrn.infrastructure.ui.AgregarParticipanteFrame;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarParticipanteFrame frame = new AgregarParticipanteFrame(
							new DefaultRegistroParticipante(new EnBaseAlmacenamientoDatos(new BaseDeDatosPropiedades(
									"jdbc:mysql://127.0.0.1/registro_tp4_oo2", "root", ""))));

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					;
				} catch (DomainException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}
}
