# 2D curves evaluation application

### A small program in Java that implement support of 2D curves hierarchy.
1. Supports two types of 2D geometric curves – lines and ellipses. Each curve returns a 2D point and a first derivative (2D vector) per parameter t along the curve.
2. Populates a container of objects of these types created with random or fixed parameters.
3. Prints coordinates of points and derivatives of all curves in the container at t=PI/4.

#### Curve definitions:
- All curves are parametrically defined, i.e. a point is calculated using some C(t) formula.
- Line is defined by its origin point O and direction D: C(t) = O + D*t.
- Ellipse is defined by its two radii, along X and Y axes.

---

### Usage:

Compile:

    javac Geom2DCurvesEvaluation.java

Run:

    java Geom2DCurvesEvaluation

or

    java Geom2DCurvesEvaluation > results.txt

    less results.txt

---

#### API:

##### public class GeomPoint2D
  
    - GeomPoint2D(double x, double y)
    initializes a point with given Cartesian coordinates x and y

    - double getX()
    return the corresponding coordinate (x)
    
    - double getY()
    return the corresponding coordinate (y)

    - String toString()
    return string representation of current point
    
    - boolean equals(Object o)
    return false if different points are compared

    - double distanceTo(GeomPoint2D that)
    return the distance between the two points
    
##### public class GeomVector2D

    - GeomVector2D(double x, double y)
    initializes a vector with given Cartesian coordinates x and y

    - double getX()
    return the corresponding coordinate (x)

    - double getY()
    return the corresponding coordinate (y)

    - double magnitude()
    return the Euclidean norm of this vector

    - double dot(GeomVector2D that)
    return the inner product of two vectors

    - double distanceTo(GeomVector2D that)
    return the distance between two vectors

    - GeomVector2D plus(GeomVector2D that)
    return the sum of two vectors

    - GeomVector2D minus(GeomVector2D that)
    return the difference of two vectors
    
    - GeomVector2D scale(double factor)
    create and return a new object whose value is (this * factor)
    
    - GeomVector2D direction()
    return the corresponding unit vector

    - String toString()
    return a string representation of the vector
    
##### public interface GeomCurve2D

    - GeomPoint2D getPoint(double t)
    return a 2D point per parameter t along the curve

    - GeomVector2D getDerivative(double t)
    return a first derivative (2D vector) per parameter t along the curve
    
##### public class GeomLine implements GeomCurve2D

    - GeomLine(GeomPoint2D o, GeomVector2D d)
    initializes a line with given origin point o and directional vector d: C(t) = O + D*t

    - GeomPoint2D getO()
    return the corresponding origin point (o)

    - GeomVector2D getD()
    return the corresponding directional vector (d)

    - GeomPoint2D getPoint(double t)
    return a 2D point per parameter t along the line

    - GeomVector2D getDerivative(double t)
    return a first derivative (2D vector) per parameter t along the line

    - String toString()
    return a string representation of the line

##### public class GeomEllipse implements GeomCurve2D

    - GeomEllipse(double semiMajorAxis, double semiMinorAxis)
    initializes an ellipse with given semi-major and semi-minor axises

    - double getSemiMajorAxis()
    return the corresponding semi-major axis
 
    - double getSemiMinorAxis()
    return the corresponding semi-minor axis

    - GeomPoint2D getPoint(double t)
    return a 2D point per parameter t along the ellipse

    - GeomVector2D getDerivative(double t)
    return a first derivative (2D vector) per parameter t along the ellipse
    
    - String toString()
    return a string representation of the ellipse
