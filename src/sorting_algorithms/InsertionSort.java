package sorting_algorithms;

import animation_components.SortingThread;

public class InsertionSort extends SortingThread {

    public InsertionSort(int unsortedArray[]) {
        super(unsortedArray);
    }

    public void sort(int from, int to) throws InterruptedException {
        for (int unsorted = from + 1; unsorted < to; unsorted++)
            for (int sorted = unsorted - 1; sorted >= 0 && array[sorted] > array[sorted + 1]; sorted--) {
                swap(sorted, sorted + 1);

                hits++;
                sleep(lag);
            }
    }
}
