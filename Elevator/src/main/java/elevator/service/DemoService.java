package elevator.service;

import elevator.model.Direction;
import static elevator.model.constant.DemoConstant.MAX_FLOOR;
import static elevator.model.constant.DemoConstant.NUMBER_OF_ELEVATORS;
import elevator.store.ElevatorStore;
import elevator.strategy.NearestElevatorSelectionStrategy;

public class DemoService {

    private final ElevatorService elevatorService;

    public DemoService() {
        ElevatorStore elevatorStore = new ElevatorStore();
        NearestElevatorSelectionStrategy elevatorSelectionStrategy = new NearestElevatorSelectionStrategy();
        this.elevatorService = new ElevatorService(elevatorStore, elevatorSelectionStrategy);
    }

    public void demo() {
        createElevators();

        elevatorService.pressExternalButton(1, Direction.UP);
        elevatorService.pressExternalButton(4, Direction.UP);
        elevatorService.pressExternalButton(6, Direction.DOWN);
        elevatorService.pressExternalButton(5, Direction.DOWN);
        elevatorService.pressExternalButton(1, Direction.UP);
        elevatorService.pressExternalButton(2, Direction.UP);
        elevatorService.pressExternalButton(4, Direction.UP);
        elevatorService.pressExternalButton(5, Direction.DOWN);
        elevatorService.pressExternalButton(6, Direction.DOWN);
        elevatorService.pressExternalButton(9, Direction.UP);
        elevatorService.pressExternalButton(3, Direction.UP);
        elevatorService.pressExternalButton(5, Direction.UP);
        elevatorService.pressExternalButton(1, Direction.DOWN);
        elevatorService.pressExternalButton(9, Direction.DOWN);
        elevatorService.pressExternalButton(3, Direction.UP);
        elevatorService.pressExternalButton(5, Direction.UP);
        elevatorService.pressExternalButton(7, Direction.UP);
        elevatorService.pressExternalButton(9, Direction.DOWN);
        elevatorService.pressExternalButton(0, Direction.DOWN);
        elevatorService.pressExternalButton(2, Direction.UP);
    }

    private void createElevators() {
        for (int i = 1; i <= NUMBER_OF_ELEVATORS; i++) {
            elevatorService.createElevator(i, MAX_FLOOR);
        }
    }
}
