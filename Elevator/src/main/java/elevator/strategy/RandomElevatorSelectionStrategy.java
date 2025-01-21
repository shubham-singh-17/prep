package elevator.strategy;

import elevator.entity.Elevator;
import elevator.model.Direction;
import java.util.List;

public class RandomElevatorSelectionStrategy implements ElevatorSelectionStrategy {

    @Override
    public Elevator getBestElevator(int floor, Direction direction, List<Elevator> elevators) {
        int numberOfElevators = elevators.size();
        int randomElevatorIndex = (int) (Math.random() * numberOfElevators);

        return elevators.get(randomElevatorIndex);
    }
}
