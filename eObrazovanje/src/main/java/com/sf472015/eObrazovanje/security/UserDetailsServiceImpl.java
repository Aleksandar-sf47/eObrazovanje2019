package com.sf472015.eObrazovanje.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sf472015.eObrazovanje.model.Korisnik;
import com.sf472015.eObrazovanje.repo.KorisnikRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	KorisnikRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Korisnik user = userRepository.getByKorisnickoIme(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

		return UserPrinciple.build(user);
	}
}