package com.ladera.claims.s1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ladera.claims.s1.entities.ClaimDetails;
import com.ladera.claims.s1.repositories.ClaimDetailsDAO;
import com.ladera.claims.s2.entities.EnquiryAudio;
import com.ladera.claims.s2.service.EnquiryAudioService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

@Service
public class ClaimDetailsServiceImpl implements ClaimDetailsService {

	@Autowired
	private ClaimDetailsDAO claimDAO;
	
	@Autowired
	private EnquiryAudioService enquiryAudioService;

	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<EnquiryAudio> getClaimDetails(ClaimDetails claimDetails) {

		int year = claimDetails.getCreatedAt().getYear();
		int monthValue = claimDetails.getCreatedAt().getMonthValue();
		
		if (claimDetails.getCriteria().equals("agentId")) {
			claimDetails.setAgentId(claimDetails.getValue());
		} else if(claimDetails.getCriteria().equals("claimTicketId")) {
			claimDetails.setClaimTicketId(claimDetails.getValue());
		}else if (claimDetails.getCriteria().equals("customerEmailId")) {
			claimDetails.setCustomerEmailId(claimDetails.getCustomerEmailId());
		}


		String tableName = "ClaimDetails_" + year + "-" + monthValue;
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		List<ClaimDetails> claimDetails2 = claimDAO.getClaimDetails(claimDetails.getAgentId(),claimDetails.getCustomerEmailId(),claimDetails.getClaimTicketId(),claimDetails.getCreatedAt(),year,monthValue);
//		
//		return claimDetails2

		String sqlQuery = "SELECT * FROM `" + tableName + "` d " + "WHERE (:agentId is null or d.agentId = :agentId) "
				+ "AND (:customerEmailId is null or d.customerEmailId = :customerEmailId) "
				+ "AND (:claimTicketId is null or d.claimTicketId = :claimTicketId) " + "AND d.createdAt >= :createdAt";

		Query query = entityManager.createNativeQuery(sqlQuery,ClaimDetails.class);
		query.setParameter("agentId",claimDetails.getAgentId());
		query.setParameter("customerEmailId", claimDetails.getCustomerEmailId());
		query.setParameter("claimTicketId", claimDetails.getClaimTicketId());
		query.setParameter("createdAt", claimDetails.getCreatedAt());
		List<ClaimDetails> resultList = query.getResultList();
		
		List<EnquiryAudio> enquiryDetails = enquiryAudioService.getEnquiryDetails(resultList);
		
		return enquiryDetails;
		
		
			
		
	}

}
