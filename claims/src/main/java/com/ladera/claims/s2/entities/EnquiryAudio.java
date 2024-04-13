package com.ladera.claims.s2.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EnquiryAudio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String fileName;
	
	private String fileDescription;
	
	private String filePath;
	
	private LocalDateTime createdAt;
	
	private String agentId;
	


	public EnquiryAudio(Integer id, String fileName, String fileDescription, String filePath, LocalDateTime createdAt,
			String agentId) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileDescription = fileDescription;
		this.filePath = filePath;
		this.createdAt = createdAt;
		this.agentId = agentId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public EnquiryAudio() {
		super();
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "EnquiryAudio [id=" + id + ", fileName=" + fileName + ", fileDescription=" + fileDescription
				+ ", filePath=" + filePath + ", createdAt=" + createdAt + ", agentId=" + agentId + "]";
	}




	
	
}
