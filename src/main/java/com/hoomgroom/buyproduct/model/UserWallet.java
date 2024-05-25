package com.hoomgroom.buyproduct.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "wallet")
public class UserWallet {
    @Id
    private String email;
    private double wallet;

    public UserWallet() {
        // Default constructor
    }

    public UserWallet(String email, double wallet) {
        this.email = email;
        this.wallet = wallet;
    }
}

