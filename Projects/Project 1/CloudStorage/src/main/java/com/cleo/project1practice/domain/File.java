package com.cleo.project1practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyGroup;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="files")
public class File {

    @Id @GeneratedValue private Long fileId;

    private String filename;
    private String contenttype;

    private String filesize;

    @ManyToOne
    private User user;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @LazyGroup("lobs")
    private Blob filedata;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public User getUser() {
        return user;
    }

    public void setUserid(User user) {
        this.user = user;
    }

    public Blob getFiledata() {
        return filedata;
    }

    public void setFiledata(Blob filedata) {
        this.filedata = filedata;
    }
}
