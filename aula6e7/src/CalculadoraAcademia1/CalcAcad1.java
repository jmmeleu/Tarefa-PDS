package CalculadoraAcademia1;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

// ============================================================================
// DEFINIÇÃO DOS ENUMS (Enumerações)
// Os enums são usados para criar conjuntos fixos de constantes.
// Isso garante que o usuário ou programador só possa escolher opções válidas,
// além de facilitar a criação das listas suspensas (JComboBox).
// ============================================================================

/**
 * Enum para os tipos de plano disponíveis.
 */
enum TipoPlano {
    SELECIONE("Selecione..."), // Opção padrão para forçar o usuário a escolher algo
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    PREMIUM("Premium");

    private final String descricao;

    // Construtor do Enum para associar a string descritiva à constante
    TipoPlano(String descricao) {
        this.descricao = descricao;
    }

    // Sobrescreve o método toString para que o JComboBox exiba o texto formatado (ex: "Básico")
    // em vez do nome da constante (ex: "BASICO")
    @Override
    public String toString() {
        return this.descricao;
    }
}

/**
 * Enum para as durações de contrato disponíveis.
 */
enum DuracaoPlano {
    SELECIONE("Selecione..."),
    MENSAL("Mensal"),
    SEMESTRAL("Semestral"),
    ANUAL("Anual");

    private final String descricao;

    DuracaoPlano(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}

/**
 * Enum para as frequências semanais de treino.
 */
enum FrequenciaPlano {
    SELECIONE("Selecione..."),
    VEZES_2("2 vezes"),
    VEZES_3("3 vezes"),
    VEZES_5("5 vezes");

    private final String descricao;

    FrequenciaPlano(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}

// ============================================================================
// CLASSE PRINCIPAL DA INTERFACE GRÁFICA
// ============================================================================

public class CalcAcad1 extends JFrame {

	private static final long serialVersionUID = 1L;

	// Componentes estruturais e de entrada de texto
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;

	// JComboBox: Listas suspensas tipadas com os Enums criados acima.
	// O uso de <TipoPlano> restringe o componente a aceitar apenas itens daquele Enum.
	private JComboBox<TipoPlano> cbPlano;
	private JComboBox<DuracaoPlano> cbDuracao;
	private JComboBox<FrequenciaPlano> cbFrequencia;

	// Rótulo para exibir o valor final calculado
	private JLabel lblResultado;

	/**
	 * Ponto de entrada (Main). Inicia a tela na thread correta do Swing.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CalcAcad1 frame = new CalcAcad1();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Construtor: Onde a interface visual (GUI) é montada.
	 */
	public CalcAcad1() {
		// Configurações básicas da janela principal
		setTitle("Calculadora de Mensalidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 365);

		// Configuração do Painel (Container) e suas bordas
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		
		// Define o MigLayout com colunas [] e linhas []. 
		// O 'grow' permite que certas colunas se expandam caso a janela seja redimensionada.
		contentPane.setLayout(new MigLayout("", "[][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[][][][][][][][][]"));

		// --- TÍTULO (Linha 0) ---
		JLabel titulo = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(titulo, "cell 0 0 12 1,alignx center"); // Ocupa a célula coluna 0, linha 0, expande por 12 colunas e 1 linha.

		// --- DADOS PESSOAIS (Linhas 1 e 2) ---
		contentPane.add(new JLabel("Nome:"), "cell 0 1 2 1,alignx right");
		textFieldNome = new JTextField();
		contentPane.add(textFieldNome, "cell 2 1 4 1,growx");

		contentPane.add(new JLabel("Telefone:"), "cell 0 2 2 1,alignx right");
		textFieldTelefone = new JTextField();
		contentPane.add(textFieldTelefone, "cell 2 2 4 1,growx");

		// --- COMBOBOX: PLANO (Linha 3) ---
		contentPane.add(new JLabel("Tipo do Plano:"), "cell 1 3,alignx right");
		// Inicializa o ComboBox chamando TipoPlano.values(), que retorna um array com todas as opções do enum
		cbPlano = new JComboBox<>(TipoPlano.values());
		contentPane.add(cbPlano, "cell 2 3 4 1,growx");

		// --- COMBOBOX: DURAÇÃO (Linha 4) ---
		contentPane.add(new JLabel("Duração:"), "cell 1 4,alignx right");
		cbDuracao = new JComboBox<>(DuracaoPlano.values());
		contentPane.add(cbDuracao, "cell 2 4 4 1,growx");

		// --- COMBOBOX: FREQUÊNCIA (Linha 5) ---
		contentPane.add(new JLabel("Frequência Semanal:"), "cell 1 5,alignx right");
		cbFrequencia = new JComboBox<>(FrequenciaPlano.values());
		contentPane.add(cbFrequencia, "cell 2 5 4 1,growx");

		// --- BOTÃO E RESULTADO (Linha 7) ---
		JButton btnCalcular = new JButton("Calcular");
		contentPane.add(btnCalcular, "cell 2 7");

		contentPane.add(new JLabel("Valor Final:"), "cell 5 7");
		lblResultado = new JLabel("R$ 0,00");
		contentPane.add(lblResultado, "cell 6 7 3 1");

		// Criação do Evento: Quando o botão for clicado, executa o método calcularMensalidade()
		btnCalcular.addActionListener(e -> calcularMensalidade());
	}

	/**
	 * Método responsável por validar as entradas e calcular o valor final.
	 */
	private void calcularMensalidade() {
		// Pega os textos, removendo os espaços em branco nas extremidades (.trim())
		String nome = textFieldNome.getText().trim();
		String telefone = textFieldTelefone.getText().trim();

		// Validação 1: Checa se os campos de texto estão vazios
		if (nome.isEmpty() || telefone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha nome e telefone.");
			return; // Sai do método prematuramente se houver erro
		}

		// Extrai o valor que está selecionado nos ComboBoxes no momento do clique.
		// O (TipoPlano) faz um "cast" garantindo que o objeto retornado seja tratado como o Enum correto.
		TipoPlano planoSelecionado = (TipoPlano) cbPlano.getSelectedItem();
		DuracaoPlano duracaoSelecionada = (DuracaoPlano) cbDuracao.getSelectedItem();
		FrequenciaPlano frequenciaSelecionada = (FrequenciaPlano) cbFrequencia.getSelectedItem();

		// Validação 2: Verifica se o usuário deixou alguma caixa na opção "Selecione..."
		if (planoSelecionado == TipoPlano.SELECIONE || duracaoSelecionada == DuracaoPlano.SELECIONE || frequenciaSelecionada == FrequenciaPlano.SELECIONE) {
			JOptionPane.showMessageDialog(this, "Selecione plano, duração e frequência.");
			return; // Sai do método prematuramente se houver erro
		}

		double valorBase = 0;

		// 1. Usa um SWITCH (muito eficiente com enums) para definir o preço base segundo o plano
		switch (planoSelecionado) {
			case BASICO:
				valorBase = 80.0;
				break;
			case INTERMEDIARIO:
				valorBase = 120.0;
				break;
			case PREMIUM:
				valorBase = 180.0;
				break;
			default:
				break;
		}

		// 2. Aplica o multiplicador de preço com base na frequência da academia
		if (frequenciaSelecionada == FrequenciaPlano.VEZES_3) {
			valorBase *= 1.20; // Aumento de 20%
		} else if (frequenciaSelecionada == FrequenciaPlano.VEZES_5) {
			valorBase *= 1.50; // Aumento de 50%
		}

		// 3. Aplica o desconto baseado na fidelidade/duração do contrato
		if (duracaoSelecionada == DuracaoPlano.SEMESTRAL) {
			valorBase *= 0.90; // Desconto de 10% (fica 90% do valor)
		} else if (duracaoSelecionada == DuracaoPlano.ANUAL) {
			valorBase *= 0.80; // Desconto de 20% (fica 80% do valor)
		}

		// 4. Formata o número (Double) final para o formato de Dinheiro do Brasil (R$ XX,XX)
		NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		lblResultado.setText(moeda.format(valorBase)); // Atualiza o JLabel na tela
	}
}
