package exerc1;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JanelaConversor extends JFrame {

    private JPanel contentPane;
    private JTextField txtFahrenheit;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaConversor frame = new JanelaConversor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaConversor() {
        setTitle("Conversor de Temperatura");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 380, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblInstrucao = new JLabel("Digite a temperatura em °F:");
        lblInstrucao.setFont(new Font("Arial", Font.PLAIN, 14));
        lblInstrucao.setBounds(30, 40, 180, 25);
        contentPane.add(lblInstrucao);

        txtFahrenheit = new JTextField();
        txtFahrenheit.setBounds(220, 40, 100, 25);
        contentPane.add(txtFahrenheit);
        txtFahrenheit.setColumns(10);

        JButton btnCalcular = new JButton("Converter");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setBounds(120, 90, 120, 30);
        contentPane.add(btnCalcular);

        lblResultado = new JLabel("Resultado: -- °C");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultado.setBounds(30, 150, 300, 25);
        contentPane.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String textoDigitado = txtFahrenheit.getText();
                    double fahrenheit = Double.parseDouble(textoDigitado);

                    Conversao conversor = new Conversao();
                    double celsius = conversor.calcularTemperatura(fahrenheit);

                    lblResultado.setText(String.format("Resultado: %.2f °C", celsius));
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Erro: Digite apenas números!");
                }
            }
        });
    }
}

class Conversao {

    public double calcularTemperatura(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}
