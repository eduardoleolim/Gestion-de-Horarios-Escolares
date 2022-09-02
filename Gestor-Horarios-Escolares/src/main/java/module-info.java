module com.gamma.gestorhorariosescolares {
    requires javafx.controls;
    requires javafx.fxml;
    requires sql2o;
    requires java.sql;

    opens com.gamma.gestorhorariosescolares to javafx.fxml;
    exports com.gamma.gestorhorariosescolares;
    exports com.gamma.gestorhorariosescolares.infrastructure.usuario.controllers;
    opens com.gamma.gestorhorariosescolares.infrastructure.usuario.controllers to javafx.fxml;
}