package unb.azul.hortencias.blog.feudal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import unb.azul.hortencias.blog.feudal.dto.AccountDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AccountEntity>> getAllAccounts(@ApiIgnore Authentication authentication) {
        if (!authentication.isAuthenticated()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<AccountEntity> accounts = accountService.getAllAccounts();

        HttpStatus status = accounts.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK;
        return new ResponseEntity<>(accounts, status);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma conta pelo ID", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<AccountEntity> getAccountById(@PathVariable Integer id) {
        AccountEntity account = accountService.getAccountById(id);

        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @PostMapping("/signup")
    public ResponseEntity<AccountEntity> createAccount(@RequestBody AccountDTO account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

}
