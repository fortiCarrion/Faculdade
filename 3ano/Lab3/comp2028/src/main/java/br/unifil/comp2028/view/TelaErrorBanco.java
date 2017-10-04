package br.unifil.comp2028.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaErrorBanco {

	public static void main(String[] args) {

		TelaErrorBanco guiError = new TelaErrorBanco();
		guiError.go();

	}

	public static void go() {

		JFrame frame = new JFrame("Bando de Dados");
		JPanel panel = new JPanel();

		JLabel jlabel1 = new JLabel("Erro na conexão com o BD");
		JLabel jlabel2 = new JLabel("Favor verificar url e senha");
		JLabel jlabel3 = new JLabel("na Classe Factory");
		
		panel.add(jlabel1);
		panel.add(jlabel2);
		panel.add(jlabel3);
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		frame.setSize(210, 200);
		frame.setVisible(true);
		frame.setResizable(false);


	}
}
