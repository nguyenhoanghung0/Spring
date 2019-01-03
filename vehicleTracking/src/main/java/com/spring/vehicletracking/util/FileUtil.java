package com.spring.vehicletracking.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static List<String> load(MultipartFile file) {
    	List<String> listOfLines = new ArrayList<>();
    	BufferedReader reader;
    	String line;
    	if (!file.isEmpty()) {
			try {
				InputStream is = file.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is));
				line = reader.readLine();
				listOfLines.add(line);
				while (true) {
					// read next line
					line = reader.readLine();
					if (line == null) break;
					listOfLines.add(line);
				}
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
    	
    	return listOfLines;
    }
}
