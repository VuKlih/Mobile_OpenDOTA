package vn.edu.usth.usthopendotaclient.network.models;

import java.io.Serializable;

public class MmrEstimate implements Serializable {
    private int estimate;

    public int getEstimate() {
        return estimate;
    }

    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }
}
