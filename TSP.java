import java.util.Scanner;

public class TSP {
    public static void main(String[] args) {
        int i, j;
        int c[][] = new int[10][10], tour[] = new int[10];
        int cost = 0;
        Scanner in =  new Scanner(System.in);
        System.out.println("Enter the number of cities");
        int n = in.nextInt();

        if(n==1){
            System.out.println("Path not possible");
            System.exit(n=0);
        }

        System.out.println("Enter the distance between cities");
        for(i= 1; i<=n; i++){
            for(j=1; j<=n; j++){
                c[i][j] = in.nextInt();
            }
        }

        System.out.println("Entered distance between cities");
        for(i= 1; i<=n; i++){
            for(j=1; j<=n; j++){
                System.out.println(c[i][j] + " ");
            }
            System.out.println();
        }

        for(i = 1; i<=n; i++){
            tour[i] = i;
        }

        cost = tsp(c, tour, 1, n);

        System.out.println(" The accurate path is ");
        for(i = 1; i<=n; i++)
            System.out.println(tour[i] + "-->");

        System.out.println("1");
        System.out.println("The minimum distance for tour is " + cost);
    }

    static int tsp(int c[][], int tour[], int start, int n){
        int i, j , temp[] = new int[10], ccost, mincost = 999, k , mintour[] = new int[10];
        if(start == n-1){
            return (c[tour[n-1]][tour[n]] + c[tour[n]][1]);
        }

        for(i=start+1; i<=n; i++){
            for(j=1; j<=n; j++){
                temp[j] = tour[j];
            }

            temp[start+1] = tour[i];
            temp[i] = tour[start+1];

            if(c[tour[start]][tour[i]] + (ccost = tsp(c, temp, start+1, n)) < mincost){
                mincost = c[tour[start]][tour[i]] + ccost;

                for(k=1; k<=n; k++){
                    mintour[k] = temp[k];
                }
            }
        }
    return mincost;
    }
}

