
public class Usuario implements Comparable<Usuario> {

	static int id_Global;
	int id;
	String dni;
	String nombre;
	String apellido1;
	String apellido2;
	boolean trabajando;

	public Usuario(String dni_Aux, String nombre_Aux, String apellido1_Aux, String apellido2_Aux) {
		dni = dni_Aux;
		nombre = nombre_Aux;
		apellido1 = apellido1_Aux;
		apellido2 = apellido2_Aux;
		trabajando=false;
		id_Global = id_Global + 1;
		id = id_Global;
	}
	
	public void entrar() {
		trabajando=true;
	}
	
	public void salir() {
		trabajando=false;
	}

	@Override
	public boolean equals(Object usuario) {
		Usuario usuario_Aux = (Usuario) usuario;

		if (dni.equals(usuario_Aux.dni)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2 + " ";
	}
	
	public String toStringUsuario() {
		return "DNI: " + dni + ". Nombre: " + nombre + " " + apellido1 + " " + apellido2 + ". ";
	}

	@Override
	public int compareTo(Usuario usuario_Aux) {
		if (id < usuario_Aux.id) {
			return 1;
		} else if (id > usuario_Aux.id) {
			return -1;
		} else {
			return 0;
		}
	}

}
