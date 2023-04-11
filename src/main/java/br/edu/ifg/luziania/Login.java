package br.edu.ifg.luziania;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Path("/")
public class Login {

    private final Template login;

    public Login(Template login) {
        this.login = login;
    }

    @GET
    public TemplateInstance login(){
        return login.instance();
    }

    @POST
    @Path("autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticar(Autenticacao autenticacao){
        RetornoAutenticacao retornoAutenticacao = new RetornoAutenticacao();
        if (nonNull(autenticacao)){
            if (autenticacao.getEmail().equals("abc") && autenticacao.getSenha().equals("123"))
                retornoAutenticacao.setRetorno("Usuário autenticado!");
            else
                retornoAutenticacao.setRetorno("Usuário não encontrado!");
            return Response.ok(retornoAutenticacao).build();
        }else
            return Response.status(Response.Status.BAD_REQUEST).entity("Dados obrigatórios não presentes!").build();
    }
}
