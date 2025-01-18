import javax.swing.*;

public class MyFrame extends JFrame{

    MyPanel panel;

    MyFrame(){

        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
