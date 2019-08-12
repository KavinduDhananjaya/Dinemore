/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.server.reservation.impl;

import java.util.HashMap;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import lk.ijse.dinemore.common.service.SuperService;

/**
 *
 * @author User
 */

public class ReservationImpl <T extends SuperService> {
    
    private Map<Object,T> resBook=new HashMap<>();
    
    public boolean reserve(Object key,T service){
        if (resBook.containsKey(key)) {
            if (resBook.get(key) == service) {
                return true;
            } else {
                return false;
            }
        } else {
            resBook.put(key, service);
            return true;
        }
    }
    
    public boolean relese(Object key){
        if (resBook.containsKey(key)) {
            resBook.remove(key);
            return true;
        } else {
            return false;
        }
    }
}
