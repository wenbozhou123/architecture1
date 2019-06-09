package com.bowen.architecture.architecture1.customerMgr.vo;

import com.bowen.architecture.architecture1.common.vo.BaseModel;

import java.util.Objects;

public class CustomerModel extends BaseModel{
    private Integer uuid;
    private String customerId;
    private String pwd;
    private String showName;
    private String trueName;
    private String registerTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerModel)) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(getUuid(), that.getUuid());
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "uuid=" + uuid +
                ", customerId='" + customerId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", showName='" + showName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUuid());
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}
