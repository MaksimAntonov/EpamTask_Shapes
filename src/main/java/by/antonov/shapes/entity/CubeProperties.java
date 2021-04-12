package by.antonov.shapes.entity;

public class CubeProperties {
    private long id;
    private double volume;
    private double sideSquare;
    private double cubeSquare;
    private Point oppositePoint;

    public CubeProperties(long id, double volume, double sideSquare, double cubeSquare) {
        this.id = id;
        this.volume = volume;
        this.sideSquare = sideSquare;
        this.cubeSquare = cubeSquare;
    }

    public CubeProperties(long id, double volume, double sideSquare, double cubeSquare, Point oppositePoint) {
        this.id = id;
        this.volume = volume;
        this.sideSquare = sideSquare;
        this.cubeSquare = cubeSquare;
        this.oppositePoint = oppositePoint;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSideSquare() {
        return sideSquare;
    }

    public void setSideSquare(double sideSquare) {
        this.sideSquare = sideSquare;
    }

    public double getCubeSquare() {
        return cubeSquare;
    }

    public void setCubeSquare(double cubeSquare) {
        this.cubeSquare = cubeSquare;
    }

    public Point getOppositePoint() {
        return oppositePoint;
    }

    public void setOppositePoint(Point oppositePoint) {
        this.oppositePoint = oppositePoint;
    }
}
