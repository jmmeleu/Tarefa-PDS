package exerc4;
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

public class JanelaCombustivel extends JFrame {

    private JPanel contentPane;
    private JTextField txtPrecoLitro;
    private JTextField txtValorPagamento;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaCombustivel frame = new JanelaCombustivel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaCombustivel() {
        setTitle("Calculadora de Combustível");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 380, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPreco = new JLabel("Preço por Litro (R$):");
        lblPreco.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPreco.setBounds(30, 30, 150, 25);
        contentPane.add(lblPreco);

        txtPrecoLitro = new JTextField();
        txtPrecoLitro.setBounds(180, 30, 140, 25);
        contentPane.add(txtPrecoLitro);
        txtPrecoLitro.setColumns(10);

        JLabel lblValor = new JLabel("Valor a Abastecer (R$):");
        lblValor.setFont(new Font("Arial", Font.PLAIN, 14));
        lblValor.setBounds(30, 70, 150, 25);
        contentPane.add(lblValor);

        txtValorPagamento = new JTextField();
        txtValorPagamento.setBounds(180, 70, 140, 25);
        contentPane.add(txtValorPagamento);
        txtValorPagamento.setColumns(10);

        JButton btnCalcular = new JButton("Calcular Litros");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setBounds(110, 110, 140, 30);
        contentPane.add(btnCalcular);

        lblResultado = new JLabel("Total de litros: --");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultado.setBounds(30, 160, 320, 25);
        contentPane.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double precoLitro = Double.parseDouble(txtPrecoLitro.getText());
                    double valorPagamento = Double.parseDouble(txtValorPagamento.getText());

                    double litros = valorPagamento / precoLitro;

                    lblResultado.setText(String.format("Total de litros: %.2f L", litros));
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Erro: Digite apenas números!");
                }
            }
        });
    }
}