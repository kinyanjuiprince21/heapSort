

public class HeapPQueue implements PQueue{

    private static int[] list;
    private int size = -1;


    public HeapPQueue(int[] items) {
        //your implementation
        bottom_up(items);
    }
    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void insert(int key) {
        size = size + 1;
        list[size] = key;

        //heaping up to maintain
        //heap property
        heapup(size);
    }

    @Override
    public int min() {
        int result = list[0];

        list[0] = list[size];
        size = size - 1;

        heapdown(0);
        return result;
    }

    @Override
    public int removeMin() {
        heapdown(0);
        return min();
    }

    private void bottom_up(int[] items) {
    // your impelementation
    // invoke this method when you construct a heap given an array of keys

        int startIndex = (items.length / 2) - 1;

        //Performing reverse level order traversal
        for(int i = startIndex; i >= 0; i--) {
            heapFy(items, i);
        }
    }
    private void heapdown(int i) {
    // your impelementation
    // invoke this method when you remove the key of the highest priority

        int maxIndex = i;

        int left = leftChild(i);

        if(left <= size && list[left] > list[maxIndex]) {
            maxIndex = left;
        }

        int right = rightChild(i);

        if(right <= size && list[right] > list[maxIndex]) {
            maxIndex = right;
        }

        if(i != maxIndex) {
            swap(i, maxIndex);
            heapdown(maxIndex);
        }
    }
    private void heapup(int i) {
    // your impelementation
    // invoke this method when you insert a new key into this heap

        while(i > 0 && list[parent(i)] < list[i]) {
            //swapping parent node and current node
            swap(parent(i), i);

            //update i to parent of i
            i = parent(i);
        }
    }

    //Returns the index of the parent node of the given node
    public int parent(int index) {
        return (index - 1) / 2;
    }

    //Returns the index of the left child of the given node
    private int leftChild(int index) {
        return ((2 * index) + 1);
    }

    //Returns the index of the right child of the given node
    private int rightChild(int index) {
        return ((2 * index) + 2);
    }

    private void swap(int k, int j) {
        int temp = list[k];
        list[k] = list[j];
        list[j] = temp;
    }

    public void heapFy(int[] items, int root) {
        int largest = root; //initializing largest as root
        int left = leftChild(root);
        int right = rightChild(root);

        if (left < items.length && items[left] > items[largest])
            largest = left;

        if(right < items.length && items[right] > items[largest])
            largest = right;

        if(largest != root) {
            int temp = items[root];
            items[root] = items[largest];
            items[largest] = temp;

            heapFy(items, largest);
        }
    }



    public static void main(String[] args) {

        list = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
//        list = new int[]{};
        HeapPQueue queue = new HeapPQueue(list);

        System.out.print("Priority Queue : ");



//        queue.insert(23);
//        queue.insert(33);
//        queue.insert(47);

//        for(int i = 0; i < list.length; ++i) {
//            System.out.print(list[i] + " ");
//        }

//        System.out.println("\n");
//        System.out.println();
//        System.out.println(queue.size());
//        System.out.println();
//        System.out.println(queue.isEmpty());
//        System.out.println();
//        System.out.println(queue.min());
//        System.out.println();
//        System.out.println(queue.removeMin());
//
//        for(int i = 0; i < list.length; ++i) {
//            System.out.print(list[i] + " ");
//        }

    }

}
