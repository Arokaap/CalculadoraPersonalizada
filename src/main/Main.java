package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    @Override
    public void start(Stage ventana) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VCalculadora.fxml")); //Cargamos la ventana creada con Scene Builder
        Scene escena = new Scene(loader.load());    //La cargamos en la escena
        escena.setFill(Color.TRANSPARENT);  // Puesto que nuestro panel tiene un border-radius se van a ver las esquinas blancas, las ponemos transparentes
        ventana.setScene(escena);   //Asignamos la escena a la ventana
        ventana.initStyle(StageStyle.TRANSPARENT); //Aunque ponemos la escena transparente necesito poner tambien la ventana para evitar el color blanco de esta.
        ventana.setResizable(false);    //Impedimos cambiar el tamanio de la ventana
        ventana.setTitle("Calculadora");    //Titulo para la ventana
        ventana.getIcons().add(new Image(getClass().getResourceAsStream("/image/icono.png")));  //Ruta al icono
        ((VCalculadoraController) loader.getController()).init(ventana);    //Realizamos un casteo para usar el metodo init creado en la clase VCalculadoraController
                                                                           // Esto nos permite mover la ventana ya que hemos hecho transparebte la ventana y no podriamos moverla
        ventana.show();
    }
    
}
