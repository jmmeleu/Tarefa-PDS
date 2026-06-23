package exerc3;
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

public class JanelaRetangulo extends JFrame {

    private JPanel contentPane;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JLabel lblPerimetro;
    private JLabel lblArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaRetangulo frame = new JanelaRetangulo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaRetangulo() {
        setTitle("Cálculo do Retângulo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 380, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBase = new JLabel("Base:");
        lblBase.setFont(new Font("Arial", Font.PLAIN, 14));
        lblBase.setBounds(30, 30, 80, 25);
        contentPane.add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(120, 30, 100, 25);
        contentPane.add(txtBase);
        txtBase.setColumns(10);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setFont(new Font("Arial", Font.PLAIN, 14));
        lblAltura.setBounds(30, 70, 80, 25);
        contentPane.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(120, 70, 100, 25);
        contentPane.add(txtAltura);
        txtAltura.setColumns(10);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setBounds(120, 110, 100, 30);
        contentPane.add(btnCalcular);

        lblPerimetro = new JLabel("Perímetro: --");
        lblPerimetro.setFont(new Font("Arial", Font.BOLD, 14));
        lblPerimetro.setBounds(30, 160, 300, 25);
        contentPane.add(lblPerimetro);

        lblArea = new JLabel("Área: --");
        lblArea.setFont(new Font("Arial", Font.BOLD, 14));
        lblArea.setBounds(30, 190, 300, 25);
        contentPane.add(lblArea);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double base = Double.parseDouble(txtBase.getText());
                    double altura = Double.parseDouble(txtAltura.getText());

                    Retangulo retangulo = new Retangulo();
                    double perimetro = retangulo.calcularPerimetro(base, altura);
                    double area = retangulo.calcularArea(base, altura);

                    lblPerimetro.setText(String.format("Perímetro: %.2f", perimetro));
                    lblArea.setText(String.format("Área: %.2f", area));
                } catch (NumberFormatException ex) {
                    lblPerimetro.setText("Erro: Digite apenas números!");
                    lblArea.setText("");
                }
            }
        });
    }
}

class Retangulo {

    public double calcularPerimetro(double base, double altura) {
        return 2 * (altura + base);
    }

    public double calcularArea(double base, double altura) {
        return base * altura;
    }
}
