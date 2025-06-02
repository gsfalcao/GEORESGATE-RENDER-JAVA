package georesgate.service;

import georesgate.model.Residencia;
import georesgate.model.Usuario;
import georesgate.repository.ResidenciaRepository;
import georesgate.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ResidenciaService {

    @Inject
    ResidenciaRepository residenciaRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    public List<Residencia> listarTodos() {
        return residenciaRepository.listAll();
    }

    public Residencia buscarPorId(Long id) {
        return residenciaRepository.findById(id);
    }

    @Transactional
    public String salvar(Residencia residencia, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if (usuario == null) {
            return "Usuário não encontrado.";
        }

        residencia.setUsuario(usuario);
        residenciaRepository.persist(residencia);
        return "Residência salva com sucesso!";
    }

    @Transactional
    public boolean atualizar(Long id, Residencia nova) {
        Residencia antiga = residenciaRepository.findById(id);
        if (antiga == null) return false;

        antiga.setEndereco(nova.getEndereco());
        antiga.setNumero(nova.getNumero());
        antiga.setCep(nova.getCep());
        antiga.setTipo(nova.getTipo());
        antiga.setNumero_andares(nova.getNumero_andares());
        antiga.setGaragem_subterranea(nova.getGaragem_subterranea());

        return true;
    }

    @Transactional
    public boolean deletar(Long id) {
        return residenciaRepository.deleteById(id);
    }
}
