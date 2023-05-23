package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RespostaDTO;
import br.edu.ifg.luziania.model.dto.RetornoDTO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.entity.Usuario;
import br.edu.ifg.luziania.model.util.Sessao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import static java.util.Objects.nonNull;

@Dependent
public class UsuarioBO {

    @Inject
    Sessao sessao;

    @Inject
    UsuarioDAO usuarioDAO;

    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        RetornoDTO retornoDTO = new RetornoDTO();
        if (nonNull(autenticacaoDTO)){
            Usuario usuario = usuarioDAO.getByEmailAndSenha(autenticacaoDTO.getEmail(), autenticacaoDTO.getSenha());
            if (nonNull(usuario)) {
                retornoDTO.setMensagem("Bem vindo "+usuario.getNome()+"!");
                sessao.setUsuario(usuario.getNome());
                return Response.ok(retornoDTO).build();
            }
            else {
                retornoDTO.setMensagem("Usuário não encontrado!");
                return Response.status(Response.Status.NOT_FOUND).entity(retornoDTO).build();
            }

        }else
            return Response.status(Response.Status.BAD_REQUEST).entity("Dados obrigatórios não presentes!").build();
    }

    @Transactional
    public RespostaDTO salvar(UsuarioDTO dto) {

        RespostaDTO respostaDTO = new RespostaDTO();

        Usuario entity = new Usuario();

        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setSenha(dto.getSenha());

        try {
            usuarioDAO.save(entity);
            respostaDTO.setStatus(200);
            respostaDTO.setMensagem("Usuário salvo com sucesso!");
            respostaDTO.setUrl("/");
        }catch (Exception e){
            respostaDTO.setStatus(500);
            respostaDTO.setMensagem("Falha ao salvar usuário!");
            respostaDTO.setUrl("/usuario");
        }

        return respostaDTO;
    }
}
