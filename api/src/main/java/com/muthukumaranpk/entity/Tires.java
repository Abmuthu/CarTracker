package com.muthukumaranpk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by muthukumaran on 5/26/17.
 */
@Entity
public class Tires {
    @Id
    private String vin;

    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tires tires = (Tires) o;

        if (frontLeft != tires.frontLeft) return false;
        if (frontRight != tires.frontRight) return false;
        if (rearLeft != tires.rearLeft) return false;
        if (rearRight != tires.rearRight) return false;
        return vin != null ? vin.equals(tires.vin) : tires.vin == null;
    }

    @Override
    public int hashCode() {
        int result = vin != null ? vin.hashCode() : 0;
        result = 31 * result + frontLeft;
        result = 31 * result + frontRight;
        result = 31 * result + rearLeft;
        result = 31 * result + rearRight;
        return result;
    }


    @Override
    public String toString() {
        return "Tires{" +
                "vin='" + vin + '\'' +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}

