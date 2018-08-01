package com.devglan.userportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody User user,HttpServletResponse resp) throws IOException{
        this.userService.create(user);
        //resp.getWriter().println("Them thanh cong");
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public void update(@PathVariable("id") int id, @RequestBody User user,HttpServletResponse resp) throws IOException{
        user.setId(id);
        userService.update(user);
        //resp.getWriter().println("Sua thanh cong");
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") int id) {
        this.userService.delete(id);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
