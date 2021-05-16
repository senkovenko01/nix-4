package ua.com.alevel.thirdTask;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cities {
    public static final String CITY_INPUT = "./src/main/resources/files/cities/inputCities.txt";
    public static final String CITY_OUTPUT = "./src/main/resources/files/cities/outputCities.txt";

    public static void run() {
        File inputFile = new File(CITY_INPUT);
        File outputFile = new File(CITY_OUTPUT);

        Reader reader = Reader.nullReader();
        Writer writer = Writer.nullWriter();
        Scanner scanner = null;

        try {
            reader = new FileReader(inputFile);
            scanner = new Scanner(reader);
        } catch (FileNotFoundException e) {
            System.err.println("Please, return file input.txt back)");
            System.exit(-1);
        }

        int townsAmount = Integer.parseInt(scanner.nextLine());
        ArrayList<Town> towns = new ArrayList<>();

        for (int i = 0; i < townsAmount; i++) {
            Town town = new Town();
            town.index = i;
            town.name = scanner.nextLine();
            Integer neighborAmount = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < neighborAmount; j++) {
                String[] neighbor = scanner.nextLine().split(" ");
                town.neighbors.add(new TownNearest(Integer.parseInt(neighbor[0]), Integer.parseInt(neighbor[1])));
            }
            towns.add(town);
        }

        int pathsAmount = Integer.parseInt(scanner.nextLine());
        String[][] paths = new String[pathsAmount][2];

        for (int i = 0; i < pathsAmount; i++) {
            String[] names = scanner.nextLine().split(" ");
            paths[i][0] = names[0];
            paths[i][1] = names[1];
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Can`t close file input.txt!");
            System.exit(-1);
        }

        SimpleWeightedGraph<String, DefaultWeightedEdge>graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        for (int i = 0; i < townsAmount; i++) {
            graph.addVertex(towns.get(i).name);
        }

        for (int i = 0; i < townsAmount; i++) {
            for (TownNearest neighbor: towns.get(i).neighbors) {
                DefaultWeightedEdge edge = graph.addEdge(towns.get(i).name, towns.get(neighbor.index - 1).name);
                if (edge != null) {
                    graph.setEdgeWeight(edge, neighbor.cost);
                }
            }
        }

        try {
            writer = new FileWriter(outputFile);
        } catch (IOException e) {
            System.err.println("Can`t create output.txt");
            System.exit(-1);
        }

        for(String[] path: paths) {
            DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
            List<String> shortestPath = dijkstraShortestPath.getPath(path[0], path[1]).getVertexList();
            double weight = dijkstraShortestPath.getPath(path[0], path[1]).getWeight();

            try {
                writer.write("Shortest way from " + path[0] + " to " + path[1] + " is: | ");
                for (int i = 0; i < shortestPath.size() - 1; i++) {
                    writer.write(shortestPath.get(i) + " -> ");
                }
                writer.write(shortestPath.get(shortestPath.size() - 1));

                writer.write(" | Length = " + NumberFormat.getInstance().format(weight) + '\n');
            } catch (IOException e) {
                System.err.println("Can`t write to output.txt");
                System.exit(-1);
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Can`t close file output.txt!");
            System.exit(-1);
        }

        try {
            reader = new FileReader(outputFile);
            scanner = new Scanner(reader);
        } catch (FileNotFoundException e) {
            System.err.println("Please, return file input.txt back)");
            System.exit(-1);
        }

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.err.println("Can`t close file input.txt!");
            System.exit(-1);
        }
        System.out.println();
    }

    private static class Town {
        private Integer index;
        private String name;
        private final ArrayList<TownNearest> neighbors = new ArrayList<>();
    }

    private static class TownNearest {
        private final Integer index;
        private final Integer cost;

        public TownNearest(Integer index, Integer cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
