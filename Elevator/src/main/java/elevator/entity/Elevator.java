package elevator.entity;

import elevator.model.Direction;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {

    private final int id;
    private int currentFloor;
    private int destinationFloor;
    private Direction direction;
    private final int maxFloor;

    // This has to be in desc order
    private PriorityQueue<Integer> maxHeapDown;
    private PriorityQueue<Integer> minHeapUp;
    private Queue<Integer> queue;

    public Elevator(int elevatorId, int maxFloor) {
        this.id = elevatorId;
        this.currentFloor = 0;
        this.destinationFloor = 0;
        this.direction = Direction.NONE;
        this.maxFloor = maxFloor;
        this.maxHeapDown = new PriorityQueue<>();
        this.minHeapUp = new PriorityQueue<>();
        this.queue = new ArrayDeque<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public PriorityQueue<Integer> getMaxHeapDown() {
        return maxHeapDown;
    }

    public PriorityQueue<Integer> getMinHeapUp() {
        return minHeapUp;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
}
