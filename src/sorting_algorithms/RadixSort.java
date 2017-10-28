package sorting_algorithms;

import animation_components.SortingThread;

import java.util.LinkedList;

public class RadixSort extends SortingThread {

    public RadixSort(int unsortedArray[]) {
        super(unsortedArray);
    }

    public void sort(int from, int to) throws InterruptedException {
        try {

            LinkedList<Integer>[] buckets = new LinkedList[10];
            // Make sure the list is initialized before adding to it
            for (int i = 0; i < buckets.length; i++)
                buckets[i] = new LinkedList<>();

            int placement = 1;
            for (int i = 3; i >= 1; i--) {

                // split input between lists
                for (int number : array) {
                    int k = number / placement;
                    buckets[k % 10].add(number);

                    hits++;
                    sleep(lag);
                }

                // empty lists into data array
                int index = 0;
                for (LinkedList<Integer> bucket : buckets) {
                    for (Integer number : bucket) {
                        array[index++] = number;
                    }
                    bucket.clear();
                }

                // move to next digit
                placement *= 10;
            }
            flag = true;

        } catch (Exception ignored) {
        }
    }
}

