package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class VCalculadoraController {
    
    @FXML
    private Pane panelTitulo;
    private double x, y; //Controladores de coordenadas
    private double num1;
    private String operador = "+";
    
    @FXML
    private ImageView btCerrar;
    @FXML
    private ImageView btMinimizar;
    @FXML
    private Label lbResultado;
    @FXML
    private Pane btn7;
    @FXML
    private Pane btn8;
    @FXML
    private Pane btn9;
    @FXML
    private Pane btn4;
    @FXML
    private Pane btn5;
    @FXML
    private Pane btn6;
    @FXML
    private Pane btn1;
    @FXML
    private Pane btn2;
    @FXML
    private Pane btn3;
    @FXML
    private Pane btn0;
    @FXML
    private Pane btnSumar;
    @FXML
    private Pane btnRestar;
    @FXML
    private Pane btnMultiplicar;
    @FXML
    private Pane btnBorrar;
    @FXML
    private Pane btnIgualar;
    @FXML
    private Pane btnDividir;
    
    /**
     * Metodo que controla la ventana
     * @param ventana 
     */
    public void init(Stage ventana) {
        //Evento que se lanza cuando el raton es presionado sobre el panel
        panelTitulo.setOnMousePressed((eventoRaton) -> {
            x = eventoRaton.getSceneX();    //Recogeremos la posicion en la que se vaya encontrando la escena en el eje x
            y = eventoRaton.getSceneY();    //Igual en el eje y
        });

        //Evento que se lanza cuando el raton es presionado sobre el panel y ademas se arrastra
        panelTitulo.setOnMouseDragged((eventoRaton) -> {
            ventana.setX(eventoRaton.getScreenX() - x); //Segun el raton se vaya movimiendo por la pantalla se ira asignando la posicion de la ventana al restarle
            //a la posicion en x la posicion del raton en la pantalla conseguimos que el raton y la ventana se muevan en conjunto desde la posicion que se
            // hizo clic
            ventana.setY(eventoRaton.getScreenY() - y); //Igual pasa en el eje y

            //Es decir si hacemos clic y tenemos la escena con una distancia del raton de 10px. Y por otro lado tenemos la pantalla desde el borde
            //hasta donde hemos hecho clic en la escena tiene 20px; Entonce 20-10=10 nos mantiene la posicion del raton junto a la ventana que tenemos
        });

        //Evento que se lanza cuando realizamos clic sobre la imagen
        btCerrar.setOnMouseClicked((eventoRaton) -> {
            ventana.close();    //Cuando se haga clic la ventana realizara la accion de cerrarse
        });

        //Evento que se lanza cuando realizamos clic sobre la imagen
        btMinimizar.setOnMouseClicked((eventoRaton) -> {
            ventana.setIconified(true); //La ventana se minimiza cuando se realiza el clic
        });
    }
    
    /**
     * Metodo que controla si pulsamos un numero
     * @param evento 
     */
    @FXML
    private void btNumeroClic(MouseEvent evento) {
        int valor = Integer.parseInt(((Pane) evento.getSource()).getId().replace("btn", ""));//Recogemos el valor del id de cada boton,
        //Cuando se hace clic en un numero se recoge el id y se reemplaza la palabra btn
        //quedando solamente el numero o simbolo que necesiamos para operar

        // Con esto conseguimos que si habia un 9.0 ahora salga por pantalla un 96.0
        lbResultado.setText(String.valueOf(Double.parseDouble(lbResultado.getText()) * 10 + valor));
    }
    
    /**
     * Metodo que controla si pulsamos un signo y segun el signo realizara una u otra accion
     * @param evento 
     */
    @FXML
    private void BtSignoClic(MouseEvent evento) {
        String signo = ((Pane) evento.getSource()).getId().replace("btn", ""); //Lo mismo que en el metodo anterior pero sin hacer el casteo

        if (signo.equals("Igualar")) {  //Si signo es igual a Igualar entonces abremos pulsado el boton de igual
            double num2 = Double.parseDouble(lbResultado.getText());    //Declaramos esta variable ya que si se pulsa el boton igualar quiere decir que existe un dato que recoger
            switch (operador) { //Segun el valor del operador realizara una accion u otra
                case "+":
                    lbResultado.setText((num1 + num2) + "");
                    break;
                case "-":
                    lbResultado.setText((num1 - num2) + "");
                    break;
                case "*":
                    lbResultado.setText((num1 * num2) + "");
                    break;
                case "/":
                    lbResultado.setText((num1 / num2) + "");
                    break;
            }
            operador = "."; //Reiniciamos operador a un valor que no sea un signo 
        } else if (signo.equals("Borrar")) {    //En caso de pulsar en borrar
            lbResultado.setText(String.valueOf(0.0));   //Reseteamos el valor guardado en resultado
            operador = "."; //Y tambien reseteamos el operador
        } else {
            switch (signo) {    //Segun el signo pulsado cambiamos el operador a un valor u otro
                case "Sumar":
                    operador = "+";
                    break;
                case "Restar":
                    operador = "-";
                    break;
                case "Multiplicar":
                    operador = "*";
                    break;
                case "Dividir":
                    operador = "/";
                    break;
            }
            
            num1 = Double.parseDouble(lbResultado.getText()); // Si estamos en esta condicion significa que no se ha pulsado antes nada y es el primer numero
            lbResultado.setText(String.valueOf(0.0));   //Reseteamos el label del resultado
        }
        
    }
}
