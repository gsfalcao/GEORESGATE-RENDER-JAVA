package georesgate.service;

import georesgate.model.Alerta;
import georesgate.model.Usuario;
import georesgate.repository.AlertaRepository;
import georesgate.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class AlertaService {

    @Inject
    AlertaRepository alertaRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    LocalizacaoService localizacaoService;

    public List<Alerta> listarTodos() {
        return alertaRepository.listAll();
    }

    public Alerta buscarPorId(Long id) {
        return alertaRepository.findById(id);
    }

    @Transactional
    public String salvar(Alerta alerta, Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if (usuario == null) {
            return "Usuário não encontrado.";
        }

        // Pegar latitude e longitude automaticamente
        String[] localizacao = localizacaoService.obterLatitudeLongitude();
        alerta.setLatitude(localizacao[0]);
        alerta.setLongitude(localizacao[1]);
        alerta.setData_hora(LocalDateTime.now());
        alerta.setUsuario(usuario);

        alertaRepository.persist(alerta);
        return "Alerta com localização enviado com sucesso!";
    }

    @Transactional
    public boolean atualizar(Long id, Alerta novoAlerta) {
        Alerta alertaExistente = alertaRepository.findById(id);
        if (alertaExistente == null) return false;

        alertaExistente.setLatitude(novoAlerta.getLatitude());
        alertaExistente.setLongitude(novoAlerta.getLongitude());
        alertaExistente.setData_hora(LocalDateTime.now());

        return true;
    }

    @Transactional
    public boolean deletar(Long id) {
        return alertaRepository.deleteById(id);
    }
}