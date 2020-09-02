package org.demon.domain;

import java.io.Serializable;
import java.util.Date;

public class Child implements Serializable {

    private String childName;
    private Integer childAge;
    private Date birthday;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Integer getChildAge() {
        return childAge;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childName='" + childName + '\'' +
                ", childAge=" + childAge +
                ", birthday=" + birthday +
                '}';
    }
}
