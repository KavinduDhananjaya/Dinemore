/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijise.dinemore.server.bussiness;

import lk.ijise.dinemore.server.bussiness.custom.impl.OrderBOImpl;

/**
 *
 * @author User
 */
public class BOFactory {

    public enum BOTypes {
        ORDER
    }

    private static BOFactory bOFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getBO(BOTypes bOTypes) {
        switch (bOTypes) {
            case ORDER:
                return new OrderBOImpl();
            default:
                return null;
        }
    }
}
