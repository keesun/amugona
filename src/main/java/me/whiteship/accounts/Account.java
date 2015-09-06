package me.whiteship.accounts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Keesun Baik
 */
@Entity
@Getter
@Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

    private String fullName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

}
