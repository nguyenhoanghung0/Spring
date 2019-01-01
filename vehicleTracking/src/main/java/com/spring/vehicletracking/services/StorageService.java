package com.spring.vehicletracking.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public interface StorageService {

	List<String> uploadEventSource(MultipartFile file);   
}
