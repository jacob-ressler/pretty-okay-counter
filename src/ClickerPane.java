import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ClickerPane extends StackPane {
    
    public int counter = 0;
    Text countText = new Text(String.valueOf(counter));
    Text mainText = new Text("POKÉMON\nCAUGHT");
    Text soniaText = new Text("Sonia best girl :)");
    String style1 = "-fx-font: bolder 140 arial; -fx-alignment: center; -fx-stroke: black; -fx-stroke-width: 3px;";
    String style2 = "-fx-font: bolder 60 rockwell; -fx-alignment: center; -fx-stroke: black; -fx-stroke-width: 2px;";
    String style3 = "-fx-font: bold 18 'brush script mt'; -fx-alignment: center;";

    public ClickerPane() {
	setBackground(new Background(new BackgroundImage(
		new Image("grookybg.png"), // rem.png sonia.png
		BackgroundRepeat.NO_REPEAT, 
		BackgroundRepeat.NO_REPEAT, 
		BackgroundPosition.CENTER, 
		new BackgroundSize(
			Clicker.WIDTH, 
			Clicker.HEIGHT, 
			false, 
			false, 
			false, 
			false)
		)));
	
	getChildren().addAll(countText, mainText, soniaText);
	mainText.setStyle(style2);
	mainText.setFill(Color.FLORALWHITE);
	mainText.setTranslateY(140);
	mainText.setTextAlignment(TextAlignment.CENTER);
	
	countText.setStyle(style1);
	countText.setFill(Color.AQUAMARINE);
	countText.setTranslateY(-120);
	
	soniaText.setStyle(style3);
	soniaText.setFill(Color.DEEPSKYBLUE);
	soniaText.setOpacity(.5);
	soniaText.setTranslateY(-145);
	soniaText.setTranslateX(-245);
	soniaText.setRotate(90);
    }

    public void changeCount(int i) {
	if (counter == 0 && i < 0) return;
	
	counter += i;
	countText.setText(String.valueOf(counter));
	
    }
    
    public void setCount() {
	TextInputDialog tid = new TextInputDialog();
	tid.showAndWait();
	String s = tid.getResult();
	String regex = "\\d+";
	
	if (s.matches(regex)) {
	    counter = Integer.valueOf(s);
	    countText.setText(String.valueOf(counter));
	}
    }
    
    public void resetCount() {
	counter = 0;
	countText.setText(String.valueOf(counter));
    }
}
