package Algorithms.DynamicProgramming;

/**
 * <pre>
 * Bigger number to smaller number 
 * @TimeComplexity: O(2^n) due to repitative calls
 * 
 * i.e similar to Top Down Memoization but without using extra space fo an array for memoization
 * 
 * 
 * fib(8) = 8+7 = 15, fib(7) = 7+6 = 13, fib(6) = 6+5 = 11, fib(5) = 5+4 = 9, fib(4) = 4+3 = 7, fib(3) = 3+2 = 5, fib(2) = 2+1 = 3, fib(1) = 1+0 = 1
 * 
 * BINARY TREE REPRESENTATION OF RECURCIVE CALLS AS BELOW:
 *                     
*                                                       8
*                                                 ______|_______                         
*                                                /              \
*                                               7                6_________________
*                                   ____________|______                      ______|______ 
*                                  /                   \                   /              \         
*                                 6                     5                  5                4                                                                                                                                                                          
*                           ______|_____             ___|___            ___|___            / \
*                          /            \           /       \          /       \          3   2
*                         5              4         4         3        4         3        /\  /\
*                      ___|___          / \       / \       / \      / \       /\       2  1 1 0  
*                     /       \        3   2     3   2     2   1    3   2     2  1     /\
*                    4         3      /\  /\    /\   /\   /\       /\  /\    /\       1  0
*                   / \       /\     2  1 1 0  2  1  1 0  1 0     2 1 1 0   1  0
*                  3   2     2  1   /\         /\                /\
*                 /\  /\    /\    1  0        1  0              1  0                                                                                                                                                
*                2  1 1 0  1  0                                
*               /\
*              1  0
*
*
*                
 * NOTE:
 * ---> fib(2) is the minimum recursion call cause we return n when n = 0 or n = 1 in base case
 * ---> Node is differenent and sum is different
 * ---> for leaf node, sum is the same as node value
*                                               
*                                                                   
*                                       6 (sum = 8)
*                              _________|________
*                             /                  \                     
*                            5 (sum = 5)          4 (sum = 3)  
*                    ________|____________ 
*                   /                     \   
*                  4(s=3)                  3(s=2) 
*                 / \                     / \ 
*           (s=2)3   2(s=1)         (s=1)2   1 --> leaf
*               / \  /\                 / \   
*         (s=1)2   1 1 0--> leaves     1   0  --> leaves
*             / \  |-----> leaf  
*            1   0 ------> leaves                
*                                                                                                                                   
 *                                                                                                  
 * <code>" 
 * in simple terms, first all the left values are calculated => i.e 
 * Once the last left node value (eg: 2) is obtained from method base case or previous call
 * calculate right sibling node vlaue (eg: 1) if we have one, and then add both these siblings in nearest parent node (eg: 3)
 * Here, this nearest parent node is nothing but a left node sibling of another right node, 
 * then calculate it's right sibling node and then sum up them in it's nearest parent node and so on ...
 * "</code>
 * </pre>
 * 
 * That's we use recursive approach in graphs and trees
 * 
 * 
 * @author Srinivas Vadige
 * @since 06 Oct 2024
 */
public class Fibonacci_DP_Recursive_Backtracking {
    public static void main(String[] args) {
        int n = 8;
        fib(n);
        // temp var =>
        // 1 2 1 3 1 2 5 1 2 1 3 8 1 2 1 3 1 2 5 13 1 2 1 3 1 2 5 1 2 1 3 8 21
        // 
        // --> where 1 2 1 3 are left sub-tree of parent node.
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) { // base case i.e when n = 0 or n = 1
            // System.out.println( "bc: " + n + " ");
            return n;
        }
        int temp = fib(n - 1) + fib(n - 2);
        System.out.print(temp + " ");
        // System.out.println( "node: " + n + ", " + "sum: " + temp); // prints repeatative calls as well
        return temp;
    }
}
