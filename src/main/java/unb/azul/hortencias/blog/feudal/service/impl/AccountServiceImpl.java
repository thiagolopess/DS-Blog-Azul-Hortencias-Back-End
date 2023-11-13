package unb.azul.hortencias.blog.feudal.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}
