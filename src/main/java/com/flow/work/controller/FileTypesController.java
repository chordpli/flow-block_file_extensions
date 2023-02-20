package com.flow.work.controller;

import com.flow.work.domain.entity.FileTypes;
import com.flow.work.service.FileTypesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/type")
public class FileTypesController {

  private final FileTypesService fileTypeService;

  @PostMapping
  public void addType(@RequestParam(name = "extension") String extension) {
    fileTypeService.addNewType(extension);
  }

  @GetMapping
  @ResponseBody
  public List<FileTypes> getSavedType(){
    return fileTypeService.getSavedType();
  }

  @PostMapping("/{extension}/delete")
  public void deleteType(@PathVariable String extension){
    fileTypeService.deleteType(extension);

  }

}
