import java.util.PriorityQueue;
public class Elevator {
    boolean up;
    int ElevFloor;

    PriorityQueue<Passenger> stopUp;
    PriorityQueue<Passenger> stopDown;
    public Elevator() {
        this.ElevFloor = 1;
        up = true;
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

    }

    public void requestStop() {

    }

}
