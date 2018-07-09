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
        for(int i = 0; i < nums.length-1; i++){
            int smallest = getSmallest(i , nums.length-1);
            swap(i, smallest);
        }
    }
    
    public int getSmallest(int start, int end){
        int value = nums[start];
        int index = start;
        for(int i = start; i <= end; i++){
            if(nums[i] < value){
                value = nums[i];
                index = i;
            }
        }
        return index;
    }
    
    public void swap(int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return;
    }
}
