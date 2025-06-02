package georesgate.controller;

import georesgate.model.Alerta;
import georesgate.service.AlertaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/alerta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlertaController {

    @Inject
    AlertaService alertaService;

    @GET
    public List<Alerta> listar() {
        return alertaService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Alerta alerta = alertaService.buscarPorId(id);
        if (alerta == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Alerta não encontrado").build();
        }
        return Response.ok(alerta).build();
    }

    @POST
    @Path("/{idUsuario}")
    public Response cadastrar(@PathParam("idUsuario") Long idUsuario, Alerta alerta) {
        String resultado = alertaService.salvar(alerta, idUsuario);
        if (resultado.contains("não encontrado")) {
            return Response.status(Response.Status.NOT_FOUND).entity(resultado).build();
        }
        return Response.status(Response.Status.CREATED).entity(resultado).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Alerta alerta) {
        boolean atualizado = alertaService.atualizar(id, alerta);
        if (!atualizado) {
            return Response.status(Response.Status.NOT_FOUND).entity("Alerta não encontrado").build();
        }
        return Response.ok("Alerta atualizado com sucesso!").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletado = alertaService.deletar(id);
        if (!deletado) {
            return Response.status(Response.Status.NOT_FOUND).entity("Alerta não encontrado").build();
        }
        return Response.ok("Alerta deletado com sucesso!").build();
    }
}