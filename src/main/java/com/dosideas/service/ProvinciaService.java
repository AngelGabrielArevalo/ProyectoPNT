package com.dosideas.service;

import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProvinciaService {

    //ProvinciaRepository provinciaRepository= new ProvinciaRepository(); dependencia
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public ProvinciaService() {
    }
    
    

    public Provincia buscarPorId(Long id) {
        if (id == null) {
            return null;
        } else {
            return provinciaRepository.findById(id).orElse(null);
        }
    }

    public List<Provincia> buscarTodos() {
        return provinciaRepository.findAll();
    }

    public List<Provincia> buscarPorNombreExacto(String nombre) throws IllegalArgumentException {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre de Provincia null");
        } else if (nombre.length() < 3) {
            throw new IllegalArgumentException("Longitud del nombre de Provincia menor a 3");
        } else {
            List<Provincia> provincias = buscarTodos();
            List<Provincia> provinciasEncontradas = new ArrayList();
            for (Provincia provincia : provincias) {
                if (provincia.getNombre().equals(nombre)) {
                    provinciasEncontradas.add(provincia);
                }
            }
            if(provinciasEncontradas.size()==0){
                return null;
            }else{
                return provinciasEncontradas;
            }   
        }
    }

    public List<Provincia> buscarPorNombreGeneral(String nombre) throws IllegalArgumentException {
        if (nombre == null) {
            throw new IllegalArgumentException("Nombre de Provincia null");
        } else if (nombre.length() < 3) {
            throw new IllegalArgumentException("Longitud del nombre de Provincia menor a 3");
        } else {
            return provinciaRepository.findByNombre(nombre);
        }
    }

    public void actualizarDatos(Provincia provincia) throws IllegalArgumentException{
        if(provincia==null){
            throw new IllegalArgumentException("Provincia null");
        }else if(provincia.getNombre()==null){
            throw new IllegalArgumentException("Nombre de Provincia null");
        }else if(provincia.getNombre().length()<3){
            throw new IllegalArgumentException("Longitud del nombre de Provincia menor a 3");
        }else{
            provinciaRepository.save(provincia);
        }
    }
    
    
    /*Pasamos esta logica al repository
    public Provincia buscarPorId(Long id) {       
        if(id==null){
            return null;
        }else if(id>10L){
            return null;
        }else{
            return new Provincia(id, "PROVINCIA"+id);
        } 
    }*/
}
