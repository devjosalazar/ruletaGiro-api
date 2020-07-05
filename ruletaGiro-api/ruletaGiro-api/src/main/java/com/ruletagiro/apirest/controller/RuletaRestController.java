package com.ruletagiro.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruletagiro.entities.Ruleta;
import com.ruletagiro.service.RuletaServiceImpl;

@RestController
@RequestMapping("/api")
public class RuletaRestController {

	@Autowired
	private RuletaServiceImpl ruletaService;
	
	
	@PostMapping(value = "/ruleta", consumes = "application/json", produces="application/json")
	public ResponseEntity<String [][]> realizarGiroRuleta(@RequestBody Ruleta ruleta) 
	{
		String [][] matrizInicial = null;
		String [][] newMatrix     = null;
		int giros, sizeFilas, sizeColumnas  = 0;
		
		matrizInicial = ruleta.getMatriz();
		
		giros  = ruleta.getGiros();
		sizeFilas = matrizInicial.length;
		sizeColumnas = matrizInicial[0].length;

		
		newMatrix  = ruletaService.girarRuleta(matrizInicial, giros, sizeFilas, sizeColumnas);
		return  new ResponseEntity<>(newMatrix,HttpStatus.CREATED);
	}
	
}
