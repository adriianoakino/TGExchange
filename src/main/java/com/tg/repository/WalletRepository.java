package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.dtos.WalletDto;

public interface WalletRepository extends JpaRepository<WalletDto, Long> {

}
