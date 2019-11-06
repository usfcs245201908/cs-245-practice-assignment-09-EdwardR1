public class BinaryHeap {
    int[] data;
    int size, maxSize;

    public BinaryHeap() {
        data = new int[10];
        size = 0;
        maxSize = 1;
    }

    private void grow() {
        int[] arr2 = new int[data.length * 2];
        int size = data.length;
        for (int i = 0; i < size; i++) {
            arr2[i] = data[i];
        }
        data = arr2;
    }

    public void add(int elem) {
        if(size == data.length){
            grow();
        }
        data[size++] = elem;
        maxSize++;
        int child = size - 1;
        int parent = (child - 1) / 2;
        if (parent >= 0) {
            while (data[parent] > data[child]) {
                swap(data, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }

    private void siftdown(int parent) {
        int child = parent * 2 + 1;
        if (child >= size) {
            return;
        }
        if (child + 1 < size && data[child + 1] < data[child]) {
            child++;
        }
        if (data[parent] > data[child]) {
            swap(data, child, parent);
            siftdown(child);
        }
    }

    public int remove()  {
        if(size == 0){
            return -1;
        }
        // if (size == 0) {
        //     throw new Exception("Heap is empty!");
        // }
        int removed = data[0];
        data[0] = data[--size];
        siftdown(0);
        return removed;
    }

    void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}