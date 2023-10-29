package com.ada.order.utils;

public class Validator {

    public static Boolean passwordValidate(String password){
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*\\W).{8,}$");
    }

    public static Boolean cpfValidate(String cpf){
        return cpf.matches("[0-9]{11}");
    }
}
