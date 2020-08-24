package com.ankur.profiles.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InventoryListAllRequest {

    @Valid
    @NotNull(message="Username is required")
    private String username;

    @Valid
    @NotNull(message="Password is required")
    private String password;

    public InventoryListAllRequest(String username, String password){
        this.username=username;
        this.password=password;
    }

    public InventoryListAllRequest(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}
