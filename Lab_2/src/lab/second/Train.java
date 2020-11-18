package lab.second;

public class Train {
    private int trainNum;
    private String destination;
    private int shipTime;
    private int common;
    private int comp;
    private int plats;
    private int lux;

    @Override
    public String toString() {
        return "Train:" +
                "num='" + trainNum + '\'' +
                ", destination='" + destination + '\'' +
                ", time=" + shipTime +
                ", common=" + common +
                " , comp=" + comp +
                " , plats=" + plats +
                " , lux=" + lux;
    }

    Train(int trainNum,String destination,int shipTime, int common, int comp, int plats, int lux){
        this.trainNum = trainNum;
        this.destination = destination;
        this.shipTime = shipTime;
        this.common = common;
        this.comp = comp;
        this.plats = plats;
        this.lux = lux;
    }

    public int getCommon() {
        return common;
    }

    public void setCommon(int common) {
        this.common = common;
    }

    public int getComp() {
        return comp;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public int getPlats() {
        return plats;
    }

    public void setPlats(int plats) {
        this.plats = plats;
    }

    public int getLux() {
        return lux;
    }

    public void setLux(int lux) {
        this.lux = lux;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getShipTime() {
        return shipTime;
    }

    public void setShipTime(int shipTime) {
        this.shipTime = shipTime;
    }

}
