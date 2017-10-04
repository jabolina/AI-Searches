package agent;

import java.util.HashMap;
import java.util.Map;

public enum Actions {
    ASPIRATE(5),
    RIGHT(1),
    LEFT(1);

    private int index;
    private static Map<Actions, Integer> map = new HashMap<>();

    static {
        for (Actions actions: Actions.values()) {
            map.put(actions, actions.index);
        }
    }

    Actions(int i) {
        index = i;
    }

    public int valueOf(Actions actions) {
        return map.get(actions);
    }
}
