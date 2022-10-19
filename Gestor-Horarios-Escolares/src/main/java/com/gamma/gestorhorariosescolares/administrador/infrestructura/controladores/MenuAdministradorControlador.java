package com.gamma.gestorhorariosescolares.administrador.infrestructura.controladores;

import com.gamma.gestorhorariosescolares.alumno.infrestructura.controladores.CatalogoAlumnosControlador;
import com.gamma.gestorhorariosescolares.compartido.infrestructura.utilerias.InicializarPanel;
import com.gamma.gestorhorariosescolares.edificio.infrestructura.controladores.CatalogoEdificiosControlador;
import com.gamma.gestorhorariosescolares.maestro.infrestructura.controladores.CatalogoMaestrosControlador;
import com.gamma.gestorhorariosescolares.salon.infrestructura.controladores.CatalogoSalonesControlador;
import com.gamma.gestorhorariosescolares.secretario.infrestructura.controladores.CatalogoSecretariosControlador;
import com.gamma.gestorhorariosescolares.usuario.infrestructura.stages.LoginStage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class MenuAdministradorControlador {
    private final Stage stage;

    private AnchorPane panelCatalogoAdministradores;

    private CatalogoAdministradoresControlador controladorAdministradores;

    private AnchorPane panelCatalogoSecretarios;

    private CatalogoSecretariosControlador controladorSecretarios;

    private AnchorPane panelCatalogoMaestros;

    private CatalogoMaestrosControlador controladorMaestros;

    private AnchorPane panelCatalogoAlumnos;

    private CatalogoAlumnosControlador controladorAlumnos;

    private AnchorPane panelCatalogoEdificios;

    private CatalogoEdificiosControlador controladorEdificios;

    private AnchorPane panelCatalogoSalones;

    private CatalogoSalonesControlador controladorSalones;

    @FXML
    private BorderPane panelMenuAdministrador;

    @FXML
    private VBox vbMenu;

    @FXML
    private Button btnCatalogoAdministradores;

    @FXML
    private Button bbtnCatalogoSecretarios;

    @FXML
    private Button btnCatalogoMaestros;

    @FXML
    private Button btnCatalogoAlumnos;

    @FXML
    private Button btnCatalogoEdificios;

    @FXML
    private Button btnCatalogoSalones;

    @FXML
    private Button btnCatalogoMaterias;

    @FXML
    private Button btnCatalogoPlanesEstudios;

    @FXML
    private Button btnCatalogoPeriodosEscolares;

    @FXML
    private Button btnCerrarSesion;

    public MenuAdministradorControlador(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        //Solo se puede acceder a los recursos @FXML aquí
        mostrarCatalogoAdministradoresClick();
        stage.setOnHiding(event -> liberarRecursos());
    }

    @FXML
    protected void mostrarCatalogoAdministradoresClick() {
        if (panelCatalogoAdministradores == null) {
            try {
                controladorAdministradores = new CatalogoAdministradoresControlador(stage);
                panelCatalogoAdministradores = InicializarPanel.inicializarAnchorPane(
                        "administrador/infrestructura/vistas/CatalogoAdministradores.fxml",
                        controladorAdministradores
                );
                panelCatalogoAdministradores.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                panelMenuAdministrador.setCenter(panelCatalogoAdministradores);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            panelMenuAdministrador.setCenter(panelCatalogoAdministradores);
        }
    }

    @FXML
    protected void mostrarCatalogoSecretariosClick() {
        if (panelCatalogoSecretarios == null) {
            try {
                controladorSecretarios = new CatalogoSecretariosControlador(stage);
                panelCatalogoSecretarios = InicializarPanel.inicializarAnchorPane(
                        "secretario/infrestructura/vistas/CatalogoSecretarios.fxml",
                        controladorSecretarios
                );
                panelCatalogoSecretarios.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                panelMenuAdministrador.setCenter(panelCatalogoSecretarios);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            panelMenuAdministrador.setCenter(panelCatalogoSecretarios);
        }
    }

    @FXML
    protected void mostrarCatalogoMaestrosClick() {
        if (panelCatalogoMaestros == null) {
            try {
                controladorMaestros = new CatalogoMaestrosControlador(stage);
                panelCatalogoMaestros = InicializarPanel.inicializarAnchorPane(
                        "maestro/infrestructura/vistas/CatalogoMaestros.fxml",
                        controladorMaestros
                );
                panelCatalogoMaestros.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                panelMenuAdministrador.setCenter(panelCatalogoMaestros);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            panelMenuAdministrador.setCenter(panelCatalogoMaestros);
        }
    }

    @FXML
    protected void mostrarCatalogoAlumnosClick() {
        if (panelCatalogoAlumnos == null) {
            try {
                controladorAlumnos = new CatalogoAlumnosControlador(stage);
                panelCatalogoAlumnos = InicializarPanel.inicializarAnchorPane(
                        "alumno/infrestructura/vistas/CatalogoAlumnos.fxml",
                        controladorAlumnos
                );
                panelCatalogoAlumnos.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                panelMenuAdministrador.setCenter(panelCatalogoAlumnos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            panelMenuAdministrador.setCenter(panelCatalogoAlumnos);
        }
    }

    @FXML
    protected void mostrarCatalogoEdificiosClick() {
        if (panelCatalogoEdificios == null) {
            try {
                controladorEdificios = new CatalogoEdificiosControlador(stage);
                panelCatalogoEdificios = InicializarPanel.inicializarAnchorPane(
                        "edificio/infrestructura/vistas/CatalogoEdificios.fxml",
                        controladorEdificios
                );
                panelCatalogoEdificios.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                panelMenuAdministrador.setCenter(panelCatalogoEdificios);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            panelMenuAdministrador.setCenter(panelCatalogoEdificios);
        }
    }

    @FXML
    protected void mostrarCatalogoSalonesClick() {
        if (panelCatalogoSalones == null) {
            try {
                controladorSalones = new CatalogoSalonesControlador(stage);
                panelCatalogoSalones = InicializarPanel.inicializarAnchorPane(
                        "salon/infrestructura/vistas/CatalogoSalones.fxml",
                        controladorSalones
                );
                panelCatalogoSalones.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
                panelMenuAdministrador.setCenter(panelCatalogoSalones);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            panelMenuAdministrador.setCenter(panelCatalogoSalones);
        }
    }

    @FXML
    protected void mostrarCatalogoPlanesEstudioClick() {

    }

    @FXML
    protected void mostrarCatalogoMateriasClick() {

    }

    @FXML
    protected void mostrarCatalogoPeriodosEscolaresClick() {

    }

    @FXML
    protected void cerrarSesionClick() {
        new LoginStage().show();
        stage.close();
    }

    private void liberarRecursos() {
        System.out.println("Liberando recursos");

        if (controladorAdministradores != null)
            controladorAdministradores.liberarRecursos();
        if (controladorSecretarios != null)
            controladorSecretarios.liberarRecursos();
        if (controladorMaestros != null)
            controladorMaestros.liberarRecursos();
        if (controladorAlumnos != null)
            controladorAlumnos.liberarRecursos();
        if (controladorEdificios != null)
            controladorEdificios.liberarRecursos();
        if (controladorSalones != null)
            controladorSalones.liberarRecursos();
    }
}
