import java.util.ArrayList;
import java.util.Arrays;

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
        //generatePassenger();
        elevatorList.get(0).loadAndUnload();
        while (currentTick < tick) {
            generatePassenger();
            printWaitingPassengers();
            //printWaitingPassengers();
            for (int i = 0; i < elevatorList.size(); i++) {
                elevatorList.get(i).travel();
                elevatorList.get(i).loadAndUnload();
                System.out.print("current floor" + elevatorList.get(i).ElevFloor);
            }
            currentTick += 1;
            printWaitingPassengers();
            if (currentTick == 3) {
                break;
            }
        }






    }

    public static void generatePassenger() {

        for (int i = 0; i < elevators.floorNumber; i++) {

            double passengerCheck = Math.random();
            System.out.println(passengerCheck);

            if (passengerCheck <= elevators.passengers) {
                System.out.println("New passenger");
                Floor toAdd = floorList.get(i);

                Passenger pass = new Passenger();
                pass.setStartFloor(i);
                toAdd.addPass(pass);
            }
        }

    }

    public static void printWaitingPassengers() {
        for (int i = 0; i < elevators.floorNumber; i++) {
            Floor currFloor = floorList.get(i);

            System.out.println("Passengers on floor " + (i) + " going up\n");

            for (int j = 0; j < currFloor.queUp.size(); j++) {
                currFloor.queUp.get(j).printPassenger();
            }

            System.out.println("Passengers on floor " + (i) + " going down\n");

            for (int j = 0; j < currFloor.queDown.size(); j++) {
                currFloor.queDown.get(j).printPassenger();
            }

        }
    }





}
