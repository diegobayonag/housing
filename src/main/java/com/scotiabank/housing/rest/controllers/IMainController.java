package com.scotiabank.housing.rest.controllers;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Main", protocols = "http, https")

public interface IMainController {

	
	@ApiOperation(value  = "Root entry point."
			  ,notes = "For verification purposes only. Provides a brief functional description of the component.")

	@ApiResponses(value = { @ApiResponse(code = 202, message = "Módulo de vivienda. Welcome and brief.") })

	public abstract ResponseEntity<?> index();

}