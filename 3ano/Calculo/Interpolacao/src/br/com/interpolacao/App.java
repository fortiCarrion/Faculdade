package br.com.interpolacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class App {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JButton calcularButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;


    public App() {
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interpolacao interpolacao = new Interpolacao();

                try {
                    double x = Integer.parseInt(textField7.getText());

                    double x0 = Integer.parseInt(textField2.getText());
                    double x1 = Integer.parseInt(textField1.getText());
                    double x2 = Integer.parseInt(textField3.getText());

                    double y0 = Integer.parseInt(textField4.getText());
                    double y1 = Integer.parseInt(textField5.getText());
                    double y2 = Integer.parseInt(textField6.getText());

                    interpolacao.setX(x);
                    interpolacao.setX0(x0);
                    interpolacao.setX1(x1);
                    interpolacao.setX2(x2);
                    interpolacao.setY0(y0);
                    interpolacao.setY1(y1);
                    interpolacao.setY2(y2);

                    textArea1.setText("Entrada de dados \n" + interpolacao.toString() + "\n\n");

                    //cálculo da interpolação linear
                    double passo1, passo2, passo3, passo4;

                    passo1 = y0 * (x - x1) / (x0 - x1) * (x - x2) / (x0 - x2);
                    textArea1.append(y0 + " * " + " ( " + x + " - " + x1 + " ) " + " / " + " ( " + x0 + " - " + x1 + " ) * ( " + x + " - " + x2 + " ) / ( " + x0 + " - " + x2 + " )" + "\n");

                    passo2 = y1 * (x - x1) / (x1 - x0) * (x - x2) / (x1 - x2);
                    textArea1.append(y1 + " * ( " + x + " - " + x1 + " ) / ( " + x1 + " - " + x0 + " ) * ( " + x + " - " + x2 + " ) / ( " + x1 + " - " + x2 + " ) \n");

                    passo3 = y2 * (x - x0) / (x2 - x0) * (x - x1) / (x2 - x1);
                    textArea1.append(y2 + " * ( " + x + " - " + x0 + " ) / ( " + x2 + " - " + x0 + " ) * ( " + x + " - " + x1 + " ) / ( " + x2 + " - " + x1 + " ) \n\n");

                    passo4 = passo1 + passo2 + passo3;
                    textArea1.append("Resultado = " + passo4);

                }catch (Exception en){
                    JOptionPane.showMessageDialog(null, "Por favor, não deixar campos em branco");
                }
            }
        });
    }

    private static void createUIComponents() {
        // TODO: place custom component creation code here

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("App - Interpolacao Linear");
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560,600);
        frame.setVisible(true);

    }
}
