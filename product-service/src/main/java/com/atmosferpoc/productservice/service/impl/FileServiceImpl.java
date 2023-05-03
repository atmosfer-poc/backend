package com.atmosferpoc.productservice.service.impl;

import com.atmosferpoc.entity.FileInfo;
import com.atmosferpoc.productservice.config.properties.StorageConfigurationProperties;
import com.atmosferpoc.productservice.repository.FileInfoRepository;
import com.atmosferpoc.productservice.service.FileService;
import com.atmosferpoc.shared.util.FileNameUtil;
import com.atmosferpoc.shared.util.IOHelper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final StorageConfigurationProperties storageConfigurationProperties;
    private final FileInfoRepository fileInfoRepository;

    @Override
    public FileInfo upload(MultipartFile file) {
        var generatedFileName = RandomStringUtils.randomAlphabetic(30);
        var originalFileName = file.getOriginalFilename();
        var extension = FileNameUtil.getExtension(originalFileName);

        if (StringUtils.isEmpty(extension)) {
            throw new RuntimeException("File extension must be not empty.");
        }

        var bucketName = storageConfigurationProperties.getPath().concat("/").concat(generatedFileName).concat(".").concat(extension);

        IOHelper.save(file, storageConfigurationProperties.getPath(), generatedFileName.concat(".").concat(extension));

        var fileInfo = FileInfo.of(originalFileName, bucketName, extension);
        return fileInfoRepository.save(fileInfo);
    }

    @SneakyThrows
    @Override
    public Pair<FileInfo, byte[]> getFile(Long fileInfoId) {
        Optional<FileInfo> fileInfoOpt = fileInfoRepository.findById(fileInfoId);

        if (fileInfoOpt.isEmpty()) {
            throw new RuntimeException("FileInfo not found: " + fileInfoId);
        }

        return Pair.of(fileInfoOpt.get(), IOHelper.readAsBase64(fileInfoOpt.get().getBucketName()));
    }
}
