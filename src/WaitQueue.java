//Usage of Priority Queue Here.
public class WaitQueue {
    //Attributes
    Node _dll_head;
    Node front, rear;
    int priorityLevel;

    public WaitQueue(){
        _dll_head = null;
        front = rear = null;
        priorityLevel = 0;
    }

    public Node removeMax() {
        Node temp;
        //remove Max using DL_List based on queue
        if(front.next == null){
            front = null;
            _dll_head = null;
        }
        else{
            front = front.next;
            front.prev = null;
            _dll_head = front;
        }
        temp = front;

        return front;
    }

    /**
     * @param dataStream -> receives data from patients array.
     * @param priorityLevel -> assigns priority based on data
     */
    public void insert(Patient dataStream, int priorityLevel){
        //insert using DL_List based on queue
        Node newNode = new Node(dataStream, priorityLevel);
        Node p;

        if(_dll_head == null || front == null) {
            _dll_head = newNode;
            front = rear = _dll_head;
        }
        else if(priorityLevel > front.priorityLevel){
            newNode.next = front.next;
            if(front.next != null){
                front.next.prev = newNode;
            }
            front.next = newNode;
            newNode.prev = front;
        }
        else{
            p = front;

            while(p.next != null){
                if(priorityLevel > p.priorityLevel){
                    break;
                }
                p = p.next;
            }
            if(priorityLevel > p.priorityLevel){
                newNode.prev = p.prev;
                if(p.prev != null){
                    p.prev.next = newNode;
                }
                p.prev = newNode;
                newNode.next = p;
            }
            else if(priorityLevel <= rear.priorityLevel &&
                    ( dataStream.getTimeOfArrival().compareTo(rear.PatientData.getTimeOfArrival()) > 0 )){
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
            else{
                p = front;

                while(p.next != null && priorityLevel == p.priorityLevel &&
                      dataStream.getTimeOfArrival().compareTo(p.PatientData.getTimeOfArrival()) < 0){
                    p = p.next;
                }

                if(dataStream.getTimeOfArrival().compareTo(p.PatientData.getTimeOfArrival()) < 0){
                    //adding node before
                    newNode.next = p.next;
                    if(p.next != null)
                        p.next.prev = newNode;
                    p.next = newNode;
                    newNode.prev = p;
                }
                else{
                    //adding node after.
                    newNode.next = p.next;
                    if(p.next != null){
                        p.next.prev = newNode;
                    }
                    p.next = newNode;
                    newNode.prev = p;
                }

            }
        }
    }

    public Node getPeekItem(){
        return _dll_head;
    }
}