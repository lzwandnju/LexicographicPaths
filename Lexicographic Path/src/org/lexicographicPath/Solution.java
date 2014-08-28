package org.lexicographicPath;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	int[][] board;
	int goalrow;
	int goalcol;
	boolean[][] visited;
	List<List<Character>> resultPath;

	enum Movement {
		UP, DOWN, LEFT, RIGHT
	}

	class Position  {
		int x;
		int y;

		public Position() {

		}

		public Position(Position temp) {
			this.x = temp.x;
			this.y = temp.y;
		}

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		
	};

	public int hsld(Position p) {
		return (p.getX() - goalrow) * (p.getX() - goalrow)
				+ (p.getY() - goalcol) * (p.getY() - goalcol);
	}

	public Solution() {
		// TODO Auto-generated constructor stub
		this(10, 10);
	}

	public Solution(int n, int m) {
		board = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = 0;
				visited[i][j] = false;
			}

		}

		resultPath = new ArrayList<List<Character>>();

	}

	public Position getPosition(Position p, Movement m) {
		switch (m) {
		case UP: {
			return new Position(p.getX() - 1, p.getY());
		}
		case DOWN: {
			return new Position(p.getX() + 1, p.getY());
		}
		case LEFT: {
			return new Position(p.getX(), p.getY() - 1);
		}
		case RIGHT: {
			return new Position(p.getX(), p.getY() + 1);
		}
		}
		return null;
	}

	public void solve(int n, int m) {

		goalrow = n;
		goalcol = m;
		boolean hasFound = false;
		Deque<Position> pq = new LinkedList<Position>();
		List<Character> path = new ArrayList<Character>();
		Position p = new Position(0, 0);
		do {
			Position tempnext;
			if (pq.isEmpty() == true) {
				pq.addFirst(p);
				hasFound=true;

			} else {
				Position nextPosition = pq.getFirst();
				for (Movement movement : Movement.values()) {
					tempnext = new Position(getPosition(nextPosition, movement));
					if (hsld(tempnext) < hsld(nextPosition)
							&& visited[tempnext.getX()][tempnext.getY()] == false) {
						pq.addFirst(tempnext);
						// p = tempnext;
						if (movement == Movement.UP
								|| movement == Movement.DOWN)
							path.add('H');
						else
							path.add('V');
						visited[tempnext.getX()][tempnext.getY()] = true;
						hasFound = true;
					}
				}
			}
			if (hasFound == false)
				pq.removeFirst();
			else {
				tempnext = pq.getFirst();
				if (tempnext.getX() == goalrow && tempnext.getY() == goalcol) {
					resultPath.add(new ArrayList<Character>(path));
					for (List<Character> clist : resultPath) {
						for (char c : clist) {
							System.out.print(c + " ");
						}
						System.out.println();
					}
					pq.removeFirst();
					path.clear();
				}
			}

		} while (pq.isEmpty() == false);
	}

	public static void main(String args[]) {
		Solution s = new Solution(3, 3);
		s.solve(2, 2);

	}

}
