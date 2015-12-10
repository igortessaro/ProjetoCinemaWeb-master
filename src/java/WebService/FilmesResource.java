package WebService;

import DTO.FilmeDTO;
import DomainEntity.Filme;
import Service.FilmeService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/filmes")
public class FilmesResource {

    @EJB
    FilmeService service;

    @Context
    private UriInfo context;

    public FilmesResource() {
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response consultarTodosFilmes() {
        List<FilmeDTO> result = new ArrayList<FilmeDTO>();
        List<Filme> filmeList;

        try {
            filmeList = this.service.obterTodos();

            if (filmeList != null && !filmeList.isEmpty()) {
                for (Filme filme : filmeList) {
                    if (filme != null) {
                        FilmeDTO entity = new FilmeDTO();
                        entity.setId(filme.getId());
                        entity.setAno(filme.getAno());
                        entity.setDiretor(filme.getDiretor());
                        entity.setGenero(filme.getGenero());
                        entity.setNome(filme.getNome());
                        entity.setSinopse(filme.getSinopse());
                        result.add(entity);
                    }
                }
            }

            return gerarResponseParaCollection(result);
        } catch (Exception e) {
            return exceptionParaResponse(e);
        }
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response salvar(FilmeDTO obj) {
        try {
            if (obj == null) {
                throw new IllegalArgumentException("Filme não informado");
            }

            Filme entity = new Filme(obj);
            this.service.salvar(entity);

            URI uri = context.getAbsolutePathBuilder().path("Filme salvo com sucesso...").build();
            return Response.created(uri).build();
        } catch (Exception e) {
            return exceptionParaResponse(e);
        }
    }

    protected Response exceptionParaResponse(Exception exception) {
        return Response.serverError().build();
    }

    protected Response gerarResponseParaCollection(List<FilmeDTO> obj) {
        if (obj == null || obj.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        GenericEntity<List<FilmeDTO>> lista = new GenericEntity<List<FilmeDTO>>(obj) {
        };
        return Response.ok(lista).build();
    }
}
