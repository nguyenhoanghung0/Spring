package com.spring.vehicletracking.services;

import org.springframework.web.multipart.MultipartFile;


public interface StorageService {

	String uploadEventSource(MultipartFile file);
   
}
