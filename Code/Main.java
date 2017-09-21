import agent.VacuumCleaner;
import environment.Environment;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Environment environment = new Environment();
        VacuumCleaner vacuumCleaner = new VacuumCleaner();

        int initialState = ThreadLocalRandom.current().nextInt(0, 9);

        System.out.println("Initial state: ");
        System.out.println(environment.getPossibleStates().get(initialState).toString());
        vacuumCleaner.setState(environment.getPossibleStates().get(initialState));
    }
}
