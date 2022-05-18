package com.atmapi.service;

import com.atmapi.DTO.AccountDTO;
import com.atmapi.entities.AccountEntity;
import com.atmapi.exception.AtmException;
import com.atmapi.exception.InfoMessages;
import com.atmapi.repositories.AccountRepository;
import com.atmapi.requestDTO.AccountRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private final AccountRepository accountRepository;


    public AccountDTO saveAccount(AccountRequestDTO accountRequestDTO) throws AtmException {
        Optional<AccountEntity> optAccountEntity = accountRepository.findByNumber(accountRequestDTO.getNumber());
        if (optAccountEntity.isPresent()) {
            throw new AtmException(InfoMessages.ACCOUNT_ALREADY_EXISTS);
        }
        AccountEntity accountEntity = optAccountEntity.get();
        accountEntity.setName(accountRequestDTO.getName());
        accountEntity.setNumber(accountRequestDTO.getNumber());
        accountEntity.setBalance(accountRequestDTO.getBalance());
        accountRepository.save(accountEntity);

        return entityConverterDto(accountEntity);
    }

    public AccountDTO entityConverterDto(AccountEntity accountEntity) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setName(accountEntity.getName());
        accountDTO.setNumber(accountEntity.getNumber());
        accountDTO.setBalance(accountEntity.getBalance());
        return accountDTO;
    }

}


