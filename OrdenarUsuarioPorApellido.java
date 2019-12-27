import java.util.Comparator;

public class OrdenarUsuarioPorApellido implements Comparator<Usuario> {
	@Override
	public int compare(Usuario u1, Usuario u2) {
		if (!u1.apellido1.equals(u2.apellido1)) {
			return u1.apellido1.compareTo(u2.apellido1);
		} else if (!u1.apellido2.equals(u2.apellido2)) {
			return u1.apellido2.compareTo(u2.apellido2);
		} else if (!u1.nombre.equals(u2.nombre)) {
			return u1.nombre.compareTo(u2.nombre);
		} else {
			return u1.compareTo(u2);
		}
	}
}
