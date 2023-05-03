package com.atmosferpoc.entity;

import com.atmosferpoc.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class FileInfo extends BaseEntity {
    private String name;

    private String bucketName;

    private String extension;

    public static FileInfo of(String name, String bucketName, String extension) {
        var fileInfo = new FileInfo();
        fileInfo.setBucketName(bucketName);
        fileInfo.setName(name);
        fileInfo.setExtension(extension);
        return fileInfo;
    }

    @Override
    public <T extends BaseEntity> void update(T entity) {
    }
}
