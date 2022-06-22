/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Angel Arévalo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class ProvinciaServiceTest {

    public ProvinciaServiceTest() {
    }

    @Autowired
    private ProvinciaService provinciaService;

    //Test buscarPorId()
    @Test
    public void buscarPorId_conIdExistente_retornaProvincia() {
        //ProvinciaService provinciaService = new ProvinciaService(new ProvinciaRepository());
        Long id = 1L;

        Provincia provincia = provinciaService.buscarPorId(id);
        assertNotNull(provincia);
        assertEquals(id, provincia.getId());
    }

    @Test
    public void buscarPorId_conIdInexistente_retornaNull() {
        //ProvinciaService provinciaService = new ProvinciaService(new ProvinciaRepository());
        Long id = 21L;

        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNull();
    }

    @Test
    public void buscarPorId_conIdNull_retornaNull() {
        //ProvinciaService provinciaService = new ProvinciaService(new ProvinciaRepository());
        Long id = null;

        Provincia provincia = provinciaService.buscarPorId(id);
        assertThat(provincia).isNull();
    }

    //Test bucarPorNombreExacto()
    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombreExacto_conLongitudMenorATres_lanzaExcepcion() {
        String nombre = "la";
        provinciaService.buscarPorNombreExacto(nombre);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombreExacto_conNombreNull_lanzaExcepcion() {
        String nombre = null;
        provinciaService.buscarPorNombreExacto(nombre);
        fail("Debería haberse lanzado una excepción.");
    }
    
    @Test
    public void buscarPorNombreExacto_conNombreExistente_RetornaListaProvincia() {
        String nombre = "Chaco";
        List<Provincia> provincia=provinciaService.buscarPorNombreExacto(nombre);
        assertNotNull(provincia);
        for(Provincia provin : provincia){
            assertEquals(nombre, provin.getNombre());
        }
    }
    
    @Test
    public void buscarPorNombreExacto_conNombreInexistente_RetornaNull() {
        String nombre = "New York";
        List<Provincia> provincia=provinciaService.buscarPorNombreExacto(nombre);
        assertThat(provincia).isNull();
    }
    
    //Test buscarPorNombreGeneral()
    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombreGeneral_conLongitudMenorATres_lanzaExcepcion() {
        String nombre = "la";
        provinciaService.buscarPorNombreExacto(nombre);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscarPorNombreGeneral_conNombreNull_lanzaExcepcion() {
        String nombre = null;
        provinciaService.buscarPorNombreExacto(nombre);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void actualizarDatos_conProvinciaNull_lanzaExcepcion() {
        Provincia provincia = null;
        provinciaService.actualizarDatos(provincia);
        fail("Debería haberse lanzado una excepción.");
    }
    
    @Test
    public void buscarPorNombreGeneral_conNombreExistente_RetornaListaProvincia() {
        String nombre = "Chaco";
        List<Provincia> provincia=provinciaService.buscarPorNombreGeneral(nombre);
        assertNotNull(provincia);
        for(Provincia provin : provincia){
            assertEquals(nombre, provin.getNombre());
        }
    }
    
    @Test
    public void buscarPorNombreGeneral_conNombreInexistente_RetornaNull() {
        String nombre = "New York";
        List<Provincia> provincia=provinciaService.buscarPorNombreExacto(nombre);
        assertThat(provincia).isNull();
    }
    
    //Test actualizarDatos()
    @Test(expected = IllegalArgumentException.class)
    public void actualizarDatos_conNombreDeProvinciaNull_lanzaExcepcion() {
        Provincia provincia = new Provincia();
        provincia.setId(1L);
        provincia.setNombre(null);
        provinciaService.actualizarDatos(provincia);
        fail("Debería haberse lanzado una excepción.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void actualizarDatos_conLongitudDeNombreDeProvinciaMenorATres_lanzaExcepcion() {
        Provincia provincia = new Provincia();
        provincia.setId(1L);
        provincia.setNombre("la");
        provinciaService.actualizarDatos(provincia);
        fail("Debería haberse lanzado una excepción.");
    }

}
