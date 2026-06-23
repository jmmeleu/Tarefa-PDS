package exerc5;
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

public class JanelaRestaurante extends JFrame {

    private JPanel contentPane;
    private JTextField txtPesoPrato;
    private JTextField txtValorQuilo;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaRestaurante frame = new JanelaRestaurante();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaRestaurante() {
        setTitle("Fomelândia - Calculadora de Prato");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 380, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPeso = new JLabel("Peso do Prato (kg):");
        lblPeso.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPeso.setBounds(30, 30, 150, 25);
        contentPane.add(lblPeso);

        txtPesoPrato = new JTextField();
        txtPesoPrato.setBounds(180, 30, 140, 25);
        contentPane.add(txtPesoPrato);
        txtPesoPrato.setColumns(10);

        JLabel lblValor = new JLabel("Valor do Quilo (R$):");
        lblValor.setFont(new Font("Arial", Font.PLAIN, 14));
        lblValor.setBounds(30, 70, 150, 25);
        contentPane.add(lblValor);

        txtValorQuilo = new JTextField();
        txtValorQuilo.setText("9.95"); 
        txtValorQuilo.setBounds(180, 70, 140, 25);
        contentPane.add(txtValorQuilo);
        txtValorQuilo.setColumns(10);

        JButton btnCalcular = new JButton("Calcular Total");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setBounds(110, 110, 140, 30);
        contentPane.add(btnCalcular);

        lblResultado = new JLabel("Valor a pagar: --");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultado.setBounds(30, 160, 320, 25);
        contentPane.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(txtPesoPrato.getText());
                    double valorQuilo = Double.parseDouble(txtValorQuilo.getText());

                    double total = peso * valorQuilo;

                    lblResultado.setText(String.format("Valor a pagar: R$ %.2f", total));
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Erro: Digite apenas números!");
                }
            }
        });
    }
}
