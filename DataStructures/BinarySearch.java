package DataStructures;

import java.util.Comparator;
import java.util.List;

/**
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 10 May 2025
 * NOTE: we can use java in-built binary search functions 🔥
 * {@link java.util.Arrays#binarySearch(int[], int)}
 * {@link java.util.Arrays#binarySearch(int[], int, int, int)} --> startInclusive, endExclusive, target
 * {@link java.util.Arrays#binarySearch(Object[], Object)}
 * {@link java.util.Arrays#binarySearch(Object[], Object, Comparator)}
 * {@link java.util.Arrays#binarySearch(Object[], int, int, Object, Comparator)}
 * and
 * {@link java.util.Collections#binarySearch(List, Object)}
 * {@link java.util.Collections#binarySearch(List, Object, Comparator)}

  Binary Search has a time complexity of O(log n) but only works on sorted arrays

  But Binary Search has 2 aspects:
  1. A sorted array
  2. Splitting the array into two equal halves

  So, if we don't have a sorted array, then try to split the array into two equal halves if we have some patterns like num[i-1] < num[i] < num[i+1]

  1. A sorted array
  -----------------
  If you have a sorted array, then you can use Binary Search to find an element in O(log n) time

  2. Splitting the array into two equal halves
  ---------------------------------------------
  Observe some patterns like num[i-1] < num[i] < num[i+1]
  You can split the array into two equal halves like
  A1 = l1{2, 4} r1{9, 12}
  Then
 */
public class BinarySearch {
    private static String[] args;

    public static void main(String[] args) {
        BinarySearch.args = args;
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.printf("binarySearch => %s \n", binarySearch(nums, target));
        System.out.printf("binarySearchWithDuplicates => %s \n", binarySearchWithDuplicates(nums, target));
    }


    /**
         [1, 3, 5, 6] & target = 7
         if target>all nums eles and not found then it'll return nums.length i.e "n" as 'r' is initialized to 'n-1' and after l & r completion in while(l<=r) it'll be r+1
         and 'r' will return 'n-1' as it is initialized to 'n-1'

         [1, 3, 5, 6] & target = -1
         similarly if target<all nums eles and not found then 'l' return 0 not -1, so 'l' is initialized to 0
         and 'r' will return -1

         so, check and return -1; instead of l
     */
    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2; // to avoid overflow or use (start + end) / 2
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l; // or return -1; -- return the index where it would be if it were inserted in order

    }


    /**
     * 🔥
     * Works for both duplicates, non-duplicates nums and also when target is not present
     * 🔥
     * Here if target not found then it'll return the next biggest number.
     * same as above binarySearch() explanation

         [1, 3, 3, 5, 6] & target = 3
         l      m     r

         [1, 3, 3, 5, 6] & target = 3
         l   r

         [1, 3, 3, 5, 6] & target = 3
            lr
     */
    public static int binarySearchWithDuplicates(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l<=r) {
            mid = l+(r-l)/2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
/*
            //or
            if (nums[mid] < target) { //---> if nums[mid] < target --> it's just "<" but not "<="
                l = mid + 1;
            } else {
                r = mid - 1;
            }
*/
        }
        return l;
    }



    public int binarySearchWithDuplicatesOldWay(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2; // to avoid overflow or use (start + end) / 2
            if (nums[mid] == target) {
                while(mid>0 && nums[mid-1]==target) mid--; // this will return the starting index of the target (as we have duplicate targets)
                return mid;
            }
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }





    /**
     * @TimeComplexity O(log n)
     * @SpaceComplexity O(1)

        Focus on "Strictly monotonically increasing" or "Strictly monotonically decreasing"

                                                *                    *
                                            *      -∞     or     -∞      *
                                        *                                     *
                                    *                                            *
                                -∞                                                   -∞

        "-∞" is for nums[-1] and nums[n]

        If there is a "Strictly monotonically increasing" then we might face a smaller number on the right i.e a peak or the nums ends with -∞ i.e a peak
        Similarly if there is a "Strictly monotonically decreasing", then we know that nums[-1] is -∞ and nums[0] is peak

        Note that we need any peak, not necessarily the max peak

    */
    public static int findPeakElement(int[] nums) {
        int n=nums.length, l=0, r=n-1, mid;
        while (l<=r) {
            mid = l + (r-l)/2;
            // which neighbor is bigger?
            if (mid > 0 && nums[mid] < nums[mid-1]) r=mid-1; // leftNeighbor is bigger
            else if( mid < n-1 && nums[mid] < nums[mid+1]) l=mid+1; // rightNeighbor is bigger
            else return mid; // so, no neighbor is bigger
        }
        return -1;
    }

}
