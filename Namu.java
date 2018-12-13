import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Namu {
	static int N;
	static int M;
	static int K;
	static ArrayList<Tree>[][] map;
	static ArrayList<Pair> checkList;
	static int[][] energy;
	static int[][] offer;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		K = scanner.nextInt();
		map = (ArrayList<Tree>[][]) new ArrayList[N][N];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++)
				map[row][col] = new ArrayList<Tree>();
		}
		energy = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(energy[i], 5);
		offer = new int[N][N];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				offer[row][col] = scanner.nextInt();
			}
		}
		for (int i = 0; i < M; i++) {
			int row = scanner.nextInt() - 1;
			int col = scanner.nextInt() - 1;
			int age = scanner.nextInt();
			Tree tree = new Tree(row, col, age);
			map[row][col].add(tree);
		}

		for (int year = 0; year < K; year++) {
			spring();
			summer();
			fall();
			winter();
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() > 0)
					answer += map[i][j].size();
			}
		}
		System.out.println(answer);
	}

	public static void spring() {
		checkList = new ArrayList<Pair>();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col].size() > 0) {
					ArrayList<Tree> treeList = map[row][col];
					for (int i = 0; i < treeList.size(); i++) {
						Tree tree = treeList.get(i);
						if (tree.age > energy[row][col]) {
							tree.isAlive = false;
						} else {
							energy[row][col] -= tree.age;
							tree.age++;
						}
					}
					checkList.add(new Pair(row, col));
				}
			}
		}
	}

	public static void summer() {
		for(int index=0; index<checkList.size(); index++) {
			Pair pair = checkList.get(index);
			int row = pair.row;
			int col = pair.col;
			ArrayList<Tree> treeList = map[row][col];
			for (int i = treeList.size() - 1; i >= 0; i--) {
				Tree tree = treeList.get(i);
				if (!tree.isAlive) {
					energy[row][col] += tree.age / 2;
					treeList.remove(i);
				}
			}
		}
	}

	public static void fall() {
		for(int index=0; index<checkList.size(); index++) {
			Pair pair = checkList.get(index);
			int row = pair.row;
			int col = pair.col;
			ArrayList<Tree> treeList = map[row][col];
			for (int i = 0; i < treeList.size(); i++) {
				Tree tree = treeList.get(i);
				if (tree.age % 5 == 0) {
					int tRow = tree.row;
					int tCol = tree.col;
					for (int j = 0; j < 8; j++) {
						int nextRow = tRow + dr[j];
						int nextCol = tCol + dc[j];
						if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1)
							continue;
						Tree t = new Tree(nextRow, nextCol, 1);
						map[nextRow][nextCol].add(0, t);
					}
				}
			}
		}
	}

	public static void winter() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				energy[row][col] += offer[row][col];
			}
		}
	}
}
class Pair{
	int row;
	int col;
	
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
}

class Tree {
	boolean isAlive = true;
	int row;
	int col;
	int age;

	Tree(int row, int col, int age) {
		this.row = row;
		this.col = col;
		this.age = age;
	}
}
