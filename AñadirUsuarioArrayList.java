import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AñadirUsuarioArrayList implements ActionListener {
	
	boolean mascara = false;

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if ((AñadirUsuario.dni_Field.getText().isEmpty() || AñadirUsuario.dni_Field.getText().equals(null))
				|| (AñadirUsuario.nombre_Field.getText().isEmpty() || AñadirUsuario.nombre_Field.getText().equals(null))
				|| (AñadirUsuario.apellido1_Field.getText().isEmpty()
						|| AñadirUsuario.apellido1_Field.getText().equals(null))
				|| (AñadirUsuario.apellido2_Field.getText().isEmpty()
						|| AñadirUsuario.apellido2_Field.getText().equals(null))) {
			JOptionPane.showMessageDialog(null, "Tiene que informar los campos DNI, nombre y apellidos. ",
					"Añadir usuario", 1);
		} else {
			/*
			if (AñadirUsuario.dni_Field.getText().length() == 9) {
				if (Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(0))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(1))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(2))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(3))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(4))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(5))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(6))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(7))
						&& Character.isAlphabetic(AñadirUsuario.dni_Field.getText().charAt(8))) {
					mascara = true;
				}
			} else if (AñadirUsuario.dni_Field.getText().length() == 10) {
				if (Character.isAlphabetic(AñadirUsuario.dni_Field.getText().charAt(0))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(1))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(2))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(3))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(4))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(5))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(6))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(7))
						&& Character.isDigit(AñadirUsuario.dni_Field.getText().charAt(8))
						&& Character.isAlphabetic(AñadirUsuario.dni_Field.getText().charAt(9))) {
					mascara = true;
				}
			}

			if (mascara) {
			*/
				Usuario usuario = new Usuario(AñadirUsuario.dni_Field.getText().toUpperCase(),
						AñadirUsuario.nombre_Field.getText(), AñadirUsuario.apellido1_Field.getText(),
						AñadirUsuario.apellido2_Field.getText());

				if (Programa.usuarios.contains(usuario)) {
					JOptionPane.showMessageDialog(null, "Este usuario ya existe en la base de datos. ",
							"Añadir usuario ", 0);
				} else {
					Programa.usuarios.add(usuario);
					Programa.usuario_Option.addItem(usuario);
					AñadirMarcaAntigua.usuario_Option.addItem(usuario);

					AñadirUsuario.panel.hide();

					JOptionPane.showMessageDialog(null, "Usuario creado correctamente. ", "Añadir usuario ", 1);
				}
				/*
			} else {
				JOptionPane.showMessageDialog(null, "El DNI requiere de formato NNNNNNNNL o LNNNNNNNNL. ",
						"Añadir usuario", 1);
			}
			*/
				
		}

	}

}
