package com.employee;

import com.employee.domain.EmployeeSkills;
import com.employee.domain.skills.Consulting;
import com.employee.domain.skills.Domain;
import com.employee.domain.skills.Technical;
import com.employee.domain.skills.Testing;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public static EmployeeSkills setDefaultSkills(Long employeeId) {
        EmployeeSkills employeeSkills = new EmployeeSkills();
        Domain domain = getDomainSkills();
        Consulting consulting = getConsultingSkills();
        Testing testing = getTestingSkills();
        Technical technical = getTechnicalSkills();

        employeeSkills.setEmployeeId(employeeId);
        employeeSkills.setDomain(domain);
        employeeSkills.setConsulting(consulting);
        employeeSkills.setTechnical(technical);
        employeeSkills.setTesting(testing);

        return employeeSkills;
    }

    private static Technical getTechnicalSkills() {
        Technical technical = new Technical();
        technical.setAWS(0);
        technical.setJava(0);
        return technical;
    }

    private static Testing getTestingSkills() {
        Testing testing = new Testing();
        testing.setCapybara(0);
        testing.setCucumber(0);
        testing.setFitness(0);
        return testing;
    }

    private static Consulting getConsultingSkills() {
        Consulting consulting = new Consulting();
        consulting.setCommunication(0);
        consulting.setQuestioning(0);
        consulting.setPlanning(0);
        return consulting;
    }

    private static Domain getDomainSkills() {
        Domain domain = new Domain();
        domain.setEducation(0);
        domain.setGovernment(0);
        return domain;
    }
}
