package com.infy.stock.web.rest;

import com.infy.stock.web.rest.vm.LoggerVM;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/management")
public class LogsResource {
   LogsResource obj = new LogsResource();
    @GetMapping("/logs")
    public List<LoggerVM> getList() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        return context.getLoggerList()
            .stream()
            .map(LoggerVM::new)
            .collect(Collectors.toList());
    }

    @PutMapping("/logs")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeLevel(@RequestBody LoggerVM jsonLogger) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.getLogger(jsonLogger.getName()).setLevel(Level.valueOf(jsonLogger.getLevel()));
    }
    @GetMapping("/log")
    public String getl() {
        /*LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        return context.getLoggerList()
            .stream()
            .map(LoggerVM::new)
            .collect(Collectors.toList());
        try {
			obj.divide();
		} catch (ArithmeticException ex) {
			ex.printStackTrace();
			
		}*/
        try {
        	obj.divide();
		} catch (ArithmeticException ex) {
			ex.printStackTrace();
			
		}
		return "Microsevice Up and Running";
    }
   /* private void divide() {
		// TODO Auto-generated method stub
		System.out.println("logging is working");
		int i = 10 / 0;
		
	}*/
    
}
