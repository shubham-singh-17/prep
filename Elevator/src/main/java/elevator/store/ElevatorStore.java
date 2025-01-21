package elevator.store;

import elevator.entity.Elevator;
import java.util.HashMap;
import java.util.Map;

public class ElevatorStore {

    private final Map<Integer, Elevator> elevatorMap;

    public ElevatorStore() {
        this.elevatorMap = new HashMap<>();
    }

    public void addElevator(Elevator elevator) {
        elevatorMap.put(elevator.getId(), elevator);
    }

    public Map<Integer, Elevator> getAllElevator() {
        return elevatorMap;
    }
}
