package com.ladera.claims.s1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.claims.s1.entities.ClaimDetails;

@Repository
public interface ClaimDetailsDAO  extends JpaRepository<ClaimDetails,Integer>{

	
//	@Query("Select d from ClaimDetails_(:column5)-(:column6) d where (:column1 is null or d.agentId = :column1) AND (:column2 is null or d.customerEmailId = :column2) AND (:column3 is null or d.claimTicketId = :column3) AND d.createdAt >= :column4")
//	public List<ClaimDetails> getClaimDetails(@Param("column1")String agentId,@Param("column2")String customerEmailId,@Param("column3")String claimTicketId,@Param("column4")LocalDate createdAt,@Param("column5")Integer year,@Param("column6")Integer monthValue);
//	
}
