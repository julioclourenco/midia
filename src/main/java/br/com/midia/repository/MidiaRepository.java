package br.com.midia.repository;

import br.com.midia.entity.Midia;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MidiaRepository extends JpaRepository<Midia, Long> {
}
