package com.financy.FinancyAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financy.FinancyAPI.model.dto.FinanceDTO;
import com.financy.FinancyAPI.model.entity.Finance;
import com.financy.FinancyAPI.repository.FinanceRepository;
import com.financy.FinancyAPI.repository.UserRepository;

@Service
public class FinanceService {
    @Autowired
    FinanceRepository financeRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<FinanceDTO> getAllFinances(Long userId) {
        List<FinanceDTO> financeDTOs = new ArrayList<FinanceDTO>();
        List<Finance> finances = financeRepository.findByUserId(userId);
        for (Finance finance : finances) {
            financeDTOs.add(new FinanceDTO(finance.getId(), finance.getName(), finance.getDate(), finance.getExchange(),
                    finance.getComment(), finance.getIsIncome()));
        }
        return financeDTOs;
    }

    @Transactional(readOnly = true)
    public FinanceDTO getFinanceById(Long userId) {
        Finance finance = financeRepository.findById(userId).orElse(null);
        if (finance == null) {
            return null;
        }
        return new FinanceDTO(finance.getId(), finance.getName(), finance.getDate(), finance.getExchange(),
                finance.getComment(), finance.getIsIncome());
    }

    @Transactional
    public FinanceDTO createFinance(FinanceDTO financeDTO, Long userId) {
        Finance finance = new Finance(0l, financeDTO.getName(), financeDTO.getDate(), financeDTO.getExchange(),
                financeDTO.getComment(), financeDTO.getIsIncome(), userRepository.findById(userId).orElse(null));
        financeRepository.save(finance);
        return new FinanceDTO(finance.getId(), finance.getName(), finance.getDate(), finance.getExchange(),
                finance.getComment(), finance.getIsIncome());
    }

    @Transactional
    public FinanceDTO updateFinance(Long id, FinanceDTO financeDTO, Long userId) {
        Finance finance = financeRepository.findById(id).orElse(null);
        if (finance == null) {
            return null;
        }
        finance.setName(financeDTO.getName());
        finance.setDate(financeDTO.getDate());
        finance.setExchange(financeDTO.getExchange());
        finance.setComment(financeDTO.getComment());
        finance.setIsIncome(financeDTO.getIsIncome());
        finance.setUser(userRepository.findById(userId).orElse(null));
        financeRepository.save(finance);
        return new FinanceDTO(finance.getId(), finance.getName(), finance.getDate(), finance.getExchange(),
                finance.getComment(), finance.getIsIncome());
    }

    @Transactional
    public FinanceDTO deleteFinance(Long id) {
        Finance finance = financeRepository.findById(id).orElse(null);
        if (finance == null) {
            return null;
        }
        financeRepository.delete(finance);
        return new FinanceDTO(finance.getId(), finance.getName(), finance.getDate(), finance.getExchange(),
                finance.getComment(), finance.getIsIncome());
    }
}
