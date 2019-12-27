import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

public class A�adirMarcaArrayList implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Date fecha = new Date();

		if (null == Programa.usuario_Option.getSelectedItem()) {
			JOptionPane.showMessageDialog(null, "Tiene que informar el usuario. ", "A�adir marca", 1);
		} else {
			Marca marca = new Marca((Usuario) Programa.usuario_Option.getSelectedItem(), fecha,
					Programa.tipo_Option.getSelectedItem().toString());

			if ("Entrada".equals(Programa.tipo_Option.getSelectedItem().toString())) {
				if (Programa.usuarios
						.get(Programa.usuarios.indexOf(Programa.usuario_Option.getSelectedItem())).trabajando == true) {
					JOptionPane.showMessageDialog(null, "El usuario ya est� trabajando. ", "A�adir marca", 0);
				} else {
					Programa.marcas.add(marca);
					Programa.marcas_Jornada.add(marca);
					Programa.usuarios.get(Programa.usuarios.indexOf(Programa.usuario_Option.getSelectedItem()))
					.entrar();
					Programa.marcas_Option.setListData(Programa.marcas_Jornada.toArray());
					JOptionPane.showMessageDialog(null, "Marca a�adida correctamente. ", "A�adir marca", 1);
				}
			} else {
				if (Programa.usuarios
						.get(Programa.usuarios.indexOf(Programa.usuario_Option.getSelectedItem())).trabajando == true) {
					Programa.marcas.add(marca);
					Programa.marcas_Jornada.add(marca);
					Programa.usuarios.get(Programa.usuarios.indexOf(Programa.usuario_Option.getSelectedItem())).salir();
					Programa.marcas_Option.setListData(Programa.marcas_Jornada.toArray());

					JOptionPane.showMessageDialog(null, "Marca a�adida correctamente. ", "A�adir marca", 1);
				} else {
					JOptionPane.showMessageDialog(null, "El usuario no est� trabajando. ", "A�adir marca", 0);
				}
			}
		}

	}

}
