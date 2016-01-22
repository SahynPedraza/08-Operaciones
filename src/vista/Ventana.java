package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.OperatingSystemMXBean;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.*;
/**
 * 
 * @author SAIN PEDRAZA GUERRERO
 *
 */
public class Ventana extends JFrame implements ActionListener{
	private JTextField txtN1 = new JTextField();
	private JTextField txtN2 = new JTextField();
	
	private JLabel lbN1 = new JLabel("Numero 1");
	private JLabel lbN2= new JLabel("Numero 2");
	private JLabel lbResultado= new JLabel("Resultado");
	
	private JButton btnSumar = new JButton("+");
	private JButton btnRestar = new JButton("-");
	private JButton btnMultiplicar = new JButton("*");
	private JButton btnDividir = new JButton("/");
	
	private Container c = getContentPane();
	
	private Suma sum = new Suma();
	private Resta res = new Resta();
	private Multiplicacion mul = new Multiplicacion();
	private Division div = new Division();
	/**
	 * Dimensiones de ventana
	 */
	public Ventana(){
	super.setTitle("Operaciones");
	super.setSize(320, 480);
	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	cargarContoles();
}
/**
 * Dimensiones de elementos que conformaran la ventana
 */
private void cargarContoles() {
	c.setLayout(null);
	lbN1.setBounds(10, 10, 300, 30);
	txtN1.setBounds(10, 40, 250, 30);
	lbN2.setBounds(10, 80, 300, 30);
	txtN2.setBounds(10, 110, 250, 30);
	
	btnSumar.setBounds		(10, 150, 90, 30);
	btnRestar.setBounds		(120, 150, 90, 30);
	btnMultiplicar.setBounds(10, 190, 90, 30);
	btnDividir.setBounds	(120, 190, 90, 30);
	
	
	lbResultado.setBounds(10, 220, 300, 30);
	/**
	 * Agregacion de los elementos
	 */
	c.add(lbN1);
	c.add(txtN1);
	c.add(lbN2);
	c.add(txtN2);
	c.add(btnSumar);
	c.add(btnRestar);
	c.add(btnMultiplicar);
	c.add(btnDividir);
	c.add(lbResultado);
	
	btnSumar.addActionListener(this);
	btnRestar.addActionListener(this);
	btnMultiplicar.addActionListener(this);
	btnDividir.addActionListener(this);	
}
	/**
	 * Metodo con sentencia if para la seleccion de botones
	 */
public void actionPerformed(ActionEvent arg0){
	Object boton = arg0.getSource();
	if(boton==btnSumar){
		float s = sum.operaciones(Float.parseFloat(txtN1.getText()), Float.parseFloat(txtN2.getText()));
		lbResultado.setText(String.format("%s + %s = %.0f", txtN1.getText(), txtN2.getText(), s));
	}
	if(boton==btnRestar){
		float r = res.operaciones(Float.parseFloat(txtN1.getText()), Float.parseFloat(txtN2.getText()));
		lbResultado.setText(String.format("%s - %s = %.1f", txtN1.getText(), txtN2.getText(), r));
	}
	if(boton==btnMultiplicar){
		float m = mul.operaciones(Float.parseFloat(txtN1.getText()), Float.parseFloat(txtN2.getText()));
		lbResultado.setText(String.format("%s * %s = %.1f", txtN1.getText(), txtN2.getText(), m));
	}
	if(boton==btnDividir){
		float d = div.operaciones(Float.parseFloat(txtN1.getText()), Float.parseFloat(txtN2.getText()));
		lbResultado.setText(String.format("%s / %s = %f", txtN1.getText(), txtN2.getText(), d));
	}

}

}
