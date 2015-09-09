package me.whiteship.accounts;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Keesun Baik
 */
@Service
@Transactional
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) {
        Account account = modelMapper.map(dto, Account.class);
        // TODO 유효한 username인지 판단
        String username = dto.getUsername();
        if (repository.findByUsername(username) != null) {
            log.error("user duplicated exception. {}", username);
            throw new UserDuplicatedException(username);
        }

        // TODO password 해싱
        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);
        return repository.save(account);
    }
}
