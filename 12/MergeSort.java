package week12;
import java.util.*;

/**
 *  A merge sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Iain Hewson
 */
public class MergeSort extends Sorter {

    /** Second array used for merge sorting. */
    private Integer[] tempMergArr;

    /**
     *  Create a new MergeSort sorter with the given integers to sort.
     * 
     * @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums) {
        super(nums);
        tempMergArr = new Integer[nums.length];
    }

    /**
     *  Sort the integers (which are stored in the parent Sorter class)
     *  using merge sort.
     */
    public void sortNums() {
        mergeSort(0, nums.length-1);
    }
    
    public void mergeSort(int left, int right){
        if(left < right){
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid + 1, right);
        }
    }
        
    public void merge(int left, int mid, int right){
        for(int i = left; i <= right; i++){
            tempMergArr[i] = nums[i];
        }

        int i = left, j = left, k = mid;
        while(i < mid && k<= right){
            if(tempMergArr[i] < tempMergArr[k]){
                nums[j++] = tempMergArr[i++];
            }else{
                nums[j++] = tempMergArr[k++];
            }
        }

        while(i < mid){
            nums[j++] = tempMergArr[i++];
        }
        while(j <= right){
            nums[j++] = tempMergArr[k++];
        }
    }
}
