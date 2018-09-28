package org.ggsl.ew_mainapp;

import org.ew_attendance.AttendanceRun;
import org.ew_compensation.CompensationRun;
import org.ew_ea.EaRun;
import org.ew_learning.LearningRun;
import org.ew_leave.LeaveRun;
import org.ew_ob.ObRun;
import org.ew_payroll.PayrollRun;
import org.ew_pms.PmsRun;
import org.ew_separation.SeparationRun;
import org.ew_setup.SetupRun;
import org.ew_timesheet.TimesheetRun;
import org.ew_travel.TravelRun;
import org.ggsl.ew_eip.EipRun;
import org.ggsl.ew_shared.SharedRun;
import org.ggsl.ew_utility.UtilityRun;
import org.ggsl.ew_utility.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */

@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication(scanBasePackages= {"org.ggsl.ew_eip","org.ggsl.ew_utility","org.ggsl.ew_mainapp","org.ggsl.ew_shared","org.ew_learning","org.ew_setup","org.ew_attendance","org.ew_leave","org.ew_ea","org.ew_pms","org.ew_separation","org.ew_compensation","org.ew_payroll","org.ew_timesheet"})
@EnableJpaRepositories(basePackages = {"org.ggsl.ew_eip","org.ggsl.ew_utility","org.ggsl.ew_mainapp","org.ggsl.ew_shared","org.ew_learning","org.ew_setup","org.ew_attendance","org.ew_leave","org.ew_ea","org.ew_pms","org.ew_separation","org.ew_compensation","org.ew_payroll","org.ew_timesheet"})
@EntityScan(basePackages = {"org.ggsl.ew_eip","org.ggsl.ew_utility","org.ggsl.ew_mainapp","org.ggsl.ew_shared","org.ew_eip","org.ew_learning","org.ew_setup","org.ew_attendance","org.ew_leave","org.ew_ea","org.ew_pms","org.ew_separation","org.ew_compensation","org.ew_payroll","org.ew_timesheet"})
public class App extends SpringBootServletInitializer {	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }	
	
	
    public static void main( String[] args ) {	
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
        
        		UtilityRun ur = new UtilityRun();
        		ur.printModuleName();
        		
        		PayrollRun pr = new PayrollRun();
        		pr.printModuleName();
        		
        		
        		EipRun er = new EipRun();
        		er.printModuleName();
        		
        		TimesheetRun tr =new TimesheetRun();
        		tr.printModuleName();
        		
        		CompensationRun cr= new CompensationRun();
        		cr.printModuleName();
        		
        		AttendanceRun ar = new AttendanceRun();
        		ar.printModuleName();
        		
        		SeparationRun sr = new SeparationRun();
        		sr.printModuleName();
        		
        		SetupRun str = new SetupRun();
        		str.printModuleName();
        		
        		SharedRun shr =new SharedRun();
        		shr.printModuleName();
        		
        		EaRun ear = new EaRun();
        		ear.printModuleName();
        		
        		TravelRun trv =new TravelRun();
        		trv.printModuleName();
        		
        		PmsRun pm =new PmsRun();
        		pm.printModuleName();
        		
        		LeaveRun lr =new LeaveRun();
        		lr.printModuleName();
        		
        		ObRun orn =new ObRun();
        		orn.printModuleName();
        		
        		LearningRun lrn =new LearningRun();
        		lrn.printModuleName();
    }
}
