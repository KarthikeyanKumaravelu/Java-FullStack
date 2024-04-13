package com.ladera.claims.s2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.claims.s2.entities.EnquiryAudio;



@Repository
public interface EnquiryAudioDAO extends JpaRepository<EnquiryAudio,Integer> {

}
