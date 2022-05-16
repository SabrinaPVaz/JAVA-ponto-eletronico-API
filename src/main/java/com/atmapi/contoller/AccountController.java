package com.atmapi.contoller;

import com.atmapi.DTO.AccountDTO;
import com.atmapi.entities.AccountEntity;
import com.atmapi.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Object> SaveAccount(@RequestBody @Valid AccountDTO accountDTO){
        if(accountService.existsByNumber(accountDTO.getNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Account Number Already Exists");
        }

        var accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDTO, accountEntity);
        accountEntity.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountEntity));
    }

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable (value = "id") Long id){
        Optional<AccountEntity> accountEntity = accountService.findById(id);
        if(!accountEntity.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountEntity.get());
    }

}
