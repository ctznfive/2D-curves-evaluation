import java.util.ArrayList;
import java.util.Random;

public class Geom2DCurvesEvaluation {

    // generate a pseudorandom value between rangeMin and rangeMax
    public static double getRandomInRange(double rangeMin, double rangeMax) {
        if (rangeMin > rangeMax)
            throw new IllegalArgumentException("rangeMin shouldn't be greater than rangeMax");

        Random rand = new Random();
        double randomInRange = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
        return randomInRange;
    }

    // create a line with pseudorandom parameters between rangeMin and rangeMax
    public static GeomLine getRandomLine(double rangeMin, double rangeMax) {
        if (rangeMin > rangeMax)
            throw new IllegalArgumentException("rangeMin shouldn't be greater than rangeMax");

        GeomPoint2D o  = new GeomPoint2D(getRandomInRange(rangeMin, rangeMax), 
                getRandomInRange(rangeMin, rangeMax));
        GeomVector2D d = new GeomVector2D(getRandomInRange(rangeMin, rangeMax), 
                getRandomInRange(rangeMin, rangeMax));
        return new GeomLine(o, d);
    }

    // create an ellipse with pseudorandom parameters between rangeMin and rangeMax
    public static GeomEllipse getRandomEllipse(double rangeMin, double rangeMax) {
        if (rangeMin > rangeMax)
            throw new IllegalArgumentException("rangeMin shouldn't be greater than rangeMax");

        return new GeomEllipse(getRandomInRange(rangeMin, rangeMax), 
                getRandomInRange(rangeMin, rangeMax));
    }

    // populate a container of n objects created with pseudorandom parameters
    // in range between rangeMin and rangeMax
    public static void populateRandomCurves (ArrayList<GeomCurve2D> curves, int n, double rangeMin, double rangeMax) {
        for (int i = 0; i < n; i++) {
            int randType = new Random().nextInt(2);
            GeomCurve2D curve;
            if (randType == 0) {
                curve = getRandomLine(rangeMin, rangeMax);
            } else {
                if (rangeMin <= 0) rangeMin = 1.0e-16;
                curve = getRandomEllipse(rangeMin, rangeMax);
            }
            curves.add(curve);
        }
    }

    // print coordinates of points and derivatives of all curves in the container at parameter t
    public static void printCoordsAndDerivatives(ArrayList<GeomCurve2D> curves, double t) {
        for (GeomCurve2D curve : curves) {
            System.out.println(curve.toString());
            System.out.println("C(" + t + ")  = " + curve.getPoint(t));
            System.out.println("C'(" + t + ") = " + curve.getDerivative(t));
            System.out.println();
        }
    }

    // client
    public static void main(String[] args) {

        ArrayList<GeomCurve2D> curves = new ArrayList<>();

        int n = 100;
        double rangeMin = -100.0;
        double rangeMax = 100.0;
        populateRandomCurves(curves, n, rangeMin, rangeMax);

        // populate a container of objects created with hard-coded fixed parameters
        GeomPoint2D o1    = new GeomPoint2D(0, 0);
        GeomVector2D d1   = new GeomVector2D(1, 5);
        GeomCurve2D line1 = new GeomLine(o1, d1);

        GeomPoint2D o2    = new GeomPoint2D(1, 1);
        GeomVector2D d2   = new GeomVector2D(4, 2);
        GeomCurve2D line2 = new GeomLine(o2, d2);

        GeomCurve2D ellipse1 = new GeomEllipse(5, 2);
        GeomCurve2D ellipse2 = new GeomEllipse(9, 7);

        curves.add(line1);
        curves.add(line2);
        curves.add(ellipse1);
        curves.add(ellipse2);

        double t = Math.PI / 4;
        printCoordsAndDerivatives(curves, t);
    }
}
