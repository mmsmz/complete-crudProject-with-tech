package com.homeservice.homeservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "imagelocation")
public class ImgLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "imgid")
    private Integer imgId;

    // DB >> Columns name can go with namingConvention like this : "img_Path"  & here it remains the "imgPath"
    @Column(name = "imgPath")
    private String imgPath;


    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
