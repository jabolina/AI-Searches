# IA Searches

The problem is presented in the book <i>Artificial Intelligence: a modern approach</i> by Russell and Norving.
The vacumm cleaner problem, where exists two tiles, A and B, where they can be clean or not. <br>
Possible actions are:

    * Aspirate
    * Go right
    * Go left

In this repo, have the DFS, BFS and A* searches implemented.

   * Depth First Search implemented on class DepthFirstSearch
   * Breadth First Search implemented on classh BreadthFirstSearch
   * A* implemented on AStarSearch, the heuristic consist in counting how many tiles still dirty, then multiply by 5.
<br>
The costs are:
   
   Go left  --> 1
   Go right --> 1
   Apirate  --> 5
