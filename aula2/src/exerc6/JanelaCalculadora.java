package exerc6;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JanelaCalculadora extends JFrame {

    private JPanel contentPane;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaCalculadora frame = new JanelaCalculadora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaCalculadora() {
        setTitle("Calculadora Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNum1 = new JLabel("Número 1:");
        lblNum1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNum1.setBounds(30, 30, 80, 25);
        contentPane.add(lblNum1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(120, 30, 240, 25);
        contentPane.add(txtNumero1);
        txtNumero1.setColumns(10);

        JLabel lblNum2 = new JLabel("Número 2:");
        lblNum2.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNum2.setBounds(30, 70, 80, 25);
        contentPane.add(lblNum2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(120, 70, 240, 25);
        contentPane.add(txtNumero2);
        txtNumero2.setColumns(10);

        JButton btnSomar = new JButton("+");
        btnSomar.setFont(new Font("Arial", Font.BOLD, 16));
        btnSomar.setBounds(50, 120, 60, 40);
        contentPane.add(btnSomar);

        JButton btnSubtrair = new JButton("-");
        btnSubtrair.setFont(new Font("Arial", Font.BOLD, 16));
        btnSubtrair.setBounds(140, 120, 60, 40);
        contentPane.add(btnSubtrair);

        JButton btnMultiplicar = new JButton("*");
        btnMultiplicar.setFont(new Font("Arial", Font.BOLD, 16));
        btnMultiplicar.setBounds(230, 120, 60, 40);
        contentPane.add(btnMultiplicar);

        JButton btnDividir = new JButton("/");
        btnDividir.setFont(new Font("Arial", Font.BOLD, 16));
        btnDividir.setBounds(320, 120, 60, 40);
        contentPane.add(btnDividir);

        lblResultado = new JLabel("Resultado: --");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBounds(30, 190, 350, 30);
        contentPane.add(lblResultado);

        btnSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executarOperacao("+");
            }
        });

        btnSubtrair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executarOperacao("-");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executarOperacao("*");
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executarOperacao("/");
            }
        });
    }

    private void executarOperacao(String operacao) {
        if (txtNumero1.getText().trim().isEmpty() || txtNumero2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro: preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            double resultado = 0;

            if (operacao.equals("+")) {
                resultado = num1 + num2;
            } else if (operacao.equals("-")) {
                resultado = num1 - num2;
            } else if (operacao.equals("*")) {
                resultado = num1 * num2;
            } else if (operacao.equals("/")) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Erro: Não é possível dividir por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                resultado = num1 / num2;
            }

            lblResultado.setText(String.format("Resultado: %.2f", resultado));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Digite apenas valores numéricos válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}