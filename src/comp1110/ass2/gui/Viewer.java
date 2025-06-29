package comp1110.ass2.gui;

import comp1110.ass2.Metro;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A very simple viewer for piece placements in the Metro game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */

public class Viewer extends Application {
    /* board layout */
    private static final int SQUARE_SIZE = 90;
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();

    private TextField textFieldShowPiece;
    private TextField textFieldAddPlayerNum;
    private Group placement = new Group();
    private Group player = new Group();

    private static final int Initial_Row = 530;
    private static final int Initial_Column = 100;

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     * @author Bowen Tan(u6822656)
     */
    private void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        this.placement.getChildren().clear();
        if (!Metro.isPlacementSequenceWellFormed(placement) || !Metro.isPlacementSequenceValid(placement) ) {
            Text t = new Text("Sorry, this placement is unacceptable!");
            t.setFill(Color.RED);
            t.setLayoutX(120);
            t.setLayoutY(680);
            this.placement.getChildren().add(t);
        } else {
            for (int i = 0; i <= placement.length() - 1; i += 6) {
                ImageView imageview = new ImageView();
                String tileType = String.valueOf(placement.charAt(i)) + placement.charAt(i + 1)
                        + placement.charAt(i + 2) + placement.charAt(i + 3);
                char colNum = placement.charAt(i + 4);
                char rowNum = placement.charAt(i + 5);

                if (tileType.equals("aaaa")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("aacb")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("acba")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("accd")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("adad")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("adbb")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("baac")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("badb")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("bbad")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("bbbb")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("bcbc")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("bcdd")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("cbaa")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("cbcb")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("cccc")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("ccda")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("cdac")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("cddb")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("dacc")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("dada")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("dbba")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("dbcd")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("ddbc")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                } else if (tileType.equals("dddd")) {
                    imageview.setLayoutX(Initial_Row + ((rowNum - 48) * SQUARE_SIZE));
                    imageview.setLayoutY(Initial_Column + ((colNum - 48) * SQUARE_SIZE));
                    imageview.setImage(new Image(this.getClass().getResource(URI_BASE + tileType + ".jpg").toString()));
                }
                this.placement.getChildren().add(imageview);
            }
        }
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    public class addPlayerWindow {
        public void display(String title, String message) {
            Stage window = new Stage();
            window.setTitle("Enter player number");
            window.setMinWidth(400);
            window.setMinHeight(300);
            Label labelAddPlayerNum = new Label("Please enter the number of whole players:");
            textFieldAddPlayerNum = new TextField();
            textFieldAddPlayerNum.setPrefWidth(50);

            Button btnAddPlayerNum = new Button("Confirm");
            btnAddPlayerNum.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    player.getChildren().clear();
                    int playerNum = Integer.parseInt(textFieldAddPlayerNum.getText());
                    int hbLayoutY = 100;
                    int plyNum = 1;
                    for(int i=0;i<=playerNum-1;i++){
                        Label labelPlayerNum = new Label("Player"+plyNum+"'s score");
                        TextField textFieldPlayerScore = new TextField();
                        textFieldPlayerScore.setPrefWidth(100);
                        HBox hbPlayers = new HBox();
                        hbPlayers.getChildren().addAll(labelPlayerNum, textFieldPlayerScore);
                        hbPlayers.setSpacing(10);
                        hbPlayers.setLayoutX(20);
                        hbPlayers.setLayoutY(hbLayoutY);
                        player.getChildren().add(hbPlayers);
                        hbLayoutY = hbLayoutY + 50;
                        plyNum++;
                    }
                    window.close();
                }
            });
            HBox hbAddPlayerNum = new HBox();
            hbAddPlayerNum.getChildren().addAll(labelAddPlayerNum, textFieldAddPlayerNum, btnAddPlayerNum);
            hbAddPlayerNum.setSpacing(10);
            hbAddPlayerNum.setLayoutX(0);
            hbAddPlayerNum.setLayoutY(120);
            window.setScene(new Scene(hbAddPlayerNum));
            window.showAndWait();
        }
    }


    private void makeControls() {
        Label labelShowPiece = new Label("Placement:");
        textFieldShowPiece = new TextField();
        textFieldShowPiece.setPrefWidth(250);
        Button btnShowPiece = new Button("Refresh");
        btnShowPiece.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textFieldShowPiece.getText());
                textFieldShowPiece.clear();
            }
        });

        HBox hbShowPiece = new HBox();
        hbShowPiece.getChildren().addAll(labelShowPiece, textFieldShowPiece, btnShowPiece);
        hbShowPiece.setSpacing(10);
        hbShowPiece.setLayoutX(20);
        hbShowPiece.setLayoutY(VIEWER_HEIGHT - 30);

        Button player = new Button("Choose Player Number");
        player.setLayoutX(20);
        player.setLayoutY(700);
        player.setOnAction(e -> new addPlayerWindow().display("title", "message"));
        controls.getChildren().add(hbShowPiece);
        controls.getChildren().add(player);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FocusGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        ImageView imageview_back = new ImageView();
        imageview_back.setLayoutX(Initial_Row);
        imageview_back.setLayoutY(Initial_Column);
        imageview_back.setImage(new Image(this.getClass().getResource(URI_BASE + "tile_back_cover.jpg").toString()));
        imageview_back.setFitHeight(720);
        imageview_back.setFitWidth(720);
        root.getChildren().add(imageview_back);

        ImageView imageview_corner1 = new ImageView();
        imageview_corner1.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview_corner1.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview_corner1.setImage(new Image(this.getClass().getResource(URI_BASE + "corner.jpg").toString()));
        imageview_corner1.setFitHeight(90);
        imageview_corner1.setFitWidth(90);
        root.getChildren().add(imageview_corner1);

        ImageView imageview_corner2 = new ImageView();
        imageview_corner2.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview_corner2.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview_corner2.setImage(new Image(this.getClass().getResource(URI_BASE + "corner.jpg").toString()));
        imageview_corner2.setFitHeight(90);
        imageview_corner2.setFitWidth(90);
        root.getChildren().add(imageview_corner2);

        ImageView imageview_corner3 = new ImageView();
        imageview_corner3.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview_corner3.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview_corner3.setImage(new Image(this.getClass().getResource(URI_BASE + "corner.jpg").toString()));
        imageview_corner3.setFitHeight(90);
        imageview_corner3.setFitWidth(90);
        root.getChildren().add(imageview_corner3);

        ImageView imageview_corner4 = new ImageView();
        imageview_corner4.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview_corner4.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview_corner4.setImage(new Image(this.getClass().getResource(URI_BASE + "corner.jpg").toString()));
        imageview_corner4.setFitHeight(90);
        imageview_corner4.setFitWidth(90);
        root.getChildren().add(imageview_corner4);

        ImageView imageview8 = new ImageView();
        imageview8.setLayoutX(Initial_Row);
        imageview8.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview8.setImage(new Image(this.getClass().getResource(URI_BASE + "station8.jpg").toString()));
        root.getChildren().add(imageview8);

        ImageView imageview7 = new ImageView();
        imageview7.setLayoutX(Initial_Row + SQUARE_SIZE);
        imageview7.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview7.setImage(new Image(this.getClass().getResource(URI_BASE + "station7.jpg").toString()));
        root.getChildren().add(imageview7);

        ImageView imageview6 = new ImageView();
        imageview6.setLayoutX(Initial_Row + 2 * SQUARE_SIZE);
        imageview6.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview6.setImage(new Image(this.getClass().getResource(URI_BASE + "station6.jpg").toString()));
        root.getChildren().add(imageview6);

        ImageView imageview5 = new ImageView();
        imageview5.setLayoutX(Initial_Row + 3 * SQUARE_SIZE);
        imageview5.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview5.setImage(new Image(this.getClass().getResource(URI_BASE + "station5.jpg").toString()));
        root.getChildren().add(imageview5);

        ImageView imageview4 = new ImageView();
        imageview4.setLayoutX(Initial_Row + 4 * SQUARE_SIZE);
        imageview4.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview4.setImage(new Image(this.getClass().getResource(URI_BASE + "station4.jpg").toString()));
        root.getChildren().add(imageview4);

        ImageView imageview3 = new ImageView();
        imageview3.setLayoutX(Initial_Row + 5 * SQUARE_SIZE);
        imageview3.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview3.setImage(new Image(this.getClass().getResource(URI_BASE + "station3.jpg").toString()));
        root.getChildren().add(imageview3);

        ImageView imageview2 = new ImageView();
        imageview2.setLayoutX(Initial_Row + 6 * SQUARE_SIZE);
        imageview2.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview2.setImage(new Image(this.getClass().getResource(URI_BASE + "station2.jpg").toString()));
        root.getChildren().add(imageview2);

        ImageView imageview1 = new ImageView();
        imageview1.setLayoutX(Initial_Row + 7 * SQUARE_SIZE);
        imageview1.setLayoutY(Initial_Column - SQUARE_SIZE);
        imageview1.setImage(new Image(this.getClass().getResource(URI_BASE + "station1.jpg").toString()));
        root.getChildren().add(imageview1);

        ImageView imageview9 = new ImageView();
        imageview9.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview9.setLayoutY(Initial_Column);
        imageview9.setImage(new Image(this.getClass().getResource(URI_BASE + "station9.jpg").toString()));
        imageview9.setRotate(270);
        root.getChildren().add(imageview9);

        ImageView imageview10 = new ImageView();
        imageview10.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview10.setLayoutY(Initial_Column + SQUARE_SIZE);
        imageview10.setImage(new Image(this.getClass().getResource(URI_BASE + "station10.jpg").toString()));
        imageview10.setRotate(270);
        root.getChildren().add(imageview10);

        ImageView imageview11 = new ImageView();
        imageview11.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview11.setLayoutY(Initial_Column + 2 * SQUARE_SIZE);
        imageview11.setImage(new Image(this.getClass().getResource(URI_BASE + "station11.jpg").toString()));
        imageview11.setRotate(270);
        root.getChildren().add(imageview11);

        ImageView imageview12 = new ImageView();
        imageview12.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview12.setLayoutY(Initial_Column + 3 * SQUARE_SIZE);
        imageview12.setImage(new Image(this.getClass().getResource(URI_BASE + "station12.jpg").toString()));
        imageview12.setRotate(270);
        root.getChildren().add(imageview12);

        ImageView imageview13 = new ImageView();
        imageview13.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview13.setLayoutY(Initial_Column + 4 * SQUARE_SIZE);
        imageview13.setImage(new Image(this.getClass().getResource(URI_BASE + "station13.jpg").toString()));
        imageview13.setRotate(270);
        root.getChildren().add(imageview13);

        ImageView imageview14 = new ImageView();
        imageview14.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview14.setLayoutY(Initial_Column + 5 * SQUARE_SIZE);
        imageview14.setImage(new Image(this.getClass().getResource(URI_BASE + "station14.jpg").toString()));
        imageview14.setRotate(270);
        root.getChildren().add(imageview14);

        ImageView imageview15 = new ImageView();
        imageview15.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview15.setLayoutY(Initial_Column + 6 * SQUARE_SIZE);
        imageview15.setImage(new Image(this.getClass().getResource(URI_BASE + "station15.jpg").toString()));
        imageview15.setRotate(270);
        root.getChildren().add(imageview15);

        ImageView imageview16 = new ImageView();
        imageview16.setLayoutX(Initial_Row - SQUARE_SIZE);
        imageview16.setLayoutY(Initial_Column + 7 * SQUARE_SIZE);
        imageview16.setImage(new Image(this.getClass().getResource(URI_BASE + "station16.jpg").toString()));
        imageview16.setRotate(270);
        root.getChildren().add(imageview16);

        ImageView imageview17 = new ImageView();
        imageview17.setLayoutX(Initial_Row);
        imageview17.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview17.setImage(new Image(this.getClass().getResource(URI_BASE + "station17.jpg").toString()));
        imageview17.setRotate(180);
        root.getChildren().add(imageview17);

        ImageView imageview18 = new ImageView();
        imageview18.setLayoutX(Initial_Row + SQUARE_SIZE);
        imageview18.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview18.setImage(new Image(this.getClass().getResource(URI_BASE + "station18.jpg").toString()));
        imageview18.setRotate(180);
        root.getChildren().add(imageview18);

        ImageView imageview19 = new ImageView();
        imageview19.setLayoutX(Initial_Row + 2 * SQUARE_SIZE);
        imageview19.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview19.setImage(new Image(this.getClass().getResource(URI_BASE + "station19.jpg").toString()));
        imageview19.setRotate(180);
        root.getChildren().add(imageview19);

        ImageView imageview20 = new ImageView();
        imageview20.setLayoutX(Initial_Row + 3 * SQUARE_SIZE);
        imageview20.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview20.setImage(new Image(this.getClass().getResource(URI_BASE + "station20.jpg").toString()));
        imageview20.setRotate(180);
        root.getChildren().add(imageview20);

        ImageView imageview21 = new ImageView();
        imageview21.setLayoutX(Initial_Row + 4 * SQUARE_SIZE);
        imageview21.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview21.setImage(new Image(this.getClass().getResource(URI_BASE + "station21.jpg").toString()));
        imageview21.setRotate(180);
        root.getChildren().add(imageview21);

        ImageView imageview22 = new ImageView();
        imageview22.setLayoutX(Initial_Row + 5 * SQUARE_SIZE);
        imageview22.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview22.setImage(new Image(this.getClass().getResource(URI_BASE + "station22.jpg").toString()));
        imageview22.setRotate(180);
        root.getChildren().add(imageview22);

        ImageView imageview23 = new ImageView();
        imageview23.setLayoutX(Initial_Row + 6 * SQUARE_SIZE);
        imageview23.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview23.setImage(new Image(this.getClass().getResource(URI_BASE + "station23.jpg").toString()));
        imageview23.setRotate(180);
        root.getChildren().add(imageview23);

        ImageView imageview24 = new ImageView();
        imageview24.setLayoutX(Initial_Row + 7 * SQUARE_SIZE);
        imageview24.setLayoutY(Initial_Column + 8 * SQUARE_SIZE);
        imageview24.setImage(new Image(this.getClass().getResource(URI_BASE + "station24.jpg").toString()));
        imageview24.setRotate(180);
        root.getChildren().add(imageview24);

        ImageView imageview32 = new ImageView();
        imageview32.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview32.setLayoutY(Initial_Column);
        imageview32.setImage(new Image(this.getClass().getResource(URI_BASE + "station32.jpg").toString()));
        imageview32.setRotate(90);
        root.getChildren().add(imageview32);

        ImageView imageview31 = new ImageView();
        imageview31.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview31.setLayoutY(Initial_Column + SQUARE_SIZE);
        imageview31.setImage(new Image(this.getClass().getResource(URI_BASE + "station31.jpg").toString()));
        imageview31.setRotate(90);
        root.getChildren().add(imageview31);

        ImageView imageview30 = new ImageView();
        imageview30.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview30.setLayoutY(Initial_Column + 2 * SQUARE_SIZE);
        imageview30.setImage(new Image(this.getClass().getResource(URI_BASE + "station30.jpg").toString()));
        imageview30.setRotate(90);
        root.getChildren().add(imageview30);

        ImageView imageview29 = new ImageView();
        imageview29.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview29.setLayoutY(Initial_Column + 3 * SQUARE_SIZE);
        imageview29.setImage(new Image(this.getClass().getResource(URI_BASE + "station29.jpg").toString()));
        imageview29.setRotate(90);
        root.getChildren().add(imageview29);

        ImageView imageview28 = new ImageView();
        imageview28.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview28.setLayoutY(Initial_Column + 4 * SQUARE_SIZE);
        imageview28.setImage(new Image(this.getClass().getResource(URI_BASE + "station28.jpg").toString()));
        imageview28.setRotate(90);
        root.getChildren().add(imageview28);

        ImageView imageview27 = new ImageView();
        imageview27.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview27.setLayoutY(Initial_Column + 5 * SQUARE_SIZE);
        imageview27.setImage(new Image(this.getClass().getResource(URI_BASE + "station27.jpg").toString()));
        imageview27.setRotate(90);
        root.getChildren().add(imageview27);

        ImageView imageview26 = new ImageView();
        imageview26.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview26.setLayoutY(Initial_Column + 6 * SQUARE_SIZE);
        imageview26.setImage(new Image(this.getClass().getResource(URI_BASE + "station26.jpg").toString()));
        imageview26.setRotate(90);
        root.getChildren().add(imageview26);

        ImageView imageview25 = new ImageView();
        imageview25.setLayoutX(Initial_Row + 8 * SQUARE_SIZE);
        imageview25.setLayoutY(Initial_Column + 7 * SQUARE_SIZE);
        imageview25.setImage(new Image(this.getClass().getResource(URI_BASE + "station25.jpg").toString()));
        imageview25.setRotate(90);
        root.getChildren().add(imageview25);

        ImageView imageview_center1 = new ImageView();
        imageview_center1.setLayoutX(Initial_Row + 3 * SQUARE_SIZE);
        imageview_center1.setLayoutY(Initial_Column + 3 * SQUARE_SIZE);
        imageview_center1.setImage(new Image(this.getClass().getResource(URI_BASE + "centre_station.jpg").toString()));
        imageview_center1.setRotate(90);
        root.getChildren().add(imageview_center1);

        ImageView imageview_center2 = new ImageView();
        imageview_center2.setLayoutX(Initial_Row + 3 * SQUARE_SIZE);
        imageview_center2.setLayoutY(Initial_Column + 4 * SQUARE_SIZE);
        imageview_center2.setImage(new Image(this.getClass().getResource(URI_BASE + "centre_station.jpg").toString()));
        root.getChildren().add(imageview_center2);

        ImageView imageview_center3 = new ImageView();
        imageview_center3.setLayoutX(Initial_Row + 4 * SQUARE_SIZE);
        imageview_center3.setLayoutY(Initial_Column + 3 * SQUARE_SIZE);
        imageview_center3.setImage(new Image(this.getClass().getResource(URI_BASE + "centre_station.jpg").toString()));
        imageview_center3.setRotate(180);
        root.getChildren().add(imageview_center3);

        ImageView imageview_center4 = new ImageView();
        imageview_center4.setLayoutX(Initial_Row + 4 * SQUARE_SIZE);
        imageview_center4.setLayoutY(Initial_Column + 4 * SQUARE_SIZE);
        imageview_center4.setImage(new Image(this.getClass().getResource(URI_BASE + "centre_station.jpg").toString()));
        imageview_center4.setRotate(270);
        root.getChildren().add(imageview_center4);

        root.getChildren().add(this.placement);
        root.getChildren().add(controls);
        root.getChildren().add(player);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
