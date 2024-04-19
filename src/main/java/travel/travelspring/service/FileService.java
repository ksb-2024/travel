package travel.travelspring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	 // 저장할 폴더 경로 설정
	@Value("${spring.servlet.multipart.location}")
    private String uploadFolder;

    public String saveFile(MultipartFile file, String foldername) throws IOException {
        if (!file.isEmpty()) {
            try {
                // 중복되지 않는 파일 이름 생성
                String fileName = generateUniqueFileName(file.getOriginalFilename());

                // 저장할 폴더 경로에 파일을 저장
                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadFolder + foldername + "/" + fileName);
                Files.write(path, bytes);

                return fileName;
            } catch (IOException e) {
                throw new IOException("Failed to store file " + file.getOriginalFilename(), e);
            }
        }
        return null;
    }

    private String generateUniqueFileName(String originalFileName) {
        // 파일 이름에 UUID를 추가하여 중복을 피함
        String uuid = UUID.randomUUID().toString();
        return uuid + "_" + originalFileName;
    }
}
