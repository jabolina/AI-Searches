import agent.State;
import agent.VacuumCleaner;
import auxiliary.AuxiliaryFunctions;
import environment.Environment;
import search.AStarSearch;
import search.BreadthFirstSearch;
import search.DepthFirstSearch;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static auxiliary.AuxiliaryFunctions.*;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        Environment environment = new Environment();
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        List<State> states = null;

        int initialState = ThreadLocalRandom.current().nextInt(0, 7);

        vacuumCleaner.setState(environment.getPossibleStates().get(initialState).father(null).heuristicCost(0));
        environment.setInitialState(vacuumCleaner.getState());

        System.out.println("--------ESCOLHA A BUSCA A SER REALIZADA:");
        System.out.println("1 - Busca em profundidade");
        System.out.println("2 - Busca em largura");
        System.out.println("3 - Busca A*");
        System.out.print("Opcao: ");
        int option = reader.nextInt();

        System.out.println("\n\n\n");

        switch (option) {
            case 1:
                DepthFirstSearch depthFirstSearch = new DepthFirstSearch(vacuumCleaner.getState());

                System.out.println("Inicio da busca em profundidade:\n");
                vacuumCleaner = depthFirstSearch.DFS(vacuumCleaner, environment);

                if (vacuumCleaner != null) {
                    System.out.println("Sequencia de ações até objetivo: \n");
                    vacuumCleaner.printActionList();
                    System.out.println("\n\nCusto total:");
                    System.out.println(vacuumCleaner.getCost());
                    return ;
                }
                break;

            case 2:
                BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(vacuumCleaner.getState());

                System.out.println("Inicio da busca em largura:\n");
                vacuumCleaner = breadthFirstSearch.BFS(vacuumCleaner, environment);
                states = generateStateSequence(vacuumCleaner.getState());

                break;

            case 3:
                AStarSearch aStarSearch = new AStarSearch(vacuumCleaner.getState());

                System.out.println("Inicio da busca A*:\n");
                vacuumCleaner = aStarSearch.AStar(vacuumCleaner, environment);
                states = generateStateSequence(vacuumCleaner.getState());
                break;
        }
        if (states != null) {
            showActionsList(vacuumCleaner, states);
            System.out.println("\n\nCusto total:");
            System.out.println(vacuumCleaner.getCost());
        } else System.out.println("Lista vazia!");
    }
}
