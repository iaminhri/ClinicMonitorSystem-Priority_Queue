//Clinic does the
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clinic{

    public Patient [] patients = new Patient[16];
    WaitQueue wq = new WaitQueue();

    public Clinic(){
        try{
            readData();
        }catch(FileNotFoundException e){
            System.out.println("Error: File Not Found.");
        }
    }

    public void readData() throws FileNotFoundException {
        //reads data from file
        File readFile = new File("H:\\DataStructure\\COSC2P03_A1_v2\\COSC2P03_A1_v2\\patients.txt");
        Scanner sc = new Scanner(readFile);

        int i = 0;

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            patients[i] = new Patient(s);
            i++;
        }
//        for(int j = 1; j < patients.length; j++){
//            System.out.println(patients[j]);
//        }
    }

    public void Monitor(){
        //WaitQueue Class functionality used in here.
        //Also uses Timer class Functionality.

        /**
         * patients added and removed in this function.
         * timer class is used for incrementing time and for checking whether
         * a patient is ready to enter the queue or not.
         */

//        String str = patients[patients.length-1].getTimeOfArrival();

//        int lastHour, lastMinute;
//        String temp[];
//        temp = str.split(":");
//
//        lastHour = Integer.parseInt(temp[0]);
//        lastMinute = Integer.parseInt(temp[1]);

        Timer timer = new Timer();

        /**
         * Calculates Time for clinic to run based first patient's arrival
         * and last patient's arrival;
         * + 15 added -> is for vx time for the last patient.
         */

//        int TimeForClinicRun = ( ( ( lastHour - maintainTimer.getHour() ) * 60 ) +
//         ((lastMinute > maintainTimer.getMinute()) ? lastMinute - maintainTimer.getMinute():
//           maintainTimer.getMinute() - lastMinute) );
        int TimeForClinicRun = (patients.length-1) * 15;
        System.out.println(TimeForClinicRun);

        int k = 0;
//        for(int i = 0; i < TimeForClinicRun; i++){ //problematic logic
//
////            System.out.println("Patient's Time: " + patients[k].getTimeOfArrival());
//
////            if(timer.compare(patients[k].getTimeOfArrival()) == 0){
////                System.out.println("Patient's Time: " + patients[k].getTimeOfArrival());
////                wq.insert(patients[k], calculatePriorityLevel(patients[k]));
////                k++;
////            }
//
//
////            timer.increase();
//        }

        System.out.println(timer.compare(patients[1].getTimeOfArrival()));
        timer.increase();

        while(true) {
            if(timer.compare(patients[4].getTimeOfArrival()) == 0){
                System.out.println("Timer Class: " + timer);
                System.out.println("Patient Entry Time: " + patients[4].getTimeOfArrival());
                System.out.println(timer.compare(patients[4].getTimeOfArrival()));
                break;
            }
            timer.increase();

        }


    }

    public int calculatePriorityLevel(Patient patient){
        int pL = 0;

        if(patient.getAge() >= 60)
            pL++;
        if(patient.getOccupation().equals("Teacher") ||
           patient.getOccupation().equals("Nurse") ||
           patient.getOccupation().equals("Care Giver"))
            pL++;
        if(patient.getHealthCondition().equals("Pregnant") ||
           patient.getHealthCondition().equals("Cancer") ||
           patient.getHealthCondition().equals("Diabetes") ||
           patient.getHealthCondition().equals("Asthma") ||
           patient.getHealthCondition().equals("Primary Immune Deficiency") ||
           patient.getHealthCondition().equals("Cardiovascular Disease"))
            pL++;

        return pL;
    }
}
