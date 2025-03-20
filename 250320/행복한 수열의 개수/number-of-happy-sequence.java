import java.util.Scanner;
  
public class Main {
    static int n, m;
    static int[][] grid;
    static int numListCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            findHappyNumList(i, true);
            findHappyNumList(i, false);
        }

        System.out.println(numListCnt);
    }

    public static void findHappyNumList(int x, boolean isRow) {
        int cnt = 1;
        int prev = isRow ? grid[x][0] : grid[0][x];

        for (int i = 1; i < n; i++) {
            int current = isRow ? grid[x][i] : grid[i][x];

            if (current == prev) {
                cnt++;
            } else {
                cnt = 1;
                prev = current;
            }

            if (cnt == m) {
                numListCnt++;
                break;
            }
        }
    }
}