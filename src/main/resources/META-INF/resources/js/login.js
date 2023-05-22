//Validar formulário
function validarFormulario(){
    return document.getElementById("email").value !== '' && document.getElementById("senha").value !== '';
}

// Construtor do AutenticacaoDTO (JSON) em Javascript
function getAutenticacaoDTO(email, senha){
    return {
        "email": email,
        "senha": senha
    };
}

//Criar uma requisição
function criarRequisicao(email, senha){
    return new Request("http://localhost:8080/autenticar", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(getAutenticacaoDTO(email, senha)),
    });
}

//Solicitar autenticação no servidor
function autenticar(){
    if (validarFormulario()){
        var requisicao = criarRequisicao(document.getElementById("email").value,document.getElementById("senha").value);
        fetch(requisicao)
            .then((response) => {
                if (response.status === 200 || response.status === 404) {
                    return response.json();
                } else {
                    throw new Error("Ocorreu algum erro no servidor!");
                }
            })
            .then(json => {
                console.log(JSON.stringify(json));
                alert(json.mensagem);
            });
    } else
        alert('Os campos e-mail e senha são obrigatórios! Verifique o formulário.')
}