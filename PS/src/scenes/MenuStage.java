/*
 * Name: Margaux Jayziel C. Flormata & Selena Therese Barrameda
 * Date Created: May 4, 2024 11:44:37 PM
 * Section: WX - 4L
 */
package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuStage {
	// Class attributes
	private Stage mainStage;
	private Scene mainScene;
	private StackPane backgroundPane;
	private Text mainTitle;
	private Button exitButton, startButton, aboutButton, devButton;
	private Button[] buttons;
	private VBox menuBox;
	private Image menuBackground;
	public final static int TILESIZE = 32;
	public final static int ROWSIZE = 21;
	public final static int COLSIZE = 42;
	
	// Constructor
	public MenuStage() {
		this.backgroundPane = new StackPane();
		this.mainScene = new Scene(this.backgroundPane, 1344, 672);	// 42 by 21
		this.mainTitle = new Text("PATINTERO SHOWDOWN");
		this.exitButton = new Button("Exit");
		this.startButton = new Button("New Game");
		this.aboutButton = new Button("About");
		this.devButton = new Button("Developers");
		this.buttons = new Button[]{startButton, aboutButton, devButton, exitButton};
		this.menuBox = new VBox(60);
	}
	
	// Method for setting the MenuStage
	public void setStage(Stage stage) {
		// Sets the background image
		this.backgroundPane.setBackground(new Background(getBackgroundImage()));
		
		// Loads custom fonts
		Font.loadFont(getClass().getResourceAsStream("/fonts/ARCADECLASSIC.TTF"), 10);

		// Sets the text of the menu title
		this.mainTitle.setStyle("-fx-font-size: 80pt; " +
								"-fx-font-weight: bold;" +
								"-fx-font-family: 'ARCADECLASSIC';" +
								"-fx-fill: #02F3FC;");
		
		// Set properties and event handling for each button
		for (Button button: this.buttons) {
			// Customizes the button
			button.setPrefWidth(300);
			button.setStyle("-fx-background-color: linear-gradient(#FDDA50, #D4AC09);"+
							"-fx-text-fill: #8A5403;" +
							"-fx-font-size: 20pt; " +
							"-fx-font-family: 'ARCADECLASSIC';" +
							"-fx-background-radius: 20;");
			button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: linear-gradient(#F0C728, #B39101);"+
							"-fx-text-fill: #8A5403;" +
							"-fx-font-size: 20pt; " +
							"-fx-font-family: 'ARCADECLASSIC';" +
							"-fx-background-radius: 20;"));
			button.setOnMouseExited(e -> button.setStyle("-fx-background-color: linear-gradient(#FDDA50, #D4AC09);"+
							"-fx-text-fill: #8A5403;" +
							"-fx-font-size: 20pt; " +
							"-fx-font-family: 'ARCADECLASSIC';" +
							"-fx-background-radius: 20;"));
		
			// Assign event handlers based on each button
			button.setOnAction(event -> handleButtonClick(button));
		}
		exitProgram();	// Set exit button action
		
		// Add the text node and button nodes to the VBox
		this.menuBox.getChildren().add(mainTitle);
		this.menuBox.getChildren().addAll(buttons);
		this.menuBox.setAlignment(Pos.CENTER);	
		
		// Adds the VBox to the StackPane
		backgroundPane.getChildren().add(menuBox);
		
		this.mainStage = stage;						// Sets the main stage
		mainStage.setScene(this.mainScene);			// Adds the main scene to the main stage
		mainStage.setTitle("Patintero Showdown");	// Sets the stage title
		mainStage.setResizable(false);				// Sets the stage to unresizable
		mainStage.show();							// Show the stage
	}
	
	// Method for getting the background image
	private BackgroundImage getBackgroundImage() {
		if (this.menuBackground == null) {
            this.menuBackground = new Image("images/late-afternoon.jpg");
        }
		
        return new BackgroundImage(
                this.menuBackground,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
    }
		
	// Method for handling button clicks for stage navigation
	private void handleButtonClick(Button button) {
		if (button == startButton) {
            openGameStage();
        } else if (button == aboutButton) {
            openAboutStage();
        } else if (button == devButton) {
            openDevStage();
        }
	}
	
	// Method for displaying the game stage
	private void openGameStage() {
		// Create and show character selection stage
        //CharSelection charSelection = new CharSelection(mainStage);
        //charSelection.setStage();
	}
	
	
	// Method for displaying the about stage
	private void openAboutStage() {  
		// Create and show about stage
		backgroundPane.getChildren().clear();

		//AboutStage aboutStage = new AboutStage(mainStage);
        //aboutStage.setStage();
	}
	
	// Method for displaying the developers stage
	private void openDevStage() {
		// Create and show developers stage
		backgroundPane.getChildren().clear();

        //DevStage devStage = new DevStage(mainStage);
        //devStage.setStage();
	}
		
	// Method for terminating the program
	private void exitProgram() {
		exitButton.setOnAction(event -> this.mainStage.close());
	}
	
}
