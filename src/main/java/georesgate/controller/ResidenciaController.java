package georesgate.controller;

import georesgate.model.Residencia;
import georesgate.service.ResidenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/residencia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResidenciaController {

    @Inject
    ResidenciaService residenciaService;

    @GET
    public List<Residencia> listar() {
        return residenciaService.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        Residencia residencia = residenciaService.buscarPorId(id);
        if (residencia == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Residência não encontrada").build();
        }
        return Response.ok(residencia).build();
    }

    @POST
    @Path("/{idUsuario}")
    public Response cadastrar(@PathParam("idUsuario") Long idUsuario, Residencia residencia) {
        String resultado = residenciaService.salvar(residencia, idUsuario);
        if (resultado.contains("não encontrado")) {
            return Response.status(Response.Status.NOT_FOUND).entity(resultado).build();
        }
        return Response.status(Response.Status.CREATED).entity(resultado).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Residencia residencia) {
        boolean atualizado = residenciaService.atualizar(id, residencia);
        if (!atualizado) {
            return Response.status(Response.Status.NOT_FOUND).entity("Residência não encontrada").build();
        }
        return Response.ok("Residência atualizada com sucesso!").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        boolean deletada = residenciaService.deletar(id);
        if (!deletada) {
            return Response.status(Response.Status.NOT_FOUND).entity("Residência não encontrada").build();
        }
        return Response.ok("Residência removida com sucesso!").build();
    }
}