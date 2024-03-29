package com.gamma.gestorhorariosescolares.administrador.aplicacion;

import com.gamma.gestorhorariosescolares.administrador.aplicacion.actualizar.ServicioActualizadorAdministrador;
import com.gamma.gestorhorariosescolares.administrador.dominio.Administrador;
import com.gamma.gestorhorariosescolares.compartido.aplicacion.excepciones.FormatoInvalidoException;
import com.gamma.gestorhorariosescolares.compartido.aplicacion.excepciones.NoPersonalDuplicadoException;
import com.gamma.gestorhorariosescolares.compartido.aplicacion.excepciones.RecursoNoEncontradoException;
import com.gamma.gestorhorariosescolares.compartido.aplicacion.servicios.ServicioBuscador;
import com.gamma.gestorhorariosescolares.usuario.aplicacion.UsuarioData;
import com.gamma.gestorhorariosescolares.usuario.aplicacion.actualizar.ServicioActualizadorUsuario;
import com.gamma.gestorhorariosescolares.usuario.aplicacion.excepciones.UsuarioDuplicadoException;
import com.gamma.gestorhorariosescolares.usuario.dominio.Usuario;

import java.util.List;

public class ActualizarAdministrador {

    private final ServicioActualizadorAdministrador actualizadorAdministrador;
    private final ServicioBuscador<Administrador> buscadorAdministrador;
    private final ServicioBuscador<Usuario> buscadorUsuario;
    private final ServicioActualizadorUsuario actualizadorUsuario;

    public ActualizarAdministrador(ServicioActualizadorAdministrador actualizadorAdministrador,
                                   ServicioBuscador<Administrador> buscadorAdministrador,
                                   ServicioBuscador<Usuario> buscadorUsuario,
                                   ServicioActualizadorUsuario actualizadorUsuario) {
        this.actualizadorAdministrador = actualizadorAdministrador;
        this.buscadorAdministrador = buscadorAdministrador;
        this.buscadorUsuario = buscadorUsuario;
        this.actualizadorUsuario = actualizadorUsuario;
    }

    public void actualizar(AdministradorData administradorData)
            throws RecursoNoEncontradoException, NoPersonalDuplicadoException, UsuarioDuplicadoException, FormatoInvalidoException {

        if (administradorData == null)
            throw new NullPointerException();

        //El administrador que se desea actualizar no existe en el sistema
        List<Administrador> listaBusquedaAdministrador = buscadorAdministrador
                .igual("id", String.valueOf(administradorData.id()))
                .igual("idUsuario", String.valueOf(administradorData.usuario().id()))
                .buscar();
        if (!(listaBusquedaAdministrador.size() > 0))
            throw new RecursoNoEncontradoException("El administrador no se encuentra registrado en el sistema");

        //El nuevo número de personal no es ocupado por otro administrador
        listaBusquedaAdministrador = buscadorAdministrador
                .igual("noPersonal", administradorData.noPersonal())
                .diferente("id", String.valueOf(administradorData.id()))
                .buscar();
        if (listaBusquedaAdministrador.size() > 0)
            throw new NoPersonalDuplicadoException("Ya hay un administrador registrado con el número de personal "
                    + administradorData.noPersonal());

        //El correo electrónico no es ocupado por otro usuario
        List<Usuario> listaBusquedaUsuario = buscadorUsuario
                .igual("correoElectronico", administradorData.usuario().correoElectronico())
                .diferente("id", String.valueOf(administradorData.usuario().id()))
                .buscar();
        if (listaBusquedaUsuario.size() > 0)
            throw new UsuarioDuplicadoException("Ya hay un usario registrado con ese correo electrónico "
                    + administradorData.usuario().correoElectronico());

        //Preparando datos para actualizar
        Administrador administrador = new Administrador(administradorData.id(), administradorData.estatus(),
                administradorData.noPersonal(), administradorData.nombre(), administradorData.apellidoPaterno(),
                administradorData.apellidoMaterno(), administradorData.usuario().id());

        UsuarioData usuarioData = administradorData.usuario();
        Usuario usuario = new Usuario(usuarioData.id(), usuarioData.telefono(), usuarioData.correoElectronico(),
                usuarioData.claveAcceso(), usuarioData.tipo());

        //Actaulizando
        actualizadorUsuario.actualizar(usuario);
        actualizadorAdministrador.actualizar(administrador);
    }

}