package sorting_algorithms;

import animation_components.SortingThread;


public class SelectionSort extends SortingThread {

    public SelectionSort(int unsortedArray[]) {
        super(unsortedArray);
    }

    public void sort(int from, int to) throws InterruptedException {

        for (int i = from; i < to; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) index = j;

                hits++;
                sleep(lag);
            }

            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }
}
