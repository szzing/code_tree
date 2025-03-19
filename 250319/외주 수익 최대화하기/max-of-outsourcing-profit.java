import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int[] pays = new int[n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int time = times[i];
            int pay = pays[i];

            if (i + time <= n) {
                dp[i] = Math.max(dp[i], dp[i + time] + pay);
            }

            dp[i] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[0]);
    }
}