import java.util.Scanner;
public class Main {
    static int n;
    static int[][] grid;
    static int maxCoin = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                findCoin(i, j);
            }
        }

        System.out.println(maxCoin);
    }

    public static void findCoin(int i, int j) {
        int cnt = 0;
        int x = i + 3;
        int y = j + 3;
        
        if(x >= 0 && y >= 0 && x <= n && y <= n) {
            for(int nx = i; nx < x; nx++) {
                for(int ny = j; ny < y; ny++) {
                    if(grid[nx][ny] == 1) cnt++;
                }
            }
        } else {
            return;
        }

        maxCoin = Math.max(cnt, maxCoin);
    }
}