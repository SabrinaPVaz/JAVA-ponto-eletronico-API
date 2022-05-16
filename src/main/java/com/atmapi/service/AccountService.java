package com.atmapi.service;

import com.atmapi.entities.AccountEntity;
import com.atmapi.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public AccountEntity save(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    public boolean existsByNumber(Integer number) {
        return accountRepository.existsByNumber(number);
    }

    public List<AccountEntity> findAll() {
        return accountRepository.findAll();
    }

    public Optional<AccountEntity> findById(Long id) {
        return accountRepository.findById(id);
    }
}
