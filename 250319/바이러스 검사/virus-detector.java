import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;
        
        int n = Integer.parseInt(br.readLine());
        int[] rest = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int leader = Integer.parseInt(st.nextToken());
        int follow = Integer.parseInt(st.nextToken());
        br.close();

        for(int i=0; i<n; i++) {
            int cust = rest[i];
            if (cust == 0) continue;
            
            answer += 1;
            cust -= leader;

            if (cust > 0) {
                answer += (cust / follow) + (cust % follow == 0 ? 0 : 1);
            }
        }

        System.out.println(answer);
    }
}