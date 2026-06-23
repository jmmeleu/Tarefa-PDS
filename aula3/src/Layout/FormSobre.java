package Layout;

import javax.swing.*;
import java.awt.*;

public class FormSobre extends JFrame {
	public FormSobre() {
		setTitle("Sobre o CalcInvest");
        setSize(300, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
       
        JLabel lblTexto = new JLabel(
            "<html>CalcInvest - Calculadora de Investimentos<br><br>" +
            "Versão 1.0<br>" +
            "Autor: João Marcelo Meleu<br><br>" +
            "Contato: joao.mtm@aluno.ifsc.edu.br</html>"
        );
        lblTexto.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> dispose());

        JPanel painelBotao = new JPanel();
        painelBotao.add(btnOk);

        getContentPane().add(lblTexto, BorderLayout.CENTER);
        getContentPane().add(painelBotao, BorderLayout.SOUTH);
	}
}
