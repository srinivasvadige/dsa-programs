package DataStructures;

import java.util.Stack;

/**
<pre>
STACK
————
LIFO (Last In, First Out)
We have Stack class & support indices.
Stack<TreeNode> stack = new Stack<>();

stack.push(ele) —> Adds an element to the top / last of the stack.

.pop() —> Removes and returns the top / last element of the stack. EmptyStackException if the stack is empty.

.peek() —> Returns the top element of the stack without removing it. EmptyStackException if the stack is empty.

.get(i) —> get(0) returns bottom/first ele. And get(s.size()-1) or peek() returns top/last ele.

.isEmpty() —> true if the stack is empty, false otherwise

search(Object o) —> Searches for an element in the stack and returns its 1-based position from the top. Returns -1 if the element is not found. Same as findIndex.

.size()

.clear()

.contains(ele) —> true if the element is found, false otherwise

.toString()

Note:
1. Use isEmpty() or try-catch or Deque to avoid the EmptyStackException when stack.pop().
2. Use Deque for both Stack and Queue alternative.
Deque<Integer> deque = new ArrayDeque<>()

</pre>
 *
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 11 Jan 2025
 */
public class StackExample {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());

        System.out.println(stack.search(3));

        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }

        for (Integer i : stack) {
            System.out.println(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        /*
        for (Integer i : stack)
            System.out.println(stack.pop());
         */
        // but we cannot loop with i and pop() simultaneously --> It throws ConcurrentModificationException
    }
}
