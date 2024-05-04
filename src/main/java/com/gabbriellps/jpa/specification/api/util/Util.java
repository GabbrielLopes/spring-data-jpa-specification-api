package com.gabbriellps.jpa.specification.api.util;

public abstract class Util {

    public static String formataCnpj(Integer raizCnpj, String sufixoCnpj, Integer digitoCnpj){

        String raizStr = String.format("%08d", raizCnpj);


        return String.format("%s.%s.%s-%s", raizStr, sufixoCnpj, digitoCnpj, digitoCnpj);
    }

}
