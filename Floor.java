import java.util.ArrayList;

public class Floor {
    ArrayList<Passenger> queUp;

    ArrayList<Passenger> queDown;
    int floorNum;

    public Floor() {
        ArrayList<Passenger> queU = new ArrayList<Passenger>();
        ArrayList<Passenger> queD = new ArrayList<Passenger>();

        this.queUp = queU;
        this.queDown = queD;
    }

    void addPass(Passenger pass) {
        if (pass.StartFloor < pass.EndFloor) {
            this.queUp.add(pass);
        } else {
            this.queDown.add(pass);
        }
    }
    void setFloorNum(int givenNum) {
        floorNum = givenNum;
    }
    boolean upIsEmpty() {
        return queUp.isEmpty();
    }
    boolean downIsEmpty() {
        return queUp.isEmpty();
    }
}
