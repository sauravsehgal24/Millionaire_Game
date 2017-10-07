/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millionare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author $AURAV DRO!D
 */
public class Millionare extends Application
{
   static Stage stage1 = new Stage();
   static Stage stage2 = new Stage();

   @Override
   public void start (Stage stage) throws Exception
   {

      Parent root1 = FXMLLoader.load(getClass().getResource("home.fxml"));
      Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      Scene scene1 = new Scene(root1);
      Scene scene2 = new Scene(root2);

      stage1.setScene(scene1);

      stage2.setScene(scene2);
      stage1();
   }

   public static void stage1 ()
   {
      stage1.show();
      stage2.hide();
   }

   public static void stage2 ()
   {
      stage1.hide();
      stage2.show();

   }

   /**
    * @param args the command line arguments
    */
   public static void main (String[] args)
   {
      launch(args);
   }

}
