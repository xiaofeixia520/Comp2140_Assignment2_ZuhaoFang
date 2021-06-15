public class Node {
    TrainCar data;
    Node next;   // The next pointer
    Node behind;  // The previous pointer

    public Node (TrainCar data){
        this.data = data;
    }
}
