package com.enviro.assessment.grad001.sicelozitha.service;

import com.enviro.assessment.grad001.sicelozitha.entity.Investor;
import com.enviro.assessment.grad001.sicelozitha.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorServiceImpl implements InvestorService{

    @Autowired
    private InvestorRepository investorRepository;

    @Override
    public Investor createInvestor(Investor investor) {
        return investorRepository.save(investor);
    }

    @Override
    public Investor getInvestor(long investorId) {
        return investorRepository.getReferenceById(investorId);
    }

    @Override
    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }
}
