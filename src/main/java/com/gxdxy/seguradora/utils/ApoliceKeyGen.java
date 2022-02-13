package com.gxdxy.seguradora.utils;

public class ApoliceKeyGen {
  
    public static String gerarNumeroApolice(int n)
    {
  
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        StringBuilder numeroApolice = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            int index
                = (int)(chars.length()
                        * Math.random());
  
            numeroApolice.append(chars
                          .charAt(index));
        }
  
        return numeroApolice.toString();
    }
  
}