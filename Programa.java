
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Programa {

	static String nombreEmpresa = "";
	static JFrame panel;
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Usuario> usuariosEliminados = new ArrayList<Usuario>();
	static String[] tipos_Marcas = new String[] { "Entrada", "Salida" };
	static ArrayList<Marca> marcas = new ArrayList<Marca>();
	static ArrayList<Marca> marcas_Jornada = new ArrayList<Marca>();
	static JComboBox<Usuario> usuario_Option = new JComboBox(usuarios.toArray());
	static JComboBox<String> tipo_Option = new JComboBox<String>(tipos_Marcas);
	static JList marcas_Option = new JList();
	static Date fecha = new Date();
	static String fechaString;
	static String horaString;
	static JLabel qr;

	static SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {	
		// /*
		if (nombreEmpresa == null) {
			String aux = JOptionPane.showInputDialog(null, "Inserte el nombre de la empresa. ", "Bienvenido", 3);

			if (aux == null || aux == "" || aux.equals("")) {
				nombreEmpresa = "";
				JOptionPane.showMessageDialog(null, "No ha especificado un nombre. ", "Nombre de la empresa ", 1);
			} else {
				nombreEmpresa = aux;
				JOptionPane.showMessageDialog(null, "Nombre de la empresa: " + nombreEmpresa + ". ",
						"Nombre de la empresa ", 1);
			}
		}
		// */

		if (nombreEmpresa.equals("")) {
			panel = new JFrame("Control horario ");
		} else {
			panel = new JFrame("Control horario - " + nombreEmpresa);
		}
		
		panel.setSize(800, 400);
		panel.getContentPane().setBackground(new Color(245, 245, 245));
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setLayout(null);

		JMenuBar menubar = new JMenuBar();
		JMenu menuOpciones = new JMenu("Opciones");
		JMenuItem modificarEmpresa = new JMenuItem("Modificar nombre de empresa ");
		modificarEmpresa.addActionListener(new ModificarEmpresa());
		menuOpciones.add(modificarEmpresa);
		menubar.add(menuOpciones);
		JMenu menuUsuarios = new JMenu("Usuarios");
		JMenuItem añadirUsuario = new JMenuItem("Añadir usuario ");
		añadirUsuario.addActionListener(new AñadirUsuario());
		menuUsuarios.add(añadirUsuario);
		JMenuItem mostrarUsuarios = new JMenuItem("Listar usuarios ");
		mostrarUsuarios.addActionListener(new MostrarUsuarios());
		menuUsuarios.add(mostrarUsuarios);
		JMenuItem restaurarUsuario = new JMenuItem("Restaurar usuario eliminado ");
		restaurarUsuario.addActionListener(new RestaurarUsuario());
		menuUsuarios.add(restaurarUsuario);
		menubar.add(menuUsuarios);
		JMenu menuMarcas = new JMenu("Marcas");
		JMenuItem añadirMarcaAntigua = new JMenuItem("Añadir marca pasada");
		añadirMarcaAntigua.addActionListener(new AñadirMarcaAntigua());
		menuMarcas.add(añadirMarcaAntigua);
		JMenuItem modificarMarcaAntigua = new JMenuItem("Modificar marca pasada");
		modificarMarcaAntigua.addActionListener(new ModificarMarcaAntigua());
		menuMarcas.add(modificarMarcaAntigua);
		menubar.add(menuMarcas);
		
		
		JMenu menuExportar = new JMenu("Exportar");
		JMenuItem exportarPDF = new JMenuItem("PDF");
		exportarPDF.addActionListener(new ExportarPDF());
		menuExportar.add(exportarPDF);
		JMenuItem exportarExcel = new JMenuItem("EXCEL");
		exportarExcel.addActionListener(new ExportarExcel());
		menuExportar.add(exportarExcel);
		JMenuItem exportarAccess = new JMenuItem("ACCESS");
		exportarAccess.addActionListener(new ExportarAccess());
		menuExportar.add(exportarAccess);
		menubar.add(menuExportar);
		
		
		panel.setJMenuBar(menubar);

		JLabel usuario_Label = new JLabel("Usuario: ");
		usuario_Label.setSize(100, 30);
		usuario_Label.setLocation(20, 19);
		panel.getContentPane().add(usuario_Label);

		usuario_Option.setSize(250, 30);
		usuario_Option.setLocation(80, 20);
		usuario_Option.setFocusable(true);
		usuario_Option.setBackground(Color.WHITE);
		usuario_Option.addActionListener(new CambiarUsuario());
		panel.getContentPane().add(usuario_Option);

		JLabel marca_Label = new JLabel("Marca: ");
		marca_Label.setSize(100, 30);
		marca_Label.setLocation(20, 249);
		panel.getContentPane().add(marca_Label);

		tipo_Option.setSize(250, 30);
		tipo_Option.setLocation(80, 250);
		tipo_Option.setBackground(Color.WHITE);
		panel.getContentPane().add(tipo_Option);

		JLabel jornada_Label = new JLabel("Jornada: ");
		jornada_Label.setSize(100, 30);
		jornada_Label.setLocation(20, 70);
		panel.getContentPane().add(jornada_Label);

		marcas_Option.setSize(500, 150);
		marcas_Option.setLocation(80, 75);
		marcas_Option.setFocusable(true);
		marcas_Option.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
				BorderFactory.createLineBorder(Color.WHITE, 2)));
		panel.getContentPane().add(marcas_Option);

		JButton boton_Marca = new JButton("Añadir marca");
		boton_Marca.setSize(150, 30);
		boton_Marca.setLocation(130, 300);
		boton_Marca.addActionListener(new AñadirMarcaArrayList());
		panel.getContentPane().add(boton_Marca);

		JButton boton_Modificar = new JButton("Modificar marca");
		boton_Modificar.setSize(150, 30);
		boton_Modificar.setLocation(600, 90);
		boton_Modificar.addActionListener(new ModificarMarca());
		panel.getContentPane().add(boton_Modificar);

		formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		formatohora = new SimpleDateFormat("HH:mm:ss");
		fechaString = formatofecha.format(fecha);
		horaString = formatohora.format(fecha);

		JLabel dia = new JLabel(fechaString);
		panel.getContentPane().add(dia);
		dia.setFocusable(true);
		panel.getContentPane().getComponent(8).setLocation(700, 10);
		panel.getContentPane().getComponent(8).setSize(70, 50);

		JLabel hora = new JLabel(horaString.substring(0, 8));
		hora.setFocusable(true);
		panel.getContentPane().add(hora);
		panel.getContentPane().getComponent(9).setLocation(600, 10);
		panel.getContentPane().getComponent(9).setSize(80, 50);

		qrInicio();

		panel.setVisible(true);

		while (true) {
			Thread.sleep(1000);

			fechaString = formatofecha.format(new Date());
			dia.setText(fechaString.toString());

			horaString = formatohora.format(new Date());
			hora.setText(horaString.substring(0, 8));
		}

	}

	@SuppressWarnings("deprecation")
	public static void marcas(Usuario usuario) {
		marcas_Jornada.clear();

		for (int i = 0; i < marcas.size(); i++) {
			if ((marcas.get(i).usuario.equals(usuario)) && (marcas.get(i).fecha.getDate() == new Date().getDate())) {
				marcas_Jornada.add(marcas.get(i));
			}
		}

		Programa.marcas_Option.setListData(Programa.marcas_Jornada.toArray());
	}

	public static void qrInicio() throws FileNotFoundException, IOException {
		String informacion;
		

		if (nombreEmpresa.equals("")) {
			informacion= "Control horario. Desarrollado por: Nicolás Rial.";
		} else {
			informacion= "Control horario: " + nombreEmpresa +". Desarrollado por: Nicolás Rial.";
		}
		
		BitMatrix matrix;

		try {
			matrix = new QRCodeWriter().encode(informacion, BarcodeFormat.QR_CODE, 150, 150);
		} catch (WriterException e) {
			e.printStackTrace(System.err);
			return;
		}

		BufferedImage image = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < 150; y++) {
			for (int x = 0; x < 150; x++) {
				int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
				image.setRGB(x, y, (grayValue == 0 ? 0 : 0xF5F5F5));
			}
		}

		ImageIcon imagenQR = new ImageIcon(image);

		qr = new JLabel(imagenQR);
		qr.setFocusable(true);
		qr.setSize(150, 150);
		qr.setLocation(600, 175);
		panel.getContentPane().add(qr);
	}

	public static void qrActualizar() throws FileNotFoundException, IOException {
	}

}
