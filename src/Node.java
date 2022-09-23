class Node {
    Patient PatientData; // contains patient instance as data
    int priorityLevel; // contains priority level
    Node prev; // previous node
    Node next; // next node

    public Node(Patient PatientData, int priorityLevel){
        this.PatientData = PatientData;
        this.priorityLevel = priorityLevel;
        this.prev = null;
        this.next = null;
    }
    public Node(Patient PatientData, int priorityLevel, Node prev, Node next){
        this.PatientData = PatientData;
        this.priorityLevel = priorityLevel;
        this.prev = prev;
        this.next = next;
    }
}
