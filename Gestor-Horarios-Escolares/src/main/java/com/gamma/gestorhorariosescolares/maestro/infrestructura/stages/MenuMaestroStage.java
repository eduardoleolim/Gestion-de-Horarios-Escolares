package com.gamma.gestorhorariosescolares.maestro.infrestructura.stages;

import com.gamma.gestorhorariosescolares.App;
import com.gamma.gestorhorariosescolares.compartido.infrestructura.stage.CustomStage;
import com.gamma.gestorhorariosescolares.maestro.infrestructura.controladores.MenuMaestroControlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class MenuMaestroStage extends CustomStage {
    public MenuMaestroStage() {
        setTitle("Menu del Maestro ");

        try {
            FXMLLoader root = new FXMLLoader(App.class.getResource("maestro/infrestructura/vistas/MenuMaestro.fxml"));
            MenuMaestroControlador menuMaestroController = new MenuMaestroControlador(this);
            root.setController(menuMaestroController);
            root.load();
            Parent conntent = root.getRoot();
            conntent.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            setContent(conntent);
        } catch (IOException e) {
            System.err.println("Error al cargar ventana.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
