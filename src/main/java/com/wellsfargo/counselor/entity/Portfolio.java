package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

import java.security.Security;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id")
    final Client client;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    @Column
    private String createdAt;

    public Portfolio(Long portfolioId, Client client, List<Security> securities, String createdAt) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.securities = securities;
        this.createdAt = createdAt;
    }

    
    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}