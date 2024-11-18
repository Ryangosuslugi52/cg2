package task;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
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

        // левый верхний
        Ellipse ellipse1 = EllipseDrawer.drawEllipseFromTopLeft(50, 50, 200, 100);

        // цент и полуоси
        Ellipse ellipse2 = EllipseDrawer.drawEllipseFromCenter(300, 300, 150, 80);

        pane.getChildren().addAll(ellipse1, ellipse2);

        return new Scene(pane, 600, 400);
    }
}
