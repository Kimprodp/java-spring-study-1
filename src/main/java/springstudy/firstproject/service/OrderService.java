package springstudy.firstproject.service;

import springstudy.firstproject.domain.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
