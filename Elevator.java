import java.util.*;

public class Elevator {
    boolean up;
    int ElevFloor;

    PriorityQueue<Passenger> stopUp;
    PriorityQueue<Passenger> stopDown;
    public Elevator() {
        this.ElevFloor = 0;
        up = true;
        Comparator<Passenger> stopUpComparator = Comparator.comparingInt(Passenger::getEndFloor);
        Comparator<Passenger> stopDownComparator = Comparator.comparingInt(Passenger::getEndFloor).reversed();
        stopUp = new PriorityQueue<Passenger>(stopUpComparator);
        stopDown = new PriorityQueue<Passenger>(stopDownComparator);
    }

    public void passengerUp(Passenger upPsg) {
        stopUp.add(upPsg);
    }

    public void passengerDown(Passenger downPsg) {
        stopDown.add(downPsg);
    }

    public void setFloor(int flr) {
        this.ElevFloor = flr;
    }

    public int getFloor() {
        return ElevFloor;
    }

    public void travel() {
        int highestTravel = ElevFloor + 5;
        if (ElevFloor + 5 > elevators.floorNumber - 1) {
            highestTravel = elevators.floorNumber;
        }
        if (up == true) {
            int dropOffFloor = highestTravel;
            if (stopUp.isEmpty() == false && stopUp.peek().EndFloor < highestTravel) {
                dropOffFloor = stopUp.peek().EndFloor;
            }
            int pickUpFloor = highestTravel;
            for (int i = ElevFloor; i < highestTravel; i++) {
                if (ElevatorSimulator.floorList.get(i).upIsEmpty() == false) {
                    pickUpFloor = i;
                    break;
                }
            }

            if (dropOffFloor < pickUpFloor) {
                ElevFloor = dropOffFloor;
            } else if (dropOffFloor > pickUpFloor) {
                ElevFloor = pickUpFloor;
            } else {
                ElevFloor = highestTravel;
            }
        }

        if (up == false) {
            int lowestTravel = ElevFloor - 5;

            if (ElevFloor - 5 < 0) {
                lowestTravel = 0;
            }

            int dropOffFloor = lowestTravel;
            if (stopDown.isEmpty() == false && stopDown.peek().EndFloor > lowestTravel) {
                dropOffFloor = stopDown.peek().EndFloor;
            }

            int pickUpFloor = lowestTravel;

            for (int i = ElevFloor; i > lowestTravel; i--) {
                if (ElevatorSimulator.floorList.get(i).upIsEmpty() == false) {
                    pickUpFloor = i;
                    break;
                }
            }

            if (dropOffFloor < pickUpFloor) {
                ElevFloor = dropOffFloor;
            } else if (dropOffFloor > pickUpFloor) {
                ElevFloor = pickUpFloor;
            } else {
                ElevFloor = lowestTravel;
            }
        }

        /*
        if (ElevFloor < 5 && up == false) {
            System.out.println("On floor "+ ElevFloor + "Cannot go lower/higher");
        } else if (ElevFloor > elevators.floorNumber - 5 && up == true) {
            System.out.println("On floor "+ ElevFloor + "Cannot go lower/higher");
        }

        if (up == true) {
            if (ElevFloor < stopUp.peek().StartFloor && stopUp.peek().StartFloor < ElevFloor + 5) {
                ElevFloor = stopUp.peek().EndFloor;
                stopUp.remove();
            }
        } else {
            if (ElevFloor > stopDown.peek().StartFloor && stopDown.peek().StartFloor > ElevFloor - 5) {
                ElevFloor = stopDown.peek().EndFloor;
                stopUp.remove();
            }
        }
        */
    }

    public void requestStop() {

    }

    public void loadAndUnload() {
        Floor currFloor = ElevatorSimulator.floorList.get(ElevFloor);
        if (currFloor.queUp.size() > 0 && up == true) {
            for (int i = 0; i < currFloor.queUp.size(); i++) {
                Passenger pass = currFloor.queUp.remove(i);
                stopUp.add(pass);
            }
        } else if (currFloor.queDown.size() > 0 && up == false) {
            for (int i = 0; i < currFloor.queDown.size(); i++) {
                Passenger pass = currFloor.queDown.remove(i);
                stopDown.add(pass);
            }
        }
        while (stopUp.peek() != null && stopUp.peek().EndFloor == ElevFloor) {
            Passenger curr = stopUp.poll();
            /* For testing:
            System.out.print("Dropped off ");
            curr.printPassenger();
            System.out.println(" at " + ElevFloor);
            */
        }
        while (stopDown.peek() != null && stopDown.peek().EndFloor == ElevFloor) {
            Passenger curr = stopDown.poll();
            /* For testing:
            System.out.print("Dropped off ");
            curr.printPassenger();
            System.out.println(" at " + ElevFloor);
            */
        }

        //The following commented out code ensures heaps work properly. Switch "Up" to "Down" in 2 lines to check up
        //queue instead.
        /*
        System.out.println("HEAP TEST: \n");
        PriorityQueue<Passenger> temp = new PriorityQueue<>(stopUp);
        while (temp.isEmpty() == false && temp.peek() != null) {
                Passenger curr = temp.poll();
                curr.printPassenger();
        }

        System.out.println("DONE WITH HEAP TEST");

         */
    }

}
