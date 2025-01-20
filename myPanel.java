import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{

    Image image;
    Image garden;
    Image forest;
    Image end;

    private int level;

    public MyPanel(int level){
        this.setPreferredSize(new Dimension(500,500));
        this.level = level;

        image = new ImageIcon("src/garden.png").getImage();
        forest = new ImageIcon("src/scene2.png").getImage();
        end = new ImageIcon("src/scene3.png").getImage();


    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (level == 1) {

            //image = new ImageIcon("garden.png").getImage();

            Graphics2D g2D = (Graphics2D) g;

            int x = (getWidth() - image.getWidth(null))/2;
            int y = (getHeight() - image.getHeight(null))/2;

            g2D.drawImage(image, x, y, this);


            //g2D.setPaint(Color.blue);
            //g2D.setStroke(new BasicStroke(5));
            //g2D.drawLine(0, 0, 500, 500);

            //g2D.setPaint(Color.pink);
            //g2D.drawRect(0, 0, 100, 200);
            //g2D.fillRect(0, 0, 100, 200);

            //g2D.setPaint(Color.orange);
            //g2D.drawOval(0, 0, 100, 100);
            //g2D.fillOval(0, 0, 100, 100);

            //g2D.setPaint(Color.red);
            //g2D.drawArc(0, 0, 100, 100, 0, 180);
            //g2D.fillArc(0, 0, 100, 100, 0, 180);
            //g2D.setPaint(Color.white);
            //g2D.fillArc(0, 0, 100, 100, 180, 180);

            //int[] xPoints = {150,250,350};
            //int[] yPoints = {300,150,300};
            //g2D.setPaint(Color.yellow);
            //g2D.drawPolygon(xPoints, yPoints, 3);
            //g2D.fillPolygon(xPoints, yPoints, 3);

            //g2D.setPaint(Color.magenta);
            //g2D.setFont(new Font("Ink Free",Font.BOLD,50));
            //g2D.drawString("U R A WINNER! :D", 50, 50);
        } else if (level == 2) {


            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(forest, 0, 0, null);

            //g2D.setPaint(Color.blue);
            //g2D.setStroke(new BasicStroke(5));
            //g2D.drawLine(0, 0, 500, 500);

            //g2D.setPaint(Color.pink);
            //g2D.drawRect(0, 0, 100, 200);
            //g2D.fillRect(0, 0, 100, 200);

            //g2D.setPaint(Color.orange);
            //g2D.drawOval(0, 0, 100, 100);
            //g2D.fillOval(0, 0, 100, 100);

            //g2D.setPaint(Color.red);
            //g2D.drawArc(0, 0, 100, 100, 0, 180);
            //g2D.fillArc(0, 0, 100, 100, 0, 180);
            //g2D.setPaint(Color.white);
            //g2D.fillArc(0, 0, 100, 100, 180, 180);

            //int[] xPoints = {150,250,350};
            //int[] yPoints = {300,150,300};
            //g2D.setPaint(Color.yellow);
            //g2D.drawPolygon(xPoints, yPoints, 3);
            //g2D.fillPolygon(xPoints, yPoints, 3);

            //g2D.setPaint(Color.magenta);
            //g2D.setFont(new Font("Ink Free",Font.BOLD,50));
            //g2D.drawString("U R A WINNER! :D", 50, 50);
        } else if (level == 3) {


            Graphics2D g2D = (Graphics2D) g;
            g2D.drawImage(end, 0, 0, null);

            //g2D.setPaint(Color.blue);
            //g2D.setStroke(new BasicStroke(5));
            //g2D.drawLine(0, 0, 500, 500);

            //g2D.setPaint(Color.pink);
            //g2D.drawRect(0, 0, 100, 200);
            //g2D.fillRect(0, 0, 100, 200);

            //g2D.setPaint(Color.orange);
            //g2D.drawOval(0, 0, 100, 100);
            //g2D.fillOval(0, 0, 100, 100);

            /*g2D.setPaint(Color.red);
            g2D.drawArc(0, 0, 100, 100, 0, 180);
            g2D.fillArc(0, 0, 100, 100, 0, 180);
            g2D.setPaint(Color.white);
            g2D.fillArc(0, 0, 100, 100, 180, 180);
            */
            //int[] xPoints = {150,250,350};
            //int[] yPoints = {300,150,300};
            //g2D.setPaint(Color.yellow);
            //g2D.drawPolygon(xPoints, yPoints, 3);
            //g2D.fillPolygon(xPoints, yPoints, 3);

            //g2D.setPaint(Color.magenta);
            //g2D.setFont(new Font("Ink Free",Font.BOLD,50));
            //g2D.drawString("U R A WINNER! :D", 50, 50);
        }
    }
}
