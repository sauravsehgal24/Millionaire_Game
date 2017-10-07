package millionare;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author $AURAV DRO!D
 */
public class FXMLDocumentController implements Initializable
{
   @FXML
   private Rectangle r1;
   @FXML
   private Rectangle r2;
   @FXML
   private Rectangle r3;
   @FXML
   private Rectangle r4;
   @FXML
   private AnchorPane ap;
   @FXML
   private Arc a1;
   @FXML
   private Arc a2;
   @FXML
   private Arc a3;
   @FXML
   private Arc a4;
   @FXML
   private Arc a5;
   @FXML
   private Arc a6;
   @FXML
   private Arc a7;
   @FXML
   private Arc a8;
   @FXML
   protected Label l1;
   @FXML
   protected Label l2;
   @FXML
   protected Label l3;
   @FXML
   protected Label l4;
   @FXML
   protected Label l5;
   @FXML
   protected Label l6;
   @FXML
   protected Label l7;
   @FXML
   protected Label l8;
   @FXML
   protected Label l9;
   @FXML
   protected Label l10;
   @FXML
   protected Label l11;
   @FXML
   protected Label l12;
   @FXML
   protected Label l13;
   @FXML
   protected Label l14;
   @FXML
   protected Label l15;
   @FXML
   protected Label l16;
   @FXML
   protected Label l17;
   @FXML
   protected Label l18;


   @FXML
   protected static Label[] lArray = new Label[18];

   @FXML
   private MouseEvent me;

   @FXML
   private Label time;

   @FXML
   private Label ques;

   @FXML
   private TextField op1;

   @FXML
   private TextField op2;

   @FXML
   private TextField op3;

   @FXML
   private TextField op4;

   @FXML
   private Circle c;

   @FXML
   private Button start;

   @FXML
   private Button bt;


   @FXML
   private int count;



   @FXML
   private int rand;

   @FXML
   private int quesNo;

   @FXML
   private int[] quesNos;

   @FXML
   private Rectangle rectCh1;
   @FXML
   private int timerCount;
   @FXML
   static MediaPlayer lockPlay;
   @FXML
   static MediaPlayer correctPlay;
   @FXML
   static MediaPlayer wrongPlay;
   @FXML
   static MediaPlayer tic;
   @FXML
   static MediaPlayer qPlay;

   @FXML
   private String quest;
   @FXML
   private String choice1;
   @FXML
   private String choice2;
   @FXML
   private String choice3;
   @FXML
   private String choice4;
   @FXML
   private String ans;
   @FXML
   private Animation animation;
   @FXML
   private boolean check;
   @FXML
   private FadeTransition ref;
   @FXML
   private int quesCount = 1;
   @FXML
   private Rectangle correctrect;
   @FXML
   private Label correct;

   @FXML
   private Label lose;

   @FXML
   private Label won;

   @FXML
   private Button again;
   @FXML
   private Button exit;

   @FXML
   protected void addLabel ()
   {

      lArray[0] = l1;
      lArray[1] = l2;
      lArray[2] = l3;
      lArray[3] = l4;
      lArray[4] = l5;
      lArray[5] = l6;
      lArray[6] = l7;
      lArray[7] = l8;
      lArray[8] = l9;
      lArray[9] = l10;
      lArray[10] = l11;
      lArray[11] = l12;
      lArray[12] = l13;
      lArray[13] = l14;
      lArray[14] = l15;
      lArray[15] = l16;
      lArray[16] = l17;
      lArray[17] = l18;




   }

   @FXML
   private void lockPlay ()
   {
      Media loadMusic = new Media(getClass().getResource("music/lock.mp3").toExternalForm());
      lockPlay = new MediaPlayer(loadMusic);
      lockPlay.play();
   }

   @FXML
   private void timer (ActionEvent event)
   {
      if (timerCount <= 30) {
         timerCount++;
         time.setText(String.valueOf(timerCount));
         int random = (int) (Math.random() * 255);
         int random2 = (int) (Math.random() * 255);
         ap.setStyle("-fx-background-color: rgb(" + random2 + ",42," + random + ")");

      }
      if (timerCount == 30) {
         time.setVisible(false);
         wrongAnsOrTimeOut();
      }

   }

   @FXML
   private void fade (int timerCount)
   {
      this.timerCount = timerCount;
      animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> timer(e)));
      animation.setCycleCount(30);
      animation.play();
      FadeTransition ft = new FadeTransition(Duration.millis(1000), c);
      ref = ft;
      c.setVisible(true);
      ft.setFromValue(1.0);
      ft.setToValue(0.3);
      ft.setCycleCount(30);
      ft.setAutoReverse(true);
      ft.play();
   }

   @FXML
   private void reset ()
   {
      ap.setStyle("-fx-background-color: black");
      op1.setDisable(true);
      op2.setDisable(true);
      op3.setDisable(true);
      op4.setDisable(true);
      op1.setStyle("-fx-background-color:#1E90FF");
      op2.setStyle("-fx-background-color:#1E90FF");
      op3.setStyle("-fx-background-color:#1E90FF");
      op4.setStyle("-fx-background-color:#1E90FF");
   }

   @FXML
   private void correctPlay ()
   {
      Media correct = new Media(getClass().getResource("music/correct.mp3").toExternalForm());
      correctPlay = new MediaPlayer(correct);
      correctPlay.play();
   }

   @FXML
   private void wrongPlay ()
   {
      Media wrong = new Media(getClass().getResource("music/wrong.mp3").toExternalForm());
      wrongPlay = new MediaPlayer(wrong);
      wrongPlay.play();
   }

   @FXML
   private void play ()
   {

      Media clock = new Media(getClass().getResource("music/tictoc.mp3").toExternalForm());
      tic = new MediaPlayer(clock);
      tic.play();
      HomeController.loadPlay.stop();
      reset();
      c.setVisible(true);
      time.setVisible(true);
      fade(0);
      File myfile = new File("C:\\Users\\saurav\\Documents\\NetBeansProjects\\Millionare\\src\\millionare\\questions.txt");
      rand = quesCount;
      try {
         Scanner read = new Scanner(myfile);
         read.useDelimiter(System.getProperty("line.separator"));
         while (read.hasNext()) {
            Scanner readLine = new Scanner(read.next());
            readLine.useDelimiter(",");
            quesNo = readLine.nextInt();
            quest = readLine.next();
            choice1 = readLine.next();
            choice2 = readLine.next();
            choice3 = readLine.next();
            choice4 = readLine.next();
            ans = readLine.next();
            if (quesNo == rand && quesNo < 19) {
               break;
            }


         }
         read.close();

      }
      catch (Exception e) {
         System.out.println("not created");
      }
      ques.setDisable(false);
      op1.setDisable(false);
      op2.setDisable(false);
      op3.setDisable(false);
      op4.setDisable(false);
      ques.setText(quest);
      op1.setText(choice1);
      op2.setText(choice2);
      op3.setText(choice3);
      op4.setText(choice4);
   }

   @FXML
   private void start (ActionEvent event) throws FileNotFoundException, InterruptedException
   {
      addLabel();
      ques.setWrapText(true);
      start.setVisible(false);
      play();
   }

   @FXML
   private void nextQuest ()
   {
      reset();
      ques.setText("");
      op1.setText("");
      op2.setText("");
      op3.setText("");
      op4.setText("");
      Task<Void> sleeper = new Task<Void>()
      {
         @Override
         protected Void call () throws Exception
         {
            try {
               Thread.sleep(6000);
            }
            catch (InterruptedException e) {
            }
            return null;
         }
      };
      sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
      {
         @Override
         public void handle (WorkerStateEvent event)
         {
            play();
         }
      });
      new Thread(sleeper).start();
   }

   @FXML
   private void thread ()
   {
      Task<Void> sleeper = new Task<Void>()
      {
         @Override
         protected Void call () throws Exception
         {
            try {
               Thread.sleep(2600);
            }
            catch (InterruptedException e) {
            }
            return null;
         }
      };
      sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
      {
         @Override
         public void handle (WorkerStateEvent event)
         {
            c.setVisible(false);

            correct.setVisible(false);
            correctrect.setVisible(false);
            time.setVisible(false);
            if (quesCount < 19) {
               Media question = new Media(getClass().getResource("music/question.mp3").toExternalForm());
               qPlay = new MediaPlayer(question);
               qPlay.play();
               nextQuest();
            }
         }
      });
      new Thread(sleeper).start();
   }

   @FXML
   private void wrongAnsOrTimeOut ()
   {
      reset();
      ques.setText("");
      op1.setText("");
      op2.setText("");
      op3.setText("");
      op4.setText("");
      time.setVisible(false);
      lose.setVisible(true);
      exit.setVisible(true);
      again.setVisible(true);
      ques.setDisable(true);
      op1.setDisable(true);
      op2.setDisable(true);
      op3.setDisable(true);
      op4.setDisable(true);
   }

   @FXML
   private void limit ()
   {
      if (quesCount > 18) {
         reset();
         ques.setText("");
         op1.setText("");
         op2.setText("");
         op3.setText("");
         op4.setText("");
         time.setVisible(false);
         won.setVisible(true);
         exit.setVisible(true);
         again.setVisible(true);
         ques.setDisable(true);
         op1.setDisable(true);
         op2.setDisable(true);
         op3.setDisable(true);
         op4.setDisable(true);
      }



   }

   @FXML
   private void playAgain (ActionEvent event)
   {
      ques.setDisable(false);
      op1.setDisable(false);
      op2.setDisable(false);
      op3.setDisable(false);
      op4.setDisable(false);
      again.setVisible(false);
      lose.setVisible(false);
      won.setVisible(false);
      exit.setVisible(false);
      quesCount = 1;
      start.setVisible(true);
      for (int i = 0; i < 18; i++) {
         lArray[i].setStyle("-fx-background-color:black");
      }
   }

   @FXML
   private void exitOut (ActionEvent event)
   {
      System.exit(0);
   }

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {

      c.setVisible(false);
      won.setVisible(false);
      lose.setVisible(false);
      again.setVisible(false);
      exit.setVisible(false);

      op1.setEditable(false);
      op2.setEditable(false);
      op3.setEditable(false);
      op4.setEditable(false);
      op1.setOnMousePressed(e -> {
         op1.setStyle("-fx-background-color:orange");

         lockPlay();


      });
      op2.setOnMousePressed(e -> {
         op2.setStyle("-fx-background-color:orange");

         lockPlay();

      });
      op3.setOnMousePressed(e -> {
         op3.setStyle("-fx-background-color:orange");

         lockPlay();

      });
      op4.setOnMousePressed(e -> {
         op4.setStyle("-fx-background-color:orange");

         lockPlay();

      });

      op1.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>()
      {
         @Override
         public void handle (MouseEvent mouseEvent)
         {
            op1.setOnMouseReleased(e -> {
               tic.stop();
               op1.setStyle("-fx-background-color:#FFA500");
               op2.setDisable(true);
               op3.setDisable(true);
               op4.setDisable(true);
               try {
                  synchronized (op1) {
                     op1.wait(2000);
                  }
               }
               catch (InterruptedException ex) {
                  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }

               if (choice1.equalsIgnoreCase(ans)) {
                  op1.setStyle("-fx-background-color:#32CD32");

                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op1.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  correct.setVisible(true);
                  correctrect.setVisible(true);
                  ref.stop();
                  animation.stop();
                  correctPlay();
                  int random = (int) (Math.random() * 255);
                  int random2 = (int) (Math.random() * 255);
                  lArray[quesCount - 1].setStyle("-fx-background-color: rgb(" + random2 + ",42," + random + ")");
                  quesCount++;
                  limit();
                  thread();
               }
               else if (choice2.equalsIgnoreCase(ans)) {
                  op2.setStyle("-fx-background-color:#32CD32");

                  op2.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op2.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice3.equalsIgnoreCase(ans)) {
                  op3.setStyle("-fx-background-color:#32CD32");

                  op3.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op3.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice4.equalsIgnoreCase(ans)) {
                  op4.setStyle("-fx-background-color:#32CD32");

                  op4.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op4.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }


            });
         }
      });



      op2.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>()
      {
         @Override
         public void handle (MouseEvent mouseEvent)
         {
            op2.setOnMouseReleased(e -> {
               tic.stop();
               op2.setStyle("-fx-background-color:#FFA500");
               op1.setDisable(true);
               op3.setDisable(true);
               op4.setDisable(true);

               try {
                  synchronized (op2) {
                     op2.wait(2000);
                  }
               }
               catch (InterruptedException ex) {
                  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }

               if (choice2.equalsIgnoreCase(ans)) {
                  op2.setStyle("-fx-background-color:#32CD32");

                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op2.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  correct.setVisible(true);
                  correctrect.setVisible(true);
                  ref.stop();
                  animation.stop();
                  correctPlay();
                  int random = (int) (Math.random() * 255);
                  int random2 = (int) (Math.random() * 255);
                  lArray[quesCount - 1].setStyle("-fx-background-color: rgb(" + random2 + ",42," + random + ")");
                  quesCount++;
                  limit();
                  thread();
               }
               else if (choice1.equalsIgnoreCase(ans)) {
                  op1.setStyle("-fx-background-color:#32CD32");

                  op1.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op1.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice3.equalsIgnoreCase(ans)) {
                  op3.setStyle("-fx-background-color:#32CD32");

                  op3.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op3.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice4.equalsIgnoreCase(ans)) {
                  op4.setStyle("-fx-background-color:#32CD32");

                  op4.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op4.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }


            });
         }
      });

      op3.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>()
      {
         @Override
         public void handle (MouseEvent mouseEvent)
         {
            op3.setOnMouseReleased(e -> {
               tic.stop();
               op3.setStyle("-fx-background-color:#FFA500");
               op2.setDisable(true);
               op1.setDisable(true);
               op4.setDisable(true);
               try {
                  synchronized (op3) {
                     op3.wait(2000);
                  }
               }
               catch (InterruptedException ex) {
                  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }

               if (choice3.equalsIgnoreCase(ans)) {
                  op3.setStyle("-fx-background-color:#32CD32");

                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op3.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  correct.setVisible(true);
                  correctrect.setVisible(true);
                  ref.stop();
                  animation.stop();
                  correctPlay();
                  int random = (int) (Math.random() * 255);
                  int random2 = (int) (Math.random() * 255);
                  lArray[quesCount - 1].setStyle("-fx-background-color: rgb(" + random2 + ",42," + random + ")");
                  quesCount++;
                  limit();
                  thread();
               }
               else if (choice2.equalsIgnoreCase(ans)) {
                  op2.setStyle("-fx-background-color:#32CD32");

                  op2.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op2.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice1.equalsIgnoreCase(ans)) {
                  op1.setStyle("-fx-background-color:#32CD32");

                  op1.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op1.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice4.equalsIgnoreCase(ans)) {
                  op4.setStyle("-fx-background-color:#32CD32");

                  op4.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op4.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }


            });
         }
      });

      op4.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>()
      {
         @Override
         public void handle (MouseEvent mouseEvent)
         {
            op4.setOnMouseReleased(e -> {
               tic.stop();
               op4.setStyle("-fx-background-color:#FFA500");
               op2.setDisable(true);
               op3.setDisable(true);
               op1.setDisable(true);
               try {
                  synchronized (op4) {
                     op4.wait(2000);
                  }
               }
               catch (InterruptedException ex) {
                  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
               }

               if (choice4.equalsIgnoreCase(ans)) {
                  op4.setStyle("-fx-background-color:#32CD32");

                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op4.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  correct.setVisible(true);
                  correctrect.setVisible(true);
                  ref.stop();
                  animation.stop();
                  correctPlay();
                  int random = (int) (Math.random() * 255);
                  int random2 = (int) (Math.random() * 255);
                  lArray[quesCount - 1].setStyle("-fx-background-color: rgb(" + random2 + ",42," + random + ")");
                  quesCount++;
                  limit();
                  thread();
               }
               else if (choice2.equalsIgnoreCase(ans)) {
                  op2.setStyle("-fx-background-color:#32CD32");

                  op2.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op2.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice3.equalsIgnoreCase(ans)) {
                  op3.setStyle("-fx-background-color:#32CD32");

                  op3.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op3.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }
               else if (choice1.equalsIgnoreCase(ans)) {
                  op1.setStyle("-fx-background-color:#32CD32");

                  op1.setDisable(false);
                  Task<Void> sleeper = new Task<Void>()
                  {
                     @Override
                     protected Void call () throws Exception
                     {
                        try {
                           Thread.sleep(1500);
                        }
                        catch (InterruptedException e) {
                        }
                        return null;
                     }
                  };
                  sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                  {
                     @Override
                     public void handle (WorkerStateEvent event)
                     {
                        op1.setDisable(true);
                     }
                  });
                  new Thread(sleeper).start();
                  ref.stop();
                  animation.stop();
                  wrongPlay();
                  wrongAnsOrTimeOut();
               }


            });
         }
      });

   }



}
