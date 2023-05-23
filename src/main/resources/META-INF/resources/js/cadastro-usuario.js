function validarFormulario(){
    return document.getElementById("nome").value !== '' && document.getElementById("email").value !== '' && document.getElementById("senha").value !== '';
}

function getUsuarioDTO(){
    return {
        "nome": document.getElementById("nome").value,
        "email": document.getElementById("email").value,
        "senha": document.getElementById("senha").value
    };
}


function criarRequisicaoSalvarUsuario(dto){
    return new Request("http://localhost:8080/usuario/salvar", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto),
    });
}


function salvar(){
    if (validarFormulario()){
        var dto = getUsuarioDTO();
        var requisicao = criarRequisicaoSalvarUsuario(dto);
        fetch(requisicao)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                alert("Ocorreu algum erro no servidor!");
            }
        })
        .then(json => {
            alert(json.mensagem);
            window.location.href = window.location.origin+json.url;
        });
    } else
        alert('Os campos e-mail e senha são obrigatórios! Verifique o formulário.')
}
