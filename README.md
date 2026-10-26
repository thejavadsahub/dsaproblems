# DSA Problems in Java

Code from [@dsa.java.hub](https://instagram.com/dsa.java.hub) - Java & DSA, explained simply.
The Java language, JVM, Spring and system design live in the sister repo
[javaconcepts](https://github.com/thejavadsahub/javaconcepts).

## What's in here

| Folder | What is in it |
|---|---|
| `arrays/` | Array basics, matrix traversal and array problems |
| `backtracking/` | Choose, explore, undo: subsets, permutations, word search |
| `binarysearch/` | Binary search on the answer and on rotated arrays |
| `bugspots/` | Intentionally buggy code: try to spot the bug before checking the fix |
| `design/` | Data structure design problems (LRU cache) |
| `dp/` | Dynamic programming: stairs, coins, subsequences, house robber |
| `graphs/` | BFS, DFS, topological sort and shortest paths |
| `hashing/` | Hash map problems: Two Sum, anagrams, prefix sums |
| `heaps/` | Min-heaps, top-k and merging sorted lists |
| `intervals/` | Interval problems |
| `linkedlists/` | Singly linked lists: reverse, cycle detection, merge |
| `queues/` | Array and linked-list queues |
| `quicktips/` | Short, focused tips and comparisons |
| `recursion/` | Recursion basics |
| `searching/` | Linear and binary search |
| `slidingwindow/` | Sliding window problems |
| `sorting/` | Sorting |
| `stacks/` | Stacks and monotonic stacks |
| `strings/` | String immutability |
| `trees/` | Binary trees, BSTs, traversals, depth and ancestors |
| `tries/` | Tries and autocomplete |
| `twopointers/` | Two pointer problems |
| `unionfind/` | Union-Find (disjoint sets) |

## How to run

No build tool needed - just plain `javac`/`java`, from this repo's root:

```bash
javac -d . arrays/ArrayBasics.java
java arrays.ArrayBasics
```

Every folder is its own Java package (matching the folder name exactly), so the class to run is `<folder>.<ClassName>`.

## Roadmaps

### DSA roadmap: 8 patterns

1. **Two Pointers**: 3Sum, Most Water, Pair Sum  
   [ThreeSum](twopointers/ThreeSum.java), [ContainerWithMostWater](twopointers/ContainerWithMostWater.java), [TrappingRainWater](twopointers/TrappingRainWater.java)
2. **Sliding Window**: Max sum of k, Longest substring  
   [MaxSumSubarrayOfSizeK](slidingwindow/MaxSumSubarrayOfSizeK.java), [LongestSubstringWithoutRepeating](slidingwindow/LongestSubstringWithoutRepeating.java)
3. **Hash Map**: Two Sum, Anagrams, Subarray = k  
   [TwoSum](hashing/TwoSum.java), [GroupAnagrams](hashing/GroupAnagrams.java), [SubarraySumEqualsK](hashing/SubarraySumEqualsK.java)
4. **Binary Search**: Sorted array, Koko bananas  
   [LinearAndBinarySearch](searching/LinearAndBinarySearch.java), [KokoEatingBananas](binarysearch/KokoEatingBananas.java), [SearchRotatedSortedArray](binarysearch/SearchRotatedSortedArray.java)
5. **Stack**: Valid ( ), Next greater  
   [ValidParentheses](stacks/ValidParentheses.java), [DailyTemperatures](stacks/DailyTemperatures.java)
6. **BFS / DFS**: Islands, Shortest path, Course order  
   [NumberOfIslands](graphs/NumberOfIslands.java), [GridShortestPathBfs](graphs/GridShortestPathBfs.java), [CourseScheduleTopoSort](graphs/CourseScheduleTopoSort.java), [RottingOranges](graphs/RottingOranges.java)
7. **Heap / Top K**: Top K, K closest, Merge K lists  
   [KthLargestElement](heaps/KthLargestElement.java), [MergeKSortedLists](heaps/MergeKSortedLists.java)
8. **Dynamic Programming**: Climb stairs, Coin change  
   [ClimbingStairs](dp/ClimbingStairs.java), [CoinChange](dp/CoinChange.java), [HouseRobber](dp/HouseRobber.java), [LongestIncreasingSubsequence](dp/LongestIncreasingSubsequence.java), [LongestCommonSubsequence](dp/LongestCommonSubsequence.java)

### Top 8 DSA patterns: read the clue in the problem statement

- "sorted array, find a pair" -> Two pointers: [ContainerWithMostWater](twopointers/ContainerWithMostWater.java) (LC 11)
- "best subarray of size k" -> Sliding window: [MaxSumSubarrayOfSizeK](slidingwindow/MaxSumSubarrayOfSizeK.java)
- "seen this value before?" -> Hash map: [TwoSum](hashing/TwoSum.java) (LC 1), [SubarraySumEqualsK](hashing/SubarraySumEqualsK.java) (LC 560)
- "smallest speed that works" -> Binary search on the answer: [KokoEatingBananas](binarysearch/KokoEatingBananas.java) (LC 875)
- "matching brackets" -> Stack: [ValidParentheses](stacks/ValidParentheses.java) (LC 20)
- "islands, fewest steps" -> BFS / DFS: [NumberOfIslands](graphs/NumberOfIslands.java) (LC 200)
- "k largest / kth smallest" -> Heap: [KthLargestElement](heaps/KthLargestElement.java) (LC 215)
- "count ways, min coins" -> Dynamic programming: [ClimbingStairs](dp/ClimbingStairs.java) (LC 70), [CoinChange](dp/CoinChange.java) (LC 322)

## Topic index

Every file in this repo.

| Folder | Topic | File |
|---|---|---|
| `arrays/` | Array basics | [ArrayBasics](arrays/ArrayBasics.java) |
| `arrays/` | LeetCode 121: Best Time to Buy and Sell Stock | [BestTimeToBuySellStock](arrays/BestTimeToBuySellStock.java) |
| `arrays/` | Matrix traversal | [MatrixTraversal](arrays/MatrixTraversal.java) |
| `arrays/` | LeetCode 238: Product of Array Except Self (no division) | [ProductOfArrayExceptSelf](arrays/ProductOfArrayExceptSelf.java) |
| `backtracking/` | LeetCode 46: Permutations (backtracking) | [Permutations](backtracking/Permutations.java) |
| `backtracking/` | LeetCode 78: Subsets (backtracking) | [Subsets](backtracking/Subsets.java) |
| `backtracking/` | LeetCode 79: Word Search (backtracking on a grid) | [WordSearch](backtracking/WordSearch.java) |
| `binarysearch/` | LeetCode 875: Koko Eating Bananas (binary search on the answer) | [KokoEatingBananas](binarysearch/KokoEatingBananas.java) |
| `binarysearch/` | LeetCode 33: Search in Rotated Sorted Array | [SearchRotatedSortedArray](binarysearch/SearchRotatedSortedArray.java) |
| `bugspots/` | Spot the bug: Binary search bug | [BinarySearchBug](bugspots/BinarySearchBug.java) |
| `bugspots/` | Spot the bug: Empty stack pop bug | [EmptyStackPopBug](bugspots/EmptyStackPopBug.java) |
| `bugspots/` | Spot the bug: LCA bug | [LcaBug](bugspots/LcaBug.java) |
| `bugspots/` | Spot the bug: Linked list reversal bug | [LinkedListReversalBug](bugspots/LinkedListReversalBug.java) |
| `bugspots/` | Spot the bug: Matrix bounds bug | [MatrixBoundsBug](bugspots/MatrixBoundsBug.java) |
| `bugspots/` | Spot the bug: Missing base case bug | [MissingBaseCaseBug](bugspots/MissingBaseCaseBug.java) |
| `bugspots/` | Spot the bug: Off by one bug | [OffByOneBug](bugspots/OffByOneBug.java) |
| `bugspots/` | Spot the bug: Queue tail pointer bug | [QueueTailPointerBug](bugspots/QueueTailPointerBug.java) |
| `bugspots/` | Spot the bug: Traversal order bug | [TraversalOrderBug](bugspots/TraversalOrderBug.java) |
| `bugspots/` | Spot the bug: Validate BST bug | [ValidateBstBug](bugspots/ValidateBstBug.java) |
| `design/` | LeetCode 146: LRU Cache, built from scratch with a HashMap and a doubly linked list | [LruCache](design/LruCache.java) |
| `dp/` | LeetCode 70: Climbing Stairs, plain recursion vs memoization | [ClimbingStairs](dp/ClimbingStairs.java) |
| `dp/` | LeetCode 322: Coin Change | [CoinChange](dp/CoinChange.java) |
| `dp/` | LeetCode 198: House Robber (dynamic programming) | [HouseRobber](dp/HouseRobber.java) |
| `dp/` | LeetCode 1143: Longest Common Subsequence (dynamic programming table) | [LongestCommonSubsequence](dp/LongestCommonSubsequence.java) |
| `dp/` | LeetCode 300: Longest Increasing Subsequence, in O(n log n) | [LongestIncreasingSubsequence](dp/LongestIncreasingSubsequence.java) |
| `dp/` | LeetCode 53: Maximum Subarray (Kadane's algorithm) | [MaximumSubarrayKadane](dp/MaximumSubarrayKadane.java) |
| `graphs/` | LeetCode 207 / 210: Course Schedule, topological sort with Kahn's algorithm | [CourseScheduleTopoSort](graphs/CourseScheduleTopoSort.java) |
| `graphs/` | BFS shortest path in a grid | [GridShortestPathBfs](graphs/GridShortestPathBfs.java) |
| `graphs/` | LeetCode 743: Network Delay Time (Dijkstra's shortest paths) | [NetworkDelayDijkstra](graphs/NetworkDelayDijkstra.java) |
| `graphs/` | LeetCode 200: Number of Islands (DFS flood fill) | [NumberOfIslands](graphs/NumberOfIslands.java) |
| `graphs/` | LeetCode 994: Rotting Oranges (multi-source BFS) | [RottingOranges](graphs/RottingOranges.java) |
| `hashing/` | LeetCode 49: Group Anagrams | [GroupAnagrams](hashing/GroupAnagrams.java) |
| `hashing/` | LeetCode 560: Subarray Sum Equals K (prefix sum + hash map) | [SubarraySumEqualsK](hashing/SubarraySumEqualsK.java) |
| `hashing/` | Two Sum: find the two numbers that add up to the target | [TwoSum](hashing/TwoSum.java) |
| `heaps/` | LeetCode 215: Kth Largest Element, with a min-heap of size k | [KthLargestElement](heaps/KthLargestElement.java) |
| `heaps/` | LeetCode 23: Merge k Sorted Lists (min-heap) | [MergeKSortedLists](heaps/MergeKSortedLists.java) |
| `heaps/` | Min heap basics | [MinHeapBasics](heaps/MinHeapBasics.java) |
| `intervals/` | LeetCode 56: Merge Intervals | [MergeIntervals](intervals/MergeIntervals.java) |
| `linkedlists/` | Detect cycle | [DetectCycle](linkedlists/DetectCycle.java) |
| `linkedlists/` | LeetCode 141: Linked List Cycle, with a step-by-step trace of Floyd's fast and slow pointers | [LinkedListCycle](linkedlists/LinkedListCycle.java) |
| `linkedlists/` | LeetCode 21: Merge Two Sorted Lists | [MergeTwoSortedLists](linkedlists/MergeTwoSortedLists.java) |
| `linkedlists/` | Reverse linked list | [ReverseLinkedList](linkedlists/ReverseLinkedList.java) |
| `linkedlists/` | LeetCode 206: Reverse a Linked List (iterative), with a step-by-step trace | [ReverseLinkedListSteps](linkedlists/ReverseLinkedListSteps.java) |
| `linkedlists/` | Singly linked list | [SinglyLinkedList](linkedlists/SinglyLinkedList.java) |
| `queues/` | Array queue | [ArrayQueue](queues/ArrayQueue.java) |
| `queues/` | Linked queue | [LinkedQueue](queues/LinkedQueue.java) |
| `quicktips/` | Array vs array list | [ArrayVsArrayList](quicktips/ArrayVsArrayList.java) |
| `quicktips/` | Arrays sort vs collections sort | [ArraysSortVsCollectionsSort](quicktips/ArraysSortVsCollectionsSort.java) |
| `quicktips/` | BFS vs DFS | [BfsVsDfs](quicktips/BfsVsDfs.java) |
| `quicktips/` | BST vs sorted array | [BstVsSortedArray](quicktips/BstVsSortedArray.java) |
| `quicktips/` | Fast slow pointer tip | [FastSlowPointerTip](quicktips/FastSlowPointerTip.java) |
| `quicktips/` | Heap vs BST | [HeapVsBst](quicktips/HeapVsBst.java) |
| `quicktips/` | Queue interface vs linked list | [QueueInterfaceVsLinkedList](quicktips/QueueInterfaceVsLinkedList.java) |
| `quicktips/` | Recursion for tree height | [RecursionForTreeHeight](quicktips/RecursionForTreeHeight.java) |
| `quicktips/` | Recursive vs iterative traversal | [RecursiveVsIterativeTraversal](quicktips/RecursiveVsIterativeTraversal.java) |
| `quicktips/` | Stack vs deque | [StackVsDeque](quicktips/StackVsDeque.java) |
| `quicktips/` | String builder vs concat | [StringBuilderVsConcat](quicktips/StringBuilderVsConcat.java) |
| `quicktips/` | When not to use linked list | [WhenNotToUseLinkedList](quicktips/WhenNotToUseLinkedList.java) |
| `recursion/` | Factorial recursion | [FactorialRecursion](recursion/FactorialRecursion.java) |
| `searching/` | Linear and binary search | [LinearAndBinarySearch](searching/LinearAndBinarySearch.java) |
| `slidingwindow/` | LeetCode 3: Longest Substring Without Repeating Characters (sliding window) | [LongestSubstringWithoutRepeating](slidingwindow/LongestSubstringWithoutRepeating.java) |
| `slidingwindow/` | Sliding window: the maximum sum of any k consecutive numbers (here k = 4) | [MaxSumSubarrayOfSizeK](slidingwindow/MaxSumSubarrayOfSizeK.java) |
| `sorting/` | Bubble sort | [BubbleSort](sorting/BubbleSort.java) |
| `stacks/` | Array stack | [ArrayStack](stacks/ArrayStack.java) |
| `stacks/` | Balanced parentheses | [BalancedParentheses](stacks/BalancedParentheses.java) |
| `stacks/` | LeetCode 739: Daily Temperatures (monotonic stack) | [DailyTemperatures](stacks/DailyTemperatures.java) |
| `stacks/` | LeetCode 20: Valid Parentheses, with a push/pop trace | [ValidParentheses](stacks/ValidParentheses.java) |
| `strings/` | String immutability | [StringImmutability](strings/StringImmutability.java) |
| `trees/` | Binary search tree | [BinarySearchTree](trees/BinarySearchTree.java) |
| `trees/` | Binary tree basics | [BinaryTreeBasics](trees/BinaryTreeBasics.java) |
| `trees/` | Level order traversal | [LevelOrderTraversal](trees/LevelOrderTraversal.java) |
| `trees/` | Lowest common ancestor | [LowestCommonAncestor](trees/LowestCommonAncestor.java) |
| `trees/` | LeetCode 236: Lowest Common Ancestor of a Binary Tree (any binary tree, not only a BST) | [LowestCommonAncestorBinaryTree](trees/LowestCommonAncestorBinaryTree.java) |
| `trees/` | Max depth | [MaxDepth](trees/MaxDepth.java) |
| `trees/` | Tree traversals | [TreeTraversals](trees/TreeTraversals.java) |
| `trees/` | Validate BST | [ValidateBst](trees/ValidateBst.java) |
| `tries/` | LeetCode 208: Implement Trie, used for autocomplete | [TrieAutocomplete](tries/TrieAutocomplete.java) |
| `twopointers/` | LeetCode 11: Container With Most Water (two pointers) | [ContainerWithMostWater](twopointers/ContainerWithMostWater.java) |
| `twopointers/` | LeetCode 15: 3Sum (sort + two pointers) | [ThreeSum](twopointers/ThreeSum.java) |
| `twopointers/` | LeetCode 42: Trapping Rain Water (two pointers) | [TrappingRainWater](twopointers/TrappingRainWater.java) |
| `unionfind/` | LeetCode 547: Number of Provinces (Union-Find, union by size) | [NumberOfProvinces](unionfind/NumberOfProvinces.java) |

## Contributing / extending

Each folder is its own Java package (matching the folder name exactly). To add a new topic, create a new folder and give
each file inside it a matching `package <foldername>;` declaration.
