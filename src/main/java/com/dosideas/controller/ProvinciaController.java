
package com.dosideas.controller;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvinciaController {
    

    @Autowired
    private ProvinciaService provinciaService;
    
    @RequestMapping("/provincias")
    public String provincias(Model model) {
        //List<Provincia> provincias = provinciaService.buscarTodos();
        model.addAttribute("provincias", provinciaService.buscarTodos());
        return "povincias";
    }
    
//     @GetMapping("/provincias")
//    public String provincias(Model model) {
//        model.addAttribute("provincias", provinciaService.buscarTodos());
//        return "provincias";
//    }
}
  
