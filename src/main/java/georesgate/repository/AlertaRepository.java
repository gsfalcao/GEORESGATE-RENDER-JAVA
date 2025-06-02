package georesgate.repository;

import georesgate.model.Alerta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlertaRepository implements PanacheRepository<Alerta> {
}