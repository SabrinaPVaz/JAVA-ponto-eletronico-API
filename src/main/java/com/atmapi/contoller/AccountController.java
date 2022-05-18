package com.atmapi.contoller;

import com.atmapi.DTO.AccountDTO;
import com.atmapi.exception.AtmException;
import com.atmapi.requestDTO.AccountRequestDTO;
import com.atmapi.service.AccountService;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/account")
@Controller
public class AccountController {

    private final AccountService accountService;



    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @CrossOrigin
    @PostMapping("")
    public AccountDTO saveAccount(
            @RequestBody @ApiParam(required = true, value = "DTO Request") AccountRequestDTO request) throws AtmException {
        return accountService.saveAccount(request);
    }
    
}
