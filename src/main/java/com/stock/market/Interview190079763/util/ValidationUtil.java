package com.stock.market.Interview190079763.util;

import org.apache.commons.validator.routines.BigDecimalValidator;

import java.math.BigDecimal;

public class ValidationUtil {

    public static boolean isBigDecimalValid(BigDecimal bigDecimal) {
        return (!BigDecimal.ZERO.equals(bigDecimal)) && BigDecimalValidator.getInstance().minValue(bigDecimal, 0) && (BigDecimalValidator.getInstance().isValid(bigDecimal.toString()));
    }
}
