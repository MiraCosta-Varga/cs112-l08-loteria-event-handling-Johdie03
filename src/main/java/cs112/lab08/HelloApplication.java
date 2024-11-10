package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.namespace.QName;
import java.io.IOException;

public class HelloApplication extends Application /*implements EventHandler<ActionEvent> */ {

    //CONSTANTS

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    //Component instances
    ImageView cardImageView;
    Label messageLabel;


    @Override
    public void start(Stage stage) throws IOException {
        LoteriaCard cardLogo = new LoteriaCard();
       //SETUP COMPONENTS
        Label titleLabel = new Label("Welcome to EChaLE STEM Loteria!");
        cardImageView = new ImageView( cardLogo.getImage() );
        messageLabel = new Label("Click the button below to randomly draw a card.");
        Button drawCardButton = new Button ("Draw Random Card");

        //Customize Components
        cardImageView.setFitWidth(300);
        cardImageView.setPreserveRatio(true);
        titleLabel.setFont(new Font(20.0));
        drawCardButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                            //handle button click
                            System.out.println ("Button was clicked!");

                            //get random card
                            int randomInt = (int) (Math.random() * LOTERIA_CARDS.length); //get 0-3
                            LoteriaCard randomCard = LOTERIA_CARDS[randomInt];
                            //image changes to card image
                            cardImageView.setImage(randomCard.getImage());

                            //message label changes to card name
                            messageLabel.setText(randomCard.getCardName());

                    }
                }


        );

        //ADD COMPONENTS
        VBox vbox = new VBox();
        vbox.getChildren().addAll(titleLabel, cardImageView, messageLabel,drawCardButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5.0);

        //SETUP SCENE AND SHOW
        Scene scene = new Scene (vbox, 350,500);
        stage.setScene(scene);
        stage.setTitle("EChale STEM Loteria");
        stage.show();

    }

    //Handle Method
   /* @Override
    public void handle (ActionEvent actionEvent){
        //handle button click
        System.out.println ("Button was clicked!");

        //get random card
        int randomInt = (int) (Math.random() * LOTERIA_CARDS.length); //get 0-3
        LoteriaCard randomCard = LOTERIA_CARDS[randomInt];
        //image changes to card image
        cardImageView.setImage(randomCard.getImage());

        //message label changes to card name
        messageLabel.setText(randomCard.getCardName());
    }
*/

    public static void main(String[] args) {
        launch();
    }
}