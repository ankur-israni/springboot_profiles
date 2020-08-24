package com.ankur.profiles.controller;




import com.ankur.profiles.domain.InventoryListAllRequest;
import com.ankur.profiles.domain.InventoryListAllResponse;
import com.ankur.profiles.domain.ServiceErrorResponse;
import com.ankur.profiles.service.InventoryService;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static java.net.HttpURLConnection.*;


@RestController
@RequestMapping("/inventory/services")
@Api(value = "/inventory/services", tags = ("Inventory Management"))
@CrossOrigin(allowedHeaders = "*",maxAge = 3600)
public class InventoryController {

    private static final String CLIENT_ID = "client-id";
    private InventoryService inventoryService;


    //From application-[profile].yaml file
    @Value("${inventory.database.username}")
    private String username;

    //From application-[profile].yaml file
    @Value("${inventory.database.password}")
    private String password;



    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @RequestMapping(value = "all", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "all", notes = "Fetch all employees", nickname = "all")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Missing / invalid parameter", response = ServiceErrorResponse.class),
            @ApiResponse(code = 200, message = "Success", response = InventoryListAllResponse.class)})
    public ResponseEntity<?> all(@RequestHeader(value = CLIENT_ID) String clientId,
                                 @Valid @RequestBody InventoryListAllRequest request) {

        System.out.println("Username injected via properties file: " + this.username);
        System.out.println("Password injectec via properties file: " + this.password);

        return inventoryService.all();
    }

}

