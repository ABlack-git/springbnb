package springbnb.app;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @GetMapping(path = "/")
    public String index() {
        return "This is public endpoint";
    }

    @GetMapping(path = "/user/info")
    public String getInfo(Principal principal) {
        return principal.getName();
    }

    @RolesAllowed(value = "host")
    @GetMapping(path = "/user/host")
    public String getHostInfo(Principal principal) {
        return principal.toString();
    }

    @RolesAllowed(value = "customer")
    @GetMapping(path = "/user/user")
    public String getUserInfo(Principal principal) {
        return principal.toString();
    }
}
