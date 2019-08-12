/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.client.controller;

import java.util.List;
import lk.ijse.dinemore.client.proxy.ProxyHandler;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.service.ServiceFactory;
import lk.ijse.dinemore.common.service.custom.OrderService;

/**
 *
 * @author User
 */
public class ChefController {
 
    
      public static boolean updateOrder(OrderDTO cdto) throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDER);
        return customerService.updateOrder(cdto);
    }
     
        
    public static boolean reserveCustomer(String customerID) throws Exception{
        
        OrderService  customerService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return  customerService.reserve(customerID);
        
    }
    
    public static boolean releaseCustomer(String customerID) throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return customerService.release(customerID);
    }
}
