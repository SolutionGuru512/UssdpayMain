package com.bank.ussd.repositories;

import com.bank.ussd.data.UssdSession;
import org.springframework.data.repository.CrudRepository;

public interface UssdSessionRepository extends CrudRepository<UssdSession, String> {}

