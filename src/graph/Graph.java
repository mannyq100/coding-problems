package graph;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of('b', 'c'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('g'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of('g'));
        graph.put('g', List.of());
        graph.put('h', List.of());

        char edges[][] = {{'i', 'j'},
                {'k', 'i'},
                {'m', 'k'},
                {'k', 'l'},
                {'o', 'n'}};

        char edges2[][] = {{'w', 'x'},
                {'x', 'y'},
                {'z', 'y'},
                {'z', 'v'},
                {'w', 'v'}};

        int matrix[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.println("Graph Depth First---------------");
        depthFirstPrint(graph, 'a');
        System.out.println();
        depthFirstRecursive(graph, 'a');
        System.out.println();
        System.out.println("Graph Breadth First---------------");
        breadthFirstPrint(graph, 'a');
        System.out.println();
        System.out.println("Graph has path from a to e ---------BFS");
        System.out.println(hasPathUsingBreadthFirst(graph, 'a', 'f'));
        System.out.println("Graph has path from a to e ---------DFS");
        System.out.println(undirectedPath(edges, 'i', 'o'));
        System.out.println("Count of connected components: " + connectComponents(graph));
        System.out.println("Max components count: " + maxComponents(graph));
        System.out.println("Shortest Path from w to z : " + shortestPath(edges2, 'w', 'z'));
        System.out.println("Number of islands in grid " + numIslands(matrix));
        System.out.println("Minimum island in matrix " + minimumIsland(matrix));

    }


    static void depthFirstPrint(Map<Character, List<Character>> graph, char a) {
        Stack<Character> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()) {
            char item = stack.pop();
            System.out.print(item + " ");
            List<Character> rel = graph.get(item);
            for (char c : rel) {
                stack.push(c);
            }
        }
    }

    static void depthFirstRecursive(Map<Character, List<Character>> graph, char a) {
        System.out.print(a + " ");
        List<Character> rel = graph.get(a);
        for (char c : rel) {
            depthFirstRecursive(graph, c);
        }
    }

    static void breadthFirstPrint(Map<Character, List<Character>> graph, char c) {
        Queue<Character> queue = new LinkedList<>();
        System.out.print(c + " ");
        queue.offer(c);

        while (!queue.isEmpty()) {
            Character currentItem = queue.poll();
            List<Character> rel = graph.get(currentItem);
            for (char item : rel) {
                System.out.print(item + " ");
                queue.offer(item);
            }

        }
    }

    private static boolean hasPath(Map<Character, List<Character>> graph, char source, char dest, Set<Character> visited) {
        if (source == dest) return true;
        if (visited.contains(source)) return false;

        visited.add(source);

        List<Character> rel = graph.get(source);
        for (char item : rel) {
            if (hasPath(graph, item, dest, visited)) return true;
        }
        return false;
    }

    private static boolean hasPathUsingBreadthFirst(Map<Character, List<Character>> graph, char source, char dest) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Character item = queue.poll();
            if (item == dest) return true;
            for (Character rel : graph.get(item)) {
                queue.offer(rel);
            }
        }
        return false;
    }

    static boolean undirectedPath(char edges[][], char source, char dest) {
        // turn edges into adjacency list
        Map<Character, List<Character>> adjList = buildAdjList(edges);
        System.out.println(adjList);

        return hasPath(adjList, source, dest, new HashSet<>());
    }

    static int shortestPath(char edges[][], char source, char dest) {
        Map<Character, List<Character>> adjList = buildAdjList(edges);

        Queue<List<Object>> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        queue.add(List.of(source, 0));


        while (!queue.isEmpty()) {
            List<Object> itemAndDistance = queue.poll();
            var item = itemAndDistance.get(0);
            var distance = itemAndDistance.get(1);
            if (item == Character.valueOf(dest)) {
                return (int) distance;
            }
            List<Character> rel = adjList.get(item);
            for (char itemz : rel) {
                if (!visited.contains(itemz)) {
                    visited.add(itemz);
                    queue.offer(List.of(itemz, (int) distance + 1));
                }
            }

        }

        return -1;
    }

    static Map<Character, List<Character>> buildAdjList(char edges[][]) {
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        for (char[] edge : edges) {
            char item1 = edge[0];
            char item2 = edge[1];
            if (!adjacencyList.containsKey(item1)) {
                adjacencyList.put(item1, new ArrayList<>());
            }
            if (!adjacencyList.containsKey(item2)) {
                adjacencyList.put(item2, new ArrayList<>());
            }
            adjacencyList.get(item1).add(item2);
            adjacencyList.get(item2).add(item1);
        }
        return adjacencyList;
    }

    static int connectComponents(Map<Character, List<Character>> graph) {
        int count = 0;
        Set<Character> visited = new HashSet<>();

        for (char item : graph.keySet()) {
            if (explore(graph, item, visited) == true) {
                count++;
            }
        }
        return count;
    }

    private static boolean explore(Map<Character, List<Character>> graph, char item, Set<Character> visited) {
        if (visited.contains(item)) return false;

        visited.add(item);
        List<Character> rel = graph.get(item);
        for (char currentItem : rel) {
            explore(graph, currentItem, visited);
        }
        return true;
    }

    static int maxComponents(Map<Character, List<Character>> graph) {
        int componentsCount = 0;
        Set<Character> visited = new HashSet<>();

        for (char item : graph.keySet()) {
            int currentCount = explore2(graph, item, visited);
            componentsCount = Math.max(currentCount, componentsCount);
        }
        return componentsCount;
    }

    private static int explore2(Map<Character, List<Character>> graph, char item, Set<Character> visited) {
        if (visited.contains(item)) return 0;

        visited.add(item);
        int size = 1;
        List<Character> rel = graph.get(item);
        for (char current : rel) {
            size += explore2(graph, current, visited);
        }
        return size;
    }

    static int numIslands(int matrix[][]) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isIsland(matrix, i, j, visited))
                    count += 1;
            }
        }
        return count;
    }

    private static boolean isIsland(int[][] matrix, int i, int j, Set<String> visited) {
        boolean rowBound = 0 <= i && i < matrix.length;
        boolean columBound = 0 <= j && j < matrix[0].length;
        if (!rowBound || !columBound) return false;
        if (matrix[i][j] == 0) return false;

        String pos = i + "," + j;
        if (visited.contains(pos)) return false;

        visited.add(pos);

        isIsland(matrix, i - 1, j, visited);
        isIsland(matrix, i + 1, j, visited);
        isIsland(matrix, i, j - 1, visited);
        isIsland(matrix, i, j + 1, visited);

        return true;
    }

    static int minimumIsland(int matrix[][]) {
        int minCount = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int numIslands = countIsland(matrix, r, c, visited);
                if (numIslands > 0 && numIslands < minCount) {
                    minCount = numIslands;
                }

            }
        }
        return minCount;
    }

    private static int countIsland(int[][] matrix, int r, int c, Set<String> visited) {
        boolean rowBound = 0 <= r && r < matrix.length;
        boolean columnBound = 0 <= c && c < matrix[0].length;
        if (!rowBound || !columnBound) return 0;

        if (matrix[r][c] == 0) return 0;

        String pos = r + "," + c;
        if (visited.contains(pos)) return 0;

        visited.add(pos);

        int currentCount = 1;
        currentCount += countIsland(matrix, r - 1, c, visited) ;
        currentCount += countIsland(matrix, r + 1, c, visited) ;
        currentCount += countIsland(matrix, r, c - 1, visited) ;
        currentCount += countIsland(matrix, r, c + 1, visited) ;

        return currentCount;
    }


}
