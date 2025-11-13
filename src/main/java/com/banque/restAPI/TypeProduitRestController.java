package com.banque.restAPI;

import com.banque.model.TypeProduit;
import com.banque.service.TypeProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banque_rest/TypeProduit")
public class TypeProduitRestController {
    private final TypeProduitService typeProduitService;

    @Autowired
    public TypeProduitRestController(TypeProduitService typeProduitService){
        this.typeProduitService = typeProduitService;
    }

    @GetMapping
    public ResponseEntity<List<TypeProduit>> getAllTypeProduits(){
        List<TypeProduit> liste = typeProduitService.getAllTypeProduit();
        return new ResponseEntity<List<TypeProduit>>(liste, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TypeProduit> getTypeProduitById(@PathVariable("id") Long idTypeProduit){
        TypeProduit cg =  typeProduitService.getTypeProduitById(idTypeProduit);
        return new ResponseEntity<TypeProduit>(cg, HttpStatus.OK);
    }


}