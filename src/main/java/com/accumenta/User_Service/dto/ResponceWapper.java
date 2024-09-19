package com.accumenta.User_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceWapper <T>{
    private T object;
    private String message;
    public ResponceWapper(T object){
        super();
        this.object = object;
    }
    public ResponceWapper(String message){
        super();
        this.message = message;
    }
}
