package com.Ecoins.EWaste.Repository;

import com.Ecoins.EWaste.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserDetails,Integer> {

}