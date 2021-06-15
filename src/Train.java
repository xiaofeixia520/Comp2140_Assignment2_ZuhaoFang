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
     * @param newCar: The data of added
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
     * @param newCar: The data of added
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

    /**********************************
     * Search list to find key if found it, turn it to null
     * @param key the train we wanna found it
     * @param num total train we dropped
     * @return
     ***********************************/
    public int drop(String key , int num){
        int actuallyDropped = 0;
        Node current = head;

        while (actuallyDropped < num && current != null){

            if(current.showLink().equals(key)){

                if(current == head){
                    head = current.next;
                    current.next.previous = null;
                }else if(current == tail){
                    tail = current.previous;
                    current.previous.next = null;
                }else{
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                actuallyDropped++;
            }
            current = current.next;
        }

        return actuallyDropped;
    }

    /*******************************************
     *  This is drop from first method, drop from first index's element
     *  if element of index are out of list, return null
     * @param index the order of element in list wanna drop
     * @return return that droped element
     */

    public Node dropFromFirst(int index){
        Node drop = head;
        for(int i = 1; i < index ; i++){   // point to index that need drop
            drop = drop.next;
        }

        if(drop == null){     //  if out of index of list, drop set to null and return
            drop = null;
            return drop;
        }else{
            if(drop == tail && !drop.showLink().equals("engine")){
                tail = drop.previous;
                drop.previous.next = null;
            }else if(drop == head && !drop.showLink().equals("engine")){
                head = drop.next;
                drop.next.previous = null;
            }else if(drop.showLink().equals("engine")){
                return drop;
            }else{
                drop.previous.next = drop.next;
                drop.next.previous = drop.previous;
            }
        }

        return drop;
    }

    /**************************************
     *  This is drop from last method, drop from last index's element
     *  if element of index are out of list, return null
     * @param index the order of element in list wanna drop
     * @return return that droped element
     */

    public Node dropFromLast(int index){
        Node drop = tail;
        for (int i = 1 ; i < index ; i++){        // point to index that need drop
            drop = drop.previous;
        }

        if(drop == null ){  //  if out of index of list, drop set to null and return
            drop = null;
            return drop;
        }else{
            if(drop == tail && !drop.showLink().equals("engine")){
                tail = drop.previous;
                drop.previous.next = null;
            }else if(drop == head && !drop.showLink().equals("engine")){
                head = drop.next;
                drop.next.previous = null;
            }else if(drop.showLink().equals("engine")){
                return drop;
            }else{
                drop.previous.next = drop.next;
                drop.next.previous = drop.previous;
            }
        }
        return drop;
    }

    /*************************************
     * traversal the list and get train type of each train car
     *
     *************************************/

    public String toString(){
        Node current = head;
        String theTrain = "The cars on the train are: ";
        while(current != null){
            theTrain += current.showLink();
            if(current.next != null){
                theTrain += " - ";
            }
            current = current.next;
        }
        return theTrain;
    }


    /***********************************
     * @return check node is empty or not
     ***********************************/
    public boolean isEmpty (){
        return (head == null);
    }
}
