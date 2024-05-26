package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTransactionRepository extends JpaRepository<PurchaseTransaction, UUID> {

}
