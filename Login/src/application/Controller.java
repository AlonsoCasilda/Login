package application;



import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
//Entre los import y la clase metemos los comentarios
/**
 * @author Dani
 * @see Main
 */

public class Controller {
	
	

	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;

	private AnchorPane mypane;
	
	@FXML //Metodo Ernesto para q abra otra ventana
	private void reportButtonHandler(ActionEvent event) {	    
	   try {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Ventana2.fxml"));
		   mypane = (AnchorPane) loader.load();
		   Scene scene = new Scene(mypane);		   
		    Stage stage = new Stage();//si no ponemos esto no abre otra ventana	    
		    stage.setScene(scene);
		    //stage.setResizable(false);
		    stage.show();
	   } catch (Exception e) {		
	   }
	}

//		@FXML
//		private URL location;
//
//		@FXML
//		private ResourceBundle resources;

	public void initialize() {
		
		backgroundAnimation();

	}

	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {

			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition0.setFromValue(0);
					fadeTransition0.setToValue(1);
					fadeTransition0.play();

					fadeTransition0.setOnFinished(event3 -> {

						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);

						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {

							FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3), pane4);

							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {

								backgroundAnimation();
							});

						});

					});

				});
			});

		});

	}
}