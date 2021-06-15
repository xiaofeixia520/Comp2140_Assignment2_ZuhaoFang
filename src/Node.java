public class Node {
    TrainCar data;
    Node next;   // The next pointer
    Node previous;  // The previous pointer

    public Node (TrainCar data){
        super();
        this.data = data;
    }

    public String showLink(){
        String carType = "";
        if(data.getWheat() != 0){
            carType = "wheat";
        }else if(data.getOil() != 0){
            carType = "oil";
        }else if(data.getLumber() != 0){
            carType = "lumber";
        }else if(data.getEngine() != false){
            carType = "engine";
        }
        return carType;
    }
}
