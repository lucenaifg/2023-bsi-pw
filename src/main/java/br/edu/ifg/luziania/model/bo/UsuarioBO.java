package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RetornoDTO;

import javax.enterprise.context.Dependent;
import javax.ws.rs.core.Response;

import static java.util.Objects.nonNull;

@Dependent
public class UsuarioBO {

    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        RetornoDTO retornoDTO = new RetornoDTO();
        if (nonNull(autenticacaoDTO)){
            if (autenticacaoDTO.getEmail().equals("abc") && autenticacaoDTO.getSenha().equals("123")) {
                retornoDTO.setMensagem("Usuário autenticado!");
                return Response.ok(retornoDTO).build();
            }
            else {
                retornoDTO.setMensagem("Usuário não encontrado!");
                return Response.status(Response.Status.NOT_FOUND).entity(retornoDTO).build();
            }

        }else
            return Response.status(Response.Status.BAD_REQUEST).entity("Dados obrigatórios não presentes!").build();
    }
}
