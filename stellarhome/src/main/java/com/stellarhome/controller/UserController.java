package com.stellarhome.controller;

import com.stellarhome.endPoints.IUserEndPoint;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.PushBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IUserEndPoint.USER_BASE_URL)
@Tag(name = "Stellar Home", description = "Points for managing products")
public class UserController {



}
