package com.swetonyancelmo.icompras.produtos.repository;

import com.swetonyancelmo.icompras.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
