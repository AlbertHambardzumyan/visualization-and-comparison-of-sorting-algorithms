package sorting_algorithms;

import animation_components.SortingThread;


public class QuickSort extends SortingThread {

    public QuickSort(int unsortedArray[]) {
        super(unsortedArray);
    }

    public void sort(int low, int high) throws InterruptedException {
        if (low < high) {
            int position = partition(low, high);

            int middle1 = position - 1;
            int middle2 = position + 1;
            sort(low, middle1);
            sort(middle2, high);
        }
        // if low >= high there is nothing to do
    }

    private int partition(int low, int high) {
        try {
            // For the simplicity, we took the left most item of the array as a pivot
            int pivot = array[low];
            int i = low + 1;
            for (int j = low + 1; j <= high; j++) {
                if (array[j] < pivot) {
                    swap(j, i);
                    i++;

                    hits++;
                    sleep(lag);
                } // if data[j] >= pivot do nothing
            }
            swap(low, i - 1);

            hits++;
            sleep(lag);
            return i - 1;

        } catch (InterruptedException ignored) {
        }
        return -1;
    }

    public void swap(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}

