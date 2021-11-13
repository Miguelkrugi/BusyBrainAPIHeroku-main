package com.busybrain.api.prototipo.models.repositories;

import com.busybrain.api.prototipo.models.Enrolment;
import com.busybrain.api.prototipo.models.Tarefa;
import com.busybrain.api.prototipo.models.Utilizador;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrolment,Integer> {

    public Iterable<Enrolment> findEnrolmentByTarefaContaining(Tarefa tarefa);
    public Iterable<Enrolment> findEnrolmentByUtilizadorContaining(Utilizador utilizador);


}
