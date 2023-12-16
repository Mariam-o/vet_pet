module com.example.vet_pet {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.vet_pet to javafx.fxml;
    exports com.example.vet_pet;
}