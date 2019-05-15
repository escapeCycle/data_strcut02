package tian;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author tianhuan
 * @date 2019-04-24 12:31
 **/
@Data
public class AccountChange {



    private Long id;
    private Long cusId;
    private String businessType;
    private BigDecimal amount;

    /**
     * 当前账户累加和
     */
    private BigDecimal curAccAmt;

    public AccountChange(Long id, Long cusId, String businessType, BigDecimal amount) {
        this.id = id;
        this.cusId = cusId;
        this.businessType = businessType;
        this.amount = amount;
    }
}
