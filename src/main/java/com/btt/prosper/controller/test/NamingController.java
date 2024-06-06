package com.btt.prosper.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/naming")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Slf4j
public class NamingController {
}
