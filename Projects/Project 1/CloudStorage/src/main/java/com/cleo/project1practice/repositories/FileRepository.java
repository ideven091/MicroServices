package com.cleo.project1practice.repositories;

import com.cleo.project1practice.domain.File;
import com.cleo.project1practice.domain.User;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {

    public List<File> getAllByUser(User user);


    void store(MultipartFile file);




    Resource loadAsResource(String filename);

    void deleteAll();
}
