import javax.swing.*;

public class MyFrame extends JFrame{

    private int level;
    MyPanel panel;

    public MyFrame(int level){

        this.level = level;
        panel = new MyPanel(level);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
