function validar_formulario(){
    var ok = document.getElementById("modeloVeiculo").value !== ''
        && document.getElementById("corVeiculo").value !== ''
        && document.getElementById("proprietarioVeiculo").value !== ''
        && (document.getElementById("opcaoSim").checked || document.getElementById("opcaoNao").checked)
        && document.getElementById("marcaVeiculo").value !== '';

    alert(ok);

    return
        document.getElementById("modeloVeiculo").value !== ''
        && document.getElementById("corVeiculo").value !== ''
        && document.getElementById("proprietarioVeiculo").value !== ''
        && (document.getElementById("opcaoSim").checked || document.getElementById("opcaoNao").checked)
        && document.getElementById("marcaVeiculo").value !== '';
}


function adicionar(){

    // recuperando o elemento tbody da tabela
    let corpoTabela = document.getElementById("corpoTabela");

    //criando uma linha na tabela e guardando o elemento criado em uma variável.
    let linha = corpoTabela.insertRow();

    //criando uma celula/coluna na linha criada e gardando o elemento criado em uma variável.
    let celula = linha.insertCell();
    celula.innerText = document.getElementById("nome").value;

    //criando uma celula/coluna na linha criada e gardando o elemento criado em uma variável.
    celula = linha.insertCell();
    celula.innerText = document.getElementById("email").value;

    celula = linha.insertCell();
    celula.append(criarBotaoRemover());

    limparFormulario();
}

function limparFormulario(){
    document.getElementById("nome").value = "";
    document.getElementById("email").value = "";
}

function removerLinha(index){
    let corpoTabela = document.getElementById("corpoTabela");
    corpoTabela.rows[index-1].remove();
}

function criarBotaoRemover(){
    let botaoRemover = document.createElement("button");
    botaoRemover.innerText = "Remover";
    botaoRemover.className = "classe_botao";
    botaoRemover.addEventListener("click", function(evento){
        removerLinha(evento.target.parentElement.parentElement.rowIndex);
    })
    return botaoRemover;
}