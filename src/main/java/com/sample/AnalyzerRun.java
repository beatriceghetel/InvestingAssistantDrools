package com.sample;


import java.io.FileNotFoundException;
import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.classifications.Cariera;
import com.sample.classifications.Venit;
import com.sample.entities.Investitor;
import com.sample.entities.Plasament;
import com.sample.entities.Recomandare;
import com.sample.notifier.MailNotifier;
import com.sample.util.DisplayUtil;

public class AnalyzerRun {

    public static void main(String[] args) throws FileNotFoundException {
    	
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("ksession-rules");

		// -- PLASAMENTE --
		
        Plasament plasamentRiscMinim1 = new Plasament("ING - Depozit de economii", "depozit la vedere", 0.007);
        kieSession.insert(plasamentRiscMinim1);
        
        Plasament plasamentRiscScazut1 = new Plasament("ING - Depozit de economii la termen", "depozit la termen",0.02);
        kieSession.insert(plasamentRiscScazut1);
        
        Plasament plasamentRiscMediu1 = new Plasament("Investitii Imobiliare", "imobiliare", 0.2);
        kieSession.insert(plasamentRiscScazut1);
        
        Plasament plasamentRiscRidicat1 = new Plasament("Tranzactionare", "tranzactionare", 0.35);
        kieSession.insert(plasamentRiscScazut1);

        // -- INVESTITORI --
        
        Investitor investitor1 = new Investitor("beatrice.ghetel27@gmail.com", Cariera.INCEPUT, Venit.FIX, 20_000.0, 2_000.0, 4_000.0, false);
        kieSession.insert(investitor1);
        
        Investitor investitor2 = new Investitor("beatrice.ghetel27@gmail.com", Cariera.INCEPUT, Venit.FIX, 20_000.0, 2_000.0, 4_000.0, true);
        kieSession.insert(investitor2);

        Recomandare recomandare0 = new Recomandare(new Date(2020, 3, 1), investitor1);      // CAZ SPECIAL : LUNA MARTIE, business case special
        kieSession.insert(recomandare0);
        
        Recomandare recomandare1 = new Recomandare(new Date(), investitor1);        
        kieSession.insert(recomandare1);
        
        Recomandare recomandare2 = new Recomandare(new Date(), investitor2);        
        kieSession.insert(recomandare2);
        
        Investitor investitor3 = new Investitor("beatrice.ghetel27@gmail.com", Cariera.INCEPUT, Venit.FIX, 100_000.0, 2_000.0, 4_000.0, false);
        kieSession.insert(investitor3);
        
        Investitor investitor4 = new Investitor("beatrice.ghetel27@gmail.com", Cariera.INCEPUT, Venit.FIX, 100_000.0, 2_000.0, 4_000.0, true);
        kieSession.insert(investitor4);

        Recomandare recomandare3 = new Recomandare(new Date(), investitor3);        
        kieSession.insert(recomandare3);
        
        Recomandare recomandare4 = new Recomandare(new Date(), investitor4);        
        kieSession.insert(recomandare4);
        
        // -- DECLANSARE REGULI --
        
        kieSession.fireAllRules();
        
        
        // -- AFISARE RECOMANDARI & TRIMITERE MAILURI--
       
        System.out.println(DisplayUtil.formatAfisareRecomandari(recomandare0));
//      MailNotifier.sendMail(investitor1, DisplayUtil.formatAfisareRecomandari(recomandare1));
        
        System.out.println(DisplayUtil.formatAfisareRecomandari(recomandare1));
//        MailNotifier.sendMail(investitor1, DisplayUtil.formatAfisareRecomandari(recomandare1));
        
        System.out.println(DisplayUtil.formatAfisareRecomandari(recomandare2));
//      MailNotifier.sendMail(investitor1, DisplayUtil.formatAfisareRecomandari(recomandare2));
        
        System.out.println(DisplayUtil.formatAfisareRecomandari(recomandare3));
//      MailNotifier.sendMail(investitor1, DisplayUtil.formatAfisareRecomandari(recomandare3));
      
        System.out.println(DisplayUtil.formatAfisareRecomandari(recomandare4));
//    	MailNotifier.sendMail(investitor1, DisplayUtil.formatAfisareRecomandari(recomandare4));


    }
    
}
