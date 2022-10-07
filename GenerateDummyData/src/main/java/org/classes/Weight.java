package org.classes;

import java.util.Date;

public class Weight {
    private String userEmail;
    private double poundage;
    private Date date;
    private int units;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public double getPoundage() {
        return poundage;
    }

    public void setPoundage(double poundage) {
        this.poundage = poundage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
