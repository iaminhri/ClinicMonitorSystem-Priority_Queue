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
        this.vxtime = 1;

    }

    public boolean increase(){
        int m = this.minute;
        int v = this.vxtime;
        int h = this.hour;

        if(m == 60) {
            h++;
            m = 0;
        }

        m++;
        v++;

        this.minute = m;
        this.vxtime = v;
        this.hour = h;

        if(v == 15) {
            this.vxtime = 0;
            return true;
        }
        else
            return false;
    }

    public int compare(String clinicData) {

        /**  if hour is less than adds 0 before the digit else keeps the same value  */


        this.fStr = convertToString(this.hour, this.minute);

        System.out.println("Final String of Time: " + fStr);
        // compares two strings and contains
        int comp = fStr.compareTo(clinicData);

        if(clinicData.equals(fStr))
            return 0;
        else if(comp < 0)
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

    public int getVxtime() {
        return vxtime;
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


//System.out.println("Hour: " + this.hour + "Minute: " + this.minute);
//

