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

enum TipoPlano {
    SELECIONE("Selecione..."),
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    PREMIUM("Premium");

    private final String descricao;

    TipoPlano(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}

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

public class CalcAcad1 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;

	private JComboBox<TipoPlano> cbPlano;
	private JComboBox<DuracaoPlano> cbDuracao;
	private JComboBox<FrequenciaPlano> cbFrequencia;

	private JLabel lblResultado;

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

	public CalcAcad1() {
		setTitle("Calculadora de Mensalidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 365);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[][][][][][][][][]"));

		JLabel titulo = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(titulo, "cell 0 0 12 1,alignx center");

		contentPane.add(new JLabel("Nome:"), "cell 0 1 2 1,alignx right");
		textFieldNome = new JTextField();
		contentPane.add(textFieldNome, "cell 2 1 4 1,growx");

		contentPane.add(new JLabel("Telefone:"), "cell 0 2 2 1,alignx right");
		textFieldTelefone = new JTextField();
		contentPane.add(textFieldTelefone, "cell 2 2 4 1,growx");

		contentPane.add(new JLabel("Tipo do Plano:"), "cell 1 3,alignx right");
		cbPlano = new JComboBox<>(TipoPlano.values());
		contentPane.add(cbPlano, "cell 2 3 4 1,growx");

		contentPane.add(new JLabel("Duração:"), "cell 1 4,alignx right");
		cbDuracao = new JComboBox<>(DuracaoPlano.values());
		contentPane.add(cbDuracao, "cell 2 4 4 1,growx");

		contentPane.add(new JLabel("Frequência Semanal:"), "cell 1 5,alignx right");
		cbFrequencia = new JComboBox<>(FrequenciaPlano.values());
		contentPane.add(cbFrequencia, "cell 2 5 4 1,growx");

		JButton btnCalcular = new JButton("Calcular");
		contentPane.add(btnCalcular, "cell 2 7");

		contentPane.add(new JLabel("Valor Final:"), "cell 5 7");
		lblResultado = new JLabel("R$ 0,00");
		contentPane.add(lblResultado, "cell 6 7 3 1");

		btnCalcular.addActionListener(e -> calcularMensalidade());
	}

	private void calcularMensalidade() {
		String nome = textFieldNome.getText().trim();
		String telefone = textFieldTelefone.getText().trim();

		if (nome.isEmpty() || telefone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha nome e telefone.");
			return;
		}

		TipoPlano planoSelecionado = (TipoPlano) cbPlano.getSelectedItem();
		DuracaoPlano duracaoSelecionada = (DuracaoPlano) cbDuracao.getSelectedItem();
		FrequenciaPlano frequenciaSelecionada = (FrequenciaPlano) cbFrequencia.getSelectedItem();

		if (planoSelecionado == TipoPlano.SELECIONE || duracaoSelecionada == DuracaoPlano.SELECIONE || frequenciaSelecionada == FrequenciaPlano.SELECIONE) {
			JOptionPane.showMessageDialog(this, "Selecione plano, duração e frequência.");
			return;
		}

		double valorBase = 0;

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

		if (frequenciaSelecionada == FrequenciaPlano.VEZES_3) {
			valorBase *= 1.20;
		} else if (frequenciaSelecionada == FrequenciaPlano.VEZES_5) {
			valorBase *= 1.50;
		}

		if (duracaoSelecionada == DuracaoPlano.SEMESTRAL) {
			valorBase *= 0.90;
		} else if (duracaoSelecionada == DuracaoPlano.ANUAL) {
			valorBase *= 0.80;
		}

		NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		lblResultado.setText(moeda.format(valorBase));
	}
}