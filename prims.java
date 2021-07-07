import java.util.Scanner;

public class prims {
    public static void main(String[] args) {
        int i, j, mincost = 0;
        int cost[][] = new int[10][10];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of nodes ");
        int n = in.nextInt();

        System.out.println("Enter the cost matrix");
        for (i = 1; i<=n; i++){
            for (j =1; j<=n; j++){
                cost[i][j] = in.nextInt();
            }
        }

        System.out.println("The entered cost matrix is ");
        System.out.println("The cost matrix");
        for(i = 1; i<=n; i++){
            for(j = 1; j<=n; j++){
                System.out.print(cost[i][j] + "   ");
            }
            System.out.println();
        }

        mincost = pr(cost, n, mincost);
        System.out.println("The min spanning tree is " + mincost);
    }

    static int pr(int cost[][], int n, int mincost) {
        int nearV[] = new int[10], i, j, t[][] = new int[10][10], u = 0, k;
        for (i = 2; i <= n; i++) {
            nearV[i] = 1;
        }
        nearV[1] = 0;
        for (i = 1; i < n; i++) {
            int min = 999;

            for (j = 1; j <= n; j++) {
                if (nearV[j] != 0 && cost[j][nearV[j]] < min) {
                    min = cost[j][nearV[j]];
                    u = j;
                }
            }
            t[i][1] = u;
            t[i][2] = nearV[u];
            mincost = min;
            nearV[u] = 0;


            for (k = 1; k <= n; k++) {
                if (nearV[k] != 0 && cost[k][nearV[k]] > cost[k][u])
                    nearV[k] = u;
            }

            System.out.println(i + "The min edge is " + t[i][1] + " , " + t[i][2] + " and its cost is " + min);

        }
        return mincost;
    }
}
