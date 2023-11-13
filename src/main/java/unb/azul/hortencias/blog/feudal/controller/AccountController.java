package unb.azul.hortencias.blog.feudal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAllAccounts() {

        List<AccountEntity> accounts = accountService.getAllAccounts();
        HttpStatus status = accounts.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(accountService.getAllAccounts(), status);
    }
}
