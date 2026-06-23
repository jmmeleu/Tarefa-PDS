package exerc2;
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

public class JanelaNome extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JLabel lblNomeCompleto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	JanelaNome frame = new JanelaNome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JanelaNome() {
        setTitle("Nome Completo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNome.setBounds(30, 30, 80, 25);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 30, 220, 25);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblSobrenome = new JLabel("Sobrenome:");
        lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSobrenome.setBounds(30, 70, 80, 25);
        contentPane.add(lblSobrenome);

        txtSobrenome = new JTextField();
        txtSobrenome.setBounds(120, 70, 220, 25);
        contentPane.add(txtSobrenome);
        txtSobrenome.setColumns(10);

        JButton btnMostrar = new JButton("Mostrar Nome Completo");
        btnMostrar.setFont(new Font("Arial", Font.BOLD, 12));
        btnMostrar.setBounds(100, 120, 200, 30);
        contentPane.add(btnMostrar);

        lblNomeCompleto = new JLabel("Nome Completo: ");
        lblNomeCompleto.setFont(new Font("Arial", Font.BOLD, 14));
        lblNomeCompleto.setBounds(30, 170, 340, 25);
        contentPane.add(lblNomeCompleto);

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String sobrenome = txtSobrenome.getText();
                lblNomeCompleto.setText("Nome Completo: " + nome + " " + sobrenome);
            }
        });
    }
}
