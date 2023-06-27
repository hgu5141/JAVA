package hello.core.oder;

public interface OrderService {
    Oder createOder(Long memberId, String itemName, int itemPrice);
}
