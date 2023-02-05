package com.getir.readingisgood.utilities.business;

import com.getir.readingisgood.utilities.results.Result;
import lombok.var;

public class BusinessRules {

    public static Result run(Result... logics) {
        for (var logic : logics) {
            if (!logic.isSuccess()) {
                return logic;
            }
        }
        return null;
    }

}