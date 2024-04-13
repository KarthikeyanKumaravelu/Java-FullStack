package com.ladera.claims.s1.service;

import java.util.List;

import com.ladera.claims.s1.entities.ClaimDetails;
import com.ladera.claims.s2.entities.EnquiryAudio;

public interface ClaimDetailsService {
	
 
 public List<EnquiryAudio> getClaimDetails(ClaimDetails claimDetails);
}
