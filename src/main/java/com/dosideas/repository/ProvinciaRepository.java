
package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
    List<Provincia> findByNombre(String nombre);
    
}

/*
@Repository
public class ProvinciaRepository {
    public Provincia finById(Long id){
        if(id==null){
            return null;
        }else if(id>10L){
            return null;
        }else{
            return new Provincia(id, "PROVINCIA"+id);
        } 
    }
}
*/
