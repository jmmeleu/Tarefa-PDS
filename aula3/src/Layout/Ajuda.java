package Layout;

import javax.swing.*;

public class Ajuda {

    public static JMenu criarMenu() {

        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");

        itemSobre.addActionListener(e -> {
            FormSobre telaSobre = new FormSobre();
            telaSobre.setVisible(true);
        });

        menuAjuda.add(itemSobre);

        return menuAjuda;
    }
}