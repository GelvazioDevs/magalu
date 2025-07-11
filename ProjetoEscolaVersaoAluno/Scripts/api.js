
async function buscarDadosApi(rota){

    if(rota == "usuarios"){
        return await carregarDadosUsuarios();
    } else if(rota == "professores"){
        return await carregarDadosProfessores();
    }
}