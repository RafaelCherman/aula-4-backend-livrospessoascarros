package com.example.pessoaslivroscarros.service;

import com.example.pessoaslivroscarros.dto.PessoaDTO;
import com.example.pessoaslivroscarros.entity.Pessoa;
import com.example.pessoaslivroscarros.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public PessoaDTO findById(Long id){
        Pessoa pessoa = repository.findById(id).orElseThrow(()-> new RuntimeException("Registro não encontrado"));
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> listAll(){
        List<Pessoa> lista = repository.findAll();
        List<PessoaDTO> listaDTO = new ArrayList<>();

        for(Pessoa i : lista)
        {
            listaDTO.add(modelMapper.map(i, PessoaDTO.class));
        }

        return listaDTO;
    }

    public PessoaDTO cadastrar(PessoaDTO pessoaDTO){
        Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);

        Pessoa pessoasalva = repository.save(pessoa);

        return modelMapper.map(pessoasalva, PessoaDTO.class);
    }

    public PessoaDTO editar(Long id, PessoaDTO pessoaDTO){
        if(pessoaDTO.getId() != id)
        {
            throw new RuntimeException("IDs diferentes");
        }
        Pessoa pessoa = modelMapper.map(pessoaDTO, Pessoa.class);

        Pessoa pessoasalva = repository.save(pessoa);

        return modelMapper.map(pessoasalva, PessoaDTO.class);
    }

    public String deletar(Long id)
    {
        this.repository.deleteById(id);
        return "Registro deletado com sucesso";
    }
}
