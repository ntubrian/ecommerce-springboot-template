package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "business_users")
@Data
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false, unique = true)
     private String username;

     @Column(nullable = false, unique = true)
     private String email;

     @Column(nullable = false)
     private String role;

     @Column(nullable = false)
     private String password;


    
}
