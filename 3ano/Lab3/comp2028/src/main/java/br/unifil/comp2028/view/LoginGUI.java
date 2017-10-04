package br.unifil.comp2028.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.unifil.comp2028.Factory;
import br.unifil.comp2028.model.user;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class LoginGUI {

	public static void main(String[] args) {

		LoginGUI gui = new LoginGUI();
		gui.go();

	}

	public void go() {

		JFrame frame = new JFrame("Login JDBC");
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JTextField username = new JTextField(15);
		//JTextField password = new JTextField(15);
		JPasswordField password = new JPasswordField(15);
		JButton button = new JButton("Login");

		username.setText("Username");
		password.setText("Password");

		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// panel.setBackground(Color.GRAY);

		// ICONE "CIRCULO USUARIO"
		IconFontSwing.register(FontAwesome.getIconFont());
		Icon icon = IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE, 55, new Color(0, 0, 0));
		JLabel label = new JLabel(icon, JLabel.CENTER);

		// ICONE USUARIO
		IconFontSwing.register(FontAwesome.getIconFont());
		Icon iconTwo = IconFontSwing.buildIcon(FontAwesome.USER, 25, new Color(0, 0, 0));
		JLabel labelTwo = new JLabel(iconTwo);

		// ICONE CADEADO
		IconFontSwing.register(FontAwesome.getIconFont());
		Icon iconThree = IconFontSwing.buildIcon(FontAwesome.LOCK, 25, new Color(0, 0, 0));
		JLabel labelThree = new JLabel(iconThree);

		panel.add(labelTwo);
		panel.add(username);
		panel.add(labelThree);
		panel.add(password);
		panel.add(button);

		frame.getContentPane().add(BorderLayout.NORTH, label);
		frame.getContentPane().add(BorderLayout.CENTER, panel);

		password.setEchoChar('*');

		frame.setSize(210, 200);
		frame.setResizable(false);
		frame.setVisible(true);

		/**
		 * @Override actionPerformed(ActionEvent e) efetuar login no MySQL
		 *           server, com nome e password do usúario.
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Factory factory = new Factory();
				user user = new user();

				user.setUsername(username.getText());
				user.setPassword(password.getText());				
				
				try {
					factory.createConnection();
					
					StringBuilder sql = new StringBuilder();
					sql.append("select * from user where username = ? and password = ? ;");
					
					Connection connection = Factory.createConnection();
					PreparedStatement stmt = connection.prepareStatement(sql.toString());
					
					stmt.setString(1, user.getUsername());
					stmt.setString(2, user.getPassword());
					
					ResultSet resultSet = stmt.executeQuery();
					boolean sucesso = false;
					
					while(resultSet.next()){
						sucesso = true;
						break;
					}
					
					if (sucesso) {
						TelaDois dgui = new TelaDois();
						frame.setVisible(false);
						dgui.go();
				    } else {
				    	TelaTres tgui = new TelaTres();
				    	frame.setVisible(false);
				    	tgui.go();
				    }
							
			        stmt.close();
					
				} catch (SQLException ee) {
					TelaErrorBanco guiError = new TelaErrorBanco();
					guiError.go();
					ee.printStackTrace();
				}

			}
		});

		/**
		 * @Override keyPressed(KeyEvent e), para poder fazer a mesma operação
		 *           do método acima porém ultilizando também a tecla "Enter".
		 */
		password.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// TODO Auto-generated method stub
					Factory factory = new Factory();
					user user = new user();

					user.setUsername(username.getText());
					user.setPassword(password.getText());

					try {
						factory.createConnection();
						
						StringBuilder sql = new StringBuilder();
						sql.append("select * from user where username = ? and password = ? ;");
						
						Connection connection = Factory.createConnection();
						PreparedStatement stmt = connection.prepareStatement(sql.toString());
						
						stmt.setString(1, user.getUsername());
						stmt.setString(2, user.getPassword());
						
						ResultSet resultSet = stmt.executeQuery();
						boolean sucesso = false;
						
						while(resultSet.next()){
							sucesso = true;
							break;
						}
						
						if (sucesso) {
							TelaDois dgui = new TelaDois();
							frame.setVisible(false);
							dgui.go();
					    } else {
					    	TelaTres tgui = new TelaTres();
					    	frame.setVisible(false);
					    	tgui.go();
					    }
								
				        stmt.close();
						
					} catch (SQLException ee) {
						TelaErrorBanco guiError = new TelaErrorBanco();
						guiError.go();
						ee.printStackTrace();
					}
					
				}
			}

		});

	}
}
