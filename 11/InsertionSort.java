package week11;

/**
 *  A Insertion sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Nathan Laing
 */
public class InsertionSort extends Sorter {
    
    /**
     *  Create a new Insertion sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums) {
        super(nums); // pass nums[] to the superclass Sort
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class). 
     */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;
        for (int i = 1; i < n; ++i){
            int key = nums[i];
            int j = i-1;
            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && nums[j] > key){
                comparisons++;
                nums[j+1] = nums[j];
                j = j-1;
                update();
            }
            nums[j+1] = key;
        }
    }
}
