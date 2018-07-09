package week11;

/**
 *  A selection sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Nathan Laing
 */
public class SelectionSort extends Sorter {

    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }
    
    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++){
                comparisons++;
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
                update();
            }
            // Swap the found minimum element with the first
            // element
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

        }
    }
}
