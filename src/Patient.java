public class Patient {

    private String patientName;
    private String gender;
    private int age;
    private String occupation;
    private String healthCondition;
    private String timeOfArrival;

    public Patient(){
        patientName = null;
        gender = null;
        age = 0;
        occupation = null;
        healthCondition = null;
        timeOfArrival = null;
    }

    public Patient(String dataStream) throws NumberFormatException{
        String []temp = new String[6];
        temp = dataStream.split("\t");

        setPatientName( temp[0] );
        setGender( temp[1] );
        try{
            setAge( Integer.parseInt(temp[2]) );
        }catch (NumberFormatException e ){
            setAge(0);
        }
        setOccupation( temp[3] );
        setHealthCondition( temp[4] );
        setTimeOfArrival( temp[5] );

//
//        System.out.println(getPatientName());
//        System.out.println(getGender());
//        System.out.println(getAge());
//        System.out.println(getOccupation());
//        System.out.println(getHealthCondition());
//        System.out.println(getTimeOfArrival());
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(String timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public String toString(){
        return "Patient Name: [ " + patientName + " Gender: " + gender + " Age: " + age +
                " Occupation: " + occupation + " Health Condition: " + healthCondition +
                " TimeOfArrival: " + timeOfArrival + " ]";
    }
}


//
//        System.out.println(getPatientName());
//        System.out.println(getGender());
//        System.out.println(getAge());
//        System.out.println(getOccupation());
//        System.out.println(getHealthCondition());
//        System.out.println(getTimeOfArrival());