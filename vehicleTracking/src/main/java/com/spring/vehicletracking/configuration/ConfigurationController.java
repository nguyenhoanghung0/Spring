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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.vehicletracking.dao.TripRepository;
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
		
		ConfigurationForm form = new ConfigurationForm();
		
		return new ModelAndView("configuration", "configurationForm", form);
	}
	
    @RequestMapping(params="upload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam(required=false, name="file") MultipartFile file) {
		
    	storageService.uploadEventSource(file);
    	
        return "redirect:/#configuration";
    }
    
    @RequestMapping(params="start", method=RequestMethod.POST)
    public String handlePost(ModelAndView model) {
		
    	WriterServiceScheduler.schedulerWriterService();
		ReaderTaskScheduler.schedulerReaderService();
		
        return "redirect:/#configuration";
    }
}
