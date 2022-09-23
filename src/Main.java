public class Main {
    public static void main(String[] args) throws Exception{
        Clinic c1 = new Clinic();

        c1.readData();

        c1.Monitor();
        c1.wq.display();
    }
}
