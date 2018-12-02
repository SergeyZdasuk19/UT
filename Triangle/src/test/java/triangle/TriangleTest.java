package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class TriangleTest {

    @DataProvider(name = "checkTriangleProvider")
    public Object[][] createTriangle() {
        return new Object[][]{
                {
                        "a<=0", new ArrayList<Double>(Arrays.asList(0.0, 2.0, 2.0))
                },
                {
                        "b<=0", new ArrayList<Double>(Arrays.asList(2.0, 0.0, 2.0))
                },
                {
                        "c<=0", new ArrayList<Double>(Arrays.asList(2.0, 2.0, 0.0))
                },
                {
                        "a+b<=c", new ArrayList<Double>(Arrays.asList(2.0, 2.0, 5.0))
                },
                {
                        "a+c<=b", new ArrayList<Double>(Arrays.asList(2.0, 5.0, 2.0))
                },
                {
                        "b+c<=a", new ArrayList<Double>(Arrays.asList(5.0, 2.0, 2.0))
                },
                {
                        "", new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0))
                },
                {
                        "", new ArrayList<Double>(Arrays.asList(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE))
                },
                {
                        "", new ArrayList<Double>(Arrays.asList(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY))
                },
                {
                        "", new ArrayList<Double>(Arrays.asList(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY))
                }

        };
    }

    @DataProvider(name = "checkTriangleProvider2")
    public Object[][] detect() {
        return new Object[][]{
                {
                        3, new ArrayList<Double>(Arrays.asList(2.0, 2.0, 2.0))
                },
                {
                        2, new ArrayList<Double>(Arrays.asList(1.0, 2.0, 2.0))
                },
                {
                        8, new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0))
                },
                {
                        8, new ArrayList<Double>(Arrays.asList(5.0, 3.0, 4.0))
                },
                {
                        8, new ArrayList<Double>(Arrays.asList(3.0, 5.0, 4.0))
                }

        };
    }
    @DataProvider(name = "createForGetSquare")
    public Object[][] getSquare() {
        return new Object[][]{
                {
                        1.7320508075688772, new ArrayList<Double>(Arrays.asList(2.0, 2.0, 2.0))
                }


        };
    }
    @Test(dataProvider = "checkTriangleProvider")
    public void testCheckTriangle(String name, ArrayList<Double> parameteres) {

        Triangle object = new Triangle(parameteres.get(0), parameteres.get(1), parameteres.get(2));
        object.checkTriangle();
        assertEquals(object.getMessage(), name);
    }

    @Test(dataProvider = "checkTriangleProvider2")
    public void testDetectTriangle(int io, ArrayList<Double> parameteres) {
        Triangle object = new Triangle(parameteres.get(0), parameteres.get(1), parameteres.get(2));
        assertEquals(object.detectTriangle(), io);
    }

    @Test(dataProvider = "createForGetSquare")
    public void testGetSquare(double expected, ArrayList<Double> parameteres) {
        Triangle object = new Triangle(parameteres.get(0), parameteres.get(1), parameteres.get(2));
        assertEquals(expected,object.getSquare());
    }
}