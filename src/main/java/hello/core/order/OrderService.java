package hello.core.order;

/**
 * hello.core.order
 * OrderService
 *
 * @author : K
 */
public interface OrderService {
  Order createOrder(Long memberId, String itemName, int itemPrice);
}
