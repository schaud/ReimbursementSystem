package dev.chaudhry.services;

import dev.chaudhry.entities.Reimbursement;

public interface ReimbursementService {

    public Reimbursement submitReimbursement(Reimbursement reimbursement);

    public Reimbursement approveReimbursement(Reimbursement reimbursement);

    public Reimbursement approveReimbursement(Reimbursement reimbursement, boolean isApproved);

    public Reimbursement denyReimbursement(Reimbursement reimbursement);

}
