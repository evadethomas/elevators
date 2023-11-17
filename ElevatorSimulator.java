import java.util.ArrayList;

public class ElevatorSimulator {
    static ArrayList<Elevator> elevatorList;
    static ArrayList<Floor> floorList;
    static int tick;

    static int currentTick;

    public ElevatorSimulator() {

        elevators simulation = new elevators();

        this.elevatorList = new ArrayList<Elevator>();

        for (int i = 0; i < elevators.elevatorNumber; i++) {
            Elevator newElevator = new Elevator();
            this.elevatorList.add(newElevator);
        }

        this.floorList = new ArrayList<Floor>();

        for (int i = 0; i < elevators.floorNumber; i++) {
            Floor newFloor = new Floor();
            this.floorList.add(newFloor);
        }

        this.tick = simulation.duration;

        this.currentTick = 0;
    }

    public static void runSimulation() {

    }

    public static void generatePassenger() {

        for (int i = 0; i < elevators.floorNumber; i++) {
            double passengerCheck = Math.random();
            System.out.println(passengerCheck);

            if (passengerCheck <= elevators.passengers) {
                System.out.println("New passenger");
            }
        }

    }



}
