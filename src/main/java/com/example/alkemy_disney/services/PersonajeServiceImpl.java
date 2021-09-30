package com.example.alkemy_disney.services;

import com.example.alkemy_disney.entities.Personaje;
import com.example.alkemy_disney.repositories.BaseRepository;
import com.example.alkemy_disney.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeServiceImpl extends BaseServiceImpl<Personaje, Long> implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeServiceImpl(BaseRepository<Personaje, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    @Transactional
    public List<Personaje> findAll() throws Exception {
        try{
            List<Personaje> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Personaje findById(Long id) throws Exception {
        try{
            Optional<Personaje> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Personaje save(Personaje entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Personaje update(Long id, Personaje entity) throws Exception {
        try{
            Optional<Personaje> entityOptional = baseRepository.findById(id);
            Personaje entityUpdate = entityOptional.get();
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
    public List<Personaje> obtener_imagen_y_nombre() throws Exception {
        try{
            System.out.println("Por cargar la lista SERVICE");
            List<Personaje> personajeList =  personajeRepository.obtener_imagen_y_nombre();
            System.out.println("Lista cargada SERVICE");
            return personajeList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Override
    public List<Personaje> buscar_personaje(String filtro) throws Exception {
        try{
            List<Personaje> personajeList =  personajeRepository.buscar_personaje(filtro);
            return personajeList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /*
    @Override
    public List<Personaje> buscar_personaje(String filtroNombre, int filtroEdad) throws Exception {
        try{
            List<Personaje> personajeList =  personajeRepository.buscar_personaje_filtro_avanzado(filtroNombre,filtroEdad);
            return personajeList;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
*/


}
