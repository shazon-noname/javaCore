package EncapsulationProject.example;

public final class Dimensions {
    private final double width;
    private final double height;
    private final double length;


    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }


    public double calculateVolume() {
        return width * height * length;
    }


    public Dimensions withDimensions(double width, double height, double length) {
        return new Dimensions(width, height, length);
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
