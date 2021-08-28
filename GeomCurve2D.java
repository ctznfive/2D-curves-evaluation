public interface GeomCurve2D {

    // return a 2D point per parameter t along the curve
    GeomPoint2D getPoint(double t);

    // return a first derivative (2D vector) per parameter t along the curve
    GeomVector2D getDerivative(double t);
}
