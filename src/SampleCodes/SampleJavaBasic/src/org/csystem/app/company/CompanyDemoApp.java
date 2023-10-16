package org.csystem.app.company;

import com.alierdemgungor.company.EmployeeFactory;
import com.huseyinemrealtun.app.company.HumanResources;
import com.yusuflale.company.Employee;
import org.csystem.util.thread.ThreadUtil;

public class CompanyDemoApp {
    private static void run()
    {
        HumanResources humanResources = new HumanResources();
        EmployeeFactory factory = new EmployeeFactory();

        for (;;) {
            Employee employee = factory.getRandomEmployee();

            humanResources.payInsurance(employee);
            ThreadUtil.sleep(3000);
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
