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
            findHappyNumList(i);
        }

        System.out.println(numListCnt);
    }

    public static void findHappyNumList(int x) {
        int cnt = 1;
        // 행
        int prev = grid[x][0];
        for(int i = 1; i < n; i++) {
            if(cnt == m) {
                numListCnt++;
                break;
            }
            if(grid[x][i] == prev) {
                cnt++;
                
                if(cnt == m) {
                    numListCnt++;
                    break;
                }

            } else {
                cnt = 1;
                prev = grid[x][i];
            }
        }

        // 열
        prev = grid[0][x];
        cnt = 1;

        for(int i = 1; i < n; i++) {
            if(cnt == m) {
                numListCnt++;
                break;
            }

            if(grid[i][x] == prev) {
                cnt++;
                
                if(cnt == m) {
                    numListCnt++;
                    break;
                }

            } else {
                cnt = 1;
                prev = grid[i][x];
            }
        }
    }
}