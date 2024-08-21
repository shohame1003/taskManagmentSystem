package com.example.taskmanagementsystem.sms;

import com.example.taskmanagementsystem.sms.entity.SmsCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsCodeRepository extends CrudRepository<SmsCode, String>
{
}
