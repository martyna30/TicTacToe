package próba;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Próba {
    public static class SOS extends Application {

        private int GRID_SIZE = 5;
        private int PADDING_MEDIUM = 5;
        private int PADDING_LARGE = 10;
        private int PADDING_XLARGE = 20;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            //create display boxes
            VBox vbRoot = new VBox(),
                    vbGrid = new VBox(),
                    vbFooter = new VBox(),
                    vbPlayers = new VBox(),
                    vbGridInfo = new VBox(),
                    vbHeader = new VBox();
            HBox hbOptions = new HBox(),
                    hbDone = new HBox(),
                    hbGameDetails = new HBox(),
                    hbGameTitle = new HBox();

        }
    }
}
