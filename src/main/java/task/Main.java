package task;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ellipse Drawer");

        Scene scene = createScene();

        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene() {
        Pane pane = new Pane();

        int width = 600;
        int height = 400;

        WritableImage image = new WritableImage(width, height);

        EllipseDrawer.drawEllipseFromTopLeft(image, 50, 50, 200, 100, javafx.scene.paint.Color.BLUE);
        EllipseDrawer.drawEllipseFromCenter(image, 300, 300, 150, 80, javafx.scene.paint.Color.RED);

        ImageView imageView = new ImageView(image);
        pane.getChildren().add(imageView);

        return new Scene(pane, width, height);
    }
}
