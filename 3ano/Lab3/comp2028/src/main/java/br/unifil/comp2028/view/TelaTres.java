package br.unifil.comp2028.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class TelaTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaTres guiTres = new TelaTres();
		guiTres.go();
	}
	

	public static void go() {

		JFrame frame = new JFrame("Bando de Dados");
	
		JPanel panel = new JPanel();
		
		JLabel jlabel1 = new JLabel("Usúario ou senha invalido");
		JLabel jlabel2 = new JLabel("Por favor voltar a tela incial");
	
		JButton backButton = new JButton("Retornar");
		
		// ICONE "BACKWARD"
				IconFontSwing.register(FontAwesome.getIconFont());
				Icon icon = IconFontSwing.buildIcon(FontAwesome.BACKWARD, 30, new Color(0, 0, 0));
				JLabel label = new JLabel(icon, JLabel.CENTER);

		panel.add(jlabel1);
		panel.add(jlabel2);
		panel.add(backButton);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, label);
		
		frame.setSize(210, 200);
		frame.setVisible(true);
		frame.setResizable(false);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginGUI gui = new LoginGUI();
				frame.setVisible(false);
				gui.go();
				

			}
		});
		
	}
}
