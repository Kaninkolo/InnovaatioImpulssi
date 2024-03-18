package InnovaatioImpulssi.InnovaatiImpulssiLippu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.AppUser;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userrepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = userrepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}