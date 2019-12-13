import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is a small JavaFX application I made
 * for one of my college courses. It simulates
 * coin flips and tracks the number of heads
 * and tails flipped. The buttons provide options 
 * for 1, 10, or 100 flips at a time, along 
 * with a score reset.
 * 
 * Created March 11, 2017
 * @author Jacob Ressler
 *
 */
public class Clicker extends Application {

	private ClickerPane clickerPane = new ClickerPane();
	public static final int WIDTH  = 576;
	public static final int HEIGHT = 168;
	
	
	@Override
	public void start(Stage primaryStage) {
	    
		BorderPane border = new BorderPane();
		border.setCenter(clickerPane);
		BorderPane.setAlignment(clickerPane, Pos.CENTER);

		Scene scene = new Scene(border, WIDTH, HEIGHT);
		primaryStage.setTitle("Clicker");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, 
			new EventHandler<MouseEvent>() {

			    @Override
			    public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
				    clickerPane.changeCount(1);
				}
				else if (event.getButton() == MouseButton.SECONDARY) {
				    clickerPane.changeCount(-1);
				}
				else if (event.getButton() == MouseButton.MIDDLE) {
				    clickerPane.resetCount();
				}
				
			    }
			});
	
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

		    @Override
		    public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.R)
			    clickerPane.resetCount();
			else if (event.getCode() == KeyCode.S)
			    clickerPane.setCount();
		    }
		    
		});
	}
	
	// Main
	public static void main (String[] args) {
		launch(args);
	}
}

