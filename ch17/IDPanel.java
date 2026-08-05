package ch17;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IDPanel extends JPanel {
    JLabel label = new JLabel("ユーザID");
    JTextField id = new JTextField();

    public IDPanel() {
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.WEST);
        this.add(id, BorderLayout.CENTER);
    }

    public String getText() {
        return this.id.getText();
    }

    public void setText(String newValue) {
        this.id.setText(newValue);
    }
}
