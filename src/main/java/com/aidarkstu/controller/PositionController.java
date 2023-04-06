package com.aidarkstu.controller;

import com.aidarkstu.service.serviceimpl.PositionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/position")
public class PositionController {
    private final PositionServiceImpl positionService;



}
