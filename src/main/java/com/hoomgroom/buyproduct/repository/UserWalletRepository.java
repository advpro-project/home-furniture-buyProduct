package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWalletRepository extends JpaRepository<UserWallet, String> {
}
