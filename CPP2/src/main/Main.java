package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import object.Buyer;
import object.shop.Shop;

/**
 * This is main class that start program.
 */
public class Main extends Application {

    @Override
    /**
     * This method is point of entry to program.
     * @param primaryStage is the window in which all elements is disposed.
     */
    //Check:OFF: MagicNumber
    public void start(final Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Магазин");
        primaryStage.setScene(new Scene(root, 720, 200));
        primaryStage.setResizable(false);
        primaryStage.show();

        Buyer buyer = new Buyer();
        Shop shop = new Shop("Carrefour");
        GUI gui = new GUI(root, shop);
        Controller controller = new Controller(gui, shop, buyer);
    }
    //Check:ON: MagicNumber

    /**
     * This method starts program.
     * @param args - default parameter.
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
