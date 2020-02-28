package com.qianfeng.pojo;

public class BusinessUserAndUsername {
    /*business_id,business_username,business_info_legal_person,
                    business_info_legal_person_tel,bussiness_info_name,business_pass_id*/
    private int business_id;
    private String business_username;
    private String business_info_legal_person;
    private String business_info_legal_person_tel;
    private String business_info_name;
    private  int business_pass_id;
    private  String business_pass_word;

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_username() {
        return business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }

    public String getBusiness_info_legal_person() {
        return business_info_legal_person;
    }

    public void setBusiness_info_legal_person(String business_info_legal_person) {
        this.business_info_legal_person = business_info_legal_person;
    }

    public String getBusiness_info_legal_person_tel() {
        return business_info_legal_person_tel;
    }

    public void setBusiness_info_legal_person_tel(String business_info_legal_person_tel) {
        this.business_info_legal_person_tel = business_info_legal_person_tel;
    }

    public String getBusiness_info_name() {
        return business_info_name;
    }

    public void setBusiness_info_name(String business_info_name) {
        this.business_info_name = business_info_name;
    }

    public int getBusiness_pass_id() {
        return business_pass_id;
    }

    public void setBusiness_pass_id(int business_pass_id) {
        this.business_pass_id = business_pass_id;
    }

    public String getBusiness_pass_word() {
        return business_pass_word;
    }

    public void setBusiness_pass_word(String business_pass_word) {
        this.business_pass_word = business_pass_word;
    }
}
