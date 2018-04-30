package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Calse que se encarga de la representacion grafica del programas donde esta
 * contenido los componentes como campo de texto y botones
 *
 * @author Juan Jose Alvarez Orozco
 * @author Daniel Beltran Gomez
 * @version 1.0
 */
public class InterfazPrincipal extends JFrame implements ActionListener {

	// Vsriables globales

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField campoFormula, salida;
	private JPanel panelPrincipal, panelContenedor, panelAtomos, panelOperadores;
	private JLabel entradaDeTexto, entradaDeOperador, entradaDeFormaAtomica, titulo, titulo1, titulo2, campoSalida;
	private JButton aceptar, conjuncion, disyuncion, implicacion, negacion, equivalencia, p, q, r, s, t, ayuda;

	/**
	 * Método constructor que establece las propiedades de la ventana
	 */
	public InterfazPrincipal() {
		this.setTitle("Forma Normal Disyuntiva");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.createUIComponents();
		getContentPane().add(panelPrincipal);
		this.setVisible(true);
	}

	/**
	 * Método que crea y organiza los componentes en la interfaz
	 */
	private void createUIComponents() {
		// Panel donde estará todos los compoentes
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(204, 255, 255));
		panelPrincipal.setLayout(null);
		panelPrincipal.setBounds(0, 0, this.getWidth(), this.getHeight());

		// Panel donde están los botones de los operadores y las formas atómicas
		panelContenedor = new JPanel();
		panelContenedor.setBackground(new Color(255, 255, 204));
		panelContenedor.setBounds(40, 100, 513, 369);

		// Panel donde está contenido los botones de cada atomo
		panelAtomos = new JPanel();
		panelAtomos.setLayout(new GridLayout(5, 1));
		panelAtomos.setBounds(300, 70, 185, 259);

		// Panel donde está contenido los botones de cada operador
		panelOperadores = new JPanel();
		panelContenedor.setLayout(null);
		panelOperadores.setLayout(new GridLayout(5, 1));
		panelOperadores.setBounds(29, 70, 185, 259);

		// Etiqueta del titulo de los ato
		entradaDeTexto = new JLabel("Visualización de entrada:");
		entradaDeTexto.setLabelFor(campoFormula);
		entradaDeTexto.setBackground(new Color(255, 255, 204));
		entradaDeTexto.setFont(new Font("Calibri", Font.BOLD, 16));
		entradaDeTexto.setBounds(40, 41, 183, 20);

		// campo de donde se visualiza la formula ingresada por el usuario
		campoFormula = new JTextField();
		campoFormula.setEditable(false);
		campoFormula.setFont(new Font("Calibri", Font.BOLD, 16));
		campoFormula.setBounds(221, 41, 495, 20);

		// Etiqueta para indicar el campo de donde se visualiza la formula tranformada
		campoSalida = new JLabel("Visualizacion de salida:");
		campoSalida.setBackground(new Color(255, 255, 204));
		campoSalida.setLabelFor(salida);
		campoSalida.setFont(new Font("Calibri", Font.BOLD, 16));
		campoSalida.setBounds(40, 480, 164, 20);

		// Campo de donde se visualiza la formula tranformada
		salida = new JTextField();
		salida.setEditable(false);
		salida.setFont(new Font("Calibri", Font.BOLD, 16));
		salida.setBounds(220, 480, 513, 20);

		// Etiqueta del titulo del programa
		titulo = new JLabel("Forma Normal Disyuntiva");
		titulo.setFont(new Font("Calibri", Font.BOLD, 16));
		titulo.setBounds(276, 11, 183, 20);

		// Etiqueta del titulo de los operaadores
		titulo1 = new JLabel("Operadores Lógicos");
		titulo1.setFont(new Font("Calibri", Font.BOLD, 16));
		titulo1.setBounds(48, 19, 150, 20);

		// Etiqueta del titulo de los atomos
		titulo2 = new JLabel("Átomos");
		titulo2.setFont(new Font("Calibri", Font.BOLD, 16));
		titulo2.setBounds(300, 19, 185, 20);

		// Botón para mostrar ayuda
		ayuda = new JButton("");
		ayuda.setIcon(new ImageIcon(Interfaz.class.getResource("/image/help_1.png")));
		ayuda.setBackground(new Color(137, 191, 253));
		ayuda.setContentAreaFilled(false);
		ayuda.setBorderPainted(false);
		ayuda.setForeground(new Color(0, 0, 0));
		ayuda.setFont(new Font("Calibri", Font.BOLD, 16));
		ayuda.setBounds(618, 198, 107, 116);
		ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ayuda.addActionListener(this);

		// Botón para terminar de editar la formula y convertir
		aceptar = new JButton("Aceptar");
		aceptar.setBackground(new Color(137, 191, 253));
		aceptar.setForeground(new Color(0, 0, 0));
		aceptar.setFont(new Font("Calibri", Font.BOLD, 16));
		aceptar.setBounds(331, 72, 100, 20);
		aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aceptar.addActionListener(this);

		// Botón para agregar el átomo p en la fórmula
		p = new JButton("Átomo (p)");
		p.setBorderPainted(false);
		p.setBackground(new Color(137, 191, 253));
		p.setForeground(new Color(0, 0, 0));
		p.setFont(new Font("Calibri", Font.BOLD, 16));
		p.setBounds(190, 60, 100, 20);
		p.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p.addActionListener(this);

		// Botón para agregar el átomo q en la fórmula
		q = new JButton("Átomo (q)");
		q.setBorderPainted(false);
		q.setBackground(new Color(137, 191, 253));
		q.setForeground(new Color(0, 0, 0));
		q.setFont(new Font("Calibri", Font.BOLD, 16));
		q.setBounds(190, 60, 100, 20);
		q.setCursor(new Cursor(Cursor.HAND_CURSOR));
		q.addActionListener(this);

		// Botón para agregar el átomo r en la fórmula
		r = new JButton("Átomo (r)");
		r.setBorderPainted(false);
		r.setBackground(new Color(137, 191, 253));
		r.setForeground(new Color(0, 0, 0));
		r.setFont(new Font("Calibri", Font.BOLD, 16));
		r.setBounds(190, 60, 100, 20);
		r.setCursor(new Cursor(Cursor.HAND_CURSOR));
		r.addActionListener(this);

		// Botón para agregar el átomo s en la fórmula
		s = new JButton("Átomo (s)");
		s.setBorderPainted(false);
		s.setBackground(new Color(137, 191, 253));
		s.setForeground(new Color(0, 0, 0));
		s.setFont(new Font("Calibri", Font.BOLD, 16));
		s.setBounds(190, 60, 100, 20);
		s.setCursor(new Cursor(Cursor.HAND_CURSOR));
		s.addActionListener(this);

		// Botón para agregar el átomo t en la fórmula
		t = new JButton("Átomo (t)");
		t.setBorderPainted(false);
		t.setBackground(new Color(137, 191, 253));
		t.setForeground(new Color(0, 0, 0));
		t.setFont(new Font("Calibri", Font.BOLD, 16));
		t.setBounds(190, 60, 100, 20);
		t.setCursor(new Cursor(Cursor.HAND_CURSOR));
		t.addActionListener(this);

		// Botón para agregar el operador de negacion
		negacion = new JButton("Operador (¬)");
		negacion.setBackground(new Color(137, 191, 253));
		negacion.setBorderPainted(false);
		negacion.setForeground(new Color(0, 0, 0));
		negacion.setFont(new Font("Calibri", Font.BOLD, 16));
		negacion.setBounds(190, 60, 100, 20);
		negacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		negacion.addActionListener(this);

		// Botón para agregar el operador de conjuncion
		conjuncion = new JButton("Operador (∧)");
		conjuncion.setBorderPainted(false);
		conjuncion.setBackground(new Color(137, 191, 253));
		conjuncion.setForeground(new Color(0, 0, 0));
		conjuncion.setFont(new Font("Calibri", Font.BOLD, 16));
		conjuncion.setBounds(190, 60, 100, 20);
		conjuncion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		conjuncion.addActionListener(this);

		// Botón para agregar el operador de disyuncion
		disyuncion = new JButton("Operador (∨)");
		disyuncion.setBorderPainted(false);
		disyuncion.setBackground(new Color(137, 191, 253));
		disyuncion.setForeground(new Color(0, 0, 0));
		disyuncion.setFont(new Font("Calibri", Font.BOLD, 16));
		disyuncion.setBounds(190, 60, 100, 20);
		disyuncion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		disyuncion.addActionListener(this);

		// Botón para agregar el operador de implicacion
		implicacion = new JButton("Átomo (→)");
		implicacion.setBorderPainted(false);
		implicacion.setBackground(new Color(137, 191, 253));
		implicacion.setForeground(new Color(0, 0, 0));
		implicacion.setFont(new Font("Calibri", Font.BOLD, 16));
		implicacion.setBounds(190, 60, 100, 20);
		implicacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		implicacion.addActionListener(this);

		// Botón para agregar el operador de equivalencia
		equivalencia = new JButton("Átomo (↔)");
		equivalencia.setBorderPainted(false);
		equivalencia.setBackground(new Color(137, 191, 253));
		equivalencia.setForeground(new Color(0, 0, 0));
		equivalencia.setFont(new Font("Calibri", Font.BOLD, 16));
		equivalencia.setBounds(190, 60, 100, 20);
		equivalencia.setCursor(new Cursor(Cursor.HAND_CURSOR));
		equivalencia.addActionListener(this);

		// Agregacion de los botones operadores
		panelOperadores.add(negacion);
		panelOperadores.add(conjuncion);
		panelOperadores.add(disyuncion);
		panelOperadores.add(implicacion);
		panelOperadores.add(equivalencia);

		// Agregacion de las formas atomicas
		panelAtomos.add(p);
		panelAtomos.add(q);
		panelAtomos.add(r);
		panelAtomos.add(s);
		panelAtomos.add(t);

		// Agregacion de paneles con operadores y sus etiquetas
		panelContenedor.add(panelOperadores);
		panelContenedor.add(panelAtomos);
		panelContenedor.add(titulo1);
		panelContenedor.add(titulo2);

		// Agregacion del panel que contiene
		panelPrincipal.add(panelContenedor);
		panelPrincipal.add(entradaDeTexto);
		panelPrincipal.add(campoFormula);
		panelPrincipal.add(campoSalida);
		panelPrincipal.add(salida);
		panelPrincipal.add(aceptar);
		panelPrincipal.add(titulo);
		panelPrincipal.add(ayuda);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	// getters & setters

	/**
	 * @return the campoFormula
	 */
	public JTextField getCampoFormula() {
		return campoFormula;
	}

	/**
	 * @param campoFormula the campoFormula to set
	 */
	public void setCampoFormula(JTextField campoFormula) {
		this.campoFormula = campoFormula;
	}

	/**
	 * @return the salida
	 */
	public JTextField getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(JTextField salida) {
		this.salida = salida;
	}

	/**
	 * @return the panelPrincipal
	 */
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	/**
	 * @param panelPrincipal the panelPrincipal to set
	 */
	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	/**
	 * @return the panelContenedor
	 */
	public JPanel getPanelContenedor() {
		return panelContenedor;
	}

	/**
	 * @param panelContenedor the panelContenedor to set
	 */
	public void setPanelContenedor(JPanel panelContenedor) {
		this.panelContenedor = panelContenedor;
	}

	/**
	 * @return the panelAtomos
	 */
	public JPanel getPanelAtomos() {
		return panelAtomos;
	}

	/**
	 * @param panelAtomos the panelAtomos to set
	 */
	public void setPanelAtomos(JPanel panelAtomos) {
		this.panelAtomos = panelAtomos;
	}

	/**
	 * @return the panelOperadores
	 */
	public JPanel getPanelOperadores() {
		return panelOperadores;
	}

	/**
	 * @param panelOperadores the panelOperadores to set
	 */
	public void setPanelOperadores(JPanel panelOperadores) {
		this.panelOperadores = panelOperadores;
	}

	/**
	 * @return the entradaDeTexto
	 */
	public JLabel getEntradaDeTexto() {
		return entradaDeTexto;
	}

	/**
	 * @param entradaDeTexto the entradaDeTexto to set
	 */
	public void setEntradaDeTexto(JLabel entradaDeTexto) {
		this.entradaDeTexto = entradaDeTexto;
	}

	/**
	 * @return the entradaDeOperador
	 */
	public JLabel getEntradaDeOperador() {
		return entradaDeOperador;
	}

	/**
	 * @param entradaDeOperador the entradaDeOperador to set
	 */
	public void setEntradaDeOperador(JLabel entradaDeOperador) {
		this.entradaDeOperador = entradaDeOperador;
	}

	/**
	 * @return the entradaDeFormaAtomica
	 */
	public JLabel getEntradaDeFormaAtomica() {
		return entradaDeFormaAtomica;
	}

	/**
	 * @param entradaDeFormaAtomica the entradaDeFormaAtomica to set
	 */
	public void setEntradaDeFormaAtomica(JLabel entradaDeFormaAtomica) {
		this.entradaDeFormaAtomica = entradaDeFormaAtomica;
	}

	/**
	 * @return the titulo
	 */
	public JLabel getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the titulo1
	 */
	public JLabel getTitulo1() {
		return titulo1;
	}

	/**
	 * @param titulo1 the titulo1 to set
	 */
	public void setTitulo1(JLabel titulo1) {
		this.titulo1 = titulo1;
	}

	/**
	 * @return the titulo2
	 */
	public JLabel getTitulo2() {
		return titulo2;
	}

	/**
	 * @param titulo2 the titulo2 to set
	 */
	public void setTitulo2(JLabel titulo2) {
		this.titulo2 = titulo2;
	}

	/**
	 * @return the campoSalida
	 */
	public JLabel getCampoSalida() {
		return campoSalida;
	}

	/**
	 * @param campoSalida the campoSalida to set
	 */
	public void setCampoSalida(JLabel campoSalida) {
		this.campoSalida = campoSalida;
	}

	/**
	 * @return the aceptar
	 */
	public JButton getAceptar() {
		return aceptar;
	}

	/**
	 * @param aceptar the aceptar to set
	 */
	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	/**
	 * @return the conjuncion
	 */
	public JButton getConjuncion() {
		return conjuncion;
	}

	/**
	 * @param conjuncion the conjuncion to set
	 */
	public void setConjuncion(JButton conjuncion) {
		this.conjuncion = conjuncion;
	}

	/**
	 * @return the disyuncion
	 */
	public JButton getDisyuncion() {
		return disyuncion;
	}

	/**
	 * @param disyuncion the disyuncion to set
	 */
	public void setDisyuncion(JButton disyuncion) {
		this.disyuncion = disyuncion;
	}

	/**
	 * @return the implicacion
	 */
	public JButton getImplicacion() {
		return implicacion;
	}

	/**
	 * @param implicacion the implicacion to set
	 */
	public void setImplicacion(JButton implicacion) {
		this.implicacion = implicacion;
	}

	/**
	 * @return the negacion
	 */
	public JButton getNegacion() {
		return negacion;
	}

	/**
	 * @param negacion the negacion to set
	 */
	public void setNegacion(JButton negacion) {
		this.negacion = negacion;
	}

	/**
	 * @return the equivalencia
	 */
	public JButton getEquivalencia() {
		return equivalencia;
	}

	/**
	 * @param equivalencia the equivalencia to set
	 */
	public void setEquivalencia(JButton equivalencia) {
		this.equivalencia = equivalencia;
	}

	/**
	 * @return the p
	 */
	public JButton getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(JButton p) {
		this.p = p;
	}

	/**
	 * @return the q
	 */
	public JButton getQ() {
		return q;
	}

	/**
	 * @param q the q to set
	 */
	public void setQ(JButton q) {
		this.q = q;
	}

	/**
	 * @return the r
	 */
	public JButton getR() {
		return r;
	}

	/**
	 * @param r the r to set
	 */
	public void setR(JButton r) {
		this.r = r;
	}

	/**
	 * @return the s
	 */
	public JButton getS() {
		return s;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(JButton s) {
		this.s = s;
	}

	/**
	 * @return the t
	 */
	public JButton getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(JButton t) {
		this.t = t;
	}
}
