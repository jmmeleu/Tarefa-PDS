package CalculadoraAcademia1;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

enum OpcaoCalculo {
    SELECIONE("Selecione..."),
    IMC("Índice de Massa Corporal (IMC)"),
    GORDURA_CORPORAL("Percentual de Gordura"),
    MASSA_MAGRA("Massa Magra (kg)"),
    AGUA_RECOMENDADA("Água Diária Recomendada");

    private String descricao;

    OpcaoCalculo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}

public class CalcAcad1 extends JFrame {

    private JPanel contentPane;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JComboBox<OpcaoCalculo> cbOperacoes;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalcAcad1 frame = new CalcAcad1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CalcAcad1() {
        setTitle("Calculadora Academia - Avaliação Física");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPeso.setBounds(30, 30, 100, 25);
        contentPane.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(150, 30, 120, 25);
        contentPane.add(txtPeso);
        txtPeso.setColumns(10);

        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setFont(new Font("Arial", Font.PLAIN, 14));
        lblAltura.setBounds(30, 70, 100, 25);
        contentPane.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 70, 120, 25);
        contentPane.add(txtAltura);
        txtAltura.setColumns(10);

        JLabel lblOpcao = new JLabel("O que calcular?");
        lblOpcao.setFont(new Font("Arial", Font.PLAIN, 14));
        lblOpcao.setBounds(30, 120, 120, 25);
        contentPane.add(lblOpcao);

        cbOperacoes = new JComboBox<>(OpcaoCalculo.values());
        cbOperacoes.setBounds(150, 120, 250, 25);
        contentPane.add(cbOperacoes);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 12));
        btnCalcular.setBounds(150, 170, 120, 35);
        contentPane.add(btnCalcular);

        lblResultado = new JLabel("Resultado: --");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 15));
        lblResultado.setBounds(30, 240, 390, 30);
        contentPane.add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OpcaoCalculo selecao = (OpcaoCalculo) cbOperacoes.getSelectedItem();

                if (selecao == OpcaoCalculo.SELECIONE) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um cálculo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (txtPeso.getText().trim().isEmpty() || txtAltura.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha o peso e a altura!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double peso = Double.parseDouble(txtPeso.getText());
                    double altura = Double.parseDouble(txtAltura.getText());
                    
                    AcademiaCalculos calculador = new AcademiaCalculos();
                    String resultadoTexto = "";

                    switch (selecao) {
                        case IMC:
                            double imc = calculador.calcularIMC(peso, altura);
                            resultadoTexto = String.format("IMC: %.2f (%s)", imc, calculador.classificarIMC(imc));
                            break;
                        case GORDURA_CORPORAL:
                            double bf = calculador.estimarGordura(peso, altura);
                            resultadoTexto = String.format("Percentual de Gordura Estimado: %.1f%%", bf);
                            break;
                        case MASSA_MAGRA:
                            double magra = calculador.calcularMassaMagra(peso, altura);
                            resultadoTexto = String.format("Massa Magra: %.2f kg", magra);
                            break;
                        case AGUA_RECOMENDADA:
                            double agua = calculador.calcularAgua(peso);
                            resultadoTexto = String.format("Água recomendada: %.2f Litros por dia", agua);
                            break;
                        default:
                            resultadoTexto = "Opção inválida.";
                    }

                    lblResultado.setText(resultadoTexto);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos válidos (Ex: peso: 75.5, altura: 1.75)", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

class AcademiaCalculos {

    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String classificarIMC(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25.0) return "Peso normal";
        if (imc < 30.0) return "Sobrepeso";
        return "Obesidade";
    }

    public double estimarGordura(double peso, double altura) {
        double imc = calcularIMC(peso, altura);
        return (1.20 * imc) + (0.23 * 25) - 5.4; 
    }

    public double calcularMassaMagra(double peso, double altura) {
        double gorduraPercentual = estimarGordura(peso, altura);
        double pesoGordura = peso * (gorduraPercentual / 100.0);
        return peso - pesoGordura;
    }

    public double calcularAgua(double peso) {
        return (peso * 35.0) / 1000.0;
    }
}