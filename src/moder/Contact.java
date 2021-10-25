package moder;

import java.io.Serializable;

public class Contact implements Serializable {
    private String phoneNum;
    private String group;
    private String fullName;
    private String sex;
    private String add;
    private String birthDay;
    private String email;

    public Contact() {
    }

    public Contact(String phoneNum, String group, String fullName, String sex, String add, String birthDay, String email) {
        this.phoneNum = phoneNum;
        this.group = group;
        this.fullName = fullName;
        this.sex = sex;
        this.add = add;
        this.birthDay = birthDay;
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNum='" + phoneNum + '\'' +
                ", group='" + group + '\'' +
                ", fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", add='" + add + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
