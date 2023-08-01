package com.example.esumspring.model;

public class Employee {
    private int EMP_ID;
    private String NAME;
    private String EMAIL;
    private int FLOOR_SEAT_SEQ;

    public int getEMP_ID() {
        return EMP_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public int getFLOOR_SEAT_SEQ() {
        return FLOOR_SEAT_SEQ;
    }

    public void setEMP_ID(int EMP_ID) {
        this.EMP_ID = EMP_ID;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    public void setFLOOR_SEAT_SEQ(int FLOOR_SEAT_SEQ) {
        this.FLOOR_SEAT_SEQ = FLOOR_SEAT_SEQ;
    }
}
