package elevator.strategy;

import elevator.entity.Elevator;
import elevator.model.Direction;
import java.util.List;

public interface ElevatorSelectionStrategy {

    Elevator getBestElevator(int floor, Direction direction, List<Elevator> elevators);
}
