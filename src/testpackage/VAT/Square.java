package testpackage.VAT;

public class Square implements Shape{

    private String name = "Square";
    private double width;
    private double height;

    public Square(double width, double height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public String getName() {
        return name;
    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double calculateVolume() {
        return getWidth() * getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return name.equals(square.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + " volume: " + calculateVolume();
    }
}