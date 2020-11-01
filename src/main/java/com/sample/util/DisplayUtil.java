package com.sample.util;

import com.sample.entities.PlasamentRecomandat;
import com.sample.entities.Recomandare;

public class DisplayUtil {
	
    /**
     * Metoda pentru afisarea in format mai citibil a recomandarilor facute pe baza regulilor stabilite
     * @param recomandare - recomandarea pentru care se face afisare
     * @return - un String formatat
     */
    public static String formatAfisareRecomandari(Recomandare recomandare) {
    	
    	String afisare = "";
    	
    	afisare += String.format("\r\n <> Pentru %s \n am recomandat urmatoarele plasamente:", recomandare.getInvestitor().toString());
    	
    	for (PlasamentRecomandat pr : recomandare.getPlasamente()) {
        	afisare += "\r\n\t\t" + pr.getPlasament().getNume() + " ; " 
        		+ pr.getPlasament().getTip() + " ; " 
        		+ (pr.getProcent() * 100) + "% ; " 
        		+ (pr.getPlasament().getProfitMediu() * 100) + "%";
        }
        afisare += String.format("\r\n\t <> Profit calculat: %f \n", recomandare.getProfitPeRecomandare());
        
        return afisare;
    }

}
