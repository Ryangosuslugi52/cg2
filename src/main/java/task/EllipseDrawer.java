package task;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class EllipseDrawer {

    public static void drawEllipseFromTopLeft(WritableImage image, double x, double y, double width, double height, Color color) {
        double centerX = x + width / 2;
        double centerY = y + height / 2;
        double a = width / 2;
        double b = height / 2;
        drawEllipse(image, centerX, centerY, a, b, color);
    }

    public static void drawEllipseFromCenter(WritableImage image, double centerX, double centerY, double a, double b, Color color) {
        drawEllipse(image, centerX, centerY, a, b, color);
    }

    private static void drawEllipse(WritableImage image, double centerX, double centerY, double a, double b, Color color) {
        PixelWriter pixelWriter = image.getPixelWriter();

        double a2 = a * a;
        double b2 = b * b;
        double x = 0;
        double y = b;

        // первая часть
        double d1 = b2 - a2 * b + 0.25 * a2;
        while (b2 * x < a2 * y) {
            plotPoints(pixelWriter, centerX, centerY, x, y, color);
            if (d1 < 0) {
                d1 += b2 * (2 * x + 3);
            } else {
                d1 += b2 * (2 * x + 3) + a2 * (-2 * y + 2);
                y--;
            }
            x++;
        }

        // вторая часть
        double d2 = b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2;
        while (y >= 0) {
            plotPoints(pixelWriter, centerX, centerY, x, y, color);
            if (d2 > 0) {
                d2 += a2 * (-2 * y + 3);
            } else {
                d2 += b2 * (2 * x + 2) + a2 * (-2 * y + 3);
                x++;
            }
            y--;
        }
    }

    private static void plotPoints(PixelWriter pixelWriter, double centerX, double centerY, double x, double y, Color color) {
        // заливка
        pixelWriter.setColor((int) (centerX + x), (int) (centerY + y), color);
        pixelWriter.setColor((int) (centerX - x), (int) (centerY + y), color);
        pixelWriter.setColor((int) (centerX + x), (int) (centerY - y), color);
        pixelWriter.setColor((int) (centerX - x), (int) (centerY - y), color);
    }
}
