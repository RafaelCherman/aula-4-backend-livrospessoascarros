package com.example.pessoaslivroscarros.service;


import com.example.pessoaslivroscarros.dto.LivroDTO;
import com.example.pessoaslivroscarros.entity.Livro;
import com.example.pessoaslivroscarros.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public LivroDTO findById(Long id){
        Livro livro = repository.findById(id).orElseThrow(()-> new RuntimeException("Registro não encontrado"));
        return modelMapper.map(livro, LivroDTO.class);
    }

    public List<LivroDTO> listAll(){
        List<Livro> lista = repository.findAll();
        List<LivroDTO> listaDTO = new ArrayList<>();

        for(Livro i : lista)
        {
            listaDTO.add(modelMapper.map(i, LivroDTO.class));
        }

        return listaDTO;
    }

    public LivroDTO cadastrar(LivroDTO livroDTO){
        Livro livro = modelMapper.map(livroDTO, Livro.class);

        Livro livrosalva = repository.save(livro);

        return modelMapper.map(livrosalva, LivroDTO.class);
    }

    public LivroDTO editar(Long id, LivroDTO livroDTO){
        if(livroDTO.getId() != id)
        {
            throw new RuntimeException("IDs diferentes");
        }
        Livro livro = modelMapper.map(livroDTO, Livro.class);

        Livro livrosalvo = repository.save(livro);

        return modelMapper.map(livrosalvo, LivroDTO.class);
    }

    public String deletar(Long id)
    {
        this.repository.deleteById(id);
        return "Registro deletado com sucesso";
    }
}
