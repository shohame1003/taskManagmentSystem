package com.example.taskmanagementsystem.sms;

import com.example.taskmanagementsystem.sms.dto.SmsCodeSendDto;
import com.example.taskmanagementsystem.sms.dto.SmsCodeVerifyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "sms-code" )
@RequiredArgsConstructor
public class SmsCodeController
{
    private final SmsCodeService service;

    @PostMapping( "/send" )
    public void send( @RequestBody SmsCodeSendDto smsCodeSendDto )
    {
        service.sendSms( smsCodeSendDto );
    }

    @PostMapping( "/verify" )
    public void just( @RequestBody SmsCodeVerifyDto verifyDto )
    {
        service.verifyCode( verifyDto );
    }
}
