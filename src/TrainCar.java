public class TrainCar {
    private int oil;
    private int wheat;
    private int lumber;
    private boolean engine = false;  // if is false, this train isn't engine, true: this rain is engine

    public TrainCar(int oil , int wheat , int lumber , boolean Engine){
        this.oil = oil;
        this.wheat = wheat;
        this.lumber = lumber;
        this.engine = Engine;
    }

    public int getOil(){
        return oil;
    }

    public int getWheat(){
        return wheat;
    }

    public int getLumber(){
        return lumber;
    }

    public boolean getEngine(){
        return engine;
    }


}
