package georesgate.repository;

import georesgate.model.Residencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResidenciaRepository implements PanacheRepository<Residencia> {
}