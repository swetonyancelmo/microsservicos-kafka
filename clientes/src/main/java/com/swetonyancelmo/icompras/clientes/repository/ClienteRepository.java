package com.swetonyancelmo.icompras.clientes.repository;

import com.swetonyancelmo.icompras.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
