package com.ladera.claims.s2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ladera.claims.s1.entities.ClaimDetails;
import com.ladera.claims.s2.entities.EnquiryAudio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

@Service
public class EnquiryAudioServiceImpl implements EnquiryAudioService {

	

	@Autowired
	@Qualifier("enquiryEntityManagerFactory")
	private EntityManagerFactory entityManagerFactory;

	
	public List<EnquiryAudio> getEnquiryDetails(List<ClaimDetails> claimDetails) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String enquiryTableName = "EnquiryAudio_" + claimDetails.get(0).getCreatedAt().getYear() + "-" + claimDetails.get(0).getCreatedAt().getMonthValue();
		
		String query2= "SELECT * FROM `"+enquiryTableName+"` e "+ "WHERE (e.agentId = :agentId)";
		
		Query enquiryQuery = entityManager.createNativeQuery(query2,EnquiryAudio.class);
		
		enquiryQuery.setParameter("agentId",claimDetails.get(0).getAgentId());
		
		List<EnquiryAudio> resultList2 = enquiryQuery.getResultList();
		
		return resultList2;
	
	}


}
