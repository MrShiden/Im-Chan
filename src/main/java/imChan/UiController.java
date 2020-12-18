package imChan;

import imChan.code.Conversion;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class UiController {


    Stage primaryStage = new Stage();

    String change = "";
    String toChange = "";
    String prefijo = "";
    String sufijo = "";


    @FXML
    private Button btn_select;
    @FXML
    private Button btn_destiny;
    @FXML
    private Button btn_cerrar;
    @FXML
    private Button btn_iniciar;
    @FXML
    private TextField tv_select;
    @FXML
    private TextField tv_destiny;
    @FXML
    private TextField tv_prefijo;
    @FXML
    private TextField tv_sufijo;
    @FXML
    private Label lb_tips;


    public void btnSelectAction() {

        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final File selectedDirectory = directoryChooser.showDialog(primaryStage);
        System.out.println(selectedDirectory);
        if (selectedDirectory != null) {
            tv_select.setText(selectedDirectory.toString());
        }
    }

    public void btnDestinyAction() {


        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final File selectedDirectory = directoryChooser.showDialog(primaryStage);
        System.out.println(selectedDirectory);
        if (selectedDirectory != null) {
            tv_destiny.setText(selectedDirectory.toString());
        }


    }

    public void btnCerrarOnAction() {
        Stage stage = (Stage) btn_cerrar.getScene().getWindow();
        stage.close();
    }

    public void btnIniciarOnAction() {
        if (tv_select.getText().isBlank()
                || tv_destiny.getText().isBlank()
                || tv_prefijo.getText().isBlank()
                || tv_sufijo.getText().isBlank()) {

            lb_tips.setTextFill(Color.web("#d9001b"));
            lb_tips.setText("Faltan datos");
        } else {
            textViewDisable(true, true, true, true);
            buttonsDisable(true, true, true, false);

            change = tv_select.getText();
            toChange = tv_destiny.getText();

            prefijo = tv_prefijo.getText();
            sufijo = tv_sufijo.getText();

            Conversion convert = new Conversion(prefijo, Integer.parseInt(sufijo));

            convert.Start(change, toChange);

            textViewDisable(false, false, false, false);
            buttonsDisable(false, false, false, false);
            cleanTv();
            lb_tips.setText("Se han cambiardo las imagenes");
            lb_tips.setTextFill(Color.web("#16A085"));


        }


    }

    public void cleanTv() {
        tv_select.clear();
        tv_destiny.clear();
        tv_select.clear();
        tv_prefijo.clear();
        tv_sufijo.clear();

    }

    public void textViewDisable(Boolean select, Boolean destiny, Boolean prefijo, Boolean sufijo) {

        tv_select.setDisable(select);
        tv_destiny.setDisable(destiny);
        tv_prefijo.setDisable(prefijo);
        tv_sufijo.setDisable(sufijo);
    }

    public void buttonsDisable(Boolean select, Boolean destiny, Boolean iniciar, Boolean cerrar) {

        btn_select.setDisable(select);
        btn_destiny.setDisable(destiny);
        btn_iniciar.setDisable(iniciar);
        btn_cerrar.setDisable(cerrar);
    }
}
