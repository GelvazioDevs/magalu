// Example for UsuarioService
class UsuarioService {
    static async criar(usuario) {
        return await ApiService.request('/usuarios', {
            method: 'POST',
            body: JSON.stringify(usuario)
        });
    }

    static async buscarTodos() {
        return await ApiService.request('/usuarios');
    }

    static async buscarPorId(id) {
        return await ApiService.request(`/usuarios/${id}`);
    }

    static async atualizar(id, usuario) {
        return await ApiService.request(`/usuarios/${id}`, {
            method: 'PUT',
            body: JSON.stringify(usuario)
        });
    }

    static async deletar(id) {
        return await ApiService.request(`/usuarios/${id}`, {
            method: 'DELETE'
        });
    }

    // Adapted for json-server: /usuarios?email=foo@bar.com
    static async buscarPorEmail(email) {
        return await ApiService.request(`/usuarios?email=${encodeURIComponent(email)}`);
    }
}

// Example for ClienteService
class ClienteService {
    // ...other methods unchanged...

    // Adapted for json-server: /clientes?cnpj=123456
    static async buscarPorCnpj(cnpj) {
        return await ApiService.request(`/clientes?cnpj=${encodeURIComponent(cnpj)}`);
    }

    // Adapted for json-server: /clientes?usuarioId=1
    static async buscarPorUsuario(usuarioId) {
        return await ApiService.request(`/clientes?usuarioId=${encodeURIComponent(usuarioId)}`);
    }
}

// Example for PalavraChaveService
class PalavraChaveService {
    // ...other methods unchanged...

    // Adapted for json-server: /palavras-chave?clienteId=1
    static async buscarPorCliente(clienteId) {
        return await ApiService.request(`/palavras-chave?clienteId=${encodeURIComponent(clienteId)}`);
    }

    // Adapted for json-server: /palavras-chave?ativa=true
    static async buscarAtivas() {
        return await ApiService.request('/palavras-chave?ativa=true');
    }
}

// Example for PostService
class PostService {
    // ...other methods unchanged...

    // Adapted for json-server: /posts?clienteId=1
    static async buscarPorCliente(clienteId) {
        return await ApiService.request(`/posts?clienteId=${encodeURIComponent(clienteId)}`);
    }

    // Adapted for json-server: /posts?redeSocialId=1
    static async buscarPorRedeSocial(redeSocialId) {
        return await ApiService.request(`/posts?redeSocialId=${encodeURIComponent(redeSocialId)}`);
    }

    // Adapted for json-server: /posts?data_gte=2024-01-01&data_lte=2024-01-31
    static async buscarPorPeriodo(dataInicio, dataFim) {
        return await ApiService.request(`/posts?data_gte=${encodeURIComponent(dataInicio)}&data_lte=${encodeURIComponent(dataFim)}`);
    }
}
