package com.satchain.service;

import com.satchain.commons.constants.Constants;
import com.satchain.commons.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 董少飞
 * @date 2019/5/19
 */
@Service
public class TeleDataService {

    public List<String> teleDataDownload(Date startTime, Date endTime) {

        String path = Constants.TELE_DATA_BASE_PATH + startTime.getTime() + endTime.getTime();
        File file = new File(path);
        if(file.exists() && file.isDirectory() && file.list() != null) {
            return Arrays.asList(file.list());
        }
        return new ArrayList<>();
    }

    public boolean teleDataUpload(MultipartFile file) {

        File target = new File(Constants.TELE_DATA_BASE_PATH + FileUtil.getFileName(file.getOriginalFilename()));
        try {
            file.transferTo(target);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
