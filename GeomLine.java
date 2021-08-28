public class GeomLine implements GeomCurve2D {

    private final GeomPoint2D o;
    private final GeomVector2D d;

    // initializes a line with given origin point o and directional vector d: C(t) = O + D*t
    public GeomLine(GeomPoint2D o, GeomVector2D d) {
        this.o = o;
        this.d = d;
    }

    // return the corresponding origin point (o)
    public GeomPoint2D getO() {
        return o;
    }

    // return the corresponding directional vector (d)
    public GeomVector2D getD() {
        return d;
    }

    // return a 2D point per parameter t along the line
    public GeomPoint2D getPoint(double t) {
       double x1 = this.o.getX();
       double y1 = this.o.getY();

       double aX = this.d.getX();
       double aY = this.d.getY();

       double x = x1 + aX * t;
       double y = y1 + aY * t;
       return new GeomPoint2D(x, y);
   }

    // return a first derivative (2D vector) per parameter t along the line
   public GeomVector2D getDerivative(double t) {
        return d;
   }

    // return a string representation of the line
    @Override
    public String toString() {
        return "2D Line: C(t) = " + o.toString() + " + " + d.toString() + " * t";
    }

    // test client
    public static void main(String[] args) {
        GeomPoint2D o = new GeomPoint2D(-1, -4.5);
        GeomVector2D d = new GeomVector2D(1.5, 5.0);
        GeomCurve2D lineTest = new GeomLine(o, d);
        double t = 1.0;

        System.out.println(lineTest.toString());
        System.out.println("C(" + t + ")  = " + lineTest.getPoint(t));
        System.out.println("C'(" + t + ") = " + lineTest.getDerivative(t));
    }
}
