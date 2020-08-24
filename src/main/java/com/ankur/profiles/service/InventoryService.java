package com.ankur.profiles.service;

import com.ankur.profiles.domain.Info;
import com.ankur.profiles.domain.InventoryListAllResponse;
import com.ankur.profiles.domain.Item;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService {

    private Map<Integer, Item> db = new HashMap<>();


    public InventoryService() {
        db.put(1, new Item(1, "Laptop", 99.67f, new Info("Apple", "16' macbook pro")));
        db.put(2, new Item(2, "Phone", 100.33f, new Info("Samsung", "Android phone")));
        db.put(3, new Item(3, "Brown Lamp", 65.99f, new Info("Costco", "Teak lamp - brown color")));
        db.put(4, new Item(4, "Alladin's Lamp", 67.99f, new Info("Genie", "Magic lamp with 3 wishes")));
    }


    public ResponseEntity<?> all() {
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("author", "onlyankur@gmail.com");
        responseHeader.set("Access-Control-Expose-Headers", "*");
        return new ResponseEntity<InventoryListAllResponse>(new InventoryListAllResponse(db.values()), responseHeader, HttpStatus.OK);
    }


}
