package com.ladera.claims.s2.service;

import java.util.List;

import com.ladera.claims.s1.entities.ClaimDetails;
import com.ladera.claims.s2.entities.EnquiryAudio;

public interface EnquiryAudioService {

	public List<EnquiryAudio> getEnquiryDetails(List<ClaimDetails> claimDetails);
}
