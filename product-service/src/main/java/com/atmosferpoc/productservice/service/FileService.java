package com.atmosferpoc.productservice.service;

import com.atmosferpoc.entity.FileInfo;
import org.springframework.data.util.Pair;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileInfo upload(MultipartFile file);

    Pair<FileInfo, byte[]> getFile(Long fileInfoId);
}
