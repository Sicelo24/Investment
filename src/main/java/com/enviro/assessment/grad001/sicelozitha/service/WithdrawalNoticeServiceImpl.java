package com.enviro.assessment.grad001.sicelozitha.service;

import com.enviro.assessment.grad001.sicelozitha.entity.Investor;
import com.enviro.assessment.grad001.sicelozitha.entity.Product;
import com.enviro.assessment.grad001.sicelozitha.entity.Type;
import com.enviro.assessment.grad001.sicelozitha.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.sicelozitha.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService{

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    @Override
    public WithdrawalNotice createWithdrawalNotice(WithdrawalNotice withdrawalNotice) {
        double withdrawalAmount = withdrawalNotice.getWithdrawalAmount();
        Product product = withdrawalNotice.getProduct();
        double maxWithdrawal = product.getCurrentBalance()*0.9;
        Investor investor = withdrawalNotice.getInvestor();

        try{
            if (withdrawalAmount > maxWithdrawal){
                throw new IllegalArgumentException("Amount to be withdrew is over the limit allowed");
            }
            if (withdrawalAmount > product.getCurrentBalance()){
                throw new IllegalArgumentException("Amount exceeds current amount");
            }
            if (product.getType()== Type.RETIREMENT){
                if (investor.age()<=65){
                    throw new IllegalArgumentException("Age needs to be higher than 65");
                }
            }
            return withdrawalNoticeRepository.save(withdrawalNotice);
        }
        catch (Exception e){
            throw new RuntimeException("Withdrawal notice failed"+ e.getMessage());
        }
    }
}
