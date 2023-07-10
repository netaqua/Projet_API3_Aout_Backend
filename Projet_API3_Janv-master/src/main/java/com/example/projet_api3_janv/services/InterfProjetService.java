package com.example.projet_api3_janv.services;

import com.example.projet_api3_janv.entities.APIEmploye;
import com.example.projet_api3_janv.entities.APIProjet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface InterfProjetService extends InterfService<APIProjet>{
    List<APIProjet> readNom(String nomproj) throws Exception;

    //List<APIProjet> readCout(Double cout) throws Exception;

    List<APIProjet> read(LocalDate dateDebut);

    List<APIProjet> getProjet(APIEmploye emp);

    List<APIProjet> getProjets();

    Page<APIProjet> allp(Pageable pageable) throws Exception;


}
