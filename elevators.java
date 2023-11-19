import java.util.*;
import java.io.*;
import java.util.Properties;
public class elevators {
    static String structures;
    static int floorNumber;
    static double passengers;
    static int elevatorNumber;
    static int elevatorCapacity;
    static int duration;

    public static void main(String[] args) throws Exception {
        // get all the system properties

        Properties prop = new Properties();
        if (args.length < 1) {

            FileReader propFile = new FileReader("db.properties");
            prop.load(propFile);

            structures = prop.getProperty("structures");
            floorNumber = Integer.parseInt(prop.getProperty("floors"));
            elevatorNumber = Integer.valueOf(prop.getProperty("elevators"));
            passengers = Double.valueOf(prop.getProperty("passengers"));
            elevatorCapacity = Integer.valueOf(prop.getProperty("elevatorCapacity"));
            duration = Integer.valueOf(prop.getProperty("duration"));

        } else {
            try {
                FileReader propFile = new FileReader(args[0]);
                prop.load(propFile);
            } catch (Exception e) {
                System.out.println("Error reading file");
            }
        }

        ElevatorSimulator simulation = new ElevatorSimulator();

        simulation.runSimulation();

//Questions -> when do we generate code for them to appear

        }
}