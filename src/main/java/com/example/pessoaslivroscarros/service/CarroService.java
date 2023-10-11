package com.example.pessoaslivroscarros.service;


import com.example.pessoaslivroscarros.dto.CarroDTO;
import com.example.pessoaslivroscarros.entity.Carro;
import com.example.pessoaslivroscarros.repository.CarroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public CarroDTO findById(Long id){
        Carro carro = repository.findById(id).orElseThrow(()-> new RuntimeException("Registro não encontrado"));
        return modelMapper.map(carro, CarroDTO.class);
    }

    public List<CarroDTO> listAll(){
        List<Carro> lista = repository.findAll();
        List<CarroDTO> listaDTO = new ArrayList<>();

        for(Carro i : lista)
        {
            listaDTO.add(modelMapper.map(i, CarroDTO.class));
        }

        return listaDTO;
    }

    public CarroDTO cadastrar(CarroDTO carroDTO){
        Carro carro = modelMapper.map(carroDTO, Carro.class);

        Carro carrosalvo = repository.save(carro);

        return modelMapper.map(carrosalvo, CarroDTO.class);
    }

    public CarroDTO editar(Long id, CarroDTO carroDTO){
        if(carroDTO.getId() != id)
        {
            throw new RuntimeException("IDs diferentes");
        }
        Carro carro = modelMapper.map(carroDTO, Carro.class);

        Carro carrosalvo = repository.save(carro);

        return modelMapper.map(carro, CarroDTO.class);
    }

    public String deletar(Long id)
    {
        this.repository.deleteById(id);
        return "Registro deletado com sucesso";
    }
}
