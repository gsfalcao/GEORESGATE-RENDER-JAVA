package georesgate.controller;

import georesgate.model.Usuario;
import georesgate.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    UsuarioService usuarioService;

    @GET
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
        return Response.ok(usuario).build();
    }

    @POST
    public Response cadastrar(Usuario usuario) {
        usuarioService.salvar(usuario);
        return Response.status(Response.Status.CREATED).entity("Usuário cadastrado com sucesso!").build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Usuario usuario) {
        boolean atualizado = usuarioService.atualizar(id, usuario);
        if (!atualizado) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
        return Response.ok("Usuário atualizado com sucesso!").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean removido = usuarioService.deletar(id);
        if (!removido) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuário não encontrado").build();
        }
        return Response.ok("Usuário removido com sucesso!").build();
    }
}