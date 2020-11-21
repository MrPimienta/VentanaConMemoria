package dad.javafx.ventanaconmemoria;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable{
	
	private Model modelo = new Model();
	
	@FXML
    private GridPane view;
	
	@FXML
    private Slider slRed;

    @FXML
    private Slider slGreen;

    @FXML
    private Slider slBlue;

    @FXML
    void onDragAction(MouseEvent e) {
    	view.setStyle("-fx-background-color: rgb(" + modelo.getRed() + "," + modelo.getGreen() + "," + modelo.getBlue() + ");");
    }

	public void initialize(URL location, ResourceBundle resources) {
		//CREAMOS LOS BINDEOS
		Bindings.bindBidirectional(slRed.valueProperty(), modelo.redProperty());
		Bindings.bindBidirectional(slGreen.valueProperty(), modelo.greenProperty());
		Bindings.bindBidirectional(slBlue.valueProperty(), modelo.blueProperty());
		
		slRed.valueProperty().addListener(e -> onDragAction((MouseEvent) e));
		slGreen.valueProperty().addListener(e -> onDragAction((MouseEvent) e));
		slBlue.valueProperty().addListener(e -> onDragAction((MouseEvent) e));
		
		view.setStyle("-fx-background-color: rgb(" + modelo.getRed() + "," + modelo.getGreen() + "," + modelo.getBlue() + ");");
		
	}
	
	public Controller(Properties properties) throws IOException{
		//ESTABLECEMOS LOS VALORES DE LOS SLIDERS SEGUN LO QUE CONTENGA EL FICHERO DE CONFIGURACION
		modelo.setRed(Integer.valueOf((String) properties.get("background.red")));
		modelo.setGreen(Integer.valueOf((String) properties.get("background.green")));
		modelo.setBlue(Integer.valueOf((String) properties.get("background.blue")));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public GridPane getView() {
		return view;
	}
	
	public void setView(GridPane view) {
		this.view = view;
	}
	 	
	
	public Model getModel() {
		return modelo;
	}
	
	public void setModel(Model modelo) {
		this.modelo = modelo;
	}	
}
