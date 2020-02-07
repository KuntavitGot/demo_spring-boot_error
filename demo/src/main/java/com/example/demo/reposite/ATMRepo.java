package com.example.demo.reposite;

import com.example.demo.atmentity.ATM;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ATMRepo extends CrudRepository<ATM,Long> {

    @Query("SELECT atm FROM ATM atm where atm.user_pass =:user_pass and atm.user_name=:user_name")
    ATM findByUser_nameAndAndUser_pass(@Param("user_pass") String user_pass, @Param("user_name") String user_name);

    @Query("SELECT atm FROM ATM atm where atm.user_pass =:user_pass")
    ATM findByUser_pass(@Param("user_pass") String user_pass);

    @Query("SELECT atm FROM ATM atm where atm.user_name =:user_name")
    ATM findByUser_name(@Param("user_name") String user_name);
}
