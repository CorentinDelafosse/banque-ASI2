package com.banque;

import com.banque.model.*;
import com.banque.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BanqueApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner testerBackend(TypeProduitRepository typeProduitRepository, ProduitBancaireRepository produitBancaireRepository,
                                    PersonnePhysiqueRepository personnePhysiqueRepository, TypePersonneMoraleRepository typePersonneMoraleRepository,
                                    ClientBancaireRepository clientBancaireRepository, PersonneMoraleRepository personneMoraleRepository,
                                    OperationRepository operationRepository)
    {
        return args -> {
            List<TypeProduit> typesProduits;
            List<ProduitBancaire> produitBancaires;
            TypeProduit tp1=new TypeProduit((float)0.2,"tp1",0);
            typeProduitRepository.save(tp1);
            TypeProduit tp2=new TypeProduit(3,"tp2",0);
            typeProduitRepository.save(tp2);
            TypeProduit tp3=new TypeProduit(0,"tp3",15);
            typeProduitRepository.save(tp3);

            tp3= typeProduitRepository.findById(tp3.getId()).orElseThrow();
            ProduitBancaire pb1 = new ProduitBancaire(1,"num1", tp3);
            produitBancaireRepository.save(pb1);
            tp2= typeProduitRepository.findById(tp2.getId()).orElseThrow();
            ProduitBancaire pb2 = new ProduitBancaire(2,"num2",tp2);
            produitBancaireRepository.save(pb2);
            tp3= typeProduitRepository.findById(tp3.getId()).orElseThrow();
            ProduitBancaire pb3 = new ProduitBancaire(3,"num3",tp3);
            produitBancaireRepository.save(pb3);

            typesProduits=typeProduitRepository.findAll();
            produitBancaires=produitBancaireRepository.findAll();
            System.out.println(produitBancaires);

            pb1=produitBancaireRepository.findById(pb1.getId()).orElseThrow();
            produitBancaireRepository.deleteById(pb1.getId());
            if (typeProduitRepository.existsById(tp3.getId())){
                System.out.println("tp3 est toujours dans la base");
            }
            else{
                System.out.println("tp3 n''existe plus");
            }
            if (produitBancaireRepository.existsById(pb1.getId())) {
                System.out.println("pb1 est toujours dans la base");
            }
            else {
                System.out.println("pb1 n''existe plus");
            }

            if (produitBancaireRepository.existsById(pb3.getId())) {
                System.out.println("pb3 est toujours dans la base");
            }
            else {
                System.out.println("pb3 n''existe plus");
            }

/*
            // Création de produits bancaires
            tp2= typeProduitRepository.findById(tp2.getId()).orElseThrow();
            pb2 = new ProduitBancaire(1,"num4",tp2);
            produitBancaireRepository.save(pb2);
            tp3= typeProduitRepository.findById(tp3.getId()).orElseThrow();
            pb3 = new ProduitBancaire(2,"num5",tp3);
            produitBancaireRepository.save(pb3);
            tp3= typeProduitRepository.findById(tp3.getId()).orElseThrow();
            pb1 = new ProduitBancaire(3,"num6",tp3);
            produitBancaireRepository.save(pb1);
// Création de personnes physiques
            PersonnePhysique pp1=new PersonnePhysique("adresse_pp1","nom_pp1","prenom_pp1");
            personnePhysiqueRepository.save(pp1);
            PersonnePhysique pp2=new PersonnePhysique("adresse_pp2","nom_pp2","prenom_pp2");
            personnePhysiqueRepository.save(pp2);
            PersonnePhysique pp3=new PersonnePhysique("adresse_pp3","nom_pp3","prenom_pp3");
            personnePhysiqueRepository.save(pp3);
// Création de types de personnes morales
            TypePersonneMorale tpm1=new TypePersonneMorale("SA");
            typePersonneMoraleRepository.save(tpm1);
            TypePersonneMorale tpm2=new TypePersonneMorale("SARL");
            typePersonneMoraleRepository.save(tpm2);
            TypePersonneMorale tpm3=new TypePersonneMorale("Auto Entrepreneur");
            typePersonneMoraleRepository.save(tpm3);
// Création de personnes morales
            PersonneMorale pm1=new PersonneMorale("pm1", "SiRET pm1","raisonsoc pm1", tpm1);
            personneMoraleRepository.save(pm1);
            PersonneMorale pm2=new PersonneMorale("pm2", "SiRET pm2","raisonsoc pm2", tpm2);
            personneMoraleRepository.save(pm2);
            PersonneMorale pm3=new PersonneMorale("pm3", "SiRET pm3","raisonsoc pm3", tpm1);
            personneMoraleRepository.save(pm3);
// Création de client bancaires
            ClientBancaire cb1 =new ClientBancaire();
            clientBancaireRepository.save(cb1);
            ClientBancaire cb2=new ClientBancaire();
            clientBancaireRepository.save(cb2);
            ClientBancaire cb3=new ClientBancaire();
            clientBancaireRepository.save(cb3);
// Ajout des participants aux clients
            pm1=personneMoraleRepository.findById(pm1.getId()).orElseThrow();
            cb1.addPersonne(pm1);
            clientBancaireRepository.save(cb1);
            cb1=clientBancaireRepository.findById(cb1.getId()).orElseThrow();
            pp2=personnePhysiqueRepository.findById(pp2.getId()).orElseThrow();
            cb1.addPersonne(pp2);
            clientBancaireRepository.save(cb1);
            pp1=personnePhysiqueRepository.findById(pp1.getId()).orElseThrow();
            cb2=clientBancaireRepository.findById(cb2.getId()).orElseThrow();
            pp1.addClientBancaire(cb2);
            personnePhysiqueRepository.save(pp1);
            cb3=clientBancaireRepository.findById(cb3.getId()).orElseThrow();
            pp3=personnePhysiqueRepository.findById(pp3.getId()).orElseThrow();
            cb3.addPersonne(pp3);
            clientBancaireRepository.save(cb3);
            System.out.println("***************************************************" +
                    "\nLes personnes physiques" +
                    "***********************************************************");
            System.out.println(personnePhysiqueRepository.findAll());
            System.out.println("***************************************************" +
                    "\nLes personnes morales" +
                    "***********************************************************");
            System.out.println(personneMoraleRepository.findAll());
*/


            // Création Operation
            TypeProduit tp = new TypeProduit(10, "typeProduit1",100);
            typeProduitRepository.save(tp);
            ProduitBancaire pb = new ProduitBancaire(10, "123456", tp);
            produitBancaireRepository.save(pb);

            Operation op1 = new Operation(12,"op1","operation1");
            Operation op2 = new Operation(13,"op2","operation2");
            pb.addOperation(op1);
            operationRepository.save(op1);
            operationRepository.save(op2);
            produitBancaireRepository.save(pb);

            // Modification
            var affichageOp1 = operationRepository.findById(op1.getId());
            System.out.println("**************************************" + "\n" + affichageOp1.toString() + "Avant changement");
            op1.setLibelle("OPERATION 1");
            operationRepository.save(op1);
            affichageOp1 =  operationRepository.findById(op1.getId());
            System.out.println("**************************************" + "\n" + affichageOp1.toString() + "Après changement");

            // Delete de op1
            System.out.println(pb.getOperations());
            pb = produitBancaireRepository.findById(pb.getId()).orElseThrow();
            //produitBancaireRepository.deleteById(pb.getId());
            op1 = operationRepository.findById(op1.getId()).orElseThrow();
            operationRepository.deleteById(op1.getId());
            System.out.println("op1 existe ?" + operationRepository.existsById(op1.getId()));
            System.out.println("op2 existe ?" + operationRepository.existsById(op2.getId()));
            System.out.println("pb existe ?" + produitBancaireRepository.existsById(pb.getId()));
        };
    }
}
