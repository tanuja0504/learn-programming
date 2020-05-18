package heap;

public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return pos * 2 + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int pos1, int pos2) {
        int tmp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = tmp;
    }

    public void heapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        int tmp = Heap[1];
        Heap[1] = size--;
        heapify(1);
        return tmp;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
    }
}
