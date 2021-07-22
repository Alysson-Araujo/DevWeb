package br.com.farmacia.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public boolean existsByEmail(String email);
}
