package com.pferrervich.core;

//TODO: Entity en restaurants
public class Restaurants {
    private String name;
    private String address;
    private String website;
    private String telephone;
    private String type;
    private String imgurl;
    private String codi;

    /**
     * Getters i setters dels parametres
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }
}

