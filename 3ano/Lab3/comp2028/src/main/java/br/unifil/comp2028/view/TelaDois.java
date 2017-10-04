package br.unifil.comp2028.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaDois {

	public static void main(String[] args) {

		TelaDois guiDois = new TelaDois();
		guiDois.go();

	}

	public static void go() {

		JFrame frame = new JFrame("Bando de Dados");
		JPanel panel = new JPanel();

		JLabel jlabel1 = new JLabel("Connectado com Sucesso :D");

		panel.add(jlabel1);
		frame.getContentPane().add(BorderLayout.NORTH, panel);

		frame.setSize(210, 200);
		frame.setVisible(true);
		frame.setResizable(false);


	}
}
