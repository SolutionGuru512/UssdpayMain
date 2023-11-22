package com.bank.ussd.services;

import com.bank.ussd.data.UssdSession;
import com.bank.ussd.repositories.UssdSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
  @Autowired
  private UssdSessionRepository ussdSessionRepository;

  public UssdSession createUssdSession(UssdSession session) {
    return (UssdSession)this.ussdSessionRepository.save(session);
  }

  public UssdSession get(String id) {
    return this.ussdSessionRepository.findById(id).orElse(null);
  }

  public UssdSession update(UssdSession session) {
    if (this.ussdSessionRepository.existsById(session.getId()))
      return (UssdSession)this.ussdSessionRepository.save(session);
    throw new IllegalArgumentException("A session must have an id to be updated");
  }

  public void delete(String id) {
    this.ussdSessionRepository.deleteById(id);
  }
}