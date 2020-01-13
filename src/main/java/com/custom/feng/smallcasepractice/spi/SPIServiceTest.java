package com.custom.feng.smallcasepractice.spi;

import java.util.ServiceLoader;

public class SPIServiceTest {
    public static void main(String[] args) {
        ServiceLoader<SPIService> spiServiceServiceLoader = ServiceLoader.load(SPIService.class);
        for (SPIService next : spiServiceServiceLoader) {
            next.execute();
        }
    }
}
