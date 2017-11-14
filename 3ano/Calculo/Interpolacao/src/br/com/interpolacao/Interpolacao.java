package br.com.interpolacao;

/**
 *
 * @author carrion
 */
public class Interpolacao {

    private double x;
    private double x0;
    private double x1;
    private double x2;

    private double y0;
    private double y1;
    private double y2;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Interpolacao{" +
                "\n"+
                " x0 = " + x0 +
                ", x1 = " + x1 +
                ", x2 = " + x2 + "\n"+
                " y0 = " + y0 +
                ", y1 = " + y1 +
                ", y2 = " + y2 +"\n"+
                "x = " + x + "\n"+
                '}';
    }
}
