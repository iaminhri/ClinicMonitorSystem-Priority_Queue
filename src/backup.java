////Usage of Priority Queue Here.
//public class WaitQueue {
//    //Attributes
//    Node _dll_head;
//    Node front, rear;
//    int priorityLevel;
//
//    public WaitQueue(){
//        _dll_head = null;
//        front = rear = null;
//        priorityLevel = 0;
//    }
//
//    public Node removeMax() {
//        Node temp = front;
//        //remove Max using DL_List based on queue
//        if(front == null){
//            return null;
//        }
//        else{
//            this.front = front.next;
//            if(this.front != null){
//                _dll_head = this.front;
//                this.front.prev = null;
//            }
//            else{
//                rear = null;
//            }
//        }
//        return temp;
//    }
//
//    /**
//     * @param dataStream -> receives data from patients array.
//     * @param priorityLevel -> assigns priority based on data
//     */
//    public void insert(Patient dataStream, int priorityLevel, int isInVXClinic){
//        //insert using DL_List based on queue
//        Node newNode = new Node(dataStream, priorityLevel);
//
//        if(_dll_head == null || front == null) {
//            _dll_head = newNode;
//            front = rear = _dll_head;
//        }
//        else{
//            if(priorityLevel > front.priorityLevel &&
//                    ( dataStream.getTimeOfArrival().compareTo(
//                            front.PatientData.getTimeOfArrival()) > 0 ) ){
//                System.out.println("isInClinic: " + isInVXClinic);
//                if(isInVXClinic == 0){
////                    if(front.next != null ){
////                        front.next.prev = newNode;
////                        newNode.next = front.next;
////                    }
////                    front.next = newNode;
////                    newNode.prev = front;
//                    Node p = _dll_head;
//
//                    while(p.next != null){
//                        if(priorityLevel > p.next.priorityLevel) {
//                            break;
//                        }
//                        p = p.next;
//                    }
//                    if(p.next != null){
//                        p.next.prev = newNode;
//                        newNode.next = p.next;
//                    }
//                    p.next = newNode;
//                    newNode.prev = p;
//                }
//                else{
//                    front.prev = newNode;
//                    newNode.next = front;
//                    _dll_head = newNode;
//                    front = _dll_head;
//                }
//            }
//            else if(priorityLevel <= rear.priorityLevel &&
//                    ( dataStream.getTimeOfArrival().compareTo(
//                            rear.PatientData.getTimeOfArrival()) > 0 )){
//                rear.next = newNode;
//                newNode.prev = rear;
//                rear = newNode;
//            }
////            else{
////                Node rotator = _dll_head;
////                while(rotator.next != null){
////                    if(priorityLevel == rotator.priorityLevel &&
////                            ( dataStream.getTimeOfArrival().compareTo(
////                               rotator.PatientData.getTimeOfArrival()) > 0 ) ) {
////                            break;
////                    }
////                    rotator = rotator.next;
////                }
////
////                if(rotator.next != null){
////                    newNode.next = rotator.next;
////                    rotator.next.prev = newNode;
////                }
////
////                rotator.next = newNode;
////                newNode.prev = rotator;
////            }
//        }
//    }
//
//    public void display(){
//        Node p = _dll_head;
//
//        while(p != null){
//            System.out.println("Patient Name: " + p.PatientData.getPatientName()
//                    + "Arrival Time: " + p.PatientData.getTimeOfArrival()
//                    + "\n Priority Level: " + p.priorityLevel);
//            p = p.next;
//        }
//    }
//    public void topItem(Node top){
//        System.out.println("[Deleted Item: Patient Name: " + top.PatientData.getPatientName()
//                + "Arrival Time: " + top.PatientData.getTimeOfArrival()
//                + "\nPriority Level: " + top.priorityLevel + " ]");
//    }
//}
//
//
////    public void insert(Patient dataStream, int priorityLevel){
////        //insert using DL_List based on queue
////        Node newNode = new Node(dataStream, priorityLevel);
////
////        if(_dll_head == null) {
////            _dll_head = newNode;
////            front = rear = _dll_head;
////        }
////        else{
////            if(priorityLevel > _dll_head.priorityLevel) {
////                _dll_head.prev = newNode;
////                newNode.next = _dll_head;
////                _dll_head = newNode;
////                front = newNode;
////            }
////            else{
////                Node rotator = _dll_head;
////
////                if(dataStream.getTimeOfArrival().
////                        compareTo(rear.PatientData.getTimeOfArrival()) > 0
////                        && priorityLevel == rotator.priorityLevel){
////                    rear.next = newNode;
////                    newNode.prev = rear;
////                    rear = newNode;
////                }
////
////                while(rotator.next != null){
////                    if(rotator.priorityLevel <= priorityLevel){
////                        break;
////                    }
////                    rotator = rotator.next;
////                }
////
////                if(rotator.next != null){
////                    newNode.next = rotator.next;
////                    rotator.next.prev = newNode;
////                }
////
////                rotator.next = newNode;
////                newNode.prev = rotator;
////            }
////        }
////        front = _dll_head;
////        rear = newNode;
////    }


//            if(priorityLevel <= front.priorityLevel &&
//                    ( dataStream.getTimeOfArrival().compareTo(
//                            front.PatientData.getTimeOfArrival()) > 0 ) ){
//                System.out.println("isInClinic: " + isInVXClinic);
//
//                if(front.next != null){
//                    newNode.next = front.next;
//                    front.next.prev = newNode;
//                }
//
//                front.next = newNode;
//                newNode.prev = front;
//            }
//            else if(priorityLevel >= front.priorityLevel &&
//                    ( dataStream.getTimeOfArrival().compareTo(
//                            front.PatientData.getTimeOfArrival()) > 0 ) ){
//                System.out.println("isInClinic: " + isInVXClinic);
//
//                front.prev = newNode;
//                newNode.next = front;
//                _dll_head = newNode;
//                front = _dll_head;
//            }