package week11;

/**
 * A Heap sort implementation which is able to be observed through its
 * Sorter superclass.
 * @author Nathan Laing
 */
public class HeapSort extends Sorter {

    /**
     * Create a new HeapSort sorter with the given integers to sort.
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }
    
    /**
     * Builds heap. 
     */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;

        for(int i = n / 2 - 1; i >= 0; i--){
            comparisons++;
            heapify(nums.length, i);
        }
        for(int i = n -1; i >= 0; i--){
            comparisons++;
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            update();

            heapify(i, 0);
        }
    }
    
    /**
     * The recursive HeapSort method.
     * @param n the size of the heap
     * @param i is the root node
     */
    public void heapify(int n, int i){
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < n && nums[l] > nums[largest]){
            comparisons+=2;
            largest = l;
            update();
        }
        if(r < n && nums[r] > nums[largest]){
            comparisons+=2;
            largest = r;
            update();
        }
        if(largest != i){
            comparisons++;
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            update();

            heapify(n, largest);
        }
    }
}
