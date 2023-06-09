package ar.unrn.infrastructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.domain.portsin.DomainException;
import ar.unrn.domain.portsin.RegistroParticipante;

public class AgregarParticipanteFrame extends JFrame {
	private RegistroParticipante registroParticipante;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private JTextField email;

	public AgregarParticipanteFrame(RegistroParticipante defaultRegistroParticipante) {
		this.registroParticipante = defaultRegistroParticipante;
		setupUIComponents();
	}

	private void setupUIComponents() {
		setTitle("Add Participant");
		setSize(522, 110);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.nombre = new JTextField(10);
		this.telefono = new JTextField(10);
		this.region = new JTextField(10);
		this.email = new JTextField(20);
		this.nombre.setText("");
		this.telefono.setText("");
		this.email.setText("");
		this.region.setText("China");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		contentPane.add(new JLabel("Email: "));
		contentPane.add(email);

		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registroParticipante.sumarParticipante(nombre.getText(), telefono.getText(), region.getText(),
							email.getText());
					JOptionPane.showMessageDialog(null, "Participante Cargado Exitosamente");
				} catch (DomainException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}
}