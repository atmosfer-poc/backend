package com.atmosferpoc.shared.util;

import com.atmosferpoc.core.exception.ErrorStatusCode;
import com.atmosferpoc.core.exception.GeneralException;
import com.atmosferpoc.shared.constant.ApplicationConstants;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
@UtilityClass
public class IOHelper {
    public String save(MultipartFile file, String folderPath, String fileName) {
        try {
            if (!folderPath.endsWith("/")) {
                folderPath = folderPath.concat("/");
            }
            String fileFullPath = folderPath.concat(fileName).concat(".").concat(FileHelper.getExtension(file.getOriginalFilename()));
            var folder = new File(fileFullPath);
            file.transferTo(folder);

            return fileFullPath;
        } catch (IOException e) {
            log.error(String.format(ApplicationConstants.ERROR_LOG_PATTERN, "[IOHelper]", "(save)", e.getMessage(), "Can't upload file to folder : " + folderPath));
            throw new GeneralException(ErrorStatusCode.FILE_UPLOAD_ERROR);
        }
    }

    public String readFile(String path) {
        try {
            var fis = new FileInputStream(path);
            var result= IOUtils.toString(fis, "UTF-8");
            fis.close();
            return result;
        } catch (Exception ex) {
            log.error(String.format(ApplicationConstants.ERROR_LOG_PATTERN, "[IOHelper]", "(readFile)", ex.getMessage(), "Can't read file to folder : " + path));
            throw new GeneralException(ErrorStatusCode.EULA_READ_ERROR);
        }
    }

    public String readAsBase64(String path) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(path));
        return Base64.getEncoder().encodeToString(fileContent);
    }
}
