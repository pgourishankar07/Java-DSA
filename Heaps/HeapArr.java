import java.util.ArrayList;

public class HeapArr {

    static class MinHeap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int num) {
            heap.add(num);

            int nodeIdx = heap.size() - 1;
            int parentIdx = (nodeIdx - 1) / 2;

            // change of sign(for maxHeap)
            while (heap.get(nodeIdx) < heap.get(parentIdx)) { // if parent is big in minHeap
                // swap
                int temp = heap.get(nodeIdx);
                heap.set(nodeIdx, heap.get(parentIdx));
                heap.set(parentIdx, temp);

                nodeIdx = parentIdx;
                parentIdx = (nodeIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        private void heapify(int i) {
            int node = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < heap.size() && heap.get(node) > heap.get(left)) {// change of sign
                node = left;
            }
            if (right < heap.size() && heap.get(node) > heap.get(right)) {// change of sign
                node = right;
            }

            if (node != i) { // if thier is a change then swap
                int temp = heap.get(i);
                heap.set(i, heap.get(node));
                heap.set(node, temp);

                // call for next further check
                heapify(node);

            }
        }

        public int remove() {
            int data = heap.get(0);
            // swap the 1st and last node
            heap.set(0, heap.get(heap.size() - 1));
            // remove the last node
            heap.remove(heap.size() - 1);
            // heapify
            heapify(0);

            return data;

        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }
    }

    public static void main(String args[]) {
        MinHeap h = new MinHeap();
        h.add(2);
        h.add(1);
        h.add(4);
        h.add(3);

        while (!h.isEmpty()) {
            System.out.println(h.remove());
        }
    }
}
