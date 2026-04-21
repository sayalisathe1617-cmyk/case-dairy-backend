package com.casedairy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nhai_case")
public class NHAICase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int clientId;
    private String clientName;

    private String caseNo;
    private int year;

    private String applicant;
    private String respondent;

    private String gatNo;
    private double area;

    private String awardNo;
    private String awardDate;

    private boolean structure;
    private String structureDetails;

    @Column(columnDefinition = "TEXT")
    private String otherClaim;

    private double claimRs;
    private double rate;
    private double amount;

    private String advocate;

    // 🔹 GETTERS & SETTERS


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public String getGatNo() {
        return gatNo;
    }

    public void setGatNo(String gatNo) {
        this.gatNo = gatNo;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getAwardNo() {
        return awardNo;
    }

    public void setAwardNo(String awardNo) {
        this.awardNo = awardNo;
    }

    public String getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(String awardDate) {
        this.awardDate = awardDate;
    }

    public boolean isStructure() {
        return structure;
    }

    public void setStructure(boolean structure) {
        this.structure = structure;
    }

    public String getStructureDetails() {
        return structureDetails;
    }

    public void setStructureDetails(String structureDetails) {
        this.structureDetails = structureDetails;
    }

    public String getOtherClaim() {
        return otherClaim;
    }

    public void setOtherClaim(String otherClaim) {
        this.otherClaim = otherClaim;
    }

    public double getClaimRs() {
        return claimRs;
    }

    public void setClaimRs(double claimRs) {
        this.claimRs = claimRs;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAdvocate() {
        return advocate;
    }

    public void setAdvocate(String advocate) {
        this.advocate = advocate;
    }
}