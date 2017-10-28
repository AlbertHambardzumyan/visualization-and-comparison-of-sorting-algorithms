package sorting_algorithms;

import animation_components.SortingThread;


public class BubbleSort extends SortingThread {

    public BubbleSort(int unsortedArray[]) {
        super(unsortedArray);
    }

    public void sort(int from, int to) throws InterruptedException {

        for (int i = from; i < to - 1; i++) {
            for (int j = from; j < to - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);

                    hits++;
                    sleep(lag);
                }
            }
        }
    }
}
