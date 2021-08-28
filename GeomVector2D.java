public class GeomVector2D {

    private final double x;
    private final double y;

    // initializes a vector with given Cartesian coordinates x and y
    public GeomVector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // return the corresponding coordinate (x)
    public double getX() {
        return this.x;
    }

    // return the corresponding coordinate (y)
    public double getY() {
        return this.y;
    }

    // return the Euclidean norm of this vector
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    // return the inner product of two vectors
    public double dot(GeomVector2D that) {
        return this.x * that.x + this.y * that.y;
    }

    // return the distance between two vectors
    public double distanceTo(GeomVector2D that) {
        return this.minus(that).magnitude();
    }

    // return the sum of two vectors
    public GeomVector2D plus(GeomVector2D that) {
        GeomVector2D vect = new GeomVector2D(this.x + that.x, this.y + that.y);
        return vect;
    }

    // return the difference of two vectors
    public GeomVector2D minus(GeomVector2D that) {
        GeomVector2D vect = new GeomVector2D(this.x - that.x, this.y - that.y);
        return vect;
    }

    // create and return a new object whose value is (this * factor)
    public GeomVector2D scale(double factor) {
        GeomVector2D vect = new GeomVector2D(factor * this.x, factor * this.y);
        return vect;
    }

    // return the corresponding unit vector
    public GeomVector2D direction() {
        if (this.magnitude() == 0.0)
            throw new ArithmeticException("zero-vector has no direction");
        return this.scale(1.0 / this.magnitude());
    }

    // return a string representation of the vector
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // test client
    public static void main(String[] args) {
        GeomVector2D a = new GeomVector2D(1.2, 2.5);
        GeomVector2D b = new GeomVector2D(5.8, 3.5);

        System.out.println("a       = " + a);
        System.out.println("b       = " + b);
        System.out.println("|a|     = " + a.magnitude());
        System.out.println("5a      = " + a.scale(5.0));
        System.out.println("a + b   = " + a.plus(b));
        System.out.println("a - b   = " + a.minus(b));
        System.out.println("|a + b| = " + a.plus(b).magnitude());
        System.out.println("|a - b| = " + a.minus(b).magnitude());
        System.out.println("<a, b>  = " + a.dot(b));
    }
}
