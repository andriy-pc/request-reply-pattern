package com.requestreply.order.controller;

import com.requestreply.order.model.dto.OrderDTO;
import com.requestreply.order.service.DefaultOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderController {

    private final DefaultOrderService orderService;

    @GetMapping("/{originalOrderId}")
    public ResponseEntity<OrderDTO> getByOriginalOrderId(@PathVariable String originalOrderId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.getByOriginalOrderId(originalOrderId));
    }

    @PatchMapping("/ship/{originalOrderId}")
    public ResponseEntity<Boolean> shipByOriginalOrderId(@PathVariable String originalOrderId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderService.ship(originalOrderId));
    }

}
