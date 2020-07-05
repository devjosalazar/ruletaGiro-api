package com.ruletagiro.service;

import org.springframework.stereotype.Service;


@Service
public class RuletaServiceImpl implements RuletaService{

	public RuletaServiceImpl() {
		
	}
	
	
	@Override
	public String[][] girarRuleta(String[][] matriz, int n, int f, int c) {
		
		String[][] nuevaMatriz = new String[c][f];
		
		if(n == 0)
			return matriz; 
		else
		{
			for (int i = 0; i < matriz.length; i++) {
				
				for (int j = 0; j < matriz[i].length; j++){
					
					if(n > 0)
						nuevaMatriz[j][f -1 -i] = matriz [i][j]; //giro der
					else
						nuevaMatriz[c-j-1][i] = matriz [i][j];   //giro izq
				}
			}
			
			if(n > 0)
				n = n-1;
			else
				n = n+1;
			
		    return  girarRuleta(nuevaMatriz, n, nuevaMatriz.length, nuevaMatriz[0].length);
		}
	}
	
}
