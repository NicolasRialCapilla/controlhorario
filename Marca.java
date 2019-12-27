import java.util.Date;

public class Marca implements Comparable<Marca> {

	static int id_Global;
	int id;
	Usuario usuario;
	Date fecha;
	String tipo;
	boolean modificada;

	public Marca(Usuario usuario_Aux, Date fecha_Aux, String tipo_Aux) {
		usuario = usuario_Aux;
		fecha = fecha_Aux;
		tipo = tipo_Aux;
		modificada = false;
		id_Global = id_Global + 1;
		id = id_Global;
	}

	@SuppressWarnings("deprecation")
	public void cambiarHora(int horaAux, int munitosAux, int segundosAux) {
		fecha.setHours(horaAux);
		fecha.setMinutes(munitosAux);
		fecha.setSeconds(segundosAux);

		modificada = true;
	}

	@Override
	public boolean equals(Object marca) {
		Marca marca_Aux = (Marca) marca;

		if (id == marca_Aux.id) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return tipo + " - " + Programa.formatohora.format(fecha);
	}

	public String toStringMarca() {
		return "Tipo: " + tipo + ". Modificada: " + modificada + ". Fecha: " + Programa.formatofecha.format(fecha)
				+ ". Hora: " + Programa.formatohora.format(fecha) + ". ";
	}

	@Override
	public int compareTo(Marca marca_Aux) {
		return fecha.compareTo(marca_Aux.fecha);
	}

}
