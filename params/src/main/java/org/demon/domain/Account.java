package org.demon.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private String accountName;
    private Integer accountId;
    private Double balance;
    private User user;

    private List<Child> list;
    private Map<String, Child> map;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Child> getList() {
        return list;
    }

    public void setList(List<Child> list) {
        this.list = list;
    }

    public Map<String, Child> getMap() {
        return map;
    }

    public void setMap(Map<String, Child> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountId=" + accountId +
                ", balance=" + balance +
                ", user=" + user +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
