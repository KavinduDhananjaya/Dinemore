/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijise.dinemore.server.bussiness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijise.dinemore.server.bussiness.custom.OrderBO;
import lk.ijise.dinemore.server.repository.RepositoryFactory;
import lk.ijise.dinemore.server.repository.custom.OrderRepository;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.server.entity.Orders;
import lk.ijse.dinemore.server.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class OrderBOImpl implements OrderBO {

    private OrderRepository orderRepository;

    public OrderBOImpl() {
        orderRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDER);
    }

    @Override
    public boolean addOrder(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = new Orders(
                    orderDTO.getOrderId(),
                    orderDTO.getCustomerName(),
                    orderDTO.getTel(),
                    orderDTO.getMenuId(),
                    orderDTO.getQty(),
                    orderDTO.getTime(),
                    orderDTO.getStatus()
            );
            boolean result = orderRepository.save(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteOrder(String cid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = orderRepository.findByID(cid);
            boolean result = false;
            if (order != null) {
                result = orderRepository.delete(order);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public OrderDTO searchOrder(String cid) throws Exception {
        Orders order = orderRepository.findByID(cid);
        return new OrderDTO(
                order.getOrderId(),
                order.getCustomerName(),
                order.getTel(),
                order.getMenuId(),
                order.getQty(),
                order.getTime(),
                order.getStatus());
    }

    @Override
    public boolean updateOrder(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = new Orders(
                    orderDTO.getOrderId(),
                    orderDTO.getCustomerName(),
                    orderDTO.getTel(),
                    orderDTO.getMenuId(),
                    orderDTO.getQty(),
                    orderDTO.getTime(),
                    orderDTO.getStatus()
            );
            boolean result = orderRepository.update(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            List<Orders> ordrs = orderRepository.findAll();
            session.getTransaction().commit();
            if (ordrs != null) {
                System.out.println("Not Null");
                List<OrderDTO> allOrders = new ArrayList<>();
                for (Orders order : ordrs) {
                    OrderDTO customerDTO = new OrderDTO(
                            order.getOrderId(),
                            order.getCustomerName(),
                            order.getTel(),
                            order.getMenuId(),
                            order.getQty(),
                            order.getTime(),
                            order.getStatus()
                    );

                    System.out.println("Hello :" + order.getOrderId());
                    allOrders.add(customerDTO);
                }
                return allOrders;
            } else {
                return null;
            }
        }
    }


}
