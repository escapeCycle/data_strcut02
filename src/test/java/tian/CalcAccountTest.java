package tian;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author tianhuan
 * @date 2019-04-24 12:34
 **/
public class CalcAccountTest {

    public List<AccountChange> calcAccAmt(List<AccountChange> list) {

        BigDecimal one = list.get(0).getAmount();
        BigDecimal two = one.add(list.get(1).getAmount());
        BigDecimal three = two.add(list.get(2).getAmount());
        list.get(0).setCurAccAmt(one);
        list.get(1).setCurAccAmt(two);
        list.get(2).setCurAccAmt(three);

        for(int i = 3;i<list.size();i++){
            if(list.get(i).getBusinessType().equals("7089")){
                list.get(i).setCurAccAmt(list.get(i-1).getCurAccAmt().add(list.get(i).getAmount()));
            }
        }
        return list;
    }


    public static void main(String[] args) {
//        new AccountChange(1,149);
    }
}
