package com.hpstudio.forummain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

/**
 * @author mawen
 * @date 2020/9/17 9:12
 * @email 455766076@qq.com
 * @description 公告实体
 */
@Data
public class Notice {

    //公告id
    @Id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //公告标题
    private String title;
    //公告正文
    private String text;
    //公告日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Timestamp addDate;
    //是否删除
    private Integer isDel;
}
