package com.ayseozcan.controller;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Yarisma;
import com.ayseozcan.service.YarismaService;

import java.util.List;

public class YarismaController {

    private YarismaService yarismaService;
    public YarismaController(){
        this.yarismaService = new YarismaService();
    }


}
