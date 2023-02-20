package com.flow.work.controller;

import com.flow.work.domain.dto.FileUploadRequest;
import com.flow.work.domain.entity.FileTypes;
import com.flow.work.domain.entity.ForbiddenTypes;
import com.flow.work.service.FilesService;
import com.flow.work.service.FileTypesService;
import com.flow.work.service.ForbiddenTypesService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class FilesController {

  private final FilesService fileService;
  private final FileTypesService fileTypeService;
  private final ForbiddenTypesService forbiddenTypesService;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("request", new FileUploadRequest());

    List<ForbiddenTypes> forbiddenTypes = forbiddenTypesService.getAllInfo();
    Long countForbiddenTypes = forbiddenTypesService.countAllInfo();
    model.addAttribute("forbiddenTypes", forbiddenTypes);
    model.addAttribute("countForbidden", countForbiddenTypes);

    return "index";
  }

  @PostMapping
  public String upload(@ModelAttribute("request") final FileUploadRequest request)
      throws IOException {
    log.info("request = {}", request.getFile());
    log.info("forbidden = {}", Arrays.toString(request.getForbidden()));
    fileService.uploadFile(request);
    return "redirect:/";
  }

}
