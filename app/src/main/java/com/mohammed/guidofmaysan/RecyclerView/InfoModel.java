package com.mohammed.guidofmaysan.RecyclerView;

public class InfoModel {
    private int id;
    private String name;
    private byte [] image;
    private double x ;
    private double y ;

    public InfoModel(int id, String name, byte[] image, double x, double y) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public byte[] getImage() {
        return image;
    }

    int getId() {
        return id;
    }

}
