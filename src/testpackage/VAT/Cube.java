package testpackage.VAT;

public class Cube implements Shape {

    private String name = "Cube";
    private Shapes type = Shapes.CUBE;
    private double width;
    private double height;
    private double length;

    public Cube(double width, double height, double length) {
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

    public double getLength() { return length; }

    public String getType(){ return type.name(); }

    public double calculateVolume(){
        return getWidth() * getHeight() * getLength();
    }

    public void saveToDatabase(){
        MyDatabase db = new MyDatabase();
        db.insertCube(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return name.equals(cube.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ": volume: " + calculateVolume();
    }
}
