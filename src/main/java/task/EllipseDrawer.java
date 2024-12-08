package task;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class EllipseDrawer {

    public static void drawEllipseFromTopLeft(WritableImage image, int x, int y, int width, int height, Color color) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        int a = width / 2;
        int b = height / 2;
        drawEllipse(image, centerX, centerY, a, b, color);
    }

    public static void drawEllipseFromCenter(WritableImage image, int centerX, int centerY, int a, int b, Color color) {
        drawEllipse(image, centerX, centerY, a, b, color);
    }

    private static void drawEllipse(WritableImage image, int centerX, int centerY, int a, int b, Color color) {
        PixelWriter pixelWriter = image.getPixelWriter();

        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        int x = 0;
        int y = b;

        int error = b2 - a2 * b + a2 / 4;
        int dx = 0;
        int dy = twoA2 * y;

        while (dx < dy) {
            plotPoints(pixelWriter, centerX, centerY, x, y, color);
            if (error < 0) {
                error += dx + b2;
            } else {
                y--;
                dy -= twoA2;
                error += dx + b2 - dy;
            }
            x++;
            dx += twoB2;
        }

        error = b2 * x * x + a2 * (y - 1) * (y - 1) - a2 * b2;
        while (y >= 0) {
            plotPoints(pixelWriter, centerX, centerY, x, y, color);
            if (error > 0) {
                error -= dy - a2;
            } else {
                x++;
                dx += twoB2;
                error += dx - dy + a2;
            }
            y--;
            dy -= twoA2;
        }
    }

    private static void plotPoints(PixelWriter pixelWriter, int centerX, int centerY, int x, int y, Color color) {
        pixelWriter.setColor(centerX + x, centerY + y, color);
        pixelWriter.setColor(centerX - x, centerY + y, color);
        pixelWriter.setColor(centerX + x, centerY - y, color);
        pixelWriter.setColor(centerX - x, centerY - y, color);
    }
}
