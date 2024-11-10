module cs112.lab08 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens cs112.lab08 to javafx.fxml;
    exports cs112.lab08;
}