package Algorithms.DynamicProgramming;

/**
<pre>
AWS provides a range of servers to meet the deployment needs of its clients. A client wants to choose a set of servers to deploy their application. Each server is associated with an availability factor and a reliability factor.
The client defines the stability of a set of servers as the minimum availability amongst the servers multiplied by the sum of reliabilities of all the servers. Given two arrays of integers, availability, and reliability, where the availabilityli] and reliabilityli] represent the availability and reliability factors of the ith server, find the maximum possible stability of any subset of servers.
Since the answer can be large, report the answer modulo (10° + 7).

Example
Consider the set of servers where reliability = [1, 2, 2] and availability = [1, 1, 3].
The possible subsets of servers are:
Indices
Stability
[0] => 1 * 1 = 1
[1] => 1 * 2 = 2
[2] => 3 * 2 = 6

[0, 1] => min(1, 1) * (1 + 2) = 3
[0, 2] => min(1, 3) * (1 + 2) = 3
[1, 2] => min(1, 3) * (2 + 2) = 4
[0, 1, 2] => min(1, 1, 3) * (1 + 2 + 2) = 5
availability[i], reliability[i] are integers
when i==j then i*j
else min(availability[i], availability[j]) * (reliability[i] + reliability[j])

Here, we have i,j,k...... many subsets like [i], [i, j], [i, j, k] and so on.

So answer is maximum stability for the set of
index {2}, answer = 6 % 1000000007 = 6.
Function Description
Complete the function getMaxStability in the editor below.
getMaxStability has the following parameters: int reliability[n]: server reliability values int availability[n]: server availability values
Returns
int: the maximum stability above among all possible non-empty subsets, modulo (109+7)
Constraints:
1 ≤ n≤ 105
1 ≤ reliability[i], availability[i] ≤ 106
It is guaranteed that lengths of reliability and availability are the same.

</pre>
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 11 Jan 2025
 */
public class MaximumPossibleStability {
    public static void main(String[] args) {

    }
}
