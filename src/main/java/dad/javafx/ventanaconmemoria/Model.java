package dad.javafx.ventanaconmemoria;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model {
	
	private IntegerProperty red = new SimpleIntegerProperty();
	private IntegerProperty green = new SimpleIntegerProperty();
	private IntegerProperty blue = new SimpleIntegerProperty();
	
	//RED////////////////////////////////////////////////////////
	public final IntegerProperty redProperty() {
		return this.red;
	}
	
	public final int getRed() {
		return this.redProperty().get();
	}
	
	public final void setRed(final int red) {
		this.redProperty().set(red);
	}
	/////////////////////////////////////////////////////////////
	
	
	
	//GREEN//////////////////////////////////////////////////////
	public final IntegerProperty greenProperty() {
		return this.green;
	}
	
	public final int getGreen() {
		return this.greenProperty().get();
	}
	
	public final void setGreen(final int green) {
		this.greenProperty().set(green);
	}
	/////////////////////////////////////////////////////////////
	
	
	
	//BLUE///////////////////////////////////////////////////////
	public final IntegerProperty blueProperty() {
		return this.blue;
	}
	
	public final int getBlue() {
		return this.blueProperty().get();
	}
	
	public final void setBlue(final int blue) {
		this.blueProperty().set(blue);
	}
	////////////////////////////////////////////////////////////
}
