package animation_components;

import java.awt.*;
import javax.swing.*;

public class ViewPanel extends JPanel implements Runnable {

    private int lag;
    private SortingThread sorter;

    ViewPanel(SortingThread sorter, Container c) {
        this.sorter = sorter;
        this.lag = sorter.getLag();

        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEtchedBorder());
        content.setLayout(new BorderLayout());

        JLabel label = new JLabel(sorter.getClass().getSimpleName(), JLabel.CENTER);
        label.setForeground(Color.GRAY);
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setFont(new Font("Serif", Font.ITALIC, 14));

        content.add(label, BorderLayout.NORTH);
        content.add(this, BorderLayout.CENTER);
        c.add(content);
    }

    void start() {
        sorter.start();
        (new Thread(this)).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, sorter.array.length, sorter.array.length);
        g.setColor(Color.RED);

        if (sorter.isSorted())
            g.setColor(Color.GREEN);

        int x0 = 0, y0 = sorter.array[0];
        for (int x = 1; x < sorter.array.length; x++) {
            g.drawLine(x0, y0, x, sorter.array[x]);
            x0 = x;
            y0 = sorter.array[x];
        }

        g.setColor(Color.BLUE);
        g.drawString(String.valueOf(sorter.hits), 170, 10);
    }

    public void run() {
        try {
            while (true) {
                repaint();
                Thread.sleep(lag);
            }
        } catch (InterruptedException ignored) {
        }
    }
}
