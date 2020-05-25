package com.scotiabank.housing.rest.controllers;

import java.util.AbstractMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
* <h1>Root Entry Point</h1>
* Expose the up status and the module root entry point
*
* @author  Diego Bayona Gómez
* @version 1.0
* @since   2020-05-23
*/

@RestController
@RequestMapping("/")
public class MainController implements IMainController {

	@Autowired
	private Environment env; 
	
	/**
    * This method expose the main route for the module.
    * @return Brief status description.
    */
	
	@Override	
	@GetMapping
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> index() {
		
		return new ResponseEntity<AbstractMap.SimpleEntry<String, String>>
				(new AbstractMap.SimpleEntry<String, String>("housingModule", 
						"Housing transactions module is UP on port:"+env.getProperty("local.server.port")), HttpStatus.OK); 
		
	}
	
}
