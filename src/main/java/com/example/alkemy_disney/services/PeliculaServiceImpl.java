package com.example.alkemy_disney.services;

import com.example.alkemy_disney.entities.Pelicula;
import com.example.alkemy_disney.entities.Personaje;
import com.example.alkemy_disney.repositories.BaseRepository;
import com.example.alkemy_disney.repositories.PeliculaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl extends BaseServiceImpl<Pelicula, Long> implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    private ModelMapper mapper = new ModelMapper();

    public PeliculaServiceImpl(BaseRepository<Pelicula, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Pelicula> findAll() throws Exception {
        try{
            List<Pelicula> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pelicula findById(Long id) throws Exception {
        try{
            Optional<Pelicula> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pelicula save(Pelicula entity) throws Exception {
        try{

            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pelicula update(Long id, Pelicula entity) throws Exception {
        try{
            Optional<Pelicula> entityOptional = baseRepository.findById(id);
            Pelicula entityUpdate = entityOptional.get();
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

    @Override
    public List<Pelicula> obtener_peliculas() throws Exception {
        try{
            List<Pelicula> peliculaList = peliculaRepository.obtener_peliculas();
            return peliculaList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
