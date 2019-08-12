/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijise.dinemore.server.bussiness.custom;

import java.util.List;
import lk.ijise.dinemore.server.bussiness.SuperBO;
import lk.ijse.dinemore.common.dto.OrderDTO;
import lk.ijse.dinemore.server.entity.Orders;

/**
 *
 * @author User
 */
public interface OrderBO extends SuperBO {

    public boolean addOrder(OrderDTO orderDTO) throws Exception;

    public boolean deleteOrder(String cid) throws Exception;

    public OrderDTO searchOrder(String cid) throws Exception;

    public boolean updateOrder(OrderDTO orderDTO) throws Exception;

    public List<OrderDTO> getAllOrder() throws Exception;

}
