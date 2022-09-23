import java.awt.*;
import javax.swing.*;
public class BarDisplay {
    private JFrame jf;
    private DrawFrame df;
    private int width;
    private int height;
    private int amt;
    private int[] values;
    private String[] names;
    private Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
    private Color barColor;
    /**
     * Constructs a BarDisplay.
     * @param width - Width of the outputted window
     * @param height - Height of the outputted window
     * @param name - Name of the outputted window
     * @param amt - Amount of bars to display
     * @param names - Names of those bars, in order
     */
    public BarDisplay(int width, int height, String name, int amt, String... names) {
        this.width = width;
        this.height = height;
        this.amt = amt;
        this.names = names;
        this.values = new int[amt];
        this.barColor = Color.BLACK;
        jf = new JFrame(name);
        jf.setResizable(false);
        df = new DrawFrame();
        df.setPreferredSize(new Dimension(width, height));
        jf.getContentPane().add(df);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        jf.pack();
        df.repaint();
    }
    /**
     * Constructs a BarDisplay with a custom bar color.
     * @param width - Width of the outputted window
     * @param height - Height of the outputted window
     * @param name - Name of the outputted window
     * @param amt - Amount of bars to display
     * @param barColor - Color of the bars
     * @param names - Names of those bars, in order
     */
    public BarDisplay(int width, int height, String name, int amt, Color barColor, String... names) {
        this(width, height, name, amt, names);
        this.barColor = barColor;
    }
    /**
     * Updates the values displayed.
     * @param values - The values to display next to the names and to size the bars with
     */
    public void updateValues(int... values) {
        this.values = values;
        df.repaint();
    }
    public class DrawFrame extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            FontMetrics fm = g.getFontMetrics(font);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawLine(0, height - fm.getHeight() - 10, width, height - fm.getHeight() - 10);
            int colWidth = width/amt;
            int max = 0;
            int maxLineWidth = 1;
            for(int i = 0; i < amt; i++) {
                if(values[i] > max) max = values[i];
                if(fm.stringWidth(names[i] + ": " + values[i]) > maxLineWidth) maxLineWidth = fm.stringWidth(names[i] + ": " + values[i]);
            }
            if(maxLineWidth > colWidth) {
                font = new Font(Font.SANS_SERIF, Font.PLAIN, (int)(20 * (float)colWidth / maxLineWidth));
                this.repaint();
                return;
            }
            for(int i = 0; i < amt; i++) {
                g.setColor(Color.BLACK);
                g.drawString(names[i] + ": " + values[i], colWidth * i + (colWidth - fm.stringWidth(names[i] + ": " + values[i])) / 2, height - fm.getHeight() / 2);
                g.setColor(barColor);
                if(max != 0) g.fillRect(colWidth / 4 + colWidth * i, (int)((float)height - fm.getHeight() - 10 - (float)values[i] / max * (height - fm.getHeight() - 20)), colWidth / 2, (int)((float)values[i] / max * (height - fm.getHeight() - 20)));
            }
        }
    }
}