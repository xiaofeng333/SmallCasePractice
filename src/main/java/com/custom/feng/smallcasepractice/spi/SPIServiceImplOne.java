package com.custom.feng.smallcasepractice.spi;

public class SPIServiceImplOne implements SPIService {

    @Override
    public void execute() {
        System.out.println("SPIServiceImplOne executed");
    }
}
