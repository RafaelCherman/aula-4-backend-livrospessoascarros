package com.example.pessoaslivroscarros.controller;

import com.example.pessoaslivroscarros.dto.LivroDTO;
import com.example.pessoaslivroscarros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@CrossOrigin(origins = "http://localhost:4200")
public class LivroController {

    @Autowired
    private LivroService service;


    @GetMapping
    private ResponseEntity<LivroDTO> findById(@RequestParam Long id ){
        try {
            LivroDTO livroDTO = service.findById(id);
            return new ResponseEntity<>(livroDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/todos")
    private ResponseEntity<List<LivroDTO>> listAll(){
        try {
            List<LivroDTO> lista = service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    private ResponseEntity<LivroDTO> cadastrar(@RequestBody LivroDTO livroDTO){
        try {
            LivroDTO livroSalvo = service.cadastrar(livroDTO);
            return new ResponseEntity<>(livroSalvo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    private ResponseEntity<LivroDTO> editar(@RequestParam Long id, @RequestBody LivroDTO livroDTO)
    {
        try {
            LivroDTO livroSalvo = service.editar(id ,livroDTO);
            return new ResponseEntity<>(livroSalvo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    private ResponseEntity<HttpStatus> deletar(@RequestParam Long id)
    {
        try {
            String sucesso = service.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
