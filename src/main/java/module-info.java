module com.example.hangmanfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hangmanfx to javafx.fxml;
    exports com.example.hangmanfx;
}