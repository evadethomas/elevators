import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ElevatorSimulator {
    static ArrayList<Elevator> elevatorList;
    static ArrayList<Floor> floorList;
    static int tick;
    static int currentTick;

    static int maxReqStop = -1;

    static int minReqStop = -1;

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
        //elevatorList.get(0).loadAndUnload();
        boolean firstLoad = true;

        while (currentTick < tick) {
            generatePassenger();
            printWaitingPassengers();
            //printWaitingPassengers();
            //for (int i = 0; i < elevatorList.size() - 1; i++) {
            System.out.print("current floor pre-load\n" + elevatorList.get(0).ElevFloor);
            elevatorList.get(0).loadAndUnload();
            System.out.print("Passengers after loadAndUnload: \n");
            printWaitingPassengers();
            elevatorList.get(0).printElevator();
            System.out.print("current floor post-load, pre-travel\n" + elevatorList.get(0).ElevFloor);
            elevatorList.get(0).travel();
            System.out.print("current floor post-travel\n" + elevatorList.get(0).ElevFloor);
                /*
                if (elevatorList.get(i).up == true) {
                    if (elevatorList.get(i).ElevFloor != elevatorList.size() - 1) {
                        elevatorList.get(i).setFloor(elevatorList.get(i).ElevFloor + 1);
                    } else {
                        elevatorList.get(i).changeDirection();
                    }
                } else {
                    if (elevatorList.get(i).ElevFloor != 0) {
                        elevatorList.get(i).setFloor(elevatorList.get(i).ElevFloor - 1);
                    } else {
                        elevatorList.get(i).changeDirection();
                    }
                }
                */

            currentTick += 1;
            printWaitingPassengers();
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
                Random rand = new Random();
                while (pass.StartFloor == pass.EndFloor) {
                    pass.setEndFloor(rand.nextInt(elevators.floorNumber));
                }
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

    public static void requestStop(int floor) {
        if (floor < minReqStop) {
            minReqStop = floor;
        } else if (floor > maxReqStop) {
            maxReqStop = floor;
        }
    }







}
