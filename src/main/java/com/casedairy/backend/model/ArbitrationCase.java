package com.casedairy.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "arbitration_case")
public class ArbitrationCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clientId;
    private String clientName;
    private String location;

    private String village;
    private String district;
    private String taluka;

    private String nhCode;
    private String projectName;
    private String projectPackage;

    private String caseNo;
    private Integer year;

    private String applicant;
    private String respondent;

    private Boolean hasStructure;
    private String structureDetails;

    private Boolean hasTrees;
    private String treeDetails;

    private String otherClaim;

    private Double claimRs;
    private Double rate;
    private Double amount;

    private String respAdv;
    private String appAdv;

    // 🔥 getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getNhCode() {
        return nhCode;
    }

    public void setNhCode(String nhCode) {
        this.nhCode = nhCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPackage() {
        return projectPackage;
    }

    public void setProjectPackage(String projectPackage) {
        this.projectPackage = projectPackage;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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

    public Boolean getHasStructure() {
        return hasStructure;
    }

    public void setHasStructure(Boolean hasStructure) {
        this.hasStructure = hasStructure;
    }

    public String getStructureDetails() {
        return structureDetails;
    }

    public void setStructureDetails(String structureDetails) {
        this.structureDetails = structureDetails;
    }

    public Boolean getHasTrees() {
        return hasTrees;
    }

    public void setHasTrees(Boolean hasTrees) {
        this.hasTrees = hasTrees;
    }

    public String getTreeDetails() {
        return treeDetails;
    }

    public void setTreeDetails(String treeDetails) {
        this.treeDetails = treeDetails;
    }

    public String getOtherClaim() {
        return otherClaim;
    }

    public void setOtherClaim(String otherClaim) {
        this.otherClaim = otherClaim;
    }

    public Double getClaimRs() {
        return claimRs;
    }

    public void setClaimRs(Double claimRs) {
        this.claimRs = claimRs;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRespAdv() {
        return respAdv;
    }

    public void setRespAdv(String respAdv) {
        this.respAdv = respAdv;
    }

    public String getAppAdv() {
        return appAdv;
    }

    public void setAppAdv(String appAdv) {
        this.appAdv = appAdv;
    }
}