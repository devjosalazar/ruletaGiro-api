package com.ruletagiro.service;

import org.springframework.stereotype.Service;


@Service
public class RuletaServiceImpl implements RuletaService{

	public RuletaServiceImpl() {
		
	}
	
	
	@Override
	public String[][] girarRuleta(String[][] matriz, int giros, int sizeFilas, int sizeColumnas) {
		
		String[][] nuevaMatriz = new String[sizeColumnas][sizeFilas];
		
		if(giros == 0)
			return matriz; 
		else
		{
			for (int i = 0; i < matriz.length; i++) {
				
				for (int j = 0; j < matriz[i].length; j++){
					
					if(giros > 0)
						nuevaMatriz[j][sizeFilas -1 -i] = matriz [i][j]; //giro der- en sentido de las manecillas del reloj.
					else
						nuevaMatriz[sizeColumnas-j-1][i] = matriz [i][j];   //giro izq - en sentido contrario a las manecillas del reloj.
				}
			}
			
			if(giros > 0)
				giros = giros-1;
			else
				giros = giros+1;
			
		    return  girarRuleta(nuevaMatriz, giros, nuevaMatriz.length, nuevaMatriz[0].length);
		}
	}
	
}
