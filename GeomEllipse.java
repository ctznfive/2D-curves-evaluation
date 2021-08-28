public class GeomEllipse implements GeomCurve2D{

    private final double semiMajorAxis;
    private final double semiMinorAxis;

    // initializes an ellipse with given semi-major and semi-minor axises
    public GeomEllipse(double semiMajorAxis, double semiMinorAxis) {
        if (semiMajorAxis <= 0 || semiMinorAxis <= 0)
            throw new IllegalArgumentException("The parameters should be positive.");
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    // return the corresponding semi-major axis
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    // return the corresponding semi-minor axis
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    // return a 2D point per parameter t along the ellipse
    public GeomPoint2D getPoint(double t) {
        if (t < 0 || t > 2 * Math.PI)
            throw new IllegalArgumentException("The parameter should be between 0 and 2 * PI.");

        return new GeomPoint2D(semiMajorAxis * Math.cos(t), semiMinorAxis * Math.sin(t));
    }

    // return a first derivative (2D vector) per parameter t along the ellipse
    public GeomVector2D getDerivative(double t) {
        if (t < 0 || t > 2 * Math.PI)
            throw new IllegalArgumentException("The parameter should be between 0 and 2 * PI.");

        return new GeomVector2D(-semiMajorAxis * Math.sin(t), semiMinorAxis * Math.cos(t));
    }

    // return a string representation of the ellipse
    @Override
    public String toString() {
        return "2D Ellipse: x(t) = " + semiMajorAxis + " * cos t; y(t) = " + semiMinorAxis + " * sin t; 0 <= t <= 2 * PI";
    }

    // test client
    public static void main(String[] args) {
        GeomCurve2D ellipseTest = new GeomEllipse(3, 2);
        double t = Math.PI / 2;

        System.out.println(ellipseTest.toString());
        System.out.println("C(" + t + ")  = " + ellipseTest.getPoint(t));
        System.out.println("C'(" + t + ") = " + ellipseTest.getDerivative(t));
    }
}
