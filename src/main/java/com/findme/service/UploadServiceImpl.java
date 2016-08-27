package com.findme.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.findme.exception.BusinessException;
import com.findme.utils.WebUtils;

@Component
public class UploadServiceImpl implements UploadService {
	private String fileLocation;
	private String downloadApi;

	@Autowired
    private Environment env;

	private Logger LOG = Logger.getLogger(UploadServiceImpl.class);

	@PostConstruct
    public void inti() {
		fileLocation = env.getProperty("resources.location");
		downloadApi = String.format("/%s/images/",env.getProperty("project.name"));
    }

	/**
	 * This method use to write a file to server
	 *
	 *
	 * @param request
	 * @param file
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public String writeFile(HttpServletRequest request, MultipartFile file) throws BusinessException {
		String fileName = null;
        if (!file.isEmpty()) {
            // Creating the directory to store file
            File dir = new File(fileLocation);

            // Create the file on server
            // File name is md5 encrypted of originalFilename +
            // currentTimeMillis
            fileName = WebUtils.md5(file.getOriginalFilename() + System.currentTimeMillis()) + "."
                    + FilenameUtils.getExtension(file.getOriginalFilename());

            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            if (serverFile.exists()) {
                throw new BusinessException("Fail to upload the file. Try again later.");
            }

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                byte[] bytes = file.getBytes();
                // Write stream to file
                IOUtils.write(bytes, stream);
                LOG.info("====== File is uploaded to : " + serverFile.getAbsolutePath());

                // Prepare response result
                return WebUtils.getServerUrl(request).toString() + downloadApi + fileName;
            } catch (Exception e) {
            	LOG.error(e);
                throw new BusinessException("Fail to upload the file. Try again later.");
            }
        } else {
            throw new BusinessException("File is empty.");
        }
	}

	@Override
	public String writeFile(HttpServletRequest request, String fileName, byte[] fileAsBytes) throws BusinessException {
		String newFileName = null;
        if (fileAsBytes.length > 0) {
            // Creating the directory to store file
            File dir = new File(fileLocation);

            // Create the file on server
            // File name is md5 encrypted of originalFilename +
            // currentTimeMillis
            newFileName = WebUtils.md5(fileName + System.currentTimeMillis()) + "."
                    + FilenameUtils.getExtension(fileName);

            File serverFile = new File(dir.getAbsolutePath() + File.separator + newFileName);
            if (serverFile.exists()) {
                throw new BusinessException("Fail to upload the file. Try again later.");
            }

            try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                // Write stream to file
                IOUtils.write(fileAsBytes, stream);
                LOG.info("====== File is uploaded to : " + serverFile.getAbsolutePath());

                // Prepare response result
				return WebUtils.getServerUrl(request).toString() + downloadApi + newFileName;
            } catch (Exception e) {
            	LOG.error(e);
                throw new BusinessException("Fail to upload the file. Try again later.");
            }
        } else {
            throw new BusinessException("File is empty.");
        }
	}

}
