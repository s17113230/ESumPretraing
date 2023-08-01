package com.example.esumspring.model;

public class SeatingChart {
    private int FLOOR_SEAT_SEQ;
    private int FLOOR_NO;
    private int SEAT_NO;
    private int EMP_ID;

    public int getFLOOR_SEAT_SEQ() {
        return FLOOR_SEAT_SEQ;
    }

    public int getFLOOR_NO() {
        return FLOOR_NO;
    }

    public int getSEAT_NO() {
        return SEAT_NO;
    }

    public int getEMP_ID() {
        return EMP_ID;
    }

    public void setFLOOR_SEAT_SEQ(int FLOOR_SEAT_SEQ) {
        this.FLOOR_SEAT_SEQ = FLOOR_SEAT_SEQ;
    }

    public void setFLOOR_NO(int FLOOR_NO) {
        this.FLOOR_NO = FLOOR_NO;
    }

    public void setSEAT_NO(int SEAT_NO) {
        this.SEAT_NO = SEAT_NO;
    }

    public void setEMP_ID(int EMP_ID) {
        this.EMP_ID = EMP_ID;
    }
}
