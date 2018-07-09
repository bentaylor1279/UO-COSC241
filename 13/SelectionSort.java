package week12;

/**
 *  A selection sort implementation which is able to be observed through
 *  its Sorter superclass.
 *
 * @author Iain Hewson
 */
public class SelectionSort extends Sorter {
    
    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums) {
        super(nums);
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using selection sort.
     */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;
        int smallest;
        for(int i = 0; i < n -1; i++){
            smallest = getSmallest(i, n -1);
            swap(smallest, i);
            update();
        }
           
        
    }
    public int getSmallest(int start, int end){
        int smallest = nums[start];
        int smallestIndex = start;
        comparisons+=end-start;
        for(int i = start; i <= end; i++){
            if(nums[i] < smallest){
                smallest = nums[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    public void swap(int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
