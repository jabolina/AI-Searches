package environment;

import agent.VacuumCleaner;

public class Environment extends EnvironmentSettings {

    public Environment() {
        super();
    }

    public void actionPerformed(VacuumCleaner vacuumCleaner, int x, int y) {

        this.addActionCost(vacuumCleaner);
        this.changeActualState(vacuumCleaner, x, y);
        this.addActionPerformed(vacuumCleaner, x, y);
    }

    private void addActionCost(VacuumCleaner vacuumCleaner) {

        vacuumCleaner.setCost(vacuumCleaner.getCost() + 1);
    }

    private void changeActualState(VacuumCleaner vacuumCleaner, int x, int y) {

        vacuumCleaner.setState(getGraph()[x][y]);
    }

    private void addActionPerformed(VacuumCleaner vacuumCleaner, int x, int y) {

        vacuumCleaner.getActionsList()
                .add(getGraph()[x][y].getAction());
    }
}
