package sorting_algorithms;

import animation_components.SortingThread;


public class MergeSort extends SortingThread {

    public MergeSort(int[] unsortedArray) {
        super(unsortedArray);
    }

    public void sort(int from, int to) throws InterruptedException {
        if (from < to) {
            int mid1 = (from + to) / 2;
            int mid2 = 1 + mid1;
            sort(from, mid1);
            sort(mid2, to);
            merge(from, mid1, mid2, to);
        }
    }

    private void merge(int from, int mid1, int mid2, int to) throws InterruptedException {
        try {
            int index = from;
            int[] combined = new int[array.length];
            int firstLeft = from;
            int secondLeft = mid2;

            while (firstLeft <= mid1 && secondLeft <= to) {
                if (array[firstLeft] <= array[secondLeft])
                    combined[index++] = array[firstLeft++];
                else
                    combined[index++] = array[secondLeft++];
                hits++;
                sleep(lag);
            }
            while (firstLeft <= mid1) {
                combined[index++] = array[firstLeft++];
                hits++;
                sleep(lag);
            }
            while (secondLeft <= to) {
                combined[index++] = array[secondLeft++];
                hits++;
                sleep(lag);
            }
            System.arraycopy(combined, from, array, from, to + 1 - from);
        } catch (Exception ignored) {
        }
    }
}
