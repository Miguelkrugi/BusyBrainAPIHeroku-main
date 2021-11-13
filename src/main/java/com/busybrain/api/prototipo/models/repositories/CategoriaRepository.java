package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria,Integer> {

    public Iterable<Categoria> findCategoriaByCategoria_nome(String name);

    public Categoria findCategoriaByCategoria_nomeContaining(String name);
}
