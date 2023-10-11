package com.example.pessoaslivroscarros.controller;


import com.example.pessoaslivroscarros.dto.CarroDTO;
import com.example.pessoaslivroscarros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin(origins = "http://localhost:4200")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    private ResponseEntity<CarroDTO> findById(@RequestParam Long id ){
        try {
            CarroDTO carroDTO = service.findById(id);
            return new ResponseEntity<>(carroDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todos")
    private ResponseEntity<List<CarroDTO>> listAll(){
        try {
            List<CarroDTO> lista = service.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    private ResponseEntity<CarroDTO> cadastrar(@RequestBody CarroDTO carroDTO){
        try {
            CarroDTO carroSalvo = service.cadastrar(carroDTO);
            return new ResponseEntity<>(carroSalvo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    private ResponseEntity<CarroDTO> editar(@RequestParam Long id, @RequestBody CarroDTO carroDTO)
    {
        try {
            CarroDTO carroSalvo = service.editar(id ,carroDTO);
            return new ResponseEntity<>(carroSalvo, HttpStatus.OK);
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
