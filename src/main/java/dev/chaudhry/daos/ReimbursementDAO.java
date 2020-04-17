package dev.chaudhry.daos;

import dev.chaudhry.entities.Reimbursement;

import java.util.ArrayList;

public interface ReimbursementDAO {

    Reimbursement createRequest(Reimbursement reimbursement);

    ArrayList<Reimbursement> viewReimbursements ();

}
