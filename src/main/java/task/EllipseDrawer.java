package task;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseDrawer {

    // левый верхний
    public static Ellipse drawEllipseFromTopLeft(double x, double y, double width, double height) {
        double centerX = x + width / 2;
        double centerY = y + height / 2;

        Ellipse ellipse = new Ellipse(centerX, centerY, width / 2, height / 2);
        ellipse.setStroke(Color.BLUE);
        ellipse.setFill(null);
        return ellipse;
    }

    // центр и полуоси
    public static Ellipse drawEllipseFromCenter(double centerX, double centerY, double a, double b) {
        Ellipse ellipse = new Ellipse(centerX, centerY, a, b);
        ellipse.setStroke(Color.RED);
        ellipse.setFill(null);
        return ellipse;
    }
}