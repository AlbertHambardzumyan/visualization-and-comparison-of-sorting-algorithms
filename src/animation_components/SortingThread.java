package animation_components;

public abstract class SortingThread extends Thread {

    protected int array[], lag = 50;
    protected boolean flag = false;
    protected int hits = 0;

    public SortingThread(int unsortedArray[]) {
        array = unsortedArray.clone();
    }

    public void run() {
        try {
            sort(0, array.length - 1);

            flag = true;
        } catch (InterruptedException ignored) {
        }
    }

    public abstract void sort(int from, int to) throws InterruptedException;

    protected void swap(int from, int to) {
        array[from] += array[to];
        array[to] = array[from] - array[to];
        array[from] -= array[to];
    }

    boolean isSorted() { //new
        return this.flag;
    }

    int getLag() {
        return this.lag;
    }
}
