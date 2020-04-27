package dev.chaudhry.daotests;
import dev.chaudhry.daos.ManagerDAO;
import dev.chaudhry.daos.ManagerDAOMaria;
import dev.chaudhry.entities.Manager;
import org.junit.Test;

public class ManagerDAOMariaTest {

    public static ManagerDAO managerdao = new ManagerDAOMaria();

    @Test
    public void readManger(){
        Manager manager = new Manager();
        manager.setManagerID("manager1");
        manager.setPassword("QWERTY1@");
        System.out.println(managerdao.readManager(manager));

    }

    @Test
    public void updateApproved(){
        Manager manager = new Manager();
        manager.setManagerID("manager1");
        manager.setPassword("QWERTY1@");
        managerdao.readManager(manager);
        int amount = 200;
        managerdao.updateApproved(manager, amount);
        System.out.println(managerdao.readManager(manager));
    }

}
