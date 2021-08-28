public class GeomPoint2D {

    private final double x;
    private final double y;

    // initializes a point with given Cartesian coordinates x and y
    public GeomPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // return the corresponding coordinate (x)
    public double getX() {
        return x;
    }

    // return the corresponding coordinate (y)
    public double getY() {
        return y;
    }

    // return string representation of current point
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // return false if different points are compared
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeomPoint2D that = (GeomPoint2D) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    // return the distance between the two points
    public double distanceTo(GeomPoint2D that) {
        double deltaX = this.x - that.x;
        double deltaY = this.y - that.y;
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }

    // test client
    public static void main(String[] args) {
        GeomPoint2D pointA = new GeomPoint2D(-1.6, 0.6);
        GeomPoint2D pointB = new GeomPoint2D(2.5, 4.2);

        System.out.println("point A  = " + pointA);
        System.out.println("Ax  = " + pointA.getX());
        System.out.println("Ay  = " + pointA.getY());

        System.out.println("point B  = " + pointB);
        System.out.println("Bx  = " + pointB.getX());
        System.out.println("By  = " + pointB.getY());

        System.out.println("distance(point A, point B) = " + pointA.distanceTo(pointB));
        System.out.println("distance(point A, point A) = " + pointA.distanceTo(pointA));

        System.out.println("are points A and B the same? " + pointA.equals(pointB));
        System.out.println("are points A and A the same? " + pointA.equals(pointA));
    }
}
