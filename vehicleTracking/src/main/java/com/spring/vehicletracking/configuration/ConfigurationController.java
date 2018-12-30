package com.spring.vehicletracking.configuration;

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

import com.spring.vehicletracking.services.ReaderTaskScheduler;
import com.spring.vehicletracking.services.StorageService;
import com.spring.vehicletracking.services.WriterServiceScheduler;



@Controller
@RequestMapping("/configuration")
public class ConfigurationController {

	private static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);
	
	private final StorageService storageService;

    @Autowired
    public ConfigurationController(StorageService storageService) {
        this.storageService = storageService;
    }
    
    @RequestMapping(method=RequestMethod.GET)
	public ModelAndView configuration() {
		
		ConfigurationForm form = new ConfigurationForm(
				WriterServiceScheduler.getWriterPeriod(),
				ReaderTaskScheduler.getReaderPeriod());
		
		return new ModelAndView("configuration", "configurationForm", form);
	}
	
    @RequestMapping(params="upload", method=RequestMethod.POST)
    public String fileUploadHandler(@RequestParam(required=false, name="file") MultipartFile file) {
    	logger.info("Uploading file:" + file.getOriginalFilename());    	
    	storageService.uploadEventSource(file);
    	
        return "redirect:/#configuration";
    }
    
    /*@RequestMapping(params="writerPeriod", method=RequestMethod.POST)
    public String updateWriterPeriod(@ModelAttribute("configurationForm") ConfigurationForm form,
    		ModelAndView model) {
		
    	logger.info("Updating Writing Period...");    	
    	WriterServiceScheduler.setWriterPeriod(form.getWriterPeriod());
    	
        return "redirect:/#configuration";
    }
    
    @RequestMapping(params="readerPeriod", method=RequestMethod.POST)
    public String updateReaderPeriod(@ModelAttribute("configurationForm") ConfigurationForm form,
    		ModelAndView model) {
		
    	logger.info("Updating Reader Period...");    	
    	//ReaderTaskScheduler
    	
        return "redirect:/#configuration";
    }*/
    
    @RequestMapping(params="start", method=RequestMethod.POST)
    public String startServiceHandler(@ModelAttribute("configurationForm") ConfigurationForm form,
    		ModelAndView model) {
    	
    	logger.info("Writer Period: " + form.getWriterPeriod());    	
    	WriterServiceScheduler.setWriterPeriod(form.getWriterPeriod());
    	
    	logger.info("Starting Writer service...");
    	WriterServiceScheduler.schedulerWriterService();
    	
    	logger.info("Reader Period: " + form.getWriterPeriod());    	
    	ReaderTaskScheduler.setReaderPeriod(form.getReaderPeriod());
    	
    	logger.info("Starting Reader service...");
		ReaderTaskScheduler.schedulerReaderService();
		
        return "redirect:/#configuration";
    }
}
