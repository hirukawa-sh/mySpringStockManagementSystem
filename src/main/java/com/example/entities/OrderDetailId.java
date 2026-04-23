import java.io.Serializable;
import lombok.*;

@Data
public class OrderDetailId implements Serializable {
 private Long orderId;
 private Long itemId;
}