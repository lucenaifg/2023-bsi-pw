package br.edu.ifg.luziania.model.util;

import javax.enterprise.context.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class Sessao {

    private String usuario;
    private List<String> permissoes;

    public Sessao() {
        this.usuario = "";
        this.permissoes = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }
}
