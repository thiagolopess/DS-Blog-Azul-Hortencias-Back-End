package unb.azul.hortencias.blog.feudal.service;

import unb.azul.hortencias.blog.feudal.dto.AccountDTO;
import unb.azul.hortencias.blog.feudal.model.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAllAccounts();

    AccountEntity createAccount(AccountDTO account);

    AccountEntity getAccountById(Integer id);
}
