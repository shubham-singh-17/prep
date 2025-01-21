package elevator.service;

import elevator.entity.Elevator;
import elevator.model.Direction;
import elevator.store.ElevatorStore;
import elevator.strategy.ElevatorSelectionStrategy;
import java.util.ArrayList;

public class ElevatorService {

    private final ElevatorStore elevatorStore;
    private final ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ElevatorService(ElevatorStore elevatorStore, ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorStore = elevatorStore;
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public void createElevator(int elevatorId, int maxFloor) {
        Elevator elevator = new Elevator(elevatorId, maxFloor);
        elevatorStore.addElevator(elevator);
    }

    public void pressExternalButton(int floor, Direction direction) {
        Elevator elevator = elevatorSelectionStrategy.getBestElevator(
            floor, direction, new ArrayList<>(elevatorStore.getAllElevator().values())
        );

        addExternalRequest(elevator, floor, direction);
    }

    private void addExternalRequest(Elevator elevator, int floor, Direction direction) {
        if (elevator.getCurrentFloor() >= floor && direction == Direction.DOWN) {
            elevator.getMaxHeapDown().offer(floor);
        } else if (elevator.getCurrentFloor() <= floor && direction == Direction.UP) {
            elevator.getMinHeapUp().offer(floor);
        } else {
            elevator.getQueue().offer(floor);
        }

        controlElevator(elevator);
    }

    private void controlElevator(Elevator elevator) {
       boolean flag = true;
        while (flag) {
            if (elevator.getDirection() == Direction.UP && !elevator.getMinHeapUp().isEmpty()) {
                while (!elevator.getMinHeapUp().isEmpty()) {
                    int destinationFloor = elevator.getMinHeapUp().poll();
                    moveElevator(elevator, destinationFloor);
                }
                elevator.setDirection(Direction.NONE);
            } else if (elevator.getDirection() == Direction.DOWN && !elevator.getMaxHeapDown().isEmpty()) {
                while (!elevator.getMaxHeapDown().isEmpty()) {
                    int destinationFloor = elevator.getMaxHeapDown().poll();
                    moveElevator(elevator, destinationFloor);
                }
                elevator.setDirection(Direction.NONE);
            } else if (elevator.getQueue().isEmpty() && (!elevator.getMinHeapUp().isEmpty() || !elevator.getMaxHeapDown().isEmpty())) {
                if (!elevator.getMinHeapUp().isEmpty()) {
                    elevator.setDirection(Direction.UP);
                } else {
                    elevator.setDirection(Direction.DOWN);
                }

            } else if (!elevator.getQueue().isEmpty()) {
                while (!elevator.getQueue().isEmpty()) {
                    int destinationFloor = elevator.getQueue().poll();
                    if (elevator.getCurrentFloor() >= destinationFloor){
                        elevator.setDirection(Direction.DOWN);
                        elevator.getMaxHeapDown().offer(destinationFloor);
                    }
                    else {
                        elevator.setDirection(Direction.UP);
                        elevator.getMinHeapUp().offer(destinationFloor);
                    }
                }
            }  else {
                flag = false;
            }
        }
    }

    private void moveElevator(Elevator elevator, int destinationFloor) {
        elevator.setDestinationFloor(destinationFloor);
        log(elevator);

        while (elevator.getCurrentFloor() != destinationFloor) {
            if (elevator.getCurrentFloor() < destinationFloor) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            } else {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            }
            log(elevator);
        }
    }

    private void log(Elevator elevator) {
        System.out.println(
            "Elevator " + elevator.getId() + " is on floor " + elevator.getCurrentFloor() + " and moving in " +
                "direction " + elevator.getDirection()
        );
    }
}
