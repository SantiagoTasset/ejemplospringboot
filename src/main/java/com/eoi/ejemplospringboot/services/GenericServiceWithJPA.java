package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import com.eoi.ejemplospringboot.errorcontrol.exceptions.ParametrosIncorrectosException;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public abstract class GenericServiceWithJPA<T, ID, R extends JpaRepository<T, ID>> implements GenericService<T, ID, R> {

    @Autowired
    R repository;

    @Autowired
    protected GenericServiceWithJPA(R repository) {
        this.repository = repository;
    }


    /**
     * @param id 
     * @return
     */
    @Override
    public T getById(ID id) {
        try {
            return repository.findById(id)
                    .orElseThrow(MiEntidadNoEncontradaException::new);
        } catch (MiEntidadNoEncontradaException ex) {
            throw new MiEntidadNoEncontradaException();
        }
    }

    /**
     * @param entity 
     * @return
     */
    @Override
    public T create(T entity) {
        return null;
    }

    /**
     * @param id 
     * @param entity
     * @return
     */
    @Override
    public T update(ID id, T entity) {
        return null;
    }

    /**
     * @param id 
     */
    @Override
    public void delete(ID id) {

    }

    /**
     * @return 
     */
    @Override
    public List<T> listAll() {
        return null;
    }



    // Resto de los métodos del servicio
    @Override
    public R getRepository() {
        return repository;
    }

}


