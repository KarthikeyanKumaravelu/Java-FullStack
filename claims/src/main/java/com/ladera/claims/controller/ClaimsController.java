package com.ladera.claims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.claims.s1.entities.ClaimDetails;
import com.ladera.claims.s1.service.ClaimDetailsService;
import com.ladera.claims.s2.entities.EnquiryAudio;

@RestController
@RequestMapping("/claims")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = {"Content-type", "Authorization"}, allowCredentials = "true")
public class ClaimsController {
	
	
	@Autowired
	private ClaimDetailsService claimService;
	
	@PostMapping("/getDetails")
	public List<EnquiryAudio> getClaimDetails(@RequestBody ClaimDetails claimDetails){
		
	List<EnquiryAudio> enquiryAudioList = claimService.getClaimDetails(claimDetails);
	
	return enquiryAudioList;
	
//	return new ResponseEntity<Response<List<EnquiryAudio>>> (Response.builder().data(enquiryAudioList).message("Fetched Successfully").build(),HttpStatus.OK);;
	
	}
	
	
	
}
