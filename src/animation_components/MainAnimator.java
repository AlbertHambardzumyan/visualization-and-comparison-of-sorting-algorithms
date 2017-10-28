package animation_components;

import sorting_algorithms.*;

import java.awt.*;
import javax.swing.*;

public class MainAnimator extends JFrame {

    public MainAnimator() {
        super("Visualization and Comparison of Sorting Algorithms");
        setLayout(new GridLayout(2, 3));

        int size = 200;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * array.length);

        (new ViewPanel(new MergeSort(array), this)).start();
        (new ViewPanel(new QuickSort(array), this)).start();
        (new ViewPanel(new RadixSort(array), this)).start();
        (new ViewPanel(new InsertionSort(array), this)).start();
        (new ViewPanel(new SelectionSort(array), this)).start();
        (new ViewPanel(new BubbleSort(array), this)).start();

        setSize(3 * (size + 5), 2 * (size + 30));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
