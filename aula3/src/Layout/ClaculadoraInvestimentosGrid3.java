package Layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClaculadoraInvestimentosGrid3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JButton btnCalcular;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel txtTotal;
	private JMenuBar menuAjuda;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClaculadoraInvestimentosGrid3 frame = new ClaculadoraInvestimentosGrid3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClaculadoraInvestimentosGrid3() {
		
   
		setTitle("CalcInvest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuAjuda = new JMenuBar();
		setJMenuBar(menuAjuda);
		
		mnNewMenu = new JMenu("Ajuda");
		menuAjuda.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Sobre");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FormSobre().setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Depósito Mensal R$:");
		panel_2.add(lblNewLabel);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Num. de Meses:");
		panel_4.add(lblNewLabel_1);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Juros ao Mês %:");
		panel_6.add(lblNewLabel_2);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		textField_3 = new JTextField();
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		lblNewLabel_3 = new JLabel("Total Investido + Juros R$:");
		panel_8.add(lblNewLabel_3);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		txtTotal = new JLabel("");
		panel_1.add(txtTotal);
		
		panel = new JPanel();
		contentPane.add(panel);
		
		panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		btnCalcular = new JButton("Calcular\r\n");
		
		btnCalcular.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {

		        double deposito = Double.parseDouble(textField_1.getText());
		        double meses = Integer.parseInt(textField_2.getText());
		        double juros = Double.parseDouble(textField_3.getText());

		        Investimento investimento = new Investimento(meses, juros, deposito);

		        double total = investimento.calculaTotal();

		        txtTotal.setText(String.format("%.2f", total));
		    }
		});
		
		panel_9.add(btnCalcular);
		btnCalcular.setForeground(new Color(0, 0, 0));
		btnCalcular.setBackground(new Color(0, 128, 255));

	}

}
