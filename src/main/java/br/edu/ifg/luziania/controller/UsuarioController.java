package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.UsuarioBO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usuario")
public class UsuarioController {

    @Inject
    UsuarioBO usuarioBO;

    private final Template cadastroUsuario;

    public UsuarioController(Template cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance cadastroUsuarioHTML(){
        return cadastroUsuario.instance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("salvar")
    public Response salvar(UsuarioDTO dto){
        RespostaDTO respostaDTO = usuarioBO.salvar(dto);
        return Response
                .status(respostaDTO.getStatus())
                .entity(respostaDTO)
                .build();
    }
}
