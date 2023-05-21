package com.eoi.ejemplospringboot.services;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public abstract class GenericServiceWithJPA<T, I, R extends JpaRepository<T, I>> implements GenericService<T, I, R> {

    @Autowired
    R repository;

    @Autowired
    protected GenericServiceWithJPA(R repository) {
        this.repository = repository;
    }

    /**
     * @param i
     * @return
     */
    @Override
    public T getById(I i) {
        try {
            return repository.findById(i)
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
     * @param i
     * @param entity
     * @return
     */
    @Override
    public T update(I i, T entity) {
        return null;
    }

    /**
     * @param i
     */
    @Override
    public void delete(I i) {

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


