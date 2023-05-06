package com.atmosferpoc.applicationservice.controller;

import com.atmosferpoc.applicationservice.service.ApplicationService;
import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.core.model.type.RoleType;
import com.atmosferpoc.core.util.SecurityUtil;
import com.atmosferpoc.shared.endpoints.ApplicationEndpoints;
import com.atmosferpoc.shared.model.dto.CommentDto;
import com.atmosferpoc.shared.model.type.ApplicationAction;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@RequestMapping(ApplicationEndpoints.APPLICATIONS)
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping(ApplicationEndpoints.CV)
    public ResponseEntity<Resource> downloadCv(@PathVariable Long id) {
        if (!Arrays.asList(RoleType.TECHNICAL, RoleType.HR, RoleType.FINANCE).contains(SecurityUtil.getRole())) {
            throw new GeneralException(ErrorStatusCode.UNEXPECTED_EXCEPTION, "Unauthorize !");
        }

        var resourceDTO = applicationService.getCV(id);

        var httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition",
                "attachment; filename=" + resourceDTO.getName());

        return ResponseEntity.ok()
                .contentType(resourceDTO.getMediaType())
                .headers(httpHeaders)
                .body(resourceDTO.getResource());
    }

    @PostMapping(ApplicationEndpoints.ACTION)
    public void action(@PathVariable Long id,
                       @PathVariable ApplicationAction action,
                       @RequestBody @Valid CommentDto commentDto) {
        applicationService.action(id, action, commentDto);
    }
}
