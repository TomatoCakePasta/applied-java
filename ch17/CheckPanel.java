package ch17;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckPanel extends JPanel {
    JCheckBox check = new JCheckBox("パスワードを表示する");

    public CheckPanel(PWPanel pwpanel) {
        this.setLayout(new BorderLayout());
        this.add(check, BorderLayout.WEST);
        check.addChangeListener(e -> {
            if (check.isSelected()) {
                pwpanel.showText();
            } else {
                pwpanel.hideText();
            }
        });
    }
}
