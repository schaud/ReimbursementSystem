package dev.chaudhry.daos;

import dev.chaudhry.entities.Manager;

public interface ManagerDAO {

    Manager readManager(Manager manager);

    Manager updateApproved(Manager manager, int amount);



}
