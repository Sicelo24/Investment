package com.enviro.assessment.grad001.sicelozitha.service;

import com.enviro.assessment.grad001.sicelozitha.entity.Investor;

import java.util.List;

public interface InvestorService {
    Investor createInvestor(Investor investor);
    Investor getInvestor(long investorId);
    List<Investor>getAllInvestors();
}
