package com.flow.work.controller;

import com.flow.work.service.ForbiddenTypesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forbidden")
@RequiredArgsConstructor
@Slf4j
public class ForbiddenTypesController {

  private final ForbiddenTypesService forbiddenTypesService;

  @PostMapping
  public String add(@RequestParam(name = "typeName") String typeName) {
    forbiddenTypesService.addType(typeName.trim());
    return "redirect:/";
  }

  @PostMapping("/delete/{forbiddenTypeName}")
  public String delete(@PathVariable String forbiddenTypeName) {
    log.info("forbiddenTypeName = {}", forbiddenTypeName);
    forbiddenTypesService.deleteForbiddenType(forbiddenTypeName);
    return "redirect:/";
  }
}
