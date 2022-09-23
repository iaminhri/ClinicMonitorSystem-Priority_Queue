//Usage of Priority Queue Here.
public class WaitQueue {
    //Attributes
    Node _dll_head;

    public WaitQueue(){
        _dll_head = null;
    }

    public void removeMax() {
        //remove Max using DL_List based on queue
    }

    /**
     * @param dataStream -> receives data from patients array.
     * @param priorityLevel -> assigns priority based on data
     */
    public void insert(Patient dataStream, int priorityLevel){
        //insert using DL_List based on queue
        Node newNode = new Node(dataStream, priorityLevel);;

        if(_dll_head == null) {
            _dll_head = newNode;
        }
        else{
            if(priorityLevel > _dll_head.priorityLevel) {
                _dll_head.prev = newNode;
                newNode.next = _dll_head;
                _dll_head = newNode;
            }
            else{
                Node rotator = _dll_head;
                while(rotator.next != null){
                    if(priorityLevel < rotator.priorityLevel){
                        break;
                    }
                    rotator = rotator.next;
                }

                if(rotator.next != null){
                    newNode.next = rotator.next;
                    rotator.next.prev = newNode;
                }

                rotator.next = newNode;
                newNode.prev = rotator;
            }
        }
    }

    public void display(){
        Node p = _dll_head;

        while(p != null){
            System.out.println("Data: " + p.PatientData
                    + " Priority Level: " + p.priorityLevel);
            p = p.next;
        }
    }
}
