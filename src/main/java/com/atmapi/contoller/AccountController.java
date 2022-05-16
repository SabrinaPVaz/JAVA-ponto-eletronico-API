package com.atmapi.contoller;

import com.atmapi.DTO.AccountDTO;
import com.atmapi.entities.AccountEntity;
import com.atmapi.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Object> SaveAccount(@RequestBody @Valid AccountDTO accountDTO){
        var accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, accountEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountEntity));
    }

}
