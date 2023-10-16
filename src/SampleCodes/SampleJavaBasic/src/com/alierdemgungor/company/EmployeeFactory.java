package com.alierdemgungor.company;

import com.bengisuuzunyenigun.company.Manager;
import com.bengisuuzunyenigun.company.SalesManager;
import com.dilekozdil.app.employee.ProjectWorker;
import com.dilekozdil.app.employee.Worker;
import com.yusuflale.company.Employee;

import java.util.Random;

public class EmployeeFactory {
    private final Random m_random = new Random();
    private Worker getWorker()
    {
        Worker worker = new Worker();

        worker.setName("Ali");
        worker.setCitizenId("12345678912");
        worker.setAddress("Mecidiyeköy");
        worker.setFeePerHour(250);
        worker.setHourPerDay(8);

        return worker;
    }

    private Manager getManager()
    {
        Manager manager = new Manager();

        manager.setName("Veli");
        manager.setCitizenId("12345678234");
        manager.setAddress("Şişli");
        manager.setDepartment("Pazarlama");
        manager.setSalary(50000);

        return manager;
    }

    private SalesManager getSalesManager()
    {
        SalesManager manager = new SalesManager();

        manager.setName("Selami");
        manager.setCitizenId("12345678238");
        manager.setAddress("Riva");
        manager.setDepartment("Pazarlama");
        manager.setSalary(50000);
        manager.setExtra(20000);

        return manager;
    }

    private ProjectWorker getProjectWorker()
    {
        ProjectWorker worker = new ProjectWorker();

        worker.setName("Ayşe");
        worker.setCitizenId("12345678910");
        worker.setAddress("Levent");
        worker.setFeePerHour(250);
        worker.setHourPerDay(8);
        worker.setProjectName("Runner Game Project");
        worker.setExtraFee(10000);

        return worker;
    }

    public Employee getRandomEmployee()
    {
        return switch (m_random.nextInt(4)) {
            case 0 -> getManager();
            case 1 -> getSalesManager();
            case 2 -> getWorker();
            default -> getProjectWorker();
        };
    }
}
