package com.example.elad.android5777.model.entities;

import java.util.Date;

/**
 * Created by Elad on 22/11/2016.
 */

public class Active {

    private KindOfAction kind;
    private String country;
    private Date start;
    private Date end;
    private double price;
    private String description;
    private int BusinessId;

    public Active(KindOfAction kind, String country, Date start, Date end, double price, String description, int businessId) {
        this.kind = kind;
        this.country = country;
        this.start = start;
        this.end = end;
        this.price = price;
        this.description = description;
        BusinessId = businessId;
    }

    public KindOfAction getKind() {
        return kind;
    }

    public void setKind(KindOfAction kind) {
        this.kind = kind;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBusinessId() {
        return BusinessId;
    }

    public void setBusinessId(int businessId) {
        BusinessId = businessId;
    }
}
