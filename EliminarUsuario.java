import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EliminarUsuario implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (null == MostrarUsuarios.usuarios_Option.getSelectedValue()) {
			JOptionPane.showMessageDialog(null, "Tiene que seleccionar un usuario. ", "Eliminar usuario", 0);
		} else if (MostrarUsuarios.usuarios_Option.getSelectedValuesList().size() > 1) {
			JOptionPane.showMessageDialog(null, "Tiene que seleccionar sólo un usuario. ", "Eliminar usuario", 0);
		} else {
			int n = JOptionPane.showConfirmDialog(null,
					"Eliminar usuario: " + MostrarUsuarios.usuarios_Option.getSelectedValue().toString() + ". ",
					"Eliminar usuario ", JOptionPane.YES_OPTION);

			if (n == JOptionPane.YES_OPTION) {
				Programa.usuarios.remove(MostrarUsuarios.usuarios_Option.getSelectedValue());
				MostrarUsuarios.usuarios_Option.setListData(Programa.usuarios.toArray());
				Programa.usuario_Option.removeItem(MostrarUsuarios.usuarios_Option.getSelectedValue());

				Programa.usuariosEliminados.add((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue());

				JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente. ", "Eliminar usuario ", 1);
			} else {
				JOptionPane.showMessageDialog(null, "No ha eliminado el usuario. ", "Eliminar usuario ", 1);
			}
		}
	}

}
