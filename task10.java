import java.util.*;

public class task10{

    // DFS function
    static void dfs(int node, ArrayList<ArrayList<Integer>> graph,
                    boolean[] visited) {

        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- INPUT LABEL --------
        System.out.println("===== CAMPUS NETWORK CONNECTIVITY CHECKER =====");

        System.out.print("Enter number of computers (N): ");
        int n = sc.nextInt();

        System.out.print("Enter number of connections (M): ");
        int m = sc.nextInt();

        // Create graph
        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read connections
        System.out.println("\nEnter the connections (u v):");

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            // Undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Visited array
        boolean[] visited = new boolean[n + 1];

        int components = 0;

        // Find connected components
        for (int i = 1; i <= n; i++) {

            if (!visited[i]) {
                components++;

                dfs(i, graph, visited);
            }
        }

        // -------- OUTPUT LABEL --------
        System.out.println("\n===== OUTPUT =====");
        System.out.println("Connected Components = " + components);

        sc.close();
    }
}