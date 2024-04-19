import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import javax.swing.*;

public class AWTCanvas extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a SwingNode to embed the AWT Canvas
        SwingNode swingNode = new SwingNode();

        // Create an AWT Canvas
        Canvas canvas = new Canvas();
        canvas.setSize(400, 300);

        // Add the Canvas to a Swing JPanel
        JPanel panel = new JPanel();
        panel.add(canvas);

        // Embed the JPanel into the SwingNode
        swingNode.setContent(panel);

        // Create a JavaFX layout and add the SwingNode
        StackPane root = new StackPane();
        root.getChildren().add(swingNode);

        // Create the JavaFX scene
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("AWT Canvas");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
