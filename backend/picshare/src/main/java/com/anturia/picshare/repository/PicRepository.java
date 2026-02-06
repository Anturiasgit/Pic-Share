package com.anturia.picshare.repository;

public interface PicRepository extends JpaRepository<Pic, Long> {
package com.anturia.picshare.repository;

import com.anturia.picshare.model.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicRepository extends JpaRepository<Pic, Long> {

    // Trouver toutes les photos d’un lieu précis
    List<Pic> findByLocation(String location);

    // Trouver toutes les photos dont le titre contient un mot clé (ignore la casse)
    List<Pic> findByTitleContainingIgnoreCase(String keyword);

    // Trouver toutes les photos prises après une certaine date
    List<Pic> findByDateTakenAfter(java.time.LocalDate date);

    // Trouver toutes les photos prises avant une certaine date
    List<Pic> findByDateTakenBefore(java.time.LocalDate date);

    // Combiner titre et location
    List<Pic> findByTitleContainingIgnoreCaseAndLocation(String keyword, String location);

}

}
