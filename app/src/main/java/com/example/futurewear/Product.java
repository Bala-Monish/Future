package com.example.futurewear;

import java.io.Serializable;

public class Product implements Serializable{
    private  String Description;
    private String Productname;
    private int productid;
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }



    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }


}
