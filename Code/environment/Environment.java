package environment;

import agent.State;
import agent.VacuumCleaner;
import auxiliary.AuxiliaryFunctions;

public class Environment extends EnvironmentSettings {

    private State initialState;

    public Environment() {
        super();
    }

    public State getInitialState() {

        return initialState;
    }

    public void setInitialState(State initialState) {

        this.initialState = initialState;
    }

    public void actionPerformed(VacuumCleaner vacuumCleaner, State actualState, State initialState) {

        if (!actualState.equals(initialState)) {
            this.changeActualState(vacuumCleaner, actualState);
            this.addActionCost(vacuumCleaner);
            this.addActionPerformed(vacuumCleaner, actualState);
        }
    }

    private void addActionCost(VacuumCleaner vacuumCleaner) {

        vacuumCleaner.setCost(vacuumCleaner.getCost() +
                vacuumCleaner.getState().getAction().valueOf(vacuumCleaner.getState().getAction()));
    }

    private void changeActualState(VacuumCleaner vacuumCleaner, State state) {

        vacuumCleaner.setState(state);
    }

    private void addActionPerformed(VacuumCleaner vacuumCleaner, State state) {

        vacuumCleaner.getActionsList()
                .add(state.getAction());
    }

}
