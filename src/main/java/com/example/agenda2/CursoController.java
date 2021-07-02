package com.example.agenda2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@ResponseBody
@CrossOrigin
public class CursoController {
 
    @Autowired
    CursoRepository cursoRepository;

    @GetMapping(value="/")
    public List<Curso> getListarTodos() {
        List<Curso> lista = cursoRepository.findAll();
        return lista;
    }
    

    @GetMapping(value="/detalhes/{id}")
    public Curso getDetalhes(@PathVariable Long id) {
        Curso curso =new Curso();
        curso = cursoRepository.findById(id).get();
        return  curso;
    }

    @PostMapping(value="/adicionar")
    public Curso postAdicionar(@RequestBody Curso curso) {
      Curso cursoNovo = cursoRepository.save(curso);
        return cursoNovo;
    }

    @GetMapping(value="/deletar/{id}")
    public void getDeletar(@PathVariable Long id) {
        cursoRepository.deleteById(id);
        
    }
    
    
    

}
