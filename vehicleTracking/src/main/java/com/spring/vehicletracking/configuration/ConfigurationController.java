package com.spring.vehicletracking.configuration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.vehicletracking.scheduler.ReaderTaskScheduler;
import com.spring.vehicletracking.scheduler.WriterTaskScheduler;
import com.spring.vehicletracking.services.StorageService;
import com.spring.vehicletracking.util.CommonConstant;


@Controller
@RequestMapping("/configuration")
public class ConfigurationController {

	private static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);
	
	private final StorageService fileSystemStorageService;

    @Autowired
    public ConfigurationController(StorageService storageService) {
        this.fileSystemStorageService = storageService;
    }
    
    private List<String> errorList = new ArrayList<>();
    
    @RequestMapping(method=RequestMethod.GET)
	public ModelAndView configuration() {
		
    	ConfigurationForm form = ConfigurationForm.getInstance();
    	form.setErrorList(errorList.toArray(new String [0]));
    	
		return new ModelAndView("configurationpage", "configurationForm", form);
	}
	
    @RequestMapping(params="upload", method=RequestMethod.POST)
    public String fileUploadHandler(@RequestParam(required=false, name="file") MultipartFile file) {
    	logger.info("Uploading file:" + file.getOriginalFilename());    	
    	
    	errorList = fileSystemStorageService.uploadEventSource(file);
    	
    	return "redirect:/#configuration";
    }
    
    @RequestMapping(params="start", method=RequestMethod.POST)
    public String startServiceHandler(@ModelAttribute("configurationForm") ConfigurationForm form,
    		ModelAndView model) {
    	
    	errorList = new ArrayList<>();
    	
    	CommonConstant.PAGE_SIZE = form.getNumberOfRecordsPerPage();
    	
    	logger.info("Writer Period: " + form.getWriterPeriod());    	
    	WriterTaskScheduler.setWriterPeriod(form.getWriterPeriod());
    	
    	logger.info("Starting Writer service...");
    	WriterTaskScheduler.schedulerWriterService();
    	
    	logger.info("Reader Period: " + form.getWriterPeriod());    	
    	ReaderTaskScheduler.setReaderPeriod(form.getReaderPeriod());
    	
    	logger.info("Starting Reader service...");
		ReaderTaskScheduler.schedulerReaderService();
		
        return "redirect:/#configuration";
    }
}
