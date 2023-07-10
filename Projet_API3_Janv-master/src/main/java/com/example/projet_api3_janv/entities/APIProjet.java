package com.example.projet_api3_janv.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@NoArgsConstructor
@AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "APIPROJET", schema = "ORA7", catalog = "ORCL")
public class APIProjet {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projet_generator")
    @SequenceGenerator(name="projet_generator", sequenceName ="APIPROJET_SEQ", allocationSize=1)
    private Integer idprojet;
    @NonNull
    private String nomproj;
    private LocalDate datedebut;
    @NonNull
    private LocalDate datefin;
    @NonNull
    private double cout;

    @ManyToOne @JoinColumn(name = "idresponsable")
    private APIEmploye idresponsable;

    @JsonProperty("idresponsable")
    public Integer getIdresponsableId() {
        if (idresponsable != null) {
            return idresponsable.getIdemploye();
        }
        return null;
    }
    /*@PostMapping("/projets")
    public APIProjet saveProjet(@RequestBody APIProjet projet) {
        System.out.println("Nom du projet : " + projet.getNomproj());
        System.out.println("Date de début : " + projet.getDatedebut());
        System.out.println("Date de fin : " + projet.getDatefin());
        System.out.println("Cout : " + projet.getCout());
        System.out.println("ID du responsable : " + projet.getIdresponsable().getIdemploye());

        // Autres opérations de sauvegarde du projet

        return projet;
    }*/
}
