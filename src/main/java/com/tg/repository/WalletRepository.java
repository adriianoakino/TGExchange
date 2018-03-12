package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.entities.Wallets;

@Repository
public interface WalletRepository extends JpaRepository<Wallets, Long> {

}
