package exerc7;
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

public class JanelaMedia extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JLabel lblResultadoMedia;
    private JLabel lblSituacao;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	JanelaMedia frame = new JanelaMedia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaMedia() {
        setTitle("Cálculo de Média Escolar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome do Aluno:");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNome.setBounds(30, 30, 110, 25);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(150, 30, 200, 25);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNota1.setBounds(30, 70, 110, 25);
        contentPane.add(lblNota1);

        txtNota1 = new JTextField();
        txtNota1.setBounds(150, 70, 100, 25);
        contentPane.add(txtNota1);
        txtNota1.setColumns(10);

        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNota2.setBounds(30, 110, 110, 25);
        contentPane.add(lblNota2);

        txtNota2 = new JTextField();
        txtNota2.setBounds(150, 110, 100, 25);
        contentPane.add(txtNota2);
        txtNota2.setColumns(10);

        JButton btnCalcular = new JButton("Calcular Média");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setBounds(120, 150, 150, 30);
        contentPane.add(btnCalcular);

        lblResultadoMedia = new JLabel("Média: --");
        lblResultadoMedia.setFont(new Font("Arial", Font.BOLD, 14));
        lblResultadoMedia.setBounds(30, 200, 320, 25);
        contentPane.add(lblResultadoMedia);

        lblSituacao = new JLabel("Situação: --");
        lblSituacao.setFont(new Font("Arial", Font.BOLD, 14));
        lblSituacao.setBounds(30, 230, 320, 25);
        contentPane.add(lblSituacao);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtNome.getText().trim().isEmpty() || txtNota1.getText().trim().isEmpty() || txtNota2.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    String nome = txtNome.getText();
                    double nota1 = Double.parseDouble(txtNota1.getText());
                    double nota2 = Double.parseDouble(txtNota2.getText());

                    double media = (nota1 + nota2) / 2.0;

                    lblResultadoMedia.setText(String.format("Média de %s: %.2f", nome, media));

                    if (media >= 7.0) {
                        lblSituacao.setText("Situação: Aprovado");
                    } else {
                        lblSituacao.setText("Situação: Reprovado");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Digite apenas números válidos nas notas!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
