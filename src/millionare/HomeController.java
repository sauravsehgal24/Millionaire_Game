package millionare;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author $AURAV DRO!D
 */
public class HomeController implements Initializable
{


   @FXML
   private Image image;

   @FXML
   private ImageView iv;

   @FXML
   private Button play;

   @FXML
   static MediaPlayer loadHome;

   @FXML
   static MediaPlayer loadPlay;

   @FXML
   private Timeline animation;

   @FXML
   private Boolean check;

   /**
    * @param void
    * @return void
    * @throws no Exception
    * Brief Description: This method is used to call second FXML page and it stops and hide current FXML page.
    * */
   @FXML
   private void play ()
   {

      Millionare.stage2();
      loadHome.stop();
      playMusic2();
   }

   /**
    * @param Type ActionEvent named event
    * @return void
    * @throws no Exception
    * Brief Description: This method is used to change color of logo in current FXML page.
    * */
   @FXML
   private void animation (ActionEvent event)
   {
      if (check == false) {
         play.setStyle("-fx-background-color:yellow");
         check = true;
      }
      else {
         play.setStyle("-fx-background-color:orange");
         check = false;
      }


   }

   /**
    * @param void
    * @return void
    * @throws no Exception
    * Brief Description: This method is used to provide animation effect to logo in current FXML page.
    * */
   @FXML
   private void animate ()
   {
      animation = new Timeline(new KeyFrame(Duration.millis(100), e -> animation(e)));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play();

   }

   /**
    * @param void
    * @return void
    * @throws no Exception
    * Brief Description: This method is used to play background music in current FXML page.
    * */
   @FXML
   private void playMusic ()
   {
      Media loadMusic = new Media("file:///C:/Users/saurav/Documents/NetBeansProjects/Millionare/src/millionare/music/theme1.mp3");


      loadHome = new MediaPlayer(loadMusic);
      loadHome.play();

   }

   /**
    * @param void
    * @return void
    * @throws no Exception
    * Brief Description: This method is used to play background music in current FXML page.
    * */
   @FXML
   private void playMusic2 ()
   {
      Media loadMusic = new Media("file:///C:/Users/saurav/Documents/NetBeansProjects/Millionare/src/millionare/music/letsPlay.mp3");

      loadPlay = new MediaPlayer(loadMusic);
      loadPlay.play();

   }


   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      check = false;
      play.setStyle("-fx-background-color:yellow");
      animate();
      image = new Image("millionare/images/load.gif");
      iv = new ImageView(image);
      playMusic();

   }

}
