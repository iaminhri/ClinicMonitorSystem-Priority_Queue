import java.util.Comparator;

public class Timer{
    Clinic testClinic = new Clinic();
    int hour;
    int minute; // resets every 60 minutes
    int vxtime; // resets every 15 minutes // required time to be vaccinated.
    String fStr;
    String str, str1;

    String []temp;

    public Timer(){
        temp = testClinic.patients[1].getTimeOfArrival().split(":");

        this.hour = Integer.parseInt(temp[0]);
        this.minute = Integer.parseInt(temp[1]);
        this.vxtime = 0;
    }

    public boolean increase(){

        this.minute++;
        this.vxtime++;

        if(this.minute == 60) {
            this.hour++;
            this.minute = 0;
        }

        if(this.vxtime >= 15) {
            this.vxtime = 0;
            return true; // remove from clinic
        }
        else
            return false; // is In clinic
    }

    public int compare(String clinicData) {

        /**  if hour is less than adds 0 before the digit else keeps the same value  */

        this.fStr = convertToString(this.hour, this.minute);

        if(clinicData.equals(fStr))
            return 0;
        else if(fStr.compareTo(clinicData) < 0)
            return -1;
        else
            return 1;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String convertToString(int hour, int minute){
        if(getHour() < 10)
            str = "0" + this.hour;
        else
            str = "" + this.hour;

        /**  if minute is less than adds 0 before the digit else keeps the same value  */
        if(getMinute() < 10)
            str1 = "0" + this.minute;
        else
            str1 = "" + this.minute;
        return str + ":" + str1;
    }

    public String toString(){
        return convertToString(this.hour, this.minute);
    }
}
