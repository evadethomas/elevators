import java.util.Random;
import java.util.Comparator;
public class Passenger {
    int StartFloor;
    int EndFloor;
    int startTime;
    int endTime;

    public Passenger() {
        Random rand = new Random();

        this.StartFloor = rand.nextInt(elevators.floorNumber);
        this.EndFloor = rand.nextInt(elevators.floorNumber);

        while (this.StartFloor == this.EndFloor) {
            this.StartFloor = rand.nextInt(elevators.floorNumber);
            this.EndFloor = rand.nextInt(elevators.floorNumber);
        }

        ElevatorSimulator.requestStop(EndFloor);

        startTime = ElevatorSimulator.currentTick;

    }

    public void setStartFloor(int floor) {
        this.StartFloor = floor;
    }
    public void setEndFloor(int floor) {
        this.EndFloor = floor;
    }

    public void setEndTime(int tick) {
        endTime = tick;
    }

    public void printPassenger() {
        System.out.println("Passenger:\nStart: " + StartFloor + "\nEnd: " + EndFloor + "\n");
    }

    public int getEndFloor() {
        return EndFloor;
    }
}
