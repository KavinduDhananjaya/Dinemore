/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.srver.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijise.dinemore.server.bussiness.BOFactory;
import lk.ijise.dinemore.server.bussiness.custom.OrderBO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.common.observer.Observer;
import lk.ijse.dinemore.common.observer.Subject;
import lk.ijse.dinemore.common.service.custom.OrderService;
import lk.ijse.dinemore.server.repository.custom.impl.OrderRepositoryImpl;
import lk.ijse.dinemore.server.reservation.impl.ReservationImpl;

/**
 *
 * @author User
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService,Subject{

    
    private OrderBO orderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<OrderService> cusResBook = new ReservationImpl<>();

    public OrderServiceImpl() throws Exception{
        orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    }
    
    
    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        boolean addOrder = orderBO.addOrder(orderDTO);
        notifyObservers();
        return addOrder;
    }

    @Override
    public boolean deleteOrder(String cid) throws Exception {
        boolean deleteOrder = orderBO.deleteOrder(cid);
        notifyObservers();
        return deleteOrder;
    }

    @Override
    public OrderDTO searchOrder(String cid) throws Exception {
       return orderBO.searchOrder(cid);
    }

    @Override
    public boolean updateOrder(OrderDTO orderDTO) throws Exception {
         boolean updateOrder = orderBO.updateOrder(orderDTO);
        notifyObservers();
        return updateOrder;
    }

    @Override
    public List<OrderDTO> getAllOrder() throws Exception {
         return orderBO.getAllOrder();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this);
    }

    @Override
    public boolean release(Object id) throws Exception {
       return cusResBook.relese(id);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
         alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
       alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
       new Thread(()->{
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(OrderRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    
}
