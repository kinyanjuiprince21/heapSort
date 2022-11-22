import java.util.Random;

public class SortingTest {
    public static void main(String[] args) {
        long startTime, endTime;
        Random rand = new Random();
        int[] keys = new int[10000];
        int[] output1 = new int[10000];
        int[] output2 = new int[10000];
        // generate 5,000 - 50,000 random key values and assign them to keys[]
        for (int i = 0; i < 10000; i++) {
            keys[i] = rand.nextInt();
            output1[i] = keys[i];
            output2[i] = keys[i];
        }

        startTime = System.currentTimeMillis();
        heapSort(output1);
        endTime = System.currentTimeMillis();
        System.out.println("Heapsort takes: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        quickSort(output2);
        endTime = System.currentTimeMillis();
        System.out.println("Quicksort takes: " + (endTime - startTime) + " ms");

    }

    private static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    private static void heapSort(int[] items) {
        /* your implementation */

        int heap_size = items.length - 1;

        buildHeap(items);

        for(int i = (items.length - 1); i > 0; i--) {
            int temp = items[0];
            items[0] = items[i];
            items[i] = temp;

            heap_size = heap_size - 1;
            heapFy(items, 0, heap_size);
        }
    }

    //returns left child index of given index
    private static int leftChild(int child) {
        return (child * 2);
    }

    private static int rightChild(int child) {
        return (child * 2 + 1);
    }

    public static void heapFy(int[] items, int index, int heap_size) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if( left <= heap_size && items[left] > items[index]) {
            largest = left;
        }

        if(right <= heap_size && items[right] > items[largest]) {
            largest = right;
        }

        if(largest != index) {
            //exchanging items[index] with items[largest]
            int temp = items[index];
            items[index] = items[largest];
            items[largest] = temp;

            heapFy(items, largest, heap_size);
        }
    }

    private static void buildHeap(int[] items) {

        int heap_size = items.length - 1;

        for(int i = ((items.length - 1) / 2); i >= 0; i--) {
            heapFy(items,i,heap_size);
        }
    }


    private static void quickSort(int[] items) {
        /* your implementation */
        quickSort(items,0, items.length - 1);
    }

    public static void quickSort(int[] items,int first,int last) {
        if(last > first) {
            int pivotIndex = partition(items, first,last);
            quickSort(items, first, pivotIndex - 1);
            quickSort(items, pivotIndex + 1, last);
        }
    }

    public static int partition(int[] items, int first, int last) {
        int pivot = items[first];//choosing the first elements as the pivot
        int low = first + 1; //index for forward search
        int high = last; //index for backward search

        while(high > low) {
            //search forward from the left
            while(low <= high && items[low] <= pivot) {
                low++;
            }

            //search backward from right
            while(low <= high && items[high] > pivot) {
                high--;
            }

            //swapping two elements in the array
            if(high > low) {
                int temp = items[high];
                items[high] = items[low];
                items[low] = temp;
            }
        }

        while (high > first && items[high] >= pivot) {
            high--;
        }

        //swap pivot with items[high]
        if(pivot > items[high]) {
            items[first] = items[high];
            items[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}