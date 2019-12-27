import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class A�adirMarcaAntiguaArrayList implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Date fecha = A�adirMarcaAntigua.calendario.getDate();
		int hora = 0;
		int minutos = 0;
		int segundos = 0;

		if (null == A�adirMarcaAntigua.usuario_Option.getSelectedItem()) {
			JOptionPane.showMessageDialog(null, "Tiene que informar el usuario. ", "A�adir marca pasada", 1);
		} else if (fecha.after(new Date()) || ((new Date().getDay() == fecha.getDay())
				&& (new Date().getMonth() == fecha.getMonth()) && (new Date().getYear() == fecha.getYear()))) {
			JOptionPane.showMessageDialog(null, "La fecha no puede ser el dia de hoy o posterior. ",
					"A�adir marca pasada", 1);
		} else {
			if ((A�adirMarcaAntigua.hora_Field.getText().isEmpty()
					|| A�adirMarcaAntigua.hora_Field.getText().equals(null))
					|| (A�adirMarcaAntigua.minutos_Field.getText().isEmpty()
							|| A�adirMarcaAntigua.minutos_Field.getText().equals(null))
					|| (A�adirMarcaAntigua.segundos_Field.getText().isEmpty()
							|| A�adirMarcaAntigua.segundos_Field.getText().equals(null))) {
				JOptionPane.showMessageDialog(null, "Tiene que informar los campos hora, minutos y segundos. ",
						"A�adir marca pasada", 1);
			} else if ((!isNumeric(A�adirMarcaAntigua.hora_Field.getText())
					|| A�adirMarcaAntigua.hora_Field.getText().equals(null))
					|| (!isNumeric(A�adirMarcaAntigua.minutos_Field.getText())
							|| A�adirMarcaAntigua.minutos_Field.getText().equals(null))
					|| (!isNumeric(A�adirMarcaAntigua.segundos_Field.getText())
							|| A�adirMarcaAntigua.segundos_Field.getText().equals(null))) {
				JOptionPane.showMessageDialog(null,
						"Tiene que insertar los campos hora, minutos y segundos con un formato num�rico v�lido. ",
						"A�adir marca pasada", 1);
			} else if (isNumeric(A�adirMarcaAntigua.hora_Field.getText())
					&& isNumeric(A�adirMarcaAntigua.minutos_Field.getText())
					&& isNumeric(A�adirMarcaAntigua.segundos_Field.getText())) {
				hora = Integer.parseInt(A�adirMarcaAntigua.hora_Field.getText());
				minutos = Integer.parseInt(A�adirMarcaAntigua.minutos_Field.getText());
				segundos = Integer.parseInt(A�adirMarcaAntigua.segundos_Field.getText());

				if ((hora > 24 || hora < 0) || (minutos > 59 || minutos < 0) || (segundos > 59 || segundos < 0)) {
					JOptionPane.showMessageDialog(null,
							"Tiene que insertar los campos hora, minutos y segundos con un formato num�rico v�lido. ",
							"A�adir marca pasada", 1);
				} else {
					Marca marca = new Marca((Usuario) A�adirMarcaAntigua.usuario_Option.getSelectedItem(), fecha,
							A�adirMarcaAntigua.tipo_Option.getSelectedItem().toString());
					Programa.marcas.add(marca);

					A�adirMarcaAntigua.panel.hide();

					JOptionPane.showMessageDialog(null, "Marca a�adida correctamente. ", "A�adir marca pasada", 1);
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
