package gui;

import javafx.scene.image.Image;

public class HuntImage extends javafx.scene.image.ImageView {

	String baseURL = "https://serebii.net/Shiny/SWSH/";

	public HuntImage(String dexnum) {
		dexnum = "810";
		setImage(new Image(baseURL + dexnum + ".png"));
		setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,1), 10, .5, 0, 0);");
	}

	public void changeImage(String dexnum) {
		switch (dexnum.length()) {
			case 1:
				dexnum = "00" + dexnum;
				break;
			case 2:
				dexnum = "0" + dexnum;
			default:
				break;
		}

		setImage(new Image(baseURL + dexnum + ".png"));
	}
}
