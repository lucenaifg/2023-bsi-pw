package br.edu.ifg.luziania;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
}
