package lab.second;

import java.io.*;

public class Train {
    private String appoint ;
    private int hour,min;
    private int num;
    private int comm,comp,plat,lux;

    Train(){}

    public void printTrain(){
        System.out.format("%s %8d %8d:%d %10d,%d,%d,%d\n",appoint,num,hour,min,comm,comp,plat,lux);
    }

    public String getAppoint() {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public void setComp(int comp) {
        this.comp = comp;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public void setLux(int lux) {
        this.lux = lux;
    }
}
