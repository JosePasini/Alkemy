package com.example.alkemy_disney.services;

import com.example.alkemy_disney.entities.Genero;
import com.example.alkemy_disney.repositories.BaseRepository;
import com.example.alkemy_disney.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl extends BaseServiceImpl<Genero, Long> implements GeneroService{

    @Autowired
    private GeneroRepository generoRepository;

    public GeneroServiceImpl(BaseRepository<Genero, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Genero> findAll() throws Exception {
        try{
            List<Genero> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Override
    @Transactional
    public Genero findById(Long id) throws Exception {
        try{
            Optional<Genero> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Genero save(Genero entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Genero update(Long id, Genero entity) throws Exception {
        try{
            Optional<Genero> entityOptional = baseRepository.findById(id);
            Genero entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
