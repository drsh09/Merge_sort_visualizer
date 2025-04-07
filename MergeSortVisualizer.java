import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MergeSortVisualizer extends JPanel implements KeyListener {
    private static final int WIDTH = 900, HEIGHT = 650, NUM_BARS = 120;
    private final int[] array = new int[NUM_BARS];
    private final Color[] colors = new Color[NUM_BARS];

    private final Color DEFAULT = new Color(0, 204, 102);
    private final Color COMPARE = new Color(255, 87, 34);
    private final Color SWAP = new Color(3, 169, 244);
    private final Color SORTED = new Color(139, 195, 74);
    private final Color FINAL = new Color(156, 39, 176);

    private boolean sorting = false;

    public MergeSortVisualizer() {
        generateArray();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(245, 245, 245));
        setFocusable(true);
        addKeyListener(this);
    }

    public void generateArray() {
        Random rand = new Random();
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = rand.nextInt(91) + 10;
            colors[i] = DEFAULT;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(33, 33, 33));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Merge Sort Visualizer", 30, 30);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.setColor(new Color(80, 80, 80));
        g.drawString("Press ENTER to sort | Press R to reset", 30, 55);

        int barWidth = WIDTH / NUM_BARS;
        for (int i = 0; i < NUM_BARS; i++) {
            int barHeight = array[i] * 5;
            g.setColor(colors[i]);
            g.fillRoundRect(i * barWidth, HEIGHT - barHeight, barWidth - 2, barHeight, 5, 5);
        }
    }

    public void mergeSort(int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, mid, end);
    }

    public void merge(int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) left[i] = array[start + i];
        for (int i = 0; i < right.length; i++) right[i] = array[mid + 1 + i];

        int i = 0, j = 0, k = start;

        while (i < left.length && j < right.length) {
            colors[k] = COMPARE;
            repaint();
            sleep(15);
            if (left[i] <= right[j]) {
                array[k] = left[i++];
            } else {
                array[k] = right[j++];
            }
            colors[k] = SWAP;
            repaint();
            sleep(10);
            colors[k] = DEFAULT;
            k++;
        }

        while (i < left.length) {
            array[k] = left[i++];
            colors[k] = SWAP;
            repaint();
            sleep(10);
            colors[k] = DEFAULT;
            k++;
        }

        while (j < right.length) {
            array[k] = right[j++];
            colors[k] = SWAP;
            repaint();
            sleep(10);
            colors[k] = DEFAULT;
            k++;
        }

        for (int x = start; x <= end; x++) {
            colors[x] = SORTED;
            repaint();
            sleep(5);
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            sorting = false;
            generateArray();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && !sorting) {
            sorting = true;
            new Thread(() -> {
                mergeSort(0, NUM_BARS - 1);
                for (int i = 0; i < NUM_BARS; i++) {
                    colors[i] = FINAL;
                    repaint();
                    sleep(4);
                }
            }).start();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Merge Sort Visualizer - Java");
        MergeSortVisualizer visualizer = new MergeSortVisualizer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(visualizer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
