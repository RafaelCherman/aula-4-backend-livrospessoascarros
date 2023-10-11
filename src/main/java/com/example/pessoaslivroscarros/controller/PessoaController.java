package com.example.pessoaslivroscarros.controller;

import com.example.pessoaslivroscarros.dto.LivroDTO;
import com.example.pessoaslivroscarros.dto.PessoaDTO;
import com.example.pessoaslivroscarros.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    private ResponseEntity<PessoaDTO> findById(@RequestParam Long id ){
        try {
            PessoaDTO pessoaDTO = service.findById(id);
            return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todos")
    private ResponseEntity<List<PessoaDTO>> listAll(){
        try {
            List<PessoaDTO> lista = service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    private ResponseEntity<PessoaDTO> cadastrar(@RequestBody PessoaDTO pessoaDTO){
        try {
            PessoaDTO pessoaSalva = service.cadastrar(pessoaDTO);
            return new ResponseEntity<>(pessoaSalva, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    private ResponseEntity<PessoaDTO> editar(@RequestParam Long id, @RequestBody PessoaDTO pessoaDTO)
    {
        try {
            PessoaDTO pessoaSalva = service.editar(id ,pessoaDTO);
            return new ResponseEntity<>(pessoaSalva, HttpStatus.OK);
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
