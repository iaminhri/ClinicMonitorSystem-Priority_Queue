//Clinic does the
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Clinic{

    public Patient [] patients = new Patient[17];
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
        Scanner input = new Scanner(readFile);

        int i = 0;
        while(input.hasNextLine()){
            String s = input.nextLine();
            patients[i] = new Patient(s);
            i++;
        }
    }

    public void Monitor(){
        //WaitQueue Class functionality used in here.
        //Also uses Timer class Functionality.

        /**
         * patients added and removed in this function.
         * timer class is used for incrementing time and for checking whether
         * a patient is ready to enter the queue or not.
         */

        Timer timer = new Timer();

        /**
         * Calculates Time for clinic to run based first patient's arrival
         * and last patient's arrival;
         * + 15 added -> is for vx time for the last patient.
         */

        int TimeForClinicRun = (patients.length-1) * 15;


        int k = 1;
        for(int i = 0; i < TimeForClinicRun; i++){ //problematic logic
            if(k <= 15 && timer.compare(patients[k].getTimeOfArrival()) == 0
                    ){ //Inserts patients in the queue.
                wq.insert(patients[k], calculatePriorityLevel(patients[k]));
                k++;
            }
            if(timer.increase() && wq != null){ //Removes Patients from queue.
                try{
                    System.out.println("Patient Name: " + wq.getPeekItem().PatientData.getPatientName()
                            + " Arrival Time: " + wq.getPeekItem().PatientData.getTimeOfArrival()
                            + " Check Out Time: " + timer);
                    wq.removeMax();
                }catch(NullPointerException e){
                    System.out.println(" ");
                }
            }
            if( k >= 16)
                patients = null;
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