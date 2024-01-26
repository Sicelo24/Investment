package com.enviro.assessment.grad001.sicelozitha.controller;

import com.enviro.assessment.grad001.sicelozitha.entity.Investor;
import com.enviro.assessment.grad001.sicelozitha.service.InvestorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    @Autowired
    private InvestorServiceImpl investorService;

    @PostMapping("/create")
    public String createInvestor(Model model){
        Investor investor = new Investor();
        model.addAttribute("Investor",investor);
        return "create_investor";
    }

    @PostMapping("/create")
    public void createInvestors() {
        Investor investor = new Investor();
        investorService.createInvestor(investor);
    }


}
