import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class AñadirMarcaAntiguaArrayList implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Date fecha = AñadirMarcaAntigua.calendario.getDate();
		int hora = 0;
		int minutos = 0;
		int segundos = 0;

		if (null == AñadirMarcaAntigua.usuario_Option.getSelectedItem()) {
			JOptionPane.showMessageDialog(null, "Tiene que informar el usuario. ", "Añadir marca pasada", 1);
		} else if (fecha.after(new Date()) || ((new Date().getDay() == fecha.getDay())
				&& (new Date().getMonth() == fecha.getMonth()) && (new Date().getYear() == fecha.getYear()))) {
			JOptionPane.showMessageDialog(null, "La fecha no puede ser el dia de hoy o posterior. ",
					"Añadir marca pasada", 1);
		} else {
			if ((AñadirMarcaAntigua.hora_Field.getText().isEmpty()
					|| AñadirMarcaAntigua.hora_Field.getText().equals(null))
					|| (AñadirMarcaAntigua.minutos_Field.getText().isEmpty()
							|| AñadirMarcaAntigua.minutos_Field.getText().equals(null))
					|| (AñadirMarcaAntigua.segundos_Field.getText().isEmpty()
							|| AñadirMarcaAntigua.segundos_Field.getText().equals(null))) {
				JOptionPane.showMessageDialog(null, "Tiene que informar los campos hora, minutos y segundos. ",
						"Añadir marca pasada", 1);
			} else if ((!isNumeric(AñadirMarcaAntigua.hora_Field.getText())
					|| AñadirMarcaAntigua.hora_Field.getText().equals(null))
					|| (!isNumeric(AñadirMarcaAntigua.minutos_Field.getText())
							|| AñadirMarcaAntigua.minutos_Field.getText().equals(null))
					|| (!isNumeric(AñadirMarcaAntigua.segundos_Field.getText())
							|| AñadirMarcaAntigua.segundos_Field.getText().equals(null))) {
				JOptionPane.showMessageDialog(null,
						"Tiene que insertar los campos hora, minutos y segundos con un formato numérico válido. ",
						"Añadir marca pasada", 1);
			} else if (isNumeric(AñadirMarcaAntigua.hora_Field.getText())
					&& isNumeric(AñadirMarcaAntigua.minutos_Field.getText())
					&& isNumeric(AñadirMarcaAntigua.segundos_Field.getText())) {
				hora = Integer.parseInt(AñadirMarcaAntigua.hora_Field.getText());
				minutos = Integer.parseInt(AñadirMarcaAntigua.minutos_Field.getText());
				segundos = Integer.parseInt(AñadirMarcaAntigua.segundos_Field.getText());

				if ((hora > 24 || hora < 0) || (minutos > 59 || minutos < 0) || (segundos > 59 || segundos < 0)) {
					JOptionPane.showMessageDialog(null,
							"Tiene que insertar los campos hora, minutos y segundos con un formato numérico válido. ",
							"Añadir marca pasada", 1);
				} else {
					Marca marca = new Marca((Usuario) AñadirMarcaAntigua.usuario_Option.getSelectedItem(), fecha,
							AñadirMarcaAntigua.tipo_Option.getSelectedItem().toString());
					Programa.marcas.add(marca);

					AñadirMarcaAntigua.panel.hide();

					JOptionPane.showMessageDialog(null, "Marca añadida correctamente. ", "Añadir marca pasada", 1);
				}
			}

		}
	}

	public static boolean isNumeric(String cadena) {
		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

}
