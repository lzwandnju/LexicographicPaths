LexicographicPaths
==================

All valid paths to Goal, lexicographically  A* Algo Using DFS
Starting at (0,0) in the Cartesian plane. He wants to go to the point (N,M) in the same plane using only horizontal and vertical moves of 1 unit. There are many ways of doing this, and he is writing down all such ways. Every way will comprise of few H moves and few V moves. i.e. moves in horizontal and vertical direction respectively. For example, if we want to go to point (2,2) from point (0,0), HVHV is one of the possible ways.

Given the value of K, he wants to know lexicographically Kth smallest way of going to (N,M) from (0,0).

Input Format 
The first line contains an integer T , i.e., number of test cases. 
Next T lines will contain integers N,M and K.

Output Format 
For each test case, print lexicographically Kth smallest path.

Constraints 
1≤T≤100000 
1≤N≤10 
1≤M≤10 
0≤K<number of paths
