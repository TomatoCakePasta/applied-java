package ch17;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    JButton login = new JButton("ログイン");
    JButton clear = new JButton("クリア");

    public ButtonPanel(IDPanel idpanel, PWPanel pwpanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        login.addActionListener(e -> {
            String id = idpanel.getText();
            String pw = pwpanel.getText();
            if (id.equals("sato") && pw.equals("pass")) {
                JOptionPane.showMessageDialog(this, "ログインに成功しました", "ログイン成功", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "ログインに失敗しました", "ログイン失敗", JOptionPane.ERROR_MESSAGE);
            }
        });

        clear.addActionListener(e -> {
            idpanel.setText("");
            pwpanel.setText("");
        });
        this.add(login);
        this.add(clear);
    }
}
