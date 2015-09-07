package me.whiteship.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Keesun Baik
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
