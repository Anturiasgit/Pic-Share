package com.anturia.picshare.repository;

import com.anturia.picshare.model.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicRepository extends JpaRepository<Pic, Long> {
}
