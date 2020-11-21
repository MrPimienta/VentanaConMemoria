package dad.javafx.ventanaconmemoria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
	
	private Controller controller;
	
	public void crearConfig(File configfile) {
		try {
			BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(configfile));
			String config = "";
			config += "background.red=255\n";
			config += "background.green=255\n";
			config += "background.blue=255\n";
			
			//ESCRIBIMOS EL STRING CONFIG DENTRO DEL ARCHIVO CONFIGFILE
			bufferedwriter.write(config);
			bufferedwriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws Exception{
		String rutausuario = System.getProperty("user.home");
		Properties properties = new Properties();
		File configfile = new File(rutausuario+"\\.VentanaConMemoria\\ventana.config");
		
		
		if(configfile.createNewFile()) { //si el archivo no existe crea uno nuevo
			crearConfig(configfile);
		}
		
		properties.load(new FileInputStream(configfile));
		controller = new Controller(properties);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene escena = new Scene(controller.getView());
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Ventana con Memoria");
		primaryStage.getIcons().add(new Image("/imagenes/rgb.png"));
		primaryStage.show();
		
	}
	
	public void stop() throws Exception{
		String rutausuario = System.getProperty("user.home");
		Properties properties = new Properties();
		File configfile = new File(rutausuario+"\\.VentanaConMemoria\\ventana.config");
		Model modelo = controller.getModel();
		
		configfile.createNewFile();
		properties.setProperty("background.red", String.valueOf(modelo.getRed()));
		properties.setProperty("background.green", String.valueOf(modelo.getGreen()));
		properties.setProperty("background.blue", String.valueOf(modelo.getBlue()));
		properties.store(new FileWriter(configfile), "");
	}
	
	public static void main(String[] ar) {
		launch(ar);
	}

}
