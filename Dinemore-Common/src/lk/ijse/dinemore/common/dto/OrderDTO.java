/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.common.dto;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class OrderDTO extends SuperDTO implements Serializable{

    private String orderId;
    private String customerName;
    private String tel;
    private String menuId;
    private String qty;
    private String time;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String customerName, String tel, String menuId, String qty, String time, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.tel = tel;
        this.menuId = menuId;
        this.qty = qty;
        this.time = time;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
