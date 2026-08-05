package ch17;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

// Compile
// javac -d . UI.java PWPanel.java IDPanel.java CheckPanel.java ButtonPanel.java

// Run
// java ch17.UI

public class UI {
    void main() {
        JFrame frame = new JFrame("ログイン画面");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        IDPanel idpanel = new IDPanel();
        PWPanel pwpanel = new PWPanel();
        frame.add(idpanel);
        frame.add(pwpanel);
        frame.add(new CheckPanel(pwpanel));
        frame.add(new ButtonPanel(idpanel, pwpanel));

        frame.setVisible(true);
    }
}
