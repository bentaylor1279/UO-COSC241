package week11;

/**
 *  A merge sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Nathan Laing
 */
public class MergeSort extends Sorter {

    /** Temperary array to copy and sort within. */
    private int[] temp;

    /**
     *  Create a new MergeSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }
    
    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        this.temp = new int[nums.length];
        comparisons = 0;
        mergesorter(0, nums.length-1);
    }
    
    /**
     * Recursive MergeSort method.
     * @param left the left index
     * @param right the right index
     */
    public void mergesorter(int left, int right){
        if(left < right){
            comparisons++;
            int mid = left + (right - left) / 2;
            mergesorter(left, mid);
            mergesorter(mid + 1, right);
            merge(left, mid, right);
        }
    }

    /**
     * Merge method that fits all the pieces back together.
     * @param left the left index
     * @param mid the middle index
     * @param right the right index
     */
    public void merge(int left, int mid, int right){
        for(int i = left; i <= right; i++){
            this.temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right){
            comparisons += 2;
            if(temp[i] <= temp[j]){
                comparisons++;
                nums[k] = temp[i];
                i++;
            } else {
                comparisons++;
                nums[k] = temp[j];
                j++;
            }
            k++;
            update();
        }
        while(i <= mid){
            comparisons++;
            nums[k] = temp[i];
            k++;
            i++;
            update();
        }
    }
}
