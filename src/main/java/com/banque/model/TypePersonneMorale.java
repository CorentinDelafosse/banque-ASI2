package com.banque.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "TypePersonneMorale")
@Table(name = "type_personne_morale")
public class TypePersonneMorale {
    @Id
    @SequenceGenerator(name = "typepersonnemorale_sequence", sequenceName = "typepersonnemorale_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "typepersonnemorale_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "intitule", nullable = false, columnDefinition = "TEXT")
    private String intitule;

    @OneToMany(mappedBy = "typePersonneMorale", fetch = FetchType.EAGER, cascade = {CascadeType.ALL},orphanRemoval = true)
    private List<PersonneMorale> personnesMorale = new ArrayList<>();

    public TypePersonneMorale() {

    }

    public TypePersonneMorale(String intitule) {
        this.intitule = intitule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<PersonneMorale> getPersonnesMorale() {
        return personnesMorale;
    }

    public void setPersonnesMorale(List<PersonneMorale> personnesMorale) {
        this.personnesMorale = personnesMorale;
    }

    public void addPersonneMorale(PersonneMorale personneMorale) {
        this.personnesMorale.add(personneMorale);
    }

    public void removePersonneMorale(PersonneMorale personneMorale) {
        this.personnesMorale.remove(personneMorale);
    }

    @PreRemove
    private void gererLien(){
        for(PersonneMorale pm : personnesMorale){
            pm.setTypePersonneMorale(null);
        }
        personnesMorale.clear();
    }
    @Override
    public String toString() {
        return "TypePersonneMorale{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", personnesMorale=" + personnesMorale +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(intitule);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()) return false;
        TypePersonneMorale that = (TypePersonneMorale)obj;
        return Objects.equals(intitule, that.intitule);
    }
}