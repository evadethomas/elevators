import java.util.Random;
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
        startTime = ElevatorSimulator.currentTick;
    }

    public void setEndTime(int tick) {
        endTime = tick;
    }

}
