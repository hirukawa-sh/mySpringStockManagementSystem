import java.io.Serializable;
import lombok.*;

@Data
public class SalesDetailId implements Serializable {
 private Long salesId;
 private Long itemId;
}