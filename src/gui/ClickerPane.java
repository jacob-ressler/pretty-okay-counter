package gui;

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

public class ClickerPane extends StackPane {

	public int counter = 0;

	Text countText = new Text(String.valueOf(counter));
	HuntImage img = new HuntImage("810");

	String style1 = "-fx-font: bolder 140 arial; -fx-alignment: center; -fx-stroke: black; -fx-stroke-width: 3px;";

	public ClickerPane() {
		Image bg = new Image("grookeybg.png");

		setBackground(new Background(
				new BackgroundImage(bg, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
						new BackgroundSize(Clicker.WIDTH, Clicker.HEIGHT, false, false, true, false))));

		getChildren().addAll(countText, img);

		/* HUNT IMAGE */
		img.setFitHeight(Clicker.HEIGHT - 10);
		img.setPreserveRatio(true);
		img.setTranslateX(-150);

		/* COUNTER TEXT */
		countText.setStyle(style1);
		countText.setFill(Color.AQUAMARINE);
		countText.setTranslateX(120);

	}

	public void changeCount(int i) {
		if (counter == 0 && i < 0)
			return;

		counter += i;
		countText.setText(String.valueOf(counter));

	}

	public void setCount() {
		TextInputDialog tid = new TextInputDialog();
		tid.setHeaderText("Enter a value for the counter");
		tid.setGraphic(null);
		tid.showAndWait();
		String s = tid.getResult();
		String regex = "\\d+";

		if (s != null && s.equals("") == false && s.matches(regex)) {
			counter = Integer.valueOf(s);
			countText.setText(String.valueOf(counter));
		}
	}

	public void resetCount() {
		counter = 0;
		countText.setText(String.valueOf(counter));
	}

	public void setHuntImage() {
		TextInputDialog tid = new TextInputDialog();
		tid.setHeaderText("Enter the national dex number of the Pokémon");
		tid.setGraphic(null);
		tid.showAndWait();
		String s = tid.getResult();
		String regex = "\\d+";

		if (s != null && s.equals("") == false && s.matches(regex)) {
			int i = Integer.valueOf(s);
			if (i > 0 && i <= 890)
				img.changeImage(s);
		}
	}
}
