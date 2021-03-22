package Util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommonUtil {
    public static Double roundNumber(double number, Integer fractionalPart) {
        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(fractionalPart, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
