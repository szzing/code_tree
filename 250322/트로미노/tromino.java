import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] grid;
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                shapeI(i, j);
                shapeL(i, j);
            }
        }

        System.out.println(maxResult);
    }

    public static void shapeI(int i, int j) {
        int sum = 0;
        if(i + 2 < n) {
            for(int x = i; x <= i + 2; x++) {
                sum += grid[x][j];
            }
        }
        maxResult = Math.max(maxResult, sum);

        sum = 0;
        if(j + 2 < m) {
            for(int y = j; y <= j + 2; y++) {
                sum += grid[i][y];
            }
        }
        maxResult = Math.max(maxResult, sum);
    }

    public static void shapeL(int i, int j) {
        int[] arr = new int[4];
        int sum = 0;
        
        if(i + 1 < n && j + 1 < m) {
            arr[0] = grid[i][j];
            arr[1] = grid[i][j+1];
            arr[2] = grid[i+1][j];
            arr[3] = grid[i+1][j+1];

            sum += grid[i][j] + grid[i+1][j] + grid[i][j+1] + grid[i+1][j+1];
        }

        for(int k = 0; k < 4; k++) {
            maxResult = Math.max(maxResult, sum - arr[k]);
        }
    }
}