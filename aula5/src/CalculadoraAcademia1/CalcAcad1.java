package CalculadoraAcademia1;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

/**
 * Classe principal que estende JFrame para criar a janela da calculadora da academia.
 */
public class CalcAcad1 extends JFrame {

	private static final long serialVersionUID = 1L;

	// Componentes principais da interface gráfica (GUI)
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;

	// ButtonGroups para garantir a seleção única (exclusão mútua) em cada categoria de RadioButtons
	private final ButtonGroup planoGroup = new ButtonGroup();
	private final ButtonGroup duracaoGroup = new ButtonGroup();
	private final ButtonGroup frequenciaGroup = new ButtonGroup();

	// Botões de opção (Radio Buttons) para o Tipo do Plano
	private JRadioButton rbBasico;
	private JRadioButton rbIntermediario;
	private JRadioButton rbPremium;

	// Botões de opção (Radio Buttons) para a Duração
	private JRadioButton rbMensal;
	private JRadioButton rbSemestral;
	private JRadioButton rbAnual;

	// Botões de opção (Radio Buttons) para a Frequência Semanal
	private JRadioButton rb2x;
	private JRadioButton rb3x;
	private JRadioButton rb5x;

	// Rótulo de texto onde o valor calculado será exibido
	private JLabel lblResultado;

	/**
	 * Método principal (ponto de entrada da aplicação).
	 */
	public static void main(String[] args) {
		// EventQueue.invokeLater garante que a interface seja criada na Thread de despacho de eventos do Swing (boa prática)
		EventQueue.invokeLater(() -> {
			try {
				CalcAcad1 frame = new CalcAcad1();
				frame.setVisible(true); // Torna a janela visível
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Construtor da classe onde a interface gráfica é configurada e montada.
	 */
	public CalcAcad1() {
		// Configurações básicas da janela (JFrame)
		setTitle("Calculadora de Mensalidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
		setBounds(100, 100, 680, 365); // Define a posição inicial (x, y) e as dimensões (largura, altura)

		// Configuração do painel principal (container)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Margens internas de 10 pixels
		setContentPane(contentPane);
		
		// Inicialização do MigLayout: define as colunas e linhas em formato de grade flexível
		contentPane.setLayout(new MigLayout("", "[][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[][][][][][][][][]"));

		// --- LINHA 0: Título principal ---
		JLabel titulo = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(titulo, "cell 0 0 12 1,alignx center"); // Ocupa 12 colunas e centraliza horizontalmente

		// --- LINHA 1: Campo de texto do Nome ---
		contentPane.add(new JLabel("Nome:"), "cell 0 1 2 1,alignx right");
		textFieldNome = new JTextField();
		contentPane.add(textFieldNome, "cell 2 1 4 1,growx"); // Ocupa 4 colunas e expande horizontalmente

		// --- LINHA 2: Campo de texto do Telefone ---
		contentPane.add(new JLabel("Telefone:"), "cell 0 2 2 1,alignx right");
		textFieldTelefone = new JTextField();
		contentPane.add(textFieldTelefone, "cell 2 2 4 1,growx");

		// --- LINHA 3: Opções de Plano ---
		contentPane.add(new JLabel("Tipo do Plano:"), "cell 1 3,alignx right");

		rbBasico = new JRadioButton("Básico");
		rbIntermediario = new JRadioButton("Intermediário");
		rbPremium = new JRadioButton("Premium");

		// Adiciona os botões de plano ao grupo para que apenas um possa ser selecionado por vez
		planoGroup.add(rbBasico);
		planoGroup.add(rbIntermediario);
		planoGroup.add(rbPremium);

		// Posiciona cada Radio Button em colunas diferentes da linha 3
		contentPane.add(rbBasico, "cell 2 3");
		contentPane.add(rbIntermediario, "cell 5 3");
		contentPane.add(rbPremium, "cell 8 3");

		// --- LINHA 4: Opções de Duração ---
		contentPane.add(new JLabel("Duração:"), "cell 1 4,alignx right");

		rbMensal = new JRadioButton("Mensal");
		rbSemestral = new JRadioButton("Semestral");
		rbAnual = new JRadioButton("Anual");

		// Adiciona ao grupo correspondente
		duracaoGroup.add(rbMensal);
		duracaoGroup.add(rbSemestral);
		duracaoGroup.add(rbAnual);

		// Posiciona os Radio Buttons na linha 4
		contentPane.add(rbMensal, "cell 2 4");
		contentPane.add(rbSemestral, "cell 5 4");
		contentPane.add(rbAnual, "cell 8 4");

		// --- LINHA 5: Opções de Frequência Semanal ---
		contentPane.add(new JLabel("Frequência Semanal:"), "cell 1 5,alignx right");

		rb2x = new JRadioButton("2 vezes");
		rb3x = new JRadioButton("3 vezes");
		rb5x = new JRadioButton("5 vezes");

		// Adiciona ao grupo correspondente
		frequenciaGroup.add(rb2x);
		frequenciaGroup.add(rb3x);
		frequenciaGroup.add(rb5x);

		// Posiciona os Radio Buttons na linha 5
		contentPane.add(rb2x, "cell 2 5");
		contentPane.add(rb3x, "cell 5 5");
		contentPane.add(rb5x, "cell 8 5");

		// --- LINHA 7: Botão de Ação e Resultado ---
		JButton btnCalcular = new JButton("Calcular");
		contentPane.add(btnCalcular, "cell 2 7");

		contentPane.add(new JLabel("Valor Final:"), "cell 5 7");
		lblResultado = new JLabel("R$ 0,00");
		contentPane.add(lblResultado, "cell 6 7 3 1");

		// Define a ação que acontece quando o botão é clicado (chama o método abaixo)
		btnCalcular.addActionListener(e -> calcularMensalidade());
	}

	/**
	 * Regra de negócio: Realiza as validações dos campos e calcula o preço final da mensalidade.
	 */
	private void calcularMensalidade() {
		// Captura os textos e remove espaços extras nas pontas (.trim())
		String nome = textFieldNome.getText().trim();
		String telefone = textFieldTelefone.getText().trim();

		// Validação 1: Verifica se os campos de texto não estão vazios
		if (nome.isEmpty() || telefone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha nome e telefone.");
			return; // Interrompe a execução do método
		}

		// Validação 2: Verifica se o usuário selecionou uma opção em cada categoria de RadioButtons
		if (planoGroup.getSelection() == null || duracaoGroup.getSelection() == null || frequenciaGroup.getSelection() == null) {
			JOptionPane.showMessageDialog(this, "Selecione plano, duração e frequência.");
			return; // Interrompe a execução do método
		}

		double valorBase = 0;

		// 1. Define o valor inicial baseado no tipo do plano
		if (rbBasico.isSelected()) valorBase = 80.0;
		else if (rbIntermediario.isSelected()) valorBase = 120.0;
		else if (rbPremium.isSelected()) valorBase = 180.0;

		// 2. Aplica acréscimo de acordo com a frequência semanal escolhida
		if (rb3x.isSelected()) {
			valorBase *= 1.20; // +20% de acréscimo
		} else if (rb5x.isSelected()) {
			valorBase *= 1.50; // +50% de acréscimo
		}

		// 3. Aplica desconto proporcional ao tempo de contrato (fidelidade)
		if (rbSemestral.isSelected()) {
			valorBase *= 0.90; // 10% de desconto (paga 90% do valor)
		} else if (rbAnual.isSelected()) {
			valorBase *= 0.80; // 20% de desconto (paga 80% do valor)
		}

		// Formata o número final como moeda local brasileira (R$)
		NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		lblResultado.setText(moeda.format(valorBase)); // Atualiza o rótulo com o valor final formatado
	}
}
