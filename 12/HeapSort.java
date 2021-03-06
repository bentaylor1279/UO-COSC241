package week12;

/**
 *  A heap sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class HeapSort extends Sorter {

    /**
     *  Create a new HeapSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using heap sort.
     */
    public void sortNums() {
        heapify();
        int x = nums.length;
        while(x > 1){
            swap(0, x-1);
            x--;
            siftDown(0, x);
        }
    }

    private void swap(int x, int y) {
        // int i, j, and nums[] are all protected datafields in the
        // superclass Sort so we can use them without declaring them
        i = x;
        j = y;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        update();
    }

    /**
     *  Turn this into a heap by sifting down each value that isn't
     *  already a leaf.
     */
    private void heapify() {
        int n = nums.length;
        for(int x = (n/2) -1; x >= 0; x--){
            siftDown(x, n);
        }
    }

    /**
     *  Move the value at index i down in the heap to its correct
     *  place by continually swapping it with its largest child that
     *  is bigger than it.
     *
     * @param i the index of the value to be sifted down in the heap.
     * @param size the size of the current heap (will be smaller than
     *        array length as heap sort is performed).
     */
    private void siftDown(int index, int size) {
        int child = getLargerChildIndex(index, size);
        if(child == -1 || nums[index] > nums[child]){
            return;
        }else{
            swap(index, child);
            siftDown(child, size);
        }
    }

    /**
     *  Returns the index of the largest child of i, or -1 if i
     *  doesn't have a child larger than itself.
     *
     * @return the index of i's largest child that is bigger than i or
     *         -1 if no such child exists.
     */
    private int getLargerChildIndex(int index, int size) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;
        if(l >= size){
            return -1;
        }
        if(r >= size){
            return l;
        }else{
            if(nums[l] > nums[r]){
                return l;
            }else{
                return r;
            }
        }
    }
}
