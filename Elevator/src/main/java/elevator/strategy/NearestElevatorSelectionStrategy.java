package elevator.strategy;

import elevator.entity.Elevator;
import elevator.model.Direction;
import static elevator.model.constant.DemoConstant.MAX_FLOOR;
import java.util.List;

public class NearestElevatorSelectionStrategy implements ElevatorSelectionStrategy {

    @Override
    public Elevator getBestElevator(int floor, Direction direction, List<Elevator> elevators) {
        Elevator nearestElevator = null;
        int minDistance = MAX_FLOOR*2;

        for (Elevator elevator : elevators) {
            int distance = calculateDistance(elevator, floor, direction);
            if (distance < minDistance) {
                minDistance = distance;
                nearestElevator = elevator;
            }
        }

        return nearestElevator;
    }

    public int calculateDistance(Elevator elevator, int floor, Direction direction) {
        int distance = 0;

        if (elevator.getCurrentFloor() < floor) {
            if (elevator.getDirection() == Direction.UP && direction == Direction.UP) {
                distance = Math.abs(elevator.getCurrentFloor() - floor);
            } else {
                distance = Math.abs(elevator.getCurrentFloor() - elevator.getDestinationFloor()) +
                               Math.abs(elevator.getDestinationFloor() - floor);
            }
        } else if (elevator.getCurrentFloor() > floor) {
            if (elevator.getDirection() == Direction.DOWN && direction == Direction.DOWN) {
                distance = Math.abs(elevator.getCurrentFloor() - floor);
            } else {
                distance = Math.abs(elevator.getCurrentFloor() - elevator.getDestinationFloor()) +
                               Math.abs(elevator.getDestinationFloor() - floor);
            }
        } else {
            if (
                (elevator.getDirection() == Direction.UP && direction == Direction.DOWN) ||
                    (elevator.getDirection() == Direction.DOWN && direction == Direction.UP)
            ) {
                distance = Math.abs(elevator.getCurrentFloor() - elevator.getDestinationFloor()) * 2;
            }
        }

        return distance;
    }
}
