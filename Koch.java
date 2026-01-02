/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

       
		//curve(Integer.parseInt(args[0]),
		//	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		  //    Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		snowFlake(Integer.parseInt(args[0]));

	}

	public static void curve(int n, double x1, double y1, double x2, double y2) {
		 if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);   
            return;
        }

        double xA = x1 + (x2 - x1) / 3;
        double yA = y1 + (y2 - y1) / 3;

        double xB = x1 + 2 * (x2 - x1) / 3;
        double yB = y1 + 2 * (y2 - y1) / 3;

        double xC = (x1 + x2) / 2 - Math.sqrt(3) * (y1 - y2) / 6; 
		double yC = (y1 + y2) / 2 + Math.sqrt(3) * (x1 - x2) / 6;

        curve(n - 1, x1, y1, xA, yA);
        curve(n - 1, xA, yA, xC, yC);
        curve(n - 1, xC, yC, xB, yB);
        curve(n - 1, xB, yB, x2, y2);
	}

	public static void snowFlake(int n) {
		StdDraw.setYscale(-0.2, 1.1);
		StdDraw.setXscale(0, 1.1);
		
		double x1 = 0.1, y1 = 0.1;
        double x2 = 1.0, y2 = 0.1;
        double x3 = 0.55, y3 = 0.9;

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
	}
}
