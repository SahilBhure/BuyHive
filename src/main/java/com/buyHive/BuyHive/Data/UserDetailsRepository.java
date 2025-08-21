package com.buyHive.BuyHive.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {

    UserDetails findByName(String name);

    UserDetails findByMail(String mail);

}
