package com.wyds2.wyds2.Repositories;

import com.wyds2.wyds2.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstName(String firstName);

    User findByLastName(String lastName);

    User findByEmail(String email);

    User findByConfirmationToken(String confirmToken);

}
