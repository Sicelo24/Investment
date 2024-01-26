package com.enviro.assessment.grad001.sicelozitha.controller;

import com.enviro.assessment.grad001.sicelozitha.entity.WithdrawalNotice;
import com.enviro.assessment.grad001.sicelozitha.service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WithdrawalNotice")
public class WithdrawalNoticeController {
        private final WithdrawalNoticeService withdrawalNoticeService;
        @Autowired
        public WithdrawalNoticeController(WithdrawalNoticeService withdrawalNoticeService) {
            this.withdrawalNoticeService = withdrawalNoticeService;
        }

        //Create a new withdrawal notice
        @PostMapping
        public ResponseEntity<String> createWithdrawalNotice(@RequestBody WithdrawalNotice withdrawalNotice ) {
            try{
                WithdrawalNotice createNotice = withdrawalNoticeService.createWithdrawalNotice(withdrawalNotice);
                return ResponseEntity.status(HttpStatus.CREATED).body("Withdrawal notice created successfully");
            }catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create withdrawal notice: " + e.getMessage());
            }
        }
}
