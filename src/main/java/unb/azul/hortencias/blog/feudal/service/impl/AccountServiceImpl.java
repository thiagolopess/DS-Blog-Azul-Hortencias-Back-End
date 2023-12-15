package unb.azul.hortencias.blog.feudal.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import unb.azul.hortencias.blog.feudal.dto.AccountDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;
import unb.azul.hortencias.blog.feudal.repository.AccountRepository;
import unb.azul.hortencias.blog.feudal.service.AccountService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity createAccount(AccountDTO account) {
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        return accountRepository.save(new AccountEntity(account));
    }

    @Override
    public AccountEntity getAccountById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public AccountEntity getAccountByEmail(String email) {
        return accountRepository.findByEmail(email).orElse(null);
    }

}
