public class Train {
    private Node head;   // The next pointer
    private Node tail; // The previous pointer
    private TrainCar train;

    public Train(){
        head = null;
        tail = head;
    }


    /***********************************
     * The add method to add item at front to doubly linked list
     ***********************************/
    public void addAtHead (TrainCar newCar){
        Node newNode = new Node(newCar);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    /***********************************
     *  the add method to add item at end to doubly linked list
     * @param newCar
     ***********************************/

    public void addAtAfter(TrainCar newCar){
        Node newNode = new Node(newCar);
        if(isEmpty()){
            head = newNode;
        }else{
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void traversalStartHead(){
        Node current = head;
        String theTrain = "The cars on the train are: ";
        while(current != null){
            //theTrain
        }
    }


    /***********************************
     *
     * @return check node is empty or not
     ***********************************/
    public boolean isEmpty (){
        return (head == null);
    }
}
